package com.codecool.player;

import com.codecool.CustomConfiguration;
import com.codecool.board.Board;
import com.codecool.board.Coordinates;
import com.codecool.ship.Orientation;
import com.codecool.ship.Ship;
import com.codecool.ship.ShipType;
import com.codecool.square.Square;
import com.codecool.square.SquareStatus;
import com.codecool.view.Display;
import com.codecool.view.Input;

import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HumanPlayer extends Player {

    private String name;
    private Board playerBoard;
    private Board checkingBoard;
    private List<Ship> ships;


    public HumanPlayer() {
        this.name = setName();
        this.ships = createShipsList();
    }


    public boolean isAlive() {
        if (ships.size() == 0) {
            return false;
        }
        return true;
    }

    private String setName() {
        return Input.getInstance().getName();
    }

    private ArrayList<Ship> createShipsList(){
        ArrayList<Ship> playerShips = new ArrayList<>();
        HashMap<ShipType, Integer> numberOfShips = CustomConfiguration.getInstance().getNumberOfShips();
        for(Map.Entry<ShipType, Integer> set : numberOfShips.entrySet()) {
            for (int i = 0; i < set.getValue(); i++) {

                // ask user until data are validated
                boolean shipValidated = false;

                while (!shipValidated) {
                    // create new ship
                    Display.getInstance().printMessage(name + " please provide the data for placing the: " + set.getKey());
                    Ship actualShip = new Ship(set.getKey());

                    // validate created ship
                    if (shipAlreadyExists(actualShip, playerShips)) {
                        playerShips.add(actualShip);
                        shipValidated = true;
                    } else {
                        // print message if the ship is not validated
                        Display.getInstance().printMessage("You provided incorrect data");
                    }
                }
            }
        }
        return playerShips;
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
}
