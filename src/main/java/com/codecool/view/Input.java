package com.codecool.view;

import com.codecool.CustomConfiguration;
import com.codecool.board.Coordinates;
import com.codecool.player.PlayerLevel;
import com.codecool.game.GameMode;
import com.codecool.ship.Orientation;
import com.codecool.ship.Ship;
import com.codecool.ship.ShipType;
import com.codecool.square.Square;
import com.codecool.square.SquareStatus;

import java.util.*;

public class Input {

    private Scanner scanner;
    private Display display;
    private CustomConfiguration configuration;


    public Input(Display display, CustomConfiguration configuration) {
        scanner = new Scanner(System.in);
        this.display = display;
        this.configuration = configuration;
    }

//    public String getInputString() {
////        Display.printMessage("Choose options (between " + min + " and " + max + "): ");
//        return scanner.next();
//    }

//    public Ship getUserShip() {
//
//        // get starting coordinates from user
//
//        // get orientation of the ship from user
//        Orientation shipOrientation = getOrientation();
//
//        // validate the shipOrientation
//
//        return new Ship();
//    }

    public Ship createShipFromUserInput(ShipType shipType) {

        // ask for coordinates
        Coordinates startCoordinates = getCoordinates();

        // ask for orientation
        Orientation orientation = getOrientation();

        // check the size of the ship
        int shipSize = shipType.getSize();


        // validate the placement of the ship
        if (startCoordinates.getY() + shipSize < configuration.getSize() ||
                startCoordinates.getX() + shipSize < configuration.getSize()) {
            // TODO return to while loop and ask again for the coordinates
            // create ship
            // new method for creating the ships
        } else {
            // ask user again for the input
        }

        // calculate Coordinates of the rest squares
        Square firstSquare = new Square(SquareStatus.SHIP, startCoordinates);

        // create list od squares
        List<Square> shipSquares = new ArrayList<>();
        shipSquares.add(firstSquare);

        // calculate and create the rest of the squares
        for (int l = 0; l < shipSize; l++) {
            if (orientation.equals(Orientation.HORIZONTAL)) {
                Coordinates actualCoordinates = new Coordinates(
                        startCoordinates.getX() +1,
                        startCoordinates.getY()
                );
                Square actualSquare = new Square(SquareStatus.SHIP, actualCoordinates);
                shipSquares.add(actualSquare);
            } else if (orientation.equals(Orientation.VERTICAL)) {
                Coordinates actualCoordinates = new Coordinates(
                        startCoordinates.getX(),
                        startCoordinates.getY() + 1
                );
                Square actualSquare = new Square(SquareStatus.SHIP, actualCoordinates);
                shipSquares.add(actualSquare);
            }
        }
        return new Ship(shipSquares, shipType);
    }



    public int getMainMenuOption() {
        int option = getOption("Menu");
        return option;
    }

    public String getName(){
        display.printMessage("Enter your Name: ");
        String name = scanner.next();
        return name;
    }

    public Orientation getOrientation() {
        int option = getOption( "Orientation");
        switch (option){
            case 1:
                return Orientation.HORIZONTAL;
            case 2:
                return Orientation.VERTICAL;
            default:
                return null;
        }
    }

    public Coordinates getCoordinates() {
        display.printMessage("Enter coordinates: ");
        String inputCoordinates = scanner.next();
        return crateCoordinate(inputCoordinates);
    }
    public ShipType getShipType(){
        int option = getOption("ShipType");
        switch (option) {
            case 1:
                return ShipType.BATTLESHIP;
            case 2:
                return ShipType.CARRIER;
            case 3:
                return ShipType.CRUISER;
            case 4:
                return ShipType.DESTROYER;
            case 5:
                return ShipType.SUBMARINE;
            default:
                return null;
        }
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

    private int[] convertCoordinateToArray(String userInput, int size) {
        int[] indices = new int[2];
        userInput = userInput.toUpperCase();
        String letter = userInput.substring(0, 1);
        int col = Integer.parseInt(userInput.substring(1))-1;
        int row = convertStringToInteger(letter, size);

        indices[0] = row;
        indices[1] = col;

        return indices;
    }

    private int convertStringToInteger(String letter, int size) {
        HashMap<String, Integer> columnsDict = new HashMap<>();

        for (int row = 0; row < size; row++) {
            columnsDict.put(String.valueOf((char) ('A' + row)), row);
        }

        return columnsDict.get(String.valueOf(letter.charAt(0)));
    }

    private Coordinates crateCoordinate (String position){
        int[] current = convertCoordinateToArray(position, configuration.getSize());
        int Row = current[0];
        int Col = current[1];
        Coordinates coordinates = new Coordinates(Row, Col);
        return  coordinates;
    };
}
