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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "facultades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facultades.findAll", query = "SELECT f FROM Facultades f")
    , @NamedQuery(name = "Facultades.findById", query = "SELECT f FROM Facultades f WHERE f.id = :id")
    , @NamedQuery(name = "Facultades.findByNombre", query = "SELECT f FROM Facultades f WHERE f.nombre = :nombre")
    , @NamedQuery(name = "Facultades.findByMision", query = "SELECT f FROM Facultades f WHERE f.mision = :mision")
    , @NamedQuery(name = "Facultades.findByVision", query = "SELECT f FROM Facultades f WHERE f.vision = :vision")})
public class Facultades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "mision")
    private String mision;
    @Size(max = 2147483647)
    @Column(name = "vision")
    private String vision;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFacultad")
    private List<Carreras> carrerasList;

    public Facultades() {
    }

    public Facultades(Integer id) {
        this.id = id;
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

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    @XmlTransient
    public List<Carreras> getCarrerasList() {
        return carrerasList;
    }

    public void setCarrerasList(List<Carreras> carrerasList) {
        this.carrerasList = carrerasList;
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
        if (!(object instanceof Facultades)) {
            return false;
        }
        Facultades other = (Facultades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Facultades[ id=" + id + " ]";
    }
    
}
