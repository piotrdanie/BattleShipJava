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


    public Ship(ShipType shipType, List<Square> squares) {
        this.shipType = shipType;
        this.squares = squares;
    }

    public List<Square> getSquares() {
        return squares;
    }

}
