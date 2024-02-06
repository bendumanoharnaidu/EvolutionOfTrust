package org.example;

public class CooperatePlayer implements Player {
    private String name;
    private int score = 0;
    public CooperatePlayer(String name) {
        this.name = name;
    }

    @Override
    public Choice playChoice() {
        return Choice.COOPERATE;
    }

    @Override
    public void score(int value) {
        this.score += value;
        System.out.println("CooperatePlayerScore: "+ this.score);
    }

    @Override
    public int getScore() {
        return this.score;
    }
}
