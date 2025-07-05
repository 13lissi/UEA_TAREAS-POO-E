
package com.mycompany.semana6;


/**
 *
 * @author corne
 */
// Clase base que representa un album 
// Aqui se define la clase padre para demostrar HERENCIA
public class Albums {
    // ATRIBUTOS PRIVADOS para aplicar ENCAPSULACION 
    private String title;
    private int year;

    // Constructor para inicializar los atributos title y year
    public Albums(String title, int year) {
        this.title = title;
        this.year = year;
    }

    // Metodos GETTERS y SETTERS para acceder y modificar atributos (Encapsulacion)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Metodo que muestra informacion basica del album
    // Sera POLIMORFICO, porque las clases hijas lo SOBRESCRIBEN
    public void showInfo() {
        System.out.println("Album: " + title + " - Year: " + year);
    }
}
