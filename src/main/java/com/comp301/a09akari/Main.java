package com.comp301.a09akari;

import com.comp301.a09akari.model.*;
import com.comp301.a09akari.view.AppLauncher;
import javafx.application.Application;

public class Main {
  public static void main(String[] args) {
    //Application.launch(AppLauncher.class);

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
            library.addPuzzle(p4);

            ModelImpl model4 = new ModelImpl(library);
            model4.addLamp(0, 2);
            model4.addLamp(0, 9);
            model4.addLamp(1, 7);
            model4.addLamp(2, 0);
            model4.addLamp(2, 6);
            model4.addLamp(3, 1);
            model4.addLamp(4, 7);
            model4.addLamp(5, 9);
            model4.addLamp(6, 4);
            model4.addLamp(7, 0);
            model4.addLamp(7, 3);
            model4.addLamp(7, 8);
            model4.addLamp(8, 2);
            model4.addLamp(9, 0);
            model4.addLamp(9, 5);
            model4.addLamp(9, 9);

            System.out.println(model4.isSolved());
  }
}
