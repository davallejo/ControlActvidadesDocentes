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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "cabecera_reunion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CabeceraReunion.findAll", query = "SELECT c FROM CabeceraReunion c")
    , @NamedQuery(name = "CabeceraReunion.findByIdReunion", query = "SELECT c FROM CabeceraReunion c WHERE c.idReunion = :idReunion")})
public class CabeceraReunion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reunion")
    private Integer idReunion;
    @JoinColumn(name = "id_coordinador_area", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CoordinadorArea idCoordinadorArea;
    @JoinColumn(name = "id_periodo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Periodo idPeriodo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReunion")
    private List<DetalleReunion> detalleReunionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReunion")
    private List<DetalleActa> detalleActaList;

    public CabeceraReunion() {
    }

    public CabeceraReunion(Integer idReunion) {
        this.idReunion = idReunion;
    }

    public Integer getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(Integer idReunion) {
        this.idReunion = idReunion;
    }

    public CoordinadorArea getIdCoordinadorArea() {
        return idCoordinadorArea;
    }

    public void setIdCoordinadorArea(CoordinadorArea idCoordinadorArea) {
        this.idCoordinadorArea = idCoordinadorArea;
    }

    public Periodo getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Periodo idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    @XmlTransient
    public List<DetalleReunion> getDetalleReunionList() {
        return detalleReunionList;
    }

    public void setDetalleReunionList(List<DetalleReunion> detalleReunionList) {
        this.detalleReunionList = detalleReunionList;
    }

    @XmlTransient
    public List<DetalleActa> getDetalleActaList() {
        return detalleActaList;
    }

    public void setDetalleActaList(List<DetalleActa> detalleActaList) {
        this.detalleActaList = detalleActaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReunion != null ? idReunion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CabeceraReunion)) {
            return false;
        }
        CabeceraReunion other = (CabeceraReunion) object;
        if ((this.idReunion == null && other.idReunion != null) || (this.idReunion != null && !this.idReunion.equals(other.idReunion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CabeceraReunion[ idReunion=" + idReunion + " ]";
    }
    
}
