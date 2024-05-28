package org.leanpoker.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

record BetRequest(List<PokerPlayer> players,
                  @JsonProperty("small_blind") int smallBlind,
                  @JsonProperty("big_blind") int bigBlind,
                  @JsonProperty("current_buy_in") int currentBuyIn,
                  @JsonProperty("pot") int pot,
                  @JsonProperty("minimum_raise") int minimumRaise,
                  @JsonProperty("in_action") int inAction) {


}
