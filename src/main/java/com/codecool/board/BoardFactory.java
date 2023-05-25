package com.codecool.board;

import com.codecool.square.Square;
import com.codecool.view.Input;

public class BoardFactory {



    private Input input;

<<<<<<< HEAD
    // ???????????????????
    public BoardFactory(Input input) {
        this.input = input;
=======

    public BoardFactory() {
        this.input = new Input();
>>>>>>> f57985865b0ebdd2930ccad01b1ce4f1f4d9ce59
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
