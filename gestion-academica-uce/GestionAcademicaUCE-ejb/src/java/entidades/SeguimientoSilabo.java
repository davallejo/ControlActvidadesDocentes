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
@Table(name = "seguimiento_silabo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeguimientoSilabo.findAll", query = "SELECT s FROM SeguimientoSilabo s")
    , @NamedQuery(name = "SeguimientoSilabo.findByObservacionDocente", query = "SELECT s FROM SeguimientoSilabo s WHERE s.observacionDocente = :observacionDocente")
    , @NamedQuery(name = "SeguimientoSilabo.findByEstadoContenido", query = "SELECT s FROM SeguimientoSilabo s WHERE s.estadoContenido = :estadoContenido")
    , @NamedQuery(name = "SeguimientoSilabo.findByConfirmacionEstudiante", query = "SELECT s FROM SeguimientoSilabo s WHERE s.confirmacionEstudiante = :confirmacionEstudiante")
    , @NamedQuery(name = "SeguimientoSilabo.findByObservacionesEstudiante", query = "SELECT s FROM SeguimientoSilabo s WHERE s.observacionesEstudiante = :observacionesEstudiante")
    , @NamedQuery(name = "SeguimientoSilabo.findById", query = "SELECT s FROM SeguimientoSilabo s WHERE s.id = :id")
    , @NamedQuery(name = "SeguimientoSilabo.findByFechaDocente", query = "SELECT s FROM SeguimientoSilabo s WHERE s.fechaDocente = :fechaDocente")
    , @NamedQuery(name = "SeguimientoSilabo.findByFechaEstudiante", query = "SELECT s FROM SeguimientoSilabo s WHERE s.fechaEstudiante = :fechaEstudiante")
    , @NamedQuery(name = "SeguimientoSilabo.findByHoraInicio", query = "SELECT s FROM SeguimientoSilabo s WHERE s.horaInicio = :horaInicio")
    , @NamedQuery(name = "SeguimientoSilabo.findByHoraFin", query = "SELECT s FROM SeguimientoSilabo s WHERE s.horaFin = :horaFin")})
public class SeguimientoSilabo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 2147483647)
    @Column(name = "observacion_docente")
    private String observacionDocente;
    @Size(max = 50)
    @Column(name = "estado_contenido")
    private String estadoContenido;
    @Column(name = "confirmacion_estudiante")
    private Boolean confirmacionEstudiante;
    @Size(max = 2147483647)
    @Column(name = "observaciones_estudiante")
    private String observacionesEstudiante;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "fecha_docente")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDocente;
    @Column(name = "fecha_estudiante")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEstudiante;
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicio;
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFin;
    @JoinColumn(name = "cod_asignatura", referencedColumnName = "id")
    @ManyToOne
    private Asignaturas codAsignatura;
    @JoinColumn(name = "cod_aula", referencedColumnName = "id")
    @ManyToOne
    private Aula codAula;
    @JoinColumn(name = "cod_contenido", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Contenidos codContenido;
    @JoinColumn(name = "cod_curso", referencedColumnName = "id")
    @ManyToOne
    private Cursos codCurso;
    @JoinColumn(name = "cod_periodo", referencedColumnName = "id")
    @ManyToOne
    private Periodo codPeriodo;
    @JoinColumn(name = "cod_silabo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Silabos codSilabo;
    @JoinColumn(name = "cod_unidad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unidades codUnidad;
    @JoinColumn(name = "cod_docente", referencedColumnName = "id")
    @ManyToOne
    private Usuarios codDocente;
    @JoinColumn(name = "cod_estudiante", referencedColumnName = "id")
    @ManyToOne
    private Usuarios codEstudiante;

    public SeguimientoSilabo() {
    }

    public SeguimientoSilabo(Long id) {
        this.id = id;
    }

    public String getObservacionDocente() {
        return observacionDocente;
    }

    public void setObservacionDocente(String observacionDocente) {
        this.observacionDocente = observacionDocente;
    }

    public String getEstadoContenido() {
        return estadoContenido;
    }

    public void setEstadoContenido(String estadoContenido) {
        this.estadoContenido = estadoContenido;
    }

    public Boolean getConfirmacionEstudiante() {
        return confirmacionEstudiante;
    }

    public void setConfirmacionEstudiante(Boolean confirmacionEstudiante) {
        this.confirmacionEstudiante = confirmacionEstudiante;
    }

    public String getObservacionesEstudiante() {
        return observacionesEstudiante;
    }

    public void setObservacionesEstudiante(String observacionesEstudiante) {
        this.observacionesEstudiante = observacionesEstudiante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaDocente() {
        return fechaDocente;
    }

    public void setFechaDocente(Date fechaDocente) {
        this.fechaDocente = fechaDocente;
    }

    public Date getFechaEstudiante() {
        return fechaEstudiante;
    }

    public void setFechaEstudiante(Date fechaEstudiante) {
        this.fechaEstudiante = fechaEstudiante;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Asignaturas getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(Asignaturas codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public Aula getCodAula() {
        return codAula;
    }

    public void setCodAula(Aula codAula) {
        this.codAula = codAula;
    }

    public Contenidos getCodContenido() {
        return codContenido;
    }

    public void setCodContenido(Contenidos codContenido) {
        this.codContenido = codContenido;
    }

    public Cursos getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Cursos codCurso) {
        this.codCurso = codCurso;
    }

    public Periodo getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Periodo codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public Silabos getCodSilabo() {
        return codSilabo;
    }

    public void setCodSilabo(Silabos codSilabo) {
        this.codSilabo = codSilabo;
    }

    public Unidades getCodUnidad() {
        return codUnidad;
    }

    public void setCodUnidad(Unidades codUnidad) {
        this.codUnidad = codUnidad;
    }

    public Usuarios getCodDocente() {
        return codDocente;
    }

    public void setCodDocente(Usuarios codDocente) {
        this.codDocente = codDocente;
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
        if (!(object instanceof SeguimientoSilabo)) {
            return false;
        }
        SeguimientoSilabo other = (SeguimientoSilabo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.SeguimientoSilabo[ id=" + id + " ]";
    }
    
}
