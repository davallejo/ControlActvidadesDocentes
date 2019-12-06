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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "formulario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formulario.findAll", query = "SELECT f FROM Formulario f")
    , @NamedQuery(name = "Formulario.findByIdFormulario", query = "SELECT f FROM Formulario f WHERE f.idFormulario = :idFormulario")
    , @NamedQuery(name = "Formulario.findByFechaFormulario", query = "SELECT f FROM Formulario f WHERE f.fechaFormulario = :fechaFormulario")
    , @NamedQuery(name = "Formulario.findByFechaClase", query = "SELECT f FROM Formulario f WHERE f.fechaClase = :fechaClase")
    , @NamedQuery(name = "Formulario.findByRazon", query = "SELECT f FROM Formulario f WHERE f.razon = :razon")
    , @NamedQuery(name = "Formulario.findByObservacion", query = "SELECT f FROM Formulario f WHERE f.observacion = :observacion")
    , @NamedQuery(name = "Formulario.findByDocumento", query = "SELECT f FROM Formulario f WHERE f.documento = :documento")
    , @NamedQuery(name = "Formulario.findByEstado", query = "SELECT f FROM Formulario f WHERE f.estado = :estado")})
public class Formulario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_formulario")
    private Integer idFormulario;
    @Column(name = "fecha_formulario")
    @Temporal(TemporalType.DATE)
    private Date fechaFormulario;
    @Column(name = "fecha_clase")
    @Temporal(TemporalType.DATE)
    private Date fechaClase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "razon")
    private String razon;
    @Size(max = 500)
    @Column(name = "observacion")
    private String observacion;
    @Size(max = 200)
    @Column(name = "documento")
    private String documento;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumn(name = "cod_asignatura", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Asignaturas codAsignatura;
    @JoinColumn(name = "cod_carrera", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Carreras codCarrera;
    @JoinColumn(name = "cod_tramite", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tramite codTramite;
    @JoinColumn(name = "cod_solicitante", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios codSolicitante;

    public Formulario() {
    }

    public Formulario(Integer idFormulario) {
        this.idFormulario = idFormulario;
    }

    public Formulario(Integer idFormulario, String razon) {
        this.idFormulario = idFormulario;
        this.razon = razon;
    }

    public Integer getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(Integer idFormulario) {
        this.idFormulario = idFormulario;
    }

    public Date getFechaFormulario() {
        return fechaFormulario;
    }

    public void setFechaFormulario(Date fechaFormulario) {
        this.fechaFormulario = fechaFormulario;
    }

    public Date getFechaClase() {
        return fechaClase;
    }

    public void setFechaClase(Date fechaClase) {
        this.fechaClase = fechaClase;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Asignaturas getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(Asignaturas codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public Carreras getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(Carreras codCarrera) {
        this.codCarrera = codCarrera;
    }

    public Tramite getCodTramite() {
        return codTramite;
    }

    public void setCodTramite(Tramite codTramite) {
        this.codTramite = codTramite;
    }

    public Usuarios getCodSolicitante() {
        return codSolicitante;
    }

    public void setCodSolicitante(Usuarios codSolicitante) {
        this.codSolicitante = codSolicitante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormulario != null ? idFormulario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formulario)) {
            return false;
        }
        Formulario other = (Formulario) object;
        if ((this.idFormulario == null && other.idFormulario != null) || (this.idFormulario != null && !this.idFormulario.equals(other.idFormulario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Formulario[ idFormulario=" + idFormulario + " ]";
    }
    
}
