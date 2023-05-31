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

    private Player firstPlayer;
    private Player secondPlayer;

    public GamePlayerVsPlayer() {
        prepareGame();
    }

    @Override
    public void prepareGame() {
        firstPlayer = PlayerFactory.createHumanPlayer();
        secondPlayer = PlayerFactory.createHumanPlayer();
    }
}
