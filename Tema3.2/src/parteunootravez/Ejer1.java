package parteunootravez;

import java.util.Scanner;

public class Ejer1 {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		
		System.out.println("Dime una frase:");
		String primeraFrase = reader.next();
		System.out.println("Dime otra:");
		String segundaFrase = reader.next();
		int numero = primeraFrase.compareToIgnoreCase(segundaFrase);
		if (numero == -1) {
			System.out.println("La frase mas corta era la primera");
		} else {
			System.out.println("La frase mas corta era la segunda");
		}
	}
}
