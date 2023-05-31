package com.codecool.ship;

import com.codecool.board.Coordinates;
import com.codecool.square.Square;
import com.codecool.square.SquareStatus;
import com.codecool.view.Display;
import com.codecool.view.Input;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private List<Square> squares;
    public ShipType shipType;


    public Ship(ShipType shipType) {
        this.shipType = shipType;
        this.squares = createShipSquares(shipType);
    }

    public List<Square> getSquares() {
        return squares;
    }


    private List<Square> createShipSquares(ShipType shipType) {
        // ask for coordinates
        Coordinates startCoordinates = Input.getInstance().getCoordinates();
        // ask for orientation
        Orientation orientation = Input.getInstance().getOrientation();
        // get the size of the ship
        int shipSize = shipType.getSize();


        // calculate Coordinates of the rest squares
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
        return shipSquares;
    }


}
