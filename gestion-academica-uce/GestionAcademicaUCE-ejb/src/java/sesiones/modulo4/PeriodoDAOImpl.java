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
import entidades.Periodo;

/**
 *
 * @author VirtualW7
 */
@Stateless
public class PeriodoDAOImpl implements PeriodoDAO {

    @PersistenceContext(name = "AsignacionesUce-Adminitracion")
    protected EntityManager em;

    @Override
    public void crear(Periodo periodo) {
        em.persist(periodo);
        em.flush();
    }

    @Override
    public List<Periodo> listar() {
        return em.createQuery("SELECT d FROM Periodo d WHERE d.activo = TRUE", Periodo.class).getResultList();
    }

}
