package com.codecool.player;

import com.codecool.board.Board;
import com.codecool.board.Coordinates;
import com.codecool.ship.Ship;
import com.codecool.square.SquareStatus;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    private Board shootingBoard;
    private Board checkingBoard;
    private List<Ship> ships;
    private String name;

    public Player() {
        this.ships = new ArrayList<Ship>();
    }

    public boolean isAlive() {
        return ships.size() == 0;
    }

    public  Coordinates shoot() {
        return new Coordinates(10, 10);
    }

    public SquareStatus responseToShoot(Coordinates coordinates) {
        return null;
    }

    public String getName() {
        return name;
    }
}
