package com.game.tennis.constants;

import org.junit.Test;

import static com.game.tennis.constants.Score.*;
import static org.junit.Assert.*;

public class ScoreTest {

    Score result;

    @Test
    public void shouldReturnZeroFor0(){
        result = Score.getScoreFor(0);

        assertEquals(LOVE, result);
    }

    @Test
    public void shouldReturnFifteenFor15(){
        result = Score.getScoreFor(15);

        assertEquals(FIFTEEN, result);
    }

    @Test
    public void shouldReturnFifteenFor30(){
        result = Score.getScoreFor(30);

        assertEquals(THIRTY, result);
    }

    @Test
    public void shouldReturnFifteenFor40(){
        result = Score.getScoreFor(40);

        assertEquals(FORTY, result);
    }

}