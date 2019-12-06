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
import entidades.AsignaturaDocente;

/**
 *
 * @author VirtualW7
 */
@Stateless
public class AsigDocDAOImpl implements AsigDocDAO{
    
     @PersistenceContext(name = "AsignacionesUce-F-AdminitracionPU")
    protected EntityManager em;

    @Override
    public void crear(AsignaturaDocente asigDoc) {
        em.persist(asigDoc);
        em.flush();
    }

    @Override
    public List<AsignaturaDocente> listar() {
        return em.createQuery("SELECT d FROM AsignaturaDocente d WHERE d.codAsignatura=1", AsignaturaDocente.class).getResultList();
        //return em.createQuery("SELECT d FROM AsigDoc d, Docente t, CoordinadorAsignatura cs, Asignatura a, Area r where t.idDocente=cs.idDocente and a.idAsignatura = cs.idAsignatura and r.idArea=a.idArea group by d", AsigDoc.class).getResultList();
      // return em.createQuery("select d.nombre, d.apellido, a.nombre from CoordinadorAsignatura c, Docente d, Asignatura a, Area r where c.idDocente = d.idDocente and a.idAsignatura = c.idAsignatura and r.idArea = a.idArea", AsigDoc.class).getResultList();
    }
    
    
}
