package com.codecool.game;

import com.codecool.CustomConfiguration;
import com.codecool.player.Player;
import com.codecool.view.Display;
import com.codecool.view.Input;


public abstract class Game {

    protected Player firstPlayer;
    protected Player secondPlayer;
    protected Input input;
    private Display display;
    protected CustomConfiguration configuration;


    public Game(Input input, Display display, CustomConfiguration configuration) {
        this.input = input;
        this.display = display;
        this.configuration = configuration;
    }

    private void prepareGame() {
        // ask user for name and board placement of the ships if this is human player
        // if player is PC then create random name for this player and place ships randomly
    }

    public void startGame() {}

    private void playerTurn() {}


}
