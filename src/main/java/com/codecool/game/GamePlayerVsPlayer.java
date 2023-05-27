package com.codecool.game;

import com.codecool.CustomConfiguration;
import com.codecool.board.Board;
import com.codecool.player.HumanPlayer;
import com.codecool.player.Player;
import com.codecool.ship.Ship;
import com.codecool.view.Display;
import com.codecool.view.Input;

import java.util.ArrayList;
import java.util.List;

public class GamePlayerVsPlayer extends Game{

    public GamePlayerVsPlayer(Input input, Display display, CustomConfiguration configuration) {
        super(input, display, configuration);
    }
    public void prepareGame() {
        // ask user for name and board placement of the ships if this is human player
        // if player is PC then create random name for this player and place ships randomly

    }
    private Player creatHumanPlayer(){
        String name = input.getName();
        Board shootingBoard;
//        Board checkingBoard;
        List<Ship> ships;
        return new HumanPlayer();
    }
    // zapytaj o koordynaty położenia nego statku
    // stwórz nowy statek
    // umieść go na checkingBoard ??
    // dodaj do lity statków
    private ArrayList<Ship> creatPlayerShips(){
        return;
    }
}
