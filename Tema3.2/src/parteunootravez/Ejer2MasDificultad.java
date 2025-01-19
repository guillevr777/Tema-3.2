package parteunootravez;

import java.util.Scanner;

public class Ejer2MasDificultad {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Jugador 1 introduce la contraseña
	        System.out.print("Jugador 1, introduce la contraseña: ");
	        String contrasena = scanner.nextLine();

	        // Crear una cadena inicial con asteriscos del mismo tamaño que la contraseña
	        String progreso = "*".repeat(contrasena.length());

	        System.out.println("Jugador 2, trata de adivinar la contraseña.");
	        String intento = "";

	        while (!progreso.equals(contrasena)) {
	            System.out.print("Introduce una palabra: ");
	            intento = scanner.nextLine();

	            // Actualizar el progreso con los caracteres acertados
	            String nuevoProgreso = ""; // Cadena temporal para el nuevo progreso
	            for (int i = 0; i < contrasena.length(); i++) {
	                if (i < intento.length() && contrasena.charAt(i) == intento.charAt(i)) {
	                    nuevoProgreso += contrasena.charAt(i); // Carácter acertado
	                } else {
	                    nuevoProgreso += progreso.charAt(i); // Mantener el carácter actual
	                }
	            }
	            progreso = nuevoProgreso; // Actualizar el progreso con la nueva cadena

	            // Mostrar el progreso actualizado
	            System.out.println("\t" + progreso);
	        }

	        System.out.println("¡Has acertado la contraseña!");
	        scanner.close();
	    }
	}