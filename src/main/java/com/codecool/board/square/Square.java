package com.codecool.board.square;

public class Square {

    // ???????????????????????????????
    private SquareStatus squareStatus;

    public Square(SquareStatus squareStatus) {
        this.squareStatus = squareStatus;
    }

    public SquareStatus getSquareStatus() {
        return squareStatus;
    }
}
