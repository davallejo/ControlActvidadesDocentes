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
@Table(name = "reporte_area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReporteArea.findAll", query = "SELECT r FROM ReporteArea r")
    , @NamedQuery(name = "ReporteArea.findByIdReporte", query = "SELECT r FROM ReporteArea r WHERE r.idReporte = :idReporte")})
public class ReporteArea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reporte")
    private Integer idReporte;
    @JoinColumn(name = "id_coordinador_area", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CoordinadorArea idCoordinadorArea;
    @JoinColumn(name = "id_periodo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Periodo idPeriodo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReporte")
    private List<DetaleReporte> detaleReporteList;

    public ReporteArea() {
    }

    public ReporteArea(Integer idReporte) {
        this.idReporte = idReporte;
    }

    public Integer getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Integer idReporte) {
        this.idReporte = idReporte;
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
    public List<DetaleReporte> getDetaleReporteList() {
        return detaleReporteList;
    }

    public void setDetaleReporteList(List<DetaleReporte> detaleReporteList) {
        this.detaleReporteList = detaleReporteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReporte != null ? idReporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReporteArea)) {
            return false;
        }
        ReporteArea other = (ReporteArea) object;
        if ((this.idReporte == null && other.idReporte != null) || (this.idReporte != null && !this.idReporte.equals(other.idReporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ReporteArea[ idReporte=" + idReporte + " ]";
    }
    
}
