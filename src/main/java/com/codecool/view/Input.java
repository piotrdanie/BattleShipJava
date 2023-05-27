package com.codecool.view;

import com.codecool.CustomConfiguration;
import com.codecool.board.Coordinates;
import com.codecool.player.PlayerLevel;
import com.codecool.game.GameMode;
import com.codecool.ship.Orientation;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Input {

    private Scanner scanner;
    private Display display;
    private CustomConfiguration configuration;


    public Input(Display display, CustomConfiguration configuration) {
        scanner = new Scanner(System.in);
        this.display = display;
        this.configuration = configuration;
    }

    public String getInputString() {
//        Display.printMessage("Choose options (between " + min + " and " + max + "): ");
        return scanner.next();
    }

    public int getMainMenuOption() {
        int option = getOption("Menu");
        return option;
    }

    public Orientation getOrientation() {
        display.printMessage("Provide orientation: ");
        return null;
    }

    public Coordinates getCoordinates() {
        // TODO: pobrać koordyanety od użytkownika and change to square
        // TODO: get String from user and convert to coordinates
        return new Coordinates(10, 10);
    }

    public GameMode getGameMode() {
        int option = getOption("Mode");
        switch (option) {
            case 1:
                return GameMode.PLAYER_VS_PLAYER;
            case 2:
                return GameMode.PLAYER_VS_PC;
            case 3:
                return GameMode.PC_VS_PC;
            default:
                return null;
        }
    }

    public PlayerLevel getGameLevel() {
        int option = getOption("Level");
        switch (option) {
            case 1:
                return PlayerLevel.EASY;
            case 2:
                return PlayerLevel.MEDIUM;
            case 3:
                return PlayerLevel.HARD;
            default:
                return null;
        }
    }

    private int getOption(String key) {
        while(true) {
            List<String> options = configuration.getListOptions().get(key);
            display.printMenu(options);

            try {
                int option = scanner.nextInt();
                if (option >= 1 && option <= options.size()) {
                    return option;
                }
            } catch (InputMismatchException e) {
                checkExit();
            }

        }
    }

    private void checkExit() {
        String input = scanner.next();
        if (input.equals(configuration.getExitButton())) {
            exitGame();
        }
    }

    public void exitGame() {
        display.printExitMessage();
        System.exit(0); // Exit with status code 0 (normal exit)
    }
}
