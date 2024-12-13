package parte1;

import java.util.Scanner;

public class Ejer7 {
	public static void main(String[]args) {
		Scanner reader = new Scanner(System.in);
		
		//creamos dos variables para guardar la frase y la palabra
		String frase;
		String palabra = "";
		int cantidad;
		
		//pregunto por la frase
		System.out.println("Dime la frase ");
		frase = reader.nextLine();
		
		//pregunto por la palabra
		System.out.println("Dime la palabra ");
		palabra = reader.nextLine();
				
		//llamamos a la funcion
		cantidad = comprobar(frase, palabra);
		
		//mostramos la cantidad de veces que aparece
		System.out.println("La palabra esta repetida un total de " + cantidad + " veces.");
		
		//cerramos el escaner
		reader.close();
	}
	static int comprobar(String frase, String palabra) {
		int contador = 0;
		int posicion;
		int posInicio;
		
		//sacamos la posicion de la primera aliteración
		posicion = frase.indexOf(palabra, 0);
		
		while (posicion >= 0) {
			contador++;
	
			posInicio = posicion+palabra.length();
			posicion = frase.indexOf(palabra, posInicio);
		}
		return contador;
	}
}
