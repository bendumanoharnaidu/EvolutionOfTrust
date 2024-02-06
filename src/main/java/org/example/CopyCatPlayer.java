package org.example;

public class CopyCatPlayer implements Player {
    private String name;
    private int score = 0;
    private Choice lastMove = Choice.CHEAT;
    public CopyCatPlayer(String name) {
        this.name = name;
    }
    @Override
    public Choice playChoice() {
        if (lastMove==Choice.CHEAT) {
            return Choice.CHEAT;
        }
        return Choice.COOPERATE;
    }

    @Override
    public void score(int value) {
        if (value <= 0) {
            this.lastMove = Choice.CHEAT;
        }
        else {
            this.lastMove = Choice.COOPERATE;
        }
        this.score += value;
        System.out.println("CopyCatPlayerScore: "+ this.score);
    }

    @Override
    public int getScore() {
        return this.score;
    }
}
