package com.game.tennis.constants;

public enum Score {
    LOVE("love", 0), FIFTEEN("fifteen", 15), THIRTY("thirty", 30), FORTY("forty", 40);

    private String text;
    private int value;

    public String getText() {
        return text;
    }

    public int getValue() {
        return value;
    }

    Score(String text, int value){
        this.text = text;
        this.value = value;
    }

    public static Score getScoreFor(int score) {
        return LOVE;
    }
}
