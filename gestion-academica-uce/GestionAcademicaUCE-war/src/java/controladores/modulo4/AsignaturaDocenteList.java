/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.modulo4;

import sesiones.modulo4.AsigDocDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import entidades.AsignaturaDocente;
import entidades.CoordinadorArea;

/**
 *
 * @author GABRIELA
 */
@ManagedBean(name = "asignaturaDocenteLista")
@ViewScoped
public class AsignaturaDocenteList {
    private static final Logger LOG = Logger.getLogger(AsignaturaDocenteList.class.getName());
    
    @Inject
    AsigDocDAO asigDocDAO;
    
    public List<AsignaturaDocente> listarAsigDoc() {
        List<AsignaturaDocente> lista = new ArrayList<>();
        LOG.info(lista.toString());
        try {
            lista = asigDocDAO.listar();
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }
        return lista;
}    
}
