package parteunootravez;

import java.util.Scanner;

public class Ejer3 {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		
		System.out.println("Cuentame tu vida");
		String frase = reader.nextLine();
		
		System.out.println(numeroEspacios(frase));
	}
	static int numeroEspacios(String frase) {
		int devolucionEspacios = 0;
		
		char arrayFrase[];
		
		arrayFrase = frase.toCharArray();
		
		for (int i = 0 ; i < arrayFrase.length ; i++) {
			if (arrayFrase[i] == ' ') {
				devolucionEspacios++;
			}
		}
		return devolucionEspacios;
	}

}
