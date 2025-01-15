package examenes;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TresRayasErrores {

	static Random random = new Random();
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {

		// creamos el array de tipo char que sera el tablero del juego
		char tablero[][] = new char[3][3];

		// variable por si se quiere volver a jugar
		char repetir;

		char turno;

		do {

			// llamamos a la funcion inicializar para que coloque el tablero
			inicializar(tablero);

			// creamos variable para cambiar el turno de los jugadores
			turno = jugadorInicial() ? 'X' : 'O';

			// declaramos las variables donde se almacenara la fila y columna donde desea el
			// jugador colocar la ficha
			int fila = 0;
			int columna = 0;

			// bienvenida a los jugadores
			System.out.println("Bienvenido al juego del 3 en rayas");

			while (!esGanador(turno, tablero) && !esEmpate(tablero)) {
	
				pintaTablero(tablero);
				if (turno == 'O') {
					System.out.println("Turno del jugador O");
					mueveFichaAleatoria(tablero);
				} else {
					System.out.println("Turno del jugador X");
					do {
						try {
							System.out.println("En que fila y columna quieres colocar la ficha?");
							fila = reader.nextInt() - 1;
							columna = reader.nextInt() - 1;

							assert (fila <= 2 && fila >= 0 && columna <= 2 && columna >= 0)
									: "Error : Debes ingresar un numero de fila y columna correctos";
							assert (!usuarioMueveFicha(tablero, fila, columna)) : "Lugar ya ocupado por otra ficha.";
						} catch (InputMismatchException e) {
							System.out.println(e.getMessage());
						}  catch(AssertionError e) {
							System.out.println(e.getMessage());
						} finally {
							reader.nextLine();
						}
					} while (fila > 2 || fila < 0 || columna > 2 || columna < 0 && usuarioMueveFicha(tablero, fila, columna));
					usuarioMueveFicha(tablero, fila, columna);
				}
				if (!esGanador(turno, tablero)) {
					
					turno = turno == 'X' ? 'O' : 'X';
					
				} else {
					pintaTablero(tablero);
				}	
			}
			
			if (esGanador(turno, tablero)) {
			System.out.println("Ha ganado el jugador " + turno);
			} else {
				System.out.println("Ha sido empate.");
			}

			// llamamos a la funcion que se encarga de dejar en tablero a 0
			limpiarTablero(tablero);

			System.out.println("Quieres volver a jugar? S / N");
			repetir = reader.next().toUpperCase().charAt(0);

		} while (repetir == 'S');

		// cerramos el escaner
		reader.close();
	}

	static void inicializar(char tablero[][]) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j] = '-';
			}
		}
	}

	static void pintaTablero(char tablero[][]) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				System.out.print(tablero[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

	static boolean jugadorInicial() {

		// llamamos al objeto random para que genere un booleano aleatorio
		boolean turno = random.nextBoolean();

		// devolvemos el resultado
		return turno;
	}

	static void mueveFichaAleatoria(char tablero[][]) {

		int numeroUnoAleatorio = 0;
		int numeroDosAleatorio = 0;

		do {
			numeroUnoAleatorio = random.nextInt(0, 3);
			numeroDosAleatorio = random.nextInt(0, 3);
			
		} while (tablero[numeroUnoAleatorio][numeroDosAleatorio] != '-');
		
		tablero[numeroUnoAleatorio][numeroDosAleatorio] = 'O';

	}

	static boolean usuarioMueveFicha(char tablero[][], int fila, int columna) {
		// inicializamos el booleano que se retornara segun la salida de la funcion
		boolean valida;

		// if else para saber si la posicion esta ocupada o no
		if (tablero[fila][columna] == '-') {
			tablero[fila][columna] = 'X';
			valida = true;
		} else {
			valida = false;
		}

		// devolvemos un booleano
		return valida;
	}
	static void limpiarTablero(char tablero[][]) {

		// borramos el tablero completamente
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j] = ' ';
			}
		}
	}
	
	static boolean esEmpate(char tablero[][]) {
		boolean esEmpate = true;
	    for (int i = 0; i < tablero.length; i++) {
	        for (int j = 0; j < tablero[i].length; j++) {
	            if (tablero[i][j] == '-') {
	                esEmpate = false; 
	            }
	        }
	    }
	    return esEmpate;
	}

	static boolean esGanador(char turno, char tablero[][]) {
		
		boolean ganador = false;
        // Comprobar filas
        for (char[] fila : tablero) {
            if (fila[0] == turno && fila[1] == turno && fila[2] == turno) {
                ganador = true;
            }
        }

        // Comprobar columnas
        for (int i = 0; i < 3; i++) {
            if (tablero[0][i] == turno && tablero[1][i] == turno && tablero[2][i] == turno) {
                ganador = true;
            }
        }

        // Comprobar diagonales
        if (tablero[0][0] == turno && tablero[1][1] == turno && tablero[2][2] == turno) {
            ganador = true;
        }
        if (tablero[0][2] == turno && tablero[1][1] == turno && tablero[2][0] == turno) {
            ganador = true;
        }

        return ganador;
    }
}