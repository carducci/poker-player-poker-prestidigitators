package org.leanpoker.player;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class APlayer {


  @Test
  void should_return_0() {
    // create a empty JsonNode
    // call Player.betRequest() and assert that it returns 0
    assertEquals(0, Player.betRequest(JsonNodeFactory.instance.objectNode()));
  }
}
