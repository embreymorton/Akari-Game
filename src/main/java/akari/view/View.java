package akari.view;

import akari.model.Model;
import akari.model.ModelObserver;
import akari.controller.ControllerImpl;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class View implements ModelObserver, FXComponent {

  private ControllerImpl controller;
  private Stage stage;

  public View(ControllerImpl controller, Stage stage) {
    this.controller = controller;
    this.stage = stage;
    controller.addModelObserver(this);
  }

  @Override
  public Parent render() {
    VBox layout = new VBox();
    PuzzleView puzzle = new PuzzleView(controller);
    ControlView control = new ControlView(controller);
    MessageView message = new MessageView(controller);

    layout.setPrefHeight(750);
    layout.setPrefWidth(750);
    layout.setSpacing(25);

    HBox space = new HBox();
    space.setPrefHeight(10);

    layout.getChildren().add(space);
    layout.getChildren().add(control.render());
    layout.getChildren().add(message.render());
    layout.getChildren().add(puzzle.render());

    return layout;
  }

  @Override
  public void update(Model model) {
    Scene scene = new Scene(render());
    scene.getStylesheets().add("main.css");
    stage.setScene(scene);
  }
}
