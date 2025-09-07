
package com.mycompany.semana12;

/**
 *
 * @author corne
 */

import java.util.ArrayList;
import java.util.List;

// La clase Usuario representa a una persona registrada en la biblioteca.
public class Usuario {

    // Atributos privados para encapsular la informacion del usuario.
    private final String id;
    private final String nombre;
    private final List<String> isbnsPrestados; // Lista para guardar los ISBN de los libros prestados.

    // Constructor para crear un nuevo usuario.
    public Usuario(String id, String nombre) {
        // Validacion para asegurar que los datos del usuario no esten vacios.
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del usuario no puede ser nulo o vacio.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del usuario no puede ser nulo o vacio.");
        }
        this.id = id;
        this.nombre = nombre;
        // Se inicializa la lista de libros prestados como una lista vacia.
        this.isbnsPrestados = new ArrayList<>();
    }

    // Metodos 'get' para obtener los datos del usuario.
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getIsbnsPrestados() {
        // Devolvemos una copia para evitar que se modifique la lista original desde fuera.
        return new ArrayList<>(isbnsPrestados);
    }

    // Metodo para anadir un libro a la lista de prestados del usuario.
    // Este metodo sera llamado por la clase Biblioteca.
    public void agregarIsbnPrestado(String isbn) {
        this.isbnsPrestados.add(isbn);
    }

    // Metodo para quitar un libro de la lista de prestados del usuario.
    public void quitarIsbnPrestado(String isbn) {
        this.isbnsPrestados.remove(isbn);
    }

    // Metodo toString para mostrar la informacion del usuario de forma legible.
    @Override
    public String toString() {
        return "Usuario [ID: " + id + ", Nombre: '" + nombre + "']";
    }
}
