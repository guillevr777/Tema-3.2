package examenes;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        // Create a 3x3 board
        char[][] board = { {'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
         
        // Create a scanner for user input
        Scanner sc = new Scanner(System.in);
        boolean gameEnded = false;
        char currentPlayer = 'X';

        System.out.println("Welcome to Tic Tac Toe!");
        
        // Game loop
        while (!gameEnded) {
            // Print the board
            printBoard(board);

            // Ask the current player for their move
            System.out.println("Player " + currentPlayer + ", enter your move (row and column):");
            int row = sc.nextInt();
            int col = sc.nextInt();

            // Check if the move is valid
            if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '-') {
                System.out.println("This move is not valid! Try again.");
            } else {
                // Place the player's mark on the board
                board[row][col] = currentPlayer;

                // Check if the current player has won
                if (hasWon(board, currentPlayer)) {
                    gameEnded = true;
                    printBoard(board);
                    System.out.println("Player " + currentPlayer + " wins!");
                } else {
                    // Check if the board is full (tie)
                    if (isBoardFull(board)) {
                        gameEnded = true;
                        printBoard(board);
                        System.out.println("The game is a tie!");
                    } else {
                        // Switch to the other player
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    }
                }
            }
        }

        sc.close();
    }

    // Function to print the board
    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Function to check if the board is full
    public static boolean isBoardFull(char[][] board) {
    	
    	boolean respuesta = true;
    	
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '-') {
                	respuesta = false;
                }
            }
        }
        return respuesta;
    }

    // Function to check if a player has won
    public static boolean hasWon(char[][] board, char player) {
    	
    	boolean ganador = false;
    	
        // Check rows
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                ganador = true;
            }
        }

        // Check columns
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
            	ganador = true;            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
        	ganador = true;        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
        	ganador = true;        }

        return ganador;
    }
}