package com.codecool.game;

import com.codecool.CustomConfiguration;
import com.codecool.player.Player;
import com.codecool.player.PlayerFactory;
import com.codecool.view.Display;
import com.codecool.view.Input;

public class GameFactory {

    public static Game createGame(GameMode gameMode) {
        switch (gameMode) {
            case PLAYER_VS_PLAYER:
                return new GamePlayerVsPlayer();
            case PLAYER_VS_PC:
                return new GamePlayerVsComputer();
            case PC_VS_PC:
                return new GameComputerVsComputer();
            default:
                return null;
        }
    }
}
