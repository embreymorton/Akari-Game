package com.comp301.a09akari.model;

public class PuzzleImpl implements Puzzle {

  private int width;
  private int height;
  private int[][] board;

  public PuzzleImpl(int[][] board) {
    width = board[0].length;
    height = board.length;
    this.board = board.clone();
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

  private boolean inBounds(int r, int c) {
    if (c >= width || r >= height) return false;
    else if (c < 0 || r < 0) return false;
    return true;
  }

  private int getValue(int r, int c) {
    return board[r][c];
  }
}
