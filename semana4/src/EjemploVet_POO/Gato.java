/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjemploVet_POO;

/**
 *
 * @author corne
 */
// Clase Gato: hereda de Animal y añade si es doméstico
public class Gato extends Animal {
    private boolean esDomestico;

    public Gato(String nombre, int edad, boolean esDomestico) {
        super(nombre, edad);
        this.esDomestico = esDomestico;
    }

    // Implementación del sonido de un gato
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Miau!");
    }

    // Muestra la información del gato, incluyendo si es doméstico
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Doméstico: " + (esDomestico ? "Sí" : "No"));
    }
}

