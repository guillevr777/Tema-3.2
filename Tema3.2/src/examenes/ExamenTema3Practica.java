package examenes;

import java.util.Random;
import java.util.Scanner;

public class ExamenTema3Practica {

	static Random random = new Random();
	static Scanner reader = new Scanner(System.in);
	
			//declaramos el array en el que estara el abecedario
			static char abecedario[][] = {{'a','b','c','d','e','f','g','h','i'},{'j','k','l','m','n','ñ','o','p','q'},{'r','s','t','u','v','w','x','y','z'}};
			
			//declaramos el array donde estaran las frases
			static String frases[] = {"las guerras seguiran mientras el color de la piel siga siendo mas importante que el de los ojos",
								"aprende a vivir y sabras morir bien",
								"cada dia sabemos mas y entendemos menos",
								"el dinero no puede comprar la vida",
								"la verdadera sabiduria esta en reconocer la propia ignorancia"};
			
			//declaramos un string que tendra la frase con la que jugaremos
			static String fraseReal = "la verdadera sabiduria esta en reconocer la propia ignorancia";
			
			//frase codificada
			static String fraseCodificada = "";
	
	public static void main(String[]args) {
		
		//llamamos a la funcion desordena abecedario
		 desordenaAbecedario();
		 
		 for (int i = 0 ; i < 3 ; i++) {
			 for (int j = 0 ; j < 9 ; j++) {
				System.out.println( abecedario[i][j]);
			 }
		 }
		
		}
		//funcion encargada de desordena el abecedario para poderlo ordenar posteriormente
		static void desordenaAbecedario() {
			
			//guardamos la letra provicionalmente aqui
			char letra;
			
			//creamos variables para generar los numeros randoms
			int numeroRandomFilas = 0;
			int numeroRandomColumnas = 0;
			
			//creamos un for para pasar por cada letra
			for (int i = 0 ; i < 3 ; i++) {
				for (int j = 0 ; j < 9 ; j++) {
					
				numeroRandomFilas = random.nextInt(0,3);
				numeroRandomColumnas = random.nextInt(0,9);
				
				if (abecedario[numeroRandomFilas][numeroRandomColumnas] != abecedario[numeroRandomFilas][numeroRandomColumnas]) {
					letra = abecedario[numeroRandomFilas][numeroRandomColumnas];
					abecedario[numeroRandomFilas][numeroRandomColumnas] = abecedario[i][j];
					abecedario[i][j] = letra;
				}
			}
		}
	}
}
