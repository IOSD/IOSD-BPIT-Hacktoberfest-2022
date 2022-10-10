package com.internshala.connectfour.connect4;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Controller implements Initializable {

	private static final int COLUMNS =7;
	private static final int ROWS = 6;
	private static final int CIRCLE_DIAMETER = 80;
	private static final String disColor1 = "#24303E";
	private static final String disColor2 = "#4CAA88";

	private static String PLAYER_ONE = "Player 1";
	private static String PLAYER_TWO = "Player 2";

	private boolean isPlayerOneTurn = true;

	private final Disc[][] insertedDiscsArray = new Disc[ROWS][COLUMNS];

	@FXML
	public GridPane rootGridPane;

	@FXML
	public Pane insertedDiscPane;

	@FXML
	public Label playerNameLabel;

	@FXML
	public TextField playerOneTextField, playerTwoTextField;

	@FXML
	public Button setNamesButton;

	private boolean isAllowedToInsert = true;

	public void createPlayground() {

		Shape rectangleWithHoles = createStructuralGrid();
		rootGridPane.add(rectangleWithHoles, 0, 1);

		List<Rectangle> rectangleList = createClickableColumns();

		for (Rectangle rectangle : rectangleList) {
			rootGridPane.add(rectangle, 0, 1);
		}

		setNamesButton.setOnAction(actionEvent -> {
			if (playerOneTextField.getText().equals("")) {
				playerOneTextField.setText("Player 1");
			} else {
				PLAYER_ONE = playerOneTextField.getText();
			}
			if (playerTwoTextField.getText().equals("")) {
				playerTwoTextField.setText("Player 2");
			} else {
				PLAYER_TWO = playerTwoTextField.getText();
			}
			PLAYER_ONE = PLAYER_ONE.substring(0,1).toUpperCase() + PLAYER_ONE.substring(1).toLowerCase();
			PLAYER_TWO = PLAYER_TWO.substring(0,1).toUpperCase() + PLAYER_TWO.substring(1).toLowerCase();
			resetGame();
			playerNameLabel.setText(PLAYER_ONE + "'s");
		});
	}

	private Shape createStructuralGrid() {

		Shape rectangleWithHoles = new Rectangle((COLUMNS + 1) * CIRCLE_DIAMETER, (ROWS + 1) * CIRCLE_DIAMETER);

		for (int row = 0; row < ROWS; ++row) {

			for (int col = 0; col < COLUMNS; ++col) {

				Circle circle = new Circle();
				circle.setRadius((float)CIRCLE_DIAMETER / 2);
				circle.setCenterX((float)CIRCLE_DIAMETER / 2);
				circle.setCenterY((float)CIRCLE_DIAMETER / 2);
				circle.setSmooth(true);

				circle.setTranslateX(col * (CIRCLE_DIAMETER + 5) + (float)CIRCLE_DIAMETER / 4);
				circle.setTranslateY(row * (CIRCLE_DIAMETER + 5) + (float)CIRCLE_DIAMETER / 4);
				rectangleWithHoles = Shape.subtract(rectangleWithHoles, circle);
			}
		}

		rectangleWithHoles.setFill(Color.WHITE);

		return rectangleWithHoles;
	}

	private List<Rectangle> createClickableColumns() {

		List<Rectangle> rectangleList = new ArrayList<>();

		for (int col = 0; col < COLUMNS; ++col) {

			Rectangle rectangle = new Rectangle(CIRCLE_DIAMETER, (ROWS + 1) * CIRCLE_DIAMETER);
			rectangle.setFill(Color.TRANSPARENT);
			rectangle.setTranslateX(col * (CIRCLE_DIAMETER + 5) + (float) CIRCLE_DIAMETER / 4);

			rectangle.setOnMouseEntered(actionEvent -> rectangle.setFill(Color.valueOf("#bebebe26")));
			rectangle.setOnMouseExited(actionEvent -> rectangle.setFill(Color.TRANSPARENT));

			final int column = col;
			rectangle.setOnMouseClicked(actionEvent -> {
				if (isAllowedToInsert) {
					isAllowedToInsert = false;
					insertDisc(new Disc(isPlayerOneTurn), column);
				}
			});
			rectangleList.add(rectangle);
		}

		return rectangleList;
	}

	private void insertDisc(Disc disc, int column) {

		int row = ROWS - 1;
		while (row >= 0) {
			if (getDiscIfPresent(row, column) == null) {
				break;
			}
			row--;
		}
		if (row < 0) {
			return;
		}

		insertedDiscsArray[row][column] = disc;
		insertedDiscPane.getChildren().add(disc);

		disc.setTranslateX(column * (CIRCLE_DIAMETER + 5) + (float) CIRCLE_DIAMETER / 4);

		int currentRow = row;
		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), disc);
		translateTransition.setToY(row * (CIRCLE_DIAMETER + 5) + (float)CIRCLE_DIAMETER / 4);
		translateTransition.setOnFinished(actionEvent -> {

			isAllowedToInsert = true;
			if (gameEnded(currentRow, column)) {
				gameOver();
				return;
			}

			isPlayerOneTurn = !isPlayerOneTurn;
			playerNameLabel.setText((isPlayerOneTurn? PLAYER_ONE: PLAYER_TWO) + "'s");
		});
		translateTransition.play();
	}

	private boolean gameEnded(int row, int column) {

		List<Point2D> verticalPoints = IntStream.rangeClosed(row - 3, row +3)
				.mapToObj(r -> new Point2D(r, column))
				.collect(Collectors.toList());

		List<Point2D> horizontalPoints = IntStream.rangeClosed(column - 3, column +3)
				.mapToObj(col -> new Point2D(row, col))
				.collect(Collectors.toList());

		Point2D startPoint1 = new Point2D(row-3, column+3);
		List<Point2D> diagonal1Points = IntStream.rangeClosed(0, 6)
				.mapToObj(i -> startPoint1.add(i, -i))
				.collect(Collectors.toList());

		Point2D startPoint2 = new Point2D(row-3, column-3);
		List<Point2D> diagonal2Points = IntStream.rangeClosed(0, 6)
				.mapToObj(i -> startPoint2.add(i, i))
				.collect(Collectors.toList());

		return checkCombinations(verticalPoints) || checkCombinations(horizontalPoints)
				|| checkCombinations(diagonal1Points) || checkCombinations(diagonal2Points);
	}

	private boolean checkCombinations(List<Point2D> points) {

		int chain = 0;

		for (Point2D point: points) {

			int rowIndexForArray = (int) point.getX();
			int columnIndexForArray = (int) point.getY();

			Disc disc = getDiscIfPresent(rowIndexForArray, columnIndexForArray);

			if (disc != null && disc.isPlayerOneMove == isPlayerOneTurn) {

				chain++;
				if (chain == 4) {
					return true;
				}
			} else {
				chain = 0;
			}
		}
		return false;
	}

	private Disc getDiscIfPresent( int row, int column) {
		if (row >= ROWS || row < 0 || column >= COLUMNS || column < 0) {
			return null;
		}
		return insertedDiscsArray[row][column];
	}

	private void gameOver() {
		String winner = isPlayerOneTurn? PLAYER_ONE: PLAYER_TWO;
		System.out.println("Winner is " + winner);

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Connect Four");
		alert.setHeaderText("The Winner is " + winner + ".");
		alert.setContentText("Want to play again?");

		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No, Exit");
		alert.getButtonTypes().setAll(yesBtn, noBtn);

		Platform.runLater(() -> {
			Optional<ButtonType> btnClicked = alert.showAndWait();
			if (btnClicked.isPresent() && btnClicked.get() == yesBtn) {
				resetGame();
			} else {
				Platform.exit();
				System.exit(0);
			}
		});
	}

	public void resetGame() {
		insertedDiscPane.getChildren().clear();
		for (Disc[] discs : insertedDiscsArray) {

			Arrays.fill(discs, null);
		}
		isPlayerOneTurn = true;
		playerNameLabel.setText(PLAYER_ONE + "'s");
		createPlayground();
	}

	private static class Disc extends Circle {

		private final boolean isPlayerOneMove;
		public Disc(boolean isPlayerOneMove) {

			this.isPlayerOneMove = isPlayerOneMove;
			setRadius((float)CIRCLE_DIAMETER / 2);
			setFill(isPlayerOneMove? Color.valueOf(disColor1): Color.valueOf(disColor2));
			setCenterX((float)CIRCLE_DIAMETER / 2);
			setCenterY((float)CIRCLE_DIAMETER / 2);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

	}
}