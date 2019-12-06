/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.modulo4;

/**
 *
 * @author D4N13L
 */
 import entidades.CabeceraReunion;
import entidades.DetalleReunion;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import sesiones.modulo4.CabeceraReunionDAO;
import sesiones.modulo4.DetalleReunionDAO;

/**
 *
 * @author VirtualW7
 */
@ManagedBean(name = "detalleReunionBacking")
@ViewScoped
public class DetalleReunionBacking {
    
    private static final Logger LOG = Logger.getLogger(DetalleReunionBacking.class.getName());

     @Inject
    DetalleReunionDAO detalleReunionDAO;
    
        
        

    private DetalleReunion detalleReunion = new DetalleReunion();

    public DetalleReunion getDetalleReunion() {
        return detalleReunion;
    }

    public void setDetalleReunion(DetalleReunion detalleReunion) {
        this.detalleReunion = detalleReunion;
    }

    

    public void guardar(ActionEvent actionEvent) {
        System.out.println("clic en boton CABECERA");
       
       // System.out.println(""+detalleReunion.getFecha());
        System.out.println(""+detalleReunion.getHoraInicio());
        System.out.println(""+detalleReunion.getHoraFin());
        System.out.println("------------------------");
        System.out.println(""+detalleReunion.getIdReunion().getIdReunion());
        
        System.out.println(""+detalleReunion.getFecha());
      
        
        if (getDetalleReunion() != null) {
           
            detalleReunionDAO.crear(getDetalleReunion());
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$"+detalleReunion);
            addMessage("Se ha registrado la convocatoria");
        }
       
    }
    
    public void addMessage(String summary) {
        System.out.println("sadasdasddasd");
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
