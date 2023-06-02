package com.codecool.game;

import com.codecool.CustomConfiguration;
import com.codecool.board.Board;
import com.codecool.player.HumanPlayer;
import com.codecool.player.Player;
import com.codecool.player.PlayerFactory;
import com.codecool.view.Display;
import com.codecool.view.Input;

import java.util.List;

public class GamePlayerVsPlayer extends Game{

    public GamePlayerVsPlayer() {
        super(
                PlayerFactory.createHumanPlayer(),
                PlayerFactory.createHumanPlayer()
        );
    }
//    public void switchRound(){
//        if (int player == 1);
//        {
//            int player = 2;
//            return player;
//        }
//        else (player == 2){
//            player = 1;
//            return player;
//        }
//    }

}
