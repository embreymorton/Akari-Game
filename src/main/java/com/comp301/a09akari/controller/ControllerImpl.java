package com.comp301.a09akari.controller;

import com.comp301.a09akari.model.CellType;
import com.comp301.a09akari.model.Model;
import com.comp301.a09akari.model.Puzzle;

public class ControllerImpl implements AlternateMvcController {

    private Model model;

    public ControllerImpl(Model model){
        this.model = model;
    }

    @Override
    public void clickNextPuzzle() {
        if(model.getActivePuzzleIndex() + 1 < model.getPuzzleLibrarySize()) {
            model.resetPuzzle();
            model.setActivePuzzleIndex(model.getActivePuzzleIndex() + 1);
        }
    }

    @Override
    public void clickPrevPuzzle() {
        if(model.getActivePuzzleIndex() - 1 >= 0) {
            model.resetPuzzle();
            model.setActivePuzzleIndex(model.getActivePuzzleIndex() - 1);
        }
    }

    @Override
    public void clickRandPuzzle() {
        model.resetPuzzle();
        int randIndex = (int)(Math.random()*model.getPuzzleLibrarySize() - 1) + 1;
        model.setActivePuzzleIndex(randIndex);
    }

    @Override
    public void clickResetPuzzle() {
        model.resetPuzzle();
    }

    @Override
    public void clickCell(int r, int c) {

        if(model.getActivePuzzle().getCellType(r, c) == CellType.CORRIDOR) {
            if(model.isLamp(r, c))
                model.removeLamp(r, c);
            else
                model.addLamp(r, c);
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
}


