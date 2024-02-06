package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetectivePlayerTest {
    @Test
    public void TestToCreateADetectivePlayer() {
        assertDoesNotThrow(() -> new DetectivePlayer("Manohar"));
    }
    @Test
    public void TestExpectPlayerToCooperate() {

        DetectivePlayer player1 = new DetectivePlayer("Manohar");

        //Round 1
        assertEquals(Choice.COOPERATE, player1.playChoice());

        //Round 2
        assertEquals(Choice.CHEAT, player1.playChoice());
        assertEquals(Choice.CHEAT, player1.playChoice());
        assertEquals(Choice.CHEAT, player1.playChoice());
    }
    @Test
    public void TestExpertsDetectivePlayerToBeCheated() {
        DetectivePlayer player1 = new DetectivePlayer("Manohar");

        //Round 1
        assertNotEquals(Choice.CHEAT, player1.playChoice());

        //Round 2
        player1.score(0); //Which means lastmove to be CHEAT
        assertEquals(Choice.CHEAT, player1.playChoice());
        //DetectivePlayer have to act like a copycat
        assertEquals(Choice.CHEAT, player1.playChoice());
        assertEquals(Choice.CHEAT, player1.playChoice());
        assertEquals(Choice.CHEAT, player1.playChoice());
        //Last move was Cooperate
        player1.score(1); //Which means lastmove to be COOPERATE
        assertEquals(Choice.COOPERATE, player1.playChoice());


    }

}