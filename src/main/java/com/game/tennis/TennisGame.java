package com.game.tennis;

import com.game.tennis.constants.Score;

public class TennisGame {

    public String scoreBoard(int playerOneScore, int playerTwoScore) {

        if (isLoveAll(playerOneScore, playerTwoScore)) {
            return "love-all";
        }

        Score score1 = Score.getScoreFor(playerOneScore);
        Score score2 = Score.getScoreFor(playerTwoScore);

        return score1 + "-" + score2;

    }

    private String getTextForScore(int score) {
        String scoreText = null;
        if (score == 0) {
            scoreText = "love";
        } else if (score == 15) {
            scoreText = "fifteen";
        } else if (score == 30) {
            scoreText = "thirty";
        } else {
            if (score == 40) {
                scoreText = "forty";
            }
        }

        return scoreText;
    }

    private boolean isLoveAll(int playerOneScore, int playerTwoScore) {
        return playerOneScore == 0 && playerTwoScore == 0;
    }

}
