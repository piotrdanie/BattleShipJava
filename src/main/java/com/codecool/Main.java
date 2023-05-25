package com.codecool;

import com.codecool.board.Board;
import com.codecool.board.BoardFactory;
import com.codecool.view.Display;

public class Main {

    public static void main(String[] args) {
//        Battleship battleship = new Battleship();
//        battleship.startApp();

        Display display = new Display();
        display.printBoard(new Board());
    }
}
