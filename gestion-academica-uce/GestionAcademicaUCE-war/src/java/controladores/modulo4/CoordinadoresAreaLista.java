/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.modulo4;

import entidades.AreaAcademica;
import sesiones.modulo4.CoordinadorAreaDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import entidades.CoordinadorArea;
import entidades.CoordinadorAsignatura;
import entidades.Usuarios;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import sesiones.modulo4.CoordinadorAsignaturaDAO;

/**
 *
 * @author GABRIELA
 */
@ManagedBean(name = "coordinadoresAreaLista")
@SessionScoped//@ViewScoped  // creo q fallas x eso
public class CoordinadoresAreaLista implements Serializable{
    private static final Logger LOG = Logger.getLogger(DocenteLista.class.getName());
    @Inject
    CoordinadorAreaDAO coordiandorAreaDAO;
    
    @Inject
    CoordinadorAsignaturaDAO coordiandorAsignaturaDAO;
    
    private Usuarios usuario;
    
    private AreaAcademica ca;  //Y SI NO LE DECLARAMOS PRIVATE? eso no tiene nada q ver
    
    private List<CoordinadorAsignatura> cas;

    public AreaAcademica getCa() {
        return ca;
    }

    public void setCa(AreaAcademica ca) {
        this.ca = ca;
    }
    
    
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    public List<CoordinadorAsignatura> getCas() {
        return cas;
    }

    public void setCas(List<CoordinadorAsignatura> cas) {
        this.cas = cas;
    }
    
    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = (Usuarios) context.getExternalContext().getSessionMap().get("usuario");
         // ahi esta como mandamos eso a la consulta jaja?
        ca = coordiandorAreaDAO.getArea(usuario.getId()); // ahi su ysa dnde vayas a usar
        int c = ca.getId();
        System.out.println("lstaa::" + ca);
         System.out.println("lstaa::" + ca.getId());
         cas = coordiandorAsignaturaDAO.listar(c);
          System.out.println("lstaa::" + cas);
    }
    
    public List<CoordinadorArea> listarCooArea() {
        List<CoordinadorArea> lista = new ArrayList<>();
        LOG.info(lista.toString());
        try {
            lista = coordiandorAreaDAO.listar();
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }
        return lista;
    }
    
    public List<CoordinadorArea> listarCooAreasId() {
        List<CoordinadorArea> lista = new ArrayList<>();
        LOG.info(lista.toString());
        try {
            lista = coordiandorAreaDAO.listarId();
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }
        return lista;
    }
    
//    public List<AreaAcademica> getArea() {
//        List<AreaAcademica> lista = new ArrayList<>();
//        LOG.info(lista.toString());
//        try {
//            lista = coordiandorAreaDAO.getArea(usuario.getId());
//            System.out.println("lstaa::" + lista);
//        } catch (Exception e) {
//            LOG.warning(e.getMessage());
//        }
//        return lista;
//    }
}
