package com.codecool.ship;

import com.codecool.square.Square;

import java.util.List;

public class Ship {

    private List<Square> squares;
    public ShipType shipType;

    public Ship(List<Square> squares, ShipType shipType) {
        this.squares = squares;
        this.shipType = shipType;
    }


}
