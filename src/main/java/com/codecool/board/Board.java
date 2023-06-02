package com.codecool.board;

import com.codecool.ship.Ship;
import com.codecool.square.Square;
import com.codecool.square.SquareStatus;

import java.util.List;

public class Board {

    private int size = 10;
    private Square[][] ocean;

    // board shouldn't have the shipList, this is property of the player
//    private List<Ship> shipList;


    public Board() {
        ocean = new Square[size][size];
        initializeOcean();
    }

//    public Board(List<Ship> shipList){
//        ocean = new Square[size][size];
//        initializeOcean(shipList);
//    }

    public boolean isPlacementOk(Coordinates coordinates) {
        return (ocean[coordinates.getX()][coordinates.getY()].getSquareStatus().equals(SquareStatus.EMPTY));
    }

    public Square[][] getSquares() {
        return this.ocean;
    }

    private void initializeOcean() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Coordinates coordinates = new Coordinates(row, col);
                ocean[row][col] = new Square(SquareStatus.EMPTY, coordinates);
            }
        }
    }

    public Square[][] getOcean() {
        return ocean;
    }
}
