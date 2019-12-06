/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.modulo4;

import entidades.AreaAcademica;
import sesiones.modulo4.CoordinadorAreaDAO;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import entidades.CoordinadorArea;
import entidades.RolUsuario;
import entidades.Roles;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import sesiones.modulo4.RolUsuarioDAO;

/**
 *
 * @author VirtualW7
 */
@ManagedBean(name = "coordinadorAreaBacking")
@SessionScoped
public class CoordinadorAreaBacking implements Serializable{

    private static final Logger LOG = Logger.getLogger(CoordinadorAreaBacking.class.getName());

    @Inject
    CoordinadorAreaDAO coordinadorAreaDAO;
    
    @Inject
    RolUsuarioDAO rolUsuarioDAO;

    private CoordinadorArea coordinadorArea = new CoordinadorArea();

    public CoordinadorArea getCoordinadorArea() {
        return coordinadorArea;
    }

    public void setCoordinadorArea(CoordinadorArea coordinadorArea) {
        this.coordinadorArea = coordinadorArea;
    }

    public void guardar(ActionEvent actionEvent) {
        System.out.println("clic en boton");
        AreaAcademica a = getCoordinadorArea().getCodArea();
        int c = a.getId();
        CoordinadorArea g = coordinadorAreaDAO.getAreaCoordinador(c);
        System.out.println(g);
        if (g == null) {
            if (getCoordinadorArea() != null) {
                coordinadorAreaDAO.crear(getCoordinadorArea());
                RolUsuario rolUsuario = new RolUsuario();
                rolUsuario.setCodUsuario(getCoordinadorArea().getCodCoordinador());
                rolUsuario.setCodRol(new Roles(2));
                System.out.println(rolUsuario.toString());
                rolUsuarioDAO.crear(rolUsuario);
                addMessage("Se ha registrado el coordinador de área");
            }
        } else {
            addMessage("El coordinador de área ya existe para este periodo");
        }
    }
    public void addMessage(String summary) {
        System.out.println("sadasdasddasd");
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
