package org.leanpoker.player;

import static org.slf4j.LoggerFactory.getLogger;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;

public class Player {

    private static final Logger log = getLogger(Player.class);

    static final String VERSION = "1.2";

    public static int betRequest(JsonNode request) {
        log.info(request.asText());
        return 1000;
    }

    public static void showdown(JsonNode game) {
    }
}
