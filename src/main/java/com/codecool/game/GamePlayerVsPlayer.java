package com.codecool.game;

import com.codecool.CustomConfiguration;
import com.codecool.board.Board;
import com.codecool.board.Coordinates;
import com.codecool.player.HumanPlayer;
import com.codecool.player.Player;
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

public class GamePlayerVsPlayer extends Game{

    public GamePlayerVsPlayer(Input input, Display display, CustomConfiguration configuration) {
        super(input, display, configuration);
    }
    public void prepareGame() {
        // ask user for name and board placement of the ships if this is human player
        Player player = creatHumanPlayer();

    }
    private Player creatHumanPlayer(){
        String name = input.getName();
        Board shootingBoard;
        Board checkingBoard;
        List<Ship> ships = createPlayerShips();
        return new HumanPlayer();
    }
    // zapytaj o koordynaty położenia nowego statku
    // stwórz nowy statek
    // umieść go na checkingBoard ??
    // dodaj do lity statków
    private ArrayList<Ship> createPlayerShips() {

        ArrayList<Ship> playerShips = new ArrayList<>();
        while (numberOfShips != 0) {
            Ship ship = creatNewShip();
            playerShips.add(ship);
            numberOfShips--;
        }
        return playerShips;
    }

    private Ship creatNewShip(){
        HashMap<ShipType, Integer> numberOfShips = configuration.getNumberOfShips();
        for(Map.Entry<ShipType, Integer> set : numberOfShips.entrySet()) {
            for (int i = 0; i <= set.getValue(); i++) {

                // create ship of particular type
                ShipType shipType = set.getKey();

                // ask for coordinates
                Coordinates startCoordinates = input.getCoordinates();

                // ask for orientation
                Orientation orientation = input.getOrientation();

                // check the size of the ship
                int shipSize = shipType.getSize();


                // validate the placement of the ship
                if (startCoordinates.getY() + shipSize < configuration.getSize() ||
                    startCoordinates.getX() + shipSize < configuration.getSize()) {
                    // TODO return to while loop and ask again for the coordinates
                    // create ship
                    // new method for creating the ships
                } else {
                    // ask user again for the input
                }

                // calculate Coordinates of the rest squares
                Square firstSquare = new Square(SquareStatus.SHIP, startCoordinates);

                // create list od squares
                List<Square> shipSquares = new ArrayList<>();
                shipSquares.add(firstSquare);

                // calculate and create the rest of the squares
                for (int l = 0; l < shipSize; l++) {
                    if (orientation.equals(Orientation.HORIZONTAL)) {
                        Coordinates actualCoordinates = new Coordinates(
                                startCoordinates.getX() +1,
                                startCoordinates.getY()
                        );
                        Square actualSquare = new Square(SquareStatus.SHIP, actualCoordinates);
                        shipSquares.add(actualSquare);
                    } else if (orientation.equals(Orientation.VERTICAL)) {
                        Coordinates actualCoordinates = new Coordinates(
                                startCoordinates.getX(),
                                startCoordinates.getY() + 1
                        );
                        Square actualSquare = new Square(SquareStatus.SHIP, actualCoordinates);
                        shipSquares.add(actualSquare);
                    }
                }


            }
        }
    }
}
