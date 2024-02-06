package org.example;

public class DetectivePlayer implements Player{
    private String name;
    private int score = 0;
    private Choice lastMove = Choice.COOPERATE;
    private boolean wasCheated = false;
    private int count = 0;
    public DetectivePlayer(String name) {
        this.name = name;
    }
    public void wasCheated() {
        this.wasCheated = true;
    }
    @Override
    public Choice playChoice() {
        count++;
        if (count==1) {
            if (lastMove == Choice.CHEAT) {
                wasCheated = true;
            }
            return Choice.COOPERATE;
        }
        if (count==2) {
            if(lastMove == Choice.CHEAT) {
                wasCheated = true;
            }
            return Choice.CHEAT;
        }
       if (wasCheated && count >2) {
           if (lastMove==Choice.CHEAT) {
               return Choice.CHEAT;
           }
           return Choice.COOPERATE;
       }
       else {
           return Choice.CHEAT;
       }
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
        System.out.println("DetectivePlayerScore: "+ this.score);
    }

    @Override
    public int getScore() {
        return this.score;
    }
}
