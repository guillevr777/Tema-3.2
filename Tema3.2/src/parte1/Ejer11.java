package parte1;

public class Ejer11 {

	public static void main(String[] args) {

		//creamos los array de char con las letras demandadas
		char conjunto2[] = {'e','i','k','m','p','q','r','s','t','u','v'};
		char conjunto1[] = {'p','v','i','u','m','t','e','r','k','q','s'};
	
		 // Texto de ejemplo
        String texto = "PaquiTo";

        System.out.println("Texto original: " + texto);

        // Codificamos el texto
        StringBuilder textoCodificado = new StringBuilder();
        for (char c : texto.toCharArray()) {
            textoCodificado.append(codifica(conjunto1, conjunto2, c));
        }

        System.out.println("Texto codificado: " + textoCodificado);
    }
	static char codifica(char conjunto1[], char conjunto2[], char c) {
		
		// Convertimos el carácter a minúscula para trabajar de forma uniforme
        char original = Character.toLowerCase(c);

        // Recorremos el conjunto1 para buscar el carácter
        for (int i = 0; i < conjunto1.length; i++) {
            if (conjunto1[i] == original) {
                // Retornamos el carácter codificado del conjunto2
                return conjunto2[i];
            }
        }
        // Si no se encuentra en conjunto1, retornamos el carácter original en minúscula
        return original;
			
	}
}
