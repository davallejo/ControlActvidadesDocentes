/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones.modulo4;

import entidades.RolUsuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author VirtualW7
 */
@Stateless
public class RolUsuarioDAOImpl implements RolUsuarioDAO {

    @PersistenceContext(name = "GestionAcademicaPU")
    protected EntityManager em;

    @Override
    public void crear(RolUsuario ru) {
        em.persist(ru);
        em.flush();
    }

    @Override
    public List<RolUsuario> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RolUsuario> listarId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
