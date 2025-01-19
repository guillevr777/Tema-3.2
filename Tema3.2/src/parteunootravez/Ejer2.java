package parteunootravez;

import java.util.Scanner;

public class Ejer2 {
	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		
		System.out.println("Dime una frase:");
		String primeraFrase = reader.next();
		
		boolean palabraAcertada = false;
		
		while (!palabraAcertada) {
		System.out.println("Dime otra:");
		String segundaFrase = reader.next();
		int numero = primeraFrase.compareToIgnoreCase(segundaFrase);
		
		if (numero < 0) {
			System.out.println("Te estas pasando, la cadena es mas pequeña.");
		} else if (numero > 0) {
			System.out.println("Te estas quedando corto, la cadena es mas grande.");
		} else {
			System.out.println("Has acertado maquina");
			palabraAcertada = true;
		}
		}
	}
}
