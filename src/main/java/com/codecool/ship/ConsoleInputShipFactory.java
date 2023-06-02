package com.codecool.ship;

import com.codecool.CustomConfiguration;
import com.codecool.board.Board;
import com.codecool.board.Coordinates;
import com.codecool.square.Square;
import com.codecool.square.SquareStatus;
import com.codecool.view.Display;
import com.codecool.view.Input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsoleInputShipFactory implements ShipFactory {

    private List<Ship> playerShips;

    public ConsoleInputShipFactory() {
        this.playerShips = new ArrayList<>();
    }

    @Override
    public List<Ship> create(Board placementBoard) {
        HashMap<ShipType, Integer> numberOfShips = CustomConfiguration.getInstance().getNumberOfShips();
        for(Map.Entry<ShipType, Integer> shipTypeAndNumber : numberOfShips.entrySet()) {
            for (int i = 0; i < shipTypeAndNumber.getValue(); i++) {
                Ship actualShip = createShipRecursion(shipTypeAndNumber);
                playerShips.add(actualShip);
            }
        }
        return playerShips;
    }

    private Ship createShipRecursion(Map.Entry<ShipType, Integer> shipTypeAndNumber) {
        Display.getInstance().printMessage("Please provide the data for placing the: " + shipTypeAndNumber.getKey());
        Ship actualShip = createShip(shipTypeAndNumber.getKey());
        if (shipAlreadyExists(actualShip, playerShips)) {
            Display.getInstance().printMessage("This square is already ocuppied.");
            return createShipRecursion(shipTypeAndNumber);
        } else {
            return actualShip;
        }
    }

    private boolean shipAlreadyExists(Ship ship, List<Ship> ships) {
        for (Ship shipInList : ships) {
            for (Square square : shipInList.getSquares()) {
                for (Square actualSquare : ship.getSquares()) {
//                    Display.getInstance().printMessage(actualSquare + " : " + square);
                    if (actualSquare.equals(square)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private Ship createShip(ShipType shipType) {
        // ask for coordinates
        Coordinates startCoordinates = Input.getInstance().getCoordinates();
        // ask for orientation
        Orientation orientation = Input.getInstance().getOrientation();
        // get the size of the ship
        int shipSize = shipType.getSize();


        // calculate Coordinates of the rest squares
        // get Square from board
        Square firstSquare = new Square(SquareStatus.SHIP, startCoordinates);

        // create list od squares
        List<Square> shipSquares = new ArrayList<>();

        // calculate and create the rest of the squares
        for (int l = 0; l < shipSize; l++) {
            Coordinates actualCoordinates;

            switch (orientation) {
                case HORIZONTAL:
                    actualCoordinates = new Coordinates(startCoordinates.getX() +l, startCoordinates.getY());
                    break;
                case VERTICAL:
                    actualCoordinates = new Coordinates(startCoordinates.getX(), startCoordinates.getY() + l);
                    break;
                default:
                    actualCoordinates = new Coordinates(startCoordinates.getX(), startCoordinates.getY() + l);
                    break;
            }
            Square actualSquare = new Square(SquareStatus.SHIP, actualCoordinates);
            shipSquares.add(actualSquare);
        }

        return new Ship(shipType, shipSquares);
    }
}
