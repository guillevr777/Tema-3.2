package tema33;

import java.util.Scanner;
import java.util.TreeSet;

public class Ejer6 {

	public static void main(String[] args) {
		
		//llamamos al metodo reader
		Scanner reader = new Scanner(System.in);

		//creamos la lista
		TreeSet<String> listaNombres = new TreeSet<>();
		
		//variable para almacenar temporalmente el nombre que de el jugador
		String respuesta = "";
		//creamos un while para que hasta que no aparezca la palabra fin no pare de preguntar por mas valores
		do {
			
			System.out.println("Dime un nombre, cuando no quieras poner mas escribe \"fin\"");
			respuesta = reader.next().toLowerCase();
			
			//si aparece la palabra fin no se almacenara
			if (!respuesta.equals("fin")) {
				listaNombres.add(respuesta);
			}
			
		} while (!respuesta.equals("fin"));
		
		//mostramos los nombres ordenados alfabeticamente
		System.out.println("Nombres ordenados : " + listaNombres);
		
		//cerramos el escaner
		reader.close();
	}
}
