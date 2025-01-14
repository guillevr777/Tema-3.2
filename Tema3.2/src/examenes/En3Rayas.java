package examenes;

import java.util.Random;
import java.util.Scanner;

public class En3Rayas {
	
	static Random random = new Random();
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {

		//creamos el array de tipo char que sera el tablero del juego
		char tablero[][] = new char[3][3];
		
		//creamos variable para cambiar el turno de los jugadores
		char turno = jugadorInicial() == true ? 'X' : 'O';
		
		//creamos la variable booleana ganador para verificar cuando salir del while
		boolean ganador = false;
		
		//llamamos a la funcion inicializar para que coloque el tablero
		inicializar(tablero);
		
		while (!ganador) {
	
			if (turno == 'O') {
				mueveFichaAleatoria(tablero);
				pintaTablero(tablero);
			} else {
		System.out.println("Turno del jugador X");
		//pintamos el tablero
		pintaTablero(tablero);
		System.out.println("En que fila y columna quieres colocar la ficha?");
		int fila = reader.nextInt();
		int columna = reader.nextInt();
			}
			if () {
				ganador = true;
			}
		}
		System.out.println("Ha ganado el jugador " + turno);
		
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
		
		while (tablero[numeroUnoAleatorio][numeroDosAleatorio] == '-') {
			numeroUnoAleatorio = random.nextInt();
			numeroDosAleatorio = random.nextInt();
			
			if (tablero[numeroUnoAleatorio][numeroDosAleatorio] == '-') {
				tablero[numeroUnoAleatorio][numeroDosAleatorio] = 'O';
			}
		}
	}
}
