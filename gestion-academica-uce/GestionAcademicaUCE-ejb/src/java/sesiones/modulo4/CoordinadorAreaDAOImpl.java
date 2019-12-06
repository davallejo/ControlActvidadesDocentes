/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones.modulo4;

import entidades.AreaAcademica;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entidades.CoordinadorArea;
import javax.persistence.NoResultException;

/**
 *
 * @author VirtualW7
 */
@Stateless
public class CoordinadorAreaDAOImpl implements CoordinadorAreaDAO {

    @PersistenceContext(name = "GestionAcademicaPU")
    protected EntityManager em;

    @Override
    public void crear(CoordinadorArea ca) {
        em.persist(ca);
        em.flush();
    }
// select d.nombre, d.apellido from CoordinadorArea c, Docente d, Area r where d.idDocente = c.idDocente and r.idArea = c.idArea
    @Override
    public List<CoordinadorArea> listar() {
        return em.createQuery("SELECT d  FROM CoordinadorArea d", CoordinadorArea.class).getResultList();
    }

    @Override
    public List<CoordinadorArea> listarId() {
        return em.createQuery("SELECT d  FROM CoordinadorArea d, Docente t where d.idArea = 5 and d.idDocente=t.idDocente", CoordinadorArea.class).getResultList();
    }
    
    @Override
    public AreaAcademica getArea(String us) { // Esperemos no haya otro error en tu sql
        String sql = "select ac from CoordinadorArea ca, Usuarios u, AreaAcademica ac, Periodo p where ca.codCoordinador.id =:us and p.id = ca.codPeriodo and u.id = ca.codCoordinador and ac.id = ca.codArea"; //   on c.codPeriodo = p.id
        return em.createQuery(sql, AreaAcademica.class).setParameter("us", us).getSingleResult();  //para un solo objeto getSingleResult() //ca.codCoordinador esto retorna el objeto // ca.codCoordinador.id retorna el parametro
    }
    
    @Override
    public CoordinadorArea getAreaCoordinador(int c) {
        CoordinadorArea a = null;
        try {
        System.out.println("ssfdfsdfsfdsf llega a la consulta");
        String sql = "SELECT d FROM CoordinadorArea d, Periodo p WHERE d.codArea.id =:c and d.codPeriodo = p.id and p.activo = TRUE"; //   on c.codPeriodo = p.id
        a = em.createQuery(sql, CoordinadorArea.class).setParameter("c", c).getSingleResult();
        } catch (NoResultException nre) {
        return a;
        }
        return a;
    }


}
