package com.codecool;

import com.codecool.view.Display;
import com.codecool.view.Input;

public class Battleship {

    private Display display;
    private Input input;

    public Battleship() {
        display = new Display();
        input = new Input();
    }

    public void startApp() {
        while(true) {
            display.printMenu();
            // choose the options
        }
    }
}
