/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.modulo2;



import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import controladores.clases.HorarioPos;
import controladores.clases.Transformar;
import controladores.clases.Validaciones;
import controladores.seguridad.Login;
import entidades.AsignaturaDocente;
import entidades.Aula;
import entidades.CargaHoraria;
import entidades.Cursos;
import entidades.DetalleCh;
import entidades.Horario;
import entidades.HorarioActividades;
import entidades.Periodo;
import entidades.Proyectos;
import entidades.Semestre;
import entidades.TipoCh;
import entidades.Usuarios;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import sesiones.modulo2.SesionProfesorLocal;


import org.primefaces.component.export.PDFOptions;


/**
 *
 * @author a
 */
@Named(value = "cargarDatos")
@SessionScoped
public class CargarDatos implements Serializable {

    
    /**
     * Creates a new instance of controlador1
     *
     * @param event
     * @throws java.io.FileNotFoundException
     *
     */
    public void handleFileUpload(FileUploadEvent event) throws FileNotFoundException, IOException {

        Date now=new Date();
        filename = event.getFile().getFileName();
        filename=Double.toString(Math.random()*1000 + 1) + now.getDay()+now.getSeconds()+filename;
        try (OutputStream out = new FileOutputStream(new File("C:/to/"+filename))) {
            int reader = 0;
            byte[] bytes = new byte[(int) event.getFile().getSize()];
            try (InputStream in = (InputStream) event.getFile().getInputstream()) {
                while ((reader = in.read(bytes)) != -1) {
                    out.write(bytes, 0, reader);
                }
            }
            out.flush();
        }
         this.guardarInvestigacion(2);
       

    }

    @EJB
    private SesionProfesorLocal sesionprofesorlocal;

   
    Login login1;
    private List<Semestre> cursos;
    private List<String> cursosNombres;
    private List<Integer> cursosCodigos;
    private List<String> asignaturas;
    private List<String> aulas;
    private Date fecha;
    private Date hora1;
    private Date hora2;
    private String aula;
    private String curso;
    private String tema;
    private Usuarios usuario;
    private String ci_estudiante;
    private String ci_docente;
    private String materia;
    private String tutor;
    private File evidencia;
    private String actividades;
    private List<Proyectos> pro;
    private List<String> nombrepro;
    private CargaHoraria cargahoraria;
    private final Validaciones validar;
    private List<Proyectos> proyectos;
    private List<String> nombres_proyectos;
    private String observacion;
    private double avance_real;
    private double avance_estimado;
    private String filename;
    List<String> args;
    private boolean combo_tipos_p;
    private String tipo_usuario;
    private String tipo_docente;
    private Usuarios usuario_nuevo;
    private Date fecha_a_buscar;
    private String cargaConsultar;
    private List<String> carga_nombres;
    private List<TipoCh> tiposCh;
    private List<CargaHoraria> cargasRecuperadas;
    private List<CargaHoraria> cargar_seleccionada;
    private List<DetalleCh> detalles_carga;
    private List<DetalleCh> detalle_seleccionado;
    List<Cursos> asig;
    private int codasig;
    private Transformar trans;
    //variable para referenciar el horario a 
    private String tipo_carga_horario;
    List<HorarioPos> horariosListos;
    private String hora;
    private List<String> horas;
    private Boolean [] camposReporte;
    List<HorarioActividades> horarios_actividades;
    List<HorarioActividades> horarios_consultados;
    private StreamedContent file_evidencia;
    private Periodo periodoActual;
    private int horasDefinidas;
    //OPCIONES DE PDF
    private PDFOptions pdfOpt;
    private Boolean visibleNombre;
    private Proyectos proyecto_seleccionado;
    private Long sumadeHoras;

    private Usuarios u;
    
    public CargarDatos() {
        args = new ArrayList<>();
        cargar_seleccionada=new ArrayList<>();
        validar = new Validaciones();
        this.combo_tipos_p=true;   
        usuario_nuevo=new Usuarios();
        
        //profesor=sesionprofesorlocal.optenerProfesor("zer");
    } 

    public int getHorasDefinidas() {
        return horasDefinidas;
    }

    public void setHorasDefinidas(int horasDefinidas) {
        this.horasDefinidas = horasDefinidas;
    }
    
    

    public Long getSumadeHoras() {
        return sumadeHoras;
    }

    public void setSumadeHoras(Long sumadeHoras) {
        this.sumadeHoras = sumadeHoras;
    }
    
    

    public Proyectos getProyecto_seleccionado() {
        return proyecto_seleccionado;
    }

    public void setProyecto_seleccionado(Proyectos proyecto_seleccionado) {
        this.proyecto_seleccionado = proyecto_seleccionado;
    }
    
    

    public Boolean getVisibleNombre() {
        return visibleNombre;
    }

    public void setVisibleNombre(Boolean visibleNombre) {
        this.visibleNombre = visibleNombre;
    }
    
    

    public String getCi_docente() {
        return ci_docente;
    }

    public void setCi_docente(String ci_docente) {
        this.ci_docente = ci_docente;
    }
    
    

