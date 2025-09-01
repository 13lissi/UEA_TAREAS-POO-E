
package com.mycompany.s11cdc;

import java.util.Objects;

/**
 *
 * @author corne
 */
class Alumno {
    private int id;       // Identificador unico del alumno
    private String nombre; // Nombre del alumno

    public Alumno(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Sobrescribir equals() para definir duplicados logicos
    // Dos alumnos son iguales si tienen el mismo id y nombre
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Alumno)) return false;
        Alumno other = (Alumno) obj;
        return this.id == other.id && Objects.equals(this.nombre, other.nombre);
    }

    // Sobrescribir hashCode() para que coincida con equals
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    // Sobrescribir toString() para mostrar el objeto de forma legible
    @Override
    public String toString() {
        return "Alumno{id=" + id + ", nombre='" + nombre + "'}";
    }
}

