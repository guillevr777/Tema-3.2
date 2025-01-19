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
		boolean ganador = false;
		
		generaPalabra();
		System.out.println(palabraSecreta);
		System.out.println("Bienvenido al juego del calamardo:");
		
		while (!ganador && !palabraPista.equals(palabraSecreta) && NUMINTENTOS > 0) {
		if (menu() != 2) {
			System.out.println("Dime la letra que quieres probar :");
			letra = reader.next().toUpperCase().charAt(0);
			compruebaLetra(letra);
		} else {
			System.out.println("Que palabra crees que es?");
			intento = reader.next();
			compruebaPalabra();
			NUMINTENTOS--;
			}
			pintaPista();
			ganador = false;
		}
		if (NUMINTENTOS > 0) {
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
	    letra = Character.toLowerCase(letra);
	    String nuevaPista = ""; 
	    boolean letraAcertada = false;

	    for (int i = 0; i < palabraSecreta.length(); i++) {
	        if (palabraSecreta.charAt(i) == letra) {
	            nuevaPista += letra;
	            letraAcertada = true;
	        } else {
	            nuevaPista += palabraPista.charAt(i);
	        }
	    }

	    if (!letraAcertada && !noAcertadas.contains(String.valueOf(letra))) {
	        noAcertadas += letra; // Registrar letra no acertada
	    }

	    palabraPista = nuevaPista; // Actualizar la pista
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
