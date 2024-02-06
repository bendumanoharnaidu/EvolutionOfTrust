package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CopyCatPlayerTest {
    @Test
    public void TestToCreateACopyCatPlayer() {
        assertDoesNotThrow(() -> new CopyCatPlayer("Manohar"));
    }

    @Test
    public void TestExpectPlayerToCheatFirstAndThenMimicTheOtherPlayerPreviousMove() {
        CopyCatPlayer player = new CopyCatPlayer("Manohar");

        assertEquals(Choice.CHEAT, player.playChoice());
        player.score(0); //Which means lastmove to be CHEAT
        assertEquals(Choice.CHEAT, player.playChoice());
        player.score(1); //Which means lastmove to be COOPERATE
        assertEquals(Choice.COOPERATE, player.playChoice());

    }
}