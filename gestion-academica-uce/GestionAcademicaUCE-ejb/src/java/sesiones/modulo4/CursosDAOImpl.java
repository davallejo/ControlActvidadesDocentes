/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones.modulo4;

import entidades.Asignaturas;
import entidades.Cursos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author D4N13L
 */
@Stateless
public class CursosDAOImpl implements CursosDAO{
    @PersistenceContext(name = "AsignacionesUce-Adminitracion")
    protected EntityManager em;
   
    @Override
    public List<Cursos> listar(Asignaturas codAsign) {
         String sql ="SELECT c FROM Cursos c join c.codPeriodo p where p.activo = true and c.codAsignatura =:codAsign";
        return em.createQuery(sql, Cursos.class).setParameter("codAsign", codAsign).getResultList();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
