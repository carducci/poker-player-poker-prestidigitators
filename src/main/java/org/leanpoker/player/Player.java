package org.leanpoker.player;

import static org.slf4j.LoggerFactory.getLogger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Random;
import org.slf4j.Logger;

public class Player {

  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

  private static final Logger log = getLogger(Player.class);

  static final String VERSION = "2.2";

  public static int betRequest(JsonNode request) {
    try {
      // log.info(request.toString());
      JsonNode jsonNode = OBJECT_MAPPER.readTree(request.toString());
      BetRequest betRequest = OBJECT_MAPPER.treeToValue(jsonNode, BetRequest.class);

      var card1 = BetRequest.getHoleCards(betRequest).get(0);
      var card2 = BetRequest.getHoleCards(betRequest).get(1);
      var startingHand = new StartingHand(card1, card2);

      StartingSolver solver = new StartingSolver(startingHand, 1);

      log.info("betRequest: {}", betRequest);
      var gutFeeling = solver.GetAction();

      return switch (gutFeeling) {
        case STRONG -> confidentRaise(betRequest);
        case MEDIUM -> mediumConfidentButBluffing(betRequest);
        case WEAK -> lessConfidentButBluffing(betRequest);
      };

    } catch (Exception e) {
      log.error("Error", e);
      log.error("Error", e);
      log.error("Error", e);
      return 0;
    }
  }

  private static int lessConfidentButBluffing(BetRequest betRequest) {
    Random random = new Random();
    int i = random.nextInt(10);
    if (i <= 3) {
      return confidentRaise(betRequest);
    }
    return 0;
  }

  private static int mediumConfidentButBluffing(BetRequest betRequest) {
    Random random = new Random();
    int i = random.nextInt(10);
    if (i <= 3) {
      return confidentRaise(betRequest);
    }
    // check call
    return betRequest.currentBuyIn() - betRequest.players().get(betRequest.inAction()).bet();
  }

  private static int confidentRaise(BetRequest betRequest) {
    Random random = new Random();
    int i = random.nextInt(10);
    if (i <= 3) {
      return (betRequest.currentBuyIn() - betRequest.players().get(betRequest.inAction()).bet()
              + betRequest.minimumRaise()) * 5;
    } else if (i < 9) {
      return (betRequest.currentBuyIn() - betRequest.players().get(betRequest.inAction()).bet()
              + betRequest.minimumRaise()) * 4;
    } else {
      // go all in
      return betRequest.players().get(betRequest.inAction()).stack();
    }
  }

  public static void showdown(JsonNode game) {
  }
}
