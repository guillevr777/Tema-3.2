package parte1;

import java.util.Scanner;

public class Ejer3 {
	public static void main(String[]args) {
		Scanner reader = new Scanner(System.in);
		
		String contraseña;
		String intento;
		int resultado;
		boolean continuar = true;
		
		System.out.println("Dime la contraseña ");
		contraseña = reader.nextLine();
		
		System.out.println(comprobar(contraseña));
		
		reader.close();
	}
	static int comprobar(String contraseña) {
		int contador = 0;
		
		for (int i = 0 ; i < contraseña.length() ; i++) {
			
			if (contraseña.charAt(i) == ' ') {
				contador++;
			}
		}
		
		return contador;
	}
}
