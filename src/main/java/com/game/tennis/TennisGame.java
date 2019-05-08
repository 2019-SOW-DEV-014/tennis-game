package com.game.tennis;

public class TennisGame {

    public String scoreBoard(int playerOneScore, int playerTwoScore) {

        if (isLoveAll(playerOneScore, playerTwoScore)) {
            return "love-all";
        }

        String score1 = getTextForScore(playerOneScore);
        String score2 = getTextForScore(playerTwoScore);

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
