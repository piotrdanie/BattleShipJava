package com.codecool.board;

import com.codecool.square.Square;
import com.codecool.view.Input;

public class BoardFactory {



    private Input input;


    public BoardFactory() {
        this.input = new Input();
    }



    public void randomPlacement(Board board) {
        for (Square[] row : board.getSquares()) {
            for (Square square : row) {
                // place ships
            }
        }
    }


    public Square[][] manualPlacement(Square[][] ocean) {
        return ocean;
    }
}
