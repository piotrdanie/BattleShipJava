package com.codecool.player;

import com.codecool.game.GameLevel;

import java.util.ArrayList;
import java.util.List;

public class PlayerFactory {

    public static Player createHumanPlayer() {
        return new Player();
    }

    public static Player createPcPlayer(GameLevel gameLevel) {
        switch (gameLevel) {
            case EASY:
                return new ComputerPlayerEasy();
            case MEDIUM:
                return new ComputerPlayerMedium();
            case HARD:
                return new ComputerPlayerHard();
        }
        return null;
    }
}
