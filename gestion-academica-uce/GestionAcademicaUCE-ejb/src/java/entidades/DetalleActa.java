/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "detalle_acta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleActa.findAll", query = "SELECT d FROM DetalleActa d")
    , @NamedQuery(name = "DetalleActa.findByIdDetalle", query = "SELECT d FROM DetalleActa d WHERE d.idDetalle = :idDetalle")
    , @NamedQuery(name = "DetalleActa.findByAsistencia", query = "SELECT d FROM DetalleActa d WHERE d.asistencia = :asistencia")
    , @NamedQuery(name = "DetalleActa.findByObservaciones", query = "SELECT d FROM DetalleActa d WHERE d.observaciones = :observaciones")
    , @NamedQuery(name = "DetalleActa.findByFecha", query = "SELECT d FROM DetalleActa d WHERE d.fecha = :fecha")})
public class DetalleActa implements Serializable {

    @Lob
    @Column(name = "firma_coordinador")
    private byte[] firmaCoordinador;
    @Lob
    @Column(name = "anexos")
    private byte[] anexos;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle")
    private Integer idDetalle;
    @Column(name = "asistencia")
    private Boolean asistencia;
    @Size(max = 200)
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_reunion", referencedColumnName = "id_reunion")
    @ManyToOne(optional = false)
    private CabeceraReunion idReunion;

    public DetalleActa() {
    }

    public DetalleActa(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Boolean getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Boolean asistencia) {
        this.asistencia = asistencia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public byte[] getFirmaCoordinador() {
        return firmaCoordinador;
    }

    public void setFirmaCoordinador(byte[] firmaCoordinador) {
        this.firmaCoordinador = firmaCoordinador;
    }


    public CabeceraReunion getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(CabeceraReunion idReunion) {
        this.idReunion = idReunion;
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
        if (!(object instanceof DetalleActa)) {
            return false;
        }
        DetalleActa other = (DetalleActa) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DetalleActa[ idDetalle=" + idDetalle + " ]";
    }

   

    public byte[] getAnexos() {
        return anexos;
    }

    public void setAnexos(byte[] anexos) {
        this.anexos = anexos;
    }
    
}
