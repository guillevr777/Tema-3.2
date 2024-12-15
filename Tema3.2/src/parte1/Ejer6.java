package parte1;

import java.util.Scanner;

public class Ejer6 {
	public static void main(String[]args) {
		Scanner reader = new Scanner(System.in);
		
		//creamos un string para guardar la frase
		String frase;
		
		//pedimos la frase por consola
		System.out.println("Dime la frase ");
		frase = reader.nextLine();
		
		//si al llamar la funcion devuleve true es palindromma y si es false no lo es
		if (palindroma(frase)) {
			System.out.println("Es palindroma!");
		} else {
			System.out.println("No lo es...");
		}
		
		//cerramos el escaner
		reader.close();
	}
	//creamos una funcion para averiguar si es palindroma la frase devolviendo un booleano
	static boolean palindroma(String frase) {
		//creamos un string y sustituimos los espacios
		String fraseSinEspacio = frase.replaceAll(" ", "").toLowerCase();
		//creamos un booleano que se devolvera al llamar a la funcion
		boolean respuesta = true;
		//creamos dos contadores , un ira sumando y otro restando segun las aliteraciones del while
		int fin = fraseSinEspacio.length()-1;
		int inicio = 0;
		//creamos un while para que no salga mientras que inicio sea menor que fin y la respuesta no sea false
		 while (inicio < fin && respuesta) {
	            respuesta = (fraseSinEspacio.charAt(inicio) == fraseSinEspacio.charAt(fin));
	            inicio++;
	            fin--;
	        }

		 //devolvemos el booleano
		return respuesta;
	}
}
