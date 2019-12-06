/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.modulo4;

import sesiones.modulo4.CabeceraReunionDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import entidades.CabeceraReunion;

/**
 *
 * @author GABRIELA
 */
@ManagedBean(name = "cabeceraReunionLista")
@ViewScoped
public class CabeceraReunionLista {
    private static final Logger LOG = Logger.getLogger(CoordinadoresAreaLista.class.getName());
    
    @Inject
    CabeceraReunionDAO cabeceraReunionDAO;
    
    public List<CabeceraReunion> listarAsignaturas() {
        List<CabeceraReunion> lista = new ArrayList<>();
        LOG.info(lista.toString());
        try {
            lista = cabeceraReunionDAO.listar();
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }
        return lista;
    
   } 
}
