package com.game.tennis;

import com.game.tennis.constants.Score;
import com.game.tennis.model.input.GameRequest;
import com.game.tennis.model.input.Player;
import com.game.tennis.model.output.ScoreBoard;
import com.game.tennis.util.Pair;

import java.util.ArrayList;
import java.util.List;

class TennisGame {

    TennisGame() {
    }

    public ScoreBoard getScoreBoard(GameRequest gameRequest) {
        ScoreBoard scoreBoard = new ScoreBoard();
        List<String> scores = new ArrayList<String>();
        List<Pair<Score, Score>> scorePairs = gameRequest.getScorePairs();

        addPointsTillGameBall(scores, scorePairs);
        addPointsFromDeuceIfAny(scores, gameRequest);

        scoreBoard.setPoints(scores);

        return scoreBoard;
    }

    private void addPointsTillGameBall(List<String> scores, List<Pair<Score, Score>> scorePairs) {

        for (Pair<Score, Score> scorePair : scorePairs) {
            String scoreText = getScoreBoard(scorePair.getFirst(), scorePair.getSecond());
            scores.add(scoreText);
        }
    }

    private String getScoreBoard(Score playerOneScore, Score playerTwoScore) {
        return getScoreText(playerOneScore, playerTwoScore);
    }

    private String getScoreText(Score score1, Score score2) {
        String score1Text = score1.getText();
        String score2Text = score2.getText();

        if (isScoresOnLevel(score1.getValue(), score2.getValue())) {
            if (isDeuce(score1)) {
                return "deuce";
            } else {
                score1Text = score1.getText();
                score2Text = "all";
            }
        }

        return score1Text + "-" + score2Text;
    }

    private boolean isScoresOnLevel(int playerOneScore, int playerTwoScore) {
        return playerOneScore == playerTwoScore;
    }

    private boolean isDeuce(Score score) {
        return score.getValue() == Score.forty.getValue();
    }

    private void addPointsFromDeuceIfAny(List<String> points, GameRequest gameRequest) {
        Player playerOne = gameRequest.getPlayerOne();
        Player playerTwo = gameRequest.getPlayerTwo();

        int playerOneLeadDifference = playerOne.getNoOfWinsAfterForty() - playerTwo.getNoOfWinsAfterForty();
        String gameStatus = getCurrentGameStatus(playerOneLeadDifference, gameRequest);

        if (gameStatus == null) {
            throw new IllegalArgumentException("Lead by value is invalid for one of the player");
        }

        points.add(gameStatus);
    }

    private String getCurrentGameStatus(int playerOneLeadDifference, GameRequest gameRequest) {
        String pointText = null;
        Player playerOne = gameRequest.getPlayerOne();
        Player playerTwo = gameRequest.getPlayerTwo();

        if (playerOneLeadDifference == 2) {
            pointText = playerOne.getName() + "-" + "won";
        } else if (playerOneLeadDifference == -2) {
            pointText = playerTwo.getName() + "-" + "won";
        } else if (playerOneLeadDifference == 0) {
            pointText = "deuce";
        } else if (playerOneLeadDifference == 1) {
            pointText = playerOne.getName() + "-" + "advantage";
        } else {
            if (playerOneLeadDifference == -1) {
                pointText = playerTwo.getName() + "-" + "advantage";
            }
        }

        return pointText;
    }
}
