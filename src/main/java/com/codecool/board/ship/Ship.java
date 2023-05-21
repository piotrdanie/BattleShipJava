package com.codecool.board.ship;

import com.codecool.board.square.Square;

import java.util.List;

public class Ship {

    private List<Square> squares;
    private ShipType shipType;

    public Ship(List<Square> squares, ShipType shipType) {
        this.squares = squares;
        this.shipType = shipType;
    }


}
