package parte1;

import java.util.Scanner;

public class Ejer9 {
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
}
