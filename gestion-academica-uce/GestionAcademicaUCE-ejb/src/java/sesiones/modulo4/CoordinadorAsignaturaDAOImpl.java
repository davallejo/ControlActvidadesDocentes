/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones.modulo4;

import entidades.Asignaturas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entidades.CoordinadorAsignatura;
import javax.persistence.NoResultException;

/**
 *
 * @author GABRIELA
 */
@Stateless
public class CoordinadorAsignaturaDAOImpl implements CoordinadorAsignaturaDAO {
    
    @PersistenceContext(name = "AsignacionesUce-F-AdminitracionPU")
    protected EntityManager em;

    @Override
    public void crear(CoordinadorAsignatura coordinadorAsignatura) {
       em.persist(coordinadorAsignatura);
        em.flush();
    }

    @Override
    public List<CoordinadorAsignatura> listar(int c) {
         System.out.println("entro a la consutasssss");
        List<CoordinadorAsignatura> a = null;
        try {
        String sql = "SELECT DISTINCT d  FROM CoordinadorAsignatura d, Asignaturas a, AreaAcademica ac, Periodo p WHERE ac.id =:c and ac.id = a.codArea and a.id = d.codAsignatura AND p.activo = TRUE";
         a = em.createQuery(sql, CoordinadorAsignatura.class).setParameter("c", c).getResultList();
         System.out.println("paso la consutasss");
         } catch (NoResultException nre) {
        return a;
        }
        return a;
    }

    @Override
    public List<CoordinadorAsignatura> listarId() {
         return em.createQuery("SELECT d  FROM CoordinadorAsignatura d where d.codAsignatura=1", CoordinadorAsignatura.class).getResultList();
    }
    
    @Override
    public Asignaturas getAsignatura(String us){
        //String sql = "select ac from CoordinadorArea ca, Usuarios u, AreaAcademica ac, Periodo p where ca.codCoordinador.id =:us and p.id = ca.codPeriodo and u.id = ca.codCoordinador and ac.id = ca.codArea"; //   on c.codPeriodo = p.id
        String sql = "select a from CoordinadorAsignatura ca, Usuarios u, Asignaturas a, Semestre s where ca.codCoordinador.id =:us and u.id = ca.codCoordinador and a.id = ca.codAsignatura and a.codSemestre = s.id"; //   on c.codPeriodo = p.id
        return em.createQuery(sql, Asignaturas.class).setParameter("us", us).getSingleResult();  //para un solo objeto getSingleResult() //ca.codCoordinador esto retorna el objeto // ca.codCoordinador.id retorna el parametro
    }
    
    @Override
    public CoordinadorAsignatura getAsignaturaCoordinador(int c) {
        CoordinadorAsignatura a = null;
        try {
        System.out.println("ssfdfsdfsfdsf llega a la consulta");
        String sql = "SELECT d FROM CoordinadorAsignatura d, Periodo p WHERE d.codAsignatura.id =:c and d.codPeriodo = p.id and p.activo = TRUE"; //   on c.codPeriodo = p.id
        a = em.createQuery(sql, CoordinadorAsignatura.class).setParameter("c", c).getSingleResult();
        } catch (NoResultException nre) {
        return a;
        }
        return a;
    }
    
}
