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
		
		//creamos un boolean para devolver la respuesta
		boolean respuesta = false;
		//creamos un string para guardar la frase sin espacios
        String respaldoFrase = frase.replaceAll(" ", "").toLowerCase();
        
        //averiguamos el boolean es true o false
        respuesta = respaldoFrase.startsWith("javalín,javalón") || respaldoFrase.endsWith("javalén,len,len");
        
        //devolvemos el boolean
        return respuesta;
    }
}
