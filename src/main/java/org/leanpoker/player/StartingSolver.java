package org.leanpoker.player;

/* Chen Formula:
Score your highest card only. Do not add any points for your lower card.
A = 10 points.
K = 8 points.
Q = 7 points.
J = 6 points.
10 to 2 = 1/2 of card value. (e.g. a 6 would be worth 3 points)
Multiply pairs by 2 of one card’s value. However, minimum score for a pair is 5.
(e.g. KK = 16 points, 77 = 7 points, 22 = 5 points)
Add 2 points if cards are suited.
Subtract points if there is a gap between the two cards.
No gap = -0 points.
1 card gap = -1 points.
2 card gap = -2 points.
3 card gap = -4 points.
4 card gap or more = -5 points. (Aces are high this step, so hands like A2, A3 etc. have a 4+ gap.)
Add 1 point if there is a 0 or 1 card gap and both cards are lower than a Q. (e.g. JT, 75, 32 etc, this bonus point does not apply to pocket pairs)
Round half point scores up. (e.g. 7.5 rounds up to 8)
 */
public class StartingSolver {

  private StartingHand cards;
  private int position;

  public int calculateChenScore() {
    int score = 0;
    if (cards.card1.rank().equals("A")) {
      score += 10;
    } else if (cards.card1.rank().equals("K")) {
      score += 8;
    } else if (cards.card1.rank().equals("Q")) {
      score += 7;
    } else if (cards.card1.rank().equals("J")) {
      score += 6;
    } else {
      score += Integer.parseInt(cards.card1.rank()) / 2;
    }

    if (cards.card1.rank().equals(cards.card2.rank())) {
      score *= 2;
      if (score < 6) {
        return 0;
      }
    }
    return score;
  }

  public StartingSolver(StartingHand cards, int position) {
    this.cards = cards;
    this.position = position;
  }

  public GutFeeling GetAction() {
    var score = calculateChenScore();
    if (score > 14) {
      return GutFeeling.SUPERCONFIDENT;
    }
    if (score > 10) {
      return GutFeeling.STRONG;
    } else if (score > 6) {
      return GutFeeling.MEDIUM;
    }
    return GutFeeling.WEAK;
  }

  public boolean IsPair() {
    if (this.cards.card1.rank() == this.cards.card2.rank()) {
      return true;
    }
    return false;
  }

  public boolean IsSuited() {
    return this.cards.card1.suit().equals(this.cards.card2.suit());
  }


}
