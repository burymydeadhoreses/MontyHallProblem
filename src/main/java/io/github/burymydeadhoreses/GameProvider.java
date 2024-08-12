package io.github.burymydeadhoreses;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Getter
public class GameProvider {
    private static final Random random = new Random();

    private final Map<Integer, Boolean> switchResult = new HashMap<>();
    private final Map<Integer, Boolean> noSwitchResult = new HashMap<>();

    /**
    * Creates a GameProvider class with results of played games
    * <p>
    * This class represents Monty Hall problem statistic
    * proving concept of more win chances with door switching
    *
    * @param  iterations  how many games it will play
    */
    public GameProvider(int iterations) {
        for (int i = 0; i < iterations; i++) {
            boolean winWithSwitch = run(true);
            boolean winWithoutSwitch = run(false);

            switchResult.put(i, winWithSwitch);
            noSwitchResult.put(i, winWithoutSwitch);
        }
    }

    private static boolean run(boolean switchDoor) {
        int carDoor = random.nextInt(3);
        int chosenDoor = random.nextInt(3);
        int revealedDoor;

        do {
            revealedDoor = random.nextInt(3);
        } while (revealedDoor == carDoor || revealedDoor == chosenDoor);

        if (switchDoor)
            chosenDoor = 3 - chosenDoor - revealedDoor;

        return chosenDoor == carDoor;
    }
}
