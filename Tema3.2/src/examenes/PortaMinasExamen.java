package examenes;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PortaMinasExamen {
	
	static Scanner reader = new Scanner(System.in);
	static Random random = new Random();

	public static void main(String[] args) {
		
		//numero de filas
		int filas;
		
		//numero columnas
		int columnas;
		
		//donde descubre la posicion
		char fila = 0;
		int columna = 0;
		
		//preguntamos por numero columna y filas
		System.out.println("Cuantas filas y columnas tendra el tablero:");
		filas = reader.nextInt();
		columnas = reader.nextInt();
		
		//tablero jugador
		char tableroJugador[][];
				
		//tablero principal donde estaran las minas
		char tablero[][];
		
		//inicializamos fuilase
		int filase = 0;
		
		//inicializamos los tableros llamando a la funcion
		tablero = inicializaTablero(filas, columnas);
		tableroJugador = inicializaTablero(filas, columnas);
		
		//numero de minas que habran en el tablero
		final int NUMEROMINAS = (filas * columnas) / 5;
		
		//booleano para cuando explote una mina
		boolean minaExplotada = false;
		
		//colocamos las minas en el tablero
		colocarMinas(tablero, NUMEROMINAS);
		
		//calculamos los huecos vacios cerca de minas
		calcularClues(tablero);
		
		//damos la bienvenida al juego
		System.out.println("Bienvenido al juego de las minas!");
		
		 while (!minaExplotada && !comprobar(tableroJugador, NUMEROMINAS)) {
		//imprimimos el tablero
		imprimirTablero(tableroJugador);
		try {
		//preguntamos por la posicion a descubrir
		System.out.println("Dime una fila y columna donde desvelar la posicion:");
		fila = reader.next().toUpperCase().charAt(0);
		filase = fila-'A';
		columna = reader.nextInt()-1;
			assert filase >= 0 && filase < tablero.length && columna >= 0 && columna < tablero[0].length 
					: "Error ; Te saliste de la tabla";
		} catch (InputMismatchException e) {
		    System.out.println("Error: Entrada inválida. Por favor, introduce una letra para la fila y un número para la columna.");
		    reader.nextLine();
		} catch (AssertionError e) {
		    System.out.println(e.getMessage());
		}
		
		if (descubrirCelda(tableroJugador, tablero, fila, columna)) {
			tableroJugador[filase][columna] = tablero[filase][columna];
		} else {
			System.out.println("Habia una mina en esa posicion!");
			tableroJugador[filase][columna] = tablero[filase][columna];
			System.out.println("Has perdido!");
			minaExplotada = true;
		}
		}
		
		//imprimimos el tablero
		imprimirTablero(tablero);
				
		System.out.println("Termino?");
		
		reader.close();
		
	}
	static char[][] inicializaTablero(int filas, int columnas) {
		
		char tablero[][] = new char[filas][columnas];
		
		for (int i = 0 ; i < tablero.length ; i++) {
			for (int j = 0 ; j < tablero[i].length ; j++) {
				tablero[i][j] = '-';
			}
		}
		return tablero;
	}
	static void colocarMinas(char[][] tablero, int numMinas) {
		
		//filas donde se pondran las minas
		int fila;
		int columna;
		
		//preguntamos por posicion hasta que sea igual a '-'
		for (int i = 0 ; i < numMinas ; i++) {
		do {
			fila = random.nextInt(0, tablero.length);
			columna = random.nextInt(0, tablero[0].length);
		} while (tablero[fila][columna] != '-');
		tablero[fila][columna] = '*';
		}
	}
	static void calcularClues(char[][] tablero) { 
		int numMinas;
		int filaVecina;
		int columnaVecina;
		
		for (int i = 0 ; i < tablero.length ; i++) {
			for (int j = 0 ; j < tablero[i].length ; j++) {
				if (tablero[i][j] != '*') {
					numMinas = 0;
					for (int filaCerca = -1 ; filaCerca <= 1 ; filaCerca++) {
						for (int columnaCerca = -1 ; columnaCerca <= 1 ; columnaCerca++) {
							filaVecina = i + filaCerca;
							columnaVecina = j + columnaCerca;
							if (filaVecina >= 0 && filaVecina < tablero.length && columnaVecina >= 0 && columnaVecina < tablero[i].length && !(filaCerca == 0 && columnaCerca == 0)) {
								if (tablero[filaVecina][columnaVecina] == '*') {
									numMinas++;
								}
							}
						}	
					}
					tablero[i][j] = (char)(numMinas + '0');
				}
			}
		}
	}
	static void imprimirTablero(char[][] tablero) {
		char letra = 'A';
		for (int i = 0 ; i < tablero[0].length ; i++) {
			System.out.print("\t" +(int)(1+i));
		}
		System.out.println("\n");
		for (int i = 0 ; i < tablero.length ; i++) {
			System.out.print((char)(letra+i));
			for (int j = 0 ; j < tablero[i].length ; j++) {
				System.out.print("\t" + tablero[i][j]);
			}
			System.out.println();
		}
	}
	static boolean descubrirCelda(char[][] tableroVisible, char[][] tableroOculto, char fila, int columna) {
		
		//creamos un booleano para devolver
		boolean salvado = false;
		
		int filas = (int)fila-65;
		
			if (tableroOculto[filas][columna] != '*') {
					salvado = true;
			}
			
		return salvado;
	}
	static boolean comprobar(char[][] tableroVisible, int numMinas) {
		boolean terminar = false;
		int contador = 0;
		
		//vemos que hay en la posicion
		for (int i = 0 ; i < tableroVisible.length ; i++) {
			for (int j = 0 ; j < tableroVisible[i].length ; j++) {
				if (tableroVisible[i][j] == '-') {
					contador++;
				}
			}
		}
		if (contador == numMinas) {
			System.out.println("Has ganado el juego crack!");
			terminar = true;
		}
		return terminar;
	}
}
