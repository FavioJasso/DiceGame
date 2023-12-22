# DiceGame
**Overview**

This project was made as my Final Project in my Computer Science 2 course at County College of Morris. The Dice Game is a JavaFX application that simulates rolling a six-sided die. The user can make a guess about the outcome of the die roll, and the application provides feedback on whether the guess is correct. The program includes classes for the dice, game logic, and the main application.

**Dice Game Documentation**

**Author : Favio Valentino Jasso**

**For : Professor Stephen Stoll**

**Computer Science 2 Final Project - Dice Game**


**Classes**

**1. Dice**

The **Dice** class implements the DiceGameInterface and represents a six-sided die. It generates random numbers between 1 and 6.

Methods:

- **roll(): int**: Generates a random number representing the result of a die roll.

**2. GameLogic**

The **GameLogic** class extends the Dice class and handles the game logic. It checks whether the user's guess matches the result of rolling the die.

Fields:

- **dice: Dice** : An instance of the **Dice** class used for rolling the dice.

Methods:

- **GameLogic(dice: Dice)**: Constructor that takes a **Dice** object as a parameter.
- **checkGuess(guess: int): boolean**: Checks if the provided guess matches the result of rolling the dice.
- **rollDice(): int**: Rolls the dice and returns the result.

**3. DiceGame (Main Application Class)**

The **DiceGame** class is the main application class that extends **Application** and manages the user interface and game flow.

Fields:

- **dice: Dice** : An instance of the **Dice** class for handling dice rolling.
- **gameLogic: GameLogic** : An instance of the **GameLogic** class for managing game logic.
- **diceImage: ImageView** : An image view to display the dice images.
- **guessInput: TextField** : Text field for user input (guess).
- **messageLabel: Label** : Label for displaying messages to the user.
- **random: Random** : A **Random** object for generating random numbers.

Methods:

- **start(primaryStage: Stage): void**: Overridden method from **Application** that sets up the JavaFX stage and scene.
- **animateRoll(diceImages: Image[]): void**: Animates the rolling of the dice and updates the UI.
- **celebrate(): void**: Performs a celebratory animation when the user's guess is correct.
- **showAlert(title: String, message: String): void**: Displays an alert dialog for error messages.
- **main(args: String[]): void**: The main entry point of the application.

**4. DiceGameInterface**

The **DiceGameInterface** class is an interface defining the contract for a dice game. It includes a method for rolling the die.

- **roll(): int**: Declares the method for rolling the die.

**UI Components**

- **VBox layout** : Vertical box layout containing UI components.
- **Button rollButton** : Button for triggering the dice roll.
- **Image[] diceImages**: Array of **Image** objects representing the six faces of a die.
- **ImageView diceImage** : Displays the image of the rolled die.
- **TextField guessInput** : Allows users to input their guesses.
- **Button quitButton** : Closes the application.
- **Label messageLabel:** Displays game messages.

**Execution Flow**

1. The application starts by creating an instance of the **Dice** class and a corresponding **GameLogic** object.
2. JavaFX UI components are initialized, including the stage, scene, image views, text fields, buttons, and labels.
3. When the user clicks the "Roll Dice" button, the **animateRoll** method is called, which animates the dice roll and updates the UI accordingly.
4. If the user's guess is correct, a celebratory animation is triggered using the **celebrate** method.
5. Error messages are displayed using the **showAlert** method in case of invalid user input.
6. The DiceGameInterface is used to define the contract for a dice game, declaring the roll() method.
7. The application can be executed by running the **main** method.

**Dependencies**

- JavaFX library for building the graphical user interface.
- Java Standard Library for general functionality, file operations, and threading.

**Conclusion**

The Dice Game is a simple and interactive JavaFX application that demonstrates basic user input, dice rolling, and game logic. The code structure follows a modular design, separating concerns between the **Dice** , **GameLogic** , and **DiceGame** classes. The use of JavaFX components provides a visually appealing interface for the user to interact with the game.

![](RackMultipart20231222-1-nke4x6_html_92774c971b786a48.png)
