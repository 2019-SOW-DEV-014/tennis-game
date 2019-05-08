package com.game.tennis.model.input;

import com.game.tennis.constants.Score;
import com.game.tennis.util.Pair;
import org.junit.Test;

import static com.game.tennis.constants.Score.fifteen;
import static com.game.tennis.constants.Score.love;
import static org.junit.Assert.*;

public class GameRequestTest {

    @Test
    public void shouldReturnLoveFifteenWhenScorePairIs0_15(){
        GameRequest gameRequest = new GameRequest();
        Pair<Score, Score> scorePair = new Pair<Score, Score>(love, fifteen);
        gameRequest.setScorePair(scorePair.getFirst(), scorePair.getSecond());

        Pair<Score, Score> pair = gameRequest.getScorePair();

        assertEquals(0, pair.getFirst().getValue());
        assertEquals(15, pair.getSecond().getValue());
    }

}