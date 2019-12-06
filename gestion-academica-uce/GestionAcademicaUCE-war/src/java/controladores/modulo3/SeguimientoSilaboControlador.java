/**
 * Descripción de la clase: Implementacion del controlador del modelo de arquitectura
 *                          MVC para gestion del Seguimiento de Silabo
 *
 * @author Geovanny Larco (D4N13L)
 * @since 1.0.0
 * @version 1.0.0	02 Dic 2017	Primera version<br> 
 *
 */
package controladores.modulo3;

import controladores.util.JsfUtil;
import controladores.util.JsfUtil.PersistAction;
import entidades.Asignaturas;
import entidades.Aula;
import entidades.Contenidos;
import entidades.Cursos;
import entidades.Paralelo;
import entidades.Periodo;
import entidades.SeguimientoSilabo;
import entidades.Silabos;
import entidades.Unidades;
import entidades.Usuarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import sesiones.estandar.AulaFacade;
import sesiones.estandar.CursosFacade;
import sesiones.modulo3.SesionSeguimientoSilaboLocal;

@Named("seguimientoSilabos")
@SessionScoped
public class SeguimientoSilaboControlador implements Serializable {

    private static final long serialVersionUID = 1L;
    /*Datos o atributos requeridos*/
    // Campos necesarios de la tabla seguimiento de silabo a persistir
    //private String codigoEstudiante;
    private int index;
    private int indexCt;
    private String codigoCodente;
    private int codigoAsignatura;
    private int codigoSilabo;
    private int codigoUnidad;
    private int codigoContenido;
    private long codigoCurso;
    private int codigoPeriodo;
    private String observacionesDocente;
    private String estadoContenido;
    private Boolean confirmacionEstudiante;
    private String observacionesEstudiante;
    private Date fechaRegDocente;
    private Date fechaRegEstudiante;
    private Date horaInicio;
    private Date horaFin;

    // Las entidades involucradas
    private Usuarios user;    
    private SeguimientoSilabo segSilabo;
    private Cursos curso;
    private Cursos selected;
    private Aula aula;
    private Periodo periodo;
    private Paralelo paralelo;
    private Asignaturas asignatura;
    private Silabos silabo;
    private Unidades unidad;
    private Contenidos contenidoSelect;
    //private

    // Listas de las entidades involucradas
    private List<Cursos> cursosDocente;
    private List<Usuarios> users;
    private List<Usuarios> docentes;
    private List<Usuarios> estudiantes;
    private List<Asignaturas> asignaturas;
    private List<Silabos> silabos;
    private List<Unidades> unidades;
    private List<Contenidos> contenidos;
    private List<Aula> aulas;
    private List<Periodo> peridos;
    private List<Contenidos> temp;
    private List<SeguimientoSilabo> ssTratados;

    //private 
    @EJB
    private SesionSeguimientoSilaboLocal segSilabos;

    @EJB
    private AulaFacade allAulas;
    
    private sesiones.estandar.CursosFacade ejbFacade;

