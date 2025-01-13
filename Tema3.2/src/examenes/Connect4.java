package examenes;

import java.util.Scanner;

public class Connect4 {
    // Define the size of the board
    public static final int N = 6; // Change this constant to adjust the board size

    public static void main(String[] args) {
        // Create the board
        char[][] board = new char[N][N];
        initializeBoard(board);

        // Variables to track players
        char currentPlayer = 'X';
        boolean gameWon = false;

        // Create a scanner for input
        Scanner reader = new Scanner(System.in);
        
        //variable for colummns
        int column = 0;

       while (!gameWon) {
    	   System.out.println("Turn of player " + currentPlayer);
    	   printBoard(board);
    	   System.out.println("En que columna quieres poner la ficha?");
    	   column = reader.nextInt()-1;
    	   if (!placeChecker(board, column, currentPlayer)) {
    		   System.out.println("Columna no valida, prueba otra vez.");
    	   } else {
    		   if (!checkWin(board, currentPlayer)) {
    			   currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
    		   } else {
    			   gameWon = true;
    		   }
    	   }
       }

        // Print final board and winner
        printBoard(board);
        System.out.println("Player " + currentPlayer + " wins!");
        reader.close();
    }

    // Initialize the board with '-' for empty spaces
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Print the board to the console
    public static void printBoard(char[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Place the checker in the specified column
    public static boolean placeChecker(char[][] board, int column, char player) {
        // Start from the bottom of the column and move upward
        for (int i = N - 1; i >= 0; i--) {
            if (board[i][column] == '-') {
                board[i][column] = player;
                return true;
            }
        }
        return false; // Column is full
    }

 // Check if the current player has won
    public static boolean checkWin(char[][] board, char player) {
    	
    	//varible for winner
    	boolean winner = false;
    	
        // Check rows, columns, and diagonals for a sequence of 4
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // Check horizontal
                if (j + 3 < N && board[i][j] == player && board[i][j + 1] == player &&
                    board[i][j + 2] == player && board[i][j + 3] == player) {
                	winner = true;
                }
                // Check vertical
                if (i + 3 < N && board[i][j] == player && board[i + 1][j] == player &&
                    board[i + 2][j] == player && board[i + 3][j] == player) {
                	winner = true;
                }
                // Check main diagonal (\)
                if (i + 3 < N && j + 3 < N && board[i][j] == player && board[i + 1][j + 1] == player &&
                    board[i + 2][j + 2] == player && board[i + 3][j + 3] == player) {
                	winner = true;
                }
                // Check anti-diagonal (/)
                if (i + 3 < N && j - 3 >= 0 && board[i][j] == player && board[i + 1][j - 1] == player &&
                    board[i + 2][j - 2] == player && board[i + 3][j - 3] == player) {
                	winner = true;
                }
            }
        }
        return winner; // No win condition met
    }
}

