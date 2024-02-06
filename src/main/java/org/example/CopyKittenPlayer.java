package org.example;

public class CopyKittenPlayer implements Player{
    private String name;
    private int score;
    private Choice lastMove = Choice.COOPERATE;
    public CopyKittenPlayer(String name) {
        this.name = name;
    }
    @Override
    public Choice playChoice() {
        if (lastMove==Choice.COOPERATE) {
            return Choice.COOPERATE;
        }
        return Choice.CHEAT;
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
