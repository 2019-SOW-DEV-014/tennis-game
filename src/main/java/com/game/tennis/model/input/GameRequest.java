package com.game.tennis.model.input;

import com.game.tennis.constants.Score;
import com.game.tennis.util.Pair;

public class GameRequest {

    private Pair<Score, Score> scorePair;

    public void setScorePair(Pair<Score, Score> scorePair) {
        this.scorePair = scorePair;
    }

    public void setScorePair(Score score1, Score score2) {
        Pair<Score, Score> scorePair = new Pair<Score, Score>(score1, score2);
        setScorePair(scorePair);
    }

    public Pair<Score, Score> getScorePair() {
        return scorePair;
    }
}
