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
@Table(name = "cabecera_reunion_as")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CabeceraReunionAs.findAll", query = "SELECT c FROM CabeceraReunionAs c")
    , @NamedQuery(name = "CabeceraReunionAs.findByIdReunion", query = "SELECT c FROM CabeceraReunionAs c WHERE c.idReunion = :idReunion")})
public class CabeceraReunionAs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reunion")
    private Integer idReunion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReunion")
    private List<DetalleReunionAs> detalleReunionAsList;
    @JoinColumn(name = "id_coordinador_asignatura", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CoordinadorAsignatura idCoordinadorAsignatura;
    @JoinColumn(name = "id_periodo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Periodo idPeriodo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReunion")
    private List<DetalleActaAs> detalleActaAsList;

    public CabeceraReunionAs() {
    }

    public CabeceraReunionAs(Integer idReunion) {
        this.idReunion = idReunion;
    }

    public Integer getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(Integer idReunion) {
        this.idReunion = idReunion;
    }

    @XmlTransient
    public List<DetalleReunionAs> getDetalleReunionAsList() {
        return detalleReunionAsList;
    }

    public void setDetalleReunionAsList(List<DetalleReunionAs> detalleReunionAsList) {
        this.detalleReunionAsList = detalleReunionAsList;
    }

    public CoordinadorAsignatura getIdCoordinadorAsignatura() {
        return idCoordinadorAsignatura;
    }

    public void setIdCoordinadorAsignatura(CoordinadorAsignatura idCoordinadorAsignatura) {
        this.idCoordinadorAsignatura = idCoordinadorAsignatura;
    }

    public Periodo getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Periodo idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    @XmlTransient
    public List<DetalleActaAs> getDetalleActaAsList() {
        return detalleActaAsList;
    }

    public void setDetalleActaAsList(List<DetalleActaAs> detalleActaAsList) {
        this.detalleActaAsList = detalleActaAsList;
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
        if (!(object instanceof CabeceraReunionAs)) {
            return false;
        }
        CabeceraReunionAs other = (CabeceraReunionAs) object;
        if ((this.idReunion == null && other.idReunion != null) || (this.idReunion != null && !this.idReunion.equals(other.idReunion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CabeceraReunionAs[ idReunion=" + idReunion + " ]";
    }
    
}
