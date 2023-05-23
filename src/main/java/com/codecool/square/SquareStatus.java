package com.codecool.square;

public enum SquareStatus {
    EMPTY('□'),
    SHIP('■'),
    HIT('✖'),
    MISSED('●');

    private final char symbol;

    SquareStatus(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
