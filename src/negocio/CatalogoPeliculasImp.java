package negocio;

import datos.AccesoDatos;
import datos.AccesoDatosFile;
import dominio.Pelicula;
import datos.AccesoDatosSQL;
import excepciones.AccesoDatosEx;


/**
 * La clase CatalogoPeliculasImpl contiene la implementación de las operaciones.
 * Esta clase sirve como intermediaria entre el menú principal y el acceso a
 * datos.
 *
 * Cada método realiza las mismas funcionalidades que los implementados en
 * AccesoDatos que podemos acceder mediante el campo datos. Además, aquí se
 * crearán los objetos que serán pasado como argumentos y se realizará el manejo
 * de las excepciones.
 *
 * @author Angonoa Franco
 * @since Junio 2020
 * @version 1.0
 */
public class CatalogoPeliculasImp implements CatalogoPeliculas {

    public static AccesoDatos datos;
    public static AccesoDatos base;

    public CatalogoPeliculasImp() {
        datos = new AccesoDatosFile();
        base = new AccesoDatosSQL();
        
    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo, boolean agregar) {
        Pelicula nuevaPeli = new Pelicula(nombrePelicula);
        try {
            if (agregar == false) {
                 if (!datos.existe(nombreArchivo)) {
                 datos.crear(nombreArchivo);    
                }                   
                 datos.escribir(nuevaPeli, nombreArchivo, true);                  
            }
            
            else {
                String nombreTabla = nombreArchivo;
                if (base.existe(nombreTabla) == false) {
                   base.crear(nombreTabla);
                }
                base.escribir(nuevaPeli, nombreTabla, true);                    
                }   
                 
            } catch (AccesoDatosEx ex) {
            System.out.println("Error en el metodo AGREGAR PELICULA" + ex);
        }
          
    }
       

    @Override
    public void listarPeliculas(String nombreArchivo, boolean listar) {
        try {
            if (listar == false) {
                if (datos.existe(nombreArchivo)) {
                datos.listar(nombreArchivo);
                } 
                else System.out.println("El archivo no existe.");  
            }
            
            else {
               String nombreTabla = nombreArchivo;
               if (base.existe(nombreTabla) == true) {
                   base.listar(nombreTabla);
               }
               else {
                   System.out.println("La tabla no existe.");
               }
            }
                       
            } catch (AccesoDatosEx ex) {
            System.out.println("No se encontro archivo/tabla. Error en metodo LISTAR PELICULAS." + ex);;
        }     
        
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar, boolean buscarPeli) {
        try {
            if (buscarPeli == false) {
                if (datos.existe(nombreArchivo)) {
                datos.buscar(nombreArchivo, buscar);
               }
                else System.out.println("No existe dicho archivo.");
            
            }
            
            else {
                String nombreTabla = nombreArchivo;
                if (base.existe(nombreTabla) == true) {
                    base.buscar(nombreTabla, buscar);
                }
                else System.out.println("Dicha tabla no existe.");
                
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error en el método BUSCAR PELICULA." + ex);
        }
    }

    @Override
    public void inciarArchivo(String nombreArchivo, boolean iniciar) {
  
        try {
            if (iniciar == false ) {
                if(datos.existe(nombreArchivo) == false)
                datos.crear(nombreArchivo);
                else System.out.println("Ya existe el archivo --> " + nombreArchivo + ". Por favor, elija otro nombre.");
              
            }
            else {
                String nombreTabla = nombreArchivo;
                if (base.existe(nombreTabla) == false) {
                base.crear(nombreTabla);
                }
                else System.out.println("Ya existe la tabla --> " + nombreTabla + ". Por favor, elija otro nombre.");
                
            }
         } catch (AccesoDatosEx ex) {
            System.out.println("Error de tipo E/S en metodo INICIAR ARCHIVO." + ex);     
         }
       
       
    }

}
