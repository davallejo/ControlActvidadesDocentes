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
import entidades.DetalleReunion;

/**
 *
 * @author GABRIELA
 */
@Stateless
public class DetalleReunionDAOImpl implements DetalleReunionDAO{
    
    @PersistenceContext(name = "AsignacionesUce-F-AdminitracionPU")
    protected EntityManager em;
    
    @Override
    public void crear(DetalleReunion periodo) {
        em.persist(periodo);
        em.flush();
    }

    @Override
    public List<DetalleReunion> listar() {
        return em.createQuery("SELECT d FROM DetalleReunion d WHERE d.idDetalle = (SELECT MAX(idDetalle) from DetalleReunion) ", DetalleReunion.class).getResultList();
    }
    
}