    public StreamedContent getFile_evidencia() {
        return file_evidencia;
    }
    
    public List<HorarioActividades> getHorarios_consultados() {
        return horarios_consultados;
    }

    public void setHorarios_consultados(List<HorarioActividades> horarios_consultados) {
        this.horarios_consultados = horarios_consultados;
    }
    
    

    public List<HorarioActividades> getHorarios_actividades() {
        return horarios_actividades;
    }

    public void setHorarios_actividades(List<HorarioActividades> horarios_actividades) {
        this.horarios_actividades = horarios_actividades;
    }
    
    
    
    

    public Boolean[] getCamposReporte() {
        return camposReporte;
    }

    public void setCamposReporte(Boolean[] camposReporte) {
        this.camposReporte = camposReporte;
    }
    
    

    public List<String> getHoras() {
        return horas;
    }

    public void setHoras(List<String> horas) {
        this.horas = horas;
    }

    
    
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    
    public List<HorarioPos> getHorariosListos() {
        return horariosListos;
    }

    public void setHorariosListos(List<HorarioPos> horariosListos) {
        this.horariosListos = horariosListos;
    }
    
    

    public String getTipo_carga_horario() {
        return tipo_carga_horario;
    }

    public void setTipo_carga_horario(String tipo_carga_horario) {
        this.tipo_carga_horario = tipo_carga_horario;
    }

    
    public List<Cursos> getAsig() {
        return asig;
    }

    public void setAsig(List<Cursos> asig) {
        this.asig = asig;
    }

    public int getCodasig() {
        return codasig;
    }

    public void setCodasig(int codasig) {
        this.codasig = codasig;
    }
    
    

    public List<DetalleCh> getDetalle_seleccionado() {
        return detalle_seleccionado;
    }

    public void setDetalle_seleccionado(List<DetalleCh> detalle_seleccionado) {
        this.detalle_seleccionado = detalle_seleccionado;
    }

    
    
    public List<CargaHoraria> getCargar_seleccionada() {
        return cargar_seleccionada;
    }

    public void setCargar_seleccionada(List<CargaHoraria> cargar_seleccionada) {
        this.cargar_seleccionada = cargar_seleccionada;
    }
    
    

    public List<DetalleCh> getDetalles_carga() {
        return detalles_carga;
    }

    public void setDetalles_carga(List<DetalleCh> detalles_carga) {
        this.detalles_carga = detalles_carga;
    }

    public String getCargaConsultar() {
        return cargaConsultar;
    }

    public void setCargaConsultar(String cargaConsultar) {
        this.cargaConsultar = cargaConsultar;
    }

    public List<CargaHoraria> getCargasRecuperadas() {
        return cargasRecuperadas;
    }

    public void setCargasRecuperadas(List<CargaHoraria> cargasRecuperadas) {
        this.cargasRecuperadas = cargasRecuperadas;
    }
    
    

    public List<String> getCarga_nombres() {
        return carga_nombres;
    }

    public void setCarga_nombres(List<String> carga_nombres) {
        this.carga_nombres = carga_nombres;
    }

    
    
    public Date getFecha_a_buscar() {
        return fecha_a_buscar;
    }

    public void setFecha_a_buscar(Date fecha_a_buscar) {
        this.fecha_a_buscar = fecha_a_buscar;
    }
    
    
  
 
    public Usuarios getUsuario_nuevo() {
        return usuario_nuevo;
    }

    public void setUsuario_nuevo(Usuarios usuario_nuevo) {
        this.usuario_nuevo = usuario_nuevo;
    }

    
    public String getTipo_docente() {
        return tipo_docente;
    }

    public void setTipo_docente(String tipo_docente) {
        this.tipo_docente = tipo_docente;
    }
    
    

    public boolean isCombo_tipos_p() {
        return combo_tipos_p;
    }

