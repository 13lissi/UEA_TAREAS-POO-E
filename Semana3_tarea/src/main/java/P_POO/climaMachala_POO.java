/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P_POO;

/**
 *
 * @author corne
 */


import java.util.ArrayList; // Para manejar listas dinámicas
import java.util.InputMismatchException; // Para manejar errores de entrada
import java.util.Scanner; // Para leer la entrada del usuario

/**
 * Clase que representa la información diaria del clima.
 * -> Aquí aplicamos **Encapsulamiento**: el atributo 'temperatura' es privado, 
 *    solo accesible mediante métodos getters y setters para proteger su acceso.
 */
class ClimaDia {
    private double temperatura; // Atributo privado que representa la temperatura de un día

    public ClimaDia() {
        this.temperatura = 0.0; // Inicializamos la temperatura a un valor por defecto
    }

    // Método público para establecer la temperatura (setter)
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    // Método público para obtener la temperatura (getter)
    public double getTemperatura() {
        return temperatura;
    }
}

/**
 * Clase principal que representa un pronóstico climático semanal para una ubicación específica.
 * Esta clase demuestra los conceptos fundamentales de POO, incluyendo encapsulamiento y abstracción.
 * 
 * -> **Encapsulamiento**: mantiene las propiedades 'dias' y 'ubicacion' privadas para proteger los datos internos.
 * -> **Abstracción**: la clase oculta los detalles de cómo se manejan las temperaturas, 
 *    y ofrece métodos claros para interactuar con esa información (registrarTemperaturas, calcularPromedio, etc.).
 */
public class climaMachala_POO {
    private ArrayList<ClimaDia> dias;  // Lista privada con objetos ClimaDia (encapsulamiento)
    private String ubicacion;           // Ubicación del pronóstico (encapsulamiento)

    /**
     * Constructor que inicializa la lista de días y la ubicación.
     * Aquí se abstracta la inicialización interna para el usuario de la clase.
     * @param ubicacion Ciudad o lugar para el pronóstico.
     */
    public climaMachala_POO(String ubicacion) {
        this.dias = new ArrayList<>();
        this.ubicacion = ubicacion;
        for (int i = 0; i < 7; i++) {
            dias.add(new ClimaDia()); // Creamos 7 objetos ClimaDia para almacenar temperaturas semanales
        }
    }

    /**
     * Método para permitir al usuario ingresar las temperaturas diarias.
     * Implementa validación para evitar entradas inválidas.
     */
    public void registrarTemperaturas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Hola! Bienvenido al registro de temperaturas de la semana en " + this.ubicacion);
        
        for (int i = 0; i < dias.size(); i++) {
            boolean entradaValida = false;
            while (!entradaValida) {
                System.out.print("Ingrese la temperatura del día " + (i + 1) + ": ");
                try {
                    double temp = scanner.nextDouble();
                    dias.get(i).setTemperatura(temp); // Uso del encapsulamiento para asignar temperatura
                    entradaValida = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor ingrese un valor numérico para la temperatura.");
                    scanner.next(); // Descartar entrada inválida y pedir de nuevo
                }
            }
        }
    }

    /**
     * Método que calcula el promedio de las temperaturas ingresadas.
     * Internamente suma las temperaturas de cada objeto ClimaDia y retorna el promedio.
     * Este método abstrae la lógica del cálculo del promedio.
     * @return Promedio semanal de temperatura.
     */
    public double calcularPromedio() {
        double suma = 0;
        for (ClimaDia dia : dias) {
            suma += dia.getTemperatura(); // Obtiene temperatura usando getter (encapsulamiento)
        }
        return suma / dias.size();
    }

    /**
     * Método que muestra el promedio calculado en consola.
     * El usuario no necesita saber cómo se calcula internamente (abstracción).
     */
    public void mostrarPromedio() {
        double promedio = calcularPromedio();
        System.out.printf("El promedio semanal de temperaturas en %s es: %.2f °C%n", ubicacion, promedio);
    }

    /**
     * Método main: punto de entrada del programa.
     * Crea un objeto de ClimaMachala_POO e interactúa con él utilizando sus métodos públicos.
     */
    public static void main(String[] args) {
        // Instanciar la clase para la ciudad Machala
        climaMachala_POO pronosticoMachala = new climaMachala_POO("Machala");
        
        // Registrar temperaturas ingresadas por el usuario
        pronosticoMachala.registrarTemperaturas();
        
        // Mostrar el promedio semanal calculado
        pronosticoMachala.mostrarPromedio();
        
        System.out.println("¡Gracias! Ten un buen día.");
    }
}

