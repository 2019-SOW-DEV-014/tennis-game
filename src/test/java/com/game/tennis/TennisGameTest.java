package com.game.tennis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TennisGameTest {

    @Test
    public void shouldReturnLoveAllWhenInputScoreIsAt0_0() {
        TennisGame game = new TennisGame();
        assertEquals("love-all", game.scoreBoard(0, 0));

    }

}