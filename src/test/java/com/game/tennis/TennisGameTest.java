package com.game.tennis;

import com.game.tennis.model.input.GameRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.game.tennis.constants.Score.*;
import static com.game.tennis.util.Pair.asPair;
import static org.junit.Assert.assertEquals;

public class TennisGameTest {

    private TennisGame game;
    private GameRequest gameRequest;
    private List<String> scoreBoard;
    @Before
    public void initialise() {
        game = new TennisGame();
        gameRequest = new GameRequest();
    }

    @Test
    public void shouldReturnLoveAllWhenInputScoreIsAt0_0() {
        gameRequest.addScorePair(asPair(love, love));

        scoreBoard = game.scoreBoard(gameRequest);
        assertEquals("love-all", scoreBoard.get(0));
    }

    @Test
    public void shouldReturnLoveFifteenWhenInputScoreIsAt0_15() {
        gameRequest.addScorePair(asPair(love, fifteen));
        scoreBoard = game.scoreBoard(gameRequest);

        assertEquals("love-fifteen", scoreBoard.get(0));
    }

    @Test
    public void shouldReturnFifteenThirtyWhenInputScoreIsAt15_30() {
        gameRequest.addScorePair(asPair(fifteen, thirty));
        scoreBoard = game.scoreBoard(gameRequest);

        assertEquals("fifteen-thirty", scoreBoard.get(0));
    }

    @Test
    public void shouldReturnFortyFifteenWhenInputScoreIsAt40_15() {
        gameRequest.addScorePair(asPair(forty, fifteen));
        scoreBoard = game.scoreBoard(gameRequest);

        assertEquals("forty-fifteen", scoreBoard.get(0));
    }

    @Test
    public void shouldReturnFifteenAllWhenInputScoreIsAt15_15() {
        gameRequest.addScorePair(asPair(fifteen, fifteen));
        scoreBoard = game.scoreBoard(gameRequest);

        assertEquals("fifteen-all", scoreBoard.get(0));
    }

    @Test
    public void shouldReturnDeuceWhenInputScoreIsAt40_40() {
        gameRequest.addScorePair(asPair(forty, forty));
        scoreBoard = game.scoreBoard(gameRequest);

        assertEquals("deuce", scoreBoard.get(0));
    }

    @Test
    public void shouldReturnDeuceWhenInputScoreIsAt40_40AsPair() {
        gameRequest.addScorePair(asPair(forty, forty));
        scoreBoard = game.scoreBoard(gameRequest);

        assertEquals("deuce", scoreBoard.get(0));
    }


}