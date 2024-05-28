package org.leanpoker.player;

import static org.slf4j.LoggerFactory.getLogger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.slf4j.Logger;

public class Player {

  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

  private static final Logger log = getLogger(Player.class);

  static final String VERSION = "3.5";

  private static Map<String, Boolean> bluffs = new HashMap<>();
  public static Random random = new Random();

  public static boolean shouldWeBluff(){
    int i = random.nextInt(5);
    return i <= 2;
  }

  private static boolean shouldWeCall(int probability) {
    int i = random.nextInt(10);
    return i < probability;
  }

  public static int betRequest(JsonNode request) {
    try {
      log.info("betRequest: {}", request);
      JsonNode jsonNode = OBJECT_MAPPER.readTree(request.toString());
      BetRequest betRequest = OBJECT_MAPPER.treeToValue(jsonNode, BetRequest.class);

      if (betRequest.isPostFlop()) {
        if (betRequest.currentBuyIn() > betRequest.bigBlind() &&
            minRaise(betRequest) > betRequest.bigBlind()) {
          if (random.nextInt(2) == 0) {
            return betRequest.currentBuyIn() - betRequest.players().get(betRequest.inAction()).bet();
          }
        }
        if (HandEvaluator.hasTwoPairOrBetter(betRequest)) {
          return betRequest.pot();
        }
        if (random.nextInt(4) == 0) {
          return betRequest.pot();
        }
        return betRequest.pot() / 4;
      }

      var card1 = betRequest.getHoleCards().get(0);
      var card2 = betRequest.getHoleCards().get(1);
      var startingHand = new StartingHand(card1, card2);

      StartingSolver solver = new StartingSolver(startingHand, 1);

      log.info("betRequest: {}", betRequest);
      var gutFeeling = solver.GetAction();

      return switch (gutFeeling) {
        case SUPERCONFIDENT -> superConfidentRaise(betRequest);
        case STRONG -> confidentRaise(betRequest);
        case MEDIUM -> mediumConfidentButBluffing(betRequest);
        case WEAK -> lessConfidentButBluffing(betRequest);
      };

    } catch (Exception e) {
      log.error("Error", e);
      return 0;
    }
  }

  private static int superConfidentRaise(BetRequest betRequest) {
    int i = random.nextInt(10);
    if (i < 7) {
      return betRequest.pot() * 2;
    }
    //return all in
    return allIn(betRequest);
  }

  private static int allIn(BetRequest betRequest) {
    return betRequest.players().get(betRequest.inAction()).stack();
  }
  private static int call(BetRequest betRequest){
    return betRequest.currentBuyIn() - betRequest.players().get(betRequest.inAction()).bet();
  }
  private static int confidentRaise(BetRequest betRequest) {
    if(shouldWeCall(3)) {
        return call(betRequest);
    }
    return betRequest.pot() * 3 / 4;
  }

  private static int minRaise(BetRequest betRequest) {
    return betRequest.currentBuyIn() - betRequest.players().get(betRequest.inAction()).bet()
           + betRequest.minimumRaise();
  }

  private static int mediumConfidentButBluffing(BetRequest betRequest) {
    if (bluffs.containsKey(betRequest.gameId())) {
      if (doWeHaveToCallAnAllIn(betRequest) && !shouldWeCall(2)) {
        return 0;
      }
      else if(doWeHaveToCallAnAllIn(betRequest)) {
        return call(betRequest);
      }

      return betRequest.pot() / 2;
    }
    if (shouldWeBluff()) {
      bluffs.put(betRequest.gameId(), true);
      log.info(">>> we bluff, game id: {}", betRequest.gameId());
      return confidentRaise(betRequest);
    }
    // check call
    return call(betRequest);
  }

  private static boolean doWeHaveToCallAnAllIn(BetRequest betRequest) {
    return betRequest.players().get(betRequest.inAction()).stack() == 0;
  }

  private static int lessConfidentButBluffing(BetRequest betRequest) {
    if (bluffs.containsKey(betRequest.gameId()) && shouldWeCall(5)) {
      if(doWeHaveToCallAnAllIn(betRequest))
        return 0;

      return betRequest.pot() / 2;
    }
    if (shouldWeBluff() && !doWeHaveToCallAnAllIn(betRequest)) {
      bluffs.put(betRequest.gameId(), true);
      log.info(">>> we bluff, game id: {}", betRequest.gameId());
      return confidentRaise(betRequest);
    }
    return 0;
  }

  public static void showdown(JsonNode game) {
  }
}
