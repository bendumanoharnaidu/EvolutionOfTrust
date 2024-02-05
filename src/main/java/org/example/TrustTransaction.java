package org.example;

public class TrustTransaction {
    private Player player1;
    private int firstplayerScore;
    private int secondplayerScore;
    private Player player2;
    public TrustTransaction(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    public void transact(int numberOfRounds) {

        for (int i=0; i<numberOfRounds; i++) {
            if (player1 instanceof CooperatePlayer && player2 instanceof CooperatePlayer) {
                player1.score(2);
                player2.score(2);

            }
            if (player1 instanceof CheatPlayer && player2 instanceof CooperatePlayer) {
                player1.score(3);
                player2.score(-1);

            }
            if (player1 instanceof CooperatePlayer && player2 instanceof CheatPlayer) {
                player1.score(-1);
                player2.score(3);
            }
        }
    }

}
