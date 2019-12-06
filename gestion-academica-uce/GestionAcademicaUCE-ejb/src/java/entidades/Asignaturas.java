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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "asignaturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignaturas.findAll", query = "SELECT a FROM Asignaturas a")
    , @NamedQuery(name = "Asignaturas.findById", query = "SELECT a FROM Asignaturas a WHERE a.id = :id")
    , @NamedQuery(name = "Asignaturas.findByNombre", query = "SELECT a FROM Asignaturas a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Asignaturas.findByCodigo", query = "SELECT a FROM Asignaturas a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Asignaturas.findByCreditos", query = "SELECT a FROM Asignaturas a WHERE a.creditos = :creditos")
    , @NamedQuery(name = "Asignaturas.findByUnidadCurricular", query = "SELECT a FROM Asignaturas a WHERE a.unidadCurricular = :unidadCurricular")
    , @NamedQuery(name = "Asignaturas.findByTipoAsignatura", query = "SELECT a FROM Asignaturas a WHERE a.tipoAsignatura = :tipoAsignatura")
    , @NamedQuery(name = "Asignaturas.findByDescripcion", query = "SELECT a FROM Asignaturas a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Asignaturas.findByObjetivoGeneral", query = "SELECT a FROM Asignaturas a WHERE a.objetivoGeneral = :objetivoGeneral")
    , @NamedQuery(name = "Asignaturas.findByObjetivosEspecificos", query = "SELECT a FROM Asignaturas a WHERE a.objetivosEspecificos = :objetivosEspecificos")
    , @NamedQuery(name = "Asignaturas.findByContribucionFormacionProf", query = "SELECT a FROM Asignaturas a WHERE a.contribucionFormacionProf = :contribucionFormacionProf")
    , @NamedQuery(name = "Asignaturas.findByResultadosAprendizaje", query = "SELECT a FROM Asignaturas a WHERE a.resultadosAprendizaje = :resultadosAprendizaje")
    , @NamedQuery(name = "Asignaturas.findByCodSilabo", query = "SELECT a FROM Asignaturas a WHERE a.codSilabo = :codSilabo")})
