package org.example;

public class CheatPlayer implements Player{
    private String name;
    private int score = 0;
    public CheatPlayer(String name) {
        this.name = name;
    }

    @Override
    public Choice playChoice() {
        return Choice.CHEAT;
    }

    @Override
    public void score(int score) {
        this.score += score;
        System.out.println("CheatPlayerScore: "+ this.score);
    }

    public int getScore() {
        return score;
    }
}
