package parte1;

import java.util.Scanner;

public class Ejer2Parte2 {

	public static void main(String[]args) {
		Scanner reader = new Scanner(System.in);
		
		//creamos variables para almacenar contraseña ,intento y un boolean
		String contraseña;
		String intento;
		boolean continuar = true;
		
		//pregunto por la contraseña
		System.out.println("Dime la contraseña ");
		contraseña = reader.nextLine();
		
		//creamos un while para que pregunte la contraseña hasta acertar
		while (continuar) {
			System.out.println("Intenta adivinar la contraseña");
			intento = reader.nextLine();
			
			if (intento.equals(contraseña)) {
				
				System.out.println("Acertaste la contraseña");
				continuar = false;
				
			} else {
				
				System.out.println("No diste completamente en el clavo, vuelve a intentarlo.");
				
				for (int i = 0 ; i < contraseña.length() ; i++) {
					
					if (contraseña.charAt(i) == intento.charAt(i)) {
						System.out.print(contraseña.charAt(i));
					} else {
						System.out.print('*');
					}
				}
				System.out.println();
			}
		}
		
		reader.close();
	}
}