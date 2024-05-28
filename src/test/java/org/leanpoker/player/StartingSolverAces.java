package org.leanpoker.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StartingSolverTest {


    @Test
    void Aces() {
        Card card1 = new Card("A", "H");
        Card card2 = new Card("A", "S");
        StartingHand startingHand = new StartingHand(card1, card2);
        StartingSolver solver = new StartingSolver(startingHand, 1);
        int action = solver.GetAction();
        assertNotEquals(0, action);
    }



}