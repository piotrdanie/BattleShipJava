package com.codecool.player;

import com.codecool.CustomConfiguration;
import com.codecool.board.Board;
import com.codecool.board.Coordinates;
import com.codecool.ship.Ship;
import com.codecool.ship.ShipType;
import com.codecool.square.SquareStatus;

import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HumanPlayer extends Player {

    // przy takiej konfiguracji w której to player ma borda ze swoimi statkami oraz z swoimi strzałami
    // jak możemy się odwoływać do borda przeciwnika żeby sprawdzić czy strzał był udany
    // podejrzewam że musi to być zaimplementowane w logice game już.
    private Board shootingBoard;
    private Board checkingBoard;
    private List<Ship> ships;
    private String name;


    public HumanPlayer(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return ships.size() == 0;
    }

    // ask for coordinates and send it
    // player choose the coordinates and that's all
    // because the game should validate it against the list of opponent ships coordinates.
    public  Coordinates shoot() {
        return new Coordinates(10, 10);
    }

    // informacja czy statek został zatopiony
    public SquareStatus responseToShoot(Coordinates coordinates) {
        return null;
    }

    public ArrayList<Ship> createShipsList(){
        ArrayList<Ship> playerShips = new ArrayList<>();
        HashMap<ShipType, Integer> numberOfShips = CustomConfiguration.getInstance().getNumberOfShips();
        for(Map.Entry<ShipType, Integer> set : numberOfShips.entrySet()) {
            for (int i = 0; i <= set.getValue(); i++) {

                Ship actualShip = input.createShipFromUserInput(set.getKey());
                playerShips.add(actualShip);
            }
        }
        return playerShips;
    }


}
