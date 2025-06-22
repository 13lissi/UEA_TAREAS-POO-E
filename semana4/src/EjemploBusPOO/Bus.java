/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjemploBusPOO;

/**
 *
 * @author corne
 */
import java.util.ArrayList;
import java.util.List;

// Esta clase representa al bus y contiene la información de su conductor y pasajeros
public class Bus {
    private String placa;              // Placa del bus (ej: ABC-123)
    private Conductor conductor;       // Objeto tipo Conductor
    private List<Pasajero> pasajeros;  // Lista de pasajeros (pueden ser muchos)

    // Constructor: se crea el bus con su placa y su conductor
    public Bus(String placa, Conductor conductor) {
        this.placa = placa;
        this.conductor = conductor;
        this.pasajeros = new ArrayList<>();  // Inicializa la lista vacía de pasajeros
    }

    // Método para agregar un pasajero al bus
    public void agregarPasajero(Pasajero pasajero) {
        pasajeros.add(pasajero);
    }

    // Método para mostrar toda la información del bus, su conductor y sus pasajeros
    public void mostrarInformacion() {
        System.out.println("BUS " + placa);
        System.out.println("Conductor:");
        conductor.mostrarIdentidad();  // Muestra nombre y cédula
        conductor.mostrarRol();        // Muestra que es conductor y su licencia

        System.out.println("\nPasajeros:");
        for (Pasajero p : pasajeros) {
            p.mostrarIdentidad();     // Muestra nombre y cédula del pasajero
            p.mostrarRol();           // Muestra que es pasajero y su destino
            System.out.println("---"); // Separador visual
        }
    }
}

