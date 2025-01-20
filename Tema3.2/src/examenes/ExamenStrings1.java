package examenes;

import java.util.Random;
import java.util.Scanner;

public class ExamenStrings1 {

	static String palabras[] = {"humanidad","persona","hombre","mujer","individuo","cuerpo","pierna","cabeza","brazo","familia"};
	static int NUMINTENTOS = 7;
	static String palabraSecreta = "";
	static String palabraPista = "";
	static String noAcertadas = "";
	static String intento = "";
	static Random random = new Random();
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		
		char letra;
		
		generaPalabra();
		System.out.println(palabraSecreta);
		System.out.println("Bienvenido al juego del calamardo:");
		
		while (!palabraPista.equals(palabraSecreta) && NUMINTENTOS > 0) {
		if (menu() != 2) {
			System.out.println("Dime la letra que quieres probar :");
			letra = reader.next().toLowerCase().charAt(0);
			compruebaLetra(letra);
		} else {
			System.out.println("Que palabra crees que es?");
			intento = reader.next();
			compruebaPalabra();
			if (!palabraPista.equals(palabraSecreta)) {
			NUMINTENTOS--;
			}
			}
			pintaPista();
		    System.out.println("Te quedan " + NUMINTENTOS + " intentos.");
		}
		if (palabraPista.equals(palabraSecreta)) {
			System.out.println("Has ganado el ahorcado!");
		} else {
			System.out.println("Has perdido crack!");
		}
		reader.close();
	}
	
	
	static void generaPalabra() {
	    int aleatorio = random.nextInt(palabras.length);
	    palabraSecreta = palabras[aleatorio];
	    palabraPista = "-".repeat(palabraSecreta.length()); // Crear guiones para toda la palabra
	}

	
	
	static int menu() {
		int numero;
		
		System.out.println("Seleccione una de las siguientes opciones:\n1.Introducir letra.\n2.Introducir palabra.");
		numero = reader.nextInt();
		
		return numero;
	}
	
	
	static void compruebaLetra(char letra) {
		String sustitutoPalabraPista = "";
		char pruebaLetra = 0;

		for (int i = 0 ; i < palabraSecreta.length() ; i++) {
		   pruebaLetra = palabraSecreta.charAt(i);
		   if (letra == pruebaLetra) {
			   sustitutoPalabraPista += letra;	
		   } else {
			   sustitutoPalabraPista += palabraPista.charAt(i);
		   }
	   }
	   if (!palabraSecreta.contains(String.valueOf(letra)) && !noAcertadas.contains(String.valueOf(letra))) {
		   noAcertadas += letra;
	   }
	   palabraPista = sustitutoPalabraPista;
	}
	
	
	static void compruebaPalabra() {
		if (palabraSecreta.equalsIgnoreCase(intento)) {
			palabraPista = palabraSecreta;
		}
	}
	
	
	static void pintaPista() {
        System.out.println("           " + palabraPista + "           ");
        System.out.print("Letras usadas no acertadas: ");
        for (int i = 0; i < noAcertadas.length(); i++) {
            System.out.print(noAcertadas.charAt(i) + " ");
        }
        System.out.println();
    }
}
