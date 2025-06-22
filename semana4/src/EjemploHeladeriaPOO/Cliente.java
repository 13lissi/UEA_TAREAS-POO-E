/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjemploHeladeriaPOO;

/**
 *
 * @author corne
 */
// Clase Cliente:
// Representa a una persona que compra productos en la heladería.
public class Cliente {
    private String nombre;  // Nombre del cliente

    // Constructor: se crea el cliente con su nombre
    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    // Método para hacer un pedido de cualquier producto
    public void hacerPedido(Producto producto) {
        System.out.println("Cliente: " + nombre);
        producto.mostrarInfo();  // Muestra información básica del producto
        System.out.println("Total a pagar: $" + producto.calcularPrecioFinal());
        System.out.println("---------------------------");
    }
}

