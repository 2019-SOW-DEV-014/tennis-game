package com.game.tennis;

import com.game.tennis.model.input.GameRequest;
import com.game.tennis.model.output.ScoreBoard;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.game.tennis.constants.Score.*;
import static com.game.tennis.util.Pair.asPair;
import static org.junit.Assert.assertEquals;

public class TennisGameTest {

    private TennisGame game;
    private GameRequest gameRequest;
    private List<String> scores;
    private ScoreBoard scoreBoard;

    @Before
    public void initialise() {
        game = new TennisGame();
        gameRequest = new GameRequest();
    }

    @Test
    public void shouldReturnLoveAllWhenInputScoreIsAt0_0() {
        gameRequest.addScorePair(asPair(love, love));
        scoreBoard = game.getScoreBoard(gameRequest);
        scores = scoreBoard.getPoints();

        assertEquals("love-all", scores.get(0));
    }

    @Test
    public void shouldReturnLoveFifteenWhenInputScoreIsAt0_15() {
        gameRequest.addScorePair(asPair(love, fifteen));
        scoreBoard = game.getScoreBoard(gameRequest);
        scores = scoreBoard.getPoints();

        assertEquals("love-fifteen", scores.get(0));
    }

    @Test
    public void shouldReturnFifteenThirtyWhenInputScoreIsAt15_30() {
        gameRequest.addScorePair(asPair(fifteen, thirty));
        scoreBoard = game.getScoreBoard(gameRequest);
        scores = scoreBoard.getPoints();

        assertEquals("fifteen-thirty", scores.get(0));
    }

    @Test
    public void shouldReturnFortyFifteenWhenInputScoreIsAt40_15() {
        gameRequest.addScorePair(asPair(forty, fifteen));
        scoreBoard = game.getScoreBoard(gameRequest);
        scores = scoreBoard.getPoints();

        assertEquals("forty-fifteen", scores.get(0));
    }

    @Test
    public void shouldReturnFifteenAllWhenInputScoreIsAt15_15() {
        gameRequest.addScorePair(asPair(fifteen, fifteen));
        scoreBoard = game.getScoreBoard(gameRequest);
        scores = scoreBoard.getPoints();

        assertEquals("fifteen-all", scores.get(0));
    }

    @Test
    public void shouldReturnDeuceWhenInputScoreIsAt40_40() {
        gameRequest.addScorePair(asPair(forty, forty));
        scoreBoard = game.getScoreBoard(gameRequest);
        scores = scoreBoard.getPoints();

        assertEquals("deuce", scores.get(0));
    }

    @Test
    public void shouldReturnLoveAllAndLoveFifteenFor_Point_love_love_and_Point_love_fifteen() {
        gameRequest.addScorePair(asPair(love,love));
        gameRequest.addScorePair(asPair(love,fifteen));
        scoreBoard = game.getScoreBoard(gameRequest);
        scores = scoreBoard.getPoints();

        assertEquals("love-all", scores.get(0));
        assertEquals("love-fifteen", scores.get(1));
    }

}