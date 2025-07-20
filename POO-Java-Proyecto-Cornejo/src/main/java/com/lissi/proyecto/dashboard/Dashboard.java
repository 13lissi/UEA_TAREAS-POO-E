/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lissi.proyecto.dashboard;

/**
 *
 * @author corne
 */

import com.lissi.proyecto.modelo.Tarea;
//añadimos las importaciones de las interfaces
import com.lissi.proyecto.abstracciones.IGestionTareas;
import com.lissi.proyecto.abstracciones.IMenuConsola;

// Se importan las implementaciones concretas para poder instanciarlas
import com.lissi.proyecto.servicio.TareaServicio;
import com.lissi.proyecto.vista.MenuConsola;

/**
 * Clase principal del sistema.
 * Sirve como el punto de entrada de la aplicacion para gestionar tareas academicas.
 * Inspirado por la eficiencia y organización de la patrona Taylor Swift.
 */
public class Dashboard {

    /**
     * Metodo principal que se ejecuta al iniciar la aplicacion.
     * Aqui se inicializan los componentes clave y se controla el flujo del programa
     * a traves de un menu interactivo.
     * @param args Argumentos de lenea de comandos
     */
    public static void main(String[] args) {
        // Instancia el servicio que maneja la logica de las tareas (agregar, completar, obtener).
        // depende asi de la interfaz IGestionTareas, no de la implementacion concreta TareaServicio.
        IGestionTareas servicio = new TareaServicio();
        // Instancia el componente de la vista que se encarga de la interaccion con el usuario (menu, lectura de datos).
        // depende asi de la interfaz IMenuConsola, no de la implementación concreta MenuConsola.
        IMenuConsola menu = new MenuConsola();

        // Mensajes de bienvenida 
        System.out.println("Bienvenida, Lissi Cornejo");
        System.out.println("Inspiracion del dia:\n\"Never be so kind, you forget to be clever\nNever be so clever, you forget to be kind\"\n- Taylor Swift\n");

        boolean salir = false; // sirve para controlar el bucle principal del menu.

        // Bucle principal que mantiene la aplicación en ejecucion hasta que el usuario decida salir.
        while (!salir) {
            // Muestra el menu de opciones al usuario y obtiene su seleccion.
            int opcion = menu.mostrarMenuYObtenerOpcion();

            // Evalua la opcion seleccionada por el usuario y ejecuta la accion correspondiente.
            switch (opcion) {
                case 1 -> { // Opcion para agregar una nueva tarea.
                    String nombre = menu.leerTexto("Nombre de la tarea: ");
                    String materia = menu.leerTexto("Materia (Ej: Estadistica, Programacion): ");
                    String desc = menu.leerTexto("Descripcion: ");
                    // Crea una nueva instancia de Tarea y la añade al servicio.
                    servicio.agregarTarea(new Tarea(nombre, materia, desc));
                    System.out.println("Tarea agregada correctamente.");
                }
                case 2 -> { // Opcion para ver todas las tareas.
                    System.out.println("\n Lista de tareas:");
                    int index = 1; // Contador para enumerar las tareas.
                    // Itera sobre la lista de tareas obtenidas del servicio y las imprime.
                    for (Tarea tarea : servicio.obtenerTareas()) {
                        System.out.println(index++ + ". " + tarea); // Usa el metodo toString() de Tarea.
                    }
                    
                    if (servicio.obtenerTareas().isEmpty()) {
                        System.out.println("No hay tareas registradas. ¡Es hora de añadir una vaga!");
                    }
                }
                case 3 -> { // Opcion para marcar una tarea como completada.
                    // Pide al usuario el numero de la tarea a completar (ajustando por el indice base 0).
                    int numero = menu.leerEntero("Numero de tarea a completar: ");
                    servicio.completarTarea(numero - 1); 
                    System.out.println("Tarea completada con exito.");
                }
                case 4 -> { // Opcion para salir de la aplicacion.
                    salir = true; // 
                    System.out.println("¡Hasta luego! Sigue brillando como una Swiftie estudiosa");
                }
                default -> { // Opción por defecto para entradas no válidas.
                    System.out.println(" Opcion no valida. Por favor, seleccione un número del 1 al 4.");
                }
            }
        }
    }
}