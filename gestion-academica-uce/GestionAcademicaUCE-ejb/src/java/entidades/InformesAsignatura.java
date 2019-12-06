/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "informes_asignatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InformesAsignatura.findAll", query = "SELECT i FROM InformesAsignatura i")
    , @NamedQuery(name = "InformesAsignatura.findById", query = "SELECT i FROM InformesAsignatura i WHERE i.id = :id")
    , @NamedQuery(name = "InformesAsignatura.findByFecha", query = "SELECT i FROM InformesAsignatura i WHERE i.fecha = :fecha")
    , @NamedQuery(name = "InformesAsignatura.findByObservaciones", query = "SELECT i FROM InformesAsignatura i WHERE i.observaciones = :observaciones")})
public class InformesAsignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 2147483647)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "cod_asignatura", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Asignaturas codAsignatura;
    @JoinColumn(name = "cod_periodo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Periodo codPeriodo;
    @JoinColumn(name = "cod_semestre", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Semestre codSemestre;
    @JoinColumn(name = "cod_coordinador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios codCoordinador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codInformeAsignatura")
    private List<DetalleInformeAsignatura> detalleInformeAsignaturaList;

    public InformesAsignatura() {
    }

    public InformesAsignatura(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Asignaturas getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(Asignaturas codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public Periodo getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Periodo codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public Semestre getCodSemestre() {
        return codSemestre;
    }

    public void setCodSemestre(Semestre codSemestre) {
        this.codSemestre = codSemestre;
    }

    public Usuarios getCodCoordinador() {
        return codCoordinador;
    }

    public void setCodCoordinador(Usuarios codCoordinador) {
        this.codCoordinador = codCoordinador;
    }

    @XmlTransient
    public List<DetalleInformeAsignatura> getDetalleInformeAsignaturaList() {
        return detalleInformeAsignaturaList;
    }

    public void setDetalleInformeAsignaturaList(List<DetalleInformeAsignatura> detalleInformeAsignaturaList) {
        this.detalleInformeAsignaturaList = detalleInformeAsignaturaList;
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
        if (!(object instanceof InformesAsignatura)) {
            return false;
        }
        InformesAsignatura other = (InformesAsignatura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.InformesAsignatura[ id=" + id + " ]";
    }
    
}
