package com.kodilla;

import java.util.Scanner;

public class GameApp {

    public static void main(String[] args) {

        GameWithComputer compGame = new GameWithComputer();
        GameForTwoPlayers twoPlayersGame = new GameForTwoPlayers();

        Scanner scanner = new Scanner(System.in);

        boolean exitGame = false;

        char[][] board = {{'1', '2', '3'},
                          {'4', '5', '6'},
                          {'7', '8', '9'}};


        System.out.println("""
                
                ~~~~~ Welcome to the game TIC-TAC-TOE! ~~~~~
                
                Choose the game mode by entering the number:
                1 - one player with computer
                2 - two players' game""");

        String gameMode = scanner.nextLine();

        while (!exitGame) {

            if (gameMode.equals("1")) {

                compGame.instruction();
                compGame.printBoard(board);

                while (true) {
                    compGame.playerMove(board, scanner);
                    if (compGame.isGameFinished(board)) {
                        break;
                    }
                    compGame.computerMove(board);
                    if (compGame.isGameFinished(board)) {
                        break;
                    }
                }
                exitGame = true;

            } else if (gameMode.equals("2")) {
                twoPlayersGame.instruction();
                twoPlayersGame.printBoard(board);

                while (true) {
                    twoPlayersGame.playerMove(board, scanner);
                    if (twoPlayersGame.isGameFinished(board)) {
                        break;
                    }
                    twoPlayersGame.secondPlayerMove(board, scanner);
                    if (twoPlayersGame.isGameFinished(board)) {
                        break;
                    }
                }
                exitGame = true;
            } else {
                System.out.println("Choose the correct mode");
                gameMode = scanner.nextLine();
            }
        }
    }
}
