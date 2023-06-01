package com.codecool.game;

import com.codecool.player.Player;


public abstract class Game {

    private Player firstPlayer;
    private Player secondPlayer;

    public Game(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

//    private Player switchMove() {
//        if (firstPlayer) {
//            return secondPlayer;
//        } else {
//            return firstPlayer;
//        }
//    }

}
