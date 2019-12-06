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
@Table(name = "contenidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contenidos.findAll", query = "SELECT c FROM Contenidos c")
    , @NamedQuery(name = "Contenidos.findById", query = "SELECT c FROM Contenidos c WHERE c.id = :id")
    , @NamedQuery(name = "Contenidos.findByNItem", query = "SELECT c FROM Contenidos c WHERE c.nItem = :nItem")
    , @NamedQuery(name = "Contenidos.findByDescripcion", query = "SELECT c FROM Contenidos c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Contenidos.findByActividades", query = "SELECT c FROM Contenidos c WHERE c.actividades = :actividades")
    , @NamedQuery(name = "Contenidos.findByMecanismosEval", query = "SELECT c FROM Contenidos c WHERE c.mecanismosEval = :mecanismosEval")
    , @NamedQuery(name = "Contenidos.findBySesion", query = "SELECT c FROM Contenidos c WHERE c.sesion = :sesion")
    , @NamedQuery(name = "Contenidos.findByHoraClase", query = "SELECT c FROM Contenidos c WHERE c.horaClase = :horaClase")
    , @NamedQuery(name = "Contenidos.findByPorcentaje", query = "SELECT c FROM Contenidos c WHERE c.porcentaje = :porcentaje")})
public class Contenidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_item")
    private int nItem;
    @Size(max = 250)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 2147483647)
    @Column(name = "actividades")
    private String actividades;
    @Size(max = 2147483647)
    @Column(name = "mecanismos_eval")
    private String mecanismosEval;
    @Column(name = "sesion")
    private Integer sesion;
    @Column(name = "hora_clase")
    @Temporal(TemporalType.DATE)
    private Date horaClase;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje")
    private Double porcentaje;
    @JoinColumn(name = "cod_unidad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unidades codUnidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codContenido")
    private List<SeguimientoSilabo> seguimientoSilaboList;

    public Contenidos() {
    }

    public Contenidos(Integer id) {
        this.id = id;
    }

    public Contenidos(Integer id, int nItem) {
        this.id = id;
        this.nItem = nItem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNItem() {
        return nItem;
    }

    public void setNItem(int nItem) {
        this.nItem = nItem;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public String getMecanismosEval() {
        return mecanismosEval;
    }

    public void setMecanismosEval(String mecanismosEval) {
        this.mecanismosEval = mecanismosEval;
    }

    public Integer getSesion() {
        return sesion;
    }

    public void setSesion(Integer sesion) {
        this.sesion = sesion;
    }

    public Date getHoraClase() {
        return horaClase;
    }

    public void setHoraClase(Date horaClase) {
        this.horaClase = horaClase;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Unidades getCodUnidad() {
        return codUnidad;
    }

    public void setCodUnidad(Unidades codUnidad) {
        this.codUnidad = codUnidad;
    }

    @XmlTransient
    public List<SeguimientoSilabo> getSeguimientoSilaboList() {
        return seguimientoSilaboList;
    }

    public void setSeguimientoSilaboList(List<SeguimientoSilabo> seguimientoSilaboList) {
        this.seguimientoSilaboList = seguimientoSilaboList;
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
        if (!(object instanceof Contenidos)) {
            return false;
        }
        Contenidos other = (Contenidos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Contenidos[ id=" + id + " ]";
    }
    
}
