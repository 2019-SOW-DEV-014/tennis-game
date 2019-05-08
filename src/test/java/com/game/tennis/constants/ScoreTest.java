package com.game.tennis.constants;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreTest {

    @Test
    public void shouldReturnZeroFor0(){
        Score result = Score.getScoreFor(0);

        assertEquals(Score.LOVE, result);
    }

    @Test
    public void shouldReturnFifteenFor15(){
        Score result = Score.getScoreFor(15);

        assertEquals(Score.FIFTEEN, result);
    }

}