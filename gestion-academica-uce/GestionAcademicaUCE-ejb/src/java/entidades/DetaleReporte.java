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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "detale_reporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetaleReporte.findAll", query = "SELECT d FROM DetaleReporte d")
    , @NamedQuery(name = "DetaleReporte.findByIdDetalle", query = "SELECT d FROM DetaleReporte d WHERE d.idDetalle = :idDetalle")
    , @NamedQuery(name = "DetaleReporte.findByPorcentajeSilabus", query = "SELECT d FROM DetaleReporte d WHERE d.porcentajeSilabus = :porcentajeSilabus")
    , @NamedQuery(name = "DetaleReporte.findByUnidades", query = "SELECT d FROM DetaleReporte d WHERE d.unidades = :unidades")
    , @NamedQuery(name = "DetaleReporte.findByObservaciones", query = "SELECT d FROM DetaleReporte d WHERE d.observaciones = :observaciones")})
public class DetaleReporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle")
    private Integer idDetalle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje_silabus")
    private Float porcentajeSilabus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidades")
    private int unidades;
    @Size(max = 200)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_reporte", referencedColumnName = "id_reporte")
    @ManyToOne(optional = false)
    private ReporteArea idReporte;

    public DetaleReporte() {
    }

    public DetaleReporte(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public DetaleReporte(Integer idDetalle, int unidades) {
        this.idDetalle = idDetalle;
        this.unidades = unidades;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Float getPorcentajeSilabus() {
        return porcentajeSilabus;
    }

    public void setPorcentajeSilabus(Float porcentajeSilabus) {
        this.porcentajeSilabus = porcentajeSilabus;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public ReporteArea getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(ReporteArea idReporte) {
        this.idReporte = idReporte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetaleReporte)) {
            return false;
        }
        DetaleReporte other = (DetaleReporte) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DetaleReporte[ idDetalle=" + idDetalle + " ]";
    }
    
}
