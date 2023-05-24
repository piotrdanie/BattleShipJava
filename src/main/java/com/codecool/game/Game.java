package com.codecool.game;

import com.codecool.board.Board;
import com.codecool.player.Player;
import com.codecool.player.PlayerFactory;

import java.util.List;

public class Game {

    private Board board;
    private GameLevel gameLevel;
    private GameMode gameMode;

    // I have no idea if list of players is good idea because we can have problem
    // with getting the second player when we want to shoot ships of first player
    private List<Player> players;

    // second option is to initialize first player and second player
    // which options is better I have no idea
    private Player firstPlayer;
    private Player secondPlayer;


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

    public void startGame() {
        while (firstPlayer.isAlive() || secondPlayer.isAlive()) {
            // TODO: main loop of the game;
        }

        // if this is god option???
        for( Player player : players) {
        }
    }
}
