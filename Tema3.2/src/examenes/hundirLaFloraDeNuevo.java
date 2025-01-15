package examenes;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class hundirLaFloraDeNuevo {
	
	static Random random = new Random();
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		
		//array que sera el tablero
		char tablero[][];
		
		//tablero jugador 1
		char tableroUno[][];
		
		//tablero 2
		char tableroDos[][];
		
		//variables para almacenar las filas y columnas
		int filas;
		int columnas;
		
		//variable constante de numero barcos
		final int NUMEROBARCOS;
		
		//creamos el booleano ganador
		boolean ganador = false;
		
		//variable jugador para cambiar turnos
		char jugador = 'X';
		
		//jugador repite turno=
		boolean jugadorRepite = false;
		
		//puntuacion jugadores
		int puntosJugadorUno = 0;
		int puntosJugadorDos = 0;
		
		//preguntamos por las filas y columnas
		System.out.println("Cuantas filas y columnas tendra el tablero:");
		filas = reader.nextInt();
		columnas = reader.nextInt();
		
		//llamamos a la funcion inicializarTablero
		tableroUno = inicializaTablero(filas, columnas);
		tableroDos = inicializaTablero(filas, columnas);
		
		//llamamos a la funcion para que cree e inicialice los tableros de los jugadores
		tablero = creaTablero(filas, columnas);
		
		//variable para el numero de barcos
		NUMEROBARCOS = (int)Math.sqrt(filas*columnas);

		//generamos un numero de barquitos llamando a la funcion
		generarBarquitos(tablero, NUMEROBARCOS);
		System.out.println(NUMEROBARCOS + " Aqui");
		pintaTablero(tablero);
		while (!ganador) {
			do {
				jugadorRepite = false;
			if (jugador == 'X') {
				System.out.println("Es el turno del jugador X");
				pintaTablero(tableroUno);
				//llamamos a la funcion turnoJugador
				if (turnoJugador(tablero, tableroUno)) {
					puntosJugadorUno++;
					jugadorRepite = true;
				}
			} else {
				System.out.println("Es el turno del jugador O");
				pintaTablero(tableroDos);
				if (turnoJugador(tablero, tableroDos)) {
					puntosJugadorDos++;
					jugadorRepite = true;
				}
			}
			if (puntosJugadorUno >= NUMEROBARCOS || puntosJugadorDos >= NUMEROBARCOS) {
				jugadorRepite = false;
			}
		} while (jugadorRepite);
			if (puntosJugadorUno != NUMEROBARCOS && puntosJugadorDos != NUMEROBARCOS) {
				jugador = jugador == 'X' ? 'O' : 'X';
			}
		}
		pintaTablero(tablero);
		System.out.println("Ha ganado el jugador " + jugador);
		
		//cerramos el escaner
		reader.close();
	}
	static char[][] inicializaTablero(int filas, int columnas) {
		char tableroInicializado[][] = new char[filas][columnas];
		for (int i = 0 ; i < tableroInicializado.length ; i++) {
			for (int j = 0 ; j < tableroInicializado[i].length ; j++) {
				tableroInicializado[i][j] = '-';
			}
		}
		return tableroInicializado;
	}
	static char[][] creaTablero(int filas, int columnas) {
		char tableroInicializado[][] = new char[filas][columnas];
		for (int i = 0 ; i < tableroInicializado.length ; i++) {
			for (int j = 0 ; j < tableroInicializado[i].length ; j++) {
				tableroInicializado[i][j] = 'A';
			}
		}
		return tableroInicializado;
	}
	static void generarBarquitos(char tablero[][], int numBarquitos) {
		int fila = 0;
		int columna = 0;
		for (int i = 0 ; i < numBarquitos ; i++) {
				do {
					fila = random.nextInt(tablero.length);
					columna = random.nextInt(tablero[0].length);
				} while (tablero[fila][columna] != 'A');
				tablero[fila][columna] = 'B';
		}
	}
	static void pintaTablero(char tablero[][]) {
		char letra = 'A';
		for (int i = 0 ; i < tablero[0].length ; i++) {
			System.out.print("\t"+ (int) (1+i));
		}
		System.out.println("\n");
		for (int i = 0 ; i < tablero.length ; i++) {
			System.out.print((char)(letra+i));
			for (int j = 0 ; j < tablero[i].length ; j++) {
				System.out.print("\t" + tablero[i][j]);
			}
			System.out.println("\n");
		}
	}
	static boolean turnoJugador(char tablero[][], char tableroJugador[][]) {
		
		//boolean que se devolvera
		boolean hundido;
		
		//variables para guardar valor fila y columna
		int fila = 0;
		int columna = 0;
		
		//creamos boolean para el control de excepciones
		boolean entradaValida;
		
		do {
		try {
			entradaValida = true;
		//preguntamos por posicion
		System.out.println("Donde quieres colocar tu barco?");
		fila = reader.nextInt()-1;
		columna = reader.nextInt()-1;
		assert fila >= 0 && fila < tablero.length && columna >= 0 && columna < tablero[0].length : "Error : Te has salido de la tabla";
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			entradaValida = false;
		} finally {
			reader.nextLine();
		}
		} while (!entradaValida);
		
		if (tablero[fila][columna] == 'B') {
			tableroJugador[fila][columna] = 'B';
			System.out.println("Hundido");
			hundido = true;
		} else {
			tableroJugador[fila][columna] = 'A';
			System.out.println("Agua");
			hundido = false;
		}
		
		return hundido;
	}
}
