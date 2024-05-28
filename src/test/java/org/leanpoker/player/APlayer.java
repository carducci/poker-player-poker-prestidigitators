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
    // create a empty JsonNode
    // call Player.betRequest() and assert that it returns 0
    ObjectMapper objectMapper = Player.OBJECT_MAPPER;
    JsonNode jsonNode = objectMapper.readTree(example);
    BetRequest betRequest = objectMapper.treeToValue(jsonNode, BetRequest.class);
    assertEquals(1000, Player.betRequest(JsonNodeFactory.instance.objectNode()));
  }


  String example = """
      {
        "tournament_id":"550d1d68cd7bd10003000003",
            
        "game_id":"550da1cb2d909006e90004b1",
            
        "round":0,
            
        "bet_index":0,
            
        "small_blind": 10,
            
        "current_buy_in": 320,
            
        "pot": 400,
            
        "minimum_raise": 240,
            
        "dealer": 1,
            
        "orbits": 7,
            
        "in_action": 1,
            
        "players": [
          {
            "id": 0,
            
            "name": "Albert",
            
            "status": "active",
            
            "version": "Default random player",
            
            "stack": 1010,
            
            "bet": 320
          },
          {
            "id": 1,
            "name": "Bob",
            "status": "active",
            "version": "Default random player",
            "stack": 1590,
            "bet": 80,
            "hole_cards": [
              {
                "rank": "6",
                "suit": "hearts"
              },
              {
                "rank": "K",
                "suit": "spades"
              }
            ]
          },
          {
            "id": 2,
            "name": "Chuck",
            "status": "out",
            "version": "Default random player",
            "stack": 0,
            "bet": 0
          }
        ],
        "community_cards": [
          {
            "rank": "4",
            "suit": "spades"
          },
          {
            "rank": "A",
            "suit": "hearts"
          },
          {
            "rank": "6",
            "suit": "clubs"
          }
        ]
      }""";
}
