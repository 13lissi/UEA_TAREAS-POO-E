/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjemploHeladeriaPOO;

/**
 *
 * @author corne
 */
// Clase Helado:
// Hereda de Producto. Es un helado simple sin extras.
public class Helado extends Producto {
    private String sabor;  // Sabor del helado 

    // Constructor: llama al constructor de Producto y guarda el sabor
    public Helado(String sabor, double precio) {
        super("Helado de " + sabor, precio);
        this.sabor = sabor;
    }

    // Calcula el precio final del helado (igual al precio base porque no hay extras)
    @Override
    public double calcularPrecioFinal() {
        return precio;
    }
}

