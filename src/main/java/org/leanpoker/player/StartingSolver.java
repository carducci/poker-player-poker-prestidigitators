package org.leanpoker.player;

public class StartingSolver {
    private StartingHand cards;
    private int position;

    public StartingSolver(StartingHand cards, int position) {
        this.cards = cards;
        this.position = position;
    }

    public int GetAction(){
        if(IsPair() && this.cards.card1.rank()=="A"){
            return 1000;
        }
        return 0;
    }

    public boolean IsPair(){
        if(this.cards.card1.rank()==this.cards.card2.rank())
        {
            return true;
        }
        return false;
    }
}
