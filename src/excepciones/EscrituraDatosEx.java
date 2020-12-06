package excepciones;

/**
 * Excepción personalizada. Implementación simple sobre el error al querer
 * escribir sobre un archivo.
 *
 * @author Angonoa, Franco
 * @since Junio 2020
 * @version 1.0
 */
public class EscrituraDatosEx extends AccesoDatosEx {

    public EscrituraDatosEx(String mensaje) {
        super(mensaje);
    }

}
