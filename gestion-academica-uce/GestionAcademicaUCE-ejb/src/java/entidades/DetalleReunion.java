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
@Table(name = "detalle_reunion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleReunion.findAll", query = "SELECT d FROM DetalleReunion d")
    , @NamedQuery(name = "DetalleReunion.findByIdDetalle", query = "SELECT d FROM DetalleReunion d WHERE d.idDetalle = :idDetalle")
    , @NamedQuery(name = "DetalleReunion.findByAsunto", query = "SELECT d FROM DetalleReunion d WHERE d.asunto = :asunto")
    , @NamedQuery(name = "DetalleReunion.findByHoraInicio", query = "SELECT d FROM DetalleReunion d WHERE d.horaInicio = :horaInicio")
    , @NamedQuery(name = "DetalleReunion.findByHoraFin", query = "SELECT d FROM DetalleReunion d WHERE d.horaFin = :horaFin")
    , @NamedQuery(name = "DetalleReunion.findByFecha", query = "SELECT d FROM DetalleReunion d WHERE d.fecha = :fecha")})
public class DetalleReunion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle")
    private Integer idDetalle;
    @Size(max = 60)
    @Column(name = "asunto")
    private String asunto;
    @Size(max = 60)
    @Column(name = "hora_inicio")
    private String horaInicio;
    @Size(max = 60)
    @Column(name = "hora_fin")
    private String horaFin;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_reunion", referencedColumnName = "id_reunion")
    @ManyToOne(optional = false)
    private CabeceraReunion idReunion;

    public DetalleReunion() {
        
        idReunion = new CabeceraReunion();
    }

    public DetalleReunion(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        if (!(object instanceof DetalleReunion)) {
            return false;
        }
        DetalleReunion other = (DetalleReunion) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DetalleReunion[ idDetalle=" + idDetalle + " ]";
    }
    
}
