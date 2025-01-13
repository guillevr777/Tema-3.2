package examenes;

import java.util.Random;
import java.util.Scanner;

public class ExamentTema3Replica {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // Pedir dimensiones del tablero
	        System.out.println("Introduce el número de filas del tablero:");
	        int filas = sc.nextInt();
	        System.out.println("Introduce el número de columnas del tablero:");
	        int columnas = sc.nextInt();

	        // Crear y inicializar los tableros
	        char[][] tableroPrincipal = creaTablero(filas, columnas);
	        char[][] tableroJugador1 = inicializaTablero(filas, columnas);
	        char[][] tableroJugador2 = inicializaTablero(filas, columnas);

	        // Generar barquitos
	        int numBarcos = (int) Math.floor(filas * columnas / 4.0); // Ajustar la fórmula
	        generarBarquitos(tableroPrincipal, numBarcos);

	        // Inicializar contadores de barcos hundidos
	        int barcosHundidosJugador1 = 0;
	        int barcosHundidosJugador2 = 0;

	        // Juego principal
	        boolean jugador1Turno = true;
	        
	        while (barcosHundidosJugador1 < numBarcos && barcosHundidosJugador2 < numBarcos) {
	            if (jugador1Turno) {
	                System.out.println("Turno del Jugador 1:");
	                pintaTablero(tableroJugador1);
	                if (turnoJugador(tableroPrincipal, tableroJugador1)) {
	                    barcosHundidosJugador1++;
	                }
	            } else {
	                System.out.println("Turno del Jugador 2:");
	                pintaTablero(tableroJugador2);
	                if (turnoJugador(tableroPrincipal, tableroJugador2)) {
	                    barcosHundidosJugador2++;
	                }
	            }
	            jugador1Turno = !jugador1Turno; // Cambiar turno
	        }

	        // Determinar el ganador
	        if (barcosHundidosJugador1 == numBarcos) {
	            System.out.println("¡El Jugador 1 ha ganado!");
	        } else {
	            System.out.println("¡El Jugador 2 ha ganado!");
	        }

	        sc.close();
	    }

	    // Función para inicializar el tablero de cada jugador
	    public static char[][] inicializaTablero(int filas, int columnas) {
	        char[][] tablero = new char[filas][columnas];
	        for (int i = 0; i < filas; i++) {
	            for (int j = 0; j < columnas; j++) {
	                tablero[i][j] = '-';
	            }
	        }
	        return tablero;
	    }

	    // Función para crear el tablero principal
	    public static char[][] creaTablero(int filas, int columnas) {
	        char[][] tablero = new char[filas][columnas];
	        for (int i = 0; i < filas; i++) {
	            for (int j = 0; j < columnas; j++) {
	                tablero[i][j] = 'A';
	            }
	        }
	        return tablero;
	    }

	    // Función para generar barquitos aleatorios
	    public static void generarBarquitos(char[][] tablero, int numBarquitos) {
	        Random random = new Random();
	        int filas = tablero.length;
	        int columnas = tablero[0].length;

	        int barcosColocados = 0;
	        while (barcosColocados < numBarquitos) {
	            int fila = random.nextInt(filas);
	            int columna = random.nextInt(columnas);

	            if (tablero[fila][columna] != 'B') {
	                tablero[fila][columna] = 'B';
	                barcosColocados++;
	            }
	        }
	    }

	    // Función para pintar el tablero
	    public static void pintaTablero(char[][] tablero) {
	        System.out.print("  ");
	        for (int i = 0; i < tablero[0].length; i++) {
	            System.out.print((i + 1) + " ");
	        }
	        System.out.println();

	        for (int i = 0; i < tablero.length; i++) {
	            System.out.print((char) ('A' + i) + " ");
	            for (int j = 0; j < tablero[0].length; j++) {
	                System.out.print(tablero[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }

	    // Función para manejar el turno de un jugador
	    public static boolean turnoJugador(char[][] tablero, char[][] tableroJugador) {
	        Scanner sc = new Scanner(System.in);

	        System.out.println("Introduzca la fila mediante una letra:");
	        char letraFila = sc.next().toUpperCase().charAt(0);
	        System.out.println("Introduzca el número de columna:");
	        int columna = sc.nextInt();

	        int fila = letraFila - 'A'; // Convertir letra a índice
	        columna--; // Ajustar índice de columna (de 1 a 0 basado)

	        // Comprobar si la posición es válida
	        if (fila < 0 || fila >= tablero.length || columna < 0 || columna >= tablero[0].length) {
	            System.out.println("Posición no válida. Inténtelo de nuevo.");
	            return turnoJugador(tablero, tableroJugador); // Llamar recursivamente
	        }

	        // Descubrir la casilla
	        tableroJugador[fila][columna] = tablero[fila][columna];

	        if (tablero[fila][columna] == 'B') {
	            System.out.println("¡HUNDIDO!");
	            return true;
	        } else {
	            System.out.println("AGUA");
	            return false;
	        }
	    }
}
