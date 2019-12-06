/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "coordinador_asignatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoordinadorAsignatura.findAll", query = "SELECT c FROM CoordinadorAsignatura c")
    , @NamedQuery(name = "CoordinadorAsignatura.findById", query = "SELECT c FROM CoordinadorAsignatura c WHERE c.id = :id")})
public class CoordinadorAsignatura implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCoordinadorAsignatura")
    private List<CabeceraReunionAs> cabeceraReunionAsList;

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
    @JoinColumn(name = "cod_coordinador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios codCoordinador;

    public CoordinadorAsignatura() {
         codAsignatura = new Asignaturas();
        codPeriodo = new Periodo();
        codCoordinador = new Usuarios();
    
    }

    public CoordinadorAsignatura(Integer id) {
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

    public Usuarios getCodCoordinador() {
        return codCoordinador;
    }

    public void setCodCoordinador(Usuarios codCoordinador) {
        this.codCoordinador = codCoordinador;
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
        if (!(object instanceof CoordinadorAsignatura)) {
            return false;
        }
        CoordinadorAsignatura other = (CoordinadorAsignatura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CoordinadorAsignatura[ id=" + id + " ]";
    }

    @XmlTransient
    public List<CabeceraReunionAs> getCabeceraReunionAsList() {
        return cabeceraReunionAsList;
    }

    public void setCabeceraReunionAsList(List<CabeceraReunionAs> cabeceraReunionAsList) {
        this.cabeceraReunionAsList = cabeceraReunionAsList;
    }
    
}