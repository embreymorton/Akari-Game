package com.comp301.a09akari;

import com.comp301.a09akari.model.*;
import com.comp301.a09akari.view.AppLauncher;
import javafx.application.Application;

public class Main {
  public static void main(String[] args) {
    Application.launch(AppLauncher.class);

    //    int[][] pzl = {
    //      {6, 1, 6},
    //      {6, 6, 6},
    //      {6, 6, 6},
    //    };
    //
    //    Puzzle p0 = new PuzzleImpl(pzl);
    //    Puzzle p1 = new PuzzleImpl(SamplePuzzles.PUZZLE_01);
    //    Puzzle p2 = new PuzzleImpl(SamplePuzzles.PUZZLE_05);
    //
    //    PuzzleLibrary library = new PuzzleLibraryImpl();
    //    library.addPuzzle(p0);
    //
    //    ModelImpl model = new ModelImpl(library);
    //    model.addLamp(0, 2);
    //    model.addLamp(2, 0);
    //
    //    System.out.println(model.isLampIllegal(2,0));
    //    System.out.println(model.isSolved());
  }
}
