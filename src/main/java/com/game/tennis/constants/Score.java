package com.game.tennis.constants;

public enum Score {
    love("love", 0), fifteen("fifteen", 15), thirty("thirty", 30), forty("forty", 40);

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
        for(Score s : values()){
            if(s.getValue() == score){
                return s;
            }
        }
        throw new IllegalArgumentException("Invalid input score: " + score);
    }
}
