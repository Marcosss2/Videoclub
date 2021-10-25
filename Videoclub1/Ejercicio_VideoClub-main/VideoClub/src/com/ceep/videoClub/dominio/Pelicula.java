package com.ceep.videoClub.dominio;

public class Pelicula {
    
    private String nombre;

    //Constructores
    public Pelicula() {
    }

    public Pelicula(String nombre) {
        this.nombre = nombre;
    }

    //Getter and Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //ToString
    @Override
    public String toString() {
        return "Pelicula{" + "nombre=" + nombre + '}';
    }
    
}
