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
import entidades.DetalleReunionAs;

/**
 *
 * @author GABRIELA
 */
@Stateless
public class DetalleReunionAsDAOImpl implements DetalleReunionAsDAO{
    
    @PersistenceContext(name = "AsignacionesUce-F-AdminitracionPU")
    protected EntityManager em;
    
    @Override
    public void crear(DetalleReunionAs periodo) {
        em.persist(periodo);
        em.flush();
    }

    @Override
    public List<DetalleReunionAs> listar() {
        return em.createQuery("SELECT d FROM DetalleReunionAs d WHERE d.idDetalle = (SELECT MAX(idDetalle) from DetalleReunionAs) ", DetalleReunionAs.class).getResultList();
    }
    
}
