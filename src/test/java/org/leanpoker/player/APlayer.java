package org.leanpoker.player;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.junit.jupiter.api.Test;

class APlayer {

  @Test
  void all_in_right_now() {
    // create a empty JsonNode
    // call Player.betRequest() and assert that it returns 0
    assertEquals(1000, Player.betRequest(JsonNodeFactory.instance.objectNode()));
  }
}
