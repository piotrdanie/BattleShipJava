package com.codecool.game;

import com.codecool.player.Player;
import com.codecool.player.PlayerFactory;
import com.codecool.view.Input;

public class GameFactory {

    public static Game createGame(GameMode gameMode, Input input) {
        switch (gameMode) {
            case PLAYER_VS_PLAYER:
                return new GamePlayerVsPlayer(input);
            case PLAYER_VS_PC:
                return new GamePlayerVsComputer(input);
            case PC_VS_PC:
                return new GameComputerVsComputer(input);
            default:
                return null;
        }
    }
}
