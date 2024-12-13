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
	static boolean palindroma(String frase) {
		int contador = frase.length()-1;
		boolean respuesta;
		String fraseDelRevez;
		
		for (int i = 0 ; i < frase.length() ; i++) {
			if (fraseDelRevez[]) {
				frase += "";
			} else {
			frase += frase.charAt(contador);
			}
			contador--;
		}
		return respuesta;
	}
	static String invierteCadena(String cadena) {
		String frase ="";
		
		for (int i = cadena.length()-1 ; i < cadena.length() ; i--) {
			
		}
	}
}
