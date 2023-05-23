package com.codecool;

import com.codecool.view.Display;
import com.codecool.view.Input;

public class Battleship {
    private static final int MIN_MENU_CHOICE = 1;
    private static final int MAX_MENU_CHOICE = 3;
    private static int menuChoice;
    private static int gameMode;
    public static String exitChoice;

    private Display display;
    private Input input;

    public Battleship() {
        display = new Display();
        input = new Input();
    }

    public void startApp() {
        while (true) {
            display.printMenu();
            try {
                menuChoice = input.getInputInteger(MIN_MENU_CHOICE, MAX_MENU_CHOICE);
                if (menuChoice == 1) {
                    display.printGameModeMenu();
                    gameMode = input.getInputInteger(MIN_MENU_CHOICE,MAX_MENU_CHOICE);
                } else if (menuChoice == 2) {
                    System.out.println("Wall of fame:");
                    // lista 10 ostatnich zwycięzców
                } else if (menuChoice == 3) {
                    System.out.println("EXIT: " + menuChoice);
                    break;  // Exit the loop
                }else {
                    System.out.println("Try again between " + MIN_MENU_CHOICE + " and " + MAX_MENU_CHOICE);
                }
            } catch (Exception e) {
                exitChoice = input.getInputString();
                System.out.println("ERROR: " + exitChoice);
                break;  // Exit the loop
            }
        }
    }
}
