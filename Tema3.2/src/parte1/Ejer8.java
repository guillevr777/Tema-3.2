package parte1;

import java.util.Arrays;
import java.util.Scanner;

public class Ejer8 {
	public static void main(String[]args) {
		Scanner reader = new Scanner(System.in);
		
		//creamos la variable que contendra la frase dicha por el usuario
		String frase;
		
		//creamos un array para albergar el array de la funcion
		String[] palabras;
		//preguntamos por la frase
		System.out.println("Dime una frase y te la ordeno de menor a mayor : ");
		frase = reader.nextLine();
		
		//llamamos a la funcion
		palabras = tablaOrdenada(frase);
		
		//creamos un for para recorrer la tabla
		for (String palabra : palabras) {
			System.out.print(palabra + " ");
		} 
		//cerramos el escaner
		reader.close();
	}
	//creamos una funcion para devolver la frase dentro de un array ordenador de menor a mayor alfabetiamente
	static String[] tablaOrdenada(String frase) {

		//separamos la frase por palabras sueltas y la devolvemos como un array
		String[] palabras = frase.split(" ");
				
		//ordenamos la cadena de menor a mayor antes de retornarla
		Arrays.sort(palabras);
		
		//devolvemos el array ordenado
		return palabras;
	}
}
