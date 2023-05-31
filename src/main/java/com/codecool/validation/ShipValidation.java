package com.codecool.validation;

import com.codecool.CustomConfiguration;
import com.codecool.board.Coordinates;
import com.codecool.ship.Orientation;
import com.codecool.ship.Ship;
import com.codecool.square.Square;

import java.util.List;

public class ShipValidation extends Validation {
    @Override
    public boolean validate() {
        return false;
    }



    public boolean validateShipOutsideBoard1(Coordinates startCoordinates, int shipSize) {
        if (startCoordinates.getY() + shipSize < CustomConfiguration.getInstance().getSize() ||
                startCoordinates.getX() + shipSize < CustomConfiguration.getInstance().getSize()) {
            return true;
        }
        return false;
    }

    public boolean validateShipOutsideBoard(Ship ship) {
        return true;
    }

}
