package org.leanpoker.player;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.junit.jupiter.api.Test;

class APlayer {

  @Test
  void all_in_right_now() throws JsonProcessingException {
    JsonNode jsonNode = Player.OBJECT_MAPPER.readTree(example);

    assertEquals(1000, Player.betRequest(jsonNode));
  }


  String example = """
      {
        "tournament_id": "66559491eb1286000231be58",
        "game_id": "6655a77208adbe0002a9d374",
        "round": 4,
        "players": [
          {
            "name": "Rusty Ladies",
            "stack": 984,
            "status": "active",
            "bet": 4,
            "time_used": 1139935,
            "version": "0.1",
            "id": 0
          },
          {
            "name": "Peanuts",
            "stack": 0,
            "status": "out",
            "bet": 0,
            "time_used": 286224,
            "version": "0.0.6 - logging",
            "id": 1
          },
          {
            "name": "Poker Prestidigitators",
            "stack": 2010,
            "status": "active",
            "bet": 2,
            "hole_cards": [
              {
                "rank": "2",
                "suit": "diamonds"
              },
              {
                "rank": "5",
                "suit": "hearts"
              }
            ],
            "time_used": 569937,
            "version": "1.3",
            "id": 2
          }
        ],
        "small_blind": 2,
        "big_blind": 4,
        "orbits": 1,
        "dealer": 0,
        "community_cards": [],
        "current_buy_in": 4,
        "pot": 6,
        "in_action": 2,
        "minimum_raise": 2,
        "bet_index": 3
      }""";
}
