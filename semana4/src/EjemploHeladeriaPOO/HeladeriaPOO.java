/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjemploHeladeriaPOO;

/**
 *
 * @author corne
 */
// Clase principal: aquí comienza la ejecución del programa
public class HeladeriaPOO {
    public static void main(String[] args) {
        // Crear un helado simple de fresa
        Producto heladoFresa = new Helado("Fresa", 1.50);

        // Crear un sundae de chocolate con topping de chispas
        Producto sundaeChoco = new Sundae("Chocolate", "Chispas", 2.00, 0.50);

        // Crear un cliente 
        Cliente cliente = new Cliente("Mabel");

        // El cliente hace pedidos de los dos productos
        cliente.hacerPedido(heladoFresa);
        cliente.hacerPedido(sundaeChoco);
    }
}

