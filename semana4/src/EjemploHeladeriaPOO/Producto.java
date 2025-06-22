/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjemploHeladeriaPOO;

/**
 *
 * @author corne
 */
// Clase abstracta Producto:
// Esta clase representa cualquier producto que se pueda vender en la heladería.
// Es abstracta porque no se puede crear directamente, solo puede usarse como base.
public abstract class Producto {
    protected String nombre;  // Nombre del producto 
    protected double precio;  // Precio base del producto

    // Constructor: se usa para crear el producto con nombre y precio
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Método que muestra el nombre y el precio del producto
    public void mostrarInfo() {
        System.out.println("Producto: " + nombre + " - Precio: $" + precio);
    }

    // Método abstracto para calcular el precio final (con o sin extras)
    public abstract double calcularPrecioFinal();
}

