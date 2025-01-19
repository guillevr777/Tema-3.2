package parteunootravez;

import java.util.Scanner;

public class Ejer4 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Cuentame tu vida");
		String frase = reader.nextLine();
		String fraseDadaVuelta;
		fraseDadaVuelta = darleVuelva(frase);
		System.out.println(fraseDadaVuelta);
	}
	static String darleVuelva(String frase) {
		String resultado = "";
		char comodin;
		char[] caracteres = frase.toCharArray();
		 
		for (int i = 0 ; i < caracteres.length/2 ; i++) {
			comodin = caracteres[i];
			caracteres[i] = caracteres[caracteres.length-1-i];
			caracteres[caracteres.length-1-i] = comodin;
		}
		resultado= String.valueOf(caracteres);
		
		return resultado;
	}
}
