package parte1;

import java.util.Scanner;

public class Ejer2 {

	public static void main(String[]args) {
		Scanner reader = new Scanner(System.in);
		
		String contraseña;
		String intento;
		int resultado;
		boolean continuar = true;
		
		System.out.println("Dime la contraseña ");
		contraseña = reader.nextLine();
		
		while (continuar) {
			System.out.println("Intenta adivinar la contraseña");
			intento = reader.nextLine();
			
			if (intento.equals(contraseña)) {
				
				System.out.println("Acertaste la contraseña");
				continuar = false;
				
			} else {
				
				System.out.println("No diste en el clavo, vuelve a intentarlo.");
				
				resultado = contraseña.compareToIgnoreCase(intento);
				
				if (resultado < 0) {
					System.out.println("La contraseña es menor");
				} else {	
					System.out.println("La contraseña es mayor");
				}
			}
		}
		
		reader.close();
	}
}