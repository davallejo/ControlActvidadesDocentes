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
@Table(name = "co_requisitos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoRequisitos.findAll", query = "SELECT c FROM CoRequisitos c")
    , @NamedQuery(name = "CoRequisitos.findById", query = "SELECT c FROM CoRequisitos c WHERE c.id = :id")})
public class CoRequisitos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "cod_asignatura_co", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Asignaturas codAsignaturaCo;
    @JoinColumn(name = "cod_asignatura", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Asignaturas codAsignatura;

    public CoRequisitos() {
    }

    public CoRequisitos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Asignaturas getCodAsignaturaCo() {
        return codAsignaturaCo;
    }

    public void setCodAsignaturaCo(Asignaturas codAsignaturaCo) {
        this.codAsignaturaCo = codAsignaturaCo;
    }

    public Asignaturas getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(Asignaturas codAsignatura) {
        this.codAsignatura = codAsignatura;
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
        if (!(object instanceof CoRequisitos)) {
            return false;
        }
        CoRequisitos other = (CoRequisitos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CoRequisitos[ id=" + id + " ]";
    }
    
}
