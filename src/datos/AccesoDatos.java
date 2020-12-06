package datos;

import dominio.Pelicula;
import excepciones.*;
import java.util.List;

/**
 * Interfaz que representa los métodos a ejecutar para el archivo creado.
 *
 * @author Angonoa Franco
 * @since Junio 2020
 * @version 1.0
 */
public interface AccesoDatos {

    /**
     * Devuelve true o false si existe o no el archivo que recibe como
     * parámetro.
     *
     * @param nombreArchivo
     * @return true si el archivo existe. False en caso contrario.
     * @throws AccesoDatosEx error al querer acceder al archivo.
     */
    public boolean existe(String nombreArchivo) throws AccesoDatosEx;

    /**
     * Devuelve una lista de películas. Está claro que se debe recorrer el
     * archivo (Puede utilizar el BufferReader).
     *
     * @param nombreArchivo
     * @return una lista de las peliculas del videoclub.
     * @throws LecturaDatosEx error al querer acceder y leer el archivo.
     */
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx;

    /**
     * Agrega la película en el archivo txt. Se puede realizar por flujo de
     * carácter.
     *
     * @param pelicula objeto que se agregará al archivo. Tenes en cuenta solo
     * el nombre
     * @param nombreArchivo
     * @param anexar true o false para anexar la pelicula al archivo. Por
     * ejemplo: el constructor de FileWrite posee dos parametros, uno es el
     * archivo y otro un valor booleano para concatenar valores al archivo.
     * @throws EscrituraDatosEx error al intentar escribir en el archivo.
     */
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

    /**
     * Busca una película agregada en el archivo txt.
     *
     * @param nombreArchivo
     * @param buscar nombre de la película que desea buscar.
     * @return nombre de la película, null en el caso que no se encuentre.
     * @throws LecturaDatosEx error al intentar leer el archivo.
     */
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;

    /**
     * Crea un archivo txt con el nombre que recibe como parámetro.
     *
     * @param nombreArchivo nombre del archivo a crear en el dicrectorio
     * catalogoPeliculas
     * @throws AccesoDatosEx error al intentar crear el archivo.
     */
    public void crear(String nombreArchivo) throws AccesoDatosEx;

    /**
     * Borra el archivo txt ingresado por parámetro.
     *
     * @param nombreArchivo nombre del archivo que se desea borrar.
     * @throws AccesoDatosEx error al intentar borrar el archivo.
     */
    public void borrar(String nombreArchivo) throws AccesoDatosEx;
}
