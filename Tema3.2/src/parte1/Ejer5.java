package parte1;

import java.util.Scanner;

public class Ejer5 {
	public static void main(String[]args) {
		Scanner reader = new Scanner(System.in);
		
		//almacenamos la frase y el intento
		String frase;
		String palabra;
		
		//preguntamops por una palabra
		System.out.println("Dime una palabra ");
		frase = reader.nextLine().toLowerCase();
		
		//mientras que no contenga fin la frase no para de preguntar
		while (!frase.contains("fin")) {
			
		//preguntamos por otra palabra que añadir a la frase
		System.out.println("Dime otra");
		palabra = reader.nextLine().toLowerCase();
		
		frase += " " + palabra;
		
		}
		//mostramos el resultado por pantalla
		System.out.println(frase);
		
		//cerramos el escaner
		reader.close();
	}
}