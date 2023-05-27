package com.codecool;

import com.codecool.game.Game;
import com.codecool.game.GameFactory;
import com.codecool.game.GameMode;
import com.codecool.view.Display;
import com.codecool.view.Input;


public class Battleship {

    private Display display;
    private Input input;
    private Game game;
    private CustomConfiguration configuration;


    public Battleship(Display display, Input input, CustomConfiguration configuration) {
        this.display = display;
        this.input = input;
        this.configuration = configuration;
    }


    public void startApp() {
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
                    input.exitGame();
            }
        }
    }

    private Game createGame() {
        GameMode gameMode = input.getGameMode();
        return GameFactory.createGame(gameMode, input, display, configuration);
    }


}
