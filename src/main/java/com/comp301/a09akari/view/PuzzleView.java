package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.ControllerImpl;
import com.comp301.a09akari.model.CellType;
import com.comp301.a09akari.model.Puzzle;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class PuzzleView implements FXComponent {
  private ControllerImpl controller;
  private Puzzle activePuzzle;
  private int rows;
  private int columns;

  public PuzzleView(ControllerImpl controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    GridPane grid = new GridPane();
    grid.setHgap(2);
    grid.setVgap(2);
    activePuzzle = controller.getActivePuzzle();
    rows = activePuzzle.getHeight();
    columns = activePuzzle.getWidth();
    Image legalBulb = new Image("legal-light-bulb.png");
    Image illegalBulb = new Image("illegal-light-bulb.png");

    Button button;
    Rectangle rectangle;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < columns; c++) {
        if (activePuzzle.getCellType(r, c) == CellType.CLUE) {
          button = new Button(String.valueOf(activePuzzle.getClue(r, c)));
          button.setPrefSize(50, 50);
          if (controller.isClueSatisfied(r, c)) button.getStyleClass().add("solved-clue-button");
          else button.getStyleClass().add("clue-button");
          button.setDisable(true);
          button.setOpacity(1);
          grid.add(button, c, r);
        } else if (activePuzzle.getCellType(r, c) == CellType.WALL) {
          button = new Button();
          button.setPrefSize(50, 50);
          button.getStyleClass().add("wall-button");
          button.setDisable(true);
          button.setOpacity(1);
          grid.add(button, c, r);
        } else {
          button = new Button();
          button.setPrefSize(50, 50);

          if (controller.isLit(r, c)) button.getStyleClass().add("lit-corridor-button");
          else button.getStyleClass().add("corridor-button");

          if (controller.isLamp(r, c)) {
            ImageView bulbView;
            if (controller.isLampIllegal(r, c)) bulbView = new ImageView(illegalBulb);
            else bulbView = new ImageView(legalBulb);
            bulbView.setFitHeight(button.getPrefHeight() - 18);
            bulbView.setFitWidth(button.getPrefWidth() - 18);
            button.setGraphic(bulbView);
          }

          int R = r;
          int C = c;
          button.setOnAction(
              (ActionEvent e) -> {
                int row = R;
                int col = C;
                controller.clickCell(row, col);
              });
          grid.add(button, c, r);
        }
      }
    }

    HBox layout = new HBox();
    layout.getChildren().add(grid);
    layout.setAlignment(Pos.CENTER);

    return layout;
  }
}
