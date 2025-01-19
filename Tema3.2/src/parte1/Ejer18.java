package parte1;

public class Ejer18 {

	    public static void main(String[] args) {
	        // Ejemplo de entrada
	        String titulo = "Mi Página Web";
	        String contenido = "Este es el contenido de la página web.";

	        // Generar el HTML
	        String html = generarHTML(titulo, contenido);

	        // Mostrar el resultado
	        System.out.println(html);
	    }
	    static String generarHTML(String titulo, String contenido) {
	        // Generar el código HTML
	        String html = "<!DOCTYPE html>\n";
	        html += "<html lang=\"es\">\n";
	        html += "<head>\n";
	        html += "<meta charset=\"UTF-8\">\n";
	        html += "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n";
	        html += "<title>" + titulo + "</title>\n";
	        html += "</head>\n";
	        html += "<body>\n";
	        html += "<h1>" + titulo + "</h1>\n";
	        html += "<p>" + contenido + "</p>\n";
	        html += "</body>\n";
	        html += "</html>";

	        return html;
	    }
	}
