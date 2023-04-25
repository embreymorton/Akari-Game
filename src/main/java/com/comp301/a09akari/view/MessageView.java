package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.ControllerImpl;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class MessageView implements FXComponent {
  private ControllerImpl controller;

  public MessageView(ControllerImpl controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    HBox box = new HBox();
    Label label = new Label();

    if (controller.isSolved()) label.setText("SUCCESS");
    box.getChildren().add(label);
    label.getStyleClass().add("success-label");

    box.setAlignment(Pos.CENTER);
    return box;
  }
}