    /*Metodos GETTER y SETTER*/
    public long getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(long codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public Boolean getConfirmacionEstudiante() {
        return confirmacionEstudiante;
    }

    public void setConfirmacionEstudiante(Boolean confirmacionEstudiante) {
        this.confirmacionEstudiante = confirmacionEstudiante;
    }

    public int getCodigoAsignatura() {
        return codigoAsignatura;
    }

    public void setCodigoAsignatura(int codigoAsignatura) {
        this.codigoAsignatura = codigoAsignatura;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndexCt() {
        return indexCt;
    }

    public void setIndexCt(int indexCt) {
        this.indexCt = indexCt;
    }

    
    
    // Entidades gett
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

    public Cursos getSelected() {
        return selected;
    }

    public void setSelected(Cursos selected) {
        this.selected = selected;
    }
    
    

    public Paralelo getParalelo() {
        return paralelo;
    }

    public void setParalelo(Paralelo paralelo) {
        this.paralelo = paralelo;
    }

    public String getObservacionesDocente() {
        return observacionesDocente;
    }

    public void setObservacionesDocente(String observacionesDocente) {
        this.observacionesDocente = observacionesDocente;
    }

    public String getEstadoContenido() {
        return estadoContenido;
    }

    public void setEstadoContenido(String estadoContenido) {
        this.estadoContenido = estadoContenido;
    }

    public String getObservacionesEstudiante() {
        return observacionesEstudiante;
    }

    public void setObservacionesEstudiante(String observacionesEstudiante) {
        this.observacionesEstudiante = observacionesEstudiante;
    }

    public Date getFechaRegDocente() {
        return fechaRegDocente;
    }

    public void setFechaRegDocente(Date fechaRegDocente) {
        this.fechaRegDocente = fechaRegDocente;
    }

    public Date getFechaRegEstudiante() {
        return fechaRegEstudiante;
    }

    public void setFechaRegEstudiante(Date fechaRegEstudiante) {
        this.fechaRegEstudiante = fechaRegEstudiante;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Asignaturas getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignaturas asignatura) {
        this.asignatura = asignatura;
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

    //// Listas gett
    public List<Contenidos> getTemp() {
        return temp;
    }

    public void setLista(List<Contenidos> temp) {
        this.temp = temp;
    }

    public List<Cursos> getCursosDocente() {
        return cursosDocente;
    }

    public void setCursosDocente(List<Cursos> cursosDocente) {
        this.cursosDocente = cursosDocente;
    }

    public List<Usuarios> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Usuarios> docentes) {
        this.docentes = docentes;
    }

    public List<Usuarios> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Usuarios> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
    

    public List<Aula> getAulas() {
        return aulas;
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

    public List<SeguimientoSilabo> getSsTratados() {
        return ssTratados;
    }

    public void setSsTratados(List<SeguimientoSilabo> ssTratados) {
        this.ssTratados = ssTratados;
    }

    public List<Asignaturas> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignaturas> asignaturas) {
        this.asignaturas = asignaturas;
    }
    
    
    

    // Implementaciones gett
    public SesionSeguimientoSilaboLocal getSegSilabos() {
        return segSilabos;
    }

    public AulaFacade getAllAulas() {
        return allAulas;
    }
    
    private CursosFacade getFacade() {
        return ejbFacade;
    }

    /*Constructor*/
    public SeguimientoSilaboControlador() {
    }

    /*Metodo que carga a la lista los Cursos con asignaturas disponibles del docente*/
    @PostConstruct
    public void misCursosDocente() {
        //try {
        FacesContext context = FacesContext.getCurrentInstance();
        user = (Usuarios) context.getExternalContext().getSessionMap().get("usuario");
        System.out.println("us::" + user.getId());
        cursosDocente = segSilabos.obtenerCursosDocente(user.getId());
        //aulas = allAulas.findAll();
        System.out.println("AULASS::" + aulas);
        //curso = new Cursos();
        System.out.println("xdsdc::" + curso);
        listarEstudiantes();
        listarDocentes();
        //silabo = new Silabos();
        //periodo = new Periodo();
        //segSilabo = new SeguimientoSilabo();
        //segSilabo.setCodDocente(user);
        //contenidoSelect = new Contenidos();
        //unidades = new ArrayList<>();
        //System.out.println("UNIT INIT::" + unidades.size());
        //contenidos = new ArrayList<Contenidos>();

    }

    /* Metodo para mostrar el silabo de la materia seleccionada */
    public void motrarSilabo() {
        silabo = new Silabos();
        //unidades = new ArrayList();
        unidades = new ArrayList<>();
        System.out.println("UNIT INIT::" + unidades.size());

        System.out.println("fdvdfgCCC::" + curso);
        index = cursosDocente.indexOf(curso); //Ojo        
        System.out.println("indice:::" + index);
        //segSilabo.setCodCurso(curso);
        periodo = curso.getCodPeriodo();
        //segSilabo.setCodPeriodo(periodo);
        //System.out.println("IU"+ codigoCurso);        

        if (index != -1) {
            paralelo = cursosDocente.get(index).getCodParalelo();
            System.out.println("pSel::" + paralelo.getNombre());

            asignatura = cursosDocente.get(index).getCodAsignatura();
            System.out.println("asSele::" + asignatura.getNombre());
            //segSilabo.setCodAsignatura(asignatura);

            silabo = segSilabos.obtenerSilaboMateria(asignatura);//asignatura.getCodSilabo();//Comento al cambiar la relacion asignatura silabo
            System.out.println("silSel::" + silabo.getFechaElaboracion() + "IDDD_:" + silabo.getId());
            //segSilabo.setCodSilabo(silabo);

            unidades = silabo.getUnidadesList();//Comento al cambiar la relacion asignatura silabo
            System.out.println("NuUud::" + unidades.size());
            System.out.println("uudd::" + unidades);
            //contenidos= unidades;          

            unidades.forEach((u) -> {
                System.out.println("cUnit::" + u.getNombre());
                System.out.println("CCSD::" + u.getContenidosList());
                //contenidos = unidad.getContenidosList();            
            });

            listarContenido();

            //ESTADO DE LA VARIABLE SEGSILABO
            //segSilabo.setCodEstudiante(curso.getCodEstudiante());

            //DateFormat hi = new SimpleDateFormat("HH:mm");
            //hi.            
            //System.out.println("Silabo Seleccionado:: " + segSilabo);
        }
    }
    
    public void prueba(){
        
    }

    /* Metodo para mostrar los contenidos del silabo seleccionado */
    private void listarContenido() {
        try {
//            unidades.forEach((unidad) -> {
            //System.out.println("CONT  INIT" + contenidos.size());
            contenidos = new ArrayList<Contenidos>();
            System.out.println("CONT  INIT:DESS" + contenidos.size());
            unidades = new ArrayList<Unidades>(new HashSet<Unidades>(unidades));
            System.out.println("MIS UNit:" + unidades + " IXD " + unidades.indexOf(this));

            contenidos = unidades.get(0).getContenidosList();
            System.out.println("CNNT add:::" + contenidos);
//                //System.out.println("sUnit::"+unidad.getNombre());
//                //List<Contenidos> temp = new ArrayList<Contenidos>();
            //System.out.println("uuu:" + unidades.size());
            for (int i = 1; i < unidades.size(); i++) {

                System.out.println("ITEMMM:: " + i);
                //System.out.println("tempANT "+temp.size());

                temp = unidades.get(i).getContenidosList();
                System.out.println("tempDESp " + temp.size());

                System.out.println("lst::" + temp);
                //Collections.copy(contenidos, temp);
                //contenidos = temp;
                contenidos.addAll(temp);
                System.out.println("CNNT add:::" + contenidos);
                temp = new ArrayList<Contenidos>();
                //System.out.println("tempNwww "+temp.size());

            }                  
            
            contenidos = new ArrayList<Contenidos>(new HashSet<Contenidos>(contenidos)); ///Ojo

            // ----- Obtener y comparar los temas tratados para no repetir (verificar estado actividad )-------
            ssTratados = segSilabos.listaContenidosTratados(user, asignatura, curso);
            
            ssTratados.forEach((ss) -> {
                System.out.println("sTemsTT::" + ss.getCodContenido().getDescripcion());
                //contenidos = unidad.getContenidosList();            
            });
            
//            });
            contenidos.forEach((contenido) -> {
                System.out.println("sCont::" + contenido.getDescripcion());
                //contenidos = unidad.getContenidosList();            
            });
            
            
            for (int i = 0; i < contenidos.size(); i++) {            
                for (int j = 0; j< ssTratados.size(); j++){
                    if(Objects.equals(contenidos.get(i).getId(), ssTratados.get(j).getCodContenido().getId())){
                        System.out.println("CntREP: "+contenidos.get(i).getDescripcion());
                        contenidos.remove(i);
                    }
                }
            }
            
            contenidos.forEach((contenido) -> {
                System.out.println("sContAA::" + contenido.getDescripcion());
                //contenidos = unidad.getContenidosList();            
            });
            
            // -------------- //
            
        } catch (Exception e) {
            System.out.println("El error es::" + e);
        }

    }

    /* Metodo para guardar el contenido dado para el seguimiento de silabo */
    public void registrarTema(Contenidos cont) {

        //segSilabo.setCodUnidad(contenidoSelect.getCodUnidad());//
        if (cont != null) {
            segSilabo = new SeguimientoSilabo();
            
            System.out.println("my contPER:: " + cont);
            
            indexCt = contenidos.indexOf(cont); //Ojo 
            System.out.println("esx:::: "+ indexCt);

            segSilabo.setCodAula(aula);

            //Obtener la fecha actualdel sistema
            Date fecha = new Date();
            fechaRegDocente = fecha;
            segSilabo.setFechaDocente(fechaRegDocente);
            //segSilabo.setCodPeriodo(periodo);
            segSilabo.setCodUnidad(cont.getCodUnidad());//
            segSilabo.setCodContenido(cont);

            System.out.println("Estad Contenido a persistir...." + segSilabo);
        }
    }

    /* Metodo para persistir el seguimiento de silabo */
    public void guardSilabo() {
        try {
            
        segSilabo.setCodDocente(user);
        
        segSilabo.setCodCurso(curso);
        segSilabo.setCodPeriodo(periodo);
        
        segSilabo.setCodAsignatura(asignatura);
            segSilabo.setCodSilabo(silabo);
            
            segSilabo.setCodEstudiante(curso.getCodEstudiante());
            
            
        
            segSilabo.setHoraInicio(horaInicio);
            segSilabo.setHoraFin(horaFin);
            segSilabo.setEstadoContenido(estadoContenido);
            segSilabo.setConfirmacionEstudiante(false);
            segSilabo.setObservacionDocente(observacionesDocente);
            System.out.println("Estad Contenido a persistir 22...." + segSilabo);
            segSilabos.registrarSegSilabo(segSilabo);
            System.out.println("Estad Contenido a persistir 33...." + segSilabo);
            contenidos.remove(indexCt);  //REVISAR
        } catch (Exception e) {
            System.out.println("error de guardado:: " + e);
        }

    }
    
    //Metodo que obtiene la lista de los temas que el docente registro
    public void listarTemasReg(){
        
        index = cursosDocente.indexOf(curso); //Ojo
        
        asignatura = cursosDocente.get(index).getCodAsignatura(); //Ojo
        
        ssTratados = segSilabos.listaContenidosTratados(user, asignatura, curso);
    }
    
    //Metodo para obtener la lista de docentes
    public void listarDocentes() {
        docentes = segSilabos.listadoDocentes();
        System.out.println("Mi lista de docente :" + docentes.size());
    }
    
    //Metodo para obtener la lista de estudiantes
    public void listarEstudiantes() {
        estudiantes = segSilabos.listadoEstudiantes();
        System.out.println("Mi lista de Estudiantes :" + estudiantes.size());
    }
    
    //Metodos para gestionar cursos (Docente), asignacion de estudiante
    protected void setEmbeddableKeys() {
    }
    
    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CursosUpdated"));
    }
    
    private void persist(JsfUtil.PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            
            try {
                if (persistAction != JsfUtil.PersistAction.DELETE) {
                    segSilabos.actualizarCursos(selected);
                    //getFacade().edit(selected);
                } else {
                    //getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

}
