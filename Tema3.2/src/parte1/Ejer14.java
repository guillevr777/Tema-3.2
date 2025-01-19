package parte1;

import java.util.Scanner;

public class Ejer14 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Introduce una frase:");
        String frase = reader.nextLine();
        mostrarConteoLetras(frase);
    }

    static void mostrarConteoLetras(String frase) {
        frase = limpiarFrase(frase);
        while (!frase.isEmpty()) {
            char letra = frase.charAt(0);
            int contador = contarLetra(frase, letra);
            System.out.println(letra + ": " + contador + " vez" + (contador > 1 ? "es" : ""));
            frase = eliminarLetra(frase, letra);
        }
    }

    static String limpiarFrase(String frase) {
        return frase.toLowerCase().replaceAll("[^a-z]", "");
    }

    static int contarLetra(String frase, char letra) {
        int contador = 0;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == letra) {
                contador++;
            }
        }
        return contador;
    }

    static String eliminarLetra(String frase, char letra) {
        return frase.replace(String.valueOf(letra), "");
    }
}
