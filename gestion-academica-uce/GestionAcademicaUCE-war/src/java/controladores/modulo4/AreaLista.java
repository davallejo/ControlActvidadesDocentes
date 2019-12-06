/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.modulo4;

import sesiones.modulo4.AreaDAO;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import entidades.AreaAcademica;
import javax.inject.Inject;

/**
 *
 * @author VirtualW7
 */
@ManagedBean(name = "areaList")
@ViewScoped
public class AreaLista {
    
    private static final Logger LOG = Logger.getLogger(AreaAcademica.class.getName());
    
    @Inject
    AreaDAO areaDAO;
    public List<AreaAcademica> listarAreas() {
        List<AreaAcademica> lista = new ArrayList<>();
        LOG.info(lista.toString());
        try {
            lista = areaDAO.listar();
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }
        return lista;
    }
    
}
