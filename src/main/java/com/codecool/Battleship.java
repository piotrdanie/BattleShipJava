package com.codecool;

import com.codecool.game.Game;
import com.codecool.game.GameFactory;
import com.codecool.game.GameLevel;
import com.codecool.game.GameMode;
import com.codecool.exceptions.ExitException;
import com.codecool.view.Display;
import com.codecool.view.Input;

import java.util.InputMismatchException;

public class Battleship {

    private Display display;
    private Input input;
    private Game game;
    private boolean isRunning;


    public Battleship(Display display, Input input) {
        this.display = display;
        this.input = input;
        this.isRunning = true;
    }


    public void startApp() throws ExitException {
        while (true) {
            int option = input.getMainMenuOption();
            switch (option) {
                case 1:
                    createGame();
                    break;
                case 2:
                    // TODO print hall of fame
                    break;
                case 3:
                    throw new ExitException();
            }
        }
    }

    private Game createGame() throws ExitException {
        GameMode gameMode = input.getGameMode();
        return GameFactory.createGame(gameMode, input);
    }


}
