package org.example;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Tournament {
    private List<Player> population;
    private int numberOfRoundsBetweenTwoPlayers;
    public Tournament(List<Player> initialPopulation) {
        if (initialPopulation.isEmpty()) {
            throw new IllegalArgumentException("Population must not be empty");
        }
        if (initialPopulation.size() < 5) {
            throw new IllegalArgumentException("Population must be at least 5");
        }
        this.population = initialPopulation;
    }

    public void evolve(int tournamentRounds, int numberOfRoundsBetweenTwoPlayers) {
        for (int i=0; i<tournamentRounds; i++) {

            playTournament(numberOfRoundsBetweenTwoPlayers);
            eliminateLosers();
            reproduceWinners();
        }
    }
    public void playTournament(int numberOfRoundsBetweenTwoPlayers) {
        for (int i=0; i<population.size(); i++) {
            for (int j=i+1; j<population.size(); j++) {
                TrustTransaction transaction = new TrustTransaction(population.get(i), population.get(j));
                transaction.transact(numberOfRoundsBetweenTwoPlayers);
            }
        }
    }
    public void eliminateLosers() {
        if (population.size() < 10) {
            throw new IllegalArgumentException("Population must be at least 10");
        }
        Collections.sort(population, new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                return Integer.compare(p1.getScore(), p2.getScore());
            }
        });
        for (int i=0; i<5; i++) {
            population.remove(i);
        }
    }
    public void reproduceWinners() {
        for (int i=0; i<5; i++) {
            Player winner = population.get(population.size()-1-i);
            Player cloneWinner = clonePlayer(winner);
            population.add(cloneWinner);
        }
    }
    private Player clonePlayer(Player player) {
        if (player instanceof CheatPlayer) {
            CheatPlayer clone = new CheatPlayer("CheatPlayer");
            clone.score(player.getScore());
            return clone;
        } else if (player instanceof CooperatePlayer) {
            CooperatePlayer clone = new CooperatePlayer("CooperatePlayer");
            clone.score(player.getScore());
            return clone;
        } else if (player instanceof CopyCatPlayer) {
            CopyCatPlayer clone = new CopyCatPlayer("CopyCatPlayer");
            clone.score(player.getScore());
            return clone;
        } else if (player instanceof CopyKittenPlayer) {
            CopyKittenPlayer clone = new CopyKittenPlayer("CopyKittenPlayer");
            clone.score(player.getScore());
            return clone;
        } else if (player instanceof DetectivePlayer) {
            DetectivePlayer clone = new DetectivePlayer("DetectivePlayer");
            clone.score(player.getScore());
            return clone;
        } else if (player instanceof GrudgerPlayer) {
            GrudgerPlayer clone = new GrudgerPlayer("GrudgerPlayer");
            clone.score(player.getScore());
            return clone;
        }
        else {
            throw new IllegalArgumentException("Unknown player type");
        }
    }
    //create a getter for the population
    public List<Player> getPopulation() {
        return population;
    }
}
