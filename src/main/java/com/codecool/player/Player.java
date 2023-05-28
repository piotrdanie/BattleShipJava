package com.codecool.player;


import com.codecool.board.Board;
import com.codecool.board.Coordinates;
import com.codecool.ship.Ship;
import com.codecool.square.SquareStatus;

import java.util.ArrayList;
import java.util.List;


public abstract class Player {

    public abstract boolean isAlive();

    public abstract  Coordinates shoot();

    public abstract SquareStatus responseToShoot(Coordinates coordinates);

    public abstract ArrayList<Ship> createShipsList();

    public abstract String getName();

    public abstract List<Ship> getShips();

    public abstract void setCheckingBoard(Board checkingBoard);
}
