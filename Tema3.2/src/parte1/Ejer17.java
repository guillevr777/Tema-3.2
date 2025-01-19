package parte1;

public class Ejer17 {
	
	    public static void main(String[] args) {
	        String sentencia = "if (a==3) /* igual a tres */ a++; /* incrementamos a */";
	        String resultado = eliminarComentarios(sentencia);
	        System.out.println("Sentencia sin comentarios: " + resultado);
	    }
	    static String eliminarComentarios(String sentencia) {
	        // Eliminar comentarios que están entre /* y */
	        while (sentencia.contains("/*")) {
	            int inicioComentario = sentencia.indexOf("/*");
	            int finComentario = sentencia.indexOf("*/", inicioComentario);

	            if (inicioComentario != -1 && finComentario != -1) {
	                // Eliminar el comentario
	                sentencia = sentencia.substring(0, inicioComentario) + sentencia.substring(finComentario + 2);
	            }
	        }
	        return sentencia;
	    }
	}

