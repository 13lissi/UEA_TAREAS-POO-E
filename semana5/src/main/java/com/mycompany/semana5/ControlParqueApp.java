/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana5;

/**
 *
 * @author corne
 */
import java.util.Scanner;

/**
 * Clase principal del programa
 * Aquí se recoge la información del usuario, se crea su perfil
 * y se evalúa si puede ingresar al juego extremo.
 */
public class ControlParqueApp {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Crear el parque con precio base del boleto
        Parque parque = new Parque(10.0f);

        // Mensaje de bienvenida
        System.out.println("=== Bienvenido al Parque de Diversiones ===");

        // Solicitar nombre del visitante
        System.out.print("Ingrese su nombre: ");
        String nombre = entrada.nextLine();

        // Leer la edad asegurando que sea válida (entero positivo)
        int edad = 0;
        while (true) {
            System.out.print("Ingrese su edad: ");
            String edadTexto = entrada.nextLine();
            try {
                edad = Integer.parseInt(edadTexto);
                if (edad < 0) throw new NumberFormatException(); // edad no puede ser negativa
                break;
            } catch (NumberFormatException e) {
                System.out.println("❌ Edad inválida. Ingrese un número entero positivo.");
            }
        }

        // Leer la altura permitiendo punto o coma y asegurando que sea razonable
        float altura = 0.0f;
        while (true) {
            System.out.print("Ingrese su altura en metros (ej. 1.60): ");
            String alturaTexto = entrada.nextLine().replace(",", ".");
            try {
                altura = Float.parseFloat(alturaTexto);
                if (altura < 0.5 || altura > 3.0) throw new NumberFormatException(); // altura razonable
                break;
            } catch (NumberFormatException e) {
                System.out.println("❌ Altura inválida. Use punto o coma y un valor entre 0.5 y 3.0 m.");
            }
        }

        // Leer si tiene pase VIP, asegurando solo valores true o false
        boolean tieneVip = false;
        while (true) {
            System.out.print("¿Tiene pase VIP? (true/false): ");
            String vipTexto = entrada.nextLine().trim().toLowerCase();
            if (vipTexto.equals("true")) {
                tieneVip = true;
                break;
            } else if (vipTexto.equals("false")) {
                tieneVip = false;
                break;
            } else {
                System.out.println("❌ Entrada inválida. Escriba 'true' o 'false'.");
            }
        }

        // Crear el visitante con los datos validados
        Visitante visitante = new Visitante(nombre, edad, altura, tieneVip);

        // Usar el parque para mostrar el resultado
        parque.mostrarResumen(visitante);

        entrada.close(); // Siempre es buena práctica cerrar el Scanner
    }
}
