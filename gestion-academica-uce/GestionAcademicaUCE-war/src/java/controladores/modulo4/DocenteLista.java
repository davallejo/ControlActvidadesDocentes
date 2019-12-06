/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.modulo4;

import sesiones.modulo4.DocenteDAO;
import javax.faces.bean.ManagedBean;
import entidades.RolUsuario;
import java.util.*;
import java.util.logging.Logger;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author VirtualW7
 */
@ManagedBean(name = "docenteList")
@ViewScoped
public class DocenteLista {

    private static final Logger LOG = Logger.getLogger(DocenteLista.class.getName());
    
    @Inject
    DocenteDAO docenteDAO;
    
    public List<RolUsuario> listarDocentes() {
        List<RolUsuario> lista = new ArrayList();
        LOG.info(lista.toString());
        try {
            lista = docenteDAO.listar();
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }
        return lista;
    }

}
