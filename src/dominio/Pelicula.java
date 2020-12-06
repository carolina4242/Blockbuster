package dominio;

/**
 * Clase del dominio de problemas. Se trata de las películas que se almacenaran
 * en el archivo. Su único campo es el nombre de la película.
 *
 * @author Angonoa Franco
 * @since Junio 2020
 * @version 1.0
 */
public class Pelicula {

    private String nombre;

    public Pelicula() {
    }

    public Pelicula(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Pelicula: " + nombre;
    }

}
