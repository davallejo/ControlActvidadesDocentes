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
@Table(name = "reporte_docente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReporteDocente.findAll", query = "SELECT r FROM ReporteDocente r")
    , @NamedQuery(name = "ReporteDocente.findById", query = "SELECT r FROM ReporteDocente r WHERE r.id = :id")
    , @NamedQuery(name = "ReporteDocente.findByFecha", query = "SELECT r FROM ReporteDocente r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "ReporteDocente.findByCurso", query = "SELECT r FROM ReporteDocente r WHERE r.curso = :curso")})
public class ReporteDocente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 50)
    @Column(name = "curso")
    private String curso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codReporteDocente")
    private List<DetalleReporteDocente> detalleReporteDocenteList;
    @JoinColumn(name = "cod_asignatura", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Asignaturas codAsignatura;
    @JoinColumn(name = "cod_periodo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Periodo codPeriodo;
    @JoinColumn(name = "cod_semestre", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Semestre codSemestre;
    @JoinColumn(name = "cod_docente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios codDocente;

    public ReporteDocente() {
    }

    public ReporteDocente(Integer id) {
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @XmlTransient
    public List<DetalleReporteDocente> getDetalleReporteDocenteList() {
        return detalleReporteDocenteList;
    }

    public void setDetalleReporteDocenteList(List<DetalleReporteDocente> detalleReporteDocenteList) {
        this.detalleReporteDocenteList = detalleReporteDocenteList;
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

    public Usuarios getCodDocente() {
        return codDocente;
    }

    public void setCodDocente(Usuarios codDocente) {
        this.codDocente = codDocente;
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
        if (!(object instanceof ReporteDocente)) {
            return false;
        }
        ReporteDocente other = (ReporteDocente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ReporteDocente[ id=" + id + " ]";
    }
    
}
