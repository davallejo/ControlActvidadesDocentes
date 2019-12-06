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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "proyectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyectos.findAll", query = "SELECT p FROM Proyectos p")
    , @NamedQuery(name = "Proyectos.findById", query = "SELECT p FROM Proyectos p WHERE p.id = :id")
    , @NamedQuery(name = "Proyectos.findByNombre", query = "SELECT p FROM Proyectos p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proyectos.findByDescripcion", query = "SELECT p FROM Proyectos p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Proyectos.findByFechaInicial", query = "SELECT p FROM Proyectos p WHERE p.fechaInicial = :fechaInicial")
    , @NamedQuery(name = "Proyectos.findByFechaFinal", query = "SELECT p FROM Proyectos p WHERE p.fechaFinal = :fechaFinal")})
public class Proyectos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_inicial")
    @Temporal(TemporalType.DATE)
    private Date fechaInicial;
    @Column(name = "fecha_final")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProyecto")
    private List<DetalleProyecto> detalleProyectoList;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "codProyecto")
    private List<DetalleCh> detalleChList;
    @JoinColumn(name = "cod_periodo", referencedColumnName = "id")
    @ManyToOne
    private Periodo codPeriodo;
    @JoinColumn(name = "cod_tutor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios codTutor;

    public Proyectos() {
    }

    public Proyectos(Integer id) {
        this.id = id;
    }

    public Proyectos(Integer id, String nombre) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @XmlTransient
    public List<DetalleProyecto> getDetalleProyectoList() {
        return detalleProyectoList;
    }

    public void setDetalleProyectoList(List<DetalleProyecto> detalleProyectoList) {
        this.detalleProyectoList = detalleProyectoList;
    }

    @XmlTransient
    public List<DetalleCh> getDetalleChList() {
        return detalleChList;
    }

    public void setDetalleChList(List<DetalleCh> detalleChList) {
        this.detalleChList = detalleChList;
    }

    public Periodo getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Periodo codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public Usuarios getCodTutor() {
        return codTutor;
    }

    public void setCodTutor(Usuarios codTutor) {
        this.codTutor = codTutor;
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
        if (!(object instanceof Proyectos)) {
            return false;
        }
        Proyectos other = (Proyectos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Proyectos[ id=" + id + " ]";
    }
    
}
