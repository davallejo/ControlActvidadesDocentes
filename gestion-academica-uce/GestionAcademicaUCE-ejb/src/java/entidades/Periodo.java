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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "periodo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periodo.findAll", query = "SELECT p FROM Periodo p")
    , @NamedQuery(name = "Periodo.findById", query = "SELECT p FROM Periodo p WHERE p.id = :id")
    , @NamedQuery(name = "Periodo.findByMesInicio", query = "SELECT p FROM Periodo p WHERE p.mesInicio = :mesInicio")
    , @NamedQuery(name = "Periodo.findByAnioInicio", query = "SELECT p FROM Periodo p WHERE p.anioInicio = :anioInicio")
    , @NamedQuery(name = "Periodo.findByMesFin", query = "SELECT p FROM Periodo p WHERE p.mesFin = :mesFin")
    , @NamedQuery(name = "Periodo.findByAnioFin", query = "SELECT p FROM Periodo p WHERE p.anioFin = :anioFin")
    , @NamedQuery(name = "Periodo.findByActivo", query = "SELECT p FROM Periodo p WHERE p.activo = :activo")
 , @NamedQuery(name = "Periodo.update", query = "UPDATE Periodo SET activo = false")})
public class Periodo implements Serializable {

    @Column(name = "inicio")
    @Temporal(TemporalType.DATE)
    private Date inicio;
    @Column(name = "fin")
    @Temporal(TemporalType.DATE)
    private Date fin;
    @Size(max = 80)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idPeriodo")
    private List<HorarioActividades> horarioActividadesList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "mes_inicio")
    private String mesInicio;
    @Size(max = 10)
    @Column(name = "anio_inicio")
    private String anioInicio;
    @Size(max = 20)
    @Column(name = "mes_fin")
    private String mesFin;
    @Size(max = 10)
    @Column(name = "anio_fin")
    private String anioFin;
    @Column(name = "activo")
    private Boolean activo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPeriodo")
    private List<InformesAsignatura> informesAsignaturaList;
    @OneToMany(mappedBy = "codPeriodo")
    private List<AsignaturaDocente> asignaturaDocenteList;
    @OneToMany(mappedBy = "codPeriodo")
    private List<ConfiguracionesCh> configuracionesChList;
    @OneToMany(mappedBy = "codPeriodo")
    private List<Silabos> silabosList; 
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPeriodo")
    private List<CabeceraReunionAs> cabeceraReunionAsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPeriodo")
    private List<ReporteArea> reporteAreaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPeriodo")
    private List<CabeceraReunion> cabeceraReunionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPeriodo")
    private List<InformesArea> informesAreaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPeriodo")
    private List<CoordinadorArea> coordinadorAreaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPeriodo")
    private List<ReporteDocente> reporteDocenteList;
    @OneToMany(mappedBy = "codPeriodo")
    private List<CoordinadorAsignatura> coordinadorAsignaturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPeriodo")
    private List<Cursos> cursosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPeriodo")
    private List<CarreraDirector> carreraDirectorList;
    @OneToMany(mappedBy = "codPeriodo")
    private List<Proyectos> proyectosList;
    @OneToMany(mappedBy = "codPeriodo")
    private List<SeguimientoSilabo> seguimientoSilaboList;


    public Periodo() {
    }

    public Periodo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMesInicio() {
        return mesInicio;
    }

    public void setMesInicio(String mesInicio) {
        this.mesInicio = mesInicio;
    }

    public String getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(String anioInicio) {
        this.anioInicio = anioInicio;
    }

    public String getMesFin() {
        return mesFin;
    }

    public void setMesFin(String mesFin) {
        this.mesFin = mesFin;
    }

    public String getAnioFin() {
        return anioFin;
    }

    public void setAnioFin(String anioFin) {
        this.anioFin = anioFin;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
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
    public List<ConfiguracionesCh> getConfiguracionesChList() {
        return configuracionesChList;
    }

    public void setConfiguracionesChList(List<ConfiguracionesCh> configuracionesChList) {
        this.configuracionesChList = configuracionesChList;
    }

    @XmlTransient
    public List<Silabos> getSilabosList() {
        return silabosList;
    }

    public void setSilabosList(List<Silabos> silabosList) {
        this.silabosList = silabosList;
    }

    @XmlTransient
    public List<CabeceraReunionAs> getCabeceraReunionAsList() {
        return cabeceraReunionAsList;
    }

    public void setCabeceraReunionAsList(List<CabeceraReunionAs> cabeceraReunionAsList) {
        this.cabeceraReunionAsList = cabeceraReunionAsList;
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

    @XmlTransient
    public List<InformesArea> getInformesAreaList() {
        return informesAreaList;
    }

    public void setInformesAreaList(List<InformesArea> informesAreaList) {
        this.informesAreaList = informesAreaList;
    }

    @XmlTransient
    public List<CoordinadorArea> getCoordinadorAreaList() {
        return coordinadorAreaList;
    }

    public void setCoordinadorAreaList(List<CoordinadorArea> coordinadorAreaList) {
        this.coordinadorAreaList = coordinadorAreaList;
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
    public List<CarreraDirector> getCarreraDirectorList() {
        return carreraDirectorList;
    }

    public void setCarreraDirectorList(List<CarreraDirector> carreraDirectorList) {
        this.carreraDirectorList = carreraDirectorList;
    }

    @XmlTransient
    public List<Proyectos> getProyectosList() {
        return proyectosList;
    }

    public void setProyectosList(List<Proyectos> proyectosList) {
        this.proyectosList = proyectosList;
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
        if (!(object instanceof Periodo)) {
            return false;
        }
        Periodo other = (Periodo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Periodo[ id=" + id + " ]";
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<HorarioActividades> getHorarioActividadesList() {
        return horarioActividadesList;
    }

    public void setHorarioActividadesList(List<HorarioActividades> horarioActividadesList) {
        this.horarioActividadesList = horarioActividadesList;
    }
    
}
