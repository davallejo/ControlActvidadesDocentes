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
@Table(name = "detalle_informe_area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleInformeArea.findAll", query = "SELECT d FROM DetalleInformeArea d")
    , @NamedQuery(name = "DetalleInformeArea.findById", query = "SELECT d FROM DetalleInformeArea d WHERE d.id = :id")
    , @NamedQuery(name = "DetalleInformeArea.findByPorcentajeSilabo", query = "SELECT d FROM DetalleInformeArea d WHERE d.porcentajeSilabo = :porcentajeSilabo")
    , @NamedQuery(name = "DetalleInformeArea.findByNUnidadesEstudiadas", query = "SELECT d FROM DetalleInformeArea d WHERE d.nUnidadesEstudiadas = :nUnidadesEstudiadas")})
public class DetalleInformeArea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje_silabo")
    private Float porcentajeSilabo;
    @Column(name = "n_unidades_estudiadas")
    private Integer nUnidadesEstudiadas;
    @JoinColumn(name = "cod_asignatura", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Asignaturas codAsignatura;
    @JoinColumn(name = "cod_informe_area", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InformesArea codInformeArea;
    @JoinColumn(name = "cod_semestre", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Semestre codSemestre;
    @JoinColumn(name = "cod_docente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios codDocente;

    public DetalleInformeArea() {
    }

    public DetalleInformeArea(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPorcentajeSilabo() {
        return porcentajeSilabo;
    }

    public void setPorcentajeSilabo(Float porcentajeSilabo) {
        this.porcentajeSilabo = porcentajeSilabo;
    }

    public Integer getNUnidadesEstudiadas() {
        return nUnidadesEstudiadas;
    }

    public void setNUnidadesEstudiadas(Integer nUnidadesEstudiadas) {
        this.nUnidadesEstudiadas = nUnidadesEstudiadas;
    }

    public Asignaturas getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(Asignaturas codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public InformesArea getCodInformeArea() {
        return codInformeArea;
    }

    public void setCodInformeArea(InformesArea codInformeArea) {
        this.codInformeArea = codInformeArea;
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
        if (!(object instanceof DetalleInformeArea)) {
            return false;
        }
        DetalleInformeArea other = (DetalleInformeArea) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DetalleInformeArea[ id=" + id + " ]";
    }
    
}
