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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "silabos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Silabos.findAll", query = "SELECT s FROM Silabos s")
    , @NamedQuery(name = "Silabos.findById", query = "SELECT s FROM Silabos s WHERE s.id = :id")
    , @NamedQuery(name = "Silabos.findByNhPresencial", query = "SELECT s FROM Silabos s WHERE s.nhPresencial = :nhPresencial")
    , @NamedQuery(name = "Silabos.findByNhPracticas", query = "SELECT s FROM Silabos s WHERE s.nhPracticas = :nhPracticas")
    , @NamedQuery(name = "Silabos.findByNhtPresencial", query = "SELECT s FROM Silabos s WHERE s.nhtPresencial = :nhtPresencial")
    , @NamedQuery(name = "Silabos.findByNhtVirtual", query = "SELECT s FROM Silabos s WHERE s.nhtVirtual = :nhtVirtual")
    , @NamedQuery(name = "Silabos.findByPerfilDocenteAcadem", query = "SELECT s FROM Silabos s WHERE s.perfilDocenteAcadem = :perfilDocenteAcadem")
    , @NamedQuery(name = "Silabos.findByPerfilDocenteProf", query = "SELECT s FROM Silabos s WHERE s.perfilDocenteProf = :perfilDocenteProf")
    , @NamedQuery(name = "Silabos.findByDescripPerfilDocente", query = "SELECT s FROM Silabos s WHERE s.descripPerfilDocente = :descripPerfilDocente")
    , @NamedQuery(name = "Silabos.findByVigente", query = "SELECT s FROM Silabos s WHERE s.vigente = :vigente")
    , @NamedQuery(name = "Silabos.findByObservaciones", query = "SELECT s FROM Silabos s WHERE s.observaciones = :observaciones")
    , @NamedQuery(name = "Silabos.findByRevisionCa", query = "SELECT s FROM Silabos s WHERE s.revisionCa = :revisionCa")
    , @NamedQuery(name = "Silabos.findByRevisionDc", query = "SELECT s FROM Silabos s WHERE s.revisionDc = :revisionDc")
    , @NamedQuery(name = "Silabos.findByAprobado", query = "SELECT s FROM Silabos s WHERE s.aprobado = :aprobado")
    , @NamedQuery(name = "Silabos.findByFechaElaboracion", query = "SELECT s FROM Silabos s WHERE s.fechaElaboracion = :fechaElaboracion")
    , @NamedQuery(name = "Silabos.findByFechaRevision", query = "SELECT s FROM Silabos s WHERE s.fechaRevision = :fechaRevision")
    , @NamedQuery(name = "Silabos.findByFechaAprobacion", query = "SELECT s FROM Silabos s WHERE s.fechaAprobacion = :fechaAprobacion")
    , @NamedQuery(name = "Silabos.findByRevisionDocentes", query = "SELECT s FROM Silabos s WHERE s.revisionDocentes = :revisionDocentes")
    , @NamedQuery(name = "Silabos.findByEvalPractica1h", query = "SELECT s FROM Silabos s WHERE s.evalPractica1h = :evalPractica1h")
    , @NamedQuery(name = "Silabos.findByEvalPractica2h", query = "SELECT s FROM Silabos s WHERE s.evalPractica2h = :evalPractica2h")
    , @NamedQuery(name = "Silabos.findByEvalAutonomo1h", query = "SELECT s FROM Silabos s WHERE s.evalAutonomo1h = :evalAutonomo1h")
    , @NamedQuery(name = "Silabos.findByEvalAutonomo2h", query = "SELECT s FROM Silabos s WHERE s.evalAutonomo2h = :evalAutonomo2h")
    , @NamedQuery(name = "Silabos.findByEvalTrabajosInd1h", query = "SELECT s FROM Silabos s WHERE s.evalTrabajosInd1h = :evalTrabajosInd1h")
    , @NamedQuery(name = "Silabos.findByEvalTrabajosInd2h", query = "SELECT s FROM Silabos s WHERE s.evalTrabajosInd2h = :evalTrabajosInd2h")
    , @NamedQuery(name = "Silabos.findByEvalTrabajosIntegrador1h", query = "SELECT s FROM Silabos s WHERE s.evalTrabajosIntegrador1h = :evalTrabajosIntegrador1h")
    , @NamedQuery(name = "Silabos.findByEvalTrabajosIntegrador2h", query = "SELECT s FROM Silabos s WHERE s.evalTrabajosIntegrador2h = :evalTrabajosIntegrador2h")
    , @NamedQuery(name = "Silabos.findByEvalTrabajosGrup1h", query = "SELECT s FROM Silabos s WHERE s.evalTrabajosGrup1h = :evalTrabajosGrup1h")
    , @NamedQuery(name = "Silabos.findByEvalTrabajosGrup2h", query = "SELECT s FROM Silabos s WHERE s.evalTrabajosGrup2h = :evalTrabajosGrup2h")})
