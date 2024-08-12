package io.github.burymydeadhoreses;

public class Main {
    private static final int iterations = 1000;

    public static void main(String[] args) {

        var games = new GameProvider(iterations);

        var switchResults = games.getSwitchResult();
        var noSwitchResults = games.getNoSwitchResult();

        System.out.println("Total games: " + iterations);

        System.out.println();

        System.out.println("Wins with switch: " +
                switchResults.values().stream().filter(result -> result).count());

        System.out.println("Loses with switch: " +
                switchResults.values().stream().filter(result -> !result).count());

        System.out.println();

        System.out.println("Wins without switch: " +
                noSwitchResults.values().stream().filter(result -> result).count());

        System.out.println("Loses without switch: " +
                noSwitchResults.values().stream().filter(result -> !result).count());
    }
}