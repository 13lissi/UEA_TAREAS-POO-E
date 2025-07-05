/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana6;

/**
 *
 * @author corne
 */
// Clase derivada que hereda de Albums
// Aqui esta la HERENCIA en accion: PopAlbum es un tipo de Albums
public class PopAlbum extends Albums {
    // Atributo privado especifico para PopAlbum (encapsulacion)
    private String producerpop;

    // Constructor de PopAlbum
    // Uso de 'super' para llamar al constructor de la clase base y reutilizar codigo
    public PopAlbum(String title, int year, String producer) {
        super(title, year); // Herencia: inicializa atributos heredados en la clase padre
        this.producerpop = producer; // Inicializa atributo propio de PopAlbum
    }

    // Getters y setters para el atributo encapsulado producerpop
    public String getProducerpop() {
        return producerpop;
    }

    public void setProducerpop(String producerpop) {
        this.producerpop = producerpop;
    }

    // POLIMORFISMO: Metodo sobrescrito para mostrar info especifica de PopAlbum
    @Override
    public void showInfo() {
        System.out.println("Pop Album: " + getTitle() + " - Year: " + getYear() + " - Producer: " + producerpop);
    }
}
