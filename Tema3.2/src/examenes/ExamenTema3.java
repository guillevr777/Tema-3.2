package examenes;

import java.util.Random;
import java.util.Scanner;

public class ExamenTema3 {
	
	//creamos el escaner
	static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args) {
		// ejercicio probado con arrays de 5x5 

		//declaramos las variables para filas y columnas de los arrays
		int numeroFilas;
		int numeroColumnas;
		
		//boolean para controlar cuando ha undido algo uno de los dos
		boolean jugador1 = true;
		boolean jugador2 = true;
		
		//contadores para saber la puntuacion de ambos jugadores
		int barcosTocados1 = 0;
		int barcosTocados2 = 0;
		
		//creamos una variable para almacenar el numero de barcos que hay
		final int NUMEROBARCOS;
		
		//creo las tres tablas para ambos jugadores y la maquina
		char tabla1[][];
		char tabla2[][];
		char tablaMaquina[][];
		
		//booleana para mostrar quien gana y detener el juego
		boolean ganador = false;
		
		//presentacion
		System.out.println("Bienvenido al juego del calamar");
		
		//preguntamos por el tamaño de los arrays
		System.out.println("Dime cuantas filas y columnas quieres los arrays separado por un espacio :");
		numeroFilas = reader.nextInt();
		numeroColumnas = reader.nextInt();
		
		//creo las tres tablas para ambos jugadores y la maquina
		tabla1 = inicializaTablero(numeroFilas, numeroColumnas);
		tabla2 = inicializaTablero(numeroFilas, numeroColumnas);
		tablaMaquina = creaTablero(numeroFilas, numeroColumnas);
	
		//calculamos la raiz cuadrada de filas * columnas para sacar el numero de barcos
		NUMEROBARCOS = (int)Math.sqrt(numeroFilas*numeroColumnas);
		
		//generamos los barquitos llamando a la funcion generarBarquitos
		generarBarquitos(tablaMaquina, NUMEROBARCOS);
		
		while (barcosTocados1 != NUMEROBARCOS && barcosTocados2 != NUMEROBARCOS) {
		
			if (jugador1 == true) {
				
				//preguntamos por el lugar donde cree que hay un barco
				System.out.println("Es el turno del jugador uno");

			
			if (turnoJugador(tablaMaquina, tabla1)) {
				
				jugador1 = true;
				barcosTocados1++;
				
			} else {
				
				jugador1 = false;
				
			}
			} else {
				
			//preguntamos por el lugar donde cree que hay un barco
			System.out.println("Es el turno del jugador dos");

				
			if (turnoJugador(tablaMaquina, tabla2)) {
				
				barcosTocados2++;

			} else {
				
				jugador1 = true;
				
			}
			}
			
			
	}
		if (barcosTocados1 >= NUMEROBARCOS) {
			System.out.println("Gano el jugador uno!");
		} else {
			System.out.println("Gano el jugador dos!");
		}
		//cerramos el escaner
		reader.close();
}
	//funcion encargada de inicializar la tabla a guiones medios
	static char[][] inicializaTablero(int fila, int columna) {
		char t[][] = new char[fila][columna];
		for (int i = 0 ; i < fila ; i++) {
			for (int j = 0 ; j < columna ; j++) {
				t[i][j] = '-';
			}
		}
		return t;
	}
	//funcion encargada de crear el tablero principal donde se hubicaran los barcos
		static char[][] creaTablero(int fila, int columna) {
			char t[][] = new char[fila][columna];
			for (int i = 0 ; i < fila ; i++) {
				for (int j = 0 ; j < columna ; j++) {
					t[i][j] = 'A';
				}
			}
			
			return t;
		}
		static void generarBarquitos(char tablero[][], int numBarquitos) {
			Random random = new Random();
			
			//creo una variable para controlar la posicion aleatoria que pueda salir
			int fila;
			int columna;
			
			//creamos un for para que repita cuantas veces como barcos haya
			for (int i = 0 ; i < numBarquitos ; i++) {
				//generara una posicion random hasta que no haya un barco ya en ella
				do {
					fila = random.nextInt(0, tablero.length);
					columna = random.nextInt(0, tablero.length);
				} while (tablero[fila][columna] == 'B');
				//cuando salga del while asignara B a esa posicion
				tablero[fila][columna] = 'B';
			}
		}
		static void pintaTablero(char tableroJugador[][]) {
			//creamos una variable que contenga A
			char letra = 'A';
			
			//creamos un for para imprimir el numero de las columnas
			for (int i = 0 ; i < tableroJugador.length ; i++) {
				System.out.print("\t" + (i+1));
			}
			//Syso para salto de linea
			System.out.println();
			
			//for para imprimir el contenido de la tabla y la letra de las filas
			for (int i = 0 ; i < tableroJugador.length ; i++) {
				System.out.print((char)(letra+i) + "\t");
				for (int j = 0 ; j < tableroJugador.length ; j++) {
					System.out.print(tableroJugador[i][j] + "\t");
				}
				System.out.println();
			}
		}
		static boolean turnoJugador(char tablero[][], char tableroJugador[][]) {
			
			//creamos un booleaano para devolver cuando llamen la funcion
			boolean respuesta;			
			
			//creamos variables para la posicion del disparo
			char fila;
			int disparoColumna;
			int disparoFila;
						
			pintaTablero(tableroJugador);
			System.out.println("Donde quieres disparar?(Fila en letras y columna en numero separados por un espacio");
			fila = reader.next().charAt(0);
			disparoColumna = reader.nextInt();
			disparoFila = (int)(fila-65);
			
			//creamos if para que si hay un barco cambie el contenido en la tabla y se lo diga al jugador sino agua
			if (tablero[disparoFila][disparoColumna-1] == 'B') {
				System.out.println("Has undido un barco!");
				tableroJugador[disparoFila][(disparoColumna-1)] = 'X';
				respuesta = true;
			} else {
				System.out.println("Solo habia agua :(");
				tableroJugador[disparoFila][(disparoColumna-1)] = 'A';
				respuesta = false;
		}
			return respuesta;
	}
}
	
