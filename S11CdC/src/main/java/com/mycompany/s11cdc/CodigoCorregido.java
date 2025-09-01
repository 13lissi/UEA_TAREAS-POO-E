
package com.mycompany.s11cdc;

/**
 *
 * @author corne
 */
import java.util.*;

public class CodigoCorregido {

    public static void main(String[] args) {

        // LISTA de nombres
        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Ana");// ArrayList permite duplicados


        // Corrección 1: El índice 3 no existe (lista tiene indices 0,1,2)
        // Se cambia a índice 2 para evitar IndexOutOfBoundsException
        System.out.println("Elemento en posicion 2: " + nombres.get(2));

        // Corrección 2: Para comparar cadenas se usa equals, no ==
        //Más simple y legible.
        //Evita crear un objeto extra en memoria.
        //String buscado = new String("Ana");//(constructor innecesario)
        String buscado = "Ana";
        if ("Ana".equals(buscado)) {
            System.out.println("Encontrado");
        } else {
            System.out.println("No encontrado");
        }

        // MAPA de telefonos
        Map<String, String> telefonos = new HashMap<>();
        telefonos.put("Ana", "0991111111");
        telefonos.put("Luis", "0992222222");
        // Inserción de Ana nuevamente: HashMap permite sobrescribir
        telefonos.put("Ana", "0993333333"); 

        // Corrección 3: Validar si la clave existe antes de usar get()
        // Evitar NullPointerException al consultar claves inexistentes
        //System.out.println("Bea: " + telefonos.getOrDefault("Bea", "No existe registro"));

        if (telefonos.containsKey("Bea")) {
            System.out.println("Bea: " + telefonos.get("Bea"));
        } else {
            System.out.println("No se encontro telefono para Bea");
        }

        // SET de inscritos
        //HashSet no permite duplicados logicos si equals() y hashCode() están bien definidos
        Set<Alumno> inscritos = new HashSet<>();
        inscritos.add(new Alumno(1, "Ana"));
        inscritos.add(new Alumno(2, "Luis"));
        inscritos.add(new Alumno(1, "Ana")); // duplicado logico

        // Corrección 4: Para evitar duplicados logicos, se debe sobrescribir equals y hashCode en Alumno
        System.out.println("Tamaño del Set: " + inscritos.size());
        System.out.println(inscritos);
    }
}




