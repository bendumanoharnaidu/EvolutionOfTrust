package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TournamentTest {
    @Test
    public void testTournamentWithEmptyList() {
        List<Player> initialPopulation = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> {
            new Tournament(initialPopulation);
        });
    }
    @Test
    public void testTournamentWithLessThan5Players() {
        List<Player> initialPopulation = new ArrayList<>();
        initialPopulation.add(new CheatPlayer("CheatPlayer1"));
        initialPopulation.add(new CooperatePlayer("CooperatePlayer1"));
        initialPopulation.add(new CopyCatPlayer("CopyCatPlayer1"));
        initialPopulation.add(new CopyKittenPlayer("CopyKittenPlayer1"));

        assertThrows(IllegalArgumentException.class, () -> {
            new Tournament(initialPopulation);
        });
    }
    @Test
    public void testTournamentWithAtleastFiveOrMorePlayers() {
        List<Player> initialPopulation = new ArrayList<>();
        initialPopulation.add(new CheatPlayer("CheatPlayer1"));
        initialPopulation.add(new CooperatePlayer("CooperatePlayer1"));
        initialPopulation.add(new CopyCatPlayer("CopyCatPlayer1"));
        initialPopulation.add(new CopyKittenPlayer("CopyKittenPlayer1"));
        initialPopulation.add(new DetectivePlayer("DetectivePlayer1"));
        initialPopulation.add(new GrudgerPlayer("GrudgerPlayer1"));

        Tournament evolution = new Tournament(initialPopulation);
    }
    @Test
    public void testEliminateLosersAndReproduceWinners() {
        List<Player> initialPopulation = new ArrayList<>();
        initialPopulation.add(new CheatPlayer("CheatPlayer1"));
        initialPopulation.add(new CheatPlayer("CheatPlayer2"));
        initialPopulation.add(new CheatPlayer("CheatPlayer3"));
        initialPopulation.add(new CheatPlayer("CheatPlayer4"));
        initialPopulation.add(new CheatPlayer("CheatPlayer5"));
        initialPopulation.add(new CheatPlayer("CheatPlayer6"));
        initialPopulation.add(new CheatPlayer("CheatPlayer7"));
        initialPopulation.add(new CheatPlayer("CheatPlayer8"));
        initialPopulation.add(new CheatPlayer("CheatPlayer9"));
        initialPopulation.add(new CooperatePlayer("CooperatePlayer1"));

        Tournament evolution = new Tournament(initialPopulation);
        evolution.eliminateLosers();
        assertEquals(5, evolution.getPopulation().size());
        evolution.reproduceWinners();
        assertEquals(10, evolution.getPopulation().size());
    }
    @Test
    public void testTournament() {
        List<Player> initialPopulation = new ArrayList<>();
        Player player1 = new CheatPlayer("CheatPlayer1");
        initialPopulation.add(player1);
        Player player2 = new CheatPlayer("CheatPlayer2");
        initialPopulation.add(player2);
        Player player3 = new CheatPlayer("CheatPlayer3");
        initialPopulation.add(player3);
        Player player4 = new CheatPlayer("CheatPlayer4");
        initialPopulation.add(player4);
        Player player5 = new CheatPlayer("CheatPlayer5");
        initialPopulation.add(player5);
        Player player6 = new CheatPlayer("CheatPlayer6");
        initialPopulation.add(player6);
        Player player7 = new CheatPlayer("CheatPlayer7");
        initialPopulation.add(player7);
        Player player8 = new CheatPlayer("CheatPlayer8");
        initialPopulation.add(player8);
        Player player9 = new CheatPlayer("CheatPlayer9");
        initialPopulation.add(player9);
        Player player10 = new CooperatePlayer("Cooperate1");
        initialPopulation.add(player10);

        Tournament evolution = new Tournament(initialPopulation);
        evolution.evolve(1,1);
        assertEquals(3, player1.getScore());
        assertEquals(3, player2.getScore());
        assertEquals(3, player3.getScore());
        assertEquals(3, player4.getScore());
        assertEquals(3, player5.getScore());
        assertEquals(3, player6.getScore());
        assertEquals(3, player7.getScore());
        assertEquals(3, player8.getScore());
        assertEquals(3, player9.getScore());
        assertEquals(-9, player10.getScore());
    }
    @Test
    public void testTournament2() {
        List<Player> initialPopulation = new ArrayList<>();
        Player player1 = new CheatPlayer("CheatPlayer1"); //5*3
        initialPopulation.add(player1);
        Player player2 = new CheatPlayer("CheatPlayer2");
        initialPopulation.add(player2);
        Player player3 = new CheatPlayer("CheatPlayer3");
        initialPopulation.add(player3);
        Player player4 = new CheatPlayer("CheatPlayer4");
        initialPopulation.add(player4);
        Player player5 = new CheatPlayer("CheatPlayer5");
        initialPopulation.add(player5);
        Player player6 = new CooperatePlayer("Cooperate1"); //-1*5 2*4
        initialPopulation.add(player6);
        Player player7 = new CooperatePlayer("Cooperate2"); //-1*5 2*4
        initialPopulation.add(player7);
        Player player8 = new CooperatePlayer("Cooperate3");
        initialPopulation.add(player8);
        Player player9 = new CooperatePlayer("Cooperate4");
        initialPopulation.add(player9);
        Player player10 = new CooperatePlayer("Cooperate5");
        initialPopulation.add(player10);

        Tournament evolution = new Tournament(initialPopulation);
        evolution.evolve(1, 1);
        assertEquals(15, player1.getScore());
        assertEquals(15, player2.getScore());
        assertEquals(15, player3.getScore());
        assertEquals(15, player4.getScore());
        assertEquals(15, player5.getScore());
        assertEquals(3, player6.getScore());
        assertEquals(3, player7.getScore());
        assertEquals(3, player8.getScore());
        assertEquals(3, player9.getScore());
        assertEquals(3, player10.getScore());
    }
    @Test
    public void testTournament3() {
        List<Player> initialPopulation = new ArrayList<>();
        Player player1 = new CheatPlayer("CheatPlayer1");
        initialPopulation.add(player1);
        Player player2 = new CheatPlayer("CheatPlayer2");
        initialPopulation.add(player2);
        Player player3 = new CheatPlayer("CheatPlayer3");
        initialPopulation.add(player3);
        Player player4 = new CheatPlayer("CheatPlayer4");
        initialPopulation.add(player4);
        Player player5 = new CheatPlayer("CheatPlayer5");
        initialPopulation.add(player5);
        Player player6 = new CooperatePlayer("Cooperate1");
        initialPopulation.add(player6);
        Player player7 = new CooperatePlayer("Cooperate2");
        initialPopulation.add(player7);
        Player player8 = new CooperatePlayer("Cooperate3");
        initialPopulation.add(player8);
        Player player9 = new CooperatePlayer("Cooperate4");
        initialPopulation.add(player9);
        Player player10 = new CooperatePlayer("Cooperate5");
        initialPopulation.add(player10);

        Tournament evolution = new Tournament(initialPopulation);
        evolution.evolve(2, 1);
//
//        assertEquals(15, player1.getScore());
//        assertEquals(15, player2.getScore());
//        assertEquals(15, player3.getScore());
//        assertEquals(15, player4.getScore());
//        assertEquals(15, player5.getScore());

    }
}
