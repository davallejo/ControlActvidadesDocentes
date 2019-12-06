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
import entidades.Usuarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import sesiones.modulo3.sessionSilaboLocal;
//import sessionBean.sessionSilabo;
//import sessionBean.sessionSilaboLocal;

/**
 *
 * @author Usuario
 */
@Named(value = "managedBeanSilabo")
@SessionScoped
public class managedBeanSilabo implements Serializable {

    //Entidad Silabo
    private Unidades unidad;
    java.util.Date periodoInicial;
    java.util.Date periodoFinal;
    int nhPresenciales;
    int nhPracticas;
    int nhtVirtual;
    int nhtPresencial;
    String perfilDocente;
    String perfilDocenteProfe;
    String descripcionPerfilDocente;
    String bibliografia;
    String bibliografiaVirtual;
    //boolean=vigente;
    int eval_practica_1h,
            eval_practica_2h,
            eval_autonomo_1h,
            eval_autonomo_2h,
            eval_trabajos_ind_1h,
            eval_trabajos_ind_2h,
            eval_trabajos_grup_1h,
            eval_trabajos_grup_2h,
            eval_trabajos_inte_1h,
            eval_trabajos_inte_2h;
    boolean rev1, rev2, rev3[];
    private Silabos silaboUnidad;
    Date fechaSilabo;
    private Periodo codPeriodo;

    @EJB
    private sessionSilaboLocal sessionSilabo;

    public managedBeanSilabo() {
    }

