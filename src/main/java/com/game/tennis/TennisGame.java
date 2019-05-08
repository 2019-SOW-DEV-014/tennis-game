package com.game.tennis;

import com.game.tennis.constants.Score;
import com.game.tennis.model.input.GameRequest;
import com.game.tennis.util.Pair;

public class TennisGame {

    public String scoreBoard(Score playerOneScore, Score playerTwoScore) {

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

    private boolean isDeuce(Score score) {
        return score.getValue() == Score.forty.getValue();
    }

    private boolean isScoresOnLevel(int playerOneScore, int playerTwoScore) {
        return playerOneScore == playerTwoScore;
    }

    public String scoreBoard(GameRequest gameRequest) {
        Pair<Score, Score> scorePair = gameRequest.getScorePair();
        return scoreBoard(scorePair.getFirst(), scorePair.getSecond());

    }
}
