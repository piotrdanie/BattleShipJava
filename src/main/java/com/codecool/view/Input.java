package com.codecool.view;

import com.codecool.board.Coordinates;
import com.codecool.board.square.Square;
import com.codecool.board.square.SquareStatus;

import java.util.Scanner;

public class Input {

    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public int getNumberBetween(int min, int max) {
        Display.printMessage("Choose options (between " + min + " and " + max + "): ");
        return scanner.nextInt();
    }

    public Coordinates getCoordinates() {
        // TODO: pobrać koordyanety od użytkownika and change to square
        // TODO: get String from user and convert to coordinates
        return new Coordinates(10, 10);
    }
}
