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

    // I have no idea if list of players is good idea because we can have problem
    // with getting the second player when we want to shoot ships of first player
    private List<Player> players;

    // second option is to initialize first player and second player
    // which options is better?
    // In this option I have direct acess to the two of them at the same time
    private Player firstPlayer;
    private Player secondPlayer;


    public Game() {
        this.board = new Board();
    }

    public Game(GameMode gameMode) {
        this.gameMode = gameMode;
        this.players = PlayerFactory.createPlayer();
        this.firstPlayer = players.get(0);
        this.secondPlayer = players.get(1);
    }

    public Game(GameMode gameMode, GameLevel gameLevel) {
        this.gameMode = gameMode;
        this.gameLevel = gameLevel;
        this.players = PlayerFactory.createPlayer(gameLevel);
        this.firstPlayer = players.get(0);
        this.secondPlayer = players.get(1);
    }

    public void startGame() {
        System.out.println("game started");
        while (firstPlayer.isAlive() || secondPlayer.isAlive()) {
            break;
        }

        // if this is god option???
        for( Player player : players) {
            if (!player.isAlive()) {
                return;
            }

        }
    }

    private void playerTurn() {
        // logic for player turn
    }

    private void checkWinner() {
        try {
            if (gameEnd()) {
                Player winner = getWinner();
                System.out.println(winner.getName());
            }
        } catch (DrawException e) {
            // I think that it is not possible to get draw in battleship game
            // but i think this is good point to ask how we should handle that kind of situations.
            System.out.println("There is no winner draw");
        }
    }

    private Player getWinner() throws DrawException {
        for (Player player : players) {
            if (player.isAlive()) {
                return player;
            }
        }
        throw new DrawException();
    }

    private boolean gameEnd() {
        for(Player player : players) {
            if (!player.isAlive()) {
                return true;
            }
        }
        return false;
    }
}
