package com.codecool.player;

import com.codecool.board.Board;
import com.codecool.ship.ConsoleInputShipFactory;
import com.codecool.ship.Ship;
import com.codecool.view.Input;

import java.util.List;

public class HumanPlayer extends Player {




    public HumanPlayer() {
        super(
                Input.getInstance().getName(),
                new ConsoleInputShipFactory()
        );
    }


    public boolean isAlive() {
        if (ships.size() == 0) {
            return false;
        }
        return true;
    }

}
