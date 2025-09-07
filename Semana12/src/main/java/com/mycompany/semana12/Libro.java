
package com.mycompany.semana12;

/**
 *
 * @author corne
 */


// La clase Libro representa la informacion de un libro.
// clase inmutable
public final class Libro {

    // Atributos privados y finales para garantizar la inmutabilidad.
    private final String isbn;
    private final String titulo;
    private final String autor;
    private final String categoria;

    // Constructor para inicializar todos los atributos del libro.
    public Libro(String isbn, String titulo, String autor, String categoria) {
        // Validacion para asegurar que ningun campo este vacio o nulo.
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("El ISBN no puede ser nulo o vacio.");
        }
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El titulo no puede ser nulo o vacio.");
        }
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor no puede ser nulo o vacio.");
        }
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("La categoria no puede ser nula o vacia.");
        }

        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
    }

    // Metodos 'get' para acceder a los atributos desde fuera de la clase.
    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    // Sobrescribimos el metodo toString 
    //para que la informacion del libro se muestre de forma clara.
    @Override
    public String toString() {
        return "Libro [ISBN: " + isbn + ", Titulo: '" + titulo + "', Autor: '" + autor + "', Categoria: '" + categoria + "']";
    }
}
