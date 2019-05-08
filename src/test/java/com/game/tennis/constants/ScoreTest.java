package com.game.tennis.constants;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.game.tennis.constants.Score.*;
import static org.junit.Assert.assertEquals;

public class ScoreTest {

    Score result;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldReturnZeroFor0(){
        result = Score.getScoreFor(0);

        assertEquals(love, result);
    }

    @Test
    public void shouldReturnFifteenFor15(){
        result = Score.getScoreFor(15);

        assertEquals(fifteen, result);
    }

    @Test
    public void shouldReturnFifteenFor30(){
        result = Score.getScoreFor(30);

        assertEquals(thirty, result);
    }

    @Test
    public void shouldReturnFifteenFor40(){
        result = Score.getScoreFor(40);

        assertEquals(forty, result);
    }

    @Test
    public void shouldExpectIllegalArgumentExceptionFor45(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid input score: 45");

        result = Score.getScoreFor(45);
    }

}