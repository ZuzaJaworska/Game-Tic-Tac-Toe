package com.kodilla;

import java.util.Scanner;

public class GameMethods {

    public void printBoard(char[][] board) {
        System.out.println("\n"
                + " " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " "
                + "\n" + "---+---+---" + "\n"
                + " " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " "
                + "\n" + "---+---+---" + "\n"
                + " " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " \n");
    }

    public void placeMove(char[][] board, String place, char playerSymbol) {
        switch (place) {
            case "1":
                board[0][0] = playerSymbol;
                break;
            case "2":
                board[0][1] = playerSymbol;
                break;
            case "3":
                board[0][2] = playerSymbol;
                break;
            case "4":
                board[1][0] = playerSymbol;
                break;
            case "5":
                board[1][1] = playerSymbol;
                break;
            case "6":
                board[1][2] = playerSymbol;
                break;
            case "7":
                board[2][0] = playerSymbol;
                break;
            case "8":
                board[2][1] = playerSymbol;
                break;
            case "9":
                board[2][2] = playerSymbol;
                break;
            default:
                System.out.println("Enter the correct number (1-9)");
        }
        printBoard(board);
    }

    public void playerMove(char[][] board, Scanner scanner) {

        String playerInput;

        while (true) {
            System.out.println("play your move: 1 - 9");

            playerInput = scanner.nextLine();
            if (isMovePossible(board, playerInput)) {
                break;
            } else {
                System.out.println(playerInput + " is not a valid move. Choose another move number");
            }
        }
        placeMove(board, playerInput, 'X');
    }

    public boolean isMovePossible(char[][] board, String space) {
        return switch (space) {
            case "1" -> (board[0][0] == '1');
            case "2" -> (board[0][1] == '2');
            case "3" -> (board[0][2] == '3');
            case "4" -> (board[1][0] == '4');
            case "5" -> (board[1][1] == '5');
            case "6" -> (board[1][2] == '6');
            case "7" -> (board[2][0] == '7');
            case "8" -> (board[2][1] == '8');
            case "9" -> (board[2][2] == '9');
            default -> false;
        };
    }

    public boolean hasSomeoneWon(char[][] board, char symbol) {

        if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {

            return true;
        }
        return false;
    }
}
