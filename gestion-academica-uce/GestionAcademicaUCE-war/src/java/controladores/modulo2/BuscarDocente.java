/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.modulo2;


import controladores.clases.ReportesImpresion;
import controladores.clases.Transformar;
import entidades.ConfiguracionesCh;
import entidades.Proyectos;
import entidades.Usuarios;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import net.sf.jasperreports.engine.JRException;
import org.primefaces.context.RequestContext;
import sesiones.modulo2.SesionProfesorLocal;


/**
 *
 * @author a
 */
@Named(value = "buscarDocente")
@SessionScoped
public class BuscarDocente implements Serializable {

    @EJB
    private SesionProfesorLocal sesionprofesorlocal;
    
    ReportesImpresion impresionpdf;
    private String proyecto;
    private List<Proyectos> pro;
    private List<String> nombrepro;
    private Usuarios usuario; 
    private String ci;
    private String nombres;
    private String apellidos;
    private String tel;
    private String correo;
    private String tipo_docente;
    private Transformar trans;
    private ConfiguracionesCh confi;
    
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

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    
    
    
    public List<String> getNombrepro() {
        return nombrepro;
    }

    public void setNombrepro(List<String> nombrepro) {
        this.nombrepro = nombrepro;
    }

    
    
    public List<Proyectos> getPro() {
        return pro;
    }

    public void setPro(List<Proyectos> pro) {
        this.pro = pro;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public ConfiguracionesCh getConfi() {
        return confi;
    }

    public void setConfi(ConfiguracionesCh confi) {
        this.confi = confi;
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

    public String getTipo_docente() {
        return tipo_docente;
    }

    public void setTipo_docente(String tipo_docente) {
        this.tipo_docente = tipo_docente;
    }
    
    @PostConstruct  
    public void jalarDatosProyectos(){
       
         nombrepro=new ArrayList<>(); 
         this.pro=this.sesionprofesorlocal.obtenerProyectos();
        if(this.pro==null){
            nombrepro.add("NINGUNO");
        }
        else{          
             pro.forEach((proyectos) -> {
                 nombrepro.add(proyectos.getNombre());
             });
        }
         
         
       
   
    }
    
    
    public void buscarDocente() {
        
        trans = new Transformar();
        usuario = sesionprofesorlocal.getUsuario(ci);
        try {
            this.nombres = usuario.getApellidoP()+" "+usuario.getNombreP();
            this.apellidos = usuario.getApellidoP()+" "+usuario.getApellidoM();
            this.correo = usuario.getCorreoInst();
            this.tel = usuario.getTelefono();
            this.tipo_docente = usuario.getUsuariosPerfilesList().get(0).getCodPerfil().getNombre();

            //obtener configuracion
            confi = new ConfiguracionesCh();
            confi = usuario.getConfiguracionesChList().get(0);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++" + confi.getHic());
            this.jalarDatosHoras();
            
        } catch (NullPointerException e) {
        
            this.limpiar();
            RequestContext.getCurrentInstance().execute("document.getElementById(\"modal1\").click();");
        }
       
    }
    
    public void limpiar(){
    
        this.nombres = "";
        this.apellidos = "";
        this.correo = "";
        this.tel = "";
        this.tipo_docente = "";
        this.ci="";
        
    }
    
    public void guardarConfiHoras() throws IOException{
    
//        confi=new Configuracion();
//        confi.setHic(h1);
//        confi.setHic1(h12);
//        confi.setHi(h2);
//        confi.setHi1(h22);
//        confi.setHvs(h3);
//        confi.setHvs1(h32);
//        confi.setHpc(h4);
//        confi.setHpc1(h42);
//        confi.setHpe(h5);
//        confi.setHpe1(h52);
//        confi.setHta(h6);
//        confi.setHta1(h62);
//        confi.setHat(h7);
//        confi.setHat1(h72);
//        confi.setHti(h8);
//        confi.setHti1(h82);
//        confi.setHga(h9);
//        confi.setHga1(h92);
//        
//        Boolean res=sesionprofesorlocal.editarConfiguracion(confi);
//        if(res=true){
//            this.redireccion();
//        }
        
    }
    public void jalarDatosHoras(){
    
//       
//        
        this.h1=confi.getHic();      
        this.h2=confi.getHi();  
        this.h3=confi.getHvs();
        this.h4=confi.getHpc();
        this.h5=confi.getHpe();
        this.h6=confi.getHta();
        this.h7=confi.getHat();
        this.h9=confi.getHga();
        
        
        
    }
    public void eliminarProyecto(){
    
//        Proyectos p = null;
//        for (Proyectos proyectos : pro) {
//           if(proyectos.getNombre().equals(proyecto)){
//              p=proyectos;
//           }
//        }
//        Boolean result =this.sesionprofesorlocal.eliminarProyecto(p);
//        System.out.println("WWWWWWWWWWWWWWWWWWWWW"+p.getNombre()+"8888888"+result);
//        this.jalarDatosHoras();
   }
    public void reporteGeneral() throws JRException, IOException {
       impresionpdf = new ReportesImpresion();
       impresionpdf.imprimirReportedocentes(this.sesionprofesorlocal.obtenerListaProfesores(1), 1);

    }
    
    public String configuracion(){
        
         this.jalarDatosHoras();
         return "configuracion.xhtml";
    }
    
    public void mostrarModal(){
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
      RequestContext.getCurrentInstance().execute("document.getElementById(\"modal1\").click();");
    }
    public void mostrarModalError(){
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
      RequestContext.getCurrentInstance().execute("document.getElementById(\"modal2\").click();");
    }
    public void redireccion() throws IOException{
       ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
       context.redirect("portal-admin.xhtml");
    }
    
    
    
}
