package com.codecool.game;

import com.codecool.CustomConfiguration;
import com.codecool.player.Player;
import com.codecool.view.Display;
import com.codecool.view.Input;


public abstract class Game {

    private Player firstPlayer;
    private Player secondPlayer;

    public Game(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }
}
