/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjemploBusPOO;

/**
 *
 * @author corne
 */
// Esta es la clase principal que contiene el método main para iniciar el programa
public class ServicioBus {
    public static void main(String[] args) {
        // Crear un conductor con nombre, cédula y tipo de licencia
        Conductor chofer = new Conductor("Wilson Cornejo", "1102233445", "Tipo C");

        // Crear el bus, indicando su placa y quién lo conduce
        Bus bus1 = new Bus("ABC-123", chofer);

        // Crear pasajeros y agregarlos al bus
        Pasajero pasajero1 = new Pasajero("Mabel Cornejo", "0102030405", "Quito");
        Pasajero pasajero2 = new Pasajero("LIssi Cornejo", "0203040506", "Santo Domingo");

        bus1.agregarPasajero(pasajero1);
        bus1.agregarPasajero(pasajero2);

        // Mostrar la información completa del bus, conductor y pasajeros
        bus1.mostrarInformacion();
    }
}

