package examenes;

import java.util.Random;
import java.util.Scanner;

public class ExamenStrings1 {

	static String palabras[] = {"humanidad","persona","hombre","mujer","individuo","cuerpo","pierna","cabeza","brazo","familia"};
	static int NUMINTENTOS = 7;
	static String palabraSecreta = "";
	static String palabraPista = "";
	static String noAcertadas = "";
	static Random random = new Random();
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		
		generaPalabra();
		System.out.println(palabraSecreta);
		System.out.println("Bienvenido al juego del calamardo:");
		if (menu() != 2) {
			compruebaLetra();
		} else {
			compruebaPalabra();
		}
		pintaPista();
		
		reader.close();
	}
	static void generaPalabra() {
		int aleatorio = random.nextInt(0, palabras.length);
		palabraSecreta = palabras[aleatorio];
	}
	static int menu() {
		int numero;
		
		System.out.println("Seleccione una de las siguientes opciones:\n1.Introducir letra.\n2.Introducir palabra.");
		numero = reader.nextInt();
		
		return numero;
	}
	static void compruebaLetra() {
		char letra = 0;
		char palabraArray[];
		palabraArray = palabraSecreta.toCharArray();
		
		System.out.println("Dime la letra que quieres probar :");
		letra = reader.next().toUpperCase().charAt(0);
		
		for (int i = 0 ; i < palabraArray.length ; i++) {
			if (palabraArray[i] == letra) {
				palabraArray[i] = letra;
			} else {
				noAcertadas += letra;
				palabraArray[i] = '-';
			}
		}
		palabraPista = palabraArray.toString();
	}
	static void compruebaPalabra() {
		
	}
	static void pintaPista() {
		System.out.println(palabraPista);
	}
}
