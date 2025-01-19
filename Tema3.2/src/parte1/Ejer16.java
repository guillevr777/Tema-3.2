package parte1;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejer16 {

	    public static void main(String[] args) {
	        Scanner reader = new Scanner(System.in);

	        // Leer la frase del primer jugador
	        System.out.println("Jugador 1: Introduce una palabra o frase (no puede ser vacía):");
	        String textoOriginal = reader.nextLine().trim();

	        // Asegurarse de que la entrada no esté vacía
	        while (textoOriginal.isEmpty()) {
	            System.out.println("¡La palabra o frase no puede estar vacía! Por favor, introduce una nueva:");
	            textoOriginal = reader.nextLine().trim();
	        }

	        // Generar el anagrama
	        String anagrama = generarAnagrama(textoOriginal);

	        // Mostrar el anagrama al jugador 2
	        System.out.println("Jugador 2: Aquí está el anagrama, trata de adivinar la palabra original:");
	        System.out.println(anagrama);

	        // El segundo jugador intenta adivinar el texto original
	        String respuesta = "";
	        while (!respuesta.equalsIgnoreCase(textoOriginal)) {
	            System.out.println("Introduce tu respuesta:");
	            respuesta = reader.nextLine().trim();

	            // Verificar cuántas letras coinciden
	            int coincidencias = contarCoincidencias(respuesta, textoOriginal);
	            if (respuesta.equalsIgnoreCase(textoOriginal)) {
	                System.out.println("¡Correcto! Has adivinado la palabra correctamente.");
	            } else {
	                System.out.println("Coinciden " + coincidencias + " letras. Intenta de nuevo.");
	            }
	        }
	    }

	    /**
	     * Función que genera un anagrama aleatorio de una palabra o frase
	     * @param texto el texto a desordenar
	     * @return el anagrama generado
	     */
	    static String generarAnagrama(String texto) {
	        // Convertir el texto a una lista de caracteres
	        List<Character> caracteres = new ArrayList<>();
	        for (char c : texto.toCharArray()) {
	            caracteres.add(c);
	        }

	        // Mezclar aleatoriamente los caracteres
	        Collections.shuffle(caracteres);

	        // Convertir la lista de caracteres de nuevo a una cadena
	        StringBuilder anagrama = new StringBuilder();
	        for (char c : caracteres) {
	            anagrama.append(c);
	        }

	        return anagrama.toString();
	    }
	    static int contarCoincidencias(String respuesta, String textoOriginal) {
	        int coincidencias = 0;
	        int longitud = Math.min(respuesta.length(), textoOriginal.length());

	        // Contar cuántas letras coinciden en la misma posición
	        for (int i = 0; i < longitud; i++) {
	            if (respuesta.charAt(i) == textoOriginal.charAt(i)) {
	                coincidencias++;
	            }
	        }
	        return coincidencias;
	    }
	}
