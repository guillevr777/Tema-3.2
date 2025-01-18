package examenrecuperacion;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ExamenRecuperacion {
	
	//declaramos el array tablero que posteriormente se inicilizara y llenara
	static char[][] tablero;
	
	//creamos un variable global de enteros para la posicion de fila del jugador
	static int posI;
	
	//creamos un variable global de enteros para la posicion de columna del jugado
	static int posJ;


	public static void main(String[] args) {
		
		//creamos el escaner
		Scanner reader = new Scanner(System.in);
		
		//creamos una variable para las filas
		int filasTablero;
		
		//creamos una variable para las columnnas
		int columnaTablero;
		
		//variables de tipo entero para inicilizar las filas del tablero
		int filas = 0; 
		
		//variables de tipo entero para inicilizar las columnas del tablero
		int columnas = 0;
		
		//creamos variable booleana ganador para controlar cuando gana
		boolean ganador = false;
		
		//generamos una variable constante de tipo entero para los obstaculos
		final int NUMEROOBSTACULOS;
		
		//variable de tipo string para saber en que direccion moverse
		String direccion = "";
		
		//Le damos a los jugadores la bienvenida al juego
		System.out.println("Bienvenido al juego de la busqueda del tesoro!");
		
		//hacemos un bucle para que hasta que las filas y columnas sean correctas repita el try catch
		while (filas < 2 || columnas < 2) {
		try {
		//preguntamos por las medidas del tablero
		System.out.println("Dime las medidas del tablero :");
		
		//recogemos los resultados introducidos
		filas = reader.nextInt();
		columnas = reader.nextInt();
		
			assert filas >= 2 && columnas >= 2 
					: "Error : Has introducido numeros inferiores a 2 filas y 2 columnas, vuelve a intentarlo :";
		} catch (AssertionError e) {
			System.out.println(e.getLocalizedMessage());
			reader.nextLine();
		}
		}
		//llamamos a la funcion para que inicilice el tablero
		inicializaTablero(filas, columnas);
		
		//le damos valor a NUMEROOBSTACULOS
		NUMEROOBSTACULOS =(int)Math.sqrt((filas*columnas)/2);
		
		//generar tesoro
		generaPosicionTesoro();
		
		//llamamos a la funcion generar obstaculos para que genere un numeron determinado en un espacio aleatorio
		generaObstaculos(NUMEROOBSTACULOS);
		
		//pintamos el tablero llamando a la funcion
		pintaTablero();
		
		//llamamos a la funcion para generar la posicion del jugador de forma aleatoria
		generaPosicionJugador();
		
		//creamos while para que haste que encuentre el tesoro no gane
		while (!ganador) {
		do {
		//preguntamos por posicion al jugador
		System.out.println("En que direccion quieres moverte?");
		direccion = reader.next().toUpperCase();
		} while (mueveJugador(direccion) != 0);
		if (tablero[posI][posJ] == 'X') {
			System.out.println("Has encontrado el tesoro, Enhorabuena!");
			ganador = true;
		} else if  (direccion.equals("DERECHA")) {
			posJ++;
		} else if (direccion.equals("IZQUIERDA")) {
			posJ--;
		}  else if (direccion.equals("ARRIBA")) {
			posI--;
		} else if (direccion.equals("ABAJO")){
			posI++;
		}
		//en la suma de posicion de fila o columna hay que poner un limite para que si llega al borde no se efecvtue el movimiento pero no me da tiempo
		//Imprimmos el tablero para ver el progreso
		pintaTablero();
		}
		
		//cerramos el escaner
		reader.close();
	}
	static void inicializaTablero(int numFilas, int numColumnas) {
		//inicilizamos el tablero dando un numero entero de filas y columnas
		tablero = new char[numFilas][numColumnas];
		
		//creamos un bucle for para recorrer el array entero e inicilizarlo a espacios vacios
		for (int i = 0 ; i < tablero.length ; i++) {
			for (int j = 0 ; j < tablero[i].length ; j++) {
				tablero[i][j] = ' ';
			}
		}
	}
	static void generaPosicionTesoro() {
		//creamos el random para poder generar numeros aleatoriamente
		Random random = new Random();
		
		//onde esta?
		int tesoroFila;
		int tesoroColumna;
		
		//creamos una variable entera para generar la posicion de la fila donde ira el tesoro
		int posFila = random.nextInt(0, tablero.length);
		
		//creamos una variable entera para generar la posicion de la columna donde ira el tesoro
		int posColumna = random.nextInt(0, tablero[0].length);
		
		tablero[posFila][posColumna] = 'X';
		
		tesoroFila = posFila;
		tesoroColumna = posColumna;
		
		System.out.print(tesoroFila + " y " + tesoroColumna);
	}
	static void generaObstaculos(int numObstaculos) {
		//creamos el random para poder generar numeros aleatoriamente
		Random random = new Random();
		
		//creamos variable fila para generar el random
		int fila;
		
		//creamos variable fila para generar el random
		int columna;
		
		//creamos variable entera para contar el numero de obstaculos colocados
		int obsColocados = 0;
		
		//posible implementacion para impedir uso de diiagonales
//		for (int i = 0 ; i < tablero.length ; i++) {
//			for (int j = 0 ; j < tablero[i].length ; j++) {
//				
//				if (tablero[i][j] != 'X') {
//				for (int filaCerca = -1 ; filaCerca <= 1 ; filaCerca++) {
//					for (int columnaCerca = -1 ; columnaCerca <= 1 ; columnaCerca++) {
//						filaCercana = i + filaCerca;
//						columnaCercana = j + columnaCerca;
//						if (filaCercana >= 0 && filaCercana < tablero.length && columnaCercana >= 0 && columnaCercana < tablero[0].length && !(filaCerca == 0 && columnaCerca == 0)) {
//							
//							}
//						}
//					}
//				}
//			}
//		}
		
		//creamos for para hacer un bucle de veces determinadas que sera el numero de obstaculos
		for (int i = 0 ; i < numObstaculos ; i++) {
		//creamos un while para colocar dichos obstaculos en lugares aleatorios y que no se repitan
		do {
			fila = random.nextInt(0, tablero.length);
			columna = random.nextInt(0, tablero[0].length);
			} while (tablero[fila][columna] == 'X' || tablero[fila][columna] == '*');
			tablero[fila][columna] = '*';
			obsColocados++;
		}
	}
	static void generaPosicionJugador() {
		//creamos el random para poder generar numeros aleatoriamente
		Random random = new Random();
		
		//creamos un do while para que genere numero aleatorio hasta que encuentre un sitio vacio
		do {
			posI = random.nextInt(0, tablero.length);
			posJ = random.nextInt(0, tablero[0].length);
			} while (tablero[posI][posJ] == ' ');
	}
	static void pintaTablero() {
		//creo variable numero para los indices
		int numero = 1;
		
		//creamos un for para poner los indices de las columnas
		for (int i = 0 ; i < tablero[0].length ; i++) {
			System.out.print("\t" + (numero+i));
		}
		System.out.println("\n");
		//devolvemos el valorn original a numero para los indices de las filas
		numero = 1;
		//creamos un bucle for para recorrer el array entero e imprimirlo evitando imprimir el tesoro
		for (int i = 0 ; i < tablero.length ; i++) {
			System.out.print((numero+i) + "\t");
			for (int j = 0 ; j < tablero[i].length ; j++) {
				//creamos un if para indicar que si la casilla no es el tesoro lo imprima y sino haga un espacio en blanco
				if (i == posI && j == posJ) {
					System.out.print('J' + "\t");
				} else {
				if (tablero[i][j] != 'X') {
				System.out.print(tablero[i][j] + "\t");
				} else {
					System.out.print(' ' + "\t");
				}
				}
			}
			System.out.println("\n");
		}
	}
	static int mueveJugador(String movimiento) {
		int moverse = -2;
		if (posI == 0 || posI > tablero.length || posJ == 0 || posJ >tablero[0].length) {
			moverse = -1;
		}
		if (movimiento.equals("DERECHA") || movimiento.equals("IZQUIERDA") || movimiento.equals("ARRIBA") || movimiento.equals("ABAJO")) {
			moverse = 0;
		}
		if (moverse == -2) {
			System.out.println("No entiendo el movimiento");
		}
		return moverse;
	}
}
