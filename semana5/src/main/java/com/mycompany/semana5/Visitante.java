
package com.mycompany.semana5;

/**
 *
 * @author corne
 */

/**
 * Clase Visitante
 * Esta clase representa a una persona que visita el parque.
 * Guarda su nombre, edad, altura y si tiene pase VIP.
 */
public class Visitante {
    // Atributos privados que describen al visitante
    private String nombre;
    private int edad;
    private float altura;
    private boolean tieneVip;

    // Constructor: inicializa al visitante con sus datos
    public Visitante(String nombre, int edad, float altura, boolean tieneVip) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.tieneVip = tieneVip;
    }

    // Métodos públicos para acceder a los datos desde otras clases (getters)
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public float getAltura() {
        return altura;
    }

    public boolean tieneVip() {
        return tieneVip;
    }
}
