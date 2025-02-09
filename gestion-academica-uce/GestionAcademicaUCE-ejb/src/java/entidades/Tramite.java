/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "tramite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tramite.findAll", query = "SELECT t FROM Tramite t")
    , @NamedQuery(name = "Tramite.findById", query = "SELECT t FROM Tramite t WHERE t.id = :id")
    , @NamedQuery(name = "Tramite.findByNombre", query = "SELECT t FROM Tramite t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Tramite.findByKeyPagina", query = "SELECT t FROM Tramite t WHERE t.keyPagina = :keyPagina")})
public class Tramite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 40)
    @Column(name = "key_pagina")
    private String keyPagina;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTramite")
    private List<Formulario> formularioList;

    public Tramite() {
    }

    public Tramite(Integer id) {
        this.id = id;
    }

    public Tramite(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getKeyPagina() {
        return keyPagina;
    }

    public void setKeyPagina(String keyPagina) {
        this.keyPagina = keyPagina;
    }

    @XmlTransient
    public List<Formulario> getFormularioList() {
        return formularioList;
    }

    public void setFormularioList(List<Formulario> formularioList) {
        this.formularioList = formularioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tramite[ id=" + id + " ]";
    }
    
}
