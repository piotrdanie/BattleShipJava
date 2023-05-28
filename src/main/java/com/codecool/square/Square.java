package com.codecool.square;

import com.codecool.board.Coordinates;

public class Square {

    private SquareStatus squareStatus;
    private Coordinates coordinates;


    public Square(SquareStatus squareStatus, Coordinates coordinates) {
        this.squareStatus = squareStatus;
        this.coordinates = coordinates;
    }

    public SquareStatus getSquareStatus() {
        return squareStatus;
    }

    public void setSquareStatus(SquareStatus squareStatus) {
    }
}
