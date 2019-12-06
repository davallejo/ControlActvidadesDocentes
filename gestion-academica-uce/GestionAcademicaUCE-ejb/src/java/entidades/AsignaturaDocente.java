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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "asignatura_docente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignaturaDocente.findAll", query = "SELECT a FROM AsignaturaDocente a")
    , @NamedQuery(name = "AsignaturaDocente.findById", query = "SELECT a FROM AsignaturaDocente a WHERE a.id = :id")})
public class AsignaturaDocente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "cod_asignatura", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Asignaturas codAsignatura;
    @JoinColumn(name = "cod_periodo", referencedColumnName = "id")
    @ManyToOne
    private Periodo codPeriodo;
    @JoinColumn(name = "cod_docente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios codDocente;

    public AsignaturaDocente() {
    }

    public AsignaturaDocente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Asignaturas getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(Asignaturas codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public Periodo getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Periodo codPeriodo) {
        this.codPeriodo = codPeriodo;
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
        if (!(object instanceof AsignaturaDocente)) {
            return false;
        }
        AsignaturaDocente other = (AsignaturaDocente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.AsignaturaDocente[ id=" + id + " ]";
    }
    
}
