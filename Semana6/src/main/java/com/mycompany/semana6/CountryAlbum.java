
package com.mycompany.semana6;

/**
 *
 * @author corne
 */
// Clase derivada que hereda de ClasificaAlbums (HERENCIA)
public class CountryAlbum extends Albums {
    // Atributo privado específico para CountryAlbum (ENCAPSULACIÓN)
    private String producer;

    // Constructor que llama a super para inicializar atributos heredados
    public CountryAlbum(String title, int year, String label) {
        super(title, year); // HERENCIA: llama constructor de la clase base
        this.producer = label; // Inicializa atributo propio
    }

    // Getters y setters para el atributo encapsulado producer
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    // POLIMORFISMO: Metodo sobrescrito para mostrar info especifica de CountryAlbum
    @Override
    public void showInfo() {
        System.out.println("Country Album: " + getTitle() + " - Year: " + getYear() + " - Producer/Label: " + producer);
    }
}

