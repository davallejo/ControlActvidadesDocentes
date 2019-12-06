/**
 * Descripción de la clase: Implementacion de la Interfaz Local de Sesion del servicio en arquitectura
 *                          EJB para gestion de Notificaciones y otras opciones del Usuario
 *
 * @author Geovanny Larco (D4N13L)
 * @since 1.0.0
 * @version 1.0.0	20 Ene 2018	Primera version<br>
 *
 *
 */
package usuarios;

import entidades.Notificaciones;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SesionUsuarioLocal {

    //Lista las notificaciones correspondientes a cada usuario
    public List<Notificaciones> listarNotificacionesUsr(String us);

    //Lista las notificaciones del usaurio por ESTADO
    public List<Notificaciones> listaNotificacionesEst(Boolean est, String us);

    //Lista las notificaciones del usuario por fecha
    public List<Notificaciones> listaNotificacionesFecha(Date fecha, String us);

    //Registra la notificacion generada por un usuario
    public void registrarNotificacionUs(Notificaciones notificacion);

    //Actualzia el estado de la notificacion
    public void updateNotificacionUs(Notificaciones notificacion);

}
