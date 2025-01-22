package english;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class WordleGame {
	
	static Scanner scanner = new Scanner(System.in);
	static Random random = new Random();
	static String words[] = {"phone","tiger","human","pizza","hater"};
	static String palabraReal;
	static String palabraPistas;
	
	public static void main(String[] args) {
		
		int palabraElegida =  random.nextInt(0, words.length);
		palabraReal = words[palabraElegida];
		boolean winner = true;
		String sentence2;
		String sentence;
		
		while (!winner) {
	
			if (menu() != 2) {
			System.out.println("Tell me one letter to try :");
			sentence2 = scanner.next().toLowerCase();
			trySentence(sentence2);
			} else {
			System.out.println("Try to reveal the word :");
			sentence = scanner.next().toLowerCase();
			}
			if (palabraPistas.equals(palabraReal)) {
				winner = false;
			}
		}
		System.out.println("You won!");
		
		scanner.close();
	}
		static int menu() {
			int chose;
			
			System.out.println("Which option are you going to chose :\n1.Try letter.\nTry word.");
			chose = scanner.nextInt();
			
			return chose;
	}
		static void trySentence(char letter) {
			
			
			
		}
}
