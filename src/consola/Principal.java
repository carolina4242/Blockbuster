package consola;


import datos.*;
import negocio.*;
import dominio.*;
import excepciones.*;


/**
 * Clase Principal. Contiene el menú que permite al usuario seleccionar la
 * acción a ejecutar sobre el catálogo de películas. Además, se cargarán datos
 * simples como, por ejemplo: los nombres de los archivos a crear o a buscar.
 * Los objetos no serán instanciados en esta clase.
 *
 * @author Angonoa Franco
 * @since Junio 2020
 * @version 1.0
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AccesoDatosEx {
        
        int opciones;

        do {
         
            System.out.println("================================");
            System.out.println("1 - Iniciar catálogo de películas");
            System.out.println("2 - Agregar una película");
            System.out.println("3 - Listar películas");
            System.out.println("4 - Buscar una película");
            System.out.println("5 - Iniciar una tabla en Base de datos");
            System.out.println("6 - Agregar una película en BD");
            System.out.println("7 - Listar películas en BD");
            System.out.println("8 - Buscar una película en BD");
            System.out.println("9 - Salir");
            System.out.println("================================");
            System.out.println("Ingresar opción: ");
            opciones = Consola.readInt();
            CatalogoPeliculas hola = new CatalogoPeliculasImp();
           
            
            switch (opciones) {
                case 1:
                    
                    System.out.println("Por favor, ingrese el nombre del archivo que quiere crear: ");
                    String nombreArchivo = Consola.readLine();
                    hola.inciarArchivo(nombreArchivo, false);
                    break;
                    
                   
                case 2:
                    System.out.println("Ingrese el nombre de la nueva película");
                    String nuevaPeli = Consola.readLine();

                    
                    System.out.println("Ingrese el nombre del archivo al cual desea sumar esta película:");
                    String carpeta = Consola.readLine(); 
                    
                    hola.agregarPelicula(nuevaPeli, carpeta, false);
                    break;
                    
                case 3:
                    System.out.println("Ingrese el nombre de la carpeta para ver el listado de películas: ");
                    String archivo = Consola.readLine();
                    
                    hola.listarPeliculas(archivo, false);
                   
                    break;
               
                case 4:
                    System.out.println("Ingrese una o más letras del título de la película que busca: ");
                    String buscada = Consola.readLine();
                    
                    System.out.println("Ahora ingrese el nombre del archivo donde esta dicha película: ");
                    String car = Consola.readLine();
                    
                    hola.buscarPelicula(car, buscada, false);
                    break;
                    
                case 5:
                    System.out.println("Ingrese el nombre de la nueva tabla:");
                    String tabla = Consola.readLine();
                    hola.inciarArchivo(tabla, true);
                  
                    break;
                
                case 6:
                    System.out.println("Ingrese el nombre de la nueva película:");
                    String otraPeli = Consola.readLine();
                    
                    System.out.println("Ahora ingrese el nombre de la tabla a la cual quiere sumarla:");
                    String otraTabla = Consola.readLine();
                    
                    hola.agregarPelicula(otraPeli, otraTabla, true);
                    
                    break;
                 
                case 7:
                    System.out.println("Ingrese el nombre de la tabla para ver el listado de películas: ");
                    String listado = Consola.readLine();
                    
                    hola.listarPeliculas(listado, true);
                    
                    break;
                    
                case 8:
                    System.out.println("Ingrese una o más letras del titulo de la película que busca:");
                    String yoBusco = Consola.readLine();
                    
                    System.out.println("Ahora ingrese el nombre de la tabla donde se encuentra dicha película:");
                    String enTabla = Consola.readLine();
                    
                    hola.buscarPelicula(enTabla, yoBusco, true);
                    
                    break;
                    
                    
                default: System.out.println("Opcion no válida");
                    break;
                
            }

        } while (opciones != 9);
    } //Fin del metodo menuDeOpciones()
         
 }


