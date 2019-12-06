/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.modulo4;

import entidades.Cursos;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;
import sesiones.modulo4.CursosDAO;

/**
 *
 * @author GABRIELA
 */
@Named(value = "cursoLista")
@SessionScoped
public class CursosLista implements Serializable {

    private static final Logger LOG = Logger.getLogger(CursosLista.class.getName());

    /**
     * Creates a new instance of CursoLista
     */
    @Inject
    CursosDAO cursosDao;
    
    

    public CursosLista() {
    }
    /*
    public List<Cursos> listar() {
        List<Cursos> lista = new ArrayList<>();
        LOG.info(lista.toString());
        try {
            lista = cursosDao.listar();
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }
        return lista;

    }*/
}

