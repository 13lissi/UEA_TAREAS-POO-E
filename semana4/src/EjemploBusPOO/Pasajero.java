/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjemploBusPOO;

/**
 *
 * @author corne
 */
// Esta clase representa a un pasajero del bus
public class Pasajero extends Persona {
    private String destino;  // Lugar al que va el pasajero

    // Constructor: usa el de Persona y además guarda el destino
    public Pasajero(String nombre, String cedula, String destino) {
        super(nombre, cedula);
        this.destino = destino;
    }

    // Implementación del método abstracto para mostrar que es pasajero y a dónde va
    @Override
    public void mostrarRol() {
        System.out.println("Rol: Pasajero - Destino: " + destino);
    }
}

