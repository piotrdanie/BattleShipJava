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
    
    public Coordinates shoot() {
        Coordinates targetCoordinates = Input.getInstance().getCoordinates();
//        Square targetSquare = checkingBoard.getOcean()[targetCoordinates.getX()][targetCoordinates.getY()];
//        SquareStatus targetSquareStatus =
//                checkingBoard.getOcean()[targetCoordinates.getX()][targetCoordinates.getY()].getSquareStatus();
//
//        if (targetSquareStatus == SquareStatus.SHIP) {
//                targetSquare.setSquareStatus(SquareStatus.HIT);
//                if (isSunk()){
//                    targetSquare.setSquareStatus(SquareStatus.SINK);
//                    Display.getInstance().printMessage("Hit and sink!");
//                } else {
//                    Display.getInstance().printMessage("It's a hit!");
//                }
//        }
//        else if (targetSquareStatus == SquareStatus.EMPTY){
//                targetSquare.setSquareStatus(SquareStatus.MISSED);
//                Display.getInstance().printMessage("It's a miss.");
//        }
        return targetCoordinates;
    }

    public boolean shipHit(Coordinates coordinates) {
        if (playerBoard.getSquareByCoordinates(coordinates).getSquareStatus().equals(SquareStatus.SHIP)) {
            return true;
        }
        return false;
    }

    public boolean shipSink(Coordinates coordinates) {
        if (playerBoard.getSquareByCoordinates(coordinates).getSquareStatus().equals(SquareStatus.SINK)) {
            return true;
        }
        return false;
    }


    // public method to get response from other player if the shoot hit or missed the ship
    public SquareStatus responseToShoot(Coordinates coordinates) {
        Square square = playerBoard.getSquareByCoordinates(coordinates);
        SquareStatus actualSquareStatus = square.getSquareStatus();

        switch (actualSquareStatus) {
            case SHIP:
                square.setSquareStatus(SquareStatus.HIT);
                break;
            case EMPTY:
                square.setSquareStatus(SquareStatus.MISSED);
                break;
        }

        return square.getSquareStatus();
    }


    private boolean isSunk(){
        for (Ship ship : ships){
            for (Square square : ship.getSquares()){
                if (square.getSquareStatus() == SquareStatus.HIT) {
                    return true;
                }
            }
        }
        return false;
    }


    public void drawCheckingBoard(Coordinates shootCoordinates, SquareStatus squareStatus) {

    }
}
