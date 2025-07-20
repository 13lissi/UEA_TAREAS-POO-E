/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lissi.proyecto.abstracciones;

/**
 *
 * @author corne
 */

import com.lissi.proyecto.modelo.Tarea;
import java.util.List;

/**
 * Esta es una clase "contrato" para manejar tareas.
 * Dice que se puede hacer con las tareas (agregar, ver, completar),
 * pero no como se hace (si es en una lista, base de datos, etc.).
 *
 * La usamos para que nuestra clase principal (Dashboard) no dependa
 * directamente de como guardamos las tareas, sino de este contrato.
 * Esto es parte de un principio SOLID llamado DIP y Se añade con fines de integrar
 * un principio SOLID mas y experimentar con la tarea */

public interface IGestionTareas {
    void agregarTarea(Tarea tarea);
    List<Tarea> obtenerTareas();
    void completarTarea(int indice);
}