    public Unidades getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidades unidad) {
        this.unidad = unidad;
    }

    public Silabos getSilaboUnidad() {
        return silaboUnidad;
    }

    public void setSilaboUnidad(Silabos silaboUnidad) {
        this.silaboUnidad = silaboUnidad;
    }

    public Silabos getCodSilaboInicial() {
        return codSilaboInicial;
    }

    public void setCodSilaboInicial(Silabos codSilaboInicial) {
        this.codSilaboInicial = codSilaboInicial;
    }

    public Unidades getCodigoUnidadesInicial() {
        return codigoUnidadesInicial;
    }

    public void setCodigoUnidadesInicial(Unidades codigoUnidadesInicial) {
        this.codigoUnidadesInicial = codigoUnidadesInicial;
    }

    public Date getFechaSilabo() {
        return fechaSilabo;
    }

    public void setFechaSilabo(Date fechaSilabo) {
        this.fechaSilabo = fechaSilabo;
    }

    public Periodo getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Periodo codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public Date getPeriodoInicial() {
        return periodoInicial;
    }

    public void setPeriodoInicial(Date periodoInicial) {
        this.periodoInicial = periodoInicial;
    }

    public Date getPeriodoFinal() {
        return periodoFinal;
    }

    public void setPeriodoFinal(Date periodoFinal) {
        this.periodoFinal = periodoFinal;
    }

    public int getNhPresenciales() {
        return nhPresenciales;
    }

    public void setNhPresenciales(int nhPresenciales) {
        this.nhPresenciales = nhPresenciales;
    }

    public int getNhPracticas() {
        return nhPracticas;
    }

    public void setNhPracticas(int nhPracticas) {
        this.nhPracticas = nhPracticas;
    }

    public int getNhtVirtual() {
        return nhtVirtual;
    }

    public void setNhtVirtual(int nhtVirtual) {
        this.nhtVirtual = nhtVirtual;
    }

    public int getNhtPresencial() {
        return nhtPresencial;
    }

    public void setNhtPresencial(int nhtPresencial) {
        this.nhtPresencial = nhtPresencial;
    }

    public String getPerfilDocente() {
        return perfilDocente;
    }

    public void setPerfilDocente(String perfilDocente) {
        this.perfilDocente = perfilDocente;
    }

    public String getPerfilDocenteProfe() {
        return perfilDocenteProfe;
    }

    public void setPerfilDocenteProfe(String perfilDocenteProfe) {
        this.perfilDocenteProfe = perfilDocenteProfe;
    }

    public String getDescripcionPerfilDocente() {
        return descripcionPerfilDocente;
    }

    public void setDescripcionPerfilDocente(String descripcionPerfilDocente) {
        this.descripcionPerfilDocente = descripcionPerfilDocente;
    }

    public int getEval_practica_1h() {
        return eval_practica_1h;
    }

    public void setEval_practica_1h(int eval_practica_1h) {
        this.eval_practica_1h = eval_practica_1h;
    }

    public int getEval_practica_2h() {
        return eval_practica_2h;
    }

    public void setEval_practica_2h(int eval_practica_2h) {
        this.eval_practica_2h = eval_practica_2h;
    }

    public int getEval_autonomo_1h() {
        return eval_autonomo_1h;
    }

    public void setEval_autonomo_1h(int eval_autonomo_1h) {
        this.eval_autonomo_1h = eval_autonomo_1h;
    }

    public int getEval_autonomo_2h() {
        return eval_autonomo_2h;
    }

    public void setEval_autonomo_2h(int eval_autonomo_2h) {
        this.eval_autonomo_2h = eval_autonomo_2h;
    }

    public int getEval_trabajos_ind_1h() {
        return eval_trabajos_ind_1h;
    }

    public void setEval_trabajos_ind_1h(int eval_trabajos_ind_1h) {
        this.eval_trabajos_ind_1h = eval_trabajos_ind_1h;
    }

    public int getEval_trabajos_ind_2h() {
        return eval_trabajos_ind_2h;
    }

    public void setEval_trabajos_ind_2h(int eval_trabajos_ind_2h) {
        this.eval_trabajos_ind_2h = eval_trabajos_ind_2h;
    }

    public int getEval_trabajos_grup_1h() {
        return eval_trabajos_grup_1h;
    }

    public void setEval_trabajos_grup_1h(int eval_trabajos_grup_1h) {
        this.eval_trabajos_grup_1h = eval_trabajos_grup_1h;
    }

    public int getEval_trabajos_grup_2h() {
        return eval_trabajos_grup_2h;
    }

    public void setEval_trabajos_grup_2h(int eval_trabajos_grup_2h) {
        this.eval_trabajos_grup_2h = eval_trabajos_grup_2h;
    }

    public int getEval_trabajos_inte_1h() {
        return eval_trabajos_inte_1h;
    }

    public void setEval_trabajos_inte_1h(int eval_trabajos_inte_1h) {
        this.eval_trabajos_inte_1h = eval_trabajos_inte_1h;
    }

    public int getEval_trabajos_inte_2h() {
        return eval_trabajos_inte_2h;
    }

    public void setEval_trabajos_inte_2h(int eval_trabajos_inte_2h) {
        this.eval_trabajos_inte_2h = eval_trabajos_inte_2h;
    }

    public boolean isRev1() {
        return rev1;
    }

    public void setRev1(boolean rev1) {
        this.rev1 = rev1;
    }

    public boolean isRev2() {
        return rev2;
    }

    public void setRev2(boolean rev2) {
        this.rev2 = rev2;
    }

    public boolean[] getRev3() {
        return rev3;
    }

    public void setRev3(boolean[] rev3) {
        this.rev3 = rev3;
    }

    public Unidades getUn() {
        return un;
    }

    public void setUn(Unidades un) {
        this.un = un;
    }

    Date fechaSila;

    public Date getFechaSila() {
        return fechaSila;
    }

    public void setFechaSila(Date fechaSila) {
        this.fechaSila = fechaSila;
    }

    Silabos sil;

    public Silabos getSil() {
        return sil;
    }

    public void setSil(Silabos sil) {
        this.sil = sil;
    }
    Asignaturas asig;
    Silabos silaboObjeto;

    Contenidos contenidoObjeto;
    Unidades unidadesObjeto;

    public Silabos getSilaboObjeto() {
        return silaboObjeto;
    }

    public void setSilaboObjeto(Silabos silaboObjeto) {
        this.silaboObjeto = silaboObjeto;
    }

    public Asignaturas getAsig() {
        return asig;
    }

    public void setAsig(Asignaturas asig) {
        this.asig = asig;
    }

    Asignaturas asn;

    public Asignaturas getAsn() {
        return asn;
    }

    public void setAsn(Asignaturas asn) {
        this.asn = asn;
    }

    public Contenidos getContenidoObjeto() {
        return contenidoObjeto;
    }

    public void setContenidoObjeto(Contenidos contenidoObjeto) {
        this.contenidoObjeto = contenidoObjeto;
    }

    public Unidades getUnidadesObjeto() {
        return unidadesObjeto;
    }

    public void setUnidadesObjeto(Unidades unidadesObjeto) {
        this.unidadesObjeto = unidadesObjeto;
    }

    //Silabos Listar
    int nhPresencialesL;
    int nhPracticasL;
    int nhtVirtualL;
    int nhtPresencialL;
    String perfilDocenteL;
    String perfilDocenteProfeL;
    String descripcionPerfilDocenteL;
    String bibliografiaL;
    String bibliografiaVirtualL;
    //boolean=vigente;
    int eval_practica_1hL,
            eval_practica_2hL,
            eval_autonomo_1hL,
            eval_autonomo_2hL,
            eval_trabajos_ind_1hL,
            eval_trabajos_ind_2hL,
            eval_trabajos_grup_1hL,
            eval_trabajos_grup_2hL,
            eval_trabajos_inte_1hL,
            eval_trabajos_inte_2hL;
    Periodo codPeriodoL;
    Asignaturas codAsignaturaL;

    public void listarSilabo() {
        nhPresencialesL = silaboObjeto.getNhPresencial();
        nhPracticasL = silaboObjeto.getNhPracticas();
        nhtVirtualL = silaboObjeto.getNhtVirtual();
        nhtPresencialL = silaboObjeto.getNhtPresencial();
        perfilDocenteL = silaboObjeto.getPerfilDocenteAcadem();
        perfilDocenteProfeL = silaboObjeto.getPerfilDocenteProf();
        descripcionPerfilDocenteL = silaboObjeto.getDescripPerfilDocente();
        eval_practica_1hL = silaboObjeto.getEvalPractica1h();
        eval_practica_2hL = silaboObjeto.getEvalPractica2h();
        eval_autonomo_1hL = silaboObjeto.getEvalAutonomo1h();
        eval_autonomo_2hL = silaboObjeto.getEvalAutonomo2h();
        eval_trabajos_ind_1hL = silaboObjeto.getEvalTrabajosInd1h();
        eval_trabajos_ind_2hL = silaboObjeto.getEvalTrabajosInd2h();
        eval_trabajos_grup_1hL = silaboObjeto.getEvalTrabajosGrup1h();
        eval_trabajos_grup_2hL = silaboObjeto.getEvalTrabajosGrup2h();
        eval_trabajos_inte_1hL = silaboObjeto.getEvalTrabajosIntegrador2h();
        eval_trabajos_inte_2hL = silaboObjeto.getEvalTrabajosIntegrador2h();
        codPeriodoL = silaboObjeto.getCodPeriodo();
        codAsignaturaL = silaboObjeto.getCodAsignatura();
        bibliografiaL=silaboObjeto.getBibliografia();
        bibliografiaVirtualL=silaboObjeto.getBibliografiaVirtual();
    }
    Unidades uni2 = new Unidades();

    public void listarUnidades() {
        uni2 = unidadesObjeto;
    }
    Silabos sil2 = new Silabos();

    public Silabos getSil2() {
        return sil2;
    }

    public void setSil2(Silabos sil2) {
        this.sil2 = sil2;
    }

    public Periodo getCodPeriodoL() {
        return codPeriodoL;
    }

    public void setCodPeriodoL(Periodo codPeriodoL) {
        this.codPeriodoL = codPeriodoL;
    }

    public Asignaturas getCodAsignaturaL() {
        return codAsignaturaL;
    }

    public void setCodAsignaturaL(Asignaturas codAsignaturaL) {
        this.codAsignaturaL = codAsignaturaL;
    }

    public Unidades getUni2() {
        return uni2;
    }

    public void setUni2(Unidades uni2) {
        this.uni2 = uni2;
    }

    public void verContenido() {
        System.out.println("metodo ver contenido.......");
        codigoUnidadesInicial = unidadesObjeto;
        System.out.println("Codigo unidaes..." + codigoUnidadesInicial.getId());
    }

    public void vistaSilaboVer() {
        codSilaboInicial = silaboObjeto;

    }

    public void reemplazarSilabo() {
        System.out.println("*************************ANTES DE: " + sil2.getId() + sil2.getNhPracticas() + " " + sil2.getNhPresencial());
        codSilaboInicial = silaboObjeto;
        sil2.setId(silaboObjeto.getId());
        sil2.setNhPresencial(nhPresencialesL);
        sil2.setNhPracticas(nhPracticasL);
        sil2.setNhtPresencial(nhtPresencialL);
        sil2.setNhtVirtual(nhtVirtualL);
        sil2.setPerfilDocenteAcadem(perfilDocenteProfeL);
        sil2.setPerfilDocenteProf(perfilDocenteProfeL);
        sil2.setDescripPerfilDocente(descripcionPerfilDocenteL);
        //
        sil2.setVigente(silaboObjeto.getVigente());
        sil2.setObservaciones(silaboObjeto.getObservaciones());
        sil2.setRevisionCa(silaboObjeto.getRevisionCa());
        sil2.setRevisionDc(silaboObjeto.getRevisionDc());
        sil2.setAprobado(silaboObjeto.getAprobado());
        Date fecha = new Date();
        fechaSila = fecha;
        sil2.setFechaElaboracion(fechaSila);
        sil2.setFechaRevision(silaboObjeto.getFechaRevision());
        sil2.setFechaAprobacion(silaboObjeto.getFechaAprobacion());
        sil2.setCodEvaluacion(silaboObjeto.getCodEvaluacion());
        sil2.setRevisionDocentes(silaboObjeto.getRevisionDocentes());
        //

        sil2.setEvalAutonomo1h(eval_autonomo_1hL);
        sil2.setEvalAutonomo2h(eval_autonomo_2hL);
        sil2.setEvalPractica1h(eval_practica_1hL);
        sil2.setEvalPractica2h(eval_practica_2hL);
        sil2.setEvalTrabajosGrup1h(eval_trabajos_grup_1hL);
        sil2.setEvalTrabajosGrup2h(eval_trabajos_grup_2hL);
        sil2.setEvalTrabajosInd1h(eval_trabajos_ind_1hL);
        sil2.setEvalTrabajosInd2h(eval_trabajos_ind_2hL);
        sil2.setEvalTrabajosIntegrador1h(eval_trabajos_inte_1hL);
        sil2.setEvalTrabajosIntegrador2h(eval_trabajos_inte_2hL);
        sil2.setCodPeriodo(codPeriodoL);
        sil2.setCodAsignatura(codAsignaturaL);
        //sil2.setCodPeriodo(codPeriodo);
        sil2.setBibliografia(bibliografiaL);
        sil2.setBibliografiaVirtual(bibliografiaVirtualL);
        System.out.println("Persistir" + sil2);
        sessionSilabo.modificarSilabos(sil2);
        System.out.println("Persistir2" + silaboObjeto);
        System.out.println("*************************DESPUES DE: " + sil2.getId() + sil2.getNhPracticas() + " " + sil2.getNhPresencial());

    }

    public void reemplazarUnidades() {
        sessionSilabo.modificarUnidades(unidadesObjeto);
        
    }
    Unidades unidadesObjetoNuevo;
    //unidades
    String nombreUnNuevo, objetivoUnNuevo, resultadosAprenUnNuevo, metAprUnNuevo, reDiUnNuevo;
    int nhApTeUnNuevo, nhApLabUnNuevo, nhTutPresUnNuevo, nhTutVirtUnNuevo, nhTrabAutUnNuevo, numeralUnNuevo;

    public void nuevaUnidadesEdicion() {
        unidadesObjetoNuevo = new Unidades();
        System.out.println("Codigo Silabo..." + silaboObjeto.getId());
        //unidadesObjeto.getCodSilabo()
        unidadesObjetoNuevo.setCodSilabo(silaboObjeto);
        //unidadesObjetoNuevo.setCodSilabo(sil);
        unidadesObjetoNuevo.setNumeral(numeralUnNuevo);
        unidadesObjetoNuevo.setNombre(nombreUnNuevo);
        unidadesObjetoNuevo.setObjetivo(objetivoUnNuevo);
        unidadesObjetoNuevo.setResAprendizaje(resultadosAprenUnNuevo);
        unidadesObjetoNuevo.setMetodologiaAprendizaje(metAprUnNuevo);
        unidadesObjetoNuevo.setRecursosDidactivos(reDiUnNuevo);
        unidadesObjetoNuevo.setNhAprendizajeTeorico(nhApTeUnNuevo);
        unidadesObjetoNuevo.setNhPracticasLab(nhApLabUnNuevo);
        unidadesObjetoNuevo.setNhTutoriaPresencial(nhTutPresUnNuevo);
        unidadesObjetoNuevo.setNhTutoriasVirtual(nhTutVirtUnNuevo);
        unidadesObjetoNuevo.setNhTrabajoAutonomo(nhTrabAutUnNuevo);

        //sessionSilabo.modificarUnidades(unidadesObjetoNuevo);
        sessionSilabo.insertarUnidades(unidadesObjetoNuevo);
        System.out.println("Nueva Unidad Agregada");
        System.out.println("Nueva Unidad Agregada........" + unidadesObjetoNuevo.getId());
        unidadesObjeto = new Unidades();
        unidadesObjeto.setId(unidadesObjetoNuevo.getId());
        limpiarPaginaRegistroContenidoRedireccion();
    }

    public void limpiarPaginaRegistroContenidoRedireccion() {
        numeralUnNuevo = 0;
        nombreUnNuevo = "";
        objetivoUnNuevo = "";
        resultadosAprenUnNuevo = "";
        metAprUnNuevo = "";
        reDiUnNuevo = "";
        nhApTeUnNuevo = 0;
        nhApLabUnNuevo = 0;
        nhTutPresUnNuevo = 0;
        nhTutVirtUnNuevo = 0;
        nhTrabAutUnNuevo = 0;

    }

    public Unidades getUnidadesObjetoNuevo() {
        return unidadesObjetoNuevo;
    }

    public void setUnidadesObjetoNuevo(Unidades unidadesObjetoNuevo) {
        this.unidadesObjetoNuevo = unidadesObjetoNuevo;
    }

    public int getNhPresencialesL() {
        return nhPresencialesL;
    }

    public void setNhPresencialesL(int nhPresencialesL) {
        this.nhPresencialesL = nhPresencialesL;
    }

    public int getNhPracticasL() {
        return nhPracticasL;
    }

    public void setNhPracticasL(int nhPracticasL) {
        this.nhPracticasL = nhPracticasL;
    }

    public int getNhtVirtualL() {
        return nhtVirtualL;
    }

    public void setNhtVirtualL(int nhtVirtualL) {
        this.nhtVirtualL = nhtVirtualL;
    }

    public int getNhtPresencialL() {
        return nhtPresencialL;
    }

    public void setNhtPresencialL(int nhtPresencialL) {
        this.nhtPresencialL = nhtPresencialL;
    }

    public String getPerfilDocenteL() {
        return perfilDocenteL;
    }

    public void setPerfilDocenteL(String perfilDocenteL) {
        this.perfilDocenteL = perfilDocenteL;
    }

    public String getPerfilDocenteProfeL() {
        return perfilDocenteProfeL;
    }

    public void setPerfilDocenteProfeL(String perfilDocenteProfeL) {
        this.perfilDocenteProfeL = perfilDocenteProfeL;
    }

    public String getDescripcionPerfilDocenteL() {
        return descripcionPerfilDocenteL;
    }

    public void setDescripcionPerfilDocenteL(String descripcionPerfilDocenteL) {
        this.descripcionPerfilDocenteL = descripcionPerfilDocenteL;
    }

    public int getEval_practica_1hL() {
        return eval_practica_1hL;
    }

    public void setEval_practica_1hL(int eval_practica_1hL) {
        this.eval_practica_1hL = eval_practica_1hL;
    }

    public int getEval_practica_2hL() {
        return eval_practica_2hL;
    }

    public void setEval_practica_2hL(int eval_practica_2hL) {
        this.eval_practica_2hL = eval_practica_2hL;
    }

    public int getEval_autonomo_1hL() {
        return eval_autonomo_1hL;
    }

    public void setEval_autonomo_1hL(int eval_autonomo_1hL) {
        this.eval_autonomo_1hL = eval_autonomo_1hL;
    }

    public int getEval_autonomo_2hL() {
        return eval_autonomo_2hL;
    }

    public void setEval_autonomo_2hL(int eval_autonomo_2hL) {
        this.eval_autonomo_2hL = eval_autonomo_2hL;
    }

    public int getEval_trabajos_ind_1hL() {
        return eval_trabajos_ind_1hL;
    }

    public void setEval_trabajos_ind_1hL(int eval_trabajos_ind_1hL) {
        this.eval_trabajos_ind_1hL = eval_trabajos_ind_1hL;
    }

    public int getEval_trabajos_ind_2hL() {
        return eval_trabajos_ind_2hL;
    }

    public void setEval_trabajos_ind_2hL(int eval_trabajos_ind_2hL) {
        this.eval_trabajos_ind_2hL = eval_trabajos_ind_2hL;
    }

    public int getEval_trabajos_grup_1hL() {
        return eval_trabajos_grup_1hL;
    }

    public void setEval_trabajos_grup_1hL(int eval_trabajos_grup_1hL) {
        this.eval_trabajos_grup_1hL = eval_trabajos_grup_1hL;
    }

    public int getEval_trabajos_grup_2hL() {
        return eval_trabajos_grup_2hL;
    }

    public void setEval_trabajos_grup_2hL(int eval_trabajos_grup_2hL) {
        this.eval_trabajos_grup_2hL = eval_trabajos_grup_2hL;
    }

    public int getEval_trabajos_inte_1hL() {
        return eval_trabajos_inte_1hL;
    }

    public void setEval_trabajos_inte_1hL(int eval_trabajos_inte_1hL) {
        this.eval_trabajos_inte_1hL = eval_trabajos_inte_1hL;
    }

    public int getEval_trabajos_inte_2hL() {
        return eval_trabajos_inte_2hL;
    }

    public void setEval_trabajos_inte_2hL(int eval_trabajos_inte_2hL) {
        this.eval_trabajos_inte_2hL = eval_trabajos_inte_2hL;
    }

    public void guardar() {
        sil = new Silabos();
        //  asn=new Asignaturas();
        //        sil.setPeriodoInicial(periodoInicial);
        //        sil.setPeriodoFinal(periodoFinal);
        sil.setNhPresencial(nhtPresencial);
        sil.setNhPracticas(nhPracticas);
        sil.setNhtPresencial(nhtPresencial);
        sil.setNhtVirtual(nhtVirtual);
        sil.setPerfilDocenteAcadem(perfilDocenteProfe);
        sil.setPerfilDocenteProf(perfilDocenteProfe);
        sil.setDescripPerfilDocente(descripcionPerfilDocente);
        sil.setEvalAutonomo1h(eval_autonomo_1h);
        sil.setEvalAutonomo2h(eval_autonomo_2h);
        sil.setEvalPractica1h(eval_practica_1h);
        sil.setEvalPractica2h(eval_practica_2h);
        sil.setEvalTrabajosGrup1h(eval_trabajos_grup_1h);
        sil.setEvalTrabajosGrup2h(eval_trabajos_grup_2h);
        sil.setEvalTrabajosInd1h(eval_trabajos_ind_1h);
        sil.setEvalTrabajosInd2h(eval_trabajos_ind_2h);
        sil.setEvalTrabajosIntegrador1h(eval_trabajos_inte_1h);
        sil.setEvalTrabajosIntegrador2h(eval_trabajos_inte_2h);
        sil.setRevisionCa(false);
        sil.setRevisionDc(false);
        //sil.setRevisionDocentes(false);
        sil.setCodPeriodo(codPeriodo);
        Date fecha = new Date();
        fechaSila = fecha;
        sil.setFechaElaboracion(fechaSila);
        sil.setCodAsignatura(asig);
        sil.setBibliografia(bibliografia);
        sil.setBibliografiaVirtual(bibliografiaVirtual);
        System.out.println("Persistir" + sil);
        sessionSilabo.insertarSilabos(sil);
        System.out.println("Persistir2" + sil);
        //return "/index.xhtml";
        nuevaUnidad();
        otroSilabo();

    }

    public void otroSilabo() {
        //sil=null;
        asig = null;
        perfilDocente = null;
        nhtPresencial = 0;
        nhPracticas = 0;
        nhtPresencial = 0;
        nhtVirtual = 0;
        perfilDocenteProfe = null;
        perfilDocenteProfe = null;
        descripcionPerfilDocente = null;
        eval_autonomo_1h = 0;
        eval_autonomo_2h = 0;
        eval_practica_1h = 0;
        eval_practica_2h = 0;
        eval_trabajos_grup_1h = 0;
        eval_trabajos_grup_2h = 0;
        eval_trabajos_ind_1h = 0;
        eval_trabajos_ind_2h = 0;
        eval_trabajos_inte_1h = 0;
        eval_trabajos_inte_2h = 0;
        sil.setRevisionCa(false);
        sil.setRevisionDc(false);
        //sil.setRevisionDocentes(false);
        codPeriodo = null;
        Date fecha = new Date();
        fechaSila = fecha;
        sil.setFechaElaboracion(fechaSila);
        sil.setCodAsignatura(asig);
        System.out.println("Persistir" + sil);
        //sessionSilabo.insertarSilabos(sil);
        System.out.println("Persistir2" + sil);
        //return "/index.xhtml";

    }

    String nombre, codigo;
    int creditos;
    String ucurricular,
            tipoAsignatura,
            descripcion;
    String oGeneral,
            oEspecifico,
            contribucion,
            resultados;
    AreaAcademica codArea;
    Carreras codCarrera;
    Semestre codCurso;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getUcurricular() {
        return ucurricular;
    }

    public void setUcurricular(String ucurricular) {
        this.ucurricular = ucurricular;
    }

    public String getTipoAsignatura() {
        return tipoAsignatura;
    }

    public void setTipoAsignatura(String tipoAsignatura) {
        this.tipoAsignatura = tipoAsignatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getoGeneral() {
        return oGeneral;
    }

    public void setoGeneral(String oGeneral) {
        this.oGeneral = oGeneral;
    }

    public String getoEspecifico() {
        return oEspecifico;
    }

    public void setoEspecifico(String oEspecifico) {
        this.oEspecifico = oEspecifico;
    }

    public String getContribucion() {
        return contribucion;
    }

    public void setContribucion(String contribucion) {
        this.contribucion = contribucion;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public AreaAcademica getCodArea() {
        return codArea;
    }

    public void setCodArea(AreaAcademica codArea) {
        this.codArea = codArea;
    }

    public Carreras getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(Carreras codCarrera) {
        this.codCarrera = codCarrera;
    }

    public Semestre getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Semestre codCurso) {
        this.codCurso = codCurso;
    }

    public List<Periodo> getListaPeriodo() {
        return listaPeriodo;
    }

    public void setListaPeriodo(List<Periodo> listaPeriodo) {
        this.listaPeriodo = listaPeriodo;
    }

    private List<Asignaturas> pro;
    private List<Carreras> carreraL;
    private List<Facultades> facultadesL;
    private List<AreaAcademica> areaAcLt;
    private List<Semestre> cursoLt;
    private List<Periodo> listaPeriodo;
    private List<Silabos> silaboLista;
    private List<Contenidos> listaContenidos;
    private List<Unidades> listaUnidades;
    private List<Contenidos> listaContenidosEdicion;

    Silabos codSilaboInicial;
    Unidades codigoUnidadesInicial;

    public List<Contenidos> getListaContenidosEdicion() {
        return listaContenidosEdicion;
    }

    public void setListaContenidosEdicion(List<Contenidos> listaContenidosEdicion) {
        this.listaContenidosEdicion = listaContenidosEdicion;
    }

    public List<Unidades> getListaUnidades() {
        return listaUnidades;
    }

    public void setListaUnidades(List<Unidades> listaUnidades) {
        this.listaUnidades = listaUnidades;
    }

    public List<Contenidos> getListaContenidos() {
        return listaContenidos;
    }

    public void setListaContenidos(List<Contenidos> listaContenidos) {
        this.listaContenidos = listaContenidos;
    }

    public List<Silabos> getSilaboLista() {
        return silaboLista;
    }

    public void setSilaboLista(List<Silabos> silaboLista) {
        this.silaboLista = silaboLista;
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

    //unidades
    String nombreUn, objetivoUn, resultadosAprenUn, metAprUn, reDiUn;
    int nhApTeUn, nhApLabUn, nhTutPresUn, nhTutVirtUn, nhTrabAutUn, numeralUn;

    public String getNombreUn() {
        return nombreUn;
    }

    public void setNombreUn(String nombreUn) {
        this.nombreUn = nombreUn;
    }

    public String getObjetivoUn() {
        return objetivoUn;
    }

    public void setObjetivoUn(String objetivoUn) {
        this.objetivoUn = objetivoUn;
    }

    public String getResultadosAprenUn() {
        return resultadosAprenUn;
    }

    public void setResultadosAprenUn(String resultadosAprenUn) {
        this.resultadosAprenUn = resultadosAprenUn;
    }

    public String getMetAprUn() {
        return metAprUn;
    }

    public void setMetAprUn(String metAprUn) {
        this.metAprUn = metAprUn;
    }

    public String getReDiUn() {
        return reDiUn;
    }

    public void setReDiUn(String reDiUn) {
        this.reDiUn = reDiUn;
    }

    public int getNhApTeUn() {
        return nhApTeUn;
    }

    public void setNhApTeUn(int nhApTeUn) {
        this.nhApTeUn = nhApTeUn;
    }

    public int getNhApLabUn() {
        return nhApLabUn;
    }

    public void setNhApLabUn(int nhApLabUn) {
        this.nhApLabUn = nhApLabUn;
    }

    public int getNhTutPresUn() {
        return nhTutPresUn;
    }

    public void setNhTutPresUn(int nhTutPres) {
        this.nhTutPresUn = nhTutPres;
    }

    public int getNhTutVirtUn() {
        return nhTutVirtUn;
    }

    public void setNhTutVirtUn(int nhTutVirt) {
        this.nhTutVirtUn = nhTutVirt;
    }

    public int getNhTrabAutUn() {
        return nhTrabAutUn;
    }

    public void setNhTrabAutUn(int nhTrabAut) {
        this.nhTrabAutUn = nhTrabAut;
    }

    public int getNumeralUn() {
        return numeralUn;
    }

    public void setNumeralUn(int numeralUn) {
        this.numeralUn = numeralUn;
    }

    Unidades un;

    public void guardarUnidad() {

        un = new Unidades();
        un.setCodSilabo(sil);
        un.setNumeral(numeralUn);
        un.setNombre(nombreUn);
        un.setObjetivo(objetivoUn);
        un.setResAprendizaje(resultadosAprenUn);
        un.setMetodologiaAprendizaje(metAprUn);
        un.setRecursosDidactivos(reDiUn);
        un.setNhAprendizajeTeorico(nhApTeUn);
        un.setNhPracticasLab(nhApLabUn);
        un.setNhTutoriaPresencial(nhTutPresUn);
        un.setNhTutoriasVirtual(nhTutVirtUn);
        un.setNhTrabajoAutonomo(nhTrabAutUn);
        //sessionSilabo.insertarSilabos(sil);
        System.out.println("Unidaaaaad...." + un);
        sessionSilabo.insertarUnidades(un);

        System.out.println("Unidaaaaad...." + un);
        System.out.println("SilaboUnidad..." + sil);
        System.out.println("+++++++++++++uNias+++++" + un.getNombre());

        /*unidad=new Unidades();
        unidad.setCodSilabo(sil);
        unidad.setNumeral(1);
        System.out.println("Unidad.."+unidad);
        
        System.out.println("Unidad Persistida.."+unidad);*/
        nuevaUnidad();
    }

    public void inicializarNumerales() {
        contNItem = 1;
    }

    public void nuevaUnidad() {
        numeralUn = 1;
        nombreUn = "";
        objetivoUn = "";
        resultadosAprenUn = "";
        metAprUn = "";
        reDiUn = "";
        nhApTeUn = 0;
        nhApLabUn = 0;
        nhTutPresUn = 0;
        nhTutVirtUn = 0;
        nhTrabAutUn = 0;

    }

    public void otraUnidad() {
        numeralUn = numeralUn + 1;
        nombreUn = "";
        objetivoUn = "";
        resultadosAprenUn = "";
        metAprUn = "";
        reDiUn = "";
        nhApTeUn = 0;
        nhApLabUn = 0;
        nhTutPresUn = 0;
        nhTutVirtUn = 0;
        nhTrabAutUn = 0;

    }
    //contenido
    Contenidos cont;
    String contNomDesc, contActividades, contMecEv;
    int contNItem;

    public Contenidos getCont() {
        return cont;
    }

    public void setCont(Contenidos cont) {
        this.cont = cont;
    }

    public String getContNomDesc() {
        return contNomDesc;
    }

    public void setContNomDesc(String contNomDesc) {
        this.contNomDesc = contNomDesc;
    }

    public String getContActividades() {
        return contActividades;
    }

    public void setContActividades(String contActividades) {
        this.contActividades = contActividades;
    }

    public String getContMecEv() {
        return contMecEv;
    }

    public void setContMecEv(String contMecEv) {
        this.contMecEv = contMecEv;
    }

    public int getContNItem() {
        return contNItem;
    }

    public void setContNItem(int contNItem) {
        this.contNItem = contNItem;
    }

    public void guardarContenidos() {
        cont = new Contenidos();
        cont.setNItem(contNItem);
        cont.setDescripcion(contNomDesc);
        cont.setActividades(contActividades);
        cont.setMecanismosEval(contMecEv);
        cont.setCodUnidad(un);
        System.err.println("Contenido...ANTES" + cont);
        sessionSilabo.insertarContenidos(cont);
        System.err.println("Contenido...LUEGO" + cont);
        System.err.println("ContenidoUnidad...UNIDAD" + un);

    }

    public void otroContenido() {
        contNItem = contNItem + 1;

        contNomDesc = "";
        contActividades = "";
        contActividades = "";
        contMecEv = "";
    }

    public void nuevoContenido() {
        contNItem = 0;

        contNomDesc = "";
        contActividades = "";
        contActividades = "";
        contMecEv = "";
    }
    //listaUnidades=new ArrayList<>();

    @PostConstruct
    public void listarAsignaturas() {

        pro = new ArrayList<>();
        pro = sessionSilabo.listarAsignatura();
        carreraL = new ArrayList<>();
        carreraL = sessionSilabo.listarCarreras();
        facultadesL = new ArrayList<>();
        facultadesL = sessionSilabo.listarFacultaders();

        areaAcLt = new ArrayList<>();
        areaAcLt = sessionSilabo.listarAreaAcademica();

        cursoLt = new ArrayList<>();
        cursoLt = sessionSilabo.listarCursos();

        listaPeriodo = new ArrayList<>();
        listaPeriodo = sessionSilabo.listarPeriodo();


        //System.out.print("Silaboooooo codigo"+codSilaboInicial.getId());
        //listaUnidades();
/*        FacesContext context = FacesContext.getCurrentInstance();
        codSilaboInicial = (Silabos) context.getExternalContext().getSessionMap().get("silabos");

        listaUnidades = new ArrayList<>();
        listaUnidades = sessionSilabo.listarUnidades(codSilaboInicial);
         */    }

    public void listaLasUnidades() {
        System.out.println("Silaboooooo codigo " + codSilaboInicial.getId());
        listaUnidades = new ArrayList<>();
        listaUnidades = sessionSilabo.listarUnidades(codSilaboInicial);
        listarUnidades();
        System.out.println("ListaUnidades ");
        System.out.println("................");
        /*verContenido();
        listaContenidosEdicion=new ArrayList<>();
        listaContenidosEdicion=sessionSilabo.listarContenidos(codigoUnidadesInicial);
        System.out.println("ListaUnidades ........"+codigoUnidadesInicial.getId());
         */
    }

    public void listarLosContenidos() {
        verContenido();
        listaContenidosEdicion = new ArrayList<>();
        listaContenidosEdicion = sessionSilabo.listarContenidos(codigoUnidadesInicial);
        System.out.println("Metodolistar Los contenidos.....");
        System.out.println("ListaUnidades ........" + codigoUnidadesInicial.getId());

    }
    String contNomDescNuevo, contActividadesNuevo, contMecEvNuevo;
    int contNItemNuevo;
    Contenidos contenidoObjetoMostrar;
    Contenidos contenidoObjetoEditar;

    public void guardarContenidoEditado() {
        contenidoObjetoEditar.setCodUnidad(unidad);
    }

    public void guardarContenidoNuevoEdicion() {

        contenidoObjetoEditar = new Contenidos();
        System.out.println("contenido id..." + contenidoObjeto.getId());
        //contenidoObjetoEditar.setId(contenidoObjeto.getId());
        System.out.println("uniddad objeto nuevo..." + codigoUnidadesInicial.getId());
        contenidoObjetoEditar.setCodUnidad(codigoUnidadesInicial);
        contenidoObjetoEditar.setDescripcion(contNomDescNuevo);
        contenidoObjetoEditar.setNItem(contNItemNuevo);
        contenidoObjetoEditar.setActividades(contActividadesNuevo);
        contenidoObjetoEditar.setMecanismosEval(contMecEvNuevo);
        sessionSilabo.insertarContenidos(contenidoObjetoEditar);
        System.out.println("Metodo guardar Contenido Nuevo Edicion...." + contenidoObjetoEditar.getId());
        limpiarPaginaRegistroContenido();
    }
    public void guardarContenidoEditado2() {

        contenidoObjetoEditar = new Contenidos();
        System.out.println("contenido id..." + contenidoObjeto.getId());
        contenidoObjetoEditar.setId(contenidoObjeto.getId());
        System.out.println("uniddad objeto nuevo..." + codigoUnidadesInicial.getId());
        contenidoObjetoEditar.setCodUnidad(codigoUnidadesInicial);
        contenidoObjetoEditar.setDescripcion(contNomDescNuevo);
        contenidoObjetoEditar.setNItem(contNItemNuevo);
        contenidoObjetoEditar.setActividades(contActividadesNuevo);
        contenidoObjetoEditar.setMecanismosEval(contMecEvNuevo);
        sessionSilabo.modificarContenidos(contenidoObjetoEditar);
        System.out.println("Metodo guardar Contenido Nuevo Edicion...." + contenidoObjetoEditar.getId());
        limpiarPaginaRegistroContenido();
    }
    public void limpiarPaginaRegistroContenido() {
        contNomDescNuevo = "";
        contNItemNuevo = 0;
        contActividadesNuevo = "";
        contMecEvNuevo = "";
    }

    public Contenidos getContenidoObjetoEditar() {
        return contenidoObjetoEditar;
    }

    public void setContenidoObjetoEditar(Contenidos contenidoObjetoEditar) {
        this.contenidoObjetoEditar = contenidoObjetoEditar;
    }

    public void verContenidoVer() {
        contenidoObjetoMostrar = contenidoObjeto;
    }
    public void verContenidoEditar() {
        contenidoObjetoMostrar = contenidoObjeto;
        contNomDescNuevo = contenidoObjetoMostrar.getDescripcion();
        contNItemNuevo = contenidoObjetoMostrar.getNItem();
        contActividadesNuevo = contenidoObjetoMostrar.getActividades();
        contMecEvNuevo = contenidoObjetoMostrar.getMecanismosEval();
        
    }
    public Contenidos getContenidoObjetoMostrar() {
        return contenidoObjetoMostrar;
    }

    public void setContenidoObjetoMostrar(Contenidos contenidoObjetoMostrar) {
        this.contenidoObjetoMostrar = contenidoObjetoMostrar;
    }

    public String getContNomDescNuevo() {
        return contNomDescNuevo;
    }

    public void setContNomDescNuevo(String contNomDescNuevo) {
        this.contNomDescNuevo = contNomDescNuevo;
    }

    public String getContActividadesNuevo() {
        return contActividadesNuevo;
    }

    public void setContActividadesNuevo(String contActividadesNuevo) {
        this.contActividadesNuevo = contActividadesNuevo;
    }

    public String getContMecEvNuevo() {
        return contMecEvNuevo;
    }

    public void setContMecEvNuevo(String contMecEvNuevo) {
        this.contMecEvNuevo = contMecEvNuevo;
    }

    public int getContNItemNuevo() {
        return contNItemNuevo;
    }

    public void setContNItemNuevo(int contNItemNuevo) {
        this.contNItemNuevo = contNItemNuevo;
    }

    public String getNombreUnNuevo() {
        return nombreUnNuevo;
    }

    public void setNombreUnNuevo(String nombreUnNuevo) {
        this.nombreUnNuevo = nombreUnNuevo;
    }

    public String getObjetivoUnNuevo() {
        return objetivoUnNuevo;
    }

    public void setObjetivoUnNuevo(String objetivoUnNuevo) {
        this.objetivoUnNuevo = objetivoUnNuevo;
    }

    public String getResultadosAprenUnNuevo() {
        return resultadosAprenUnNuevo;
    }

    public void setResultadosAprenUnNuevo(String resultadosAprenUnNuevo) {
        this.resultadosAprenUnNuevo = resultadosAprenUnNuevo;
    }

    public String getMetAprUnNuevo() {
        return metAprUnNuevo;
    }

    public void setMetAprUnNuevo(String metAprUnNuevo) {
        this.metAprUnNuevo = metAprUnNuevo;
    }

    public String getReDiUnNuevo() {
        return reDiUnNuevo;
    }

    public void setReDiUnNuevo(String reDiUnNuevo) {
        this.reDiUnNuevo = reDiUnNuevo;
    }

    public int getNhApTeUnNuevo() {
        return nhApTeUnNuevo;
    }

    public void setNhApTeUnNuevo(int nhApTeUnNuevo) {
        this.nhApTeUnNuevo = nhApTeUnNuevo;
    }

    public int getNhApLabUnNuevo() {
        return nhApLabUnNuevo;
    }

    public void setNhApLabUnNuevo(int nhApLabUnNuevo) {
        this.nhApLabUnNuevo = nhApLabUnNuevo;
    }

    public int getNhTutPresUnNuevo() {
        return nhTutPresUnNuevo;
    }

    public void setNhTutPresUnNuevo(int nhTutPresUnNuevo) {
        this.nhTutPresUnNuevo = nhTutPresUnNuevo;
    }

    public int getNhTutVirtUnNuevo() {
        return nhTutVirtUnNuevo;
    }

    public void setNhTutVirtUnNuevo(int nhTutVirtUnNuevo) {
        this.nhTutVirtUnNuevo = nhTutVirtUnNuevo;
    }

    public int getNhTrabAutUnNuevo() {
        return nhTrabAutUnNuevo;
    }

    public void setNhTrabAutUnNuevo(int nhTrabAutUnNuevo) {
        this.nhTrabAutUnNuevo = nhTrabAutUnNuevo;
    }

    public int getNumeralUnNuevo() {
        return numeralUnNuevo;
    }

    public void setNumeralUnNuevo(int numeralUnNuevo) {
        this.numeralUnNuevo = numeralUnNuevo;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

    public String getBibliografiaVirtual() {
        return bibliografiaVirtual;
    }

    public void setBibliografiaVirtual(String bibliografiaVirtual) {
        this.bibliografiaVirtual = bibliografiaVirtual;
    }

    public String getBibliografiaL() {
        return bibliografiaL;
    }

    public void setBibliografiaL(String bibliografiaL) {
        this.bibliografiaL = bibliografiaL;
    }

    public String getBibliografiaVirtualL() {
        return bibliografiaVirtualL;
    }

    public void setBibliografiaVirtualL(String bibliografiaVirtualL) {
        this.bibliografiaVirtualL = bibliografiaVirtualL;
    }

}
