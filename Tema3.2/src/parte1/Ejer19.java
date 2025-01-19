package parte1;

public class Ejer19 {
	 public static void main(String[] args) {
	        String frase = "Me GUsta merenDAR gaLLEtas";
	        String variableCamelCase = convertirCamelCase(frase);
	        System.out.println(variableCamelCase);  // Resultado: meGustaMerendarGalletas
	    }
	    static String convertirCamelCase(String frase) {
	        // Dividir la frase en palabras
	        String[] palabras = frase.split(" ");
	        StringBuilder camelCase = new StringBuilder();

	        // Procesar cada palabra
	        for (int i = 0; i < palabras.length; i++) {
	            // Convertir la primera palabra completamente a minúsculas
	            if (i == 0) {
	                camelCase.append(palabras[i].toLowerCase());
	            } else {
	                // Convertir las siguientes palabras en formato "PascalCase" (Primera letra mayúscula)
	                camelCase.append(Character.toUpperCase(palabras[i].charAt(0)));
	                camelCase.append(palabras[i].substring(1).toLowerCase());
	            }
	        }

	        return camelCase.toString();
	  }
}
