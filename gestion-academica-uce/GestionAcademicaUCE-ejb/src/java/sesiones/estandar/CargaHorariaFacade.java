/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones.estandar;

import entidades.CargaHoraria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author D4N13L
 */
@Stateless
public class CargaHorariaFacade extends AbstractFacade<CargaHoraria> {

    @PersistenceContext(unitName = "GestionAcademicaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CargaHorariaFacade() {
        super(CargaHoraria.class);
    }
    
}
