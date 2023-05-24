package com.codecool.player;

import com.codecool.board.Board;
import com.codecool.board.Coordinates;
import com.codecool.ship.Ship;

import java.util.ArrayList;
import java.util.List;

public class Player {

    // przy takiej konfiguracji w której to player ma borda ze swoimi statkami oraz z swoimi strzałami
    // jak możemy się odwoływać do borda przeciwnika żeby sprawdzić czy strzał był udany
    // podejrzewam że musi to być zaimplementowane w logice game już.
    private Board shootingBoard;
    private Board checkingBoard;
    private List<Ship> ships;

    public Player() {
        this.ships = new ArrayList<Ship>();
    }

    public boolean isAlive() {
        return ships.size() == 0;
    }

    // ask for coordinates and send it
    // player choose the coordinates and that's all
    // because the game should validate it against the list of opponent ships coordinates.
    public  Coordinates shoot() {
        return new Coordinates(10, 10);
    }

}
