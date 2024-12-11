package parte1;

import java.util.Scanner;

public class Ejer6 {
	public static void main(String[]args) {
		Scanner reader = new Scanner(System.in);
		
		String frase;
		
		System.out.println("Dime la frase ");
		frase = reader.nextLine();
		
		if (palindroma(frase)) {
			System.out.println("Es palindroma!");
		} else {
			System.out.println("No lo es...");
		}
		
		reader.close();
	}
	static boolean palindroma(String a) {
		int contador = a.length()-1;
		boolean frase;
		
		for (int i = 0 ; i < a.length() ; i++) {
			if () {
				frase += "";
			} else {
			frase += a.charAt(contador);
			}
			contador--;
		}
		return frase;
	}
}
