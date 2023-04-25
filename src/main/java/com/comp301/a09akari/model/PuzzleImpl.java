package com.comp301.a09akari.model;

import java.util.ArrayList;
import java.util.List;

public class PuzzleImpl implements Puzzle {

  private int width;
  private int height;
  private int[][] board;
  private List<Lamp> lampList;

  public PuzzleImpl(int[][] board) {
    width = board[0].length;
    height = board.length;
    this.board = board.clone();
    lampList = new ArrayList<>();
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public CellType getCellType(int r, int c) {
    if (!inBounds(r, c)) throw new IndexOutOfBoundsException();

    if (getValue(r, c) <= 4) return CellType.CLUE;
    else if (getValue(r, c) == 5) return CellType.WALL;
    else return CellType.CORRIDOR;
  }

  @Override
  public int getClue(int r, int c) {
    if (!inBounds(r, c)) throw new IndexOutOfBoundsException();
    else if (getCellType(r, c) != CellType.CLUE) throw new IllegalArgumentException();
    else return getValue(r, c);
  }

  @Override
  public void addLamp(Lamp p) {
    lampList.add(p);
  }

  @Override
  public void removeLamp(Lamp p) {
    lampList.remove(p);
  }

  @Override
  public void clearLamps() {
    lampList.clear();
  }

  @Override
  public List<Lamp> getLamps() {
    return lampList;
  }

  private boolean inBounds(int r, int c) {
    if (c >= width || r >= height) return false;
    else if (c < 0 || r < 0) return false;
    return true;
  }

  private int getValue(int r, int c) {
    return board[r][c];
  }
}
