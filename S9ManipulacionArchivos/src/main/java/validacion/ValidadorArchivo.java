
package validacion;

/**
 *
 * @author corne
 */

import excepciones.ArchivoVacioException; // Importamos nuestra excepcion
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que verifica que un archivo tenga contenido.
 */
public class ValidadorArchivo {

    /**
     * Verifica si un archivo esta vacio.
     *
     * @param nombreArchivo Nombre del archivo a verificar
     * @throws ArchivoVacioException Si el archivo no tiene contenido
     */
    public void verificarNoVacio(String nombreArchivo) throws ArchivoVacioException {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            if (reader.readLine() == null) { // Si la primera línea es null, esta vacio
                throw new ArchivoVacioException("El archivo '" + nombreArchivo + "' esta vacio.");
            }
        } catch (IOException e) {
            System.err.println("Error al verificar archivo: " + e.getMessage());
        }
    }
}
