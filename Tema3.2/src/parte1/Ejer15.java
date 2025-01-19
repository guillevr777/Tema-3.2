package parte1;

	import java.util.Collections;
	import java.util.List;
	import java.util.ArrayList;
	import java.util.Scanner;

public class Ejer15 {

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
	        System.out.println("Introduce tu respuesta:");
	        String respuesta = reader.nextLine().trim();

	        // Verificar si la respuesta es correcta
	        if (respuesta.equalsIgnoreCase(textoOriginal)) {
	            System.out.println("¡Correcto! Has adivinado la palabra correctamente.");
	        } else {
	            System.out.println("Lo siento, la respuesta es incorrecta. La palabra original era: " + textoOriginal);
	        }
	    }
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
	}
