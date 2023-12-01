package com.kodilla;

import java.util.Random;

public class GameWithComputer extends GameMethods {

    public void instruction() {
        System.out.println("""
                
                The game is easy:
                The object of Tic-Tac-Toe is to have three of your symbols make a straight line.
                The line can go sideways, up and down, or diagonally.
                To play, each person takes turn and draws their symbol in one of the empty squares.
                First you place your move by symbol "X".
                Computer's symbol is "O".
                The first player to make a straight line with three of their symbols wins!
                If nobody has a straight line of three symbols when the grid is filled, it's a tie.
                """);
    }
    public void computerMove(char[][] board) {
        Random random = new Random();
        int computerInput;
        while (true) {
            computerInput = random.nextInt(9) + 1;
            if (isMovePossible(board, Integer.toString(computerInput))) {
                break;
            }
        }
        System.out.println("Computer played " + computerInput);
        placeMove(board, Integer.toString(computerInput), 'O');
    }

    public boolean isGameFinished(char[][] board) {

        if (hasSomeoneWon(board, 'X')) {
            System.out.println("Congratulations! You win!\n\nThank you for playing!");
            return true;
        }

        if (hasSomeoneWon(board, 'O')) {
            System.out.println("Computer wins!\n\nThank you for playing!");
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
