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
import entidades.CabeceraReunion;

/**
 *
 * @author GABRIELA
 */
@Stateless
public class CabeceraReunionDAOImpl implements CabeceraReunionDAO {
    
    @PersistenceContext(name = "AsignacionesUce-Adminitracion")
    protected EntityManager em;

    @Override
    public void crear(CabeceraReunion cabeceraReunion) {
        em.persist(cabeceraReunion);
        em.flush();
    }

    @Override
    public List<CabeceraReunion> listar() {
        return em.createQuery("SELECT d FROM CabeceraReunion d", CabeceraReunion.class).getResultList();//To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
