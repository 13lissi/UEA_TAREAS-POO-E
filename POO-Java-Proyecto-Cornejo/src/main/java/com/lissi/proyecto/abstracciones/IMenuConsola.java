/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lissi.proyecto.abstracciones;

/**
 *
 * @author corne
 */
/**
 * Esta es otra clase "contrato", pero para interactuar con el usuario.
 * Dice que acciones se pueden hacer para mostrar un men y leer lo que el usuario escribe.
 * NO como se hace (si es en la consola, una ventana grafica, etc)
 *
 * Tambien ayuda con el principio SOLID DIP, para que nuestro Dashboard
 * no dependa de si es una consola o una futura ventana grafica.
 * Investigando concluyo que es útil por si un dia modifico el prrograma queriendo tal vez
 * botones y ventanas en lugar de solo texto en la consola, sin cambiar mucho codigo 
 * en el Dashboard
 */

public interface IMenuConsola {
    int mostrarMenuYObtenerOpcion();
    String leerTexto(String mensaje);
    int leerEntero(String mensaje);
}
