package examenes;

import java.util.Scanner;

public class PiedraPapelTijeras {

    // Determina el ganador de una ronda
    public static int determinarGanador(String eleccion1, String eleccion2) {
        if (eleccion1.equals(eleccion2)) {
            return 0; // Empate
        }
        if ((eleccion1.equals("piedra") && eleccion2.equals("tijera")) ||
            (eleccion1.equals("papel") && eleccion2.equals("piedra")) ||
            (eleccion1.equals("tijera") && eleccion2.equals("papel"))) {
            return 1; // Jugador 1 gana
        }
        return 2; // Jugador 2 gana
    }

    // Imprime el marcador actual
    public static void imprimirMarcador(int puntosJugador1, int puntosJugador2) {
        System.out.println("\n--- Marcador ---");
        System.out.println("Jugador 1: " + puntosJugador1);
        System.out.println("Jugador 2: " + puntosJugador2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int puntosJugador1 = 0;
        int puntosJugador2 = 0;
        String[] opcionesValidas = {"piedra", "papel", "tijera"};

        System.out.println("¡Bienvenidos a Piedra, Papel o Tijera!");
        System.out.println("Escribe 'salir' para terminar el juego.");

        while (true) {
            System.out.print("Jugador 1, introduce tu elección (piedra, papel, tijera): ");
            String eleccionJugador1 = scanner.nextLine().toLowerCase();

            if (eleccionJugador1.equals("salir")) {
                break;
            }

            System.out.print("Jugador 2, introduce tu elección (piedra, papel, tijera): ");
            String eleccionJugador2 = scanner.nextLine().toLowerCase();

            if (eleccionJugador2.equals("salir")) {
                break;
            }

            boolean eleccion1Valida = false;
            boolean eleccion2Valida = false;

            for (String opcion : opcionesValidas) {
                if (eleccionJugador1.equals(opcion)) {
                    eleccion1Valida = true;
                }
                if (eleccionJugador2.equals(opcion)) {
                    eleccion2Valida = true;
                }
            }

            if (!eleccion1Valida || !eleccion2Valida) {
                System.out.println("Una o ambas elecciones no son válidas. Intenta de nuevo.");
                continue;
            }

            int resultado = determinarGanador(eleccionJugador1, eleccionJugador2);

            switch (resultado) {
                case 0:
                    System.out.println("Es un empate.");
                    break;
                case 1:
                    System.out.println("Jugador 1 gana esta ronda.");
                    puntosJugador1++;
                    break;
                case 2:
                    System.out.println("Jugador 2 gana esta ronda.");
                    puntosJugador2++;
                    break;
            }

            imprimirMarcador(puntosJugador1, puntosJugador2);
        }

        System.out.println("\nJuego terminado. Resultado final:");
        imprimirMarcador(puntosJugador1, puntosJugador2);
        scanner.close();
    }
}
