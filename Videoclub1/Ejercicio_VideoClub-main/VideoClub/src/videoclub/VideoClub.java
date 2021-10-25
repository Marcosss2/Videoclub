package videoclub;

import com.ceep.videoClub.negocio.*;
import java.util.Scanner;

public class VideoClub {

    public static void main(String[] args) {
        
        System.out.println("----------------------------------\n" + "     BIENVENIDO AL VIDEO CLUB" + "\n----------------------------------");
        System.out.println("\nIntroduzca una opcion entre el 0 y 4");
        System.out.println("\n0. Salir\n" + "1. Crear Archivo\n" + "2. Agregar Peliculas\n" + "3. Listar Peliculas\n" + "4. Buscar pelicula\n" + "5. Eliminar catalogo\n");
        
        
        IntCatalogoPeliculas metodosPeliculas = new CatalogoPeliculasImpl();
        int entradaCaso;
        
        do {
            Scanner entrada = new Scanner(System.in);
            entradaCaso = entrada.nextInt();
            switch(entradaCaso){
           
                case 0 :
                    System.out.println("FIN DEL PROGRAMA");
                   break;

                case 1 :
                    metodosPeliculas.iniciarCatalogo("VideoClub.txt");
                    metodosPeliculas.iniciarCatalogo("CatalogoEliminar.txt");

                    System.out.println("\n¿Que más quieres hacer?");
                   break;

                case 2 :
                    metodosPeliculas.agregarPelicula("Matrix", "VideoClub.txt");
                    metodosPeliculas.agregarPelicula("Spiderman 2", "VideoClub.txt");
                    metodosPeliculas.agregarPelicula("Interstelar", "VideoClub.txt");

                    System.out.println("\n¿Que más quieres hacer?");

                   break;

                case 3:
                    metodosPeliculas.listaPeliculas("VideoClub.txt");

                    System.out.println("\n¿Que más quieres hacer?");

                   break;

                 case 4:
                     metodosPeliculas.buscarPelicula("VideoClub.txt", "Spiderman 2");

                     System.out.println("\n¿Que más quieres hacer?");
                   break;
                   
                 case 5:
                     metodosPeliculas.borrarCatalogo("CatalogoEliminar.txt");

                     System.out.println("\n¿Que más quieres hacer?");
                   break;

                default : 
                        System.out.println("Valor erroneo");
            }
            
        } while (entradaCaso != 0);
        
    }
    
}
