module com.internshala.javafxapp {
	requires javafx.controls;
	requires javafx.fxml;


	opens com.internshala.javafxapp to javafx.fxml;
	exports com.internshala.javafxapp;
}