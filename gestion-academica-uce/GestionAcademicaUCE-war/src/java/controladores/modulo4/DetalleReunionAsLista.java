/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.modulo4;

import sesiones.modulo4.DetalleReunionAsDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import entidades.DetalleReunionAs;

/**
 *
 * @author GABRIELA
 */
@ManagedBean(name = "detalleReunionAsLista")
@ViewScoped
public class DetalleReunionAsLista {
    private static final Logger LOG = Logger.getLogger(DetalleReunionLista.class.getName());
    
    @Inject
    DetalleReunionAsDAO detalleReunionAsDAO;
    
    public List<DetalleReunionAs> listarDetalleReunionAs() {
        List<DetalleReunionAs> lista = new ArrayList<>();
        LOG.info(lista.toString());
        try {
            lista = detalleReunionAsDAO.listar();
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }
        return lista;
    }
}
