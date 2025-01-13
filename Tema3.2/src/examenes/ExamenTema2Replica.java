package examenes;

import java.util.Random;
import java.util.Scanner;

public class ExamenTema2Replica {

	public static void main(String[]args) {
		
		//creamos el escaner
		Scanner reader = new Scanner(System.in);
		
		//creamos el random
		Random random = new Random();
		
		//creamos la variable para la puntuacion
		double puntos;
		
		//creamos la variable carta
		int carta;
		
		//variable para guardar el palo
		int palo;
		
		//puntuaciones jugador 1 y 2
		double jg1 = 0;
		double jg2 = 0;
		
		//almacenamos la respuesta en una variable
		String respuesta = "";
		
		//titulo y bienvenida del juego
		System.out.println("Bienvenido a las siete y media.");
		
		//bucle para la reproduccion de turnos del jugador 1 y 2
		for (int jugador = 1 ; jugador <= 2 ; jugador++) {
			
			//dice el turno del jugador que corresponda
			System.out.println("Es el turno del jugador " + jugador);
			
			//ponemos los puntos a cero
			puntos = 0;
			
			//hacemos un do while para preguntar si quiere sacar una primera carta hasta que la respuesta sea valida
			do {
				try {
					// Le preguntamos que si quiere carta
					System.out.println("¿Quiere sacar una carta?");
					respuesta = reader.next();
					
					assert "s".equalsIgnoreCase(respuesta) || "n".equalsIgnoreCase(respuesta)
							: "ERROR: Debe introducir S o N";
				} catch (AssertionError e) {
					System.err.println(e.getMessage());
				} finally {
					reader.nextLine();
				}
			} while (!"s".equalsIgnoreCase(respuesta) && !"n".equalsIgnoreCase(respuesta));
			
			//creamos un while para que mientras diga que quiere mas cartas y no tengas mas de 7.5 puntos continue
			while (respuesta.equalsIgnoreCase("S") && (jugador == 1 ? jg1 : jg2) <= 7.5) {
				
				carta = 0;
				palo = 0;
				puntos = 0;
				
				carta = random.nextInt(1,11);
				palo = random.nextInt(1,5);
				
				//vamos juntando los Syso para decirle que carta a salido aleatoriamente
				System.out.print("Tu carta es : ");
				
				//elegimos el tipo de puntuacion de la carta y el nombre
				switch (carta) {
					case 8 -> {
						System.out.print("sota"); 
						puntos += 0.5;
					}	
					case 9 -> {
						System.out.print("caballo");
						puntos += 0.5;
					}
					case 10 -> {
						System.out.print("rey");
						puntos += 0.5;
					}
					default -> {
						System.out.print(carta);
						puntos += carta;
					}	
				}
				
				//elegimos aleatoriamente el palo de la carta
				switch (palo) {
				case 1 -> System.out.println(" de oro.");
				case 2 -> System.out.println(" de copas.");
				case 3 -> System.out.println(" de espadas.");
				case 4 -> System.out.println(" de bastos.");
				}
				
				//si es el turno del jugador 1 se le daran los puntos a el sino seran del jugador 2
				if (jugador == 1) {
					jg1 += puntos;
				} else {
					jg2 += puntos;
				}
				
				//mostramos la puntuacion del jugador actual mediante una ternaria
				System.out.println("La puntuacion es de " + (jugador == 1 ? jg1 : jg2));
				
				//Si no supera los 7.5 puntos puede robar otra carta sino pasa a ser turno del jugador 2
				if ((jugador == 1 ? jg1 : jg2) <= 7.5) {
				System.out.println("Quieres volver a robar? (S / N)");
				respuesta = reader.next();
				} else {
					System.out.println("Te has pasado pidiendo carta crack.");
				}
			}
		} 
		
		System.out.println("La puntuacion del jugador 1 a sido de " + jg1 + " puntos y la del jugador 2 a sido de " + jg2 + " puntos.");
		
		if (jg1 > 7.5 && jg2 > 7.5) {
			System.out.println("Esta vez fue empate!");
		} else if (jg1 <= 7.5 && jg2 > 7.5) {
			System.out.println("Gano el jugador 1!");
		} else if (jg2 <= 7.5 && jg1 > 7.5) {
			System.out.println("Gano el jugador 2!");
		} else if (jg1 > jg2 && jg1 <= 7.5) {
			System.out.println("Gano el jugador 1!");
		} else if (jg2 > jg1 && jg2 <= 7.5) {
			System.out.println("Gano el jugador 2!");
		} else {
			System.out.println("Ambos jugadores empataron.");
		}
		
		//cerramos la consola
		reader.close();
	}
}
