package datos;

import dominio.Pelicula;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.in;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Contiene las operaciones a ejecutar en el archivo de peliculas.txt
 * implementadas con Path y File, además de los Flujos de byte o caracter. Lo
 * ideal es que cada método declare las excepciones creadas en el paquete
 * excepciones.
 *
 * @author Angonoa Franco
 * @since Junio 2020
 * @version 1.0
 */
public class AccesoDatosFile implements AccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {        
        Path path = Paths.get("C:\\Users\\Usuario\\Documents\\Curso Java\\Java intermedio\\Practico voluntario_2\\Practico_voluntario_2\\Catalogo peliculas\\" + nombreArchivo + ".txt");
        return Files.exists(path);
        
    }

    @Override
  
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {       
      
        String listado;
        List<Pelicula> hola = new ArrayList<>();
        String listaFinal = " ";
               
        try { BufferedReader in  = new BufferedReader (new FileReader("C:\\Users\\Usuario\\Documents\\Curso Java\\Java intermedio\\Practico voluntario_2\\Practico_voluntario_2\\Catalogo peliculas\\" + nombreArchivo + ".txt"));
                
            try {
                while ((listado = in.readLine()) != null) {
                    
                    Pelicula peli = new Pelicula();
                    peli.setNombre(listado);
                    hola.add(peli);    
                }
                } catch (IOException ex) {
                System.out.println("Error al leer el archivo." + ex);
                }
                for (Pelicula elem : hola) {
                     listaFinal = listaFinal.concat("\n" + "--> " + elem.getNombre());  
                }
                  
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontró del archivo." +ex);
        }
        
        if (listaFinal != " ") {
        System.out.println("Las películas que se encuentran en el archivo == " + nombreArchivo + " == son: " + listaFinal);
        }
        else System.out.println("Aún no hay películas en este archivo.");
        
        return hola ;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        
        try ( BufferedWriter out
             = new BufferedWriter(new FileWriter("C:\\Users\\Usuario\\Documents\\Curso Java\\Java intermedio\\Practico voluntario_2\\Practico_voluntario_2\\Catalogo peliculas\\" + nombreArchivo + ".txt"))) { 
            
            String cadena = pelicula.getNombre();
            
            out.write(cadena);
            out.newLine();    
  
            System.out.println("Se ha agregado con éxito la película --> " + pelicula.getNombre() + " <-- al archivo --> " + nombreArchivo + " <--");
      
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontró el archivo en método ESCRIBIR." + ex);
        } catch (IOException ex) {
            System.out.println("Error de tipo E/S en método ESCRIBIR." + ex);
    
        } 
    
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        String encontrado = " "; 
        
        try {
          BufferedReader in = new BufferedReader (new FileReader("C:\\Users\\Usuario\\Documents\\Curso Java\\Java intermedio\\Practico voluntario_2\\Practico_voluntario_2\\Catalogo peliculas\\" + nombreArchivo + ".txt"));
          
          String cadena;
            try {
                while ((cadena = in.readLine()) != null) {
                    Pattern pat = Pattern.compile(buscar);
                    Matcher mat = pat.matcher(cadena);
                    if (mat.find()) {
                        encontrado += ("\n--> " + cadena);   
                    }
                } 
            
            } catch (IOException ex) {
                System.out.println("Error de tipo E/S");
            }   
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontró el archivo." + ex);
        } 
        
        finally {
            try {
                in.close();
            } catch (IOException ex) {
                System.out.println("Error en close");
            }
        }
        
        if (encontrado != " ") {
            System.out.println("Las películas que coinciden con su búsqueda son: " + encontrado);   
            }
        else System.out.println("No hay películas que coincidan con su búsqueda. Pruebe con otro nombre para el archivo y/o pelicula");
        
        return encontrado;
       
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
         
         String ruta = "C:\\Users\\Usuario\\Documents\\Curso Java\\Java intermedio\\Practico voluntario_2\\Practico_voluntario_2\\Catalogo peliculas\\" + nombreArchivo + ".txt";

         File archivo = new File(ruta);

             try {
                 archivo.createNewFile();
                 System.out.println("Se ha creado con éxito el archivo --> " + nombreArchivo);
                 
             } catch (IOException ex) {
                 System.out.println("Error en el método CREAR." + ex);
             }
         

    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
          
    }

}
