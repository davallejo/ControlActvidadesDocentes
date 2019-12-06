/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones.modulo4;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entidades.Asignaturas;

/**
 *
 * @author GABRIELA
 */
@Stateless
public class AsignaturaDAOImpl implements AsignaturaDAO{
    
    @PersistenceContext(name = "AsignacionesUce-Adminitracion")
    protected EntityManager em;
    
    @Override
    public void crear(Asignaturas asignatura) {
        em.persist(asignatura);
        em.flush();
    }

    @Override
    public List<Asignaturas> listar() {
        return em.createQuery("SELECT d FROM Asignaturas d", Asignaturas.class).getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
