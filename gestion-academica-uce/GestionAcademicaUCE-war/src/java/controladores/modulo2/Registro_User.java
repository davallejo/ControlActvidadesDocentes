/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.modulo2;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import controladores.clases.ReportesImpresion;
import controladores.clases.Validaciones;
import entidades.AreaAcademica;
import entidades.AsignaturaDocente;
import entidades.Asignaturas;
import entidades.CargaHoraria;
import entidades.Carreras;
import entidades.Confi;
import entidades.ConfiguracionesCh;
import entidades.Cursos;
import entidades.Paralelo;
import entidades.Perfiles;
import entidades.Periodo;
import entidades.Proyectos;
import entidades.RolUsuario;
import entidades.Roles;
import entidades.Semestre;
import entidades.Silabos;
import entidades.TipoCh;
import entidades.Usuarios;
import entidades.UsuariosPerfiles;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import org.primefaces.context.RequestContext;
import sesiones.modulo2.SesionProfesorLocal;

/**
 *
 * @author a
 */
@Named(value = "registro_User")
@SessionScoped
public class Registro_User implements Serializable {

    /**
     * Creates a new instance of Registro_User
     */
    @EJB
    private SesionProfesorLocal sesionprofesorlocal;

    //##########   VARIABLES PARA ASIGANAR MATERIAS  ####################################
    //############################################## ####################################
    private List<Periodo> periodos;
    private List<Periodo> periodos_seleccinados;
    private List<String> nombreperiodos;

    private List<Paralelo> paralelos;
    private List<Paralelo> paralelos_seleccionados;
    private List<String> nombreparalelos;

    private Boolean permitir_manipular_materias;
    private Boolean activar_tablas;
    private List<Cursos> asignaturas_de_docente;
    private List<Cursos> asignaturas_de_docente_seleccionada;
    //##############################################
    //##############################################

    ReportesImpresion impresionpdf;
    private List<CargaHoraria> cargasRecuperadas;
    private List<TipoCh> tiposCh;
    private List<String> carga_nombres;
    private List<CargaHoraria> cargahorariaselec;
    private List<Roles> roles;
    private List<Perfiles> perfiles;
    private List<String> roles_nombres;
    private List<String> perfiles_nombres;
    private Confi confi;
    private CargaHoraria cargahoraria;
    private Usuarios usuario;
    private String ci;
    private String nombres;
    private String apellidos;
    private String tel;
    private String correo;
    private int tipo_docente;
    private Boolean SiDocente;
    private List<Asignaturas> materias;
    private List<Asignaturas> materias_seleccionadas;
    private ConfiguracionesCh horas_de_carga;

    private List<Proyectos> proyectos;
    private String nombre_proyecto_seleccionado;
    private List<String> nombres_proyectos;
    //                        VARIABLES PARA ASIGNATURAS          
    //############################################################################
    //############################################################################
    private List<AreaAcademica> areas_academicas;
    private List<Carreras> carreras;
    private List<Silabos> silabos;
    private List<Semestre> semestres;

    private List<String> areas_nombres;
    private List<String> nombres_carreras;
    private List<String> nombres_silabos;
    private List<String> nombres_semestres;

    private String area_nombre_selecionado;
    private String nombre_carrera_selecionada;
    private String nombre_carrera_selecionada_a_borrar;
    private String nombre_silabo_selecionado;
    private String nombre_semestre_selecionado;
    private Boolean no_materias_escoger;

    //############################################################################
    //############################################################################
    Usuarios u;

    private String pass;
    private int h1;
    private int h2;
    private int h3;
    private int h4;
    private int h5;
    private int h6;
    private int h7;
    private int h8;
    private int h9;
    private int h12;
    private int h22;
    private int h32;
    private int h42;
    private int h52;
    private int h62;
    private int h72;
    private int h82;
    private int h92;
    private String ci_consultar;
    private List<Integer> horas;
    private Integer total_horas;
    private Validaciones validar;
    private int rol;
    private boolean desactivar;
    private String cargaConsultar;
    private Date fechaConsultar;
    private List<Perfiles> perfiles_seleccionados;
    private List<Roles> roles_seleccionados;
    private List<String> nombres_materias;
    private String materia_selecionada;

    //variables para crear nuevo proyecto
    private String nombre_proyecto;
    private String ci_tutor;
    private Date inicio_proyecto;
    private Date fin_proyecto;
    private String descripcion_proyecto;
    private List<Usuarios> tutores;
    private List<String> nombre_tutores;
    private Periodo periodoActual;
    
    private Periodo periodoActivo;

    //###############CAMPOS PARA MATERIA###############################
    //#################################################################
    private Asignaturas nueva_materia;

    private Carreras nueva_carrera;
    //#################################################################
    //#################################################################

    public ConfiguracionesCh getHoras_de_carga() {
        return horas_de_carga;
    }

    public void setHoras_de_carga(ConfiguracionesCh horas_de_carga) {
        this.horas_de_carga = horas_de_carga;
    }
    
    
    

    public Boolean getActivar_tablas() {
        return activar_tablas;
    }

    public void setActivar_tablas(Boolean activar_tablas) {
        this.activar_tablas = activar_tablas;
    }

    
    
    public Periodo getPeriodoActual() {
        return periodoActual;
    }

    public void setPeriodoActual(Periodo periodoActual) {
        this.periodoActual = periodoActual;
    }

