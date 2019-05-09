package com.game.tennis;

import com.game.tennis.constants.Score;
import com.game.tennis.model.input.GameRequest;
import com.game.tennis.util.Pair;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> scoreBoard(GameRequest gameRequest) {
        List<String> scoreBoardResult = new ArrayList<String>();
        List<Pair<Score, Score>> scorePairs = gameRequest.getScorePairs();

        for (Pair<Score, Score> scorePair : scorePairs) {
            String scoreText = scoreBoard(scorePair.getFirst(), scorePair.getSecond());
            scoreBoardResult.add(scoreText);
        }
        return scoreBoardResult;
    }
}
