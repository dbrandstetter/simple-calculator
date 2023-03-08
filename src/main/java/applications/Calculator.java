package applications;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.function.BinaryOperator;

/**
 * The Calculator class implements a JavaFX application and is used for simple
 * arithmetic calculations like addition, subtraction, multiplication, division,
 * modulus and power.
 *
 * @author David Brandstetter
 */
public class Calculator extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        // Init horizontal FlowPane
        GridPane display = new GridPane();

        // Create operational buttons
        Button buttonPlus = new Button();
        Button buttonMinus = new Button();
        Button buttonMult = new Button();
        Button buttonDiv = new Button();
        Button buttonMod = new Button();
        Button buttonPow = new Button();

        // Create label for result to be displayed
        TextField result = new TextField();

        // Create user input fields for numbers
        TextField input1 = new TextField();
        TextField input2 = new TextField();

        // Set placeholder text for the input
        input1.setPromptText("Enter num 1!");
        input2.setPromptText("Enter num 2!");

        // Declare gaps and alignment of element in FlowPane
        display.setHgap(15);
        display.setVgap(15);
        display.setAlignment(Pos.CENTER);
        display.setPadding(new Insets(10));

        // Style inputs and result with inline CSS
        input1.setStyle("-fx-background-color: cornsilk;-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre';-fx-start-margin: 10px; -fx-background-radius: 10px");
        input2.setStyle("-fx-background-color: cornsilk;-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre';-fx-start-margin: 10px; -fx-background-radius: 10px");
        result.setStyle("-fx-background-color: cornsilk;-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-radius: 10px");

        // Add text to buttons
        buttonPlus.setText("+ add +");
        buttonMinus.setText("- subtract -");
        buttonMult.setText("* multiply *");
        buttonDiv.setText(": divide :");
        buttonMod.setText("% modulo %");
        buttonPow.setText("^ power ^");

        // Style buttons with inline CSS
        buttonPlus.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
        buttonMinus.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
        buttonMult.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
        buttonDiv.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
        buttonMod.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
        buttonPow.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");

        // Make result field not editable
        result.setEditable(false);

        // Add all element to be displayed to the FlowPane in correct order
        display.add(input1, 0, 0);
        display.add(input2, 1, 0);
        display.add(result, 0, 1, 2, 3);
        display.add(buttonPlus, 0, 4);
        display.add(buttonMinus, 1, 4);
        display.add(buttonMult, 0, 5);
        display.add(buttonDiv, 1, 5);
        display.add(buttonMod, 0, 6);
        display.add(buttonPow, 1, 6);

        // Create group and scene with background color
        Scene primaryScene = new Scene(display, 400, 500);
        primaryScene.setFill(Color.DIMGREY);
        display.setStyle("-fx-background-color: dimgrey");

        // Configure stage settings
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Calculator");

        // Get screen bounds
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        // Configure stage information
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(400);

        // Set a dynamic size to the elements to make them expand and shrink
        input1.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight());
        input2.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight());
        result.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight());
        buttonPlus.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight());
        buttonMinus.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight());
        buttonMult.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight());
        buttonDiv.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight());
        buttonMod.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight());
        buttonPow.setPrefSize(screenBounds.getWidth(), screenBounds.getHeight());

        // Add event listeners to buttons
        buttonPlus.setOnAction(actionEvent -> {
            try {
                double num1 = Double.parseDouble(input1.getText());
                double num2 = Double.parseDouble(input2.getText());
                result.setText("    " + (num1 + num2));
            } catch (Exception e) {
                result.setText("Please enter valid numbers!");
            }

            // Mark this button as clicked and reset others
            buttonPlus.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #c06400; -fx-background-radius: 10px");
            buttonMinus.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonMult.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonDiv.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonMod.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonPow.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
        });

        buttonMinus.setOnAction(actionEvent -> {
            try {
                double num1 = Double.parseDouble(input1.getText());
                double num2 = Double.parseDouble(input2.getText());
                result.setText("    " + (num1 - num2));
            } catch (Exception e) {
                result.setText("Please enter valid numbers!");
            }

            // Mark this button as clicked and reset others
            buttonPlus.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonMinus.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #c06400; -fx-background-radius: 10px");
            buttonMult.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonDiv.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonMod.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonPow.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
        });

        buttonMult.setOnAction(actionEvent -> {
            try {
                double num1 = Double.parseDouble(input1.getText());
                double num2 = Double.parseDouble(input2.getText());
                result.setText("    " + (num1 * num2));
            } catch (Exception e) {
                result.setText("Please enter valid numbers!");
            }

            // Mark this button as clicked and reset others
            buttonPlus.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonMinus.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonMult.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #c06400; -fx-background-radius: 10px");
            buttonDiv.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonMod.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonPow.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
        });

        buttonDiv.setOnAction(actionEvent -> {
            try {
                double num1 = Double.parseDouble(input1.getText());
                double num2 = Double.parseDouble(input2.getText());
                result.setText("    " + (num1 /  num2));
            } catch (Exception e) {
                result.setText("Please enter valid numbers!");
            }

            // Mark this button as clicked and reset others
            buttonPlus.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonMinus.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonMult.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonDiv.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #c06400; -fx-background-radius: 10px");
            buttonMod.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonPow.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
        });

        buttonMod.setOnAction(actionEvent -> {
            try {
                double num1 = Double.parseDouble(input1.getText());
                double num2 = Double.parseDouble(input2.getText());
                result.setText("    " + (num1 % num2));
            } catch (Exception e) {
                result.setText("Please enter valid numbers!");
            }

            // Mark this button as clicked and reset others
            buttonPlus.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonMinus.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonMult.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonDiv.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonMod.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #c06400; -fx-background-radius: 10px");
            buttonPow.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
        });

        buttonPow.setOnAction(actionEvent -> {
            try {
                double num1 = Double.parseDouble(input1.getText());
                double num2 = Double.parseDouble(input2.getText());
                result.setText("    " + Math.pow(num1, num2));
            } catch (Exception e) {
                result.setText("Please enter valid numbers!");
            }

            // Mark this button as clicked and reset others
            buttonPlus.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonMinus.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonMult.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonDiv.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonMod.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #FF8C00; -fx-background-radius: 10px");
            buttonPow.setStyle("-fx-font-size:20;-fx-font-family:'DejaVu Math TeX Gyre'; -fx-background-color: #c06400; -fx-background-radius: 10px");
        });

        // Show stage and create window
        primaryStage.show();
    }
}