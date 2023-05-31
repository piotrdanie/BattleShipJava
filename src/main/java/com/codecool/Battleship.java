package com.codecool;

import com.codecool.game.Game;
import com.codecool.game.GameFactory;
import com.codecool.game.GameMode;
import com.codecool.view.Input;


public class Battleship {

    public Battleship() {
    }

    public void startApp() {
        while (true) {
            int option = Input.getInstance().getMainMenuOption();
            switch (option) {
                case 1:
                    createGame();
                    break;
                case 2:
                    // TODO print hall of fame
                    break;
                case 3:
                    Input.getInstance().exitGame();
            }
        }
    }

    private Game createGame() {
        GameMode gameMode = Input.getInstance().getGameMode();
        return GameFactory.createGame(gameMode);
    }
}
