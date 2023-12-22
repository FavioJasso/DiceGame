package DiceGame;
//inherits from Dice Class
//private instance variable dice of type Dice
public class GameLogic extends Dice{
    private Dice dice;
//@param dice
//this.dice, indicating that the GameLogic class is initialized with a specific Dice object
    public GameLogic(Dice dice) {
        this.dice = dice;
    }
//@param int guess
// returns true if the guess is equal to the rollResult, otherwise, it returns false
    public boolean checkGuess(int guess) {
        int rollResult = dice.roll();
        return guess == rollResult;
    }
//@return dice.roll
    public int roll() {
        return dice.roll();
    }
}