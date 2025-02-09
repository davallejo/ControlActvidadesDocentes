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
@Table(name = "area_academica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaAcademica.findAll", query = "SELECT a FROM AreaAcademica a")
    , @NamedQuery(name = "AreaAcademica.findById", query = "SELECT a FROM AreaAcademica a WHERE a.id = :id")
    , @NamedQuery(name = "AreaAcademica.findByNombre", query = "SELECT a FROM AreaAcademica a WHERE a.nombre = :nombre")})
public class AreaAcademica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codArea")
    private List<InformesArea> informesAreaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codArea")
    private List<CoordinadorArea> coordinadorAreaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codArea")
    private List<Asignaturas> asignaturasList;

    public AreaAcademica() {
    }

    public AreaAcademica(Integer id) {
        this.id = id;
    }

    public AreaAcademica(Integer id, String nombre) {
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

    @XmlTransient
    public List<InformesArea> getInformesAreaList() {
        return informesAreaList;
    }

    public void setInformesAreaList(List<InformesArea> informesAreaList) {
        this.informesAreaList = informesAreaList;
    }

    @XmlTransient
    public List<CoordinadorArea> getCoordinadorAreaList() {
        return coordinadorAreaList;
    }

    public void setCoordinadorAreaList(List<CoordinadorArea> coordinadorAreaList) {
        this.coordinadorAreaList = coordinadorAreaList;
    }

    @XmlTransient
    public List<Asignaturas> getAsignaturasList() {
        return asignaturasList;
    }

    public void setAsignaturasList(List<Asignaturas> asignaturasList) {
        this.asignaturasList = asignaturasList;
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
        if (!(object instanceof AreaAcademica)) {
            return false;
        }
        AreaAcademica other = (AreaAcademica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.AreaAcademica[ id=" + id + " ]";
    }
    
}
