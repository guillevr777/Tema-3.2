package parte1;

import java.util.Scanner;

public class Ejer9 {
	public static void main(String[]args) {
		Scanner reader = new Scanner(System.in);
		
		//creamos un string para guardar la frase
		String frase;
		
		//pedimos la frase por consola
		System.out.println("Dime la frase ");
		frase = reader.nextLine();
		
		//si al llamar la funcion devuelve true es el idioma javalandia y si es false no lo es
		if (esJavalandia(frase)) {
			System.out.println("Es el idioma Javalandia!");
		} else {
			System.out.println("No es el idioma Javalandia...");
		}
		
		//cerramos el escaner
		reader.close();
	}
	//creamos una funcion para averiguar si es el idioma javalandia
	static boolean esJavalandia(String frase) {
		
		//creamos un string que quite las pausas del idioma
		String respaldoFrase = frase.replaceAll(" ", "");
		
		//creamos un booleano que se devolvera al llamar a la funcion
		boolean respuesta = true;
		
		//buscamos la muletilla tipica del inicio y del fin de las frases
		int inicio = respaldoFrase.indexOf("Javalín, javalón");
		int fin = respaldoFrase.indexOf("javalén, len, len", 1);

		//comprobamos si de verdad es Javalandia
		if (inicio == -1 && fin == -1) {
			respuesta = false;
		}
		
		//devolvemos el booleano
		return respuesta;
	}
}
