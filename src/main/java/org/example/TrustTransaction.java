package org.example;

public class TrustTransaction {
    private Player player1;
    private Player player2;
    public TrustTransaction(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    public void transact(int numberOfRounds) {
        for (int i=0; i<numberOfRounds; i++) {
            Choice playerOneChoice = player1.playChoice();
            Choice playerTwoChoice = player2.playChoice();
            int score1 = calculateScore(playerOneChoice, playerTwoChoice);
            int score2 = calculateScore(playerTwoChoice, playerOneChoice);

            if (player1 instanceof GrudgerPlayer && playerTwoChoice==Choice.CHEAT) {
                ((GrudgerPlayer) player1).wasCheated();
            }
            if (player2 instanceof GrudgerPlayer && playerOneChoice==Choice.CHEAT) {
                ((GrudgerPlayer) player1).wasCheated();
            }
            if (player1 instanceof DetectivePlayer && playerTwoChoice==Choice.CHEAT) {
                ((DetectivePlayer) player1).wasCheated();
            }
            if (player2 instanceof DetectivePlayer && playerOneChoice==Choice.CHEAT) {
                ((DetectivePlayer) player1).wasCheated();
            }

            player1.score(score1);
            player2.score(score2);

        }
    }
    private int calculateScore(Choice choice1, Choice choice2) {
        if (choice1==Choice.COOPERATE && choice2==Choice.COOPERATE) {
            return 2;
        }
        else if (choice1==Choice.COOPERATE && choice2==Choice.CHEAT) {
            return -1;
        }
        else if (choice1==Choice.CHEAT && choice2==Choice.COOPERATE) {
            return 3;
        }
        return 0;
    }


}