public class Asignaturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 10)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "creditos")
    private Integer creditos;
    @Size(max = 50)
    @Column(name = "unidad_curricular")
    private String unidadCurricular;
    @Size(max = 50)
    @Column(name = "tipo_asignatura")
    private String tipoAsignatura;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 2147483647)
    @Column(name = "objetivo_general")
    private String objetivoGeneral;
    @Size(max = 2147483647)
    @Column(name = "objetivos_especificos")
    private String objetivosEspecificos;
    @Size(max = 2147483647)
    @Column(name = "contribucion_formacion_prof")
    private String contribucionFormacionProf;
    @Size(max = 2147483647)
    @Column(name = "resultados_aprendizaje")
    private String resultadosAprendizaje;
    @Column(name = "cod_silabo")
    private Integer codSilabo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAsignatura")
    private List<InformesAsignatura> informesAsignaturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAsignatura")
    private List<AsignaturaDocente> asignaturaDocenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAsignaturaCo")
    private List<CoRequisitos> coRequisitosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAsignatura")
    private List<CoRequisitos> coRequisitosList1;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "codAsignatura")
    private List<Silabos> silabosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAsignaturaPre")
    private List<PreRequisitos> preRequisitosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAsignatura")
    private List<PreRequisitos> preRequisitosList1;
    @JoinColumn(name = "cod_area", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AreaAcademica codArea;
    @JoinColumn(name = "cod_carrera", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Carreras codCarrera;
    @JoinColumn(name = "cod_semestre", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Semestre codSemestre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAsignatura")
    private List<ReporteDocente> reporteDocenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAsignatura")
    private List<CoordinadorAsignatura> coordinadorAsignaturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAsignatura")
    private List<Cursos> cursosList;
    @OneToMany(mappedBy = "codMateria")
    private List<DetalleCh> detalleChList;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "codAsignatura")
    private List<SeguimientoSilabo> seguimientoSilaboList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAsignatura")
    private List<DetalleInformeArea> detalleInformeAreaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAsignatura")
    private List<Formulario> formularioList;

    public Asignaturas() {
    }

    public Asignaturas(Integer id) {
        this.id = id;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public String getUnidadCurricular() {
        return unidadCurricular;
    }

    public void setUnidadCurricular(String unidadCurricular) {
        this.unidadCurricular = unidadCurricular;
    }

    public String getTipoAsignatura() {
        return tipoAsignatura;
    }

    public void setTipoAsignatura(String tipoAsignatura) {
        this.tipoAsignatura = tipoAsignatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObjetivoGeneral() {
        return objetivoGeneral;
    }

    public void setObjetivoGeneral(String objetivoGeneral) {
        this.objetivoGeneral = objetivoGeneral;
    }

    public String getObjetivosEspecificos() {
        return objetivosEspecificos;
    }

    public void setObjetivosEspecificos(String objetivosEspecificos) {
        this.objetivosEspecificos = objetivosEspecificos;
    }

    public String getContribucionFormacionProf() {
        return contribucionFormacionProf;
    }

    public void setContribucionFormacionProf(String contribucionFormacionProf) {
        this.contribucionFormacionProf = contribucionFormacionProf;
    }

    public String getResultadosAprendizaje() {
        return resultadosAprendizaje;
    }

    public void setResultadosAprendizaje(String resultadosAprendizaje) {
        this.resultadosAprendizaje = resultadosAprendizaje;
    }

    public Integer getCodSilabo() {
        return codSilabo;
    }

    public void setCodSilabo(Integer codSilabo) {
        this.codSilabo = codSilabo;
    }

    @XmlTransient
    public List<InformesAsignatura> getInformesAsignaturaList() {
        return informesAsignaturaList;
    }

    public void setInformesAsignaturaList(List<InformesAsignatura> informesAsignaturaList) {
        this.informesAsignaturaList = informesAsignaturaList;
    }

    @XmlTransient
    public List<AsignaturaDocente> getAsignaturaDocenteList() {
        return asignaturaDocenteList;
    }

    public void setAsignaturaDocenteList(List<AsignaturaDocente> asignaturaDocenteList) {
        this.asignaturaDocenteList = asignaturaDocenteList;
    }

    @XmlTransient
    public List<CoRequisitos> getCoRequisitosList() {
        return coRequisitosList;
    }

    public void setCoRequisitosList(List<CoRequisitos> coRequisitosList) {
        this.coRequisitosList = coRequisitosList;
    }

    @XmlTransient
    public List<CoRequisitos> getCoRequisitosList1() {
        return coRequisitosList1;
    }

    public void setCoRequisitosList1(List<CoRequisitos> coRequisitosList1) {
        this.coRequisitosList1 = coRequisitosList1;
    }

    @XmlTransient
    public List<Silabos> getSilabosList() {
        return silabosList;
    }

    public void setSilabosList(List<Silabos> silabosList) {
        this.silabosList = silabosList;
    }

    @XmlTransient
    public List<PreRequisitos> getPreRequisitosList() {
        return preRequisitosList;
    }

    public void setPreRequisitosList(List<PreRequisitos> preRequisitosList) {
        this.preRequisitosList = preRequisitosList;
    }

    @XmlTransient
    public List<PreRequisitos> getPreRequisitosList1() {
        return preRequisitosList1;
    }

    public void setPreRequisitosList1(List<PreRequisitos> preRequisitosList1) {
        this.preRequisitosList1 = preRequisitosList1;
    }

    public AreaAcademica getCodArea() {
        return codArea;
    }

    public void setCodArea(AreaAcademica codArea) {
        this.codArea = codArea;
    }

    public Carreras getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(Carreras codCarrera) {
        this.codCarrera = codCarrera;
    }

    public Semestre getCodSemestre() {
        return codSemestre;
    }

    public void setCodSemestre(Semestre codSemestre) {
        this.codSemestre = codSemestre;
    }

    @XmlTransient
    public List<ReporteDocente> getReporteDocenteList() {
        return reporteDocenteList;
    }

    public void setReporteDocenteList(List<ReporteDocente> reporteDocenteList) {
        this.reporteDocenteList = reporteDocenteList;
    }

    @XmlTransient
    public List<CoordinadorAsignatura> getCoordinadorAsignaturaList() {
        return coordinadorAsignaturaList;
    }

    public void setCoordinadorAsignaturaList(List<CoordinadorAsignatura> coordinadorAsignaturaList) {
        this.coordinadorAsignaturaList = coordinadorAsignaturaList;
    }

    @XmlTransient
    public List<Cursos> getCursosList() {
        return cursosList;
    }

    public void setCursosList(List<Cursos> cursosList) {
        this.cursosList = cursosList;
    }

    @XmlTransient
    public List<DetalleCh> getDetalleChList() {
        return detalleChList;
    }

    public void setDetalleChList(List<DetalleCh> detalleChList) {
        this.detalleChList = detalleChList;
    }

    @XmlTransient
    public List<SeguimientoSilabo> getSeguimientoSilaboList() {
        return seguimientoSilaboList;
    }

    public void setSeguimientoSilaboList(List<SeguimientoSilabo> seguimientoSilaboList) {
        this.seguimientoSilaboList = seguimientoSilaboList;
    }

    @XmlTransient
    public List<DetalleInformeArea> getDetalleInformeAreaList() {
        return detalleInformeAreaList;
    }

    public void setDetalleInformeAreaList(List<DetalleInformeArea> detalleInformeAreaList) {
        this.detalleInformeAreaList = detalleInformeAreaList;
    }

    @XmlTransient
    public List<Formulario> getFormularioList() {
        return formularioList;
    }

    public void setFormularioList(List<Formulario> formularioList) {
        this.formularioList = formularioList;
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
        if (!(object instanceof Asignaturas)) {
            return false;
        }
        Asignaturas other = (Asignaturas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Asignaturas[ id=" + id + " ]";
    }
    
}
