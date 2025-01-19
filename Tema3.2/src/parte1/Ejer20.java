package parte1;

public class Ejer20 {

	    public static void main(String[] args) {
	        String palabra = "destornillador";
	        int n = 4;
	        String[] secuencias = dividirEnSecuencias(palabra, n);

	        // Mostrar el resultado
	        for (String secuencia : secuencias) {
	            System.out.println(secuencia);
	        }
	    }
	    static String[] dividirEnSecuencias(String palabra, int n) {
	        // Calcular cuántas secuencias serán necesarias
	        int numSecuencias = (int) Math.ceil((double) palabra.length() / n);
	        String[] secuencias = new String[numSecuencias];

	        // Dividir la palabra en secuencias de n letras
	        for (int i = 0; i < numSecuencias; i++) {
	            // Determinar el índice de inicio y el final de la secuencia
	            int inicio = i * n;
	            int fin = Math.min(inicio + n, palabra.length());  // Evitar que el índice de fin exceda el tamaño de la palabra

	            // Obtener la secuencia y agregarla al array
	            secuencias[i] = palabra.substring(inicio, fin);
	        }

	        return secuencias;
	    }
	}

