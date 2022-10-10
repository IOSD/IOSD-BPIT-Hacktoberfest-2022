package com.internshala.connectfour.connect4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

	private Controller controller;

	@Override
	public void start(Stage primaryStage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("game.fxml"));
		GridPane rootGridPane = fxmlLoader.load();

		Scene scene = new Scene(rootGridPane);

		controller = fxmlLoader.getController();
		controller.createPlayground();

		MenuBar menuBar = createMenu();
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

		Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
		menuPane.getChildren().add(menuBar);

		primaryStage.setTitle("Connect 4");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	private MenuBar createMenu() {

		Menu fileMenu = new Menu("File");
		MenuItem newGame = new MenuItem("New Game");
		newGame.setOnAction(actionEvent -> controller.resetGame());

		MenuItem resetGame = new MenuItem("Reset Game");
		resetGame.setOnAction(actionEvent -> controller.resetGame());

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem exitGame = new MenuItem("Exit Game");
		exitGame.setOnAction(actionEvent -> exitGame());

		fileMenu.getItems().addAll(newGame, resetGame, separatorMenuItem, exitGame);

		Menu helpMenu = new Menu("Help");
		MenuItem aboutGame = new MenuItem("About Connect4");
		aboutGame.setOnAction(actionEvent -> aboutConnect4());

		SeparatorMenuItem separator = new SeparatorMenuItem();
		MenuItem aboutMe = new MenuItem("About Me");
		aboutMe.setOnAction(actionEvent -> aboutMe());

		helpMenu.getItems().addAll(aboutGame, separator, aboutMe);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		return menuBar;
	}

	private void aboutMe() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About The Developer");
		alert.setHeaderText("Keshav Garg");
		alert.setContentText("I love to play around with code and create games. Connect 4 is one of them. In free time I like to spend time with nears and dears.");
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		alert.show();
	}

	private void aboutConnect4() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About Connect Four");
		alert.setHeaderText("How To Play?");
		alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs. The pieces fall straight down, occupying the next available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of the one's own discs. Connect Four is a solved game. The first player can always win by playing the right moves.");
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		alert.show();
	}

	private void exitGame() {
		Platform.exit();
		System.exit(0);
	}

	public static void main(String[] args) {
		launch(args);
	}
}