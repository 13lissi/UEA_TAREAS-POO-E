/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjemploBusPOO;

/**
 *
 * @author corne
 */
// Esta clase representa al conductor del bus
public class Conductor extends Persona {
    private String licencia;  // Tipo de licencia del conductor

    // Constructor: usa el de Persona y además guarda el tipo de licencia
    public Conductor(String nombre, String cedula, String licencia) {
        super(nombre, cedula);
        this.licencia = licencia;
    }

    // Implementación del método abstracto para mostrar que es conductor y su tipo de licencia
    @Override
    public void mostrarRol() {
        System.out.println("Rol: Conductor - Licencia: " + licencia);
    }
}

