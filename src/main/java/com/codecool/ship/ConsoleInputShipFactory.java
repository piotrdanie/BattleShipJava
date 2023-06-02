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
        Display.getInstance().printBoard(placementBoard);
        HashMap<ShipType, Integer> numberOfShips = CustomConfiguration.getInstance().getNumberOfShips();
        for(Map.Entry<ShipType, Integer> shipTypeAndNumber : numberOfShips.entrySet()) {
            for (int i = 0; i < shipTypeAndNumber.getValue(); i++) {
                Ship actualShip = createShipRecurent(shipTypeAndNumber, placementBoard);
                playerShips.add(actualShip);
                Display.getInstance().printBoard(placementBoard);
            }
        }
        return playerShips;
    }

    private Ship createShipRecurent(Map.Entry<ShipType, Integer> shipTypeAndNumber, Board placementBoard) {
        Display.getInstance().printMessage("Please provide the data for placing the: " + shipTypeAndNumber.getKey());
        Ship actualShip = createShip(shipTypeAndNumber.getKey(), placementBoard);
        if (!shipAlreadyExists(actualShip, playerShips)) {
            Display.getInstance().printMessage("This square is already occupied.");
            return createShipRecurent(shipTypeAndNumber, placementBoard);
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

    //check that the ship fits on board
    //TODO use it :)
    private boolean shipInBoard(ShipType shipType, Coordinates startCoordinates, CustomConfiguration configuration) {
        if (startCoordinates.getX() + shipType.getSize() > configuration.getSize()
                || startCoordinates.getY() + shipType.getSize() > configuration.getSize()) {
            return false;
        } else {
            return true;
        }
    }


    private Ship createShip(ShipType shipType, Board placementBoard) {

        Coordinates startCoordinates = Input.getInstance().getCoordinates();

        // set square status as ship
        placementBoard.getOcean()[startCoordinates.getX()][startCoordinates.getY()].setSquareStatus(SquareStatus.SHIP);

        // ask for orientation
        Orientation orientation = Input.getInstance().getOrientation();

        // get the size of the ship
        int shipSize = shipType.getSize();

        // create list od squares
        List<Square> shipSquares = new ArrayList<>();

        // calculate and create the rest of the squares
        for (int l = 0; l < shipSize; l++) {
            Coordinates actualCoordinates;

            switch (orientation) {
                case VERTICAL:
                    actualCoordinates = new Coordinates(startCoordinates.getX() +l, startCoordinates.getY());
                    break;
                case HORIZONTAL:
                    actualCoordinates = new Coordinates(startCoordinates.getX(), startCoordinates.getY() + l);
                    break;
                default:
                    actualCoordinates = new Coordinates(startCoordinates.getX(), startCoordinates.getY() + l);
                    break;
            }

            Square actualSquare = placementBoard.getOcean()[actualCoordinates.getX()][actualCoordinates.getY()];
            actualSquare.setSquareStatus(SquareStatus.SHIP);
            shipSquares.add(actualSquare);
        }

        return new Ship(shipType, shipSquares);
    }


}
