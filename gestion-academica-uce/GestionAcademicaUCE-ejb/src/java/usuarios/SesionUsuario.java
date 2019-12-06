/**
 * Descripción de la clase: Implementacion de la clase de Sesion del servicio en arquitectura
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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SesionUsuario implements SesionUsuarioLocal{
    
    @PersistenceContext(unitName = "GestionAcademicaPU")
    private EntityManager em;
    
    //Lista las notificaciones correspondientes a cada usuario
    @Override
    public List<Notificaciones> listarNotificacionesUsr(String us){
        String sql = "select n from Notificaciones n where n.codUsuarioReceptor =: us";    
        return em.createQuery(sql, Notificaciones.class).setParameter("us", us).getResultList();
        //return null;
    }

    //Lista las notificaciones del usaurio por ESTADO
    @Override
    public List<Notificaciones> listaNotificacionesEst(Boolean est, String us){
        String sql = "select n from Notificaciones n where n.estado =:est and n.codUsuarioReceptor =: us";    
        return em.createQuery(sql, Notificaciones.class).setParameter("est", est).setParameter("us", us).getResultList();
    }

    //Lista las notificaciones del usuario por fecha
    @Override
    public List<Notificaciones> listaNotificacionesFecha(Date fecha, String us){
        String sql = "select n from Notificaciones n where n.fecha =:fecha and n.codUsuarioReceptor =: us";  // REVISAR  
        return em.createQuery(sql, Notificaciones.class).setParameter("fecha", fecha).setParameter("us", us).getResultList();
    }

    //Registra la notificacion generada por un usuario
    @Override
    public void registrarNotificacionUs(Notificaciones notificacion){
        try {
            em.persist(notificacion);
        } catch (Exception e) {
            System.out.println("Erroor:"+ e);
        }
    }

    //Actualzia el estado de la notificacion
    @Override
    public void updateNotificacionUs(Notificaciones notificacion){
        
    }
    
}
