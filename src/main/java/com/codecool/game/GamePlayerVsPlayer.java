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
import java.util.List;

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
        int numberOfShips = 5;
        ArrayList<Ship> playerShips = new ArrayList<>();
        while (numberOfShips != 0) {
            Ship ship = creatNewShip();
            playerShips.add(ship);
            numberOfShips--;
        }
        return playerShips;
    }
    private Ship creatNewShip(){
        Square square = new Square(SquareStatus.SHIP);
        ShipType shipType = input.getShipType();
        Coordinates coordinates = input.getCoordinates();
        Orientation orientation = input.getOrientation();
        return new Ship((List<Square>) square,shipType,coordinates,orientation);
    }
}
