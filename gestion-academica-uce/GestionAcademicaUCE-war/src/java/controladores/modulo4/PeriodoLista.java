/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.modulo4;

import sesiones.modulo4.PeriodoDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import entidades.Periodo;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author VirtualW7
 */
@ManagedBean(name = "periodoList")
@SessionScoped
public class PeriodoLista implements Serializable{
    
    private static final Logger LOG = Logger.getLogger(DocenteLista.class.getName());
    
    @Inject
    PeriodoDAO periodoDAO;
    
    public List<Periodo> listarPeriodos() {
        List<Periodo> lista = new ArrayList();
        LOG.info(lista.toString());
        try {
            lista = periodoDAO.listar();
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }
        return lista;
    }
    
}
