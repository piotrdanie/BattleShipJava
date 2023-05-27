package com.codecool.game;

import com.codecool.board.Board;
import com.codecool.exceptions.DrawException;
import com.codecool.player.Player;
import com.codecool.player.PlayerFactory;
import com.codecool.view.Input;

import java.util.List;

public abstract class Game {

    private Player firstPlayer;
    private Player secondPlayer;
    private Input input;


    public Game(Input input) {
        this.input = input;
    }

    private void prepareGame() {

    }

    public void startGame() {}

    private void playerTurn() {}
}
