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
        int size = CustomConfiguration.getInstance().getSize();
        char rowLabel = 'A';
        System.out.println(" "+ printNumber(size));
        for (int row = 0; row < size; row++) {
            System.out.print((char) (rowLabel + row) + " ");;
            for (int col = 0; col < size; col++) {
                System.out.print(board.getOcean()[row][col].getSquareStatus().getSymbol() + " ");

            }
            System.out.print((char) (rowLabel + row) + " ");
            System.out.println();
        }
        System.out.println(" "+ printNumber(size));
        System.out.println();
    }

    private StringBuilder printNumber(int size){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= size; i++){
            sb.append(i);
            if (i < size){
                sb.append(" ");
            }
        }
        return sb;
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
