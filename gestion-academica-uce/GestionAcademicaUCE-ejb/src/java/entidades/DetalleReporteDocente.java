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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "detalle_reporte_docente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleReporteDocente.findAll", query = "SELECT d FROM DetalleReporteDocente d")
    , @NamedQuery(name = "DetalleReporteDocente.findById", query = "SELECT d FROM DetalleReporteDocente d WHERE d.id = :id")
    , @NamedQuery(name = "DetalleReporteDocente.findByNEstudiates1620", query = "SELECT d FROM DetalleReporteDocente d WHERE d.nEstudiates1620 = :nEstudiates1620")
    , @NamedQuery(name = "DetalleReporteDocente.findByNEstudiantes1216", query = "SELECT d FROM DetalleReporteDocente d WHERE d.nEstudiantes1216 = :nEstudiantes1216")
    , @NamedQuery(name = "DetalleReporteDocente.findByNEstudiantesMenor12", query = "SELECT d FROM DetalleReporteDocente d WHERE d.nEstudiantesMenor12 = :nEstudiantesMenor12")
    , @NamedQuery(name = "DetalleReporteDocente.findByTotalEstudiantes", query = "SELECT d FROM DetalleReporteDocente d WHERE d.totalEstudiantes = :totalEstudiantes")
    , @NamedQuery(name = "DetalleReporteDocente.findByAsistencias", query = "SELECT d FROM DetalleReporteDocente d WHERE d.asistencias = :asistencias")})
public class DetalleReporteDocente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "n_estudiates16_20")
    private Integer nEstudiates1620;
    @Column(name = "n_estudiantes12_16")
    private Integer nEstudiantes1216;
    @Column(name = "n_estudiantes_menor12")
    private Integer nEstudiantesMenor12;
    @Column(name = "total_estudiantes")
    private Integer totalEstudiantes;
    @Column(name = "asistencias")
    private Integer asistencias;
    @JoinColumn(name = "cod_reporte_docente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ReporteDocente codReporteDocente;

    public DetalleReporteDocente() {
    }

    public DetalleReporteDocente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNEstudiates1620() {
        return nEstudiates1620;
    }

    public void setNEstudiates1620(Integer nEstudiates1620) {
        this.nEstudiates1620 = nEstudiates1620;
    }

    public Integer getNEstudiantes1216() {
        return nEstudiantes1216;
    }

    public void setNEstudiantes1216(Integer nEstudiantes1216) {
        this.nEstudiantes1216 = nEstudiantes1216;
    }

    public Integer getNEstudiantesMenor12() {
        return nEstudiantesMenor12;
    }

    public void setNEstudiantesMenor12(Integer nEstudiantesMenor12) {
        this.nEstudiantesMenor12 = nEstudiantesMenor12;
    }

    public Integer getTotalEstudiantes() {
        return totalEstudiantes;
    }

    public void setTotalEstudiantes(Integer totalEstudiantes) {
        this.totalEstudiantes = totalEstudiantes;
    }

    public Integer getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(Integer asistencias) {
        this.asistencias = asistencias;
    }

    public ReporteDocente getCodReporteDocente() {
        return codReporteDocente;
    }

    public void setCodReporteDocente(ReporteDocente codReporteDocente) {
        this.codReporteDocente = codReporteDocente;
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
        if (!(object instanceof DetalleReporteDocente)) {
            return false;
        }
        DetalleReporteDocente other = (DetalleReporteDocente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DetalleReporteDocente[ id=" + id + " ]";
    }
    
}
