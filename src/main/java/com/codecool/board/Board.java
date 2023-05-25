package com.codecool.board;

import com.codecool.square.Square;
import com.codecool.square.SquareStatus;

public class Board {

    private int size = 10;
    private Square[][] ocean;


    public Board() {
        ocean = new Square[size][size];
        initializeOcean();
    }

    public boolean isPlacementOk(Coordinates coordinates) {
        return (ocean[coordinates.getX()][coordinates.getY()].getSquareStatus().equals(SquareStatus.EMPTY));
    }

    public Square[][] getSquares() {
        return this.ocean;
    }


    private void initializeOcean() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                ocean[row][col] = new Square(SquareStatus.EMPTY);
            }
        }
    }

    public Square[][] getOcean() {
        return ocean;
    }
}
