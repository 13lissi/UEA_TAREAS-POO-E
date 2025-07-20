/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lissi.proyecto.servicio;

/**
 *
 * @author corne
 */


import com.lissi.proyecto.modelo.Tarea;
import java.util.ArrayList;
import java.util.List;
import com.lissi.proyecto.abstracciones.IGestionTareas; // Importación para la interfaz

/**
 * Servicio encargado de gestionar la lista de tareas.
 * Aplica el principio de responsabilidad unica (SRP).
 */
public class TareaServicio implements IGestionTareas { // Implementa la interfaz IGestionTareas
    private final List<Tarea> tareas;

    // Constructor que inicializa la lista de tareas
    public TareaServicio() {
        this.tareas = new ArrayList<>();
    }

    // Agrega una nueva tarea a la lista
    @Override // Sobreescribe el mtodo de la interfaz
    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    // Retorna todas las tareas registradas
    @Override // Sobreescribe el metodo de la interfaz
    public List<Tarea> obtenerTareas() {
        return tareas;
    }

    // Marca una tarea especifica como completada
    @Override // Sobreescribe el metodo de la interfaz
    public void completarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.get(indice).completarTarea();
        }
    }
}