package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CooperatePlayerTest {
    @Test
    public void TestExpectToCreateACooperatePlayer() {
        assertDoesNotThrow(() -> new CooperatePlayer("Manohar"));
    }

    @Test
    public void TestExpectPlayerToAlwaysChooseCooperate() {
        Player player = new CooperatePlayer("Manohar");
        assertEquals(Choice.COOPERATE, player.playChoice());
    }

    @Test
    public void TestExpectPlayerToAlwaysChooseCooperate1() {
        Player player = new CooperatePlayer("Manohar");
        assertNotEquals(Choice.CHEAT, player.playChoice());
        assertNotEquals(Choice.CHEAT, player.playChoice());
        assertNotEquals(Choice.CHEAT, player.playChoice());
    }

}