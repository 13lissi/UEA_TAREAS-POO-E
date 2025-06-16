
package com.mycompany.semana3_tarea.newpackage;

/**
 *
 * @author corne
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class ClimaMachala_PTradicional {

    // Función para ingresar temperaturas diarias con validación de entrada numérica
    public static double[] ingresarTemperaturas() {
        Scanner scanner = new Scanner(System.in);
        double[] temperaturas = new double[7];
        System.out.println("¡Hola! Bienvenido al registro de temperaturas de la semana en la ciudad de Machala");
        
        for (int i = 0; i < 7; i++) {
            boolean entradaValida = false; // Variable para controlar la validez de la entrada
            while (!entradaValida) {
                System.out.print("Ingrese la temperatura del día " + (i + 1) + ": ");
                try {
                    temperaturas[i] = scanner.nextDouble(); // Intenta leer un número
                    entradaValida = true; // La entrada es válida
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor ingrese un valor numérico para la temperatura.");
                    scanner.next(); // Descarta la entrada inválida
                }
            }
        }
        return temperaturas; // Devuelve el array de temperaturas
    }

    // Función para calcular el promedio semanal
    public static double calcularPromedio(double[] temperaturas) {
        double suma = 0;
        for (double temp : temperaturas) {
            suma += temp; // Suma todas las temperaturas
        }
        return suma / temperaturas.length; // Calcula y devuelve el promedio
    }

    public static void main(String[] args) {
        double[] temperaturas = ingresarTemperaturas(); // Llama a la función para ingresar temperaturas
        double promedio = calcularPromedio(temperaturas); // Calcula el promedio
        System.out.printf("El promedio semanal de temperaturas en Machala es: %.2f °C%n", promedio); // Muestra el promedio
        System.out.printf("¡Gracias! Ten un buen día.%n"); // Mensaje de despedida
        
    }
}


