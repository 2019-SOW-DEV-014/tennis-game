package com.game.tennis.util;

import com.game.tennis.constants.Score;
import org.junit.Test;

import static com.game.tennis.constants.Score.fifteen;
import static com.game.tennis.constants.Score.love;
import static org.junit.Assert.assertEquals;

public class PairTest {

    @Test
    public void pairShouldHaveLoveFifteenWhenAsPairInvokedWithLoveFifteen() {
        Pair<Score, Score> pair = Pair.asPair(love, fifteen);

        assertEquals(love, pair.getFirst());
        assertEquals(fifteen, pair.getSecond());
    }

}