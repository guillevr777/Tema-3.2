package parteunootravez;

import java.util.Scanner;

public class Ejer6 {
public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);

		System.out.println("Dime una frase");
		String frase = "";
		frase = reader.nextLine();
		
		if (esPalindroma(frase)) {
			System.out.println("La frase introducida es Palindroma");
		} else {
			System.out.println("La frase introducida no es Palindroma");
		}
		reader.close();
	}
	static boolean esPalindroma(String frase) {

		String fraseSinEspacio = frase.replaceAll(" ", "").toLowerCase();

		boolean respuesta = true;

		int fin = fraseSinEspacio.length()-1;
		int inicio = 0;

		while (inicio < fin && respuesta) {
	           respuesta = (fraseSinEspacio.charAt(inicio) == fraseSinEspacio.charAt(fin));
		          inicio++;
			          fin--;
			  }
		return respuesta;
	}
}
