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

    var tripleCount = 0;
    var pairCount = 0;
    for (var entry : rankCount.entrySet()) {
      if (entry.getValue() == 2) {
        pairCount++;
      }
      if (entry.getValue() == 3) {
        tripleCount++;
      }
    }


    var suitCount = list.stream()
        .map(Card::suit)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return pairCount >= 2 || tripleCount >= 1 || suitCount.values().stream()
        .anyMatch(count -> count >= 5);
  }
}
