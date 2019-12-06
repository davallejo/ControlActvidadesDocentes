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
@Table(name = "coordinador_area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoordinadorArea.findAll", query = "SELECT c FROM CoordinadorArea c")
    , @NamedQuery(name = "CoordinadorArea.findById", query = "SELECT c FROM CoordinadorArea c WHERE c.id = :id")})
public class CoordinadorArea implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCoordinadorArea")
    private List<ReporteArea> reporteAreaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCoordinadorArea")
    private List<CabeceraReunion> cabeceraReunionList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "cod_area", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AreaAcademica codArea;
    @JoinColumn(name = "cod_periodo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Periodo codPeriodo;
    @JoinColumn(name = "cod_coordinador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios codCoordinador;

    public CoordinadorArea() {
        codArea = new AreaAcademica();
        codPeriodo = new Periodo();
        codCoordinador = new Usuarios();
    }

    public CoordinadorArea(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AreaAcademica getCodArea() {
        return codArea;
    }

    public void setCodArea(AreaAcademica codArea) {
        this.codArea = codArea;
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
        if (!(object instanceof CoordinadorArea)) {
            return false;
        }
        CoordinadorArea other = (CoordinadorArea) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CoordinadorArea[ id=" + id + " ]";
    }

    @XmlTransient
    public List<ReporteArea> getReporteAreaList() {
        return reporteAreaList;
    }

    public void setReporteAreaList(List<ReporteArea> reporteAreaList) {
        this.reporteAreaList = reporteAreaList;
    }

    @XmlTransient
    public List<CabeceraReunion> getCabeceraReunionList() {
        return cabeceraReunionList;
    }

    public void setCabeceraReunionList(List<CabeceraReunion> cabeceraReunionList) {
        this.cabeceraReunionList = cabeceraReunionList;
    }
    
}