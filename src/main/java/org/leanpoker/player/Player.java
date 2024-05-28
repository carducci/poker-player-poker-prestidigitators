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

    static final String VERSION = "1.4";

    public static int betRequest(JsonNode request) {
        log.info(request.toString());
        return 1000;
    }

    public static void showdown(JsonNode game) {
    }
}
