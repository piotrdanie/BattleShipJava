package com.codecool;

import com.codecool.game.Game;
import com.codecool.game.GameLevel;
import com.codecool.game.GameMode;
import com.codecool.util.ExitException;
import com.codecool.view.Display;
import com.codecool.view.Input;

import java.util.InputMismatchException;

public class Battleship {
    private static final int MIN_MENU_CHOICE = 1;
    private static final int MAX_MENU_CHOICE = 3;
    public static String EXIT_CHOICE = "q";

    private Display display;
    private Input input;
    private Game game;


    public Battleship() {
        display = new Display();
        input = new Input();
    }


    public void startApp() {
        while (true) {

            // try to start game, if game is not initialized it won't start
            try {
                game.startGame();
                System.out.println("game started");
            } catch (Exception e) {
                System.out.println("game not started yet");
                System.out.println(e);

            }

            display.printMenu();
            try {
                int menuChoice = input.getInputInteger(MIN_MENU_CHOICE, MAX_MENU_CHOICE);
                chooseMainMenuOption(menuChoice);
            } catch (InputMismatchException e) {
                String exitChoice = input.getInputString();
                if (exitChoice.equals(EXIT_CHOICE)) {
                    break;
                }
                Display.printMessage("You provided incorrect choice");
            } catch (ExitException e) {
                break;
            }
        }
    }

    private void chooseMainMenuOption(int userChoice) throws ExitException {
        switch (userChoice) {
            case 1:
                display.printGameModeMenu();
                int menuChoice = input.getInputInteger(MIN_MENU_CHOICE, MAX_MENU_CHOICE);
                chooseGameModeOption(menuChoice);
                break;
            case 2:
                display.printHallOfFame();
                break;
            case 3:
                throw new ExitException();
            default:
                Display.printMessage("Try again between " + MIN_MENU_CHOICE + " and " + MAX_MENU_CHOICE);
                break;
        }
    }

    private void chooseGameModeOption(int userChoice) throws ExitException {
        switch (userChoice) {
            case 1:
                setGame(new Game(GameMode.PLAYER_VS_PLAYER));
                break;
            case 2:
                int menuChoice = input.getInputInteger(MIN_MENU_CHOICE, MAX_MENU_CHOICE);
                chooseGameLevelOption(menuChoice);
                break;
            case 3:
                throw new ExitException();
            default:
                Display.printMessage("Try again between " + MIN_MENU_CHOICE + " and " + MAX_MENU_CHOICE);
                break;
        }
    }

    private void chooseGameLevelOption(int userChoice) {
        switch (userChoice) {
            case 1:
                setGame(new Game(GameMode.PLAYER_VS_PC, GameLevel.EASY));
                break;
            case 2:
                setGame(new Game(GameMode.PLAYER_VS_PC, GameLevel.MEDIUM));
                break;
            case 3:
                setGame(new Game(GameMode.PLAYER_VS_PC, GameLevel.HARD));
                break;
            default:
                Display.printMessage("Try again between " + MIN_MENU_CHOICE + " and " + MAX_MENU_CHOICE);
                break;
        }
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
