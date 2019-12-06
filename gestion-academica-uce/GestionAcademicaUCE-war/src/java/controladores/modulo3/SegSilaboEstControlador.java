/**
 * Descripción de la clase: Implementacion del controlador del modelo de arquitectura
 *                          MVC para gestion del Seguimiento de Silabo para el Estuidante
 *
 * @author Geovanny Larco (D4N13L)
 * @since 1.0.0
 * @version 1.0.0	22 Dic 2017	Primera version<br>
 *
 */
package controladores.modulo3;

import entidades.Contenidos;
import entidades.Cursos;
import entidades.Periodo;
import entidades.SeguimientoSilabo;
import entidades.Silabos;
import entidades.Unidades;
import entidades.Usuarios;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import sesiones.modulo3.SesionSeguimientoSilaboLocal;

@Named("segSilaboEst")
@SessionScoped
public class SegSilaboEstControlador implements Serializable {

    private static final long serialVersionUID = 1L;
    /*Variables A*/
    private int index;
    private int indexSs;
    private String observacionesEstudiante;
    private Boolean confirmacionEstudiante;
    private Date fechaEstudiante;

    /*Variables tipo Entidad*/
    private Usuarios user;
    private SeguimientoSilabo segSilabo;
    private Cursos curso;
    private Silabos silabo;
    private Unidades unidad;
    private Contenidos contenidoSelect;
    private Periodo periodo;

    /*Variables tipo Lista*/
    private List<SeguimientoSilabo> listSegSilabo;
    private List<SeguimientoSilabo> listTemasTratados;
    private List<Cursos> cursosEstudiante;
    private List<Unidades> unidades;
    private List<Contenidos> contenidos;
    private List<Contenidos> temp;

    /*EJB utilizados*/
    @EJB
    private SesionSeguimientoSilaboLocal segSilabos;

    /*Contructores*/
    public SegSilaboEstControlador() {
    }

    /*Getters y Setters variables*/
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndexSs() {
        return indexSs;
    }

    public void setIndexSs(int indexSs) {
        this.indexSs = indexSs;
    }

    public String getObservacionesEstudiante() {
        return observacionesEstudiante;
    }

    public void setObservacionesEstudiante(String observacionesEstudiante) {
        this.observacionesEstudiante = observacionesEstudiante;
    }

    public Boolean getConfirmacionEstudiante() {
        return confirmacionEstudiante;
    }

    public void setConfirmacionEstudiante(Boolean confirmacionEstudiante) {
        this.confirmacionEstudiante = confirmacionEstudiante;
    }

    public Date getFechaEstudiante() {
        return fechaEstudiante;
    }

    public void setFechaEstudiante(Date fechaEstudiante) {
        this.fechaEstudiante = fechaEstudiante;
    }

    /*Getters y Setters Entidades*/
    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }

    public SeguimientoSilabo getSegSilabo() {
        return segSilabo;
    }

    public void setSegSilabo(SeguimientoSilabo segSilabo) {
        this.segSilabo = segSilabo;
    }

    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }

    public Silabos getSilabo() {
        return silabo;
    }

    public void setSilabo(Silabos silabo) {
        this.silabo = silabo;
    }

    public Unidades getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidades unidad) {
        this.unidad = unidad;
    }

    public Contenidos getContenidoSelect() {
        return contenidoSelect;
    }

    public void setContenidoSelect(Contenidos contenidoSelect) {
        this.contenidoSelect = contenidoSelect;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }
    
    /*Getters y Setters Listas*/
    public List<SeguimientoSilabo> getListSegSilabo() {
        return listSegSilabo;
    }
    
    public void setListSegSilabo(List<SeguimientoSilabo> listSegSilabo) {
        this.listSegSilabo = listSegSilabo;
    }

    public List<SeguimientoSilabo> getListTemasTratados() {
        return listTemasTratados;
    }    

    public List<Cursos> getCursosEstudiante() {
        return cursosEstudiante;
    }

    public void setCursosEstudiante(List<Cursos> cursosEstudiante) {
        this.cursosEstudiante = cursosEstudiante;
    }

    public List<Unidades> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidades> unidades) {
        this.unidades = unidades;
    }

    public List<Contenidos> getContenidos() {
        return contenidos;
    }

    public void setContenidos(List<Contenidos> contenidos) {
        this.contenidos = contenidos;
    }

    public List<Contenidos> getTemp() {
        return temp;
    }

    public void setTemp(List<Contenidos> temp) {
        this.temp = temp;
    }

    /*Getters y Setters EJBs*/
    public SesionSeguimientoSilaboLocal getSegSilabos() {
        return segSilabos;
    }

    public void setSegSilabos(SesionSeguimientoSilaboLocal segSilabos) {
        this.segSilabos = segSilabos;
    }

    /* ------------- Metodos USADOS EN JSF ---------------- */
 /* Metodo PostConstructor*/
    @PostConstruct
    public void misCursosEstudiante() {
        FacesContext context = FacesContext.getCurrentInstance();
        user = (Usuarios) context.getExternalContext().getSessionMap().get("usuario");
        System.out.println("us::" + user.getId());
        cursosEstudiante = segSilabos.obtenerCursosEstudiante(user.getId());
        System.out.println("mis curssosos:::" + cursosEstudiante);
    }

    /* Metodo para mostrar el avance del silabo de la materia seleccionada */
    public void motrarSilabo() {
        segSilabo = new SeguimientoSilabo();
        index = cursosEstudiante.indexOf(curso);
        System.out.println("mi indice es:: " + index);
        
        System.out.println("El curso seleccionado es: "+ curso);

        periodo = curso.getCodPeriodo();
        //System.out.println("El periodo es::: "+ periodo);

        if (index != -1) {
            listSegSilabo = segSilabos.listaSilabosEst(curso.getId(), user.getId());
            System.out.println("Mis silabos pendiente" + listSegSilabo.size());
        }
    }

    // Metodo que le permite validar al estudiante el tema dado por el docente
    public void selectSegSilabo(SeguimientoSilabo ss) {
        if (ss != null) {
            segSilabo = new SeguimientoSilabo();
            segSilabo = ss;
            indexSs = listSegSilabo.indexOf(ss); //Ojo 
        }
    }

    // Metodo que le permite validar al estudiante el tema dado por el docente
    public void validarSegSilabo() {
        try {
            System.out.println("segSS 1::" + segSilabo);
            segSilabo.setConfirmacionEstudiante(confirmacionEstudiante);
            segSilabo.setObservacionesEstudiante(observacionesEstudiante);
            Date fecha = new Date();
            fechaEstudiante = fecha;
            segSilabo.setFechaEstudiante(fechaEstudiante);

            segSilabos.modificarSegSilabo(segSilabo); // Update de la tabala Seguimiento Silabo
            System.out.println("segSS 2::" + segSilabo);
            listSegSilabo.remove(indexSs);  //REVISAR
        } catch (Exception e) {
            System.out.println("el error UPd esst:: " + e);
        }

    }
    
    //Metodo que lista los temas tratados y que ya han sido revisados por el estudiante
    public void listarTemas(){
        listTemasTratados = segSilabos.listaSilabosEstConfirm(curso.getId(), user.getId());
    }

}
