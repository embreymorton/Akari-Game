package com.comp301.a09akari;

import com.comp301.a09akari.model.*;
import com.comp301.a09akari.view.AppLauncher;
import javafx.application.Application;

public class Main {
  public static void main(String[] args) {
    // Application.launch(AppLauncher.class);

    //            int[][] pzl = {
    //              {6, 6, 6, 6, 6},
    //              {6, 6, 6, 6, 6},
    //              {6, 5, 6, 6, 6},
    //              {6, 6, 6, 6, 6},
    //              {6, 6, 6, 6, 6},
    //            };

    int[][] pzl = {
      {6, 6},
    };

    Puzzle p0 = new PuzzleImpl(pzl);
    Puzzle p1 = new PuzzleImpl(SamplePuzzles.PUZZLE_01);
    Puzzle p2 = new PuzzleImpl(SamplePuzzles.PUZZLE_02);
    Puzzle p3 = new PuzzleImpl(SamplePuzzles.PUZZLE_03);
    Puzzle p4 = new PuzzleImpl(SamplePuzzles.PUZZLE_04);
    Puzzle p5 = new PuzzleImpl(SamplePuzzles.PUZZLE_05);

    PuzzleLibrary library = new PuzzleLibraryImpl();
    library.addPuzzle(p0);
    library.addPuzzle(p1);
    library.addPuzzle(p2);
    library.addPuzzle(p3);
    library.addPuzzle(p4);
    library.addPuzzle(p5);

    ModelImpl model = new ModelImpl(library);

    model.setActivePuzzleIndex(1);
    model.addLamp(0, 3);
    model.addLamp(1, 1);
    model.addLamp(2, 5);
    model.addLamp(3, 4);
    model.addLamp(3, 6);
    model.addLamp(4, 5);
    model.addLamp(5, 2);
    model.addLamp(5, 6);
    model.addLamp(6, 0);
    model.addLamp(6, 3);
    System.out.println("Puzzle 1 Solved: " + model.isSolved());
    model.resetPuzzle();

    model.setActivePuzzleIndex(2);
    model.addLamp(0, 1);
    model.addLamp(0, 4);
    model.addLamp(1, 3);
    model.addLamp(2, 0);
    model.addLamp(2, 2);
    model.addLamp(2, 9);
    model.addLamp(3, 1);
    model.addLamp(4, 6);
    model.addLamp(5, 3);
    model.addLamp(5, 7);
    model.addLamp(6, 2);
    model.addLamp(6, 5);
    model.addLamp(6, 8);
    model.addLamp(7, 0);
    model.addLamp(7, 4);
    model.addLamp(7, 9);
    model.addLamp(8, 8);
    model.addLamp(9, 2);
    model.addLamp(9, 7);
    System.out.println("Puzzle 2 Solved: " + model.isSolved());
    model.resetPuzzle();

    model.setActivePuzzleIndex(3);
    model.addLamp(0, 1);
    model.addLamp(0, 5);
    model.addLamp(1, 4);
    model.addLamp(1, 6);
    model.addLamp(2, 5);
    model.addLamp(3, 0);
    model.addLamp(4, 1);
    model.addLamp(5, 0);
    model.addLamp(5, 3);
    model.addLamp(6, 2);
    model.addLamp(6, 6);
    System.out.println("Puzzle 3 Solved: " + model.isSolved());
    model.resetPuzzle();

    model.setActivePuzzleIndex(4);
    model.addLamp(0, 2);
    model.addLamp(0, 9);
    model.addLamp(1, 7);
    model.addLamp(2, 0);
    model.addLamp(2, 6);
    model.addLamp(3, 1);
    model.addLamp(4, 7);
    model.addLamp(5, 9);
    model.addLamp(6, 4);
    model.addLamp(7, 0);
    model.addLamp(7, 3);
    model.addLamp(7, 8);
    model.addLamp(8, 2);
    model.addLamp(9, 0);
    model.addLamp(9, 5);
    model.addLamp(9, 9);
    System.out.println("Puzzle 4 Solved: " + model.isSolved());
    model.resetPuzzle();

    model.setActivePuzzleIndex(5);
    model.addLamp(0, 1);
    model.addLamp(0, 5);
    model.addLamp(1, 4);
    model.addLamp(2, 5);
    model.addLamp(3, 0);
    model.addLamp(4, 1);
    model.addLamp(5, 0);
    model.addLamp(5, 3);
    model.addLamp(6, 2);
    System.out.println("Puzzle 5 Solved: " + model.isSolved());
    model.resetPuzzle();
  }
}