public class Silabos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nh_presencial")
    private Integer nhPresencial;
    @Column(name = "nh_practicas")
    private Integer nhPracticas;
    @Column(name = "nht_presencial")
    private Integer nhtPresencial;
    @Column(name = "nht_virtual")
    private Integer nhtVirtual;
    @Size(max = 2147483647)
    @Column(name = "perfil_docente_academ")
    private String perfilDocenteAcadem;
    @Size(max = 2147483647)
    @Column(name = "perfil_docente_prof")
    private String perfilDocenteProf;
    @Size(max = 2147483647)
    @Column(name = "descrip_perfil_docente")
    private String descripPerfilDocente;
    @Column(name = "vigente")
    private Boolean vigente;
    @Size(max = 2147483647)
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "revision_ca")
    private Boolean revisionCa;
    @Column(name = "revision_dc")
    private Boolean revisionDc;
    @Column(name = "aprobado")
    private Boolean aprobado;
    @Basic(optional = false)
    @Column(name = "fecha_elaboracion")
    @Temporal(TemporalType.DATE)
    private Date fechaElaboracion;
    @Column(name = "fecha_revision")
    @Temporal(TemporalType.DATE)
    private Date fechaRevision;
    @Column(name = "fecha_aprobacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAprobacion;
    @Column(name = "revision_docentes")
    private Boolean revisionDocentes;
    @Column(name = "eval_practica_1h")
    private Integer evalPractica1h;
    @Column(name = "eval_practica_2h")
    private Integer evalPractica2h;
    @Column(name = "eval_autonomo_1h")
    private Integer evalAutonomo1h;
    @Column(name = "eval_autonomo_2h")
    private Integer evalAutonomo2h;
    @Column(name = "eval_trabajos_ind_1h")
    private Integer evalTrabajosInd1h;
    @Column(name = "eval_trabajos_ind_2h")
    private Integer evalTrabajosInd2h;
    @Column(name = "eval_trabajos_integrador_1h")
    private Integer evalTrabajosIntegrador1h;
    @Column(name = "eval_trabajos_integrador_2h")
    private Integer evalTrabajosIntegrador2h;
    @Column(name = "eval_trabajos_grup_1h")
    private Integer evalTrabajosGrup1h;
    @Column(name = "eval_trabajos_grup_2h")
    private Integer evalTrabajosGrup2h;
    @Size(max = 2147483647)
    @Column(name = "bibliografia_virtual")
    private String bibliografiaVirtual;
    @Size(max = 2147483647)
    @Column(name = "bibliografia")
    private String bibliografia;
    @JoinColumn(name = "cod_asignatura", referencedColumnName = "id")
    @ManyToOne
    private Asignaturas codAsignatura;
    @JoinColumn(name = "cod_evaluacion", referencedColumnName = "id")
    @ManyToOne
    private Evaluacion codEvaluacion;
    @JoinColumn(name = "cod_periodo", referencedColumnName = "id")
    @ManyToOne
    private Periodo codPeriodo;
    @OneToMany(mappedBy = "codSilabo")
    private List<SilaboBibliografia> silaboBibliografiaList;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSilabo")
    private List<Unidades> unidadesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSilabo")
    private List<SeguimientoSilabo> seguimientoSilaboList;

    public Silabos() {
    }

    public Silabos(Integer id) {
        this.id = id;
    }

    public Silabos(Integer id, Date fechaElaboracion) {
        this.id = id;
        this.fechaElaboracion = fechaElaboracion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNhPresencial() {
        return nhPresencial;
    }

    public void setNhPresencial(Integer nhPresencial) {
        this.nhPresencial = nhPresencial;
    }

    public Integer getNhPracticas() {
        return nhPracticas;
    }

    public void setNhPracticas(Integer nhPracticas) {
        this.nhPracticas = nhPracticas;
    }

    public Integer getNhtPresencial() {
        return nhtPresencial;
    }

    public void setNhtPresencial(Integer nhtPresencial) {
        this.nhtPresencial = nhtPresencial;
    }

    public Integer getNhtVirtual() {
        return nhtVirtual;
    }

    public void setNhtVirtual(Integer nhtVirtual) {
        this.nhtVirtual = nhtVirtual;
    }

    public String getPerfilDocenteAcadem() {
        return perfilDocenteAcadem;
    }

    public void setPerfilDocenteAcadem(String perfilDocenteAcadem) {
        this.perfilDocenteAcadem = perfilDocenteAcadem;
    }

    public String getPerfilDocenteProf() {
        return perfilDocenteProf;
    }

    public void setPerfilDocenteProf(String perfilDocenteProf) {
        this.perfilDocenteProf = perfilDocenteProf;
    }

    public String getDescripPerfilDocente() {
        return descripPerfilDocente;
    }

    public void setDescripPerfilDocente(String descripPerfilDocente) {
        this.descripPerfilDocente = descripPerfilDocente;
    }

    public Boolean getVigente() {
        return vigente;
    }

    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Boolean getRevisionCa() {
        return revisionCa;
    }

    public void setRevisionCa(Boolean revisionCa) {
        this.revisionCa = revisionCa;
    }

    public Boolean getRevisionDc() {
        return revisionDc;
    }

    public void setRevisionDc(Boolean revisionDc) {
        this.revisionDc = revisionDc;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public Date getFechaElaboracion() {
        return fechaElaboracion;
    }

    public void setFechaElaboracion(Date fechaElaboracion) {
        this.fechaElaboracion = fechaElaboracion;
    }

    public Date getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(Date fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public Boolean getRevisionDocentes() {
        return revisionDocentes;
    }

    public void setRevisionDocentes(Boolean revisionDocentes) {
        this.revisionDocentes = revisionDocentes;
    }

    public Integer getEvalPractica1h() {
        return evalPractica1h;
    }

    public void setEvalPractica1h(Integer evalPractica1h) {
        this.evalPractica1h = evalPractica1h;
    }

    public Integer getEvalPractica2h() {
        return evalPractica2h;
    }

    public void setEvalPractica2h(Integer evalPractica2h) {
        this.evalPractica2h = evalPractica2h;
    }

    public Integer getEvalAutonomo1h() {
        return evalAutonomo1h;
    }

    public void setEvalAutonomo1h(Integer evalAutonomo1h) {
        this.evalAutonomo1h = evalAutonomo1h;
    }

    public Integer getEvalAutonomo2h() {
        return evalAutonomo2h;
    }

    public void setEvalAutonomo2h(Integer evalAutonomo2h) {
        this.evalAutonomo2h = evalAutonomo2h;
    }

    public Integer getEvalTrabajosInd1h() {
        return evalTrabajosInd1h;
    }

    public void setEvalTrabajosInd1h(Integer evalTrabajosInd1h) {
        this.evalTrabajosInd1h = evalTrabajosInd1h;
    }

    public Integer getEvalTrabajosInd2h() {
        return evalTrabajosInd2h;
    }

    public void setEvalTrabajosInd2h(Integer evalTrabajosInd2h) {
        this.evalTrabajosInd2h = evalTrabajosInd2h;
    }

    public Integer getEvalTrabajosIntegrador1h() {
        return evalTrabajosIntegrador1h;
    }

    public void setEvalTrabajosIntegrador1h(Integer evalTrabajosIntegrador1h) {
        this.evalTrabajosIntegrador1h = evalTrabajosIntegrador1h;
    }

    public Integer getEvalTrabajosIntegrador2h() {
        return evalTrabajosIntegrador2h;
    }

    public void setEvalTrabajosIntegrador2h(Integer evalTrabajosIntegrador2h) {
        this.evalTrabajosIntegrador2h = evalTrabajosIntegrador2h;
    }

    public Integer getEvalTrabajosGrup1h() {
        return evalTrabajosGrup1h;
    }

    public void setEvalTrabajosGrup1h(Integer evalTrabajosGrup1h) {
        this.evalTrabajosGrup1h = evalTrabajosGrup1h;
    }

    public Integer getEvalTrabajosGrup2h() {
        return evalTrabajosGrup2h;
    }

    public void setEvalTrabajosGrup2h(Integer evalTrabajosGrup2h) {
        this.evalTrabajosGrup2h = evalTrabajosGrup2h;
    }

    public Asignaturas getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(Asignaturas codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public Evaluacion getCodEvaluacion() {
        return codEvaluacion;
    }

    public void setCodEvaluacion(Evaluacion codEvaluacion) {
        this.codEvaluacion = codEvaluacion;
    }

    public Periodo getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Periodo codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public String getBibliografiaVirtual() {
        return bibliografiaVirtual;
    }

    public void setBibliografiaVirtual(String bibliografiaVirtual) {
        this.bibliografiaVirtual = bibliografiaVirtual;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }


    @XmlTransient
    public List<SilaboBibliografia> getSilaboBibliografiaList() {
        return silaboBibliografiaList;
    }

    public void setSilaboBibliografiaList(List<SilaboBibliografia> silaboBibliografiaList) {
        this.silaboBibliografiaList = silaboBibliografiaList;
    }

    @XmlTransient
    public List<Unidades> getUnidadesList() {
        return unidadesList;
    }

    public void setUnidadesList(List<Unidades> unidadesList) {
        this.unidadesList = unidadesList;
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
        if (!(object instanceof Silabos)) {
            return false;
        }
        Silabos other = (Silabos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Silabos[ id=" + id + " ]";
    }
    
}
