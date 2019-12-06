package seguridad;

import entidades.Roles;
import entidades.Usuarios;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author  Willian Bermeo
 * @version 1.0
 */
@Stateful
public class SesionLogin implements SesionLoginLocal {

    @PersistenceContext(unitName = "GestionAcademicaPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public void metodoPrueba() {
         
         try {
            em.createNamedQuery("Roles.findAll",Roles.class).getResultList();
            System.out.println(":::::::::::::::::::::::::.LOGIN EXITO:::::::::::::::::::::");
            
        } catch (Exception e) {
            System.out.println(":::::::::::::::::::::::::.LOGIN FAIL--------------------:::::::::::::::::::::"+e);
            
        }
    }

    @Override
    public Usuarios loginUsuario(String correo, String pass) {
        try {
            Usuarios u =em.createNamedQuery("Usuarios.findByLogin",Usuarios.class)
                    .setParameter("correoInst", correo)
                    .setParameter("pass", pass)
                    .getSingleResult();
            System.out.println(":::::::::::::::::::::::::.LOGIN EXITO:::::::::::::::::::::");
            
            return u;
        } catch (Exception e) {
            System.out.println("<-----------:::::::::::::::::::::::::.LOGIN FAIL:::::::::::::::::::::------->"+e);
            return null;
        }

    }    
    
}
