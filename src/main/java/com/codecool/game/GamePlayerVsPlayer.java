package com.codecool.game;

import com.codecool.CustomConfiguration;
import com.codecool.board.Board;
import com.codecool.player.HumanPlayer;
import com.codecool.player.Player;
import com.codecool.player.PlayerFactory;
import com.codecool.view.Display;
import com.codecool.view.Input;

import java.util.List;

public class GamePlayerVsPlayer extends Game{

    public GamePlayerVsPlayer(Input input, Display display, CustomConfiguration configuration) {
        super(input, display, configuration);
        prepareGame();
    }

    public void prepareGame() {
        firstPlayer = createPlayer();
        secondPlayer = createPlayer();
    }

    private Player createPlayer(){
        String name = input.getName();
        Player player = PlayerFactory.createHumanPlayer(input, name);
        player.createShipsList();
        Board playerCheckingBoard = new Board(player.getShips());
        player.setCheckingBoard(playerCheckingBoard);
        return player;
    }




}
