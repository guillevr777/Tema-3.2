package examenes;
import java.util.Random;
import java.util.Scanner;

public class Sudoku {

    private static final int SIZE = 9;
    private static final int SUBGRID = 3;
    private int[][] board;
    private boolean[][] fixed;

    public Sudoku() {
        board = new int[SIZE][SIZE];
        fixed = new boolean[SIZE][SIZE];
    }

    // Genera un Sudoku parcialmente lleno
    public void generateSudoku() {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (random.nextInt(100) < 30) { // 30% de las celdas estarán llenas
                    int num = random.nextInt(9) + 1;
                    if (isValid(i, j, num)) {
                        board[i][j] = num;
                        fixed[i][j] = true; // Marca esta celda como fija
                    }
                }
            }
        }
    }

    // Comprueba si un número puede colocarse en una posición
    private boolean isValid(int row, int col, int num) {
        // Verifica la fila y la columna
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // Verifica la subcuadrícula
        int startRow = (row / SUBGRID) * SUBGRID;
        int startCol = (col / SUBGRID) * SUBGRID;
        for (int i = 0; i < SUBGRID; i++) {
            for (int j = 0; j < SUBGRID; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // Verifica si el Sudoku está completamente lleno y válido
    public boolean isSolved() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0 || !isValid(row, col, board[row][col])) {
                    return false;
                }
            }
        }
        return true;
    }

    // Permite al jugador hacer un movimiento
    public boolean makeMove(int row, int col, int num) {
        if (fixed[row][col]) {
            System.out.println("No puedes cambiar una celda fija.");
            return false;
        }
        if (isValid(row, col, num)) {
            board[row][col] = num;
            return true;
        } else {
            System.out.println("Movimiento inválido.");
            return false;
        }
    }

    // Muestra el tablero en la consola
    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            if (i % SUBGRID == 0 && i != 0) {
                System.out.println("---------------------");
            }
            for (int j = 0; j < SIZE; j++) {
                if (j % SUBGRID == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] == 0 ? ". " : board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sudoku generado:");
        sudoku.generateSudoku();
        sudoku.printBoard();

        while (!sudoku.isSolved()) {
            System.out.println("\nIntroduce tu movimiento (fila columna número):");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            int num = scanner.nextInt();

            if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || num < 1 || num > 9) {
                System.out.println("Entrada inválida. Intenta de nuevo.");
                continue;
            }

            if (sudoku.makeMove(row, col, num)) {
                System.out.println("Tablero actualizado:");
                sudoku.printBoard();
            }

            if (sudoku.isSolved()) {
                System.out.println("\n¡Felicidades! Has resuelto el Sudoku.");
                break;
            }
        }

        scanner.close();
    }
}
