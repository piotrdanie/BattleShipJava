package com.codecool.player;

import com.codecool.game.GameLevel;
import com.codecool.game.GameMode;
import com.codecool.util.ExitException;

import java.util.ArrayList;
import java.util.List;

public class PlayerFactory {

    // class for returning player based on the provided data
    public static List<Player> createPlayer(GameLevel gameLevel) {
        // create user player
        Player userPlayer = new Player();
        Player pcPlayer = createPcPlayer(gameLevel);
        List<Player> players = new ArrayList<>();
        players.add(userPlayer);
        players.add(pcPlayer);

        return players;
    }

    public static List<Player> createPlayer(){
        Player firstPlayer = new Player();
        Player secondPlayer = new Player();
        List<Player> players = new ArrayList<>();
        players.add(firstPlayer);
        players.add(secondPlayer);

        return players;
    }

    private static Player createPcPlayer(GameLevel gameLevel) {
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
