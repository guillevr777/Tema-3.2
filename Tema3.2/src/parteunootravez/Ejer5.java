package parteunootravez;

import java.util.Scanner;

public class Ejer5 {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);

		String frase = "";
		String palabra = "";
		
		while (!palabra.equalsIgnoreCase("fin")) {
			System.out.println("Dime una palabra o termina diciendo fin :");
			palabra = reader.next().toLowerCase();
			if (!palabra.equalsIgnoreCase("fin")) {
			frase += palabra + " ";
			}
		}
		System.out.println(frase);
		reader.close();
	}
}
