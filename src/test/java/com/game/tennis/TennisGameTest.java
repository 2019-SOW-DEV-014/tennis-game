package com.game.tennis;

import com.game.tennis.model.input.GameRequest;
import com.game.tennis.model.input.Player;
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
    private Player playerOne;
    private Player playerTwo;

    @Before
    public void initialise() {
        game = new TennisGame();
        gameRequest = new GameRequest();
        playerOne = new Player();
        playerTwo = new Player();

        gameRequest.setPlayers(playerOne, playerTwo);
    }

    @Test
    public void shouldReturnloveAllWhenInputScoreIsAt0_0() {
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
        gameRequest.addScorePair(asPair(love, love));
        gameRequest.addScorePair(asPair(love, fifteen));
        scoreBoard = game.getScoreBoard(gameRequest);
        scores = scoreBoard.getPoints();

        assertEquals("love-all", scores.get(0));
        assertEquals("love-fifteen", scores.get(1));
    }

    @Test
    public void scoresShouldContainPlayer2AdvantageWhenNoOfWinsAfterFortyIs1ForPlayer2() {
        gameRequest.addScorePair(asPair(love, love));
        gameRequest.addScorePair(asPair(love, fifteen));
        gameRequest.addScorePair(asPair(love, thirty));
        gameRequest.addScorePair(asPair(love, forty));
        playerOne.setNoOfWinsAfterForty(0);
        playerTwo.setNoOfWinsAfterForty(1);
        scoreBoard = game.getScoreBoard(gameRequest);
        scores = scoreBoard.getPoints();

        assertEquals("love-all", scores.get(0));
        assertEquals("love-fifteen", scores.get(1));
        assertEquals("love-thirty", scores.get(2));
        assertEquals("love-forty", scores.get(3));
        assertEquals("Frederer-advantage", scores.get(4));
    }

    @Test
    public void scoresShouldContainPlayer1AdvantageWhenNoOfWinsAfterFortyIs2ForPlayer1And1ForPlayer2() {
        addPointPairsToGameRequest();
        playerOne.setNoOfWinsAfterForty(2);
        playerTwo.setNoOfWinsAfterForty(1);
        scoreBoard = game.getScoreBoard(gameRequest);
        scores = scoreBoard.getPoints();

        assertEquals("love-all", scores.get(0));
        assertEquals("fifteen-love", scores.get(1));
        assertEquals("fifteen-all", scores.get(2));
        assertEquals("fifteen-thirty", scores.get(3));
        assertEquals("thirty-all", scores.get(4));
        assertEquals("thirty-forty", scores.get(5));
        assertEquals("deuce", scores.get(6));
        assertEquals("Nadal-advantage", scores.get(7));
    }

    @Test
    public void scoresShouldContainDeuceWhenNoOfWinsAfterFortyIsEqualForPlayer1AndPlayer2() {
        addPointPairsToGameRequest();
        playerOne.setNoOfWinsAfterForty(2);
        playerTwo.setNoOfWinsAfterForty(2);
        scoreBoard = game.getScoreBoard(gameRequest);
        scores = scoreBoard.getPoints();

        assertEquals("love-all", scores.get(0));
        assertEquals("fifteen-love", scores.get(1));
        assertEquals("fifteen-all", scores.get(2));
        assertEquals("fifteen-thirty", scores.get(3));
        assertEquals("thirty-all", scores.get(4));
        assertEquals("thirty-forty", scores.get(5));
        assertEquals("deuce", scores.get(6));
        assertEquals("deuce", scores.get(7));
    }

    @Test
    public void scoresShouldContainPlayer2WonWhenNoOfWinsAfterFortyIs1ForPlayer1And3ForPlayer2() {
        addPointPairsToGameRequest();
        playerOne.setNoOfWinsAfterForty(1);
        playerTwo.setNoOfWinsAfterForty(3);
        scoreBoard = game.getScoreBoard(gameRequest);
        scores = scoreBoard.getPoints();

        assertEquals("love-all", scores.get(0));
        assertEquals("fifteen-love", scores.get(1));
        assertEquals("fifteen-all", scores.get(2));
        assertEquals("fifteen-thirty", scores.get(3));
        assertEquals("thirty-all", scores.get(4));
        assertEquals("thirty-forty", scores.get(5));
        assertEquals("deuce", scores.get(6));
        assertEquals("Frederer-won", scores.get(7));
    }

    @Test
    public void scoresShouldContainPlayer1WonWhenNoOfWinsAfterFortyIs5ForPlayer1And3ForPlayer2() {
        addPointPairsToGameRequest();
        playerOne.setNoOfWinsAfterForty(5);
        playerTwo.setNoOfWinsAfterForty(3);
        scoreBoard = game.getScoreBoard(gameRequest);
        scores = scoreBoard.getPoints();

        assertEquals("love-all", scores.get(0));
        assertEquals("fifteen-love", scores.get(1));
        assertEquals("fifteen-all", scores.get(2));
        assertEquals("fifteen-thirty", scores.get(3));
        assertEquals("thirty-all", scores.get(4));
        assertEquals("thirty-forty", scores.get(5));
        assertEquals("deuce", scores.get(6));
        assertEquals("Nadal-won", scores.get(7));
    }

    private void addPointPairsToGameRequest() {
        gameRequest.addScorePair(asPair(love, love));
        gameRequest.addScorePair(asPair(fifteen, love));
        gameRequest.addScorePair(asPair(fifteen, fifteen));
        gameRequest.addScorePair(asPair(fifteen, thirty));
        gameRequest.addScorePair(asPair(thirty, thirty));
        gameRequest.addScorePair(asPair(thirty, forty));
        gameRequest.addScorePair(asPair(forty, forty));
    }

}