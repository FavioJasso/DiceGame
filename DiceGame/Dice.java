package DiceGame;

import java.util.Random;
//defines a class named Dice that implements the DiceGameInterface interface.
//private instance variable named random of type Random, which is used for generating random numbers.
public class Dice implements DiceGameInterface {
    private Random random = new Random();
//provides the implementation for the roll method specified in the DiceGameInterface
//the roll method uses the Random object (random) to generate a random integer between 0 (inclusive) and 6 (exclusive) using nextInt(6)
    public int roll() {
        return random.nextInt(6) + 1;
    }
}