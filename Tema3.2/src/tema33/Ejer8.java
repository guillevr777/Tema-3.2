package tema33;

import java.util.HashMap;
import java.util.Scanner;

public class Ejer8 {

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
		
		//variable para buscar usuario
		String usuario = "";
		
		//variable string para buscar contraseña
		String contraseña;
		
		//numero de intentos para introducir la contraseña
		int numIntentos = 0;
		
		//variable booleana para si accede con la contraseña salga del tiron
		boolean accedio = false;;
		
		//variable booleana para controlar el bucle
		boolean salir = false;
		
		//introducimos las palabras de español a ingles
		do {
			
			System.out.println("1. Registro.\n2. Login.\n0. Salir.");
			numero = reader.nextInt();
			reader.nextLine();
			
			switch (numero) {
			case 1 -> {
				
				System.out.println("Dime un nombre de usuario y una contraseña :");
				respuesta = reader.next().toLowerCase();
				respuestaDos = reader.next().toLowerCase();
				
				palabras.put(respuesta, respuestaDos);
				
			}
			case 2 -> {
				numIntentos = 3;
				
				do {
				System.out.println("Debes hacer login antes de acceder.");
				
				//pedimos el usuario
				System.out.println("Usuario :");
				usuario = reader.next();
				
				//pedimos la contraseña
				System.out.println("Contraseña :");
				contraseña = reader.next();
				
				//Verificamos que sea correcto
				if (palabras.containsKey(usuario) && palabras.get(usuario).equals(contraseña)) {
					System.out.println("Ha accedido al área restringida.");
					accedio = true;
				} else {
					numIntentos--;
					System.out.println("Te quedan " + numIntentos + " intentos, se bloqueara el usuario si sigue fallando.");
				}
				} while (numIntentos > 0 && !accedio);
			}
			default -> salir = true;
			}
		
		} while (!salir);

		//cerramos el escaner
		reader.close();
		}
	}