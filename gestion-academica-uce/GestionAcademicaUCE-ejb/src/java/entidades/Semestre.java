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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "semestre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Semestre.findAll", query = "SELECT s FROM Semestre s")
    , @NamedQuery(name = "Semestre.findById", query = "SELECT s FROM Semestre s WHERE s.id = :id")
    , @NamedQuery(name = "Semestre.findByNombre", query = "SELECT s FROM Semestre s WHERE s.nombre = :nombre")})
public class Semestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSemestre")
    private List<InformesAsignatura> informesAsignaturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSemestre")
    private List<Asignaturas> asignaturasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSemestre")
    private List<ReporteDocente> reporteDocenteList;
    @OneToMany(mappedBy = "codCurso")
    private List<DetalleCh> detalleChList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSemestre")
    private List<DetalleInformeArea> detalleInformeAreaList;

    public Semestre() {
    }

    public Semestre(Integer id) {
        this.id = id;
    }

    public Semestre(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<InformesAsignatura> getInformesAsignaturaList() {
        return informesAsignaturaList;
    }

    public void setInformesAsignaturaList(List<InformesAsignatura> informesAsignaturaList) {
        this.informesAsignaturaList = informesAsignaturaList;
    }

    @XmlTransient
    public List<Asignaturas> getAsignaturasList() {
        return asignaturasList;
    }

    public void setAsignaturasList(List<Asignaturas> asignaturasList) {
        this.asignaturasList = asignaturasList;
    }

    @XmlTransient
    public List<ReporteDocente> getReporteDocenteList() {
        return reporteDocenteList;
    }

    public void setReporteDocenteList(List<ReporteDocente> reporteDocenteList) {
        this.reporteDocenteList = reporteDocenteList;
    }

    @XmlTransient
    public List<DetalleCh> getDetalleChList() {
        return detalleChList;
    }

    public void setDetalleChList(List<DetalleCh> detalleChList) {
        this.detalleChList = detalleChList;
    }

    @XmlTransient
    public List<DetalleInformeArea> getDetalleInformeAreaList() {
        return detalleInformeAreaList;
    }

    public void setDetalleInformeAreaList(List<DetalleInformeArea> detalleInformeAreaList) {
        this.detalleInformeAreaList = detalleInformeAreaList;
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
        if (!(object instanceof Semestre)) {
            return false;
        }
        Semestre other = (Semestre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Semestre[ id=" + id + " ]";
    }
    
}
