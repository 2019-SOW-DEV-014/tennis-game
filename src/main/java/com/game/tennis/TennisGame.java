package com.game.tennis;

import com.game.tennis.constants.Score;

public class TennisGame {

    public String scoreBoard(int playerOneScore, int playerTwoScore) {

        Score score1 = Score.getScoreFor(playerOneScore);
        Score score2 = Score.getScoreFor(playerTwoScore);

        return getScoreText(score1, score2);

    }

    private String getScoreText(Score score1, Score score2) {
        String score1Text = score1.getText();
        String score2Text = score2.getText();

        if (isScoresOnLevel(score1.getValue(), score2.getValue())) {
            score1Text = score1.getText();
            score2Text = "all";
        }

        return score1Text + "-" + score2Text;
    }

    private boolean isScoresOnLevel(int playerOneScore, int playerTwoScore) {
        return playerOneScore == playerTwoScore;
    }

}
