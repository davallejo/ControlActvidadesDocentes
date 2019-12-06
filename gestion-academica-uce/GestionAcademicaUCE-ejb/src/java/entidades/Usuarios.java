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
import javax.persistence.Id;
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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id")
    , @NamedQuery(name = "Usuarios.findByLogin", query = "SELECT u FROM Usuarios u WHERE u.correoInst = :correoInst AND u.userPass = :pass") 
    , @NamedQuery(name = "Usuarios.findByUserName", query = "SELECT u FROM Usuarios u WHERE u.userName = :userName")
    , @NamedQuery(name = "Usuarios.findByUserPass", query = "SELECT u FROM Usuarios u WHERE u.userPass = :userPass")
    , @NamedQuery(name = "Usuarios.findByNombreP", query = "SELECT u FROM Usuarios u WHERE u.nombreP = :nombreP")
    , @NamedQuery(name = "Usuarios.findByApellidoP", query = "SELECT u FROM Usuarios u WHERE u.apellidoP = :apellidoP")
    , @NamedQuery(name = "Usuarios.findByCorreoInst", query = "SELECT u FROM Usuarios u WHERE u.correoInst = :correoInst")
    , @NamedQuery(name = "Usuarios.findByCorreoPers", query = "SELECT u FROM Usuarios u WHERE u.correoPers = :correoPers")
    , @NamedQuery(name = "Usuarios.findByTelefono", query = "SELECT u FROM Usuarios u WHERE u.telefono = :telefono")
    , @NamedQuery(name = "Usuarios.findByApellidoM", query = "SELECT u FROM Usuarios u WHERE u.apellidoM = :apellidoM")
    , @NamedQuery(name = "Usuarios.findByNombreS", query = "SELECT u FROM Usuarios u WHERE u.nombreS = :nombreS")
    , @NamedQuery(name = "Usuarios.findByEstado", query = "SELECT u FROM Usuarios u WHERE u.estado = :estado")
    , @NamedQuery(name = "Usuarios.findByUserPic", query = "SELECT u FROM Usuarios u WHERE u.userPic = :userPic")
    , @NamedQuery(name = "Usuarios.findByUserFirma", query = "SELECT u FROM Usuarios u WHERE u.userFirma = :userFirma")})
public class Usuarios implements Serializable {

