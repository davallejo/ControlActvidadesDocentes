/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.modulo4;

import entidades.CabeceraReunionAs;
import entidades.DetalleReunionAs;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import sesiones.modulo4.CabeceraReunionAsDAO;
import sesiones.modulo4.DetalleReunionAsDAO;
/**
 *
 * @author D4N13L
 */
@ManagedBean(name = "detalleReunionAsBacking")
@ViewScoped
public class DetalleReunionAsBacking {
    
    private static final Logger LOG = Logger.getLogger(DetalleReunionAsBacking.class.getName());

    @Inject
    DetalleReunionAsDAO detalleReunionAsDAO;
    
        

    private DetalleReunionAs detalleReunionAs = new DetalleReunionAs();

    public DetalleReunionAs getDetalleReunionAs() {
        return detalleReunionAs;
    }

    public void setDetalleReunionAs(DetalleReunionAs detalleReunionAs) {
        this.detalleReunionAs = detalleReunionAs;
    }

    

    public void guardar(ActionEvent actionEvent) {
        System.out.println("clic en boton CABECERA");
       
       // System.out.println(""+detalleReunion.getFecha());
        System.out.println(""+detalleReunionAs.getHoraInicio());
        System.out.println(""+detalleReunionAs.getHoraFin());
        System.out.println("------------------------");
        System.out.println(""+detalleReunionAs.getIdReunion().getIdReunion());
        
        System.out.println(""+detalleReunionAs.getFecha());
      
        
        if (getDetalleReunionAs() != null) {
           
            detalleReunionAsDAO.crear(getDetalleReunionAs());
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$"+detalleReunionAs);
            addMessage("Se ha registrado la convocatoria");
        }
       
    }
    
    public void addMessage(String summary) {
        System.out.println("sadasdasddasd");
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}

