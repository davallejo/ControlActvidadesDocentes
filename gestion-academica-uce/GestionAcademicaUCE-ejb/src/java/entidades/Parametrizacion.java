/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "parametrizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametrizacion.findAll", query = "SELECT p FROM Parametrizacion p")
    , @NamedQuery(name = "Parametrizacion.findById", query = "SELECT p FROM Parametrizacion p WHERE p.id = :id")
    , @NamedQuery(name = "Parametrizacion.findByDiasJustificacion", query = "SELECT p FROM Parametrizacion p WHERE p.diasJustificacion = :diasJustificacion")
    , @NamedQuery(name = "Parametrizacion.findByDiasPermiso", query = "SELECT p FROM Parametrizacion p WHERE p.diasPermiso = :diasPermiso")})
public class Parametrizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dias_justificacion")
    private Integer diasJustificacion;
    @Column(name = "dias_permiso")
    private Integer diasPermiso;

    public Parametrizacion() {
    }

    public Parametrizacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiasJustificacion() {
        return diasJustificacion;
    }

    public void setDiasJustificacion(Integer diasJustificacion) {
        this.diasJustificacion = diasJustificacion;
    }

    public Integer getDiasPermiso() {
        return diasPermiso;
    }

    public void setDiasPermiso(Integer diasPermiso) {
        this.diasPermiso = diasPermiso;
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
        if (!(object instanceof Parametrizacion)) {
            return false;
        }
        Parametrizacion other = (Parametrizacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Parametrizacion[ id=" + id + " ]";
    }
    
}
