package com.ceep.videoClub.negocio;

public interface IntCatalogoPeliculas {
    
    public void agregarPelicula(String titulo, String nombreArchivo);
    public void listaPeliculas(String nombreArchivo);
    public void buscarPelicula(String nombreArchivo, String buscar);
    public void iniciarCatalogo(String nombreArchivo);
    public void borrarCatalogo(String nombreArchivo);
}
