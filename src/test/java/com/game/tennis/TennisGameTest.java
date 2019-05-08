package com.game.tennis;

import com.game.tennis.model.input.GameRequest;
import org.junit.Before;
import org.junit.Test;

import static com.game.tennis.constants.Score.*;
import static org.junit.Assert.assertEquals;

public class TennisGameTest {

    private TennisGame game;
    private GameRequest gameRequest;
    @Before
    public void initialise() {
        game = new TennisGame();
        gameRequest = new GameRequest();
    }

    @Test
    public void shouldReturnLoveAllWhenInputScoreIsAt0_0() {
        gameRequest.setScorePair(love, love);

        assertEquals("love-all", game.scoreBoard(gameRequest));
    }

    @Test
    public void shouldReturnLoveFifteenWhenInputScoreIsAt0_15() {
        gameRequest.setScorePair(love, fifteen);

        assertEquals("love-fifteen", game.scoreBoard(gameRequest));
    }

    @Test
    public void shouldReturnFifteenThirtyWhenInputScoreIsAt15_30() {
        gameRequest.setScorePair(fifteen, thirty);

        assertEquals("fifteen-thirty", game.scoreBoard(gameRequest));
    }

    @Test
    public void shouldReturnFortyFifteenWhenInputScoreIsAt40_15() {
        gameRequest.setScorePair(forty, fifteen);

        assertEquals("forty-fifteen", game.scoreBoard(gameRequest));
    }

    @Test
    public void shouldReturnFifteenAllWhenInputScoreIsAt15_15() {
        gameRequest.setScorePair(fifteen, fifteen);

        assertEquals("fifteen-all", game.scoreBoard(gameRequest));
    }

    @Test
    public void shouldReturnDeuceWhenInputScoreIsAt40_40() {
        gameRequest.setScorePair(forty, forty);

        assertEquals("deuce", game.scoreBoard(gameRequest));
    }


}