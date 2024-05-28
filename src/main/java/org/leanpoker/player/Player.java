package org.leanpoker.player;

import static org.slf4j.LoggerFactory.getLogger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.slf4j.Logger;

public class Player {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private static final Logger log = getLogger(Player.class);

    static final String VERSION = "1.8";

    public static int betRequest(JsonNode request) {
        try {
            // log.info(request.toString());
            JsonNode jsonNode = OBJECT_MAPPER.readTree(request.toString());
            BetRequest betRequest = OBJECT_MAPPER.treeToValue(jsonNode, BetRequest.class);

            var card1 = betRequest.players().get(betRequest.inAction()).holeCards().get(0);
            var card2 = betRequest.players().get(betRequest.inAction()).holeCards().get(1);
            var startingHand = new StartingHand(card1, card2);

            StartingSolver solver = new StartingSolver(startingHand, 1);

            log.info("betRequest: {}", betRequest);
            return solver.GetAction();
        } catch (Exception e) {
            log.error("Error", e);
            log.error("Error", e);
            log.error("Error", e);
            return 0;
        }
    }

    public static void showdown(JsonNode game) {
    }
}
