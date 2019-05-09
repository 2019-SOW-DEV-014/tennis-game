package com.game.tennis.model.input;

import com.game.tennis.constants.Score;
import com.game.tennis.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class GameRequest {

    private Pair<Score, Score> scorePair;
    private Player playerOne;
    private Player playerTwo;
    private final List<Pair<Score, Score>> scorePairs;

    public GameRequest() {
        scorePairs = new ArrayList<Pair<Score, Score>>();
    }

    public void setScorePair(Pair<Score, Score> scorePair) {
        this.scorePair = scorePair;
    }

    public void setPlayers(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void addScorePair(Pair<Score, Score> scorePair) {
        scorePairs.add(scorePair);
    }

    public List<Pair<Score, Score>> getScorePairs() {
        return scorePairs;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }
}
