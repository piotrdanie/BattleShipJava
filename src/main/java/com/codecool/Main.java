package com.codecool;

import com.codecool.board.Board;
import com.codecool.board.BoardFactory;
import com.codecool.view.Display;
import com.codecool.view.Input;

public class Main {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        Display display = new Display();
        Input input = new Input(display);
        Battleship battleship = new Battleship(display, input);
        battleship.startApp();
    }
}