    public void setCombo_tipos_p(boolean combo_tipos_p) {
        this.combo_tipos_p = combo_tipos_p;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    
    
    
    public double getAvance_real() {
        return avance_real;
    }

    public void setAvance_real(double avance_real) {
        this.avance_real = avance_real;
    }

    public double getAvance_estimado() {
        return avance_estimado;
    }

    public void setAvance_estimado(double avance_estimado) {
        this.avance_estimado = avance_estimado;
    }
    
    public List<Proyectos> getPro() {
        return pro;
    }

    public void setPro(List<Proyectos> pro) {
        this.pro = pro;
    }

    public List<String> getNombrepro() {
        return nombrepro;
    }

    public void setNombrepro(List<String> nombrepro) {
        this.nombrepro = nombrepro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora1() {
        return hora1;
    }

    public void setHora1(Date hora) {
        this.hora1 = hora;
    }

    public String getAula() {
        return aula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Usuarios getProfesor() {
        return usuario;
    }

    public void setProfesor(Usuarios u) {
        this.usuario = u;
    }

    public Date getHora2() {
        return hora2;
    }

    public void setHora2(Date hora2) {
        this.hora2 = hora2;
    }

    public String getCi_estudiante() {
        return ci_estudiante;
    }

    public void setCi_estudiante(String ci_estudiante) {
        this.ci_estudiante = ci_estudiante;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    

    public File getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(File evidencia) {
        this.evidencia = evidencia;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public List<String> getAulas() {
        return aulas;
    }

    public void setAulas(List<String> aulas) {
        this.aulas = aulas;
    }

    public List<String> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<String> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public List<Semestre> getCursos() {
        return cursos;
    }

    public void setCursos(List<Semestre> cursos) {
        this.cursos = cursos;
    }

    public List<String> getCursosNombres() {
        return cursosNombres;
    }

    public void setCursosNombres(List<String> cursosNombres) {
        this.cursosNombres = cursosNombres;
    }

    public List<Integer> getCursosCodigos() {
        return cursosCodigos;
    }

    public void setCursosCodigos(List<Integer> cursosCodigos) {
        this.cursosCodigos = cursosCodigos;
    }

    public List<String> getNombres_proyectos() {
        return nombres_proyectos;
    }

    public void setNombres_proyectos(List<String> nombres_proyectos) {
        this.nombres_proyectos = nombres_proyectos;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public PDFOptions getPdfOpt() {
        return pdfOpt;
    }

    public void setPdfOpt(PDFOptions pdfOpt) {
        this.pdfOpt = pdfOpt;
    }
    
    
    
    
    
    
    
    public void guardarInvestigacion(int tipo) {
        cargahoraria =new CargaHoraria();
        cargahoraria.setFecha(fecha);
//        cargahoraria.setHoraInicial(hora1);
//        cargahoraria.setHoraFin(hora2);
        cargahoraria.setHorario(hora);
        cargahoraria.setCodTipoCh(sesionprofesorlocal.obtenerTipoCh(tipo));
        cargahoraria.setCodDocente(this.login1.getUsuario());
        cargahoraria.setTema(tema);
        //sesionprofesorlocal.guardarCargaHoraria(cargahoraria);
        this.prepararDetalleCh(tipo,cargahoraria);


    }
    

  
    

    public boolean guardarDatos(int tipo_operacion) {
        try {
            //crear carga horaria 
            cargahoraria = new CargaHoraria();
            cargahoraria.setFecha(fecha);
//        cargahoraria.setHoraInicial(hora1);
//        cargahoraria.setHoraFin(hora2);
            cargahoraria.setCodTipoCh(sesionprofesorlocal.obtenerTipoCh(tipo_operacion));
            cargahoraria.setCodDocente(this.login1.getUsuario());
            cargahoraria.setTema(tema);
            cargahoraria.setHorario(hora);
            this.llenarDatos(tipo_operacion);

        } catch (Exception e) {
            System.out.println("L EXCEPCION"+e);
        }
//        System.out.println("8888888888888888888888888888888888" + hora1.getHours());
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++-----------"+validar.validarVacios(args));
//        System.out.println("---"+fecha+"---"+hora1+"---"+hora2+"---"+curso+"---"+tema+"---"+observacion);
        if (validar.validarVacios(args)) {
            System.out.println("-------------------NO HAY VACIOS EN LOS DATOS-------------------------");
            //guardar
            Boolean res = validar.verificarCi(ci_estudiante);
            if (tipo_operacion==5|| res == true || tipo_operacion==3|| tipo_operacion==4|| tipo_operacion==7|| tipo_operacion==9) {
                System.out.println("-------------------CEDULA BIEN O NO HACE FALTA-------------------------");
                //sesionprofesorlocal.guardarCargaHoraria(cargahoraria);
                this.prepararDetalleCh(tipo_operacion,cargahoraria);
                this.mostrarModal();
                this.limpiarCampos();
            } else {

                this.mostrarModalErrorCi();
            }

            return true;
        } else {
            this.mostrarModalError();
            return false;
        }

        //sesionprofesorlocal.guardarCargaHoraria(cargahoraria);
        //crear detallecarga horaria
        //boolean res1=sesionprofesorlocal.guardarDatosCargaHoraria(detalle);
        //System.out.println("//////////////////////"+res1);
    }
    
    public void prepararDetalleCh(int tipo,CargaHoraria carga) {

        System.out.println("DETALLE ------------------------ ENTRP-------------");
        DetalleCh detallech = new DetalleCh();
        detallech.setCodCargaHoraria(carga);

        //definir campos de detalle segun tipo de carga horaria del profesor 
        boolean res1;
        switch (tipo) {
            case 1:
                detallech.setCodEstudiante(sesionprofesorlocal.getUsuario(ci_estudiante));
                detallech.setCodCurso(sesionprofesorlocal.getSemestreById(Integer.parseInt(curso)));
                detallech.setCodMateria(sesionprofesorlocal.obtenerCodMateriaPorNombre(materia));
                detallech.setCodAula(sesionprofesorlocal.obtenerCodAulaPornombre(aula));
                //detallech.setCodCurso(sesionprofesorlocal.obtenerCursoPorId(Integer.parseInt(curso)));
                res1 = sesionprofesorlocal.guardarDatosCargaHoraria(detallech);
                break;
            case 2:

                detallech.setTutor(tutor);
                //detallech.setAvanceReal(avance_real);
                //detallech.setAvanceEstimado(avance_estimado);
                detallech.setActividad(actividades);
                detallech.setEvidencia(this.filename);
                detallech.setCodProyecto(sesionprofesorlocal.getProyectoByNombre(tema));
                res1 = sesionprofesorlocal.guardarDatosCargaHoraria(detallech);
                this.filename="";
                this.mostrarModal();
                this.limpiarCampos();
                break;
            case 3:

                detallech.setCodCurso(sesionprofesorlocal.getSemestreById(Integer.parseInt(curso)));
                detallech.setObservacion(observacion);
                res1 = sesionprofesorlocal.guardarDatosCargaHoraria(detallech);
                break;
            case 4:
                detallech.setCodCurso(sesionprofesorlocal.getSemestreById(Integer.parseInt(curso)));;
                detallech.setActividad(actividades);
                detallech.setCodMateria(sesionprofesorlocal.obtenerCodMateriaPorNombre(materia));
                res1 = sesionprofesorlocal.guardarDatosCargaHoraria(detallech);
                break;
            case 5:
                detallech.setCodCurso(sesionprofesorlocal.getSemestreById(Integer.parseInt(curso)));
                detallech.setCodAula(sesionprofesorlocal.obtenerCodAulaPornombre(aula));
                detallech.setActividad(actividades);
                detallech.setCodMateria(sesionprofesorlocal.obtenerCodMateriaPorNombre(materia));
                res1 = sesionprofesorlocal.guardarDatosCargaHoraria(detallech);
                break;
            case 6:

                detallech.setCodCurso(sesionprofesorlocal.getSemestreById(Integer.parseInt(curso)));
                detallech.setCodAula(sesionprofesorlocal.obtenerCodAulaPornombre(aula));
                detallech.setCodEstudiante(sesionprofesorlocal.getUsuario(ci_estudiante));
                detallech.setCodMateria(sesionprofesorlocal.obtenerCodMateriaPorNombre(materia));
                res1 = sesionprofesorlocal.guardarDatosCargaHoraria(detallech);
                break;
            case 7:
                detallech.setCodCurso(sesionprofesorlocal.getSemestreById(Integer.parseInt(curso)));
                detallech.setObservacion(observacion);
                res1 = sesionprofesorlocal.guardarDatosCargaHoraria(detallech);
                break;
            case 8:
                detallech.setCodCurso(sesionprofesorlocal.getSemestreById(Integer.parseInt(curso)));
                detallech.setCodEstudiante(sesionprofesorlocal.getUsuario(ci_estudiante));
                detallech.setObservacion(observacion);
                res1 = sesionprofesorlocal.guardarDatosCargaHoraria(detallech);
                break;
            case 9:
        
                detallech.setCodCurso(sesionprofesorlocal.getSemestreById(Integer.parseInt(curso)));
                detallech.setObservacion(observacion);
                res1 = sesionprofesorlocal.guardarDatosCargaHoraria(detallech);
        }

    }
    

   /*
    public void exportarPdf() throws JRException, IOException {

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", profesor.getApellidos() + " " + profesor.getNombres());
        String nombrepdf = profesor.getApellidos();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("imparticionDeClases4.jasper"));
        //JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(this.profesor.getImparticionDeClasesList()));

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment;filename=" + nombrepdf);
        ServletOutputStream stream = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();

    }
    */
    
    @PostConstruct
    public void inicio() {
        
        
         horasDefinidas=0;
         sumadeHoras=0L;
        //get periodo actual
        periodoActual=sesionprofesorlocal.getPeriodoActual();
        visibleNombre=true;
        
        this.filename="false.txt";
        trans=new Transformar();
        Date facha_actual = new Date();
        tiposCh=new ArrayList<>();
        tiposCh=sesionprofesorlocal.getTiposCh();
        this.llenarTiposCargaHoraria(tiposCh);
        cursosNombres=new ArrayList<>();
        cursosCodigos=new ArrayList<>();
        //cargar cursos
        cursos=sesionprofesorlocal.obtenerSemestres();
        proyectos=sesionprofesorlocal.obtenerProyectos();
        this.obtenerNombreProyectos(proyectos);
        //procesar nombres y codigos
        for (int i = 0; i < cursos.size(); i++) {
            cursosCodigos.add(cursos.get(i).getId().intValue());
            cursosNombres.add(cursos.get(i).getNombre());
        } 
        
       
         proyecto_seleccionado=proyectos.get(0);
        
        List<Aula> aul;
        aulas=new ArrayList<>();
        aul=sesionprofesorlocal.obtenerAulas();
        for (int i = 0; i < aul.size(); i++) {
            aulas.add(aul.get(i).getNomenclatura());
        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        this.login1 = (Login) facesContext.getApplication()
                .getVariableResolver().resolveVariable(facesContext, "login");
        
        //System.out.println("gggggggggggggggggggg"+login1.getUsuario().getAsignaturaDocenteList().size());
          
        asignaturas=new ArrayList<>();
       
       // asig=login1.getUsuario().getAsignaturaDocenteList();
       asig=login1.getUsuario().getCursosList();
       
        for (int i = 0; i < asig.size(); i++) {
            asignaturas.add(asig.get(i).getCodAsignatura().getNombre());
        }
        
        this.consultar_horarios_actividades();
//        Horario horario=login1.getUsuario().getReferenciaHorariaList().get(0).getIdHorario();
//        trans.extraerHorario(sesionprofesorlocal.getHorarioById(horario));
        fecha=facha_actual;
        
        
        //opcines de pdf 
        pdfOpt = new PDFOptions();
        //pdfOpt.setFacetBgColor("#F88017");
       // pdfOpt.setFacetFontSize("20");
        
        
        pdfOpt.setFacetFontColor("#0000ff");
        pdfOpt.setFacetFontStyle("BOLD");
        pdfOpt.setCellFontSize("12");
        
    }
    
    public void llenarTiposCargaHoraria(List<TipoCh> tipo){
        carga_nombres=new ArrayList<>();
        tipo.forEach((tipoCh) -> {
            this.carga_nombres.add(tipoCh.getNombre());
        });
    }
    
     public String irPagEvidencia(int tipo) {
        args.clear();
        try {
            tutor=proyecto_seleccionado.getCodTutor().getApellidoP()+" "+proyecto_seleccionado.getCodTutor().getNombreP();
            args.add(fecha.toString());
//            args.add(hora1.toString());
//            args.add(hora2.toString());
            args.add(tema);
            args.add(tutor);
        } catch (Exception e) {
            args.add(" ");
        }

        if (validar.validarVacios(
                args)) {

            return "cargare_evidencia_vinculacion.xhtml";

        } else {

            this.mostrarModalError();
            return null;
        }

    }
    
    public void obtenerNombreProyectos(List<Proyectos> proyectos){
          this.nombres_proyectos = new ArrayList<>();
          for (Proyectos proyecto : proyectos) {
               nombres_proyectos.add(proyecto.getNombre());
          }   
    }
    
    
    public void mostrarModal() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        RequestContext.getCurrentInstance().execute("document.getElementById(\"modal1\").click();");
    }

    public void mostrarModalError() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        RequestContext.getCurrentInstance().execute("document.getElementById(\"modal2\").click();");
    }

    public void redireccion() throws IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect("../modulo2/registrar_docente_tc.xhtml");
    }
    
    public void redireccion1() throws IOException {
        
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect("../registrar_docente_tc.xhtml");
    }

    public void mostrarModalErrorCi() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        RequestContext.getCurrentInstance().execute("document.getElementById(\"modal3\").click();");
    }

    public void limpiarCampos() {
         
        try {
           // fecha = null;
            hora1 = null;
            hora2 = null;
            aula = "";
            curso = "";
            tema = "";
            ci_estudiante = "";
            materia = "";
            evidencia = null;
            actividades = "";
            observacion="";
        } catch (Exception e) {
            System.out.println("--++++++++++++++++++++++++++++++++++++++++++++++++++++------------------"+e);
        }

    }

    public void cerrarSesion() throws IOException {

//        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
//        String realPath=servletContext.getContextPath();
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+realPath);
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        Object session = externalContext.getSession(false);
        HttpSession httpSession = (HttpSession) session;
        httpSession.invalidate();
        ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();
        context1.redirect("../entrada.xhtml");   
    }
    
     public void cerrarSesion1() throws IOException {

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        Object session = externalContext.getSession(false);
        HttpSession httpSession = (HttpSession) session;
        httpSession.invalidate();
        ExternalContext context1 = FacesContext.getCurrentInstance().getExternalContext();
        context1.redirect("entrada.xhtml");
    }
     
    public void llenarDatos(int tipo){
        args.clear();
        switch (tipo) {
            case 1:
                args.add(fecha.toString());
//                args.add(hora1.toString());
//                args.add(hora2.toString());
//                args.add(aula);
                args.add(tema);
                args.add(materia);
                args.add(ci_estudiante);
                args.add(curso);
                break;
            case 2:
                args.add(fecha.toString());
                args.add(actividades);
//                args.add(hora2.toString());
                args.add(tema);
                args.add(Double.toString(avance_real));
                args.add(Double.toHexString(avance_estimado));
                args.add(tutor);
                break;
            case 3:
                args.add(fecha.toString());
//                args.add(hora1.toString());
//                args.add(hora2.toString());
                args.add(curso);
                args.add(tema);
                args.add(observacion);
                break;
            case 4:
                args.add(fecha.toString());
//                args.add(hora1.toString());
//                args.add(hora2.toString());
                args.add(curso);
//                args.add(aula);
                args.add(actividades);
                args.add(materia);
                break;
            case 5:
                args.add(fecha.toString());
//                args.add(hora1.toString());
//                args.add(hora2.toString());
                args.add(curso);
//                args.add(aula);
                args.add(actividades);
                args.add(materia);
                break;
            case 6:
                args.add(fecha.toString());
//                args.add(hora1.toString());
//                args.add(hora2.toString());
                args.add(curso);
//                args.add(aula);
                args.add(tema);
                args.add(ci_estudiante);
                args.add(materia);
                break;
            case 7:
                args.add(fecha.toString());
//                args.add(hora1.toString());
//                args.add(hora2.toString());
                args.add(curso);
                args.add(tema);
                args.add(observacion);
                break;
            case 8:
                args.add(fecha.toString());
//                args.add(hora1.toString());
//                args.add(hora2.toString());
                args.add(curso);
                args.add(tema);
                args.add(ci_estudiante);
                args.add(observacion);
                break;
            case 9:
                args.add(fecha.toString());
//                args.add(hora1.toString());
//                args.add(hora2.toString());
                args.add(curso);
                args.add(tema);
                args.add(observacion);
                
                
        }
        
    }
    
    public String getCargaHorariaVista() throws IOException{
        String perfil=login1.getUsuario().getUsuariosPerfilesList().get(0).getCodPerfil().getNombre();
        
        switch (perfil){
            case "tc":
                FacesContext.getCurrentInstance().getExternalContext().redirect("../Docente/modulo2/registrar_docente_tc.xhtml");
            case "mt":
                FacesContext.getCurrentInstance().getExternalContext().redirect("../Docente/modulo2/registrar_docente_mt.xhtml");    
            case "tp" :
                FacesContext.getCurrentInstance().getExternalContext().redirect("../Docente/modulo2/registrar_docente_tp.xhtml");
        }
        
        return null;
        
    }
    public String RevisarEntradas(int opcion){
        System.out.println("................>>>>>>>>>>>>>"+tipo_carga_horario);
        System.out.println("la opcion es "+opcion);
        return "entradas.xhtml";
    }
    
    public void buscarEntradasPorDocente(){
      TipoCh tipo;
        cargasRecuperadas=new ArrayList<>();
        System.out.println("ENTRO A LA CONSULTA MANAGED BEAN");
        tipo=sesionprofesorlocal.getTipoChByNombre(cargaConsultar);
        this.jalarCampos(tipo.getId());
        Usuarios u=sesionprofesorlocal.getUsuario(ci_docente);
        cargasRecuperadas=sesionprofesorlocal.getTodasCargarPorFechayUsuario(tipo, fecha_a_buscar,u);
        System.out.println("<-----------------------------------numero de cargar------------------------------->"+cargasRecuperadas.size());
        
    }
    
    public void buscarEntradas(){
        TipoCh tipo;
        cargasRecuperadas=new ArrayList<>();
        System.out.println("ENTRO A LA CONSULTA MANAGED BEAN");
        tipo=sesionprofesorlocal.getTipoChByNombre(cargaConsultar);
        this.jalarCampos(tipo.getId());
        cargasRecuperadas=sesionprofesorlocal.getTodasCargarPorFechayUsuario(tipo, fecha_a_buscar,login1.getUsuario());
        System.out.println("<-----------------------------------numero de cargar------------------------------->"+cargasRecuperadas.size());
        
    }
    public void buscarEntradasGeneral() throws ParseException {
        
        TipoCh tipo;
        cargasRecuperadas = new ArrayList<>();
        tipo = sesionprofesorlocal.getTipoChByNombre(cargaConsultar);
        if (ci_docente.equals("")) {

            System.out.println("ci_docente vacio ");
            cargasRecuperadas = sesionprofesorlocal.obtenerCargasPorTipoYFecha(tipo, fecha_a_buscar);
            sumadeHoras = validar.sumarHoras(cargasRecuperadas);
        } else {
            try {
                System.out.println("no vacios");
                u = sesionprofesorlocal.getUsuario(ci_docente);
                cargasRecuperadas = sesionprofesorlocal.getTodasCargarPorFechayUsuario(tipo, fecha_a_buscar, u);
                sumadeHoras = validar.sumarHoras(cargasRecuperadas);
                //set horas definidas
                switch (cargaConsultar) {

                    case "IMPARTICIÓN DE CLASES":
                        horasDefinidas = u.getConfiguracionesChList().get(0).getHic();
                        break;
                    case "INVESTIGACIÓN":
                        horasDefinidas = u.getConfiguracionesChList().get(0).getHi();
                        break;
                    case "VINCULACIÓN CON LA SOCIEDAD":
                        horasDefinidas = u.getConfiguracionesChList().get(0).getHvs();
                        break;
                    case "PREPARACIÓN DE CLASES":
                        horasDefinidas = u.getConfiguracionesChList().get(0).getHpc();
                        break;
                    case "PREPARACIÓN DE EXÁMENES":
                        horasDefinidas = u.getConfiguracionesChList().get(0).getHpe();
                        break;
                    case "TUTORÍAS ACADÉMICAS":
                        horasDefinidas = u.getConfiguracionesChList().get(0).getHta();
                        break;
                    case "ACTIVIDADES DE TITULACIÓN":
                        horasDefinidas = u.getConfiguracionesChList().get(0).getHat();
                        break;
                    case "TUTORÍAS DE PROYECTOS DE INVESTIGACIÓN":
                        horasDefinidas = u.getConfiguracionesChList().get(0).getHti();
                        break;
                    case "GESTIÓN ACADÉMICA":
                        horasDefinidas = u.getConfiguracionesChList().get(0).getHga();
                        break;
                }
            } catch (Exception e) {
                System.out.println("===== " + e);
                this.mostrarModalError();
            }

        }
        
           
            
            System.out.println("ENTRO A SEGUNDA CONDICION......");
           

            this.jalarCampos(tipo.getId());
            System.out.println("EVIDENCIA  -----> " + tipo + " ----  " + camposReporte[14]);
           
            detalles_carga = new ArrayList<>();
            System.out.println("----------------------0000000000------------------------------>" + detalles_carga.size());
            if (detalles_carga != null) {
                for (CargaHoraria car : cargasRecuperadas) {
                    detalles_carga.addAll(car.getDetalleChList());
                }
            }

            System.out.println("<-----------------------------------numero de detalles------------------------------->" + detalles_carga.size());

        
    }

    
    public String detallarEntrada(int opcion){
        
        System.out.println("los detalles son===========---------------------------------->"+cargar_seleccionada);
        detalles_carga=cargar_seleccionada.get(0).getDetalleChList();
        return "detalle_entrada.xhtml";
    }
    public boolean[] determinarCamposVisibles(){
        
        return null;
    }
    public void agregar(){
        
        DetalleCh detalle;
        detalle=cargar_seleccionada.get(0).getDetalleChList().get(0);
        detalles_carga.add(detalle);
    }
    
    
    
    public String transformaFecha(Date fecha){
        int h,m;
        String tiempo;
        h=fecha.getHours();
        m=fecha.getMinutes();
        if (h<10){
            tiempo="0"+Integer.toString(h)+" : ";
        }
        else{
            tiempo=Integer.toString(h)+" : ";
        }
        if(m<10){
            tiempo=tiempo+"0"+Integer.toString(m);
        }
        else{
            tiempo=tiempo+Integer.toString(m);
        }
        return tiempo;
    }
   public String getNombrecompleto(){
     return login1.getUsuario().getNombreP()+" "+login1.getUsuario().getApellidoP();
   }
   
   public void consultar_horarios(String nombre_carga){
       //METODO RECUPERAR HORARIOS ANTIGUA TABLA
       
//       trans=new Transformar();
//       Horario horario=login1.getUsuario().getReferenciaHorariaList().get(0).getIdHorario();
//       String [][] horarios=trans.extraerHorario(sesionprofesorlocal.getHorarioById(horario));
//       horariosListos=trans.identificarDias(horarios, nombre_carga);
//       System.out.println("TODO BIEN"+horariosListos);
//       horas=new ArrayList<>();
//       horariosListos.forEach((h) -> {
//           horas.add(h.getDia()+" "+h.getHora_ini()+"-"+h.getHora_fin()+" "+h.getAula());
//        });
       
   }
   public void consultar_horarios_actividades(){
       
       horarios_actividades=login1.getUsuario().getHorarioActividadesList();
       System.out.println("----------Zlos HORARIOS SON"+horarios_actividades);
   }
   
   public void consultar_horarios_actividades(int tipo){
       horarios_consultados=new ArrayList<>();
       TipoCh tipocch=sesionprofesorlocal.obtenerTipoCh(tipo);
       trans=new Transformar();
       horas=new ArrayList<>();
       this.horarios_actividades.forEach((actividad) -> {
           if (!actividad.getIdTipoch().equals(tipocch)) {
           } else {
               
               this.horarios_consultados.add(actividad);
               horas.add(trans.numeroADia(actividad.getDia())+" "+actividad.getHoraInicio()+"-"+actividad.getHoraFin()+" "+
                       actividad.getIdCursoAula().getNomenclatura());
               
           }
        });
       
       
       System.out.println("NUEVO HORARIO------------------------->>>>----------->>>>>>>>------->>>>>>>>"+horarios_consultados);
   }
   
   public String direccionarAVista(int vista){
       camposReporte=new Boolean[17];
       trans=new Transformar();
       switch(vista){
           case 1:
               
//               this.consultar_horarios("IMPARTICIÓN DE CLASES");
               this.consultar_horarios_actividades(vista);
               return "formularios/imparticion_de_clases" ;
           case 2:             
//               this.consultar_horarios("INVESTIGACIÓN");
               this.consultar_horarios_actividades(vista);
               return "formularios/investigacion" ;
           case 3:             
//             this.consultar_horarios("VINCULACIÓN CON LA SOCIEDAD");
               this.consultar_horarios_actividades(vista);
               return "formularios/vinculacion_sociedad" ;
           case 4:
               
//               this.consultar_horarios("PREPARACIÓN DE CLASES");
               this.consultar_horarios_actividades(vista);
               return "formularios/preparacion_clases" ;
           case 5:
               
//               this.consultar_horarios("PREPARACIÓN DE EXÁMENES");
               this.consultar_horarios_actividades(vista);
               return "formularios/preparacion_examenes" ;
           case 6:
               this.consultar_horarios_actividades(vista);
//               this.consultar_horarios("TUTORÍAS ACADÉMICAS");
               this.consultar_horarios_actividades(vista);
               return "formularios/tutorias_academicas" ;
           case 7:
               
//               this.consultar_horarios("ACTIVIDADES DE TITULACIÓN");
               this.consultar_horarios_actividades(vista);
               return "formularios/actividades_titulacion" ;
           case 8:
               
//               this.consultar_horarios("TUTORÍAS DE PROYECTOS DE INVESTIGACIÓN");
               this.consultar_horarios_actividades(vista);
               return "formularios/tutorias_proyecto_investigacion" ;
           case 9:
               
//               this.consultar_horarios("GESTIÓN ACADÉMICA");
               this.consultar_horarios_actividades(vista);
               return "formularios/gestion_academica.xhtml";
           default:return null;
           
       }
   }
   
   public void jalarCampos(int tipo){
       
       camposReporte=trans.getCamposReporte(tipo);
       
   }
   
   public void desaparecerEvidencia(){
       camposReporte[14]=false;
   }
   public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
       
        SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es_ES"));
        Date fechaDate = new Date();
         
        System.out.println("VECTOR------"+camposReporte[14]);
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
        pdf.addTitle("Reporte Carga Horaria");
        pdf.addSubject("subtitulo");
        pdf.setMargins(1f, 1f, 1f, 1f);
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "imagenes" + File.separator + "logo_uce_administra.png";
        Image imagen= Image.getInstance(logo);
        imagen.scalePercent(50f);
        imagen.setAlignment(Image.ALIGN_CENTER);
        //pdf.add(imagen);
//        PdfPTable pdfTable = new PdfPTable(2);
//        pdfTable.setWidthPercentage(40f);
//	pdfTable.setHorizontalAlignment(0);
//	pdf.add(pdfTable);	
	final Paragraph phrase = new Paragraph("REPORTE DE CARGA HORARIA");
        
        
        final Paragraph fechaactual = new Paragraph("Fecha: "+formateador.format(fechaDate));
        final Paragraph periodo = new Paragraph("Periodo: "+periodoActual.getAnioInicio()+"-"+periodoActual.getAnioFin());
        
        
        phrase.setAlignment(Element.ALIGN_CENTER);
	fechaactual.setAlignment(Element.ALIGN_LEFT);
        periodo.setAlignment(Element.ALIGN_LEFT);
        
        
        
        pdf.add(new Paragraph(" "));
        pdf.add(phrase);
        pdf.add(new Paragraph(" "));
        pdf.add(fechaactual);
        pdf.add(periodo);
        
        
        if(!ci_docente.equals("") && u!=null){
            visibleNombre=false;
            final Paragraph nombre = new Paragraph("Nombre: "+u.getApellidoP()+" "+u.getNombreP());
            final Paragraph horas1 = new Paragraph("Total Horas Hechas: "+sumadeHoras);
            final Paragraph horasD = new Paragraph("Total Horas Definidas: "+horasDefinidas);
            pdf.add(horas1);
            pdf.add(horasD);
            pdf.add(nombre);
            pdf.add(new Paragraph(" "));
        }
        else{
            pdf.add(new Paragraph(" "));
        }
            
        
        
        camposReporte[14]=false;
        
    }
   
 
    public StreamedContent descargarArchivo(String nom_archi) throws FileNotFoundException {
        
        try {
            //InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("C:\\to\\logo_uce_administra.png");
        FileInputStream stream = new FileInputStream("C:\\\\to\\\\"+nom_archi);
        file_evidencia = new DefaultStreamedContent(stream, "image/png", nom_archi);
        return file_evidencia;
        } catch (FileNotFoundException e) {
            this.mostrarModal();
            System.out.println("error"+e);
            return null;
        }
        
    }
   	
   public void actualizarDatosCarga(){
       
       
       this.detalle_seleccionado.get(0).setCodCurso(sesionprofesorlocal.getSemestreById(Integer.parseInt(curso)));
       this.cargar_seleccionada.get(0).setDetalleChList(this.detalle_seleccionado);
       sesionprofesorlocal.upDateCargaHoria(this.cargar_seleccionada.get(0));
       System.out.println("*********************METODO PARA ACTUALIZAR CARGA*******************************");
   }
   
   
   public void actualizarDetalleCarga(){
         cargar_seleccionada.get(0).getDetalleChList().get(0).setCodCurso(sesionprofesorlocal
                 .getSemestreById(Integer.parseInt(curso)));
         cargar_seleccionada.get(0).setHorario(hora);
         sesionprofesorlocal.upDateCargaHoria(cargar_seleccionada.get(0));
         
        
   }
   
   
    public void bucarProyecto(){
        
        proyecto_seleccionado=sesionprofesorlocal.obtenerProyectoPorNombre(tema);
    }
   
	
   
   
   
}
