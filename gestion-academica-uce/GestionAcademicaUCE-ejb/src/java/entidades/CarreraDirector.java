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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "carrera_director")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarreraDirector.findAll", query = "SELECT c FROM CarreraDirector c")
    , @NamedQuery(name = "CarreraDirector.findById", query = "SELECT c FROM CarreraDirector c WHERE c.id = :id")
    , @NamedQuery(name = "CarreraDirector.findByFechaInicio", query = "SELECT c FROM CarreraDirector c WHERE c.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "CarreraDirector.findByFechaFin", query = "SELECT c FROM CarreraDirector c WHERE c.fechaFin = :fechaFin")})
public class CarreraDirector implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @JoinColumn(name = "cod_carrera", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Carreras codCarrera;
    @JoinColumn(name = "cod_periodo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Periodo codPeriodo;
    @JoinColumn(name = "cod_director", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios codDirector;

    public CarreraDirector() {
    }

    public CarreraDirector(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Carreras getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(Carreras codCarrera) {
        this.codCarrera = codCarrera;
    }

    public Periodo getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Periodo codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public Usuarios getCodDirector() {
        return codDirector;
    }

    public void setCodDirector(Usuarios codDirector) {
        this.codDirector = codDirector;
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
        if (!(object instanceof CarreraDirector)) {
            return false;
        }
        CarreraDirector other = (CarreraDirector) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CarreraDirector[ id=" + id + " ]";
    }
    
}
