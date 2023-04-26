package com.comp301.a09akari.controller;

import com.comp301.a09akari.model.CellType;
import com.comp301.a09akari.model.Model;
import com.comp301.a09akari.model.ModelObserver;
import com.comp301.a09akari.model.Puzzle;

public class ControllerImpl implements AlternateMvcController {

  private Model model;

  public ControllerImpl(Model model) {
    this.model = model;
  }

  @Override
  public void clickNextPuzzle() {
    if (model.getActivePuzzleIndex() + 1 < model.getPuzzleLibrarySize()) {
      model.setActivePuzzleIndex(model.getActivePuzzleIndex() + 1);
    } else model.setActivePuzzleIndex(0);
  }

  @Override
  public void clickPrevPuzzle() {
    if (model.getActivePuzzleIndex() - 1 >= 0) {
      model.setActivePuzzleIndex(model.getActivePuzzleIndex() - 1);
    } else model.setActivePuzzleIndex(model.getPuzzleLibrarySize() - 1);
  }

  @Override
  public void clickRandPuzzle() {
    int currentIndex = model.getActivePuzzleIndex();
    int randIndex = (int) (Math.random() * model.getPuzzleLibrarySize());
    while (randIndex == currentIndex) {
      randIndex = (int) (Math.random() * model.getPuzzleLibrarySize());
    }
    model.setActivePuzzleIndex(randIndex);
  }

  @Override
  public void clickResetPuzzle() {
    model.resetPuzzle();
  }

  @Override
  public void clickCell(int r, int c) {
    if (model.getActivePuzzle().getCellType(r, c) == CellType.CORRIDOR) {
      if (model.isLamp(r, c)) model.removeLamp(r, c);
      else model.addLamp(r, c);
    }
  }

  @Override
  public boolean isLit(int r, int c) {
    return model.isLit(r, c);
  }

  @Override
  public boolean isLamp(int r, int c) {
    return model.isLamp(r, c);
  }

  @Override
  public boolean isClueSatisfied(int r, int c) {
    return model.isClueSatisfied(r, c);
  }

  @Override
  public boolean isSolved() {
    return model.isSolved();
  }

  @Override
  public Puzzle getActivePuzzle() {
    return model.getActivePuzzle();
  }

  public boolean isLampIllegal(int r, int c) {
    return model.isLampIllegal(r, c);
  }

  public void addModelObserver(ModelObserver o) {
    model.addObserver(o);
  }

  public void removeModelObserver(ModelObserver o) {
    model.removeObserver(o);
  }

  public int getActivePuzzleIndex() {
    return model.getActivePuzzleIndex();
  }

  public int getPuzzleLibrarySize() {
    return model.getPuzzleLibrarySize();
  }
}
