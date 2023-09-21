package akari.view;

import akari.controller.ControllerImpl;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ControlView implements FXComponent {
  private ControllerImpl controller;

  public ControlView(ControllerImpl controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {

    HBox controlBox = new HBox();

    Button prev = new Button("Previous");
    controlBox.getChildren().add(prev);
    prev.getStyleClass().add("control-button");
    prev.setOnAction(
        (ActionEvent e) -> {
          controller.clickPrevPuzzle();
        });

    Button next = new Button("Next");
    controlBox.getChildren().add(next);
    next.getStyleClass().add("control-button");
    next.setOnAction(
        (ActionEvent e) -> {
          controller.clickNextPuzzle();
        });

    Button rand = new Button("Random");
    controlBox.getChildren().add(rand);
    rand.getStyleClass().add("control-button");
    rand.setOnAction(
        (ActionEvent e) -> {
          controller.clickRandPuzzle();
        });

    Button reset = new Button("Reset");
    controlBox.getChildren().add(reset);
    reset.getStyleClass().add("control-button");
    reset.setOnAction(
        (ActionEvent e) -> {
          controller.clickResetPuzzle();
        });

    Label puzzleNumber =
        new Label(
            "Puzzle "
                + (controller.getActivePuzzleIndex() + 1)
                + " of "
                + controller.getPuzzleLibrarySize());
    puzzleNumber.getStyleClass().add("puzzle-number");

    controlBox.setSpacing(10);
    HBox box = new HBox();
    box.getChildren().add(puzzleNumber);
    box.getChildren().add(controlBox);
    box.setSpacing(50);
    box.setAlignment(Pos.CENTER);
    return box;
  }
}
