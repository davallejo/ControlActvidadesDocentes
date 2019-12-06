/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.seguridad;

import entidades.RolUsuario;
import entidades.Usuarios;
import java.io.IOException;
import seguridad.SesionLoginLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author: Willian Bermeo & Geovanny Larco
 * @version: 1.0
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {
    
    private Usuarios usuario;
    private String correo;
    private String clave;
    private String rolSelect;
    private List<String> roles;

   
    
    @EJB
    private SesionLoginLocal sesionLoginlocal;

    
     public Login() {
    }
   
    
    public Login(String rolSelected ) {
        this.rolSelect = rolSelected;
    }
    
    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    
     
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    public String getRolSelect() {
        return rolSelect;
    }

    public void setRolSelect(String rolSelect) {
        this.rolSelect = rolSelect;
    }

    public String entrar() {
        //rolSelect= -1;

        try {
            usuario = sesionLoginlocal.loginUsuario(correo, clave);
            System.out.println("*****************" + usuario.getApellidoP() + " " + usuario.getNombreP());
            System.out.println("++++++++++++++"+usuario.getUserPass());
            System.out.println("size de roles"+usuario.getRolUsuarioList().size());
            //int op = 1;
            //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",usuario);
            
            // Gestion de roles y acceso a carpeta
            if(usuario.getRolUsuarioList().size()==1){
                //System.out.println("size de roles"+usuario.getRolUsuarioList().size());  
                System.out.println("Usr select::" + usuario.getRolUsuarioList().get(0).getCodRol().getNombre());
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",usuario);
                return "Usuarios/"
                        +usuario.getRolUsuarioList().get(0).getCodRol().getNombre()
                        +"/home.xhtml?faces-redirect=true";
            } else{
                //System.out.println("size de roles"+usuario.getRolUsuarioList().size());
                
                //System.out.println("roool::: "+ rolSelect);
                
                //carga de roles del usuario
                System.out.println("--------------------------------------------------->"+usuario.getRolUsuarioList().size());
                List<RolUsuario> lista_roles=usuario.getRolUsuarioList();
                roles=new ArrayList<>();
                
                lista_roles.forEach((role) -> {
                    roles.add(role.getCodRol().getNombre());
                });
                rolSelect=roles.get(0);
                try {
                    
                    this.mostrarModalRol();
//                System.out.println("roool::: "+ rolSelect);
//                
//                System.out.println("Usr select::" + usuario.getRolUsuarioList().get(rolSelect).getCodRol().getNombre());
//                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",usuario);
//                return "Usuarios/"
//                        +usuario.getRolUsuarioList().get(rolSelect).getCodRol().getNombre()
//                        +"/home.xhtml?faces-redirect=true";
                } catch (Exception e) {
                    System.out.println("Probles roles:: "+e);
                    return null;
                }
                
                
                //int tipo_rol=usuario.getRolUsuarioList().ge .get(0).getCodPerfil().getId();
                            /*switch(rolSelect){
                                case 1:
                                   return "Usuarios/docentes/home.xhtml?faces-redirect=true";
                                case 2:    
                                   return "Usuarios/docentes/home.xhtml?faces-redirect=true";
                                case 3:
                                   return "Usuarios/docentes/home.xhtml?faces-redirect=true"; 
                            }*/
                
                //return null;
                //return "Usuarios/docentes/home.xhtml?faces-redirect=true";
            }
            
            

        } catch (Exception e) {
            System.out.println("error::" + e);
            this.mostrarModal();
            return null;

        }
       return null;
    }
    
    public String redireccionar(){
                System.out.println("roles"+roles);
                System.out.println("roool::: "+ rolSelect);
                System.out.println("Usr select::" + rolSelect);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",usuario);
                return "Usuarios/"
                        +rolSelect
                        +"/home.xhtml?faces-redirect=true";
    }
    
    // Valida la session del usuario
    public void verificarSesion(){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Usuarios us = (Usuarios) context.getExternalContext().getSessionMap().get("usuario");
            if(us == null){
                context.getExternalContext().redirect("./../../restringido.xhtml");
            }
        } catch (IOException e) {
            //logs
            System.out.println("error::"+e);
        }
    }
    
    public void cerrarSession(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        //return "success";
    }
    
    public void mostrarModal() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        RequestContext.getCurrentInstance().execute("document.getElementById(\"modal\").click();");
    }
    
    public void mostrarModalRol() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        RequestContext.getCurrentInstance().execute("document.getElementById(\"bModalRol\").click();");
    }

}
