/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.modulo4;

import entidades.Asignaturas;
import sesiones.modulo4.CoordinadorAsignaturaDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
//import javax.inject.Inject;
import entidades.CoordinadorAsignatura;
import entidades.Cursos;
import entidades.Usuarios;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import sesiones.modulo4.CursosDAO;

/**
 *
 * @author GABRIELA
 */
@ManagedBean(name = "coordinadoresAsignaturaLista")
@SessionScoped
public class CoordinadoresAsignaturaLista implements Serializable{
    private static final Logger LOG = Logger.getLogger(DocenteLista.class.getName());
    
    @Inject
    CoordinadorAsignaturaDAO coordinadorAsignaturaDAO;
    
    @Inject
    CursosDAO cursosDao;
    
    private Usuarios usuario;
    private Asignaturas ca;
    
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Asignaturas getCa() {
        return ca;
    }

    public void setCa(Asignaturas ca) {
        this.ca = ca;
    }
    
    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (Usuarios) context.getExternalContext().getSessionMap().get("usuario");
         // ahi esta como mandamos eso a la consulta jaja?
        ca = coordinadorAsignaturaDAO.getAsignatura(usuario.getId()); // ahi su ysa dnde vayas a usar
        System.out.println("lstaa::" + ca);
        //ca.getId()// ahi esta el id
    }
    
    public List<CoordinadorAsignatura> listarCooAsignatura() {
        List<CoordinadorAsignatura> lista = new ArrayList<>();
        LOG.info(lista.toString());
        try {
    //        lista = coordinadorAsignaturaDAO.listar();
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }
        return lista;
    }
    
    public List<CoordinadorAsignatura> listarCooAsignaturaId() {
        List<CoordinadorAsignatura> lista = new ArrayList<>();
        LOG.info(lista.toString());
        try {
            lista = coordinadorAsignaturaDAO.listarId();
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }
        return lista;
    }
    
    public List<Cursos> listar() {
        List<Cursos> lista = new ArrayList<>();
        LOG.info(lista.toString());
        try {
            lista = cursosDao.listar(ca);
            System.out.println("mi lista doc-asig:: " + lista );
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }
        return lista;

    }
}
