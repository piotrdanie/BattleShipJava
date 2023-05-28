package com.codecool.board;

import com.codecool.ship.Ship;
import com.codecool.square.Square;
import com.codecool.square.SquareStatus;

import java.util.List;

public class Board {

    private int size = 10;
    private Square[][] ocean;

    private List<Ship> shipList;


    public Board() {
        ocean = new Square[size][size];
        initializeOcean();
    }

    public Board(List<Ship> shipList){
        ocean = new Square[size][size];
        initializeOcean(List<Ship> shipList);
    }

    public boolean isPlacementOk(Coordinates coordinates) {
        return (ocean[coordinates.getX()][coordinates.getY()].getSquareStatus().equals(SquareStatus.EMPTY));
    }

    public Square[][] getSquares() {
        return this.ocean;
    }
    private void initializeOcean() {
    }

    private void initializeOcean(List<Ship> shipList) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                boolean isOccupied = false;
                for (Ship ship : shipList) {
                    for (Square square : ship.getSquares()){
                        if (square.getCoordinates().getX()  == row
                        && square.getCoordinates().getY() == col){
                            isOccupied = true;
                            break;
                        }
                    }
                    if (isOccupied){
                        break;
                    }
                }
                Coordinates coordinates = new Coordinates(row,col);
                SquareStatus status = isOccupied ? SquareStatus.SHIP : SquareStatus.EMPTY;
                ocean[row][col] = new Square(status, coordinates);
            }
        }
    }

    public Square[][] getOcean() {
        return ocean;
    }
}
