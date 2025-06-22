/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjemploVet_POO;

/**
 *
 * @author corne
 */
// Clase principal: ejecuta el programa
public class VeterinariaPOO {
    public static void main(String[] args) {
        // Llamado Perro y Gato
        Animal perro = new Perro("Jake", 5, "Labrador");
        Animal gato = new Gato("Michita", 3, true);

        // Creamos el veterinario
        Veterinario vet = new Veterinario("Dra. Mabel");

        // Revisar los animales (uso de polimorfismo)
        vet.revisarAnimal(perro);
        vet.revisarAnimal(gato);
    }
}