    @OneToMany(mappedBy = "idUsuario")
    private List<RegistroBiometrico> registroBiometricoList;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "idUsuario")
    private List<HorarioActividades> horarioActividadesList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "user_pass")
    private String userPass;
    @Size(max = 30)
    @Column(name = "nombre_p")
    private String nombreP;
    @Size(max = 30)
    @Column(name = "apellido_p")
    private String apellidoP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correo_inst")
    private String correoInst;
    @Size(max = 100)
    @Column(name = "correo_pers")
    private String correoPers;
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 30)
    @Column(name = "apellido_m")
    private String apellidoM;
    @Size(max = 30)
    @Column(name = "nombre_s")
    private String nombreS;
    @Column(name = "estado")
    private Boolean estado;
    @Size(max = 255)
    @Column(name = "user_pic")
    private String userPic;
    @Size(max = 255)
    @Column(name = "user_firma")
    private String userFirma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codDocente")
    private List<CargaHoraria> cargaHorariaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCoordinador")
    private List<InformesAsignatura> informesAsignaturaList;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codUsuario")
    private List<RolUsuario> rolUsuarioList;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codDocente")
    private List<AsignaturaDocente> asignaturaDocenteList;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codUsuario")
    private List<UsuariosPerfiles> usuariosPerfilesList;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProfesor")
    private List<ConfiguracionesCh> configuracionesChList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCoordinador")
    private List<InformesArea> informesAreaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codUsuarioEmisor")
    private List<Notificaciones> notificacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codUsuarioReceptor")
    private List<Notificaciones> notificacionesList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCoordinador")
    private List<CoordinadorArea> coordinadorAreaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codDocente")
    private List<ReporteDocente> reporteDocenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCoordinador")
    private List<CoordinadorAsignatura> coordinadorAsignaturaList;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codDocente")
    private List<Cursos> cursosList;
    @OneToMany(mappedBy = "codEstudiante")
    private List<Cursos> cursosList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codDirector")
    private List<CarreraDirector> carreraDirectorList;
    @OneToMany(mappedBy = "codEstudiante")
    private List<DetalleCh> detalleChList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTutor")
    private List<Proyectos> proyectosList;
    @OneToMany(mappedBy = "codDocente")
    private List<SeguimientoSilabo> seguimientoSilaboList;
    @OneToMany(mappedBy = "codEstudiante")
    private List<SeguimientoSilabo> seguimientoSilaboList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codDocente")
    private List<DetalleInformeArea> detalleInformeAreaList;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSolicitante")
    private List<Formulario> formularioList;

    public Usuarios() {
    }

    public Usuarios(String id) {
        this.id = id;
    }

    public Usuarios(String id, String userName, String userPass, String correoInst) {
        this.id = id;
        this.userName = userName;
        this.userPass = userPass;
        this.correoInst = correoInst;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getCorreoInst() {
        return correoInst;
    }

    public void setCorreoInst(String correoInst) {
        this.correoInst = correoInst;
    }

    public String getCorreoPers() {
        return correoPers;
    }

    public void setCorreoPers(String correoPers) {
        this.correoPers = correoPers;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getUserFirma() {
        return userFirma;
    }

    public void setUserFirma(String userFirma) {
        this.userFirma = userFirma;
    }

    @XmlTransient
    public List<CargaHoraria> getCargaHorariaList() {
        return cargaHorariaList;
    }

    public void setCargaHorariaList(List<CargaHoraria> cargaHorariaList) {
        this.cargaHorariaList = cargaHorariaList;
    }

    @XmlTransient
    public List<InformesAsignatura> getInformesAsignaturaList() {
        return informesAsignaturaList;
    }

    public void setInformesAsignaturaList(List<InformesAsignatura> informesAsignaturaList) {
        this.informesAsignaturaList = informesAsignaturaList;
    }

    @XmlTransient
    public List<RolUsuario> getRolUsuarioList() {
        return rolUsuarioList;
    }

    public void setRolUsuarioList(List<RolUsuario> rolUsuarioList) {
        this.rolUsuarioList = rolUsuarioList;
    }

    @XmlTransient
    public List<AsignaturaDocente> getAsignaturaDocenteList() {
        return asignaturaDocenteList;
    }

    public void setAsignaturaDocenteList(List<AsignaturaDocente> asignaturaDocenteList) {
        this.asignaturaDocenteList = asignaturaDocenteList;
    }

    @XmlTransient
    public List<UsuariosPerfiles> getUsuariosPerfilesList() {
        return usuariosPerfilesList;
    }

    public void setUsuariosPerfilesList(List<UsuariosPerfiles> usuariosPerfilesList) {
        this.usuariosPerfilesList = usuariosPerfilesList;
    }

    @XmlTransient
    public List<ConfiguracionesCh> getConfiguracionesChList() {
        return configuracionesChList;
    }

    public void setConfiguracionesChList(List<ConfiguracionesCh> configuracionesChList) {
        this.configuracionesChList = configuracionesChList;
    }

    @XmlTransient
    public List<InformesArea> getInformesAreaList() {
        return informesAreaList;
    }

    public void setInformesAreaList(List<InformesArea> informesAreaList) {
        this.informesAreaList = informesAreaList;
    }

    @XmlTransient
    public List<Notificaciones> getNotificacionesList() {
        return notificacionesList;
    }

    public void setNotificacionesList(List<Notificaciones> notificacionesList) {
        this.notificacionesList = notificacionesList;
    }

    @XmlTransient
    public List<Notificaciones> getNotificacionesList1() {
        return notificacionesList1;
    }

    public void setNotificacionesList1(List<Notificaciones> notificacionesList1) {
        this.notificacionesList1 = notificacionesList1;
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
    public List<Cursos> getCursosList1() {
        return cursosList1;
    }

    public void setCursosList1(List<Cursos> cursosList1) {
        this.cursosList1 = cursosList1;
    }

    @XmlTransient
    public List<CarreraDirector> getCarreraDirectorList() {
        return carreraDirectorList;
    }

    public void setCarreraDirectorList(List<CarreraDirector> carreraDirectorList) {
        this.carreraDirectorList = carreraDirectorList;
    }

    @XmlTransient
    public List<DetalleCh> getDetalleChList() {
        return detalleChList;
    }

    public void setDetalleChList(List<DetalleCh> detalleChList) {
        this.detalleChList = detalleChList;
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

    @XmlTransient
    public List<SeguimientoSilabo> getSeguimientoSilaboList1() {
        return seguimientoSilaboList1;
    }

    public void setSeguimientoSilaboList1(List<SeguimientoSilabo> seguimientoSilaboList1) {
        this.seguimientoSilaboList1 = seguimientoSilaboList1;
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
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Usuarios[ id=" + id + " ]";
    }

    @XmlTransient
    public List<RegistroBiometrico> getRegistroBiometricoList() {
        return registroBiometricoList;
    }

    public void setRegistroBiometricoList(List<RegistroBiometrico> registroBiometricoList) {
        this.registroBiometricoList = registroBiometricoList;
    }

    @XmlTransient
    public List<HorarioActividades> getHorarioActividadesList() {
        return horarioActividadesList;
    }

    public void setHorarioActividadesList(List<HorarioActividades> horarioActividadesList) {
        this.horarioActividadesList = horarioActividadesList;
    }
    
}
