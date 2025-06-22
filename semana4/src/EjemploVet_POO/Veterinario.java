/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjemploVet_POO;

/**
 *
 * @author corne
 */
// Clase Veterinario: contiene el nombre del veterinario y puede revisar animales
public class Veterinario {
    private String nombre;

    public Veterinario(String nombre) {
        this.nombre = nombre;
    }

    // Método que acepta cualquier objeto tipo Animal (uso de polimorfismo)
    public void revisarAnimal(Animal animal) {
        System.out.println("Veterinario " + nombre + " revisa al animal:");
        animal.mostrarInfo();
        animal.hacerSonido();
        System.out.println("-------------------------");
    }
}

