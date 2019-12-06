/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "detalle_ch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCh.findAll", query = "SELECT d FROM DetalleCh d")
    , @NamedQuery(name = "DetalleCh.findById", query = "SELECT d FROM DetalleCh d WHERE d.id = :id")
    , @NamedQuery(name = "DetalleCh.findByActividad", query = "SELECT d FROM DetalleCh d WHERE d.actividad = :actividad")
    , @NamedQuery(name = "DetalleCh.findByEvidencia", query = "SELECT d FROM DetalleCh d WHERE d.evidencia = :evidencia")
    , @NamedQuery(name = "DetalleCh.findByTutor", query = "SELECT d FROM DetalleCh d WHERE d.tutor = :tutor")
    , @NamedQuery(name = "DetalleCh.findByObservacion", query = "SELECT d FROM DetalleCh d WHERE d.observacion = :observacion")})
public class DetalleCh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "actividad")
    private String actividad;
    @Size(max = 2147483647)
    @Column(name = "evidencia")
    private String evidencia;
    @Size(max = 2147483647)
    @Column(name = "tutor")
    private String tutor;
    @Size(max = 2147483647)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "cod_materia", referencedColumnName = "id")
    @ManyToOne
    private Asignaturas codMateria;
    @JoinColumn(name = "cod_aula", referencedColumnName = "id")
    @ManyToOne
    private Aula codAula;
    @JoinColumn(name = "cod_carga_horaria", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private CargaHoraria codCargaHoraria;
    @JoinColumn(name = "cod_proyecto", referencedColumnName = "id")
    @ManyToOne
    private Proyectos codProyecto;
    @JoinColumn(name = "cod_curso", referencedColumnName = "id")
    @ManyToOne
    private Semestre codCurso;
    @JoinColumn(name = "cod_estudiante", referencedColumnName = "id")
    @ManyToOne
    private Usuarios codEstudiante;

    public DetalleCh() {
    }

    public DetalleCh(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(String evidencia) {
        this.evidencia = evidencia;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Asignaturas getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(Asignaturas codMateria) {
        this.codMateria = codMateria;
    }

    public Aula getCodAula() {
        return codAula;
    }

    public void setCodAula(Aula codAula) {
        this.codAula = codAula;
    }

    public CargaHoraria getCodCargaHoraria() {
        return codCargaHoraria;
    }

    public void setCodCargaHoraria(CargaHoraria codCargaHoraria) {
        this.codCargaHoraria = codCargaHoraria;
    }

    public Proyectos getCodProyecto() {
        return codProyecto;
    }

    public void setCodProyecto(Proyectos codProyecto) {
        this.codProyecto = codProyecto;
    }

    public Semestre getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Semestre codCurso) {
        this.codCurso = codCurso;
    }

    public Usuarios getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(Usuarios codEstudiante) {
        this.codEstudiante = codEstudiante;
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
        if (!(object instanceof DetalleCh)) {
            return false;
        }
        DetalleCh other = (DetalleCh) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DetalleCh[ id=" + id + " ]";
    }
    
}
