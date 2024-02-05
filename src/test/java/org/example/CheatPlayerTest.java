package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheatPlayerTest {
    @Test
    public void TestToCreateACheatPlayer() {
        assertDoesNotThrow(() -> new CheatPlayer("Manohar"));
    }

    @Test
    public void TestExpectsToAlwaysChooseCheat() {
        Player player = new CheatPlayer("Manohar");
        assertEquals(Choice.CHEAT, player.playChoice());
    }
    @Test
    public void TestExpectsToAlwaysChooseCheat2() {
        Player player = new CheatPlayer("Manohar");
        assertNotEquals(Choice.COOPERATE, player.playChoice());
    }

}