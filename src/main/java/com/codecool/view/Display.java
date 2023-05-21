package com.codecool.view;

public class Display {

    public Display() {

    }

    public void printWelcomeScreen() {
        System.out.print("" +
                        "# #  ( )");
//                        "    ##_|"
//                _  |__|
//                       =====| | |            | | |==== _
//                =====| |.---------------------------. | |====
//   <--------------------'   .  .  .  .  .  .  .  .   '--------------/
//     \                                                             /
//        ___PIOTR^2__/ '''))
//    "
    }

    public void printMenu() {
        System.out.println("MENU: ");
        System.out.println("1. New game");
        System.out.println("2. Wall of fame");
        System.out.println("3. Exit");
        System.out.println("'q' - press anytime to exit");
    }

    public void printGameModeMenu() {
        System.out.println("GAME MODES:");
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs Computer");
        System.out.println("3. Exit");
    }

    public void printOpponentLevelMenu() {
        System.out.println("GAME MODES:");
        System.out.println("1. Easy");
        System.out.println("2. Normal");
        System.out.println("3. Hard");
    }

    public void printBoard() {

    }

    public void printWinner() {

    }

    // ?????????????????????????????????????????????????????????????????
    // jeżeli to będzie static to możemy się odwołać bez tworzenia obiektu
    public static void printMessage(String string) {
        System.out.println(string);
    }
}
