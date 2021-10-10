package com.techreturners.mars;

public class Plateau {
    // initialized with upper x, y i.e. max size of grid 5,5
    // can contain many rovers

    private int upperX;
    private int upperY;
    private int lowerX;
    private int lowerY;

    public Plateau(int upperX, int upperY) throws Exception {

        if (upperX > 5 | upperY > 5 | upperX < 0 | upperY < 0) throw new Exception("Invalid Input to Upper CoOrds.");
        this.upperX = upperX;
        this.upperY = upperY;
    }


}
