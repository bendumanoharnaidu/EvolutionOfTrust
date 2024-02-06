package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrudgerPlayerTest {
    @Test
    public void TestExpectToCreateAGrudgerPlayer() {
        assertDoesNotThrow(() -> new GrudgerPlayer("Manohar"));
    }

    @Test
    public void TestExpectPlayerToCooperate() {
        GrudgerPlayer player = new GrudgerPlayer("Manohar");

        assertEquals(Choice.COOPERATE, player.playChoice());
        assertEquals(Choice.COOPERATE, player.playChoice());
        assertEquals(Choice.COOPERATE, player.playChoice());
        assertEquals(Choice.COOPERATE, player.playChoice());
    }
    @Test
    public void TestExpectPlayerToCooperateFirstAndThenCheat() {
        GrudgerPlayer player = new GrudgerPlayer("Manohar");

        assertEquals(Choice.COOPERATE, player.playChoice());
        assertEquals(Choice.COOPERATE, player.playChoice());

        player.wasCheated();

        assertEquals(Choice.CHEAT, player.playChoice());
        assertEquals(Choice.CHEAT, player.playChoice());
        assertEquals(Choice.CHEAT, player.playChoice());
        assertEquals(Choice.CHEAT, player.playChoice());
    }


}