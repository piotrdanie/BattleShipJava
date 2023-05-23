package com.codecool;

import com.codecool.ship.Ship;
import com.codecool.ship.ShipType;
import com.codecool.square.Square;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//            ShipType shipType = ShipType.CARRIER;
//            ShipType shipType1 = ShipType.CARRIER;
//            System.out.println(shipType == shipType1);
        Ship[] list = new Ship[2];
        Ship s1 = new Ship(new ArrayList<Square>(),ShipType.CARRIER);
        list[0] = s1;
        System.out.println(list[0].shipType);
        s1.shipType = ShipType.DESTROYER;
        System.out.println(list[0].shipType);

    }
}