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
import entidades.RolUsuario;

/**
 *
 * @author VirtualW7
 */
@Stateless
public class DocenteDAOImpl implements DocenteDAO {

    @PersistenceContext(name = "AsignacionesUce-F-AdminitracionPU")
    protected EntityManager em;

    @Override
    public void crear(RolUsuario docente) {
        em.persist(docente);
        em.flush();
    }

    @Override
    public List<RolUsuario> listar() {
        return em.createQuery("SELECT d FROM RolUsuario d where d.codRol=4", RolUsuario.class).getResultList();
    }

}
