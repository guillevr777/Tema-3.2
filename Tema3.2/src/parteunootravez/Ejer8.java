package parteunootravez;

import java.util.Arrays;
import java.util.Scanner;

public class Ejer8 {

public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);

		System.out.println("Dime una frase");
		String frase = "";
		frase = reader.nextLine();
		
		String fraseReordenada[] = frase.split(" ");
		 Arrays.sort(fraseReordenada);
		
		String fraseOrdenada[] = fraseRepetida(frase);
		
		for (int i = 0 ; i < fraseOrdenada.length ; i++) {
				System.out.print("\t" + fraseOrdenada[i]);
		}
		System.out.println();
		for (int i = 0 ; i < fraseOrdenada.length ; i++) {
			System.out.print("\t" + fraseReordenada[i]);
	}
		
		reader.close();
	}
	static String[] fraseRepetida(String frase) {
		
		String fraseEntera[] = frase.split(" ");

		  for (int i = 0; i < fraseEntera.length - 1; i++) {
	            for (int j = i + 1; j < fraseEntera.length; j++) {
	                if (fraseEntera[i].compareTo(fraseEntera[j]) < 0) {
	                    // Intercambiar palabras[i] y palabras[j]
	                    String temp = fraseEntera[i];
	                    fraseEntera[i] = fraseEntera[j];
	                    fraseEntera[j] = temp;
	                }
	            }
	        }
		
		return fraseEntera;
	}
}


