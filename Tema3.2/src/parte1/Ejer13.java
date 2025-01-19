package parte1;
	import java.util.Arrays;

	public class Ejer13 {

	    public static void main(String[] args) {
	        // Ejemplo de uso de la función
	        String palabra1 = "roma";
	        String palabra2 = "amor";

	        if (sonAnagramas(palabra1, palabra2)) {
	            System.out.println(palabra1 + " y " + palabra2 + " son anagramas.");
	        } else {
	            System.out.println(palabra1 + " y " + palabra2 + " no son anagramas.");
	        }
	    }

	    // Función para verificar si dos palabras son anagramas
	    static boolean sonAnagramas(String palabra1, String palabra2) {
	        // Eliminar espacios y convertir las palabras a minúsculas
	        palabra1 = palabra1.replace(" ", "").toLowerCase();
	        palabra2 = palabra2.replace(" ", "").toLowerCase();

	        // Si las palabras no tienen la misma longitud, no pueden ser anagramas
	        if (palabra1.length() != palabra2.length()) {
	            return false;
	        }

	        // Convertir las palabras a arreglos de caracteres
	        char[] arreglo1 = palabra1.toCharArray();
	        char[] arreglo2 = palabra2.toCharArray();

	        // Ordenar ambos arreglos
	        Arrays.sort(arreglo1);
	        Arrays.sort(arreglo2);

	        // Comparar los arreglos ordenados
	        return Arrays.equals(arreglo1, arreglo2);
	    }
	}
