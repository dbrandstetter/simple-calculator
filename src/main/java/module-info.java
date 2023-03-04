module applications.calculator {
	requires javafx.controls;
	requires javafx.fxml;


	opens applications to javafx.fxml;
	exports applications;
}