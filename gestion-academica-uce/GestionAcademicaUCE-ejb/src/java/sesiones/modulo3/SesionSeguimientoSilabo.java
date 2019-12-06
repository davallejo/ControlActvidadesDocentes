/**
 * Descripción de la clase: Implementacion de la clase de Sesion del servicio en arquitectura
 *                          EJB para gestion del Seguimiento de Silabo
 *
 * @author Geovanny Larco (D4N13L)
 * @since 1.0.0
 * @version 1.0.0	02 Dic 2017	Primera version<br> *
 *
 */
package sesiones.modulo3;

import entidades.Asignaturas;
import entidades.Cursos;
import entidades.SeguimientoSilabo;
import entidades.Silabos;
import entidades.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SesionSeguimientoSilabo implements SesionSeguimientoSilaboLocal {

    @PersistenceContext(unitName = "GestionAcademicaPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }    
    
    /***** SELECCIONES POR ID ******/
    
    @Override
    public Asignaturas obtenerAsignaturaPorId(int id) {
       Asignaturas asignatura;
         try {
            asignatura = em.createNamedQuery("Asignaturas.findById", Asignaturas.class).setParameter("id", id).getSingleResult();
            System.out.println(":::::::::::::::::::::::::.proyectos exito:::::::::::::::::::::"+asignatura.getNombre());
           return asignatura;

        } catch (Exception e) {
            System.out.println(":::::::::::::::::::::::::.proyectos fail:::::::::::::::::::::");
            return null;
        }
    }
    
    /*Selecciona los cursos disponibles actuales*/
    @Override
    public List<Cursos> obtenerCursosDisponibles(){
        String sql = "select c from Cursos c join c.codPeriodo p where p.activo = true"; // 
        return em.createQuery(sql, Cursos.class).getResultList();
    }

    
    //----- METODOS DOCENTE ----- \\
    /*Selecciona los cursos que el docente logeado imparte en el periodo actual*/
    @Override
    public List<Cursos> obtenerCursosDocente(String us) {
        String sql = "select c from Cursos c join c.codPeriodo p where p.activo = true and c.codDocente.id =:us"; //   on c.codPeriodo = p.id
        return em.createQuery(sql, Cursos.class).setParameter("us", us).getResultList();
    }
    
    /*Obtiene el silabo correspondiente a la asignatura seleccionada*/
    @Override
    public Silabos obtenerSilaboMateria(Asignaturas codAsign) {
        String sql = "select s from Silabos s join s.codPeriodo p where p.activo = true and s.codAsignatura =:codAsign"; // 
        return em.createQuery(sql, Silabos.class).setParameter("codAsign", codAsign).getSingleResult();
    }
    
    /*Lista de temas tratados por docente y materia*/
    @Override
    public List<SeguimientoSilabo> listaContenidosTratados(Usuarios dcnt, Asignaturas asg, Cursos crs) {
        String sql = "select ss from SeguimientoSilabo ss join ss.codPeriodo p where ss.codCurso =:crs and ss.codDocente =:dcnt and ss.codAsignatura =:asg and p.activo = true"; 
        return em.createQuery(sql, SeguimientoSilabo.class).setParameter("crs", crs).setParameter("dcnt", dcnt).setParameter("asg", asg).getResultList();
    }
    
    /*Guarda el tema dado por el docente para el seguimiento de silabo*/
    @Override
    public void registrarSegSilabo(SeguimientoSilabo segSilabo){
        try {
            em.persist(segSilabo);
        } catch (Exception e) {
            System.out.println("Error al guardar segSil:::"+e);
        }
    }
    
    
    // ----- METODOS ESTUDIANTE ----- \\    
    /*Obtiene los cursos que el estudianet esta designado como presidente*/
    @Override
    public List<Cursos> obtenerCursosEstudiante(String us) {
        String sql = "select c from Cursos c join c.codPeriodo p where p.activo = true and c.codEstudiante.id =:us";  // on c.codPeriodo = p.id      
        return em.createQuery(sql, Cursos.class).setParameter("us", us).getResultList();
    }    
    
    /*Lista los items tratados de un silabo por estudiante*/
    @Override
    public List<SeguimientoSilabo> listaSilabosEst(Long c, String est){
        String sql = "select ss from SeguimientoSilabo ss where ss.codCurso.id =:c and ss.codEstudiante.id =:est and ss.confirmacionEstudiante = false"; 
        return em.createQuery(sql, SeguimientoSilabo.class).setParameter("c", c).setParameter("est", est).getResultList();
        //return null;
    }
    
    /*Realiza las modificaciones del siguimiento por parte del estudiante*/
    @Override
    public void modificarSegSilabo(SeguimientoSilabo segSilaboEst){
        try {
            em.merge(segSilaboEst);
        } catch (Exception e) {
            System.out.println("ERROR EST grb cambios:::"+e);
        }        
    }

    /*Lista los temas impartidos de un silabo que ya han sido confirmados por estudiante*/
    @Override
    public List<SeguimientoSilabo> listaSilabosEstConfirm(Long c, String est) {
        String sql = "select ss from SeguimientoSilabo ss where ss.codCurso.id =:c and ss.codEstudiante.id =:est and ss.confirmacionEstudiante = true"; 
        return em.createQuery(sql, SeguimientoSilabo.class).setParameter("c", c).setParameter("est", est).getResultList();
    }
    
    //----- METODOS DIRECTOR(A) ----- \\    
    /*Obtiene la lista de usuarios de rol docente*/
    @Override
    public List<Usuarios> listadoDocentes() {
        String sql = "select u from Usuarios u join u.rolUsuarioList r where r.codRol = 4 and u.estado = true";
        return em.createQuery(sql, Usuarios.class).getResultList();
    }
    
    //----- OTROS METODOS ----- \\    
    /*Obtiene la lista de usuarios de rol Estudiante*/
    @Override
    public List<Usuarios> listadoEstudiantes() {
        String sql = "select u from Usuarios u join u.rolUsuarioList r where r.codRol = 5 and u.estado = true";
        return em.createQuery(sql, Usuarios.class).getResultList();
    }

    /*Actualizar la tabla de cursos*/
    @Override
    public void actualizarCursos(Cursos curso) {
        
         try {
            em.merge(curso);
        } catch (Exception e) {
            System.out.println("*********************NO SE PUDO ACTUALIZAR EL USARIO*******************"+e);
            
        }
    }
}
