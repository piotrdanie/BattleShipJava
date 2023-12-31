package com.codecool;

import com.codecool.ship.ShipType;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomConfiguration{

    private static CustomConfiguration instance;
    private HashMap<String, List<String>> listOptions;
    private HashMap<ShipType, Integer> numberOfShips;
    private String exitButton;
    private int size;


    public static CustomConfiguration getInstance() {
        if (instance == null) {
            instance = new CustomConfiguration();
        }
        return instance;
    }

    public CustomConfiguration() {
        this.listOptions = initializeOptions();
        this.size = 10;
//        this.numberOfShips = 5;
        this.numberOfShips = initializeNumberOfShips();
        this.exitButton = "q";
    }

    private HashMap<String, List<String>> initializeOptions() {
        HashMap<String, List<String>> optionsMap = new HashMap<>();
        optionsMap.put("Menu", createMainMenuList());
        optionsMap.put("Mode", createGameModeMenu());
        optionsMap.put("Level", createGameLevelMenu());
        optionsMap.put("Orientation", createOrientationMenu());
//        optionsMap.put("ShipType", createShipTypeMenu());
        return optionsMap;
    }

    private List<String> createMainMenuList() {
        ArrayList<String> menuList = new ArrayList<>();
        menuList.add("New game");
        menuList.add("Wall of fame");
        menuList.add("Exit");
        return menuList;
    }

    private List<String> createGameModeMenu() {
        ArrayList<String> menuList = new ArrayList<>();
        menuList.add("Player vs Player");
        menuList.add("Player vs Computer");
        menuList.add("Computer vs Computer");
        return menuList;
    }

    private List<String> createGameLevelMenu() {
        ArrayList<String> menuList = new ArrayList<>();
        menuList.add("Easy");
        menuList.add("Medium");
        menuList.add("Hard");
        return menuList;
    }

    private List<String> createOrientationMenu() {
        ArrayList<String> menuList = new ArrayList<>();
        menuList.add("Horizontal");
        menuList.add("Vertical");
        return menuList;
    }

    private HashMap<ShipType, Integer> initializeNumberOfShips() {
        HashMap<ShipType, Integer> mapNumberOfShips = new HashMap<>();
        mapNumberOfShips.put(ShipType.BATTLESHIP, 1);
        mapNumberOfShips.put(ShipType.CARRIER, 1);
        mapNumberOfShips.put(ShipType.CRUISER, 1);
        mapNumberOfShips.put(ShipType.DESTROYER, 1);
        mapNumberOfShips.put(ShipType.SUBMARINE, 1);
        return mapNumberOfShips;
    }
//    private List<String> createShipTypeMenu() {
//        ArrayList<String> shipTypeMenu = new ArrayList<>();
//        shipTypeMenu.add("BATTLESHIP");
//        shipTypeMenu.add("CARRIER");
//        shipTypeMenu.add("CRUISER");
//        shipTypeMenu.add("DESTROYER");
//        shipTypeMenu.add("SUBMARINE");
//        return shipTypeMenu;
//    }

    public int getSize() {
        return size;
    }

    public String getExitButton() {
        return this.exitButton;
    }

    public HashMap<ShipType, Integer> getNumberOfShips() {
        return numberOfShips;
    }

    public HashMap<String, List<String>> getListOptions() {
        return listOptions;
    }
}
