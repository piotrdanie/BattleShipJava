package com.codecool.view;

import com.codecool.board.Board;
import com.codecool.board.BoardFactory;
import com.codecool.square.Square;

import java.io.IOException;

public class Display {
    private int size = 10;

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
        System.out.println("3. Computer vs Computer");
    }

    public void printOpponentLevelMenu() {
        System.out.println("GAME MODES:");
        System.out.println("1. Easy");
        System.out.println("2. Normal");
//        System.out.println("3. Hard");
    }

    public void printHallOfFame() {
    }

    public void printBoard(Board board) {

    // TODO System.out.println(play nr ...);

        System.out.println("  A B C D E F G H I J");
        for (int row = 0; row < size; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < size; col++) {
                System.out.print(board.getOcean()[row][col].getSquareStatus().getSymbol() + " ");
            }
            System.out.println();
        }
    }



    public void printWinner() {

    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            System.out.println(e);
        }
    }

    public static void printMessage(String string) {
        System.out.println(string);
    }

    private void translationCharToEmoji() {

        // translation_char_to_emoji = {
        //    '#':'🧱',
        //    '@':'🧍',
        //    '&':'🧚',
        //    '!':'👾',
        //    '>':'🚪',
        //    '*':'🍕',
        //    '%':'🔫',
        //    '^':'⚡',
        //    '+':'💎',
        //    '?':'🧛',
        //    '1':' 1️⃣',
        //    '2':' 2️⃣',
        //    '3':' 3️⃣',
        //    ' ':'  '
        //    }
    }
}
