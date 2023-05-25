package com.codecool.ship;

import com.codecool.board.Coordinates;
import com.codecool.square.Square;

import java.util.List;

public class Ship {

    private List<Square> squares;
    public ShipType shipType;
    private Coordinates startingCoordinates;
    private Orientation orientation;


    public Ship(List<Square> squares, ShipType shipType) {
        this.squares = squares;
        this.shipType = shipType;
    }
}
