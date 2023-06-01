package com.codecool.ship;

import com.codecool.board.Board;

import java.util.ArrayList;
import java.util.List;

public interface ShipFactory {

    List<Ship> create(Board placementBoard);
}
