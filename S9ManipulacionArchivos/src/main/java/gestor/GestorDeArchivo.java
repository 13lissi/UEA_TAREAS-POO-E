
package gestor;

/**
 *
 * @author corne
 */

// Librerias necesarias para trabajar con archivos(comentado para recordar)
import java.io.BufferedReader;   // Para leer archivos linea por linea de forma rapida
import java.io.BufferedWriter;   // Para escribir en archivos de manera eficiente
import java.io.FileReader;       // Para abrir un archivo y leerlo
import java.io.FileWriter;       // Para abrir un archivo y escribir en el
import java.io.IOException;      // Para manejar errores de lectura/escritura
import java.util.ArrayList;      // Lista dinamica para guardar las lineas
import java.util.List;           // Interfaz para manejar listas de manera generica

/**
 * Clase que permite guardar y leer archivos de texto.
 */
public class GestorDeArchivo {

    /**
     * Guarda un contenido en un archivo de texto.
     * Si el archivo no existe, lo crea; si existe, lo sobrescribe.
     *
     * @param nombreArchivo Nombre del archivo donde se guardara el contenido
     * @param contenido Texto que se va a guardar en el archivo
     */
    public void guardar(String nombreArchivo, String contenido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(contenido); // Guardamos el texto en el archivo
            System.out.println("Archivo '" + nombreArchivo + "' guardado con exito.");
        } catch (IOException e) {
            System.err.println("Error al guardar archivo: " + e.getMessage());
        }
    }

    /**
     * Lee un archivo linea por linea y devuelve todas las lineas en una lista.
     *
     * @param nombreArchivo Nombre del archivo que queremos leer
     * @return Lista con todas las líneas del archivo
     */
    public List<String> leer(String nombreArchivo) {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea); // Guardamos cada línea en la lista
            }
        } catch (IOException e) {
            System.err.println("Error al leer archivo: " + e.getMessage());
        }
        return lineas;
    }
}
