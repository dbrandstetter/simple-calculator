package applications;

import javafx.application.Application;
import javafx.css.PseudoClass;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
		FlowPane display = new FlowPane(Orientation.HORIZONTAL);

		// Create operational buttons
		Button buttonPlus = new Button();
		Button buttonMinus = new Button();
		Button buttonMult = new Button();
		Button buttonDiv = new Button();
		Button buttonMod = new Button();
		Button buttonPow = new Button();

		// Create label for result to be displayed
		Label result = new Label();

		// Create user input fields for numbers
		TextField input1 = new TextField();
		TextField input2 = new TextField();

		// Set a fixed height to the inputs so thy don't expand
		input1.setMaxWidth(395);
		input2.setMaxWidth(395);
		input1.setMaxHeight(80);
		input2.setMaxHeight(80);
		input1.setMinWidth(395);
		input2.setMinWidth(395);
		input1.setMinHeight(80);
		input2.setMinHeight(80);
		input1.setPrefWidth(Region.USE_COMPUTED_SIZE);
		input2.setPrefWidth(Region.USE_COMPUTED_SIZE);
		input1.setPrefHeight(Region.USE_COMPUTED_SIZE);
		input2.setPrefHeight(Region.USE_COMPUTED_SIZE);

		// Set placeholder text for the input
		input1.setPromptText("Enter num 1!");
		input2.setPromptText("Enter num 2!");

		// Set size for result label
		result.setPrefWidth(800);
		result.setPrefHeight(80);

		// Declare gaps and alignment of element in FlowPane
		display.setHgap(10);
		display.setVgap(10);
		display.setAlignment(Pos.CENTER);

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

		// Set size of buttons
		buttonPlus.setPrefWidth(395);
		buttonMinus.setPrefWidth(395);
		buttonMult.setPrefWidth(395);
		buttonDiv.setPrefWidth(395);
		buttonMod.setPrefWidth(395);
		buttonPow.setPrefWidth(395);
		buttonPlus.setPrefHeight(100);
		buttonMinus.setPrefHeight(100);
		buttonMult.setPrefHeight(100);
		buttonDiv.setPrefHeight(100);
		buttonMod.setPrefHeight(100);
		buttonPow.setPrefHeight(100);

		// Add all element to be displayed to the FlowPane in correct order
		display.getChildren().addAll(input1, input2, result, buttonPlus, buttonMinus, buttonMult, buttonDiv, buttonMod, buttonPow);

		// Create group and scene with background color
		Group primaryGroup = new Group(display);
		Scene primaryScene = new Scene(primaryGroup);
		primaryScene.setFill(Color.DIMGREY);

		// Configure stage settings
		primaryStage.setScene(primaryScene);
		primaryStage.setTitle("Calculator");
		primaryStage.setMinWidth(800);
		primaryStage.setMinHeight(540);
		primaryStage.setMaxWidth(800);
		primaryStage.setMaxHeight(540);

		// Add event listeners to buttons
		buttonPlus.setOnAction(actionEvent -> {
			try {
				double num1 = Double.parseDouble(input1.getText());
				double num2 = Double.parseDouble(input2.getText());
				double sum = num1 + num2;
				result.setText("    " + sum);
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
				double difference = num1 - num2;
				result.setText("    " + difference);
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
				double product = num1 * num2;
				result.setText("    " + product);
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
				double quotient = num1 / num2;
				result.setText("    " + quotient);
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
				double remainder = num1 % num2;
				result.setText("    " + remainder);
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
				double potency = Math.pow(num1, num2);
				result.setText("    " + potency);
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