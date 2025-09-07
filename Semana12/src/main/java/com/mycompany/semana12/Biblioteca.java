
package com.mycompany.semana12;

/**
 *
 * @author corne
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// La clase Biblioteca gestiona todas las operaciones: libros, usuarios y prestamos.
public class Biblioteca {

    // Colecciones para almacenar los datos.
    // Map para busquedas rapidas por clave (ISBN o ID).
    private final Map<String, Libro> catalogoPorIsbn;
    private final Map<String, Usuario> usuariosPorId;
    // Set para verificar rapidamente si un libro esta prestado (no permite duplicados).
    private final Set<String> isbnsPrestados;

    // Constructor que inicializa las colecciones vacias.
    public Biblioteca() {
        this.catalogoPorIsbn = new HashMap<>();
        this.usuariosPorId = new HashMap<>();
        this.isbnsPrestados = new HashSet<>();
    }

    // --- Funcionalidades de Libros ---

    public void anadirLibro(Libro libro) {
        // Se añade el libro al mapa usando su ISBN como clave.
        // putIfAbsent evita sobreescribir un libro si ya existe.
        catalogoPorIsbn.putIfAbsent(libro.getIsbn(), libro);
        System.out.println("INFO: Libro agregado al catalogo: " + libro.getTitulo());
    }

    public void quitarLibro(String isbn) {
        if (isbnsPrestados.contains(isbn)) {
            System.out.println("ERROR: No se puede quitar el libro con ISBN " + isbn + " porque esta prestado.");
        } else if (catalogoPorIsbn.remove(isbn) != null) {
            System.out.println("INFO: Libro con ISBN " + isbn + " ha sido quitado del catalogo.");
        } else {
            System.out.println("ERROR: No se encontro un libro con el ISBN " + isbn + ".");
        }
    }

    // --- Funcionalidades de Usuarios ---

    public void registrarUsuario(Usuario usuario) {
        // Se registra al usuario usando su ID como clave.
        usuariosPorId.putIfAbsent(usuario.getId(), usuario);
        System.out.println("INFO: Usuario registrado: " + usuario.getNombre());
    }

    public void darBajaUsuario(String id) {
        Usuario usuario = usuariosPorId.get(id);
        if (usuario != null) {
            if (usuario.getIsbnsPrestados().isEmpty()) {
                usuariosPorId.remove(id);
                System.out.println("INFO: Usuario " + id + " ha sido dado de baja :(.");
            } else {
                System.out.println("ERROR: No se puede dar de baja al usuario " + id + " porque tiene libros prestados.");
            }
        } else {
            System.out.println("ERROR: No se encontro un usuario con el ID " + id + ".");
        }
    }

    // --- Funcionalidades de Prestamos ---

    public void prestarLibro(String idUsuario, String isbn) {
        Usuario usuario = usuariosPorId.get(idUsuario);
        Libro libro = catalogoPorIsbn.get(isbn);

        if (usuario == null) {
            System.out.println("ERROR: El usuario " + idUsuario + " no existe.");
            return;
        }
        if (libro == null) {
            System.out.println("ERROR: El libro con ISBN " + isbn + " no existe.");
            return;
        }
        if (isbnsPrestados.contains(isbn)) {
            System.out.println("ERROR: El libro '" + libro.getTitulo() + "' ya esta prestado.");
            return;
        }
        
        // Si todo es correcto, se realiza el prestamo.
        isbnsPrestados.add(isbn);
        usuario.agregarIsbnPrestado(isbn);
        System.out.println("INFO: El libro '" + libro.getTitulo() + "' ha sido prestado a " + usuario.getNombre() + ".");
    }

    public void devolverLibro(String idUsuario, String isbn) {
        Usuario usuario = usuariosPorId.get(idUsuario);
        Libro libro = catalogoPorIsbn.get(isbn);

        if (usuario == null) {
            System.out.println("ERROR: El usuario " + idUsuario + " no existe.");
            return;
        }
        if (libro == null) {
            // Este caso es raro(practico), significaria que el libro fue eliminado mientras estaba prestado.
            System.out.println("ERROR: El libro con ISBN " + isbn + " ya no existe en el catalogo.");
            return;
        }
        if (usuario.getIsbnsPrestados().contains(isbn)) {
            isbnsPrestados.remove(isbn);
            usuario.quitarIsbnPrestado(isbn);
            System.out.println("INFO: El libro '" + libro.getTitulo() + "' ha sido devuelto por " + usuario.getNombre() + ".");
        } else {
            System.out.println("ERROR: El usuario " + usuario.getNombre() + " no tiene prestado este libro.");
        }
    }
    
    // --- Funcionalidades de Busqueda y Listado ---

    // Usamos la API de Streams de Java para buscar de forma declarativa.
    public List<Libro> buscarPorTitulo(String texto) {
        return catalogoPorIsbn.values().stream()
                .filter(libro -> libro.getTitulo().toLowerCase().contains(texto.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Libro> buscarPorAutor(String texto) {
        return catalogoPorIsbn.values().stream()
                .filter(libro -> libro.getAutor().toLowerCase().contains(texto.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Libro> buscarPorCategoria(String texto) {
        return catalogoPorIsbn.values().stream()
                .filter(libro -> libro.getCategoria().equalsIgnoreCase(texto))
                .collect(Collectors.toList());
    }

    public List<Libro> listarPrestados(String idUsuario) {
        Usuario usuario = usuariosPorId.get(idUsuario);
        if (usuario != null) {
            // Se crea una lista vacia para guardar los libros encontrados.
            List<Libro> librosEncontrados = new ArrayList<>();
            // Se recorre la lista de ISBNs prestados por el usuario.
            for (String isbn : usuario.getIsbnsPrestados()) {
                Libro libro = catalogoPorIsbn.get(isbn);
                if (libro != null) {
                    librosEncontrados.add(libro);
                }
            }
            return librosEncontrados;
        }
        // Si el usuario no existe, devuelve una lista vacia.
        return new ArrayList<>();
    }
}
