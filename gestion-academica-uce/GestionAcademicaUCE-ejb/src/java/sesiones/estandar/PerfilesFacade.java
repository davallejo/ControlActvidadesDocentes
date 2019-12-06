/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones.estandar;

import entidades.Perfiles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author D4N13L
 */
@Stateless
public class PerfilesFacade extends AbstractFacade<Perfiles> {

    @PersistenceContext(unitName = "GestionAcademicaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PerfilesFacade() {
        super(Perfiles.class);
    }
    
}
