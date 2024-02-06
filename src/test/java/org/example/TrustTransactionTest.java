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
        Player player1 = new CheatPlayer("Manohar");
        Player player2 = new CheatPlayer("Naidu");

        TrustTransaction transaction = new TrustTransaction(player1,player2);
        transaction.transact(5);

        assertEquals(0,player1.getScore());
        assertEquals(0,player2.getScore());
    }
    @Test
    public void TestExpectsToPlayByTwoCooperatePlayersForFiveRounds() {
        Player player1 = new CooperatePlayer("Manohar");
        Player player2 = new CooperatePlayer("Naidu");

        TrustTransaction transaction = new TrustTransaction(player1,player2);
        transaction.transact(5);

        assertEquals(10, player1.getScore());
        assertEquals(10, player2.getScore());

    }
    @Test
    public void TestExpectsToPlayByTwoCooperatePlayers() {
        Player player1 = new CooperatePlayer("Manohar"); //Coppe -1
        Player player2 = new CheatPlayer("Naidu");       //Cheat  3

        TrustTransaction transaction = new TrustTransaction(player1,player2);
        transaction.transact(5);

        assertEquals(-5, player1.getScore());
        assertEquals(15, player2.getScore());

    }
    @Test
    public void TestToCreateCopyCatPlayerToCheatFirstAndMimicTheOtherPlayerPreviousMove() {
        Player player1 = new CopyCatPlayer("Manohar");  //Cheat Cheat
        Player player2 = new CopyCatPlayer("Naidu");    //Cheat Cheat

        TrustTransaction transaction = new TrustTransaction(player1,player2);
        transaction.transact(2);

        assertEquals(0, player1.getScore());
        assertEquals(0, player2.getScore());
    }
    @Test
    public void TestCopyCatPlayerWithCooperatePlayer() {
        Player player1 = new CopyCatPlayer("Manohar"); //Cheat 3 Coope 2
        Player player2 = new CooperatePlayer("Naidu"); //Coope-1 Coope 2

        TrustTransaction transaction = new TrustTransaction(player1,player2);
        transaction.transact(2);

        assertEquals(5, player1.getScore());
        assertEquals(1, player2.getScore());
    }
    @Test
    public void TestToCreateCopyKittenPlayerToCooperateFirstAndMimicTheOtherPlayerPreviousMove() {
        CopyKittenPlayer player1 = new CopyKittenPlayer("Manohar"); //Coope
        CopyKittenPlayer player2 = new CopyKittenPlayer("Naidu");

        TrustTransaction transaction = new TrustTransaction(player1,player2);
        transaction.transact(2);

        assertEquals(4, player1.getScore());
        assertEquals(4, player2.getScore());
    }
    @Test
    public void TestToObserveCopyCatPlayerAndCopyKittenPlayer() {
        Player player1 = new CopyCatPlayer("Manohar");       // 3 2
        Player player2 = new CopyKittenPlayer("Naidu");   // -1 2

        TrustTransaction transaction = new TrustTransaction(player1,player2);
        transaction.transact(2);

        assertEquals(2, player1.getScore());
        assertEquals(2, player2.getScore());
    }
    @Test
    public void TestToObserveGrudgerPlayerAndCopyCatPlayer() {
        GrudgerPlayer player1 = new GrudgerPlayer("Manohar");   // Coope-1 Cheat 3 = 2
        CopyCatPlayer player2 = new CopyCatPlayer("Naidu");     // Cheat 3 Coope -1 = 2

        TrustTransaction transaction = new TrustTransaction(player1,player2);
        transaction.transact(2);

        assertEquals(2, player1.getScore());
        assertEquals(2, player2.getScore());
    }
    @Test
    public void TestToObserveGrudgerPlayerAndCopyKittenPlayer() {
        GrudgerPlayer player1 = new GrudgerPlayer("Manohar");       // Cooper 2 Coope 2
        CopyKittenPlayer player2 = new CopyKittenPlayer("Naidu");   // Cooper 2 Coope 2

        TrustTransaction transaction = new TrustTransaction(player1,player2);
        transaction.transact(2);

        assertEquals(4, player1.getScore());
        assertEquals(4, player2.getScore());
    }
    @Test
    public void TestToObserveGrudgerPlayerAndGrudgerPlayer() {
        GrudgerPlayer player1 = new GrudgerPlayer("Manohar");   // Cooper 2 Coope 2
        GrudgerPlayer player2 = new GrudgerPlayer("Naidu");     // Cooper 2 Coope 2

        TrustTransaction transaction = new TrustTransaction(player1,player2);
        transaction.transact(2);

        assertEquals(4, player1.getScore());
        assertEquals(4, player2.getScore());
    }
    @Test
    public void TestToObserveDetectivePlayerAndDetectivePlayer1() {
        Player player1 = new DetectivePlayer("Manohar");    //Cooper 2 Cheat   3 Cheat 3 Cheat 3
        Player player2 = new CooperatePlayer("Naidu");      //Cooper 2 Cooper -1 Cooper-1Cooper-1

        TrustTransaction transaction = new TrustTransaction(player1,player2);
        transaction.transact(1);

        assertEquals(2, player1.getScore());
        assertEquals(2, player2.getScore());

    }
    @Test
    public void TestToObserveDetectivePlayerAndDetectivePlayer2() {
        Player player1 = new DetectivePlayer("Manohar");    //Cooper 2 Cheat   3 Cheat 3 Cheat 3
        Player player2 = new CooperatePlayer("Naidu");      //Cooper 2 Cooper -1 Cooper-1Cooper-1

        TrustTransaction transaction = new TrustTransaction(player1,player2);
        transaction.transact(4);

        assertEquals(11, player1.getScore());
        assertEquals(-1, player2.getScore());

    }
    @Test
    public void TestTwoDetectivePlayers() {
        Player player1 = new DetectivePlayer("Manohar");    //Cooper 2 Cheat 0
        Player player2 = new DetectivePlayer("Naidu");      //Cooper 2 Chear 0

        TrustTransaction transaction = new TrustTransaction(player1,player2);
        transaction.transact(2);

        assertEquals(2, player1.getScore());
        assertEquals(2, player2.getScore());
    }

}