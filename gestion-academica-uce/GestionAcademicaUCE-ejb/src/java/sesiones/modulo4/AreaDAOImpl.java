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
import entidades.AreaAcademica;

/**
 *
 * @author VirtualW7
 */
@Stateless
public class AreaDAOImpl implements AreaDAO {

    @PersistenceContext(name = "AsignacionesUce-F-AdminitracionPU")
    protected EntityManager em;

    @Override
    public void crear(AreaAcademica area) {
        em.persist(area);
        em.flush();
    }

    @Override
    public List<AreaAcademica> listar() {
        return em.createQuery("SELECT d FROM AreaAcademica d", AreaAcademica.class).getResultList();
    }

}
