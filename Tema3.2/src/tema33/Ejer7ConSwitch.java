package tema33;

import java.util.HashMap;
import java.util.Scanner;

public class Ejer7ConSwitch {
	
	public static void main(String[]args) {
	//llamamos al Scanner
	Scanner reader = new Scanner(System.in);

	//usamos los diccionarios para crear un traductor de palabras en ingles a español
	HashMap<String, String> palabras = new HashMap<>();
	
	//Recogemos respuesta usuario al elegir que hacer
	int numero;
	
	//variable para almacenar temporalmente la palabra en español
	String respuesta = "";
	
	//variable para almacenar temporalmente la palabra en ingles
	String respuestaDos = "";
	
	//variable para buscar traduccion palabra
	String traduccionPalabra = "";
	
	//variable string para almacenar la respuesta del .get
	String traduccion;
	
	//variable booleana para controlar el bucle
	boolean salir = false;
	
	//introducimos las palabras de español a ingles
	do {
		
		System.out.println("Escribe 1 si quieres poner una palabra.\nEscribe 2 si quieres buscar el significado de una palabra.\nEscribe 0 si quieres terminar el programa.");
		numero = reader.nextInt();
		reader.nextLine();
		
		switch (numero) {
		case 1 -> {
			
			System.out.println("Dime un nombre y su equivalente en ingles.");
			respuesta = reader.next().toLowerCase();
			respuestaDos = reader.next().toLowerCase();
			
			palabras.put(respuesta, respuestaDos);
			
		}
		case 2 -> {
			
			System.out.println("Dime de que palabra quieres buscar la traduccion :");
			traduccionPalabra = reader.next();
			
			traduccion = palabras.get(traduccionPalabra);
			System.out.println(traduccion);
			
		}
		default -> salir = true;
		}
	
	} while (!salir);

	//cerramos el escaner
	reader.close();
	}
}