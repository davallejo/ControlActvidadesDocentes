/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.modulo4;

import entidades.Asignaturas;
import entidades.CoordinadorAsignatura;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import entidades.RolUsuario;
import entidades.Roles;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import sesiones.modulo4.CoordinadorAreaDAO;
import sesiones.modulo4.CoordinadorAsignaturaDAO;
import sesiones.modulo4.RolUsuarioDAO;

/**
 *
 * @author VirtualW7
 */

@ManagedBean(name = "coordinadorAsignaturaBacking")
@SessionScoped
public class CoordinadorAsignaturaBacking implements Serializable{
    
    private static final Logger LOG = Logger.getLogger(CoordinadorAreaBacking.class.getName());

    @Inject
    CoordinadorAsignaturaDAO coordinadorAsignaturaDAO;
    
    @Inject
    RolUsuarioDAO rolUsuarioDAO;

    private CoordinadorAsignatura coordinadorAsignatura = new CoordinadorAsignatura();

    public CoordinadorAsignatura getCoordinadorAsignatura() {
        return coordinadorAsignatura;
    }

    public void setCoordinadorAsignatura(CoordinadorAsignatura coordinadorAsignatura) {
        this.coordinadorAsignatura = coordinadorAsignatura;
    }

     public void guardar(ActionEvent actionEvent) {
        System.out.println("clic en boton");
         Asignaturas a = getCoordinadorAsignatura().getCodAsignatura();
         int c = a.getId();
         CoordinadorAsignatura g = coordinadorAsignaturaDAO.getAsignaturaCoordinador(c);
         System.out.println(g);
         if (g == null) {
             if (getCoordinadorAsignatura() != null) {
                 coordinadorAsignaturaDAO.crear(getCoordinadorAsignatura());
                 RolUsuario rolUsuario = new RolUsuario();
                 rolUsuario.setCodUsuario(getCoordinadorAsignatura().getCodCoordinador());
                 rolUsuario.setCodRol(new Roles(3));
                 System.out.println(rolUsuario.toString());
                 rolUsuarioDAO.crear(rolUsuario);
                 addMessage("Se ha registrado el coordinador de asignatura");
             }
         } else {
             addMessage("El coordinador de asignatura ya existe para este periodo");
         }
    }
     public void addMessage(String summary) {
        System.out.println("sadasdasddasd");
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
