package com.codecool.ship;

public enum ShipType {
    CARRIER(5),
    CRUISER(4),
    BATTLESHIP(3),
    SUBMARINE(2),
    DESTROYER(1);


    private final int size;

    ShipType(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }
}
