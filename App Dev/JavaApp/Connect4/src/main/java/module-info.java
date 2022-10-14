module com.internshala.connectfour.connect4 {
	requires javafx.controls;
	requires javafx.fxml;


	opens com.internshala.connectfour.connect4 to javafx.fxml;
	exports com.internshala.connectfour.connect4;
}