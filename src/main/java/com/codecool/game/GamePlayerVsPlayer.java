package com.codecool.game;

import com.codecool.CustomConfiguration;
import com.codecool.player.HumanPlayer;
import com.codecool.player.Player;
import com.codecool.view.Display;
import com.codecool.view.Input;

import java.util.List;

public class GamePlayerVsPlayer extends Game{

    private Player firstPlayer;

    public GamePlayerVsPlayer(Input input, Display display, CustomConfiguration configuration) {
        super(input, display, configuration);
    }

    // ask about abstract classes and why cannot see method;
    // game and player, PLayer and HumanPlayer.
    public void prepareGame() {
        // ask user for name and board placement of the ships if this is human player
        firstPlayer = createHumanPlayer();
        firstPlayer.createShipsList();
    }
    private HumanPlayer createHumanPlayer(){
        String name = input.getName();
        return new HumanPlayer(name);
    }




}
