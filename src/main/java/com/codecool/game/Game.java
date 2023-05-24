package com.codecool.game;

import com.codecool.board.Board;

public class Game {

    private Board board;
    private GameLevel gameLevel;
    private GameMode gameMode;

    public Game() {
        this.board = new Board();
    }

    public Game(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public void setGameLevel(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }
}
