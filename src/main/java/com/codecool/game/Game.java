package com.codecool.game;

import com.codecool.board.Coordinates;
import com.codecool.player.Player;
import com.codecool.square.SquareStatus;
import com.codecool.view.Display;


public abstract class Game {

    private final Player firstPlayer;
    private final Player secondPlayer;
    private Player actualPlayer;
    private Player otherPlayer;


    public Game(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.actualPlayer = firstPlayer;
        this.otherPlayer = secondPlayer;
    }

    public void startGame() {
        while (true) {
            playerTurn();
            switchPlayers();
            if (!otherPlayer.isAlive()){
                Display.getInstance().printMessage(actualPlayer.getName() + " win!");
                Display.getInstance().printMessage("Game over!");
                break;
            }
            else if (!actualPlayer.isAlive()){
                Display.getInstance().printMessage(otherPlayer.getName() + " win!");
                Display.getInstance().printMessage("Game over!");
                break;
            }
        }
    }


    public void playerTurn(){
        // get the coordinates from Player
        Coordinates shootCoordinates = actualPlayer.shoot();

        // check if th missile hit the ship
        SquareStatus squareStatus = otherPlayer.responseToShoot(shootCoordinates);

        // wrote the square status on the player board
        actualPlayer.drawCheckingBoard(shootCoordinates, squareStatus);
    }

    private void switchPlayers() {
        if (actualPlayer.equals(firstPlayer)) {
            actualPlayer = secondPlayer;
            otherPlayer = firstPlayer;
        } else {
            actualPlayer = firstPlayer;
            otherPlayer = secondPlayer;
        }
    }

}
