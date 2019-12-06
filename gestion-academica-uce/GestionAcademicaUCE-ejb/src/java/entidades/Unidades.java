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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "unidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidades.findAll", query = "SELECT u FROM Unidades u")
    , @NamedQuery(name = "Unidades.findById", query = "SELECT u FROM Unidades u WHERE u.id = :id")
    , @NamedQuery(name = "Unidades.findByNombre", query = "SELECT u FROM Unidades u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Unidades.findByObjetivo", query = "SELECT u FROM Unidades u WHERE u.objetivo = :objetivo")
    , @NamedQuery(name = "Unidades.findByResAprendizaje", query = "SELECT u FROM Unidades u WHERE u.resAprendizaje = :resAprendizaje")
    , @NamedQuery(name = "Unidades.findByNhAprendizajeTeorico", query = "SELECT u FROM Unidades u WHERE u.nhAprendizajeTeorico = :nhAprendizajeTeorico")
    , @NamedQuery(name = "Unidades.findByNhPracticasLab", query = "SELECT u FROM Unidades u WHERE u.nhPracticasLab = :nhPracticasLab")
    , @NamedQuery(name = "Unidades.findByNhTutoriaPresencial", query = "SELECT u FROM Unidades u WHERE u.nhTutoriaPresencial = :nhTutoriaPresencial")
    , @NamedQuery(name = "Unidades.findByNhTutoriasVirtual", query = "SELECT u FROM Unidades u WHERE u.nhTutoriasVirtual = :nhTutoriasVirtual")
    , @NamedQuery(name = "Unidades.findByNhTrabajoAutonomo", query = "SELECT u FROM Unidades u WHERE u.nhTrabajoAutonomo = :nhTrabajoAutonomo")
    , @NamedQuery(name = "Unidades.findByMetodologiaAprendizaje", query = "SELECT u FROM Unidades u WHERE u.metodologiaAprendizaje = :metodologiaAprendizaje")
    , @NamedQuery(name = "Unidades.findByRecursosDidactivos", query = "SELECT u FROM Unidades u WHERE u.recursosDidactivos = :recursosDidactivos")
    , @NamedQuery(name = "Unidades.findByEvidAprendizaje", query = "SELECT u FROM Unidades u WHERE u.evidAprendizaje = :evidAprendizaje")
    , @NamedQuery(name = "Unidades.findByNumeral", query = "SELECT u FROM Unidades u WHERE u.numeral = :numeral")
    , @NamedQuery(name = "Unidades.findByPorcentaje", query = "SELECT u FROM Unidades u WHERE u.porcentaje = :porcentaje")})
public class Unidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "objetivo")
    private String objetivo;
    @Size(max = 2147483647)
    @Column(name = "res_aprendizaje")
    private String resAprendizaje;
    @Column(name = "nh_aprendizaje_teorico")
    private Integer nhAprendizajeTeorico;
    @Column(name = "nh_practicas_lab")
    private Integer nhPracticasLab;
    @Column(name = "nh_tutoria_presencial")
    private Integer nhTutoriaPresencial;
    @Column(name = "nh_tutorias_virtual")
    private Integer nhTutoriasVirtual;
    @Column(name = "nh_trabajo_autonomo")
    private Integer nhTrabajoAutonomo;
    @Size(max = 2147483647)
    @Column(name = "metodologia_aprendizaje")
    private String metodologiaAprendizaje;
    @Size(max = 2147483647)
    @Column(name = "recursos_didactivos")
    private String recursosDidactivos;
    @Size(max = 2147483647)
    @Column(name = "evid_aprendizaje")
    private String evidAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeral")
    private int numeral;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje")
    private Double porcentaje;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codUnidad")
    private List<Contenidos> contenidosList;
    @JoinColumn(name = "cod_silabo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Silabos codSilabo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codUnidad")
    private List<SeguimientoSilabo> seguimientoSilaboList;

    public Unidades() {
    }

    public Unidades(Integer id) {
        this.id = id;
    }

    public Unidades(Integer id, String nombre, int numeral) {
        this.id = id;
        this.nombre = nombre;
        this.numeral = numeral;
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

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getResAprendizaje() {
        return resAprendizaje;
    }

    public void setResAprendizaje(String resAprendizaje) {
        this.resAprendizaje = resAprendizaje;
    }

    public Integer getNhAprendizajeTeorico() {
        return nhAprendizajeTeorico;
    }

    public void setNhAprendizajeTeorico(Integer nhAprendizajeTeorico) {
        this.nhAprendizajeTeorico = nhAprendizajeTeorico;
    }

    public Integer getNhPracticasLab() {
        return nhPracticasLab;
    }

    public void setNhPracticasLab(Integer nhPracticasLab) {
        this.nhPracticasLab = nhPracticasLab;
    }

    public Integer getNhTutoriaPresencial() {
        return nhTutoriaPresencial;
    }

    public void setNhTutoriaPresencial(Integer nhTutoriaPresencial) {
        this.nhTutoriaPresencial = nhTutoriaPresencial;
    }

    public Integer getNhTutoriasVirtual() {
        return nhTutoriasVirtual;
    }

    public void setNhTutoriasVirtual(Integer nhTutoriasVirtual) {
        this.nhTutoriasVirtual = nhTutoriasVirtual;
    }

    public Integer getNhTrabajoAutonomo() {
        return nhTrabajoAutonomo;
    }

    public void setNhTrabajoAutonomo(Integer nhTrabajoAutonomo) {
        this.nhTrabajoAutonomo = nhTrabajoAutonomo;
    }

    public String getMetodologiaAprendizaje() {
        return metodologiaAprendizaje;
    }

    public void setMetodologiaAprendizaje(String metodologiaAprendizaje) {
        this.metodologiaAprendizaje = metodologiaAprendizaje;
    }

    public String getRecursosDidactivos() {
        return recursosDidactivos;
    }

    public void setRecursosDidactivos(String recursosDidactivos) {
        this.recursosDidactivos = recursosDidactivos;
    }

    public String getEvidAprendizaje() {
        return evidAprendizaje;
    }

    public void setEvidAprendizaje(String evidAprendizaje) {
        this.evidAprendizaje = evidAprendizaje;
    }

    public int getNumeral() {
        return numeral;
    }

    public void setNumeral(int numeral) {
        this.numeral = numeral;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @XmlTransient
    public List<Contenidos> getContenidosList() {
        return contenidosList;
    }

    public void setContenidosList(List<Contenidos> contenidosList) {
        this.contenidosList = contenidosList;
    }

    public Silabos getCodSilabo() {
        return codSilabo;
    }

    public void setCodSilabo(Silabos codSilabo) {
        this.codSilabo = codSilabo;
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
        if (!(object instanceof Unidades)) {
            return false;
        }
        Unidades other = (Unidades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Unidades[ id=" + id + " ]";
    }
    
}
