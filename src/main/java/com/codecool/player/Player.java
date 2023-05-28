package com.codecool.player;

import com.codecool.CustomConfiguration;
import com.codecool.board.Board;
import com.codecool.board.Coordinates;
import com.codecool.ship.Ship;
import com.codecool.square.SquareStatus;
import com.codecool.view.Input;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    private Board shootingBoard;
    private Board checkingBoard;
    private List<Ship> ships;
    private String name;
    private CustomConfiguration configuration;
    private Input input;

    public Player(Board shootingBoard, Board checkingBoard, List<Ship> ships, String name, Input input) {
        this.shootingBoard = shootingBoard;
        this.checkingBoard = checkingBoard;
        this.ships = ships;
        this.name = name;
        this.input = input;
    }


    public abstract boolean isAlive();

    public abstract  Coordinates shoot();

    public abstract SquareStatus responseToShoot(Coordinates coordinates);

    public abstract ArrayList<Ship> createShipsList();

    public abstract String getName();
}
