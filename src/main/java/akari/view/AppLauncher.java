package akari.view;

import akari.SamplePuzzles;
import akari.model.*;
import akari.controller.ControllerImpl;
import javafx.application.Application;
import javafx.stage.Stage;

public class AppLauncher extends Application {
  @Override
  public void start(Stage stage) {
    // TODO: Create your Model, View, and Controller instances and launch your GUI

    stage.setTitle("PLAY AKARI");

    PuzzleLibrary library = new PuzzleLibraryImpl();
    Puzzle p1 = new PuzzleImpl(SamplePuzzles.PUZZLE_01);
    Puzzle p2 = new PuzzleImpl(SamplePuzzles.PUZZLE_02);
    Puzzle p3 = new PuzzleImpl(SamplePuzzles.PUZZLE_03);
    Puzzle p4 = new PuzzleImpl(SamplePuzzles.PUZZLE_04);
    Puzzle p5 = new PuzzleImpl(SamplePuzzles.PUZZLE_05);

    library.addPuzzle(p1);
    library.addPuzzle(p2);
    library.addPuzzle(p3);
    library.addPuzzle(p4);
    library.addPuzzle(p5);

    ModelImpl puzzle = new ModelImpl(library);
    ControllerImpl controller = new ControllerImpl(puzzle);
    View view = new View(controller, stage);

    view.update(puzzle);

    stage.show();
  }
}
