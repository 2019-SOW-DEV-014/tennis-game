package com.game.tennis.util;

public class Pair<First, Second> {

    private final First first;
    private final Second second;

    public First getFirst() {
        return first;
    }

    public Second getSecond() {
        return second;
    }

    public Pair(First first, Second second) {
        this.first = first;
        this.second = second;
    }

    public static <First, Second> Pair<First, Second> asPair(First score1, Second score2) {
        return new Pair<First, Second>(score1, score2);
    }
}
