package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrustTransactionTest {
    @Test
    public void TestExpectsToCreateATransaction() {
        Player player1 = new CooperatePlayer("Manohar");
        Player player2 = new CooperatePlayer("Naidu");
        assertDoesNotThrow(() -> new TrustTransaction(player1,player2));
    }
    @Test
    public void TestExpectsToPlayByTwoCheatPlayers() {
        CheatPlayer player1 = new CheatPlayer("Manohar");
        CheatPlayer player2 = new CheatPlayer("Naidu");

        TrustTransaction transaction = new TrustTransaction(player1,player2);
        transaction.transact(5);

        assertEquals(0,player1.getScore());
        assertEquals(0,player2.getScore());
    }
    @Test
    public void TestExpectsToPlayByTwoCooperatePlayersForFiveRounds() {
        CooperatePlayer player1 = new CooperatePlayer("Manohar");
        CooperatePlayer player2 = new CooperatePlayer("Naidu");

        TrustTransaction transaction = new TrustTransaction(player1,player2);
        transaction.transact(5);

        assertEquals(10, player1.getScore());
        assertEquals(10, player2.getScore());

    }
    @Test
    public void TestExpectsToPlayByTwoCooperatePlayers() {
        CooperatePlayer player1 = new CooperatePlayer("Manohar");
        CheatPlayer player2 = new CheatPlayer("Naidu");

        TrustTransaction transaction = new TrustTransaction(player1,player2);
        transaction.transact(5);

        assertEquals(-5, player1.getScore());
        assertEquals(15, player2.getScore());

    }


}