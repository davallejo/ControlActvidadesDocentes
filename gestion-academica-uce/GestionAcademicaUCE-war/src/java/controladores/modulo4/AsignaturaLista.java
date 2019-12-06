/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.modulo4;

import sesiones.modulo4.AsignaturaDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import entidades.Asignaturas;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author GABRIELA
 */
@ManagedBean(name = "asignaturaLista")
@SessionScoped
public class AsignaturaLista implements Serializable{

    /**
     * Creates a new instance of AsignaturaLista
     */
    private static final Logger LOG = Logger.getLogger(DocenteLista.class.getName());
    
    @Inject
    AsignaturaDAO asignaturaDAO;
    
    public List<Asignaturas> listarAsignaturas() {
        List<Asignaturas> lista = new ArrayList<>();
        LOG.info(lista.toString());
        try {
            lista = asignaturaDAO.listar();
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }
        return lista;
    }
}
