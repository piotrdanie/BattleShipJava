package com.codecool.square;

public enum SquareStatus {
    EMPTY('□'),
    SHIP('■'),
    HIT('✖'),
    MISSED('●'),
    // implementation
    SINK('S');

    private final char symbol;

    SquareStatus(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

}
