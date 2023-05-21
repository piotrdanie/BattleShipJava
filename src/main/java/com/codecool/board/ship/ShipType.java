package com.codecool.board.ship;

public enum ShipType {
    CARRIER(1),
    CRUISER(2),
    BATTLESHIP(3),
    SUBMARINE(4),
    DESTROYER(5);


    private final int size;

    ShipType(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

}
