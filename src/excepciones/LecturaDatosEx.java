package excepciones;

/**
 * Excepción personalizada. Implementación simple sobre el error al querer leer
 * el archivo.
 *
 * @author Angonoa, Franco
 * @since Junio 2020
 * @version 1.0
 */
public class LecturaDatosEx extends AccesoDatosEx {

    public LecturaDatosEx(String mensaje) {
        super(mensaje);
    }
}
