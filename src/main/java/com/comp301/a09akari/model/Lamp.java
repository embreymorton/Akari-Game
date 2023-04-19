package com.comp301.a09akari.model;

public class Lamp {

    private int row;
    private int col;

    public Lamp (int r, int c){
        row = r;
        col = c;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return col;
    }

    public boolean equals(Lamp other){
        return (this.row == other.getRow()) && (this.col == other.getColumn());
    }

}
