/**
 * Descripción de la clase: Implementacion del controlador del modelo de arquitectura
 *                          MVC para gestion de ingreso de Silabos
 *
 * @author Diego Navarrete
 * @since 1.0.0
 * @version 1.0.0	02 Dic 2017	Primera version<br>
 *
 *
 */
package controladores.modulo3;

import entidades.AreaAcademica;
import entidades.Asignaturas;
import entidades.Carreras;
import entidades.Contenidos;
import entidades.Facultades;
import entidades.Periodo;
import entidades.Semestre;
import entidades.Silabos;
import entidades.Unidades;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

import sesiones.modulo3.sessionSilaboLocal;
//import sessionBean.sessionSilabo;
//import sessionBean.sessionSilaboLocal;

/**
 *
 * @author Usuario
 */
@Named(value = "managedBeanTablas")
@SessionScoped
public class managedBeanTablas implements Serializable {

    //Entidad Silabo
    @EJB
    private sessionSilaboLocal sessionSilabo;
    private List<Semestre> cursoLt;

    public managedBeanTablas() {
    }
    Semestre semestreBean;
    AreaAcademica areaAcademicaBean;
    Facultades facultadBean;
    Carreras carreraBean;
    Asignaturas asignaturaBean;

    public Asignaturas getAsignaturaBean() {
        return asignaturaBean;
    }

    public void setAsignaturaBean(Asignaturas asignaturaBean) {
        this.asignaturaBean = asignaturaBean;
    }
    //Campos Semestre
    String nombreSemestreTablas;
    //Campos AreaAcademica
    String nombreAreaAcademicaTablas;
    //Campos facultad
    String misionFacultadTablas;
    String nombreFacultadTablas;
    String visionFacultadTablas;
    //Campos carrera
    String nombreCarreraTablas;
    Facultades codFacultadCarreraTablas;
    String misionCarreraTablas;
    String visionCarreraTablas;
    String perfilEgresoCarreraTablas;
    //Campos Asignatura
    String nombreAsignaturaTablas;
    String codigoAsignaturaTablas;
    int creditosAsignaturaTablas;
    String uniCurrAsignaturaTablas;
    String tipoAsignaturaTablas;
    String descripcionAsignaturaTablas;
    String objetivoGeneralAsigTablas;
    String objetivoEspecificoAsigTablas;
    String contribucionFormacionAsigTablas;
    String resultadosAprendizajeAsignaturaTablas;
    AreaAcademica codAreraAsignaturaTablas;
    Carreras codCarreraAsignaturaTablas;
    Semestre codSemestreAsignaturaTablas;

    public String getNombreAsignaturaTablas() {
        return nombreAsignaturaTablas;
    }

    public void setNombreAsignaturaTablas(String nombreAsignaturaTablas) {
        this.nombreAsignaturaTablas = nombreAsignaturaTablas;
    }

    public String getCodigoAsignaturaTablas() {
        return codigoAsignaturaTablas;
    }

    public void setCodigoAsignaturaTablas(String codigoAsignaturaTablas) {
        this.codigoAsignaturaTablas = codigoAsignaturaTablas;
    }

    public int getCreditosAsignaturaTablas() {
        return creditosAsignaturaTablas;
    }

    public void setCreditosAsignaturaTablas(int creditosAsignaturaTablas) {
        this.creditosAsignaturaTablas = creditosAsignaturaTablas;
    }

    public String getUniCurrAsignaturaTablas() {
        return uniCurrAsignaturaTablas;
    }

    public void setUniCurrAsignaturaTablas(String uniCurrAsignaturaTablas) {
        this.uniCurrAsignaturaTablas = uniCurrAsignaturaTablas;
    }

    public String getTipoAsignaturaTablas() {
        return tipoAsignaturaTablas;
    }

    public void setTipoAsignaturaTablas(String tipoAsignaturaTablas) {
        this.tipoAsignaturaTablas = tipoAsignaturaTablas;
    }

