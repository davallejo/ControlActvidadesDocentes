/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "bibliografia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bibliografia.findAll", query = "SELECT b FROM Bibliografia b")
    , @NamedQuery(name = "Bibliografia.findById", query = "SELECT b FROM Bibliografia b WHERE b.id = :id")
    , @NamedQuery(name = "Bibliografia.findByDescripcion", query = "SELECT b FROM Bibliografia b WHERE b.descripcion = :descripcion")
    , @NamedQuery(name = "Bibliografia.findByTipo1", query = "SELECT b FROM Bibliografia b WHERE b.tipo1 = :tipo1")
    , @NamedQuery(name = "Bibliografia.findByTipo2", query = "SELECT b FROM Bibliografia b WHERE b.tipo2 = :tipo2")
    , @NamedQuery(name = "Bibliografia.findByDisponibilidadUce", query = "SELECT b FROM Bibliografia b WHERE b.disponibilidadUce = :disponibilidadUce")
    , @NamedQuery(name = "Bibliografia.findByBibliotecaVirtual", query = "SELECT b FROM Bibliografia b WHERE b.bibliotecaVirtual = :bibliotecaVirtual")})
public class Bibliografia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 1000)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 50)
    @Column(name = "tipo1")
    private String tipo1;
    @Size(max = 50)
    @Column(name = "tipo2")
    private String tipo2;
    @Column(name = "disponibilidad_uce")
    private Boolean disponibilidadUce;
    @Size(max = 100)
    @Column(name = "biblioteca_virtual")
    private String bibliotecaVirtual;
    @OneToMany(mappedBy = "codBibliografia")
    private List<SilaboBibliografia> silaboBibliografiaList;

    public Bibliografia() {
    }

    public Bibliografia(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    public Boolean getDisponibilidadUce() {
        return disponibilidadUce;
    }

    public void setDisponibilidadUce(Boolean disponibilidadUce) {
        this.disponibilidadUce = disponibilidadUce;
    }

    public String getBibliotecaVirtual() {
        return bibliotecaVirtual;
    }

    public void setBibliotecaVirtual(String bibliotecaVirtual) {
        this.bibliotecaVirtual = bibliotecaVirtual;
    }

    @XmlTransient
    public List<SilaboBibliografia> getSilaboBibliografiaList() {
        return silaboBibliografiaList;
    }

    public void setSilaboBibliografiaList(List<SilaboBibliografia> silaboBibliografiaList) {
        this.silaboBibliografiaList = silaboBibliografiaList;
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
        if (!(object instanceof Bibliografia)) {
            return false;
        }
        Bibliografia other = (Bibliografia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Bibliografia[ id=" + id + " ]";
    }
    
}
