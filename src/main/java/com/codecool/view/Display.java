package com.codecool.view;

import com.codecool.CustomConfiguration;
import com.codecool.board.Board;

import java.util.List;

public class Display {


    private static Display instance;

    public static Display getInstance() {
        if (instance == null) {
            instance = new Display();
        }
        return instance;
    }


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


    public void printMenu(List<String> options) {
        System.out.println("Choose option:");
        printOptions(options);
    }

    private void printOptions(List<String> options) {
        int i = 1;
        for (String option : options) {
            System.out.println(i + ". " + option);
            i++;
        }
    }


    public void printBoard(Board board) {
        System.out.println("  A B C D E F G H I J");
        for (int row = 0; row < CustomConfiguration.getInstance().getSize(); row++) {
            System.out.print(row + 1 + " ");
            for (int col = 0; col < CustomConfiguration.getInstance().getSize(); col++) {
                System.out.print(board.getOcean()[row][col].getSquareStatus().getSymbol() + " ");
            }
            System.out.println();
        }
    }

    public String printMessage(String message) {
        System.out.println(message);
        return message;
    }


    public void printWinner() {

    }

    public void clearConsole() {
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

    public void printExitMessage() {
        System.out.println("The game exited");
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
