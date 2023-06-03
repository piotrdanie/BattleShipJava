package com.codecool.ship;

import com.codecool.board.Coordinates;
import com.codecool.square.Square;
import com.codecool.square.SquareStatus;
import com.codecool.view.Display;
import com.codecool.view.Input;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private final List<Square> squares;
    private final ShipType shipType;
//    private boolean isSunk;


    public Ship(ShipType shipType, List<Square> squares) {
        this.shipType = shipType;
        this.squares = squares;
//        this.isSunk = false;
    }

    public boolean isSunk() {
        for (Square square : squares) {
            if (square.getSquareStatus().equals(SquareStatus.SHIP)) {
                return false;
            }
        }
        return true;
    }

    public List<Square> getSquares() {
        return squares;
    }

//    public void setSunk() {
//        for (Square square : this.squares) {
//            square.setSquareStatus(SquareStatus.SINK);
//        }
//        Display.getInstance().printMessage("You've sunk a ship!");
//        this.isSunk = true;
//    }
//
//    public boolean isSunk() {
//        return this.isSunk;
//    }
//
//    public void canShipSink() {
//        boolean shouldBeSunk = true;
//        for (Square nextSquare : squares) {
//            if (!nextSquare.getSquareStatus().equals(SquareStatus.HIT)) shouldBeSunk = false;
//        }
//        if (shouldBeSunk && !this.isSunk) setSunk();
//    }
}
