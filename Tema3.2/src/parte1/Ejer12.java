package parte1;

import java.util.Scanner;

public class Ejer12 {

	public static void main(String[] args) {

		//creamos el escaner
		Scanner reader = new Scanner(System.in);
		
		//creamos la variable para almacenar un string que se recogera del usuario
		String frase;
		
		//creamos un array de string
		String palabras[];
		
		//string para alvergar la palabra mas larga
		String palabraLarga = "";
		
		//pedimos el string
		System.out.println("Dime una frase y te digo la palabra mas larga:");
		frase = reader.nextLine();
		
		//usamos el metodo split para dividir las palabras
		palabras = frase.split(" ");
		
		//creamos un for para recorrer el array
		for (int i = 0 ; i < palabras.length ; i++) {
			if (palabraLarga.length() < palabras[i].length()) {
				palabraLarga = palabras[i];
			}
		}
		
		// Mostramos la palabra más larga
        System.out.println("La palabra más larga es: " + palabraLarga + " y tiene " + palabraLarga.length() + " letras.");
		
        //cerramos el escaner
        reader.close();
	}
}
