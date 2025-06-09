/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana2tarea;

/**
 *
 * @author corne
 */
public class SEMANA2TAREA {

    // Clase para Abstracción
    static class Vehiculo {
        private String marca;
        private String modelo;

        public Vehiculo(String marca, String modelo) {
            this.marca = marca;
            this.modelo = modelo;
        }

        public void mostrarInfo() {
            System.out.println("Marca: " + marca + ", Modelo: " + modelo);
        }
    }

    // Clase para Encapsulación
    static class Telefono {
        private String numero;

        public Telefono(String numero) {
            setNumero(numero);
        }

        public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            if (numero != null && numero.matches("\\d{10}")) { // Validar que tenga 10 dígitos
                this.numero = numero;
            } else {
                System.out.println("Número inválido. Debe tener 10 dígitos.");
            }
        }
    }

    // Clase base para Herencia y Polimorfismo
    static class Empleado {
        protected String nombre;

        public Empleado(String nombre) {
            this.nombre = nombre;
        }

        public void trabajar() {
            System.out.println(nombre + " está trabajando.");
        }
    }

    static class Gerente extends Empleado {
        public Gerente(String nombre) {
            super(nombre);
        }

        @Override
        public void trabajar() {
            System.out.println(nombre + " está gestionando el equipo.");
        }
    }

    static class Desarrollador extends Empleado {
        public Desarrollador(String nombre) {
            super(nombre);
        }

        @Override
        public void trabajar() {
            System.out.println(nombre + " está escribiendo código.");
        }
    }

    public static void main(String[] args) {
        // Ejemplo de Abstracción
        System.out.println(" Abstracción:");
        Vehiculo vehiculo = new Vehiculo("Toyota", "Corolla");
        vehiculo.mostrarInfo();

        // Ejemplo de Encapsulación
        System.out.println("\n Encapsulación:");
        Telefono telefono = new Telefono("1234567890");
        System.out.println("Número de teléfono: " + telefono.getNumero());
        telefono.setNumero("abc123"); // Intento inválido

        // Ejemplo de Herencia
        System.out.println("\n Herencia:");
        Empleado emp = new Empleado("Taylor swift");
        emp.trabajar();
        Gerente gerente = new Gerente("Travis kelce");
        gerente.trabajar();

        // Ejemplo de Polimorfismo
        System.out.println("\n Polimorfismo:");
        Empleado[] empleados = { new Desarrollador("Lissi"), new Gerente("Mabel") };
        for (Empleado e : empleados) {
            e.trabajar();
        }
    }
}



