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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "detalle_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleProyecto.findAll", query = "SELECT d FROM DetalleProyecto d")
    , @NamedQuery(name = "DetalleProyecto.findById", query = "SELECT d FROM DetalleProyecto d WHERE d.id = :id")
    , @NamedQuery(name = "DetalleProyecto.findByDescripcionAvance", query = "SELECT d FROM DetalleProyecto d WHERE d.descripcionAvance = :descripcionAvance")
    , @NamedQuery(name = "DetalleProyecto.findByEvidencia", query = "SELECT d FROM DetalleProyecto d WHERE d.evidencia = :evidencia")
    , @NamedQuery(name = "DetalleProyecto.findByAvanceReal", query = "SELECT d FROM DetalleProyecto d WHERE d.avanceReal = :avanceReal")
    , @NamedQuery(name = "DetalleProyecto.findByAvanceEstimado", query = "SELECT d FROM DetalleProyecto d WHERE d.avanceEstimado = :avanceEstimado")})
public class DetalleProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "descripcion_avance")
    private String descripcionAvance;
    @Size(max = 256)
    @Column(name = "evidencia")
    private String evidencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "avance_real")
    private Float avanceReal;
    @Column(name = "avance_estimado")
    private Float avanceEstimado;
    @JoinColumn(name = "cod_proyecto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proyectos codProyecto;

    public DetalleProyecto() {
    }

    public DetalleProyecto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcionAvance() {
        return descripcionAvance;
    }

    public void setDescripcionAvance(String descripcionAvance) {
        this.descripcionAvance = descripcionAvance;
    }

    public String getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(String evidencia) {
        this.evidencia = evidencia;
    }

    public Float getAvanceReal() {
        return avanceReal;
    }

    public void setAvanceReal(Float avanceReal) {
        this.avanceReal = avanceReal;
    }

    public Float getAvanceEstimado() {
        return avanceEstimado;
    }

    public void setAvanceEstimado(Float avanceEstimado) {
        this.avanceEstimado = avanceEstimado;
    }

    public Proyectos getCodProyecto() {
        return codProyecto;
    }

    public void setCodProyecto(Proyectos codProyecto) {
        this.codProyecto = codProyecto;
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
        if (!(object instanceof DetalleProyecto)) {
            return false;
        }
        DetalleProyecto other = (DetalleProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DetalleProyecto[ id=" + id + " ]";
    }
    
}
