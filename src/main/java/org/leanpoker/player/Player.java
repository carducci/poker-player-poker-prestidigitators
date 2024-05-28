package org.leanpoker.player;

import static org.slf4j.LoggerFactory.getLogger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;

public class Player {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private static final Logger log = getLogger(Player.class);

    static final String VERSION = "1.6";

    public static int betRequest(JsonNode request) {
        try {
            // log.info(request.toString());
            JsonNode jsonNode = OBJECT_MAPPER.readTree(request.toString());
            BetRequest betRequest = OBJECT_MAPPER.treeToValue(jsonNode, BetRequest.class);

            log.info("betRequest: {}", betRequest);
            return 1000;
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
