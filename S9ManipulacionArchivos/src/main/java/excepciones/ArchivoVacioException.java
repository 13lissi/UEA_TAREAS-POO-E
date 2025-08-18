
package excepciones;

/**
 *
 * @author corne
 */

/**
 * Excepcion personalizada para indicar que un archivo esta vacio.
 * Esta excepcion obliga a manejarla con try-catch.
 */
public class ArchivoVacioException extends Exception {

    /**
     * Constructor que recibe un mensaje explicando por que se lanza la excepcion.
     *
     * @param mensaje Mensaje de error
     */
    public ArchivoVacioException(String mensaje) {
        super(mensaje); // Se llama al constructor de Exception
    }
}

