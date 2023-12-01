package com.kodilla;

import java.util.Scanner;

public class GameForTwoPlayers extends GameMethods {

    public void instruction() {
        System.out.println("""
                
                The game is easy:
                The object of Tic-Tac-Toe is to have three of your symbols make a straight line.
                The line can go sideways, up and down, or diagonally.
                To play, each person takes turn and draws their symbol in one of the empty squares.
                First Player 1 places their move by symbol "X".
                Player's 2 symbol is "O".
                The first player to make a straight line with three of their symbols wins!
                If nobody has a straight line of three symbols when the grid is filled, it's a tie.
                """);
    }
    public void secondPlayerMove(char[][] board, Scanner scanner) {

        String playerInput;

        while (true) {
            System.out.println("play your move: 1 - 9");

            playerInput = scanner.nextLine();
            if (isMovePossible(board, playerInput)) {
                break;
            } else {
                System.out.println(playerInput + " is not a valid move. Choose a correct move number");
            }
        }
        placeMove(board, playerInput, 'O');
    }

    public boolean isGameFinished(char[][] board) {

        if (hasSomeoneWon(board, 'X')) {
            System.out.println("Player 1 wins!\n\nThank you for playing!");
            return true;
        }

        if (hasSomeoneWon(board, 'O')) {
            System.out.println("Player 2 wins!\n\nThank you for playing!");
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    return false;
                }
            }
        }
        System.out.println("It's a tie!\n\nThank you for playing!");
        return true;
    }
}
