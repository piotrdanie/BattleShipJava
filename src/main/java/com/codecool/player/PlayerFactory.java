package com.codecool.player;

import com.codecool.view.Input;

public class PlayerFactory {

    public static Player createHumanPlayer(Input input, String name) {
        return new HumanPlayer(name, input);
    }

    public static Player createPcPlayer(PlayerLevel playerLevel) {
        switch (playerLevel) {
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
