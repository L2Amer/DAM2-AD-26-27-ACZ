package ud1.ejerciciosPracticos;

import java.io.Serializable;

public class Persona implements Serializable{
    private String nombre;
    private int edad;

    
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad;
    }

    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }

    

}
