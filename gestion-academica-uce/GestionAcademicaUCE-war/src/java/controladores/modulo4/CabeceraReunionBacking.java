/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.modulo4;

import entidades.CabeceraReunion;
import entidades.DetalleReunion;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import sesiones.modulo4.CabeceraReunionDAO;
import sesiones.modulo4.DetalleReunionDAO;

/**
 *
 * @author VirtualW7
 */
@ManagedBean(name = "cabeceraReunionBacking")
@ViewScoped
public class CabeceraReunionBacking {
    
     private static final Logger LOG = Logger.getLogger(CabeceraReunionBacking.class.getName());

    @Inject
    CabeceraReunionDAO cabeceraReunionDAO;
    
        

    private CabeceraReunion cabeceraReunion = new CabeceraReunion();

    public CabeceraReunion getCabeceraReunion() {
        return cabeceraReunion;
    }

    public void setCabeceraReunion(CabeceraReunion cabeceraReunion) {
        this.cabeceraReunion = cabeceraReunion;
    }

    

    public void guardar(ActionEvent actionEvent) {
        System.out.println("clic en boton CABECERA");
       
        System.out.println(""+cabeceraReunion);
        
        if (getCabeceraReunion() != null) {
           
            cabeceraReunionDAO.crear(getCabeceraReunion());
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$"+cabeceraReunion);
        }
       
    }
    
}
