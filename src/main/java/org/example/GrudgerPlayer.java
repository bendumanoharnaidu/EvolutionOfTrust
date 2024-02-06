package org.example;

public class GrudgerPlayer implements Player {
    private String name;
    private int score = 0;
    private Choice lastMove = Choice.COOPERATE;
    private boolean wasCheated = false;
    public GrudgerPlayer(String name) {
        this.name = name;
    }

    public void wasCheated() {
        this.wasCheated = true;
    }
    @Override
    public Choice playChoice() {
        if (wasCheated) {
            return Choice.CHEAT;
        }
        return Choice.COOPERATE;
    }

    @Override
    public void score(int score) {
        if (score <= 0) {
            this.lastMove = Choice.CHEAT;
        }
        else {
            this.lastMove = Choice.COOPERATE;
        }
        this.score += score;
    }

    @Override
    public int getScore() {

        return this.score;
    }
}
