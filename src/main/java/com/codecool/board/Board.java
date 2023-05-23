package com.codecool.board;

import com.codecool.square.Square;
import com.codecool.square.SquareStatus;

public class Board {

    private final int size = 10;
    private Square[][] ocean;

    // ?????????????????????????????????????????
    // jak i gdzie wrzucić ilości statków? ta informacja jest w klasie Player
    // można dać jako static ale to nie będzię obiektowe
    // lista enumów

    public Board() {
        ocean = new Square[size][size];
    }

    // ?????????????????????????
    // validacja
    public boolean isPlacementOk(Coordinates coordinates) {
        return (ocean[coordinates.getX()][coordinates.getY()].getSquareStatus().equals(SquareStatus.EMPTY));
    }

    public Square[][] getSquares() {
        return this.ocean;
    }
}
