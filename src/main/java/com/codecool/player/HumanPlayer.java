package com.codecool.player;

import com.codecool.CustomConfiguration;
import com.codecool.board.Board;
import com.codecool.board.Coordinates;
import com.codecool.ship.Ship;
import com.codecool.ship.ShipType;
import com.codecool.square.SquareStatus;
import com.codecool.view.Input;

import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HumanPlayer extends Player {


    private Board shootingBoard;
    private Board checkingBoard;
    private List<Ship> ships;
    private String name;
    private Input input;


    public HumanPlayer(String name, Input input) {
        super();
        this.name = name;
        this.input = input;
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

    // informacja czy statek został zatopiony
    public SquareStatus responseToShoot(Coordinates coordinates) {
        return null;
    }

    public List<Ship> getShips() {
        return ships;
    }

    @Override
    public void setCheckingBoard(Board checkingBoard) {
        this.checkingBoard = checkingBoard;
    }

    @Override
    public String getName() {
        return this.name;
    }


}