    public String getDescripcionAsignaturaTablas() {
        return descripcionAsignaturaTablas;
    }

    public void setDescripcionAsignaturaTablas(String descripcionAsignaturaTablas) {
        this.descripcionAsignaturaTablas = descripcionAsignaturaTablas;
    }

    public String getObjetivoGeneralAsigTablas() {
        return objetivoGeneralAsigTablas;
    }

    public void setObjetivoGeneralAsigTablas(String objetivoGeneralAsigTablas) {
        this.objetivoGeneralAsigTablas = objetivoGeneralAsigTablas;
    }

    public String getObjetivoEspecificoAsigTablas() {
        return objetivoEspecificoAsigTablas;
    }

    public void setObjetivoEspecificoAsigTablas(String objetivoEspecificoAsigTablas) {
        this.objetivoEspecificoAsigTablas = objetivoEspecificoAsigTablas;
    }

    public String getContribucionFormacionAsigTablas() {
        return contribucionFormacionAsigTablas;
    }

    public void setContribucionFormacionAsigTablas(String contribucionFormacionAsigTablas) {
        this.contribucionFormacionAsigTablas = contribucionFormacionAsigTablas;
    }

    public String getResultadosAprendizajeAsignaturaTablas() {
        return resultadosAprendizajeAsignaturaTablas;
    }

    public void setResultadosAprendizajeAsignaturaTablas(String resultadosAprendizajeAsignaturaTablas) {
        this.resultadosAprendizajeAsignaturaTablas = resultadosAprendizajeAsignaturaTablas;
    }

    public AreaAcademica getCodAreraAsignaturaTablas() {
        return codAreraAsignaturaTablas;
    }

    public void setCodAreraAsignaturaTablas(AreaAcademica codAreraAsignaturaTablas) {
        this.codAreraAsignaturaTablas = codAreraAsignaturaTablas;
    }

    public Carreras getCodCarreraAsignaturaTablas() {
        return codCarreraAsignaturaTablas;
    }

    public void setCodCarreraAsignaturaTablas(Carreras codCarreraAsignaturaTablas) {
        this.codCarreraAsignaturaTablas = codCarreraAsignaturaTablas;
    }

    public Semestre getCodSemestreAsignaturaTablas() {
        return codSemestreAsignaturaTablas;
    }

    public void setCodSemestreAsignaturaTablas(Semestre codSemestreAsignaturaTablas) {
        this.codSemestreAsignaturaTablas = codSemestreAsignaturaTablas;
    }

    public Facultades getFacultadBean() {
        return facultadBean;
    }

    public void setFacultadBean(Facultades facultadBean) {
        this.facultadBean = facultadBean;
    }

    public Carreras getCarreraBean() {
        return carreraBean;
    }

    public void setCarreraBean(Carreras carreraBean) {
        this.carreraBean = carreraBean;
    }

    public String getMisionFacultadTablas() {
        return misionFacultadTablas;
    }

    public void setMisionFacultadTablas(String misionFacultadTablas) {
        this.misionFacultadTablas = misionFacultadTablas;
    }

    public String getNombreFacultadTablas() {
        return nombreFacultadTablas;
    }

    public void setNombreFacultadTablas(String nombreFacultadTablas) {
        this.nombreFacultadTablas = nombreFacultadTablas;
    }

    public String getVisionFacultadTablas() {
        return visionFacultadTablas;
    }

    public void setVisionFacultadTablas(String visionFacultadTablas) {
        this.visionFacultadTablas = visionFacultadTablas;
    }

    public String getNombreCarreraTablas() {
        return nombreCarreraTablas;
    }

    public void setNombreCarreraTablas(String nombreCarreraTablas) {
        this.nombreCarreraTablas = nombreCarreraTablas;
    }

    public Facultades getCodFacultadCarreraTablas() {
        return codFacultadCarreraTablas;
    }

