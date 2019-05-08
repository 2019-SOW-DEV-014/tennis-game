package com.game.tennis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisGameTest {

    private TennisGame game;

    @Before
    public void initialise() {
        game = new TennisGame();
    }

    @Test
    public void shouldReturnLoveAllWhenInputScoreIsAt0_0() {
        assertEquals("love-all", game.scoreBoard(0, 0));
    }

    @Test
    public void shouldReturnLoveFifteenWhenInputScoreIsAt0_15() {
        assertEquals("love-fifteen", game.scoreBoard(0, 15));
    }


}