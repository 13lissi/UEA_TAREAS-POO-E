/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lissi.proyecto.modelo;

/**
 *
 * @author corne
 */

/**
 * Representa una tarea academica con sus atributos y estado.
 * Esta clase modela una tarea individual dentro del sistema.
 */
public class Tarea {
    private String nombre;
    private String materia;
    private String descripcion;
    private boolean completada;

    // Constructor para crear una nueva instancia de Tarea.
    public Tarea(String nombre, String materia, String descripcion) {
        this.nombre = nombre;
        this.materia = materia;
        this.descripcion = descripcion;
        this.completada = false;
    }

    // Getters
    // Permiten acceder a los valores de los atributos privados.
    public String getNombre() {
        return nombre;
    }

    public String getMateria() {
        return materia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    // Metodo para marcar la tarea como completada
    public void completarTarea() {
        this.completada = true;
    }

    // Muestra el estado de la tarea en formato legible
    @Override
    public String toString() {
        return nombre + " - " + materia + "\n" + descripcion +
               "\nEstado: " + (completada ? "Completada" : "Pendiente");
    }
}