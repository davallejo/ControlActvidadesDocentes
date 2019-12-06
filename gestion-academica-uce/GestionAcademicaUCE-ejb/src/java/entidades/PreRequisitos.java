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
@Table(name = "pre_requisitos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreRequisitos.findAll", query = "SELECT p FROM PreRequisitos p")
    , @NamedQuery(name = "PreRequisitos.findByIdPreRequisito", query = "SELECT p FROM PreRequisitos p WHERE p.idPreRequisito = :idPreRequisito")})
public class PreRequisitos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pre_requisito")
    private Integer idPreRequisito;
    @JoinColumn(name = "cod_asignatura_pre", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Asignaturas codAsignaturaPre;
    @JoinColumn(name = "cod_asignatura", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Asignaturas codAsignatura;

    public PreRequisitos() {
    }

    public PreRequisitos(Integer idPreRequisito) {
        this.idPreRequisito = idPreRequisito;
    }

    public Integer getIdPreRequisito() {
        return idPreRequisito;
    }

    public void setIdPreRequisito(Integer idPreRequisito) {
        this.idPreRequisito = idPreRequisito;
    }

    public Asignaturas getCodAsignaturaPre() {
        return codAsignaturaPre;
    }

    public void setCodAsignaturaPre(Asignaturas codAsignaturaPre) {
        this.codAsignaturaPre = codAsignaturaPre;
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
        hash += (idPreRequisito != null ? idPreRequisito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreRequisitos)) {
            return false;
        }
        PreRequisitos other = (PreRequisitos) object;
        if ((this.idPreRequisito == null && other.idPreRequisito != null) || (this.idPreRequisito != null && !this.idPreRequisito.equals(other.idPreRequisito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PreRequisitos[ idPreRequisito=" + idPreRequisito + " ]";
    }
    
}
