package org.leanpoker.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

record PokerPlayer(int bet,
                   int stack,
                   @JsonProperty("hole_cards") List<Card> holeCards) {

}
