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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "detalle_informe_asignatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleInformeAsignatura.findAll", query = "SELECT d FROM DetalleInformeAsignatura d")
    , @NamedQuery(name = "DetalleInformeAsignatura.findById", query = "SELECT d FROM DetalleInformeAsignatura d WHERE d.id = :id")
    , @NamedQuery(name = "DetalleInformeAsignatura.findByCurso", query = "SELECT d FROM DetalleInformeAsignatura d WHERE d.curso = :curso")
    , @NamedQuery(name = "DetalleInformeAsignatura.findByTotalEstudiantes", query = "SELECT d FROM DetalleInformeAsignatura d WHERE d.totalEstudiantes = :totalEstudiantes")
    , @NamedQuery(name = "DetalleInformeAsignatura.findByNPromovidos", query = "SELECT d FROM DetalleInformeAsignatura d WHERE d.nPromovidos = :nPromovidos")
    , @NamedQuery(name = "DetalleInformeAsignatura.findByNNoPromovidos", query = "SELECT d FROM DetalleInformeAsignatura d WHERE d.nNoPromovidos = :nNoPromovidos")
    , @NamedQuery(name = "DetalleInformeAsignatura.findByNDesertores", query = "SELECT d FROM DetalleInformeAsignatura d WHERE d.nDesertores = :nDesertores")
    , @NamedQuery(name = "DetalleInformeAsignatura.findByPorcentajeAprobados", query = "SELECT d FROM DetalleInformeAsignatura d WHERE d.porcentajeAprobados = :porcentajeAprobados")})
public class DetalleInformeAsignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 30)
    @Column(name = "curso")
    private String curso;
    @Column(name = "total_estudiantes")
    private Integer totalEstudiantes;
    @Column(name = "n_promovidos")
    private Integer nPromovidos;
    @Column(name = "n_no_promovidos")
    private Integer nNoPromovidos;
    @Column(name = "n_desertores")
    private Integer nDesertores;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje_aprobados")
    private Float porcentajeAprobados;
    @JoinColumn(name = "cod_informe_asignatura", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InformesAsignatura codInformeAsignatura;

    public DetalleInformeAsignatura() {
    }

    public DetalleInformeAsignatura(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Integer getTotalEstudiantes() {
        return totalEstudiantes;
    }

    public void setTotalEstudiantes(Integer totalEstudiantes) {
        this.totalEstudiantes = totalEstudiantes;
    }

    public Integer getNPromovidos() {
        return nPromovidos;
    }

    public void setNPromovidos(Integer nPromovidos) {
        this.nPromovidos = nPromovidos;
    }

    public Integer getNNoPromovidos() {
        return nNoPromovidos;
    }

    public void setNNoPromovidos(Integer nNoPromovidos) {
        this.nNoPromovidos = nNoPromovidos;
    }

    public Integer getNDesertores() {
        return nDesertores;
    }

    public void setNDesertores(Integer nDesertores) {
        this.nDesertores = nDesertores;
    }

    public Float getPorcentajeAprobados() {
        return porcentajeAprobados;
    }

    public void setPorcentajeAprobados(Float porcentajeAprobados) {
        this.porcentajeAprobados = porcentajeAprobados;
    }

    public InformesAsignatura getCodInformeAsignatura() {
        return codInformeAsignatura;
    }

    public void setCodInformeAsignatura(InformesAsignatura codInformeAsignatura) {
        this.codInformeAsignatura = codInformeAsignatura;
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
        if (!(object instanceof DetalleInformeAsignatura)) {
            return false;
        }
        DetalleInformeAsignatura other = (DetalleInformeAsignatura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DetalleInformeAsignatura[ id=" + id + " ]";
    }
    
}
