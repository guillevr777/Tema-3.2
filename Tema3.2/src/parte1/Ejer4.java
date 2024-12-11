package parte1;

import java.util.Scanner;

public class Ejer4 {
	public static void main(String[]args) {
		Scanner reader = new Scanner(System.in);
		
		//creamos la variable contraseña
		String contraseña;
		
		//creamos una variable para contener la funcion
		String solucion;
		
		//p`reguntamos por la contraseña
		System.out.println("Dime la contraseña ");
		contraseña = reader.nextLine();
		
		//llamamos a la funcion
		solucion = invertir(contraseña);
		
		//mostramos la funcion asignada a solucion
		System.out.println(solucion);
		
		//cerramos el escaner
		reader.close();
	}
	static String invertir(String a) {
		
		//creamos una variable para contener la frase del reves
		String frase = "";
		
		//creamos un char para almacenar los caracteres
		char caracter;
		
		//creamos un contador
		int contador = a.length()-1;
		
		//creamos un for para repetir tantas veces como caracteres haya
		for (int i = 0 ; i < a.length() ; i++) {
		
			caracter = a.charAt(contador);
			
			frase += caracter;
			
			contador--;
		}
		return frase;
	}
}