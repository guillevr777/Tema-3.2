package parteunootravez;

import java.util.Scanner;

public class Ejer7 {

public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);

		System.out.println("Dime una frase");
		String frase = "";
		frase = reader.nextLine();
		
		System.out.println("Dime una palabra");
		String palabra = "";
		palabra = reader.next();
		
		System.out.println("La palabra esta repetida " + fraseRepetida(frase, palabra) + " veces en la frase.");
		
		reader.close();
	}
	static int fraseRepetida(String frase, String palabra) {
		
		String fraseEntera[] = frase.split(" ");

		int respuesta = 0;

		for (int i = 0 ; i < fraseEntera.length ; i++) {
			if (palabra.equals(fraseEntera[i])) {
				respuesta++;
			}
		}
		
		return respuesta;
	}
}


