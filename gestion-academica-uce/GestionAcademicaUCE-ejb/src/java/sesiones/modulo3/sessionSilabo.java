/**
 * Descripción de la clase: Implementacion de la clase de Sesion del servicio en arquitectura
 *                          EJB para gestion de Ingreso de Silabos
 *
 * @author Diego Navarrete
 * @since 1.0.0
 * @version 1.0.0	02 Dic 2017	Primera version<br>
 *
 *
 */
package sesiones.modulo3;

import entidades.AreaAcademica;
import entidades.Asignaturas;
import entidades.Carreras;
import entidades.Contenidos;
import entidades.Cursos;
import entidades.Facultades;
import entidades.Periodo;
import entidades.Semestre;
import entidades.Silabos;
import entidades.Unidades;
import entidades.Usuarios;
import java.awt.geom.Area;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//@Stateful
@Stateless
public class sessionSilabo implements sessionSilaboLocal {

    private List<Asignaturas> listAsignaturas;
    private List<Carreras> listCarreras;
    private List<Facultades> listFacultades;
    private List<AreaAcademica> listAreaAc;
    private List<Semestre> listCurso;
    private List<Periodo> listPeriodo;
    private List<Silabos> listSilabo;
    private List<Unidades> listUnidades;
    private List<Contenidos> listContenidos;

    @PersistenceContext(unitName = "GestionAcademicaPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public boolean insertarSilabos(Silabos silabo) {
        try {
            em.persist(silabo);
            return true;
        } catch (Exception e) {
            System.out.print(e);

        }
        return false;
    }
//, Area area, Carreras carrera, Cursos curso

    @Override
    public void insertarAsignaturas(Asignaturas asignatura) {
        try {
            //em.persist(silabo);
            em.persist(asignatura);

        } catch (Exception e) {
            System.out.print(e);

        }

    }

    /*
    @Override
    public List<Asignaturas> listarAsignaturas() {
        
        try {

            listAsignaturas = em.createNamedQuery("Asignaturas.findByIN", Asignaturas.class).getResultList();
            return listAsignaturas;
        } catch (Exception e) {
            System.out.print(e);
           
        }
 return false;
        
    }
     */
    /**
     *
     * @return
     */
    @Override
    public List<Asignaturas> listarAsignatura() {
        listAsignaturas = em.createNamedQuery("Asignaturas.findAll", Asignaturas.class).getResultList();
        return listAsignaturas;

    }

    @Override
    public List<Silabos> listarSilaboAsignatura(int us, int cp) {
        String sql = "select c.id from Silabos c where c.codAsignatura =:us and c.codPeriodo:=cp"; //   on c.codPeriodo = p.id
        return em.createQuery(sql, Silabos.class).setParameter("us", us).setParameter("cp", cp).getResultList();
    }

    @Override
    public List<Carreras> listarCarreras() {
        listCarreras = em.createNamedQuery("Carreras.findAll", Carreras.class).getResultList();
        return listCarreras;
    }

    @Override
    public List<Facultades> listarFacultaders() {
        listFacultades = em.createNamedQuery("Facultades.findAll", Facultades.class).getResultList();
        return listFacultades;
    }

    @Override
    public List<AreaAcademica> listarAreaAcademica() {
        listAreaAc = em.createNamedQuery("AreaAcademica.findAll", AreaAcademica.class).getResultList();
        return listAreaAc;
    }

    @Override
    public List<Semestre> listarCursos() {
        listCurso = em.createNamedQuery("Semestre.findAll", Semestre.class).getResultList();
        return listCurso;
    }

    @Override
    public List<Periodo> listarPeriodo() {
        listPeriodo = em.createNamedQuery("Periodo.findAll", Periodo.class).getResultList();
        return listPeriodo;

    }

    @Override
    public List<Silabos> listarSilabo() {
        listSilabo = em.createNamedQuery("Silabos.findAll", Silabos.class).getResultList();
        return listSilabo;

    }

    @Override
    public List<Unidades> listarUnidades(Silabos cod) {
        String sql="SELECT u FROM Unidades u WHERE u.codSilabo = :cod";
        listUnidades = em.createQuery(sql, Unidades.class).setParameter("cod",cod).getResultList();
        return listUnidades;
    
    }

    @Override
    public List<Contenidos> listarContenidos(Unidades cod) {
        String sql="SELECT c FROM Contenidos c WHERE c.codUnidad = :cod";
        listContenidos = em.createQuery(sql, Contenidos.class).setParameter("cod",cod).getResultList();
        return listContenidos;
    }

    @Override
    public void insertarUnidades(Unidades unidades) {
        try {
            //em.persist(silabo);
            em.persist(unidades);

        } catch (Exception e) {
            System.out.print(e);

        }
    }

    @Override
    public void insertarContenidos(Contenidos contenido) {
        try {
            em.persist(contenido);
        } catch (Exception e) {
            System.out.print(e);

        }
    }

    @Override
    public void escogerAsignaturaSilabo(Asignaturas usuario, Asignaturas usmodificado) {
        try {
            Asignaturas u;
            u = em.createNamedQuery("Usuarios.findById", Asignaturas.class).setParameter("id", usuario).getSingleResult();
            // u.setCodSilabo(usmodificado.getCodSilabo());
            em.merge(u);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    Asignaturas confi1 = null;

    @Override
    public void ModificarAsignatura(Asignaturas asignatura) {

        confi1 = em.createNamedQuery("Asignaturas.findById", Asignaturas.class).setParameter("id", asignatura.getId()).getSingleResult();
//        confi1.setCodSilabo(asignatura.getCodSilabo());
        em.merge(confi1);
    }

    @Override
    public void modificarSilabos(Silabos silabo) {

        try {
            //sil = em.createNamedQuery("Silabos.findById", Silabos.class).setParameter("id", silabo.getId()).getSingleResult();
            System.out.println("*********Silabos encontrado=------" + silabo);
            //silabo=silabo;
            em.merge(silabo);

        } catch (Exception e) {
            System.out.println("ERROR EST grb cambios:::" + e);
        }
        /*sil = em.createNamedQuery("Silabos.findById", Silabos.class).setParameter("id", silabo.getId()).getSingleResult();
        System.out.println("*********Silabos encontrado=------" + sil);
//        confi1.setCodSilabo(asignatura.getCodSilabo());
        sil.setNhPresencial(silabo.getNhtPresencial());
        sil.setNhPracticas(silabo.getNhPracticas());
        sil.setNhtPresencial(silabo.getNhtPresencial());
        sil.setNhtVirtual(silabo.getNhtVirtual());
        sil.setPerfilDocenteAcadem(silabo.getPerfilDocenteAcadem());
        sil.setPerfilDocenteProf(silabo.getPerfilDocenteProf());
        sil.setDescripPerfilDocente(silabo.getDescripPerfilDocente());
        sil.setEvalAutonomo1h(silabo.getEvalAutonomo1h());
        sil.setEvalAutonomo2h(silabo.getEvalAutonomo1h());
        sil.setEvalPractica1h(silabo.getEvalPractica1h());
        sil.setEvalPractica2h(silabo.getEvalPractica2h());
        sil.setEvalTrabajosGrup1h(silabo.getEvalTrabajosGrup1h());
        sil.setEvalTrabajosGrup2h(silabo.getEvalTrabajosGrup2h());
        sil.setEvalTrabajosInd1h(silabo.getEvalTrabajosInd1h());
        sil.setEvalTrabajosInd2h(silabo.getEvalTrabajosInd2h());
        sil.setEvalTrabajosIntegrador1h(silabo.getEvalTrabajosIntegrador1h());
        sil.setEvalTrabajosIntegrador2h(silabo.getEvalTrabajosIntegrador2h());
        
         */
        //em.getTransaction().commit();
        //System.out.println("Silabo NUevo-----" + sil);
        //em.merge(confi1);

    }

    @Override
    public void modificarUnidades(Unidades unidad) {

        try {
            System.out.println("*********Silabos encontrado=------" + unidad);
            em.merge(unidad);

        } catch (Exception e) {
            System.out.println("ERROR EST grb cambios:::" + e);
        }
    }

    @Override
    public void modificarContenidos(Contenidos contenido) {

        try {
            System.out.println("*********Silabos encontrado=------" + contenido);
            em.merge(contenido);

        } catch (Exception e) {
            System.out.println("ERROR EST grb cambios:::" + e);
        }
    }

    @Override
    public void insertarSemestre(Semestre semestre) {
        try {

            em.persist(semestre);

        } catch (Exception e) {
            System.out.print(e);

        }

    }

    @Override
    public void insertarAreaAcademica(AreaAcademica areaAcademica) {
        try {
            em.persist(areaAcademica);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    @Override
    public void registrarFacultad(Facultades facultad) {
        try {

            em.persist(facultad);

        } catch (Exception e) {
            System.out.print(e);

        }
    }

    @Override
    public void borrarSilabos(Silabos silabo) {
        try {
            Silabos sila;
            sila = em.createNamedQuery("Silabos.findById", Silabos.class).setParameter("id", silabo.getId()).getSingleResult();
            em.remove(sila);

        } catch (Exception e) {
            System.out.print(e);

        }
    }

    @Override
    public void insertarCarrera(Carreras carrera) {
        try {

            em.persist(carrera);

        } catch (Exception e) {
            System.out.print(e);

        }
    }

    @Override
    public void insetarAsignatua(Asignaturas asignatura) {
        try {

            em.persist(asignatura);

        } catch (Exception e) {
            System.out.print(e);

        }
    }

}
