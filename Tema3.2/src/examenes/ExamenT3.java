package examenes;

import java.util.Random;
import java.util.Scanner;

public class ExamenT3 {
	
	static Scanner reader = new Scanner(System.in);

	public static void main(String[]args) {
		
		//variable jugador
		int jg1 = 0;
		int jg2 = 0;
		
		//variable turno
		boolean turno = true;
		
		//creamos las variables filas y columnas
		int filas;
		int columnas;
		
		//pedimos al usuario las medidas del tablero
		System.out.println("Dime cuanto mide el tablero:");
		filas = reader.nextInt();
		columnas = reader.nextInt();
		
		//creamos una variable para el numero de barquitos
		int numeroBarquitos = (int) Math.floor(filas * columnas);
				
		//inicializo los tableros de los jugadores y el principal
		char tableroJugadorUno[][];
		char tableroJugadorDos[][];
		char tablero[][];
				
		//LLamo a las funciones para inicializar las tablas de los jugadores y el tablero principal donde se pondran los barcos aleatoriamente
		tableroJugadorUno = inicializaTablero(filas,columnas);
		tableroJugadorDos = inicializaTablero(filas,columnas);
		tablero = creaTablero(filas,columnas);
		
		//generamos los barcos en la tabla principal
		generarBarquitos(tablero, numeroBarquitos);
		
		System.out.println("Bienvenidos a hundir el barco");
		
		 // Variables para el juego
        boolean ganador = false;
        int barcosJugador1 = 0, barcosJugador2 = 0;

        // Turnos del juego
        while (!ganador) {
            System.out.println("Turno del Jugador 1");
            if (turnoJugador(tablero, tableroJugadorUno)) {
                barcosJugador1++;
                if (barcosJugador1 == numeroBarquitos) {
                    System.out.println("¡Jugador 1 ha ganado!");
                    ganador = true;
                    break;
                }
            }

            System.out.println("Turno del Jugador 2");
            if (turnoJugador(tablero, tableroJugadorDos)) {
                barcosJugador2++;
                if (barcosJugador2 == numeroBarquitos) {
                    System.out.println("¡Jugador 2 ha ganado!");
                    ganador = true;
                }
            }
        }
    }
	static char[][] inicializaTablero (int filas, int columnas) {
		
		char[][] tablero = new char[filas][columnas];
		
		for (int i = 0 ; i < filas ; i++) {
			for (int j = 0 ; j < columnas ; j++) {
				tablero[i][j] = '-';
			}
		}
		return tablero;
	}
	static char[][] creaTablero (int filas, int columnas) {
		
		char [][] tablero = new char[filas][columnas];
		
		for (int i = 0 ; i < filas ; i++) {
			for (int j = 0 ; j < columnas ; j++) {
				tablero[i][j] = 'A';
			}
		}
		return tablero;
	}
	static void pintaTablero(char tableroJugador[][]) {
		
		char letra = 'A';
		
			System.out.println();
			System.out.print("\t");
		
		for (int i = 0 ; i < tableroJugador[1].length ; i++) {
			System.out.print(i+1 + "\t");
		}
		
		System.out.println();
		
		for (int i = 0 ; i < tableroJugador.length ; i++) {
			System.out.print(letra + "\t");
			for (int j = 0 ; j < tableroJugador[i].length ; j++) {
				
				System.out.print(tableroJugador[i][j] + "\t");
				
			}
			System.out.println();
			letra++;
		}
	}
	static void generarBarquitos(char tablero[][], int numBarquitos) {
		
		 Random random = new Random();
	        int filas = tablero.length;
	        int columnas = tablero[0].length;

	        int barcosGenerados = 0;
	        while (barcosGenerados < numBarquitos) {
	            int fila = random.nextInt(filas);
	            int columna = random.nextInt(columnas);
	            if (tablero[fila][columna] != 'B') {
	                tablero[fila][columna] = 'B';
	                barcosGenerados++;
	            }
	        }
	    }
	static boolean turnoJugador(char tablero[][], char tableroJugador[][]) {
		
		 boolean hundido = false;
		    int fila = -1;  // Valores predeterminados
		    int columna = -1;

		    try {
		        System.out.print("Introduzca la fila mediante una letra: ");
		        char filaChar = reader.next().toUpperCase().charAt(0);
		        fila = filaChar - 'A';

		        System.out.print("Introduzca el número de columna: ");
		        columna = reader.nextInt() - 1;

		        // Validar límites del tablero
		        assert fila >= 0 && fila < tablero.length && columna >= 0 && columna < tablero[0].length 
		        : "Error: ¡Te has salido de la tabla!";
		        
		        // Actualizar el tablero del jugador
		        tableroJugador[fila][columna] = tablero[fila][columna];

		        // Comprobar si hay un barco
		        if (tablero[fila][columna] == 'B') {
		            System.out.println("¡HUNDIDO!");
		            hundido = true;
		        } else {
		            System.out.println("AGUA.");
		        }
		    } catch (AssertionError e) {
		        System.out.println(e.getMessage());
		    } catch (Exception e) {
		        System.out.println("Error: Entrada inválida. Inténtelo de nuevo.");
		        reader.nextLine(); // Limpiar el buffer en caso de error
		    } finally {
		        System.out.println();
		    }

		    return hundido;
		}
}
