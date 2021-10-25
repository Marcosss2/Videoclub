package com.ceep.videoClub.negocio;

import java.util.*;
import com.ceep.videoClub.datos.*;
import com.ceep.videoClub.excepciones.*;
import com.ceep.videoClub.dominio.Pelicula;


public class CatalogoPeliculasImpl implements IntCatalogoPeliculas{

    private final IntAccesoDatos datos;

    //Constructor
    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }
    
    
    @Override
    public void agregarPelicula(String titulo, String nombreArchivo) {
        try {
            Pelicula newPelicula = new Pelicula(titulo);
            if(datos.Existe(nombreArchivo) == true){
                datos.Escribir(newPelicula, nombreArchivo, true);
            } else {
                System.out.println("El archivo no existe");
            }
            
        } catch (ExcepcionEscrituraEx ex) {
            ex.printStackTrace(System.out);
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listaPeliculas(String nombreArchivo) {
        List<Pelicula> lista;
        //= new ArrayList<Pelicula>();
        try {
            lista = datos.Listar(nombreArchivo);
            //lista = datos.Listar(nombreArchivo);
            lista.forEach(pelicula -> {
                System.out.println("Nombre pelicula: " + pelicula.getNombre());
            });
            
        } catch (ExcepcionLectura e) {
            System.out.println("Error leyendo el catalogo");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        try {
            System.out.println(datos.Buscar(nombreArchivo, buscar));
        } catch (ExcepcionLectura e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarCatalogo(String nombreArchivo) {
        try {
            if(datos.Existe(nombreArchivo) == false){
                datos.Crear(nombreArchivo);
            } else {
                System.out.println("El archivo ya existe");
            }
            
        } catch (AccesoDatosEx e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void borrarCatalogo(String nombreArchivo) {
        datos.Borrar(nombreArchivo);
        System.out.println("Catalogo eliminado con exito");
    }
    
}