    public void setCodFacultadCarreraTablas(Facultades codFacultadCarreraTablas) {
        this.codFacultadCarreraTablas = codFacultadCarreraTablas;
    }

    public String getMisionCarreraTablas() {
        return misionCarreraTablas;
    }

    public void setMisionCarreraTablas(String misionCarreraTablas) {
        this.misionCarreraTablas = misionCarreraTablas;
    }

    public String getVisionCarreraTablas() {
        return visionCarreraTablas;
    }

    public void setVisionCarreraTablas(String visionCarreraTablas) {
        this.visionCarreraTablas = visionCarreraTablas;
    }

    public String getPerfilEgresoCarreraTablas() {
        return perfilEgresoCarreraTablas;
    }

    public void setPerfilEgresoCarreraTablas(String perfilEgresoCarreraTablas) {
        this.perfilEgresoCarreraTablas = perfilEgresoCarreraTablas;
    }

    public Semestre getSemestreBean() {
        return semestreBean;
    }

    public void setSemestreBean(Semestre semestreBean) {
        this.semestreBean = semestreBean;
    }

    public AreaAcademica getAreaAcademicaBean() {
        return areaAcademicaBean;
    }

    public void setAreaAcademicaBean(AreaAcademica areaAcademicaBean) {
        this.areaAcademicaBean = areaAcademicaBean;
    }

    public String getNombreSemestreTablas() {
        return nombreSemestreTablas;
    }

    public void setNombreSemestreTablas(String nombreSemestreTablas) {
        this.nombreSemestreTablas = nombreSemestreTablas;
    }

    public String getNombreAreaAcademicaTablas() {
        return nombreAreaAcademicaTablas;
    }

    public void setNombreAreaAcademicaTablas(String nombreAreaAcademicaTablas) {
        this.nombreAreaAcademicaTablas = nombreAreaAcademicaTablas;
    }

    //metodos de insercion
    public void guardarSemestre() {
        semestreBean = new Semestre();
        semestreBean.setNombre(nombreSemestreTablas);
        sessionSilabo.insertarSemestre(semestreBean);
        nuevoSemestre();
    }

    public void guardarAreaAcademica() {
        areaAcademicaBean = new AreaAcademica();
        areaAcademicaBean.setNombre(nombreAreaAcademicaTablas);
        sessionSilabo.insertarAreaAcademica(areaAcademicaBean);
        nuevaAreaAcademica();
    }

    public void guardarFacultad() {
        facultadBean = new Facultades();
        facultadBean.setNombre(nombreFacultadTablas);
        facultadBean.setMision(misionFacultadTablas);
        facultadBean.setVision(visionFacultadTablas);
        sessionSilabo.registrarFacultad(facultadBean);
        nuevaFacultad();
    }

    public void guardarCarrera() {
        carreraBean = new Carreras();
        carreraBean.setNombre(nombreCarreraTablas);
        carreraBean.setCodFacultad(codFacultadCarreraTablas);
        carreraBean.setMision(misionCarreraTablas);
        carreraBean.setVision(visionCarreraTablas);
        carreraBean.setPerfilEgreso(perfilEgresoCarreraTablas);
        sessionSilabo.insertarCarrera(carreraBean);
        nuevaCarrera();
    }

    public void guardarAsignatura() {
        asignaturaBean = new Asignaturas();
        asignaturaBean.setNombre(nombreAsignaturaTablas);
        asignaturaBean.setCodigo(codigoAsignaturaTablas);
        asignaturaBean.setUnidadCurricular(uniCurrAsignaturaTablas);
        asignaturaBean.setTipoAsignatura(tipoAsignaturaTablas);
        asignaturaBean.setDescripcion(descripcionAsignaturaTablas);
        asignaturaBean.setObjetivoGeneral(objetivoGeneralAsigTablas);
        asignaturaBean.setObjetivosEspecificos(objetivoEspecificoAsigTablas);
        asignaturaBean.setContribucionFormacionProf(contribucionFormacionAsigTablas);
        asignaturaBean.setResultadosAprendizaje(resultadosAprendizajeAsignaturaTablas);
        asignaturaBean.setCodArea(codAreraAsignaturaTablas);
        asignaturaBean.setCodCarrera(codCarreraAsignaturaTablas);
        asignaturaBean.setCodSemestre(codSemestreAsignaturaTablas);
        sessionSilabo.insertarAsignaturas(asignaturaBean);
        nuevaAsignatura();

    }