    public Integer getTotal_horas() {
        return total_horas;
    }

    public void setTotal_horas(Integer total_horas) {
        this.total_horas = total_horas;
    }

    public String getNombre_carrera_selecionada_a_borrar() {
        return nombre_carrera_selecionada_a_borrar;
    }

    public void setNombre_carrera_selecionada_a_borrar(String nombre_carrera_selecionada_a_borrar) {
        this.nombre_carrera_selecionada_a_borrar = nombre_carrera_selecionada_a_borrar;
    }

    public List<Proyectos> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyectos> proyectos) {
        this.proyectos = proyectos;
    }

    public String getNombre_proyecto_seleccionado() {
        return nombre_proyecto_seleccionado;
    }

    public void setNombre_proyecto_seleccionado(String nombre_proyecto_seleccionado) {
        this.nombre_proyecto_seleccionado = nombre_proyecto_seleccionado;
    }

    public List<String> getNombres_proyectos() {
        return nombres_proyectos;
    }

    public void setNombres_proyectos(List<String> nombres_proyectos) {
        this.nombres_proyectos = nombres_proyectos;
    }

    public Carreras getNueva_carrera() {
        return nueva_carrera;
    }

    public void setNueva_carrera(Carreras nueva_carrera) {
        this.nueva_carrera = nueva_carrera;
    }

    public Asignaturas getNueva_materia() {
        return nueva_materia;
    }

    public void setNueva_materia(Asignaturas nueva_materia) {
        this.nueva_materia = nueva_materia;
    }

    public List<String> getNombres_materias() {
        return nombres_materias;
    }

    public void setNombres_materias(List<String> nombres_materias) {
        this.nombres_materias = nombres_materias;
    }

    public String getMateria_selecionada() {
        return materia_selecionada;
    }

    public void setMateria_selecionada(String materia_selecionada) {
        this.materia_selecionada = materia_selecionada;
    }

    public List<Asignaturas> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Asignaturas> materias) {
        this.materias = materias;
    }

    public List<Asignaturas> getMaterias_seleccionadas() {
        return materias_seleccionadas;
    }

    public void setMaterias_seleccionadas(List<Asignaturas> materias_seleccionadas) {
        this.materias_seleccionadas = materias_seleccionadas;
    }

    public Confi getConfi() {
        return confi;
    }

    public void setConfi(Confi confi) {
        this.confi = confi;
    }

    public List<String> getNombre_tutores() {
        return nombre_tutores;
    }

    public void setNombre_tutores(List<String> nombre_tutores) {
        this.nombre_tutores = nombre_tutores;
    }

    public List<Usuarios> getTutores() {
        return tutores;
    }

    public void setTutores(List<Usuarios> tutores) {
        this.tutores = tutores;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }

    public String getCi_tutor() {
        return ci_tutor;
    }

    public void setCi_tutor(String ci_tutor) {
        this.ci_tutor = ci_tutor;
    }

    public Date getInicio_proyecto() {
        return inicio_proyecto;
    }

    public void setInicio_proyecto(Date inicio_proyecto) {
        this.inicio_proyecto = inicio_proyecto;
    }

    public Date getFin_proyecto() {
        return fin_proyecto;
    }

    public void setFin_proyecto(Date fin_proyecto) {
        this.fin_proyecto = fin_proyecto;
    }

    public String getDescripcion_proyecto() {
        return descripcion_proyecto;
    }

    public void setDescripcion_proyecto(String descripcion_proyecto) {
        this.descripcion_proyecto = descripcion_proyecto;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public List<Perfiles> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(List<Perfiles> perfiles) {
        this.perfiles = perfiles;
    }

    public List<Perfiles> getPerfiles_seleccionados() {
        return perfiles_seleccionados;
    }

    public void setPerfiles_seleccionados(List<Perfiles> perfiles_seleccionados) {
        this.perfiles_seleccionados = perfiles_seleccionados;
    }

    public List<Roles> getRoles_seleccionados() {
        return roles_seleccionados;
    }

    public void setRoles_seleccionados(List<Roles> roles_seleccionados) {
        this.roles_seleccionados = roles_seleccionados;
    }

    public List<CargaHoraria> getCargasRecuperadas() {
        return cargasRecuperadas;
    }

    public void setCargasRecuperadas(List<CargaHoraria> cargasRecuperadas) {
        this.cargasRecuperadas = cargasRecuperadas;
    }

    public Date getFechaConsultar() {
        return fechaConsultar;
    }

    public void setFechaConsultar(Date fechaConsultar) {
        this.fechaConsultar = fechaConsultar;
    }

    public String getCargaConsultar() {
        return cargaConsultar;
    }

    public void setCargaConsultar(String cargaConsultar) {
        this.cargaConsultar = cargaConsultar;
    }

    public List<String> getCarga_nombres() {
        return carga_nombres;
    }

    public void setCarga_nombres(List<String> carga_nombres) {
        this.carga_nombres = carga_nombres;
    }

    public List<String> getRoles_nombres() {
        return roles_nombres;
    }

    public void setRoles_nombres(List<String> roles_nombres) {
        this.roles_nombres = roles_nombres;
    }

    public List<String> getPerfiles_nombres() {
        return perfiles_nombres;
    }

    public void setPerfiles_nombres(List<String> perfiles_nombres) {
        this.perfiles_nombres = perfiles_nombres;
    }

    public List<CargaHoraria> getCargahorariaselec() {
        return cargahorariaselec;
    }

    public void setCargahorariaselec(List<CargaHoraria> cargahorariaselec) {
        this.cargahorariaselec = cargahorariaselec;
    }

    public boolean isDesactivar() {
        return desactivar;
    }

    public void setDesactivar(boolean desactivar) {
        this.desactivar = desactivar;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getCi_consultar() {
        return ci_consultar;
    }

    public void setCi_consultar(String ci_consultar) {
        this.ci_consultar = ci_consultar;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTipo_docente() {
        return tipo_docente;
    }

    public void setTipo_docente(int tipo_docente) {
        this.tipo_docente = tipo_docente;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Periodo getPeriodoActivo() {
        return periodoActivo;
    }

    public void setPeriodoActivo(Periodo periodoActivo) {
        this.periodoActivo = periodoActivo;
    }

    
    
    public int getH1() {
        return h1;
    }

    public void setH1(int h1) {
        this.h1 = h1;
    }

    public int getH2() {
        return h2;
    }

    public void setH2(int h2) {
        this.h2 = h2;
    }

    public int getH3() {
        return h3;
    }

    public void setH3(int h3) {
        this.h3 = h3;
    }

    public int getH4() {
        return h4;
    }

    public void setH4(int h4) {
        this.h4 = h4;
    }

    public int getH5() {
        return h5;
    }

    public void setH5(int h5) {
        this.h5 = h5;
    }

    public int getH6() {
        return h6;
    }

    public void setH6(int h6) {
        this.h6 = h6;
    }

    public int getH7() {
        return h7;
    }

    public void setH7(int h7) {
        this.h7 = h7;
    }

    public int getH8() {
        return h8;
    }

    public void setH8(int h8) {
        this.h8 = h8;
    }

    public int getH9() {
        return h9;
    }

    public void setH9(int h9) {
        this.h9 = h9;
    }

    public int getH12() {
        return h12;
    }

    public void setH12(int h12) {
        this.h12 = h12;
    }

    public int getH22() {
        return h22;
    }

    public void setH22(int h22) {
        this.h22 = h22;
    }

    public int getH32() {
        return h32;
    }

    public void setH32(int h32) {
        this.h32 = h32;
    }

    public int getH42() {
        return h42;
    }

    public void setH42(int h42) {
        this.h42 = h42;
    }

    public int getH52() {
        return h52;
    }

    public void setH52(int h52) {
        this.h52 = h52;
    }

    public int getH62() {
        return h62;
    }

    public void setH62(int h62) {
        this.h62 = h62;
    }

    public int getH72() {
        return h72;
    }

    public void setH72(int h72) {
        this.h72 = h72;
    }

    public int getH82() {
        return h82;
    }

    public void setH82(int h82) {
        this.h82 = h82;
    }

    public int getH92() {
        return h92;
    }

    public void setH92(int h92) {
        this.h92 = h92;
    }

    public List<String> getAreas_nombres() {
        return areas_nombres;
    }

    public void setAreas_nombres(List<String> areas_nombres) {
        this.areas_nombres = areas_nombres;
    }

    public List<String> getNombres_carreras() {
        return nombres_carreras;
    }

    public void setNombres_carreras(List<String> nombres_carreras) {
        this.nombres_carreras = nombres_carreras;
    }

    public List<String> getNombres_silabos() {
        return nombres_silabos;
    }

    public void setNombres_silabos(List<String> nombres_silabos) {
        this.nombres_silabos = nombres_silabos;
    }

    public List<String> getNombres_semestres() {
        return nombres_semestres;
    }

    public void setNombres_semestres(List<String> nombres_semestres) {
        this.nombres_semestres = nombres_semestres;
    }

    public String getArea_nombre_selecionado() {
        return area_nombre_selecionado;
    }

    public void setArea_nombre_selecionado(String area_nombre_selecionado) {
        this.area_nombre_selecionado = area_nombre_selecionado;
    }

    public String getNombre_carrera_selecionada() {
        return nombre_carrera_selecionada;
    }

    public void setNombre_carrera_selecionada(String nombre_carrera_selecionada) {
        this.nombre_carrera_selecionada = nombre_carrera_selecionada;
    }

    public String getNombre_silabo_selecionado() {
        return nombre_silabo_selecionado;
    }

    public void setNombre_silabo_selecionado(String nombre_silabo_selecionado) {
        this.nombre_silabo_selecionado = nombre_silabo_selecionado;
    }

    public String getNombre_semestre_selecionado() {
        return nombre_semestre_selecionado;
    }

    public void setNombre_semestre_selecionado(String nombre_semestre_selecionado) {
        this.nombre_semestre_selecionado = nombre_semestre_selecionado;
    }

    public List<Carreras> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carreras> carreras) {
        this.carreras = carreras;
    }

    public List<Periodo> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(List<Periodo> periodos) {
        this.periodos = periodos;
    }

    public List<Paralelo> getParalelos() {
        return paralelos;
    }

    public void setParalelos(List<Paralelo> paralelos) {
        this.paralelos = paralelos;
    }

    public List<Periodo> getPeriodos_seleccinados() {
        return periodos_seleccinados;
    }

    public void setPeriodos_seleccinados(List<Periodo> periodos_seleccinados) {
        this.periodos_seleccinados = periodos_seleccinados;
    }

    public List<Paralelo> getParalelos_seleccionados() {
        return paralelos_seleccionados;
    }

    public void setParalelos_seleccionados(List<Paralelo> paralelos_seleccionados) {
        this.paralelos_seleccionados = paralelos_seleccionados;
    }

    public Boolean getPermitir_manipular_materias() {
        return permitir_manipular_materias;
    }

    public void setPermitir_manipular_materias(Boolean permitir_manipular_materias) {
        this.permitir_manipular_materias = permitir_manipular_materias;
    }

    public List<Cursos> getAsignaturas_de_docente() {
        return asignaturas_de_docente;
    }

    public void setAsignaturas_de_docente(List<Cursos> asignaturas_de_docente) {
        this.asignaturas_de_docente = asignaturas_de_docente;
    }

    public Boolean getNo_materias_escoger() {
        return no_materias_escoger;
    }

    public void setNo_materias_escoger(Boolean no_materias_escoger) {
        this.no_materias_escoger = no_materias_escoger;
    }

    public List<Cursos> getAsignaturas_de_docente_seleccionada() {
        return asignaturas_de_docente_seleccionada;
    }

    public void setAsignaturas_de_docente_seleccionada(List<Cursos> asignaturas_de_docente_seleccionada) {
        this.asignaturas_de_docente_seleccionada = asignaturas_de_docente_seleccionada;
    }

    @PostConstruct
    public void jalarHora() {

        activar_tablas=true;
        periodoActual = sesionprofesorlocal.getPeriodoActual();
        no_materias_escoger = false;
        permitir_manipular_materias = true;
        //obttener periodos y paralelos
        periodos_seleccinados = new ArrayList<>();
        paralelos_seleccionados = new ArrayList<>();
        periodos = sesionprofesorlocal.obtenerPeriodos();
        paralelos = sesionprofesorlocal.obtenerParalelos();
        //sacar nombres paraleslos y periodos
        nombreperiodos = new ArrayList<>();
        for (Periodo periodo : periodos) {
            nombreperiodos.add(periodo.getAnioInicio() + "--" + periodo.getAnioFin());
        }
        nombreparalelos = new ArrayList<>();
        for (Paralelo paralelo : paralelos) {
            nombreparalelos.add(paralelo.getNombre());
        }

        //----------------------------------------------
        nueva_carrera = new Carreras();

        proyectos = new ArrayList<>();
        proyectos = sesionprofesorlocal.obtenerProyectos();
        nombres_proyectos = new ArrayList<>();
        for (Proyectos proyecto : proyectos) {
            nombres_proyectos.add(proyecto.getNombre());
        }

        areas_academicas = sesionprofesorlocal.obtenerAreasAcademicas();
        carreras = sesionprofesorlocal.obtenerCarreras();
        silabos = sesionprofesorlocal.obtenerSilabos();
        semestres = sesionprofesorlocal.ObtenerSemestres();

        areas_nombres = new ArrayList<>();
        for (AreaAcademica areas_academica : areas_academicas) {
            areas_nombres.add(areas_academica.getNombre());
        }

        nombres_carreras = new ArrayList<>();
        for (Carreras carrera : carreras) {
            nombres_carreras.add(carrera.getNombre());
        }

        nombres_silabos = new ArrayList<>();
        for (Silabos silabo : silabos) {
            nombres_silabos.add(silabo.getId().toString());
        }

        nueva_materia = new Asignaturas();
        this.SiDocente = false;
        this.materias = sesionprofesorlocal.getMaterias();
        tiposCh = new ArrayList<>();
        tiposCh = sesionprofesorlocal.getTiposCh();
        this.llenarTiposCargaHoraria(tiposCh);

        this.tutores = sesionprofesorlocal.obtenerListaProfesores(0);
        nombre_tutores = new ArrayList<>();
        for (Usuarios usuario : tutores) {
            List<RolUsuario> roles = usuario.getRolUsuarioList();
            for (RolUsuario role : roles) {
                if (role.getCodRol().getNombre().equals("Docente")) {
                    nombre_tutores.add(usuario.getApellidoP() + " " + usuario.getApellidoM() + " " + usuario.getNombreP());
                }
            }
        }

        cargahorariaselec = new ArrayList<>();
        perfiles = new ArrayList<>();
        roles = new ArrayList<>();
        perfiles = sesionprofesorlocal.getPerfiles();
        roles = sesionprofesorlocal.getRoles();
        desactivar = true;
        confi = sesionprofesorlocal.obternerConfiguracionGeneral(1);
//        rol=1;
//        this.h1=confi.getHic();
//        this.h12=confi.getHic1();
//        this.h2=confi.getHi();
//        this.h22=confi.getHi1();
//        this.h3=confi.getHvs();
//        this.h32=confi.getHvs1();
//        this.h4=confi.getHpc();
//        this.h42=confi.getHpc1();
//        this.h5=confi.getHpe();
//        this.h52=confi.getHpe1();
//        this.h6=confi.getHta();
//        this.h62=confi.getHta1();
//        this.h7=confi.getHat();
//        this.h72=confi.getHat1();
//        this.h9=confi.getHga();

        nombres_materias = new ArrayList<>();
        for (Asignaturas mat_actual : materias) {
            nombres_materias.add(mat_actual.getNombre());
        }

        inicio_proyecto = new Date();
    }

    public void llenarTiposCargaHoraria(List<TipoCh> tipo) {
        carga_nombres = new ArrayList<>();
        tipo.forEach((tipoCh) -> {
            this.carga_nombres.add(tipoCh.getNombre());
        });
    }

    public void extraerRolesyPerfiles() {
        roles_nombres = new ArrayList<>();
        perfiles_nombres = new ArrayList<>();
        roles.forEach((role) -> {
            roles_nombres.add(role.getNombre());
        });
        perfiles.forEach((perfi) -> {
            perfiles_nombres.add(perfi.getNombre());
        });
    }

    public String guardarUsuario() {

        try {

            validar = new Validaciones();
            String[] noms = validar.separarFrase(nombres);
            String[] apes = validar.separarFrase(apellidos);
            u = new Usuarios();
            u.setId(ci);
            u.setApellidoP(apes[0]);
            
            if(apes.length>1){
                u.setApellidoM(apes[1]);
            }
            else{
                u.setApellidoM("NO");
            }
            
            u.setNombreP(noms[0]);
            
            if(noms.length>1){
                u.setNombreS(noms[1]);
            }
            else{
                u.setNombreS("NO");
            }
            
            u.setTelefono(tel);
            u.setUserPass(pass);
            u.setEstado(true);

            //colocar perfiles de nuevo usuario
            List<UsuariosPerfiles> usuarios_perfiles = new ArrayList<>();
            for (Perfiles perfile : perfiles_seleccionados) {
                UsuariosPerfiles perfilesUsuario = new UsuariosPerfiles();
                perfilesUsuario.setCodUsuario(u);
                perfilesUsuario.setCodPerfil(perfile);
                usuarios_perfiles.add(perfilesUsuario);
            }
            u.setUsuariosPerfilesList(usuarios_perfiles);

            //colocar roles de nuevo usuario
            List<RolUsuario> usuarios_roles = new ArrayList<>();
            for (Roles rol : roles_seleccionados) {
                RolUsuario rolUsuario = new RolUsuario();
                rolUsuario.setCodUsuario(u);
                rolUsuario.setCodRol(rol);
                usuarios_roles.add(rolUsuario);
            }
            u.setRolUsuarioList(usuarios_roles);

            u.setCorreoInst(correo);
            u.setUserName(noms[0].substring(0, 1).toUpperCase() + apes[0]);

            /*CONFIGURACION DE LISTA**/
 /*#######################*/
 /*#######################*/
 /*#######################*/
            ConfiguracionesCh configuracion = new ConfiguracionesCh();
            configuracion.setHic(h1);
            configuracion.setHi(h2);
            configuracion.setHvs(h3);
            configuracion.setHpc(h4);
            configuracion.setHpe(h5);
            configuracion.setHta(h6);
            configuracion.setHat(h7);
            configuracion.setHti(h7);
            configuracion.setHga(h8);
            configuracion.setCodProfesor(u);

            List<ConfiguracionesCh> configuracionLista = new ArrayList<>();
            configuracionLista.add(configuracion);
            u.setConfiguracionesChList(configuracionLista);
            /*##########MATERIAS#############*/
 /*#######################*/
 /* 
                List<AsignaturaDocente> listaMaterias = new ArrayList<>();
                for (Asignaturas materia : materias_seleccionadas) {
                    
                   
                    
                    
                    
                    AsignaturaDocente ad = new AsignaturaDocente();
                    ad.setCodAsignatura(materia);
                    ad.setCodDocente(u);
                    listaMaterias.add(ad);
                    // fata asinar periodo no definido ------> listaMaterias.add();
                }
                
                u.setAsignaturaDocenteList(listaMaterias);
                
             */
 /*#######################*/
 /*#######################*/
 /*#######################*/

 /*#######################*/
 /*#######################*/
 /*#######################*/
            //guardar usuario
            System.out.println("ENTRO EN FUNCION GUARDAR --------------------el usuario" + u + "----" + nombres + "----" + apellidos);

            sesionprofesorlocal.guardarNuevoUsuario(u);
            materias_seleccionadas = null;
            
            return "exito_creacion_usuario.xhtml";

        } catch (Exception e) {

            System.out.println("ERROR------------------------>"+e);
            mostrarModal();

        }

        return null;
    }

    public String insertarHoras() {

        validar = new Validaciones();
        List<String> campos = new ArrayList<>();

        campos.clear();

        campos.add(ci);
        campos.add(nombres);
        campos.add(apellidos);
        campos.add(correo);
        campos.add(tel);
        campos.add(pass);
        campos.add(Integer.toString(tipo_docente));

        Boolean res = validar.validarVacios(campos);
        System.out.println("------------------------------" + res);
        
                
        
        
        if (res == true && !roles_seleccionados.isEmpty()) {

            //validacion de estudiante no sea docente 
            int be = 0;
            int bd = 0;
            for (Roles role_seleccionado : roles_seleccionados) {
                if (role_seleccionado.getNombre().equals("Estudiante")) {
                    be = 1;
                }
                if (role_seleccionado.getNombre().equals("Docente")) {
                    bd = 1;
                }
            }

            if (be == 1 && bd == 0 && roles_seleccionados.size()==1) {

                perfiles_seleccionados = new ArrayList<>();
                perfiles_seleccionados.add(perfiles.get(0));
                return this.validarCedula();
            }
            else
            if (be == 1 && bd == 1) {

                this.mostrarModaAdvertencia();
            }
            else
            if(be==1 && roles_seleccionados.size()>1){
                 this.mostrarModaAdvertencia2();
            }   
            
            else
            if (be == 0  && !perfiles_seleccionados.isEmpty()) {

                
                return this.validarCedula();
            }
            
            else{
                this.mostrarModaAdvertencia1();
            }

            
        } else {
            this.mostrarModal();
            return null;
        }
        return null;
    }

    public String validarCedula() {
        validar = new Validaciones();
        Boolean res = validar.verificarCi(ci);
        System.out.println("-----------------------------------6666" + res);
        //if (res == true) {
        if (true) {
            // Profesor repetido=this.sesionprofesorlocal.optenerProfesor(ci);
            //if(sesionprofesorlocal.getUsuarioByCorreo(correo)==null){
            if (true) {

                //this.guardarUsuario();
                return this.siguenteCrearUsiario();
            } else {
                this.mostrarModaRegistradoYa();
                this.ci = "";
            }
        } else {
            this.limpiar();
            this.mostrarModaErrorCi();
            return null;
        }
//
        return null;
    }

    public void mostrarModalGeneral() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        RequestContext.getCurrentInstance().execute("document.getElementById(\"modal2\").click();");
    }

    public void mostrarModal() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        RequestContext.getCurrentInstance().execute("document.getElementById(\"modal1\").click();");
    }

    public void mostrarModaErrorCi() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        RequestContext.getCurrentInstance().execute("document.getElementById(\"modal2\").click();");
    }

    public void mostrarModaRegistradoYa() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        RequestContext.getCurrentInstance().execute("document.getElementById(\"modal3\").click();");
    }
    
    public void mostrarModaAdvertencia() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        RequestContext.getCurrentInstance().execute("document.getElementById(\"modal6\").click();");
    }
    public void mostrarModaAdvertencia1() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        RequestContext.getCurrentInstance().execute("document.getElementById(\"modal7\").click();");
    }
    
    public void mostrarModaAdvertencia2() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        RequestContext.getCurrentInstance().execute("document.getElementById(\"modal8\").click();");
    }

    public void limpiar() {

        this.ci = "";
        this.nombres = "";
        this.apellidos = "";
        this.correo = "";
        this.tel = "";
        this.pass = "";
        this.total_horas = 0;
        this.h1 = 0;
        this.h2 = 0;
        this.h3 = 0;
        this.h4 = 0;
        this.h5 = 0;
        this.h6 = 0;
        this.h7 = 0;
        this.h8 = 0;
        this.h9 = 0;

        ci_consultar = "";
        usuario = new Usuarios();

    }

    public Boolean verificarHoras() {

//        horas=new ArrayList<>();
//        confi=sesionprofesorlocal.optenerConfiguracion();
//        horas.add(h1);
//        horas.add(h2);
//        horas.add(h3);
//        horas.add(h4);
//        horas.add(h5);
//        horas.add(h6);
//        horas.add(h7);
//        horas.add(h8);
//        horas.add(h9);
//        validar=new Validaciones();
//        
//        int indicadores[]= validar.validarHoras(confi, horas);
//        Boolean mal=false;
//        for (int i = 0; i < 9; i++) {
//            if(indicadores[i]==0) mal=true;
//        }
//        if(mal==true){
//                this.mostrarModal();
//        }
        return false;
    }

    public void buscarUsuario() {

        try{
            
        
            this.materias = sesionprofesorlocal.getMaterias();
            this.usuario = sesionprofesorlocal.getUsuario(ci_consultar);

            
           
            
            if (materias.isEmpty()) {
                no_materias_escoger = true;
            }

            //comprobar si existe el usuario y si es docente
            try {
                int bd=0;
                List<RolUsuario> roles= usuario.getRolUsuarioList();
                for (RolUsuario role : roles) {
                    if(role.getCodRol().getNombre().equals("Docente")) bd=1;
                }
                
                if(bd==1){
                    permitir_manipular_materias = false;
                    no_materias_escoger = false;
                    this.asignaturas_de_docente = usuario.getCursosList();
                    horas_de_carga = usuario.getConfiguracionesChList().get(0);
                }
                else{
                   permitir_manipular_materias=true; 
                   this.mostrarModalGeneral();
                }
                
                
                
                
            } catch (Exception e) {
                
                System.out.println("ERROR ------ "+e);
                this.mostrarModal();

            }

            //Quitar asignaturas ya tomadas por el profesor
            String nombreMateria;
            for (Cursos curso : asignaturas_de_docente) {
                nombreMateria = curso.getCodAsignatura().getNombre();
                for (int i = 0; i < materias.size(); i++) {
                    if (materias.get(i).getNombre().equals(nombreMateria)) {
                        materias.remove(i);
                    }
                }
            }
            
        }
        catch (Exception e) {
                
                System.out.println("ERROR ------ "+e);
             

            
        }
        

        
    }

    public void activarCombo() {

        System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii" + rol);
        if (rol == 2) {
            desactivar = true;
        } else {
            desactivar = false;
        }

    }

    //consultar datos en la tabla CargaHoraria
    public void cargarDatosTabla() {
        cargasRecuperadas = new ArrayList<>();
        cargasRecuperadas = sesionprofesorlocal.getCargaEspecifica(usuario, sesionprofesorlocal.getTipoChByNombre(cargaConsultar));
        try {
            System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk" + cargasRecuperadas.get(0).getHoraInicial());
            Calendar cal = Calendar.getInstance();
            cal.setTime(cargasRecuperadas.get(0).getHoraInicial());
            System.out.println(cal.get(Calendar.HOUR_OF_DAY));
            System.out.println(cal.get(Calendar.MINUTE));
            System.out.println(cal.get(Calendar.SECOND));
        } catch (Exception e) {
            System.out.println("no hay ningun archivo...");
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

    public void reporteCargaHoraria() throws JRException, IOException {
        impresionpdf = new ReportesImpresion();
        impresionpdf.imprimirReporteCargaHoraria(cargasRecuperadas);

    }

    public String tranformarfecha(Date d) {

        return Integer.toString(d.getHours()) + ":" + Integer.toString(d.getMinutes());
    }

    public String siguenteCrearUsiario() {

        System.out.println("ROLES SELECCIONADOS >------------------> " + roles_seleccionados);
        System.out.println("roles--->" + roles_seleccionados);
        System.out.println("roles--->" + perfiles_seleccionados);
        int op = 0;
        for (Roles rol : roles_seleccionados) {

            if (rol.getNombre().equals("Docente")) {
                op = 1;

            } else {
                //op=0;
                //no hace nada
            }
        }

        System.out.println("opcion----------> " + op);
        if (op == 0) {
            this.guardarUsuario();
            return "exito_creacion_usuario.xhtml";
        } else {
            return "insertar_configuracion_horas.xhtml";
        }

    }

    public String nombrarPerfil(String nomenclatura) {

        switch (nomenclatura) {
            case "tc":
                return "Profesor tiempo completo";
            case "tp":
                return "Profesor tiempo parcial";
            case "mt":
                return "Profesor medio tiempo";
        }
        return "No perfil";
    }

    public String guardarConfiHoras() {
        sesionprofesorlocal.guardarConfiguracionGeneralHoras(confi);
        return "configuracion.xhtml";
    }

    public String eliminarProyecto() {

        sesionprofesorlocal.eliminarProyectoPorNombre(nombre_proyecto_seleccionado);

        proyectos = new ArrayList<>();
        proyectos = sesionprofesorlocal.obtenerProyectos();
        nombres_proyectos = new ArrayList<>();
        nombres_proyectos.clear();
        for (Proyectos proyecto : proyectos) {
            nombres_proyectos.add(proyecto.getNombre());
        }
        return "configuracion.xhtml";
    }

    public String crearProyecto() {
        try {
            usuario = sesionprofesorlocal.getUsuario(ci_tutor);
            List<RolUsuario> roles = usuario.getRolUsuarioList();
            int bd = 0;
            for (RolUsuario role : roles) {
                if (role.getCodRol().getNombre().equals("Docente")) {
                    bd = 1;
                }
            }

            if (bd == 1) {
                Proyectos project = new Proyectos();
                project.setNombre(nombre_proyecto);
                project.setDescripcion(descripcion_proyecto);
                project.setFechaFinal(fin_proyecto);
                project.setFechaInicial(inicio_proyecto);
                project.setCodTutor(sesionprofesorlocal.getUsuario(ci_tutor));
                project.setDescripcion(descripcion_proyecto);
                sesionprofesorlocal.crearProyecto(project);

                proyectos = new ArrayList<>();
                proyectos = sesionprofesorlocal.obtenerProyectos();

                nombres_proyectos = new ArrayList<>();
                for (Proyectos proyecto : proyectos) {
                    nombres_proyectos.add(proyecto.getNombre());
                }

                nombre_proyecto = "";
                descripcion_proyecto = "";
                fin_proyecto = null;
                ci_tutor = "";
                descripcion_proyecto = "";

                return "configuracion.xhtml";

            } else {
                this.mostrarModal();
            }

        } catch (Exception e) {
            System.out.println("ERROR CREANDO PROYECTO "+e);
            this.mostrarModal();
        }
                
       return "configuracion.xhtml"; 
    }

    public void eliminarMateria() {
        sesionprofesorlocal.eliminarMateriaPorNombre(materia_selecionada);
        materias = sesionprofesorlocal.getMaterias();
        nombres_materias.clear();
        for (Asignaturas asig : materias) {
            nombres_materias.add(asig.getNombre());
        }
    }

    public String guardarAsignatura() {
        nueva_materia.setCodArea(sesionprofesorlocal.obtenerAreaPorNombre(area_nombre_selecionado));
        nueva_materia.setCodCarrera(sesionprofesorlocal.obtenerCarreraPorNombre(nombre_carrera_selecionada));
        nueva_materia.setCodSilabo(Integer.parseInt(nombre_silabo_selecionado));
        nueva_materia.setCodSemestre(sesionprofesorlocal.getSemestreById(Integer.parseInt(nombre_semestre_selecionado)));

        sesionprofesorlocal.guardarMateria(nueva_materia);
        nueva_materia = new Asignaturas();

        materias = sesionprofesorlocal.obtenerAsignaturtas();
        nombres_materias.clear();
        for (Asignaturas materia : materias) {
            nombres_materias.add(materia.getNombre());
        }

        return "configuracion.xhtml";
    }

    public String guardarCarrera() {
        nueva_carrera.setCodFacultad(sesionprofesorlocal.obtenerFacultadPorId(1));//obtiene la faculta de ciencias administrativas
        sesionprofesorlocal.guardarCarrera(nueva_carrera);
        nombres_carreras.clear();
        carreras = sesionprofesorlocal.obtenerCarreras();
        for (Carreras car : carreras) {
            nombres_carreras.add(car.getNombre());
        }
        return "configuracion.xhtml";
    }

    public String borrarCarrera() {

        System.out.println("------------------------  ENTRO BORRAR CARRERA ------------------------------");
        sesionprofesorlocal.eliminarCarrera(nombre_carrera_selecionada_a_borrar);

        carreras = sesionprofesorlocal.obtenerCarreras();

        nombres_carreras = new ArrayList<>();
        for (Carreras carrera : carreras) {
            nombres_carreras.add(carrera.getNombre());
        }

        nueva_carrera = new Carreras();
        return "configuracion.xhtml";
    }

    public void agregarAsignatura() {
        List<Cursos> curso = new ArrayList<>();
        for (Asignaturas materia : materias_seleccionadas) {
            Cursos c = new Cursos();
            c.setCodAsignatura(materia);
            c.setCodDocente(usuario);

        }

    }

    public String actualizarUsuarioMaterias() {
        
        
        no_materias_escoger = materias.isEmpty();
        
        List<Cursos> cursosDocente = usuario.getCursosList();
        if (cursosDocente == null) {
            cursosDocente = new ArrayList<>();

        }

        if (!paralelos_seleccionados.isEmpty() && !materias_seleccionadas.isEmpty()) {
            
            
            Asignaturas a = materias_seleccionadas.get(0);
            Paralelo par = paralelos_seleccionados.get(0);

            Cursos cur = new Cursos();
            cur.setCodDocente(usuario);
            cur.setCodParalelo(par);
            cur.setCodPeriodo(periodoActual);
            cur.setCodAsignatura(a);
            cursosDocente.add(cur);
            usuario.setCursosList(cursosDocente);
            sesionprofesorlocal.actualizarUsuario(usuario);

            
            
            for (int i = 0; i < materias.size(); i++) {
                if (materias.get(i).getNombre().equals(materias_seleccionadas.get(0).getNombre())) {
                    materias.remove(i);
                }
            }
            

            ///limpiar selecciones
            materias_seleccionadas.clear();
            paralelos_seleccionados.clear();
            periodos_seleccinados.clear();
            permitir_manipular_materias = true;
            return "portal-admin.xhtml";
        } else {
            this.mostrarModal();
        }

        return "asignar_materias.xhtml";

    }

    public String eliminarMateriaDocente() {

//        System.out.println("------->-----------------" + asignaturas_de_docente_seleccionada.get(0).getCodAsignatura().getNombre());
//        System.out.println("-------------------------------------------->" + asignaturas_de_docente);
//        System.out.println("-------------------------------------------->" + usuario);
       
        if (!asignaturas_de_docente_seleccionada.isEmpty()) {
            int pos = 0;
            for (int i = 0; i < asignaturas_de_docente.size(); i++) {
                if (asignaturas_de_docente.get(i).getCodAsignatura().getNombre().equals(asignaturas_de_docente_seleccionada.get(0).getCodAsignatura().getNombre())) {
                    System.out.println("-----entro-----" + i);
                    //asignaturas_de_docente.remove(i);
                    pos = i;
                    System.out.println("-----luego-----" + i);
                }
            }
            permitir_manipular_materias = true;
            System.out.println("------------------->" + asignaturas_de_docente);
            //usuario.setCursosList(asignaturas_de_docente);
            sesionprofesorlocal.borrarCurso(asignaturas_de_docente.get(pos));
             return "portal-admin.xhtml";
        }
        else{
            this.mostrarModalGeneral();
        }
        
        

        return "asignar_materias.xhtml";
    }

    public void sumarHorasProfesor() {
        total_horas = 0;
        this.total_horas = h1 + h2 + h3 + h4 + h5 + h6 + h7 + h8 + h9;

    }
    
    public void sumarHorasProfesorActualizar() {
        total_horas = 0;
       
        
        this.total_horas=horas_de_carga.getHic()
                +horas_de_carga.getHi()
                +horas_de_carga.getHvs()
                +horas_de_carga.getHpc()
                +horas_de_carga.getHpe()
                +horas_de_carga.getHta()
                +horas_de_carga.getHat()
                +horas_de_carga.getHti()
                +horas_de_carga.getHga();

    }
    
    public String actualzarHorasDeCarga(){
        usuario.getConfiguracionesChList().clear();
        usuario.getConfiguracionesChList().add(horas_de_carga);
        sesionprofesorlocal.actualizarUsuario(usuario);
        return "portal-admin.xhtml";
    }
    
    public String aceptarCreacionUsuario(){
        this.limpiar();
        roles_seleccionados=new ArrayList<>();
        perfiles_seleccionados=new ArrayList<>();
        return "portal-admin.xhtml";
    }
    
    public void activarPerido(){
        sesionprofesorlocal.activarPeriodo(periodoActivo);
    }
    

}
