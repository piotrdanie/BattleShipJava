package com.codecool.player;

import com.codecool.board.Board;
import com.codecool.board.Coordinates;
import com.codecool.ship.Ship;
import com.codecool.square.SquareStatus;

import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer extends Player {
    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public Coordinates shoot() {
        return null;
    }

    @Override
    public SquareStatus responseToShoot(Coordinates coordinates) {
        return null;
    }

    @Override
    public ArrayList<Ship> createShipsList() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<Ship> getShips() {
        return null;
    }

    @Override
    public void setCheckingBoard(Board checkingBoard) {

    }
}