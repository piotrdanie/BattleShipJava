package com.codecool.game;

import com.codecool.board.Board;
import com.codecool.player.Player;
import com.codecool.player.PlayerFactory;

import java.util.List;

public class Game {

    private Board board;
    private GameLevel gameLevel;
    private GameMode gameMode;
    private List<Player> players;


    public Game() {
        this.board = new Board();
    }

    public Game(GameMode gameMode) {
        this.gameMode = gameMode;
        this.players = PlayerFactory.createPlayer();
    }

    public Game(GameMode gameMode, GameLevel gameLevel) {
        this.gameMode = gameMode;
        this.gameLevel = gameLevel;
        this.players = PlayerFactory.createPlayer(gameLevel);

    }
}
