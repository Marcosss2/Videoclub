package com.ceep.videoClub.datos;

import com.ceep.videoClub.dominio.Pelicula;
import com.ceep.videoClub.excepciones.*;
import java.util.*;

public interface IntAccesoDatos{
    
    boolean Existe(String nombreArchivo) throws AccesoDatosEx;
    List<Pelicula> Listar(String nombreArchivo) throws ExcepcionLectura;
    void Escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws ExcepcionEscrituraEx;
    String Buscar(String nombreArchivo, String Buscar) throws ExcepcionLectura;
    void Crear(String nombreArchivo) throws AccesoDatosEx;
    void Borrar(String nombreArchivo);
    
}
