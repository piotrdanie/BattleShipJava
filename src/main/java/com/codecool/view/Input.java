package com.codecool.view;

import com.codecool.board.Coordinates;
import com.codecool.game.Game;
import com.codecool.ship.Orientation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Input {

    private HashMap<String, List<String>> options;
    private Scanner scanner;
    private Display display;

    public Input(Display display) {
        scanner = new Scanner(System.in);
        this.display = display;
    }

    public String getInputString() {
//        Display.printMessage("Choose options (between " + min + " and " + max + "): ");
        return scanner.next();
    }
    public int getInputInteger(int min, int max) {
        // can use display
        Display.printMessage("Choose options (between " + min + " and " + max + "): ");
        // TODO validate integer
        return scanner.nextInt();
    }

    public Orientation getOrientation() {
        return null;
    }

    // this method is for returnn
    public Game getGame() {
        return new Game();
    }

    public Coordinates getCoordinates() {
        // TODO: pobrać koordyanety od użytkownika and change to square
        // TODO: get String from user and convert to coordinates
        return new Coordinates(10, 10);
    }
}
