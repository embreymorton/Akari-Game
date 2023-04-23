package com.comp301.a09akari.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

  private PuzzleLibrary library;
  private List<Lamp> lamps;
  private Puzzle activePuzzle;
  private int index;
  private Lamp currentLamp;
  private List<ModelObserver> observers;

  public ModelImpl(PuzzleLibrary library) {
    this.library = library;
    lamps = new ArrayList<>();
    observers = new ArrayList<>();
    index = 0;
    activePuzzle = library.getPuzzle(index);
    currentLamp = null;
  }

  @Override
  public void addLamp(int r, int c) {
    checkInBounds(r, c);
    checkCellType(r, c, CellType.CORRIDOR);

    if (!isLamp(r, c)) lamps.add(new Lamp(r, c));
    updateObservers();
  }

  @Override
  public void removeLamp(int r, int c) {
    checkInBounds(r, c);
    checkCellType(r, c, CellType.CORRIDOR);

    if (isLamp(r, c)) lamps.remove(currentLamp);
    updateObservers();
  }

  @Override
  public boolean isLit(int r, int c) {
    checkInBounds(r, c);
    if (activePuzzle.getCellType(r, c) == CellType.WALL
        || activePuzzle.getCellType(r, c) == CellType.CLUE) return false;

    checkCellType(r, c, CellType.CORRIDOR);
    if (isLamp(r, c)) return true;

    int lampRow;
    int lampCol;
    for (Lamp lamp : lamps) {
      lampRow = lamp.getRow();
      lampCol = lamp.getColumn();

      if (lampRow == r || lampCol == c)
        if (!wallInBetween(r, c, lampRow, lampCol)) {
          return true;
        }
    }
    return false;
  }

  @Override
  public boolean isLamp(int r, int c) {
    //checkInBounds(r, c);
    checkCellType(r, c, CellType.CORRIDOR);

    for (Lamp lamp : lamps) {
      if ((lamp.getRow() == r) && (lamp.getColumn() == c)) {
        currentLamp = lamp;
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean isLampIllegal(int r, int c) {
    //checkInBounds(r, c);
    if (!isLamp(r, c)) throw new IllegalArgumentException();

    int lampRow;
    int lampCol;
    for (Lamp lamp : lamps) {
      lampRow = lamp.getRow();
      lampCol = lamp.getColumn();

      if (lampRow == r || lampCol == c) {
        if (lampRow == r && lampCol == c) continue;

        if (!wallInBetween(r, c, lampRow, lampCol)) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public Puzzle getActivePuzzle() {
    return library.getPuzzle(index);
  }

  @Override
  public int getActivePuzzleIndex() {
    return index;
  }

  @Override
  public void setActivePuzzleIndex(int index) {
    if (index >= library.size() || index < 0) throw new IndexOutOfBoundsException();
    this.index = index;
    activePuzzle = library.getPuzzle(index);
    updateObservers();
  }

  @Override
  public int getPuzzleLibrarySize() {
    return library.size();
  }

  @Override
  public void resetPuzzle() {
    lamps.clear();
    updateObservers();
  }

  @Override
  public boolean isSolved() {
    int width = activePuzzle.getWidth();
    int height = activePuzzle.getHeight();

    CellType type;
    for (int r = 0; r < height; r++) {
      for (int c = 0; c < width; c++) {
        type = activePuzzle.getCellType(r, c);
        if (type == CellType.CORRIDOR) {
          if (!isLit(r, c)) return false;
        } else if (type == CellType.CLUE) {
          if (!isClueSatisfied(r, c)) return false;
        }
      }
    }

    int lampRow;
    int lampCol;
    for (Lamp lamp : lamps) {
      lampRow = lamp.getRow();
      lampCol = lamp.getColumn();

      if (isLampIllegal(lampRow, lampCol)) return false;
    }
    return true;
  }

  @Override
  public boolean isClueSatisfied(int r, int c) {
    checkInBounds(r, c);
    checkCellType(r, c, CellType.CLUE);

    int value = activePuzzle.getClue(r, c);
    int numLamps = 0;

    if (r - 1 >= 0) {
      if (isCellType(r - 1, c, CellType.CORRIDOR) && isLamp(r - 1, c)) numLamps++;
    }
    if (r + 1 <= activePuzzle.getWidth() - 1) {
      if (isCellType(r + 1, c, CellType.CORRIDOR) && isLamp(r + 1, c)) numLamps++;
    }
    if (c - 1 >= 0) {
      if (isCellType(r, c - 1, CellType.CORRIDOR) && isLamp(r, c - 1)) numLamps++;
    }
    if (c + 1 <= activePuzzle.getHeight() - 1) {
      if (isCellType(r, c + 1, CellType.CORRIDOR) && isLamp(r, c + 1)) numLamps++;
    }

    return numLamps == value;
  }

  @Override
  public void addObserver(ModelObserver observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(ModelObserver observer) {
    observers.remove(observer);
  }

  public void checkInBounds(int r, int c) {
    if (c >= activePuzzle.getWidth() || r >= activePuzzle.getHeight())
      throw new IndexOutOfBoundsException();
    if (c < 0 || r < 0)
      throw new IndexOutOfBoundsException();
  }

  private void checkCellType(int r, int c, CellType type) {
    //checkInBounds(r, c);
    if (type != activePuzzle.getCellType(r, c)) throw new IllegalArgumentException();
  }

  private boolean isCellType(int r, int c, CellType type) {
    checkInBounds(r, c);
    if (type != activePuzzle.getCellType(r, c)) return false;
    return true;
  }

  public boolean wallInBetween(int r1, int c1, int r2, int c2) {
    if (r1 == r2) {
      if (c2 < c1) {
        for (int i = c2; i < c1; i++) {
          if (activePuzzle.getCellType(r1, i) != CellType.CORRIDOR) {
            return true;
          }
        }
      } else if (c2 > c1) {
        for (int i = c1; i < c2; i++) {
          if (activePuzzle.getCellType(r1, i) != CellType.CORRIDOR) {
            return true;
          }
        }
      }
    } else if (c1 == c2) {
      if (r2 < r1) {
        for (int i = r2; i < r1; i++) {
          if (activePuzzle.getCellType(i, c1) != CellType.CORRIDOR) {
            return true;
          }
        }
      } else if (r2 > r1) {
        for (int i = r1; i < r2; i++) {
          if (activePuzzle.getCellType(i, c1) != CellType.CORRIDOR) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public void updateObservers() {
    for (ModelObserver o : observers) {
      o.update(this);
    }
  }
}
