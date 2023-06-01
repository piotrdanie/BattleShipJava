package com.codecool.player;


import com.codecool.board.Board;
import com.codecool.ship.Ship;
import com.codecool.ship.ShipFactory;

import java.util.List;

public abstract class Player {

    private final String name;
    private final List<Ship> ships;
    private final Board playerBoard;
    private final Board checkingBoard;

    protected Player(String name, ShipFactory shipFactory) {
        this.name = name;
        this.playerBoard = new Board();
        this.ships = shipFactory.create(playerBoard);
    }
}
