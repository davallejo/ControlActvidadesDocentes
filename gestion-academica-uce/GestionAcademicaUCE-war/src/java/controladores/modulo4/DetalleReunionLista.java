/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.modulo4;

import sesiones.modulo4.DetalleReunionDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import entidades.CoordinadorAsignatura;
import entidades.DetalleReunion;
import entidades.DetalleReunion;
import sesiones.modulo4.DetalleReunionDAO;

/**
 *
 * @author GABRIELA
 */
@ManagedBean(name = "detalleReunionLista")
@ViewScoped
public class DetalleReunionLista {
    
     private static final Logger LOG = Logger.getLogger(DetalleReunionLista.class.getName());
    
    @Inject
    DetalleReunionDAO detalleReunionDAO;
    
    public List<DetalleReunion> listarDetalleReunion() {
        List<DetalleReunion> lista = new ArrayList<>();
        LOG.info(lista.toString());
        try {
            lista = detalleReunionDAO.listar();
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }
        return lista;
    }
    
}
