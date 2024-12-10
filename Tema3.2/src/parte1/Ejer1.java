package parte1;

import java.util.Scanner;

public class Ejer1 {

	public static void main(String[]args) {
		Scanner reader = new Scanner(System.in);
		
		String frase1;
		String frase2;
		
		System.out.println("Dime la primera frase");
		frase1 = reader.nextLine();
		System.out.println("Dime la segunda frase");
		frase2 = reader.nextLine();
		
		System.out.println(frase1);
		System.out.println(frase2);
		
		if (frase1.length() < frase2.length()) {
			System.out.println("La primera frase es mas corta!");
		} else if (frase2.length() < frase1.length()) {
			System.out.println("La segunda frase es mas corta!");
		} else {
			System.out.println("Ambas frases miden lo mismo...");
		}
		
		reader.close();
	}
}
