package com.ceep.videoClub.datos;

import com.ceep.videoClub.dominio.Pelicula;
import com.ceep.videoClub.excepciones.*;
import java.io.*;
import java.util.*;

public class AccesoDatosImpl implements IntAccesoDatos{

    @Override
    public boolean Existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);      
        return archivo.exists();
    }

    @Override
    public List<Pelicula> Listar(String nombreArchivo) throws ExcepcionLectura {
        
        File archivo = new File(nombreArchivo);
        List<Pelicula> lista = new ArrayList<Pelicula>();
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            
            var lectura = entrada.readLine();
            while (lectura != null) {
                Pelicula newPelicula = new Pelicula(lectura);
                lista.add(newPelicula);
                lectura = entrada.readLine();
            }
            entrada.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
                throw new ExcepcionLectura("Error de lectura listando las peliculas");
            } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        return lista;
    }

    @Override
    public void Escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws ExcepcionEscrituraEx{
        File archivo = new File(nombreArchivo);
        
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(pelicula.getNombre());
            salida.close();
            System.out.println("Modificado el contenido con exito\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            System.out.println("El archivo no existe");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public String Buscar(String nombreArchivo, String Buscar) {
        File archivo = new File(nombreArchivo);
        String mensaje = "";
        String lectura;
        int linea = 0;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            
            lectura = entrada.readLine();
            while (lectura != null) {
                linea = linea + 1;
                if(lectura.equalsIgnoreCase(Buscar)){
                    mensaje = "Nombre del archivo : " + nombreArchivo + "\n" + "Pelicula : " + lectura + "\n" + "Linea : " + linea;
                    break;
                }
                
                lectura = entrada.readLine();
            }
            
            if(lectura == null) {
                System.out.println("La pelicula no esta en el catalogo");
            }
            
            entrada.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
                System.out.println("Error al leerlo");
            } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("No se ha encontrado el archivo");
        }
        
        return mensaje;
    }

    @Override
    public void Crear(String nombreArchivo) throws ExcepcionEscrituraEx {
        File archivo = new File(nombreArchivo);
        
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado con exito el archivo");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new ExcepcionEscrituraEx("No se ha podido crear el archivo");
        }
    }

    @Override
    public void Borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if(archivo.exists() == true){
            archivo.delete();
            System.out.println("El archivo a sido eliminado");
        } else {
            System.out.println("El archivo que quieres eliminar no existe");
        }
        
    }
    
}
