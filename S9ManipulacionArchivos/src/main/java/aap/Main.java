
package aap;

/**
 *
 * @author corne
 */

import gestor.GestorDeArchivo; 
import validacion.ValidadorArchivo; 
import excepciones.ArchivoVacioException; 
import java.util.List;

/**
 * Clase principal qur:
 * - Guardar archivos
 * - Leer archivos línea por línea
 * - Validar si están vacíos
 * - Manejar excepciones
 */
public class Main {
    public static void main(String[] args) {
        GestorDeArchivo gestor = new GestorDeArchivo();
        ValidadorArchivo validador = new ValidadorArchivo();

        String archivo = "mi_DocSecret.txt";
        String contenido = "Taylor swift mi patrona.\nAmo a mis gatos <3.";

        try {
            // Guardar contenido
            gestor.guardar(archivo, contenido);

            // Verificar que no este vacio
            System.out.println("\nVerificando el archivo...");
            validador.verificarNoVacio(archivo);
            System.out.println("El archivo tiene contenido :3.");

            // Leer y mostrar el contenido linea por linea
            System.out.println("\nContenido del archivo:");
            System.out.println("------------------------------------");
            List<String> lineas = gestor.leer(archivo);
            for (int i = 0; i < lineas.size(); i++) {
                System.out.println("Linea" + (i + 1) + ": " + lineas.get(i));
            }
            System.out.println("------------------------------------");
            
            // prueba de excepcion con archivo vacio
            String archivoVacio = "arch_Solitario.txt";
            gestor.guardar(archivoVacio, ""); // Creamos un archivo vacio
            System.out.println("\nAnalizando archivo...");
            validador.verificarNoVacio(archivoVacio); // Aqui lanza la excepcion

        } catch (ArchivoVacioException e) {
            System.err.println("Excepcion registrada: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error inesperado: " + e.getMessage());
        }
    }
}

