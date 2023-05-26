package com.codecool;

import com.codecool.exceptions.ExitException;
import com.codecool.view.Display;
import com.codecool.view.Input;

public class Main {

    public static void main(String[] args) {
        CustomConfiguration configuration = new CustomConfiguration();
        Display display = new Display(configuration);
        Input input = new Input(display, configuration);
        Battleship battleship = new Battleship(display, input);

        try {
            battleship.startApp();
        } catch (ExitException e) {
            display.printExitMessage();
        }

    }
}
