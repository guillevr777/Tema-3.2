package tema33;

import java.lang.foreign.AddressLayout;
import java.util.HashMap;
import java.util.Scanner;

public class PruebaEjer7 {

	public static void main(String[] args) {
		
		//llamamos al Scanner
		Scanner reader = new Scanner(System.in);

		//usamos los diccionarios para crear un traductor de palabras en ingles a español
		HashMap<String, String> palabras = new HashMap<>() {{
			//añadimos unas cuantas traducciones con este metodo
				put("Vergonzoso", "Shy");
			 	put("Feliz", "Happy");
			    put("Fuerte", "Strong");
			    put("Dedo", "Finger");
			    put("Jugador", "Player");
			    put("Games", "Juegos");
			    put("LeagueOfLegends", "NoQuererVivir");
			    put("Jayce", "Perder");
		}};
		
		//añadimos 5 pares de palabras de antemano
		palabras.put("Correr", "Run");
		palabras.put("Nadar", "Swim");
		palabras.put("Volar", "Fly");
		palabras.put("Fumar", "Smoke");
		palabras.put("Beber", "Drink");
		
		//variable para almacenar temporalmente la palabra en español
		String respuesta = "";
		
		//variable para almacenar temporalmente la palabra en ingles
		String respuestaDos = "";
				
		//introducimos las palabras de español a ingles
		do {
					
			System.out.println("Dime un nombre y su equivalente en ingles, cuando no quieras poner mas escribe \"fin\" y pulsa enter 2 veces");
			respuesta = reader.next().toLowerCase();
			respuestaDos = reader.next().toLowerCase();
					
			//si aparece la palabra fin no se almacenara
			if (!respuesta.equals("fin")) {
				palabras.put(respuesta, respuestaDos);
			}
			
		} while (!respuesta.equals("fin"));
		
		//Mostramos el resultado
		System.out.println("El equivalente en ingles de las anteriores palabras es :" + palabras);
	
		//cerramos el escaner
		reader.close();
	}
}
