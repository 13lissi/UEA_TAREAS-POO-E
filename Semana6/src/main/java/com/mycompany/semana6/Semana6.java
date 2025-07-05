
package com.mycompany.semana6;

/**
 *
 * @author corne
 */
// Clase principal donde se crean objetos e interactúan (INSTANCIACION)
public class Semana6 {
    public static void main(String[] args) {
        // INSTANCIACION de objetos: se crean albumes pop y country
        Albums album1 = new PopAlbum("1989", 2014, "Taylor Swift");
        Albums album2 = new CountryAlbum("Fearless", 2008, "Taylor swift");
        Albums album3 = new PopAlbum("Midnights", 2022, "Taylor Swift");

        // POLIMORFISMO en accion: se llama al mismo metodo pero actua distinto segun el objeto
        album1.showInfo(); // Llama a showInfo() de PopAlbum
        album2.showInfo(); // Llama a showInfo() de CountryAlbum
        album3.showInfo(); // Llama a showInfo() de PopAlbum
    }
}

