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
        this.checkingBoard = new Board();
        this.playerBoard = new Board();
        this.ships = shipFactory.create(playerBoard);
    }

    public boolean isAlive() {
        if (ships.size() == 0) {
            return false;
        }
        return true;
    }

    //poczatek implementacj strzelania
//    public void shoot() {
//        if (coordinateInBoardSize(targetCoordinates)) {
//            Square targetSquare = board.getOcean()[targetCoordinates.getX()][targetCoordinates.getY()];
//            SquareStatus targetStatus = targetSquare.getSquareStatus();
//
//            if (targetStatus == SquareStatus.SHIP) {
//                targetSquare.setSquareStatus(SquareStatus.HIT);
//                Display.getInstance().printMessage("It's a hit!");
//            } else {
//                targetSquare.setSquareStatus(SquareStatus.MISSED);
//                Display.getInstance().printMessage("It's a miss.");
//            }
//        } else {
//            Display.getInstance().printMessage("Invalid target coordinates.");
//        }
//    }

}
