package com.codecool.player;


import com.codecool.board.Board;
import com.codecool.board.Coordinates;
import com.codecool.ship.Ship;
import com.codecool.ship.ShipFactory;
import com.codecool.square.Square;
import com.codecool.square.SquareStatus;
import com.codecool.view.Display;
import com.codecool.view.Input;

import java.util.List;

public abstract class Player {

    private final String name;
    private final List<Ship> ships;
    private final Board playerBoard;
    private final Board checkingBoard;


    protected Player(String name, ShipFactory shipFactory) {
        this.name = name;
        this.checkingBoard = new Board();
        this.playerBoard = new Board();
        this.ships = shipFactory.create(playerBoard,checkingBoard);
    }

    public boolean isAlive() {
        if (ships.size() == 0) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public Coordinates shoot() {
        // Display the board to the user
        Display.getInstance().printBoard(playerBoard, checkingBoard);

        // get coordinates from the user
        Display.getInstance().printMessage(name + " you shoot");
        Coordinates targetCoordinates = Input.getInstance().getCoordinates();


        // return the selected coordinates
        return targetCoordinates;
    }

    // public method to get response from other player if the shoot hit or missed the ship
    public SquareStatus responseToShoot(Coordinates coordinates) {
        Square square = playerBoard.getSquareByCoordinates(coordinates);
        SquareStatus actualSquareStatus = square.getSquareStatus();

        switch (actualSquareStatus) {
            case SHIP:
                shipHit(coordinates);
                break;
            case EMPTY:
                square.setSquareStatus(SquareStatus.MISSED);
                Display.getInstance().printMessage("You missed the cowardly shrimp");
                break;
        }
        return square.getSquareStatus();
    }

    private void shipHit(Coordinates coordinates) {
        Square square = playerBoard.getSquareByCoordinates(coordinates);
        Display.getInstance().printMessage("You've hit a ship!");
        square.setSquareStatus(SquareStatus.HIT);


        // check if the ship is sunk - if the ship is sunk then remove it from the ships
        Ship ship = getShipByCoordinates(coordinates);
        if (ship.isSunk()) {
            for (Square hitSquare : ship.getSquares()){
                hitSquare.setSquareStatus(SquareStatus.SINK);
            }
            Display.getInstance().printMessage("You've sunk a ship!");
            ships.remove(ship);
        }
    }


    public void drawCheckingBoard(Coordinates shootCoordinates, SquareStatus squareStatus) {
        this.checkingBoard.getSquareByCoordinates(shootCoordinates).setSquareStatus(squareStatus);
    }

    public Ship getShipByCoordinates(Coordinates coordinates) {
        for (Ship ship : ships) {
            for (Square square : ship.getSquares()) {
               if (!square.getCoordinates().equals(coordinates)) {
                 return ship;
               }
            }
    }
        return null;
    }
}
