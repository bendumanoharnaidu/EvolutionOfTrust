package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CopyKittenPlayerTest {
    @Test
    public void TestToCreateACopyKittenPlayer() {
        assertDoesNotThrow(() -> new CopyKittenPlayer("Manohar"));
    }

    @Test
    public void TestExpectPlayerToCooperateFirstAndThenMimicTheOtherPlayerPreviousMove() {
        CopyKittenPlayer player = new CopyKittenPlayer("Manohar");

        assertEquals(Choice.COOPERATE, player.playChoice());
        player.score(0); //Which means lastmove to be CHEAT
        assertEquals(Choice.CHEAT, player.playChoice());
        player.score(1); //Which means lastmove to be COOPERATE
        assertEquals(Choice.COOPERATE, player.playChoice());
        player.score(0); //Which means lastmove to be CHEAT
        assertEquals(Choice.CHEAT, player.playChoice());

    }

}