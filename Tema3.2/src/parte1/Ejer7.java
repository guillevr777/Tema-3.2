package parte1;

import java.util.Scanner;

public class Ejer7 {
	public static void main(String[]args) {
		Scanner reader = new Scanner(System.in);
		
		//creamos dos variables para guardar la frase y la palabra
		String frase;
		String palabra = "";
		
		//pregunto por la frase
		System.out.println("Dime la frase ");
		frase = reader.nextLine();
		
		//llamamos a la funcion
		comprobar(frase, palabra);
		
		//cerramos el escaner
		reader.close();
	}
	static void comprobar(String a, String b) {
		int contador = 0;
		int posicion;
		int posInicio;
		
		//sacamos la posicion de la primera aliteración
		posicion = a.indexOf(b, 0);
		
		while (posicion >= 0) {
			contador++;
	
			posInicio = posicion+b.length();
			posicion = a.indexOf(b, posInicio);
		}
	}
	private static Object indexOf(String b, int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
