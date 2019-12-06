/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones.modulo1;

import entidades.HorarioActividades;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alex
 */
@Stateless
public class HorarioDaoImpl extends AbstractFacade<HorarioActividades> implements HorarioDao {

    @PersistenceContext(unitName = "GestionAcademicaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HorarioDaoImpl() {
        super(HorarioActividades.class);
    }

    @Override
    public List<HorarioActividades> findAllByPeriodoIdAndUsuariosId(Integer periodoId, String usuarioId) {
        return em.createQuery("SELECT d  FROM HorarioActividades d where d.idPeriodo.id=:idPeriodo and d.idUsuario.id=:usuarioId", HorarioActividades.class)
                .setParameter("idPeriodo", periodoId)
                .setParameter("usuarioId", usuarioId)
                .getResultList();
    }

    @Override
    public void deleteFromUser(String usuarioId) {
        em.createQuery("DELETE FROM HorarioActividades d where d.idUsuario.id=:usuarioId")
                .setParameter("usuarioId", usuarioId)
                .executeUpdate();
    }

}