    public List<Periodo> getListaPeriodo() {
        return listaPeriodo;
    }

    public void setListaPeriodo(List<Periodo> listaPeriodo) {
        this.listaPeriodo = listaPeriodo;
    }

    private List<Facultades> facultadListaTablas;

    private List<Asignaturas> pro;
    private List<Carreras> carreraL;
    private List<Facultades> facultadesL;
    private List<AreaAcademica> areaAcLt;

    private List<Periodo> listaPeriodo;

    @PostConstruct
    public void listasTablas() {
        facultadListaTablas = new ArrayList<>();
        facultadListaTablas = sessionSilabo.listarFacultaders();

        pro = new ArrayList<>();
        pro = sessionSilabo.listarAsignatura();
        carreraL = new ArrayList<>();
        carreraL = sessionSilabo.listarCarreras();

        areaAcLt = new ArrayList<>();
        areaAcLt = sessionSilabo.listarAreaAcademica();

        cursoLt = new ArrayList<>();
        cursoLt = sessionSilabo.listarCursos();

        listaPeriodo = new ArrayList<>();
        listaPeriodo = sessionSilabo.listarPeriodo();
    }

    public List<Facultades> getFacultadListaTablas() {
        return facultadListaTablas;
    }

    public void setFacultadListaTablas(List<Facultades> facultadListaTablas) {
        this.facultadListaTablas = facultadListaTablas;
    }

    public List<Carreras> getCarreraL() {
        return carreraL;
    }

    public void setCarreraL(List<Carreras> carreraL) {
        this.carreraL = carreraL;
    }

    public List<Asignaturas> getPro() {
        return pro;
    }

    public void setPro(List<Asignaturas> pro) {
        this.pro = pro;
    }

    public List<Facultades> getFacultadesL() {
        return facultadesL;
    }

    public void setFacultadesL(List<Facultades> facultadesL) {
        this.facultadesL = facultadesL;
    }

    public List<AreaAcademica> getAreaAcLt() {
        return areaAcLt;
    }

    public void setAreaAcLt(List<AreaAcademica> areaAcLt) {
        this.areaAcLt = areaAcLt;
    }

    public List<Semestre> getCursoLt() {
        return cursoLt;
    }

    public void setCursoLt(List<Semestre> cursoLt) {
        this.cursoLt = cursoLt;
    }

    public void nuevaAreaAcademica() {
        nombreAreaAcademicaTablas = "";
    }

    public void nuevoSemestre() {
        nombreSemestreTablas = "";
    }

    public void nuevaFacultad() {
        nombreFacultadTablas = "";
        misionFacultadTablas = "";
        visionFacultadTablas = "";
    }

    public void nuevaCarrera() {
        nombreCarreraTablas = "";
        codFacultadCarreraTablas = null;
        misionCarreraTablas = "";
        visionCarreraTablas = "";
        perfilEgresoCarreraTablas = "";

    }

    public void nuevaAsignatura() {
        nombreAsignaturaTablas = "";
        codigoAsignaturaTablas = "";
        uniCurrAsignaturaTablas = "";
        tipoAsignaturaTablas = "";
        descripcionAsignaturaTablas = "";
        objetivoGeneralAsigTablas = "";
        objetivoEspecificoAsigTablas = "";
        contribucionFormacionAsigTablas = "";
        resultadosAprendizajeAsignaturaTablas = "";
        codAreraAsignaturaTablas = null;
        codCarreraAsignaturaTablas = null;
        codSemestreAsignaturaTablas = null;

    }
}
