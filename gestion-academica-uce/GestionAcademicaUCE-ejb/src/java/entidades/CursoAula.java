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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administracion
 */
@Entity
@Table(name = "curso_aula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CursoAula.findAll", query = "SELECT c FROM CursoAula c")
    , @NamedQuery(name = "CursoAula.findById", query = "SELECT c FROM CursoAula c WHERE c.id = :id")
    , @NamedQuery(name = "CursoAula.findByNomenclatura", query = "SELECT c FROM CursoAula c WHERE c.nomenclatura = :nomenclatura")
    , @NamedQuery(name = "CursoAula.findByAula", query = "SELECT c FROM CursoAula c WHERE c.aula = :aula")
    , @NamedQuery(name = "CursoAula.findByPeriodo", query = "SELECT c FROM CursoAula c WHERE c.periodo = :periodo")})
public class CursoAula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "nomenclatura")
    private String nomenclatura;
    @Column(name = "aula")
    private Integer aula;
    @Size(max = 80)
    @Column(name = "periodo")
    private String periodo;

    public CursoAula() {
    }

    public CursoAula(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    public Integer getAula() {
        return aula;
    }

    public void setAula(Integer aula) {
        this.aula = aula;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
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
        if (!(object instanceof CursoAula)) {
            return false;
        }
        CursoAula other = (CursoAula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CursoAula[ id=" + id + " ]";
    }
    
}
