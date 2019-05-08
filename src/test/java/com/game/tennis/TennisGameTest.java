package com.game.tennis;

import org.junit.Before;
import org.junit.Test;

import static com.game.tennis.constants.Score.*;
import static org.junit.Assert.assertEquals;

public class TennisGameTest {

    private TennisGame game;

    @Before
    public void initialise() {
        game = new TennisGame();
    }

    @Test
    public void shouldReturnLoveAllWhenInputScoreIsAt0_0() {
        assertEquals("love-all", game.scoreBoard(love, love));
    }

    @Test
    public void shouldReturnLoveFifteenWhenInputScoreIsAt0_15() {
        assertEquals("love-fifteen", game.scoreBoard(love, fifteen));
    }

    @Test
    public void shouldReturnFifteenThirtyWhenInputScoreIsAt15_30() {
        assertEquals("fifteen-thirty", game.scoreBoard(fifteen, thirty));
    }

    @Test
    public void shouldReturnFortyFifteenWhenInputScoreIsAt40_15() {
        assertEquals("forty-fifteen", game.scoreBoard(forty, fifteen));
    }

    @Test
    public void shouldReturnFifteenAllWhenInputScoreIsAt15_15() {
        assertEquals("fifteen-all", game.scoreBoard(fifteen, fifteen));
    }

    @Test
    public void shouldReturnDeuceWhenInputScoreIsAt40_40() {
        assertEquals("deuce", game.scoreBoard(forty, forty));
    }


}