/**
 * Descripción de la clase: Implementacion del controlador del modelo de arquitectura
 *                          MVC para gestion del Seguimiento de Silabo para el Director de Carrera
 *
 * @author Geovanny Larco (D4N13L)
 * @since 1.0.0
 * @version 1.0.0	06 Dic 2017	Primera version<br>
 *
 */
package controladores.modulo3;

import entidades.Asignaturas;
import entidades.Cursos;
import entidades.SeguimientoSilabo;
import entidades.Usuarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import sesiones.modulo3.SesionSeguimientoSilaboLocal;

@Named("segSilaboDirC")
@SessionScoped
public class SegSilaboDirControlador implements Serializable {

    private static final long serialVersionUID = 1L;
    /*Variables A*/
    private int index;

    /*Variables tipo Entidad*/
    private Usuarios user;
    private Cursos curso;
    private Usuarios docente;
    private Asignaturas asignatura;

    /*Variables tipo Lista*/
    private List<Cursos> cursosDisponibles;
    private List<Usuarios> listaDocentes;
    private List<SeguimientoSilabo> ssTratados;

    /*EJB utilizados*/
    @EJB
    private SesionSeguimientoSilaboLocal segSilabos;

    /*Contructores*/
    public SegSilaboDirControlador() {
    }

    /*Getters y Setters variables*/
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    /*Getters y Setters Entidades*/
    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }

    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }

    public Usuarios getDocente() {
        return docente;
    }

    public void setDocente(Usuarios docente) {
        this.docente = docente;
    }

    public Asignaturas getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignaturas asignatura) {
        this.asignatura = asignatura;
    }

    /*Getters y Setters Listas*/
    public List<Cursos> getCursosDisponibles() {
        return cursosDisponibles;
    }

    public void setCursosDisponibles(List<Cursos> cursosDisponibles) {
        this.cursosDisponibles = cursosDisponibles;
    }

    public List<Usuarios> getListaDocentes() {
        return listaDocentes;
    }

    public void setListaDocentes(List<Usuarios> listaDocentes) {
        this.listaDocentes = listaDocentes;
    }

    public List<SeguimientoSilabo> getSsTratados() {
        return ssTratados;
    }

    public void setSsTratados(List<SeguimientoSilabo> ssTratados) {
        this.ssTratados = ssTratados;
    }

    /*Getters y Setters EJBs*/
    public SesionSeguimientoSilaboLocal getSegSilabos() {
        return segSilabos;
    }

    public void setSegSilabos(SesionSeguimientoSilaboLocal segSilabos) {
        this.segSilabos = segSilabos;
    }

    /*Metodos USADOS EN JSF*/
    @PostConstruct
    public void misCursosDocente() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            user = (Usuarios) context.getExternalContext().getSessionMap().get("usuario");
            System.out.println("us::" + user.getId());
            listarDocentes();
            cursosDisponibles =  new ArrayList<>();//null;
            System.out.println("Lista de Cursos:: " + cursosDisponibles.size());
        } catch (Exception e) {
            System.out.println("Errror por lista vacia" + e);
        }

    }

    /*Metodo utilizado para...*/
    //Metodo para obtener la lista de usuario de rol DOCENTE y sus asignaturas
    public void listarDocentes() {
        listaDocentes = segSilabos.listadoDocentes();
        System.out.println("Mi lista de docente :" + listaDocentes.size());
    }

    //Metodo para obtener las asignaturas que dicta un docente
    public void listarCursosDocente() {
        cursosDisponibles = segSilabos.obtenerCursosDocente(docente.getId());
        System.out.println("cursos del docente:: " + cursosDisponibles.size());
    }

    //Metodo para listar los temas que un docente ya a impartido de una materia en base al silabo
    public void listarTemasReg() {
        index = cursosDisponibles.indexOf(curso); //Ojo

        asignatura = cursosDisponibles.get(index).getCodAsignatura(); //Ojo
        System.out.println("DOCENT:: " + docente 
                + " ASIGNATUR:: " + asignatura 
                + "CURSO:: " + curso);

        ssTratados = segSilabos.listaContenidosTratados(docente, asignatura, curso);
        System.out.println("El totoal de temas tratados es:: " + ssTratados.size());
    }
}
