package org.leanpoker.player;

import com.fasterxml.jackson.annotation.JsonProperty;

record PokerPlayer(int bet, int stack, @JsonProperty("hole_cards") Card[] holeCards) {

}
