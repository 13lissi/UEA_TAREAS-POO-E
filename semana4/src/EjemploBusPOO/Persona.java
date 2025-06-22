/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjemploBusPOO;

/**
 *
 * @author corne
 */
// Esta clase representa a las persona que usan el servicio de bus.
// Es abstracta porque no se puede crear directamente, solo se hereda.
public abstract class Persona {
    protected String nombre;  // Nombre de la persona
    protected String cedula;  // Cédula 

    // Constructor: sirve para crear un objeto con su nombre y cédula
    public Persona(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    // Método que muestra el nombre y cédula de la persona
    public void mostrarIdentidad() {
        System.out.println("Nombre: " + nombre + ", Cédula: " + cedula);
    }

    // Método abstracto: cada subclase debe decir qué rol tiene (conductor o pasajero)
    public abstract void mostrarRol();
}

