/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.semana5;

/**
 *
 * @author corne
 */

/**
 * Clase Parque
 * Esta clase representa el parque y su lógica para permitir o no
 * la entrada de personas a un juego extremo, según sus características.
 */
public class Parque {
    // Precio estándar del boleto sin VIP
    private float precioBase;

    // Constructor: define el precio del parque
    public Parque(float precioBase) {
        this.precioBase = precioBase;
    }

    /**
     * Método que verifica si el visitante puede entrar al juego extremo.
     * Debe tener mínimo 12 años y medir al menos 1.40 metros.
     */
    public boolean puedeIngresar(Visitante visitante) {
        return visitante.getEdad() >= 12 && visitante.getAltura() >= 1.4;
    }

    /**
     * Método que calcula cuánto debe pagar el visitante.
     * Si tiene pase VIP, entra gratis. Si no, paga el precio base.
     * @param visitante Un objeto de tipo Visitante que representa al visitante,
     *                  el cual puede tener un pase VIP.
     * @return El precio que debe pagar el visitante. Devuelve 0.0 si tiene pase VIP,
     *         o el precio base si no lo tiene. 
     */
    public float calcularPrecio(Visitante visitante) {
        return visitante.tieneVip() ? 0.0f : precioBase;
    }

    /**
     * Muestra toda la información del visitante y el resultado de su ingreso.
     * @param visitante
     */
    public void mostrarResumen(Visitante visitante) {
        System.out.println("\nResumen del visitante:");
        System.out.println("Nombre: " + visitante.getNombre());
        System.out.println("Edad: " + visitante.getEdad());
        System.out.println("Altura: " + visitante.getAltura() + " m");
        System.out.println("Pase VIP: " + (visitante.tieneVip() ? "Sí" : "No"));

        // Se muestra si puede o no ingresar al juego extremo
        if (puedeIngresar(visitante)) {
            System.out.println("¡Puede subir al juego extremo!");
            System.out.println("Precio de entrada: $" + calcularPrecio(visitante));
            System.out.println("Gracias");
        } else {
            System.out.println(" No cumple con los requisitos para el juego extremo.");
            System.out.println("Debe tener al menos 12 años y medir mínimo 1.4 metros.");
        }
    }
}
