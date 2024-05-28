package org.leanpoker.player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class HandEvaluator {

  public static boolean hasTwoPairOrBetter(BetRequest betRequest) {
    List<Card> list = new ArrayList<>();
    list.addAll(betRequest.getHoleCards());
    list.addAll(betRequest.communityCards());
    var rankCount = list.stream()
        .map(Card::rank)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    var pairCount = 0;
    for(var entry : rankCount.entrySet()) {
      if(entry.getValue() == 2) {
        pairCount++;
      }
    }
    return pairCount >= 2;
  }
}
