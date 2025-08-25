/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;

/**
 *
 * @author corne
 */

import java.io.*;
import java.util.*;

public class inventario {
    private Map<String, producto> productos; // Almacena productos por su codigo
    private String archivo; // Nombre del archivo donde se guardan los productos

    // Constructor, recibe el nombre del archivo
    public inventario(String archivo) {
        this.archivo = archivo;
        productos = new HashMap<>();
        cargarInventario(); // Carga los productos existentes al iniciar
    }

    // Carga productos desde el archivo
    private void cargarInventario() {
        File file = new File(archivo);
        if (!file.exists()) {
            // Si no existe, se crea un archivo vacío
            System.out.println("Archivo no encontrado, se creara uno nuevo.");
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
            }
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                producto p = producto.desdeArchivo(linea);
                if (p != null) {
                    productos.put(p.getCodigo(), p);
                }
            }
            System.out.println("Inventario cargado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Guarda todos los productos en el archivo
    private void guardarInventario() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (producto p : productos.values()) {
                bw.write(p.toArchivo());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    // Agrega un nuevo producto
    public void agregarProducto(producto p) {
        if (productos.containsKey(p.getCodigo())) {
            System.out.println("El producto ya existe. Use actualizar para modificarlo.");
            return;
        }
        productos.put(p.getCodigo(), p);
        guardarInventario();
        System.out.println("Producto agregado exitosamente.");
    }

    // Actualiza un producto existente
    public void actualizarProducto(String codigo, String nombre, Integer cantidad, Double precio) {
        producto p = productos.get(codigo);
        if (p == null) {
            System.out.println("Producto no encontrado.");
            return;
        }
        if (nombre != null) p.setNombre(nombre);
        if (cantidad != null) p.setCantidad(cantidad);
        if (precio != null) p.setPrecio(precio);
        guardarInventario();
        System.out.println("Producto actualizado exitosamente.");
    }

    // Elimina un producto
    public void eliminarProducto(String codigo) {
        producto p = productos.remove(codigo);
        if (p != null) {
            guardarInventario();
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Muestra todos los productos
    public void mostrarInventario() {
        if (productos.isEmpty()) {
            System.out.println("Inventario vacio.");
            return;
        }
        System.out.println("Inventario actual:");
        for (producto p : productos.values()) {
            System.out.println(p);
        }
    }
}
