package excepciones;

/**
 * Excepción personalizada. Implementación simple sobre el error al querer
 * acceder a un archivo.
 *
 * @author Angonoa, Franco
 * @since Junio 2020
 * @version 1.0
 */
public class AccesoDatosEx extends Exception {

    public AccesoDatosEx(String mensaje) {
        super(mensaje);
    }

}
