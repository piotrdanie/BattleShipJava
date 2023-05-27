package com.codecool.game;

import com.codecool.CustomConfiguration;
import com.codecool.player.Player;
import com.codecool.player.PlayerFactory;
import com.codecool.view.Display;
import com.codecool.view.Input;

public class GameFactory {

    public static Game createGame(GameMode gameMode, Input input, Display display, CustomConfiguration configuration) {
        switch (gameMode) {
            case PLAYER_VS_PLAYER:
                return new GamePlayerVsPlayer(input, display, configuration);
            case PLAYER_VS_PC:
                return new GamePlayerVsComputer(input, display, configuration);
            case PC_VS_PC:
                return new GameComputerVsComputer(input, display, configuration);
            default:
                return null;
        }
    }
}
