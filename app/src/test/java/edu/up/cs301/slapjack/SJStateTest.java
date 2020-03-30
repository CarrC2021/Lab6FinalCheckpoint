package edu.up.cs301.slapjack;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import edu.up.cs301.card.Card;

import static org.junit.Assert.*;

public class SJStateTest {

    private Deck Deck;
    private Card card;


    @Test
    public void getDeck() {
        SJState state = new SJState();
        SJState state2 = state;
        assertEquals(state.getDeck(0), state.getDeck(0));
        assertEquals(state.getDeck(1), state.getDeck(1));
        assertEquals(state.getDeck(2), state.getDeck(2));

        assertNotEquals(state.getDeck(1), state.getDeck(0));
        assertNotEquals(state.getDeck(1), state.getDeck(2));

        state.getDeck(0).shuffle();
        state2.getDeck(0).shuffle();
        assertEquals(state.getDeck(0), state.getDeck(0));

    }

    @Test
    public void toPlay() {
        SJState state = new SJState();
        state.setToPlay(1);
        assertEquals(1, state.toPlay());
        state.setToPlay(0);
        assertEquals(0, state.toPlay());
        state.setToPlay(-1);
        assertEquals(-1, state.toPlay());
        state.setToPlay(32);
        assertEquals(32, state.toPlay());
    }

    @Test
    public void setToPlay() {
        SJState state = new SJState();
        state.setToPlay(1);
        assertEquals(1, state.toPlay());
        state.setToPlay(0);
        assertEquals(0, state.toPlay());
        state.setToPlay(-1);
        assertEquals(-1, state.toPlay());
        state.setToPlay(32);
        assertEquals(32, state.toPlay());
    }

    @Test
    public void nullAllButTopOf2() {
        SJState state = new SJState();
        state.nullAllButTopOf2();
        assertEquals(null, state.getDeck(1).peekAtTopCard());
        assertEquals(null, state.getDeck(0).peekAtTopCard());
        assertNotEquals(null, state.getDeck(2));
    }
}