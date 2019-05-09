package com.game.tennis.model.input;

public class Player {
    private String name;
    private int noOfWinsAfterForty;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNoOfWinsAfterForty(int noOfWinsAfterForty) {
        this.noOfWinsAfterForty = noOfWinsAfterForty;
    }

    public int getNoOfWinsAfterForty() {
        return noOfWinsAfterForty;
    }
}
