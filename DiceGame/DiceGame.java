package DiceGame;

import DiceGame.Dice;
import DiceGame.GameLogic;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.util.Random;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
/*
Author : Favio Valentino Jasso
For : Prof. Stoll
12.8.2023
Final Project - Dice Game
*/

public class DiceGame extends Application {
    //reference variables
    private Dice dice = new Dice();
    private GameLogic gameLogic = new GameLogic(dice);
    private ImageView diceImage;
    private TextField guessInput;
    private Label messageLabel;
    private Random random = new Random();

// initial stage for a "Dice Game."  
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Dice Game");
//This creates an array of six Image objects, each representing a different side of a die, by loading corresponding image files from the "resources" directory.
        Image[] diceImages = new Image[6];
        try {
            for (int i = 0; i < 6; i++) {
                diceImages[i] = new Image(new FileInputStream("resources/"+(i + 1) + ".png"));
            }
      //If there's an exception during this process, it prints the stack trace and exits the method.
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
//It creates an ImageView named diceImage and initializes it with the first image 
        diceImage = new ImageView(diceImages[0]);
        diceImage.setFitHeight(100);
        diceImage.setFitWidth(100);
//It creates a TextField named guessInput.
        guessInput = new TextField();
        guessInput.setPromptText("Guess a number between 1 and 6");
        guessInput.setMaxWidth(100);
//It creates a Button named rollButton with the label "Roll Dice."
//on action, it animates the roll. 
        Button rollButton = new Button("Roll Dice");
        rollButton.setOnAction(e -> animateRoll(diceImages));
        //creates new quit button
        //when button is clicked, it quits application 
        Button quitButton = new Button("Quit");
        quitButton.setOnAction(e -> primaryStage.close());
        
//new message label.  
        messageLabel = new Label("Guess a number between 1 and 6");

//new vbox, named layout. 
//centers that vbox
        VBox layout = new VBox(10, diceImage, guessInput, rollButton, quitButton, messageLabel);
        layout.setAlignment(Pos.CENTER);
        
        //creates new scene 
        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
//@param image, dice images
//@return 
//retrieves the text from the guessInput, and assigns it to the guess string variable.
//attempts to convert the guess string to an integer (guessValue) using Integer.parseInt(guess).
//If the conversion is successful, it checks whether the guessValue is between 1 and 6 (inclusive). If not, it throws a NumberFormatException.
//If there's an exception (either during the conversion or if the value is outside the valid range), it catches the NumberFormatException and shows an alert with an error message.
    private void animateRoll(Image[] diceImages) {
        String guess = guessInput.getText();
        int guessValue;
        try {
            guessValue = Integer.parseInt(guess);
            if (guessValue < 1 || guessValue > 6) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            showAlert("Error", "Enter a number between 1 and 6");
            return;
        }
        //Using javafx.application.Platform.runLater(), it updates the diceImage in the JavaFX application thread to display the newly selected diceFrame.
        //It pauses the thread for 100 milliseconds using Thread.sleep(100) to create a visual delay in the animation.
        Thread animationThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    int index = random.nextInt(6);
                    Image diceFrame = diceImages[index];
                    javafx.application.Platform.runLater(() -> diceImage.setImage(diceFrame));
                    Thread.sleep(100);
                    
                }
//It checks if the guessed value (guessValue) is equal to the rolled result. 
//If match, it sets the text of the messageLabel to "You guessed right!" and calls the celebrate() method.
//if not, it sets to the text to "sorry, it was X result"
                int result = gameLogic.roll();
                javafx.application.Platform.runLater(() -> {
                    diceImage.setImage(diceImages[result - 1]);
                    if (guessValue==result) {
                        messageLabel.setText("You guessed right!");
                        celebrate();
                    } else {
                        messageLabel.setText("Sorry, it was " + result);
                    }
                });
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        animationThread.start();
    }

   private void celebrate() {
    // Define an array of colors for celebration
    Color[] colors = new Color[]{
        Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.PINK, Color.PURPLE
    };

    // Create a new thread for the celebration animation to avoid blocking the UI thread
    new Thread(() -> {
        try {
            for (Color color : colors) {
                // Update the label color on the JavaFX Application Thread
                javafx.application.Platform.runLater(() -> messageLabel.setTextFill(color));
                // Pause to make the color change visible
                Thread.sleep(400); // Duration in milliseconds
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        // Reset to default color (optional)
        javafx.application.Platform.runLater(() -> messageLabel.setTextFill(Color.BLACK));
    }).start();
}
//@param string title & message 
//it creates an instance of the Alert class with the type ERROR.
//It sets the content text of the alert to the specified message.
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
//main
    public static void main(String[] args) {
        launch(args);
    }
}
