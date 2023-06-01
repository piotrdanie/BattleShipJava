package com.codecool.player;

import com.codecool.ship.ShipFactory;

public class ComputerPlayer extends Player{
    protected ComputerPlayer(String name, ShipFactory shipFactory) {
        super(name, shipFactory);
    }
}