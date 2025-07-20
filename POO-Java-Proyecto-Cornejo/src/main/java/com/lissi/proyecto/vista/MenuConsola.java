/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lissi.proyecto.vista;

/**
 *
 * @author corne
 */

import java.util.Scanner;
import com.lissi.proyecto.abstracciones.IMenuConsola; // Importacion para la interfaz

/**
 * Clase para mostrar el menu y capturar entradas del usuario desde la consola.
 */
public class MenuConsola implements IMenuConsola { // Implementa la interfaz IMenuConsola
    private final Scanner scanner;

    public MenuConsola() {
        scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menu principal y retorna la opcion seleccionada.
     * @return opcion ingresada por el usuario
     */
    @Override // Sobreescribe el metodo de la interfaz
    public int mostrarMenuYObtenerOpcion() {
        System.out.println("\n--- DASHBOARD UNIVERSITARIO ---");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Ver tareas");
        System.out.println("3. Completar tarea");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opcion: ");
        int opcion = scanner.nextInt();        
        scanner.nextLine();
        return opcion;
    }

    // Captura texto ingresado por el usuario
    @Override // Sobreescribe el metodo de la interfaz
    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    // Captura numeros enteros
    @Override // Sobreescribe el metodo de la interfaz
    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        int numero = scanner.nextInt();
        // Consumir el salto de linea pendiente despues de nextInt()
        scanner.nextLine();
        return numero;
    }
}