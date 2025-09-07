
package com.mycompany.semana12;

/**
 *
 * @author corne
 */
// 
import java.util.List;

// Clase principal para probar el sistema de la biblioteca.
public class Init {
    public static void main(String[] args) {
        System.out.println("--- Iniciando Sistema de Biblioteca Digital ---");
        
        // -Se crea una instancia de la Biblioteca.
        Biblioteca biblioteca = new Biblioteca();
        System.out.println("\n--- Registro de Usuarios y Libros ---");

        // -Se registran dos usuarios.
        biblioteca.registrarUsuario(new Usuario("U1", "Ana"));
        biblioteca.registrarUsuario(new Usuario("U2", "Luis"));

        // -Se añaden dos libros al catalogo.
        biblioteca.anadirLibro(new Libro("ISBN-001", "Clean Code", "Robert C. Martin", "Software"));
        biblioteca.anadirLibro(new Libro("ISBN-002", "Effective Java", "Joshua Bloch", "Java"));
        biblioteca.anadirLibro(new Libro("ISBN-003", "The Pragmatic Programmer", "Andy Hunt", "Software"));

        System.out.println("\n--- Operaciones de Prestamo y Devolucion ---");

        // -Se prestan dos libros a diferentes usuarios.
        biblioteca.prestarLibro("U1", "ISBN-001"); // Ana presta Clean Code
        biblioteca.prestarLibro("U2", "ISBN-002"); // Luis presta Effective Java

        // -Se intenta prestar un libro ya prestado.
        biblioteca.prestarLibro("U1", "ISBN-002"); // Ana intenta prestar Effective Java (lo cual fallara)

        // - Se listan los libros prestados por Ana.
        System.out.println("\n--- Libros prestados por el usuario U1 (Ana) ---");
        List<Libro> prestadosAna = biblioteca.listarPrestados("U1");
        if (prestadosAna.isEmpty()) {
            System.out.println("Ana no tiene libros prestados.");
        } else {
            prestadosAna.forEach(System.out::println);
        }

        // -Ana devuelve el libro.
        biblioteca.devolverLibro("U1", "ISBN-001");
        
        // -Se verifica que Ana ya no tiene libros.
        System.out.println("\n--- Libros prestados por U1 (Ana) despues de la devolucion ---");
        prestadosAna = biblioteca.listarPrestados("U1");
        if (prestadosAna.isEmpty()) {
            System.out.println("Ana no tiene libros prestados.");
        } else {
            prestadosAna.forEach(System.out::println);
        }

        System.out.println("\n--- Busquedas en el Catalogo ---");

        // -Se busca un libro por autor.
        System.out.println("Buscando libros del autor 'Bloch':");
        List<Libro> porAutor = biblioteca.buscarPorAutor("Bloch");
        porAutor.forEach(System.out::println);

        // -Se busca un libro por categoria.
        System.out.println("\nBuscando libros de la categoria 'Software':");
        List<Libro> porCategoria = biblioteca.buscarPorCategoria("Software");
        porCategoria.forEach(System.out::println);
        
        System.out.println("\n--- Fin de la Simulacion ---");
    }
}
