package com.codecool.game;

import com.codecool.board.Board;
import com.codecool.exceptions.DrawException;
import com.codecool.player.Player;
import com.codecool.player.PlayerFactory;

import java.util.List;

public class Game {

    private Board board;
    private GameLevel gameLevel;
    private GameMode gameMode;
    private Player firstPlayer;
    private Player secondPlayer;


    public Game() {
        this.board = new Board();
    }

    public Game(GameMode gameMode) {
        this.gameMode = gameMode;

    }

    public Game(GameMode gameMode, GameLevel gameLevel) {
        this.gameMode = gameMode;
        this.gameLevel = gameLevel;
    }

    public void startGame() {
        System.out.println("game started");
        while (firstPlayer.isAlive() || secondPlayer.isAlive()) {
            break;
        }
    }

    private void playerTurn() {
        // logic for player turn
    }
}
