/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjemploHeladeriaPOO;

/**
 *
 * @author corne
 */
// Clase Sundae:
// También hereda de Producto. Tiene un topping que cuesta un extra.
public class Sundae extends Producto {
    private String topping;   // Nombre del topping (ejemplo: chispas)
    private double extra;     // Precio adicional por el topping

    // Constructor: se crea con sabor, topping, precio base y extra
    public Sundae(String sabor, String topping, double precioBase, double extra) {
        super("Sundae de " + sabor + " con " + topping, precioBase);
        this.topping = topping;
        this.extra = extra;
    }

    // Calcula el precio final sumando el precio base + el costo del topping
    @Override
    public double calcularPrecioFinal() {
        return precio + extra;
    }
}

