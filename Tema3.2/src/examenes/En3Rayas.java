package examenes;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class En3Rayas {
	
	static Random random = new Random();
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {

		//creamos el array de tipo char que sera el tablero del juego
		char tablero[][] = new char[3][3];
		
		//variable por si se quiere volver a jugar
		char repetir;
		
		do {
		
		//llamamos a la funcion inicializar para que coloque el tablero
		inicializar(tablero);
		
		//creamos variable para cambiar el turno de los jugadores
		char turno = jugadorInicial() == true ? 'X' : 'O';
				
		//creamos la variable booleana ganador para verificar cuando salir del while
		boolean ganador = false;
		
		//declaramos las variables donde se almacenara la fila y columna donde desea el jugador colocar la ficha
		int fila = 0;
		int columna = 0;
		
		//llamamos a la funcion inicializar para que coloque el tablero
		inicializar(tablero);
		
		//bienvenida a los jugadores
		System.out.println("Bienvenido al juego del 3 en rayas");
		
		while (!ganador) {
	
			if (turno == 'O') {
				System.out.println("Turno del jugador O");
				mueveFichaAleatoria(tablero);
				pintaTablero(tablero);
				} else {
				boolean jugadaValida = false;
				System.out.println("Turno del jugador X");
				do {
					try {
					System.out.println("En que fila y columna quieres colocar la ficha?");
					fila = reader.nextInt()-1;
					columna = reader.nextInt()-1;
					
					if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
						
					System.out.println("Error : Debes ingresar un numero de fila y columna correctos");
						
					} else if (!usuarioMueveFicha(tablero, fila, columna)) {
						System.out.println("Ya se encuentra una ficha en este lugar.");
					} else {
						jugadaValida = true;
					}
					} catch (InputMismatchException e) {
						System.err.println("Error: Entrada inválida. Debes ingresar números.");
					} finally {
						reader.next();
					}
				} while (!jugadaValida);
				//pintamos el tablero
				pintaTablero(tablero);
			}
			if (esGanador(turno, tablero)) {
				ganador = true;
			} else {
				turno = turno == 'X' ? 'O' : 'X';
			}
		}
		System.out.println("Ha ganado el jugador " + turno);
		
		//llamamos a la funcion que se encarga de dejar en tablero a 0
		limpiarTablero(tablero);
		
		System.out.println("Quieres volver a jugar? S / N");
		repetir = reader.next().toUpperCase().charAt(0);
		
		} while (repetir == 'S');
		
		//cerramos el escaner
		reader.close();
	}
	static void inicializar(char tablero[][]) {
		for (int i = 0 ; i < tablero.length ; i++) {
			for (int j = 0 ; j < tablero.length ; j++) {
				tablero[i][j] = '-';
			}
		}
	}
	static void pintaTablero(char tablero[][]) {
		for (int i = 0 ; i < tablero.length ; i++) {
			for (int j = 0 ; j < tablero.length ; j++) {
				System.out.print(tablero[i][j] + "\t");
			}
			System.out.println( "\n" );
		}
	}
	static boolean jugadorInicial() {
		
		//llamamos al objeto random para que genere un booleano aleatorio
		boolean turno = random.nextBoolean();
		
		//devolvemos el resultado
		return turno;
	}
	static void mueveFichaAleatoria(char tablero[][]) {
		
		int numeroUnoAleatorio = 0;
		int numeroDosAleatorio = 0;
		
		do  {
			
			numeroUnoAleatorio = random.nextInt(0, 3);
			numeroDosAleatorio = random.nextInt(0, 3);
			
		} while (tablero[numeroUnoAleatorio][numeroDosAleatorio] != '-');
		
		tablero[numeroUnoAleatorio][numeroDosAleatorio] = 'O';
		
	}
	static boolean usuarioMueveFicha(char tablero[][], int fila, int columna) {
		//inicializamos el booleano que se retornara segun la salida de la funcion
		boolean valida;
		
		//if else para saber si la posicion esta ocupada o no
		if (tablero[fila][columna] == '-') {
			tablero[fila][columna] = 'X';
			valida = true;
		} else {
			valida = false;
		}
		
		//devolvemos un booleano
		return valida;
	}
	static void limpiarTablero(char tablero[][]) {
		
		//borramos el tablero completamente
		for (int i = 0 ; i < tablero.length ; i++) {
			for (int j = 0 ; j < tablero.length ; j++) {
				tablero[i][j] = ' ';
			}
		}
	}
	static boolean esGanador(char turno, char tablero[][]) {
		// inicializamos el boolean que posteriormente devolveremos al llamar a la
		// funcion
		boolean ganador = false;

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				// si hay 3 circulos o equis en horizontal gana
				if (tablero[i][0] == turno && tablero[i][1] == turno && tablero[i][2] == turno) {
					ganador = true;
				}
				// si hay 3 circulos o equis en vertical gana
				if (tablero[0][i] == turno && tablero[1][i] == turno && tablero[2][i] == turno) {
					ganador = true;
				}
			}
		}
		// si hay 3 circulos o equis en diagonal gana
		if (tablero[0][0] == turno && tablero[1][1] == turno && tablero[2][2] == turno
				|| tablero[0][2] == turno && tablero[1][1] == turno && tablero[2][0] == turno) {
			ganador = true;
		}

		// devolvemos un boolean en caso ganador true sino false
		return ganador;
	}
}