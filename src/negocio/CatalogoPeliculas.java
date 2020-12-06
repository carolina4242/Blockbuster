package negocio;

/**
 * La interfaz CatalogoPeliculas contiene las operaciones necesarias de la
 * aplicación.
 *
 * @author Angonoa Franco
 * @since Junio 2020
 * @version 1.0
 */
public interface CatalogoPeliculas {

    public void agregarPelicula(String nombrePelicula, String nombreArchivo, boolean agregar);

    public void listarPeliculas(String nombreArchivo, boolean listar);

    public void buscarPelicula(String nombreArchivo, String buscar,boolean bucarPeli);

    public void inciarArchivo(String nombreArchivo, boolean iniciar);
}
