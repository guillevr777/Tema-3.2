package parte1;

public class Pruebas {

	public static void main(String[] args) {
		
		String frase = "HOLA MUNDO";
		
		System.out.println(frase);
		
		String fraseDos = frase.replace(frase.charAt(1), frase.charAt(2));
		
		String[] palabras = frase.split("");
				
		System.out.println(fraseDos);
		
		for (int i = 0 ; i < palabras.length ; i++) {
			
			System.out.print(palabras[i] + "\t");
			
		}
		
		char[] letras = frase.toCharArray();
		
		System.out.println();
		
		for (int i = 0 ; i < letras.length ; i++) {
			
			System.out.print(letras[i] + "\t");
			
		}
	}

}
