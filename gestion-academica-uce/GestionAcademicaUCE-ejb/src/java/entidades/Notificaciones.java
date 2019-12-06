/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "notificaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notificaciones.findAll", query = "SELECT n FROM Notificaciones n")
    , @NamedQuery(name = "Notificaciones.findById", query = "SELECT n FROM Notificaciones n WHERE n.id = :id")
    , @NamedQuery(name = "Notificaciones.findByFecha", query = "SELECT n FROM Notificaciones n WHERE n.fecha = :fecha")
    , @NamedQuery(name = "Notificaciones.findByDescripcion", query = "SELECT n FROM Notificaciones n WHERE n.descripcion = :descripcion")
    , @NamedQuery(name = "Notificaciones.findByEstado", query = "SELECT n FROM Notificaciones n WHERE n.estado = :estado")
    , @NamedQuery(name = "Notificaciones.findByModTarea", query = "SELECT n FROM Notificaciones n WHERE n.modTarea = :modTarea")
    , @NamedQuery(name = "Notificaciones.findByAdjunto", query = "SELECT n FROM Notificaciones n WHERE n.adjunto = :adjunto")
    , @NamedQuery(name = "Notificaciones.findByTitulo", query = "SELECT n FROM Notificaciones n WHERE n.titulo = :titulo")})
public class Notificaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 256)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private Boolean estado;
    @Size(max = 200)
    @Column(name = "mod_tarea")
    private String modTarea;
    @Size(max = 250)
    @Column(name = "adjunto")
    private String adjunto;
    @Size(max = 50)
    @Column(name = "titulo")
    private String titulo;
    @JoinColumn(name = "cod_usuario_emisor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios codUsuarioEmisor;
    @JoinColumn(name = "cod_usuario_receptor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios codUsuarioReceptor;

    public Notificaciones() {
    }

    public Notificaciones(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getModTarea() {
        return modTarea;
    }

    public void setModTarea(String modTarea) {
        this.modTarea = modTarea;
    }

    public String getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(String adjunto) {
        this.adjunto = adjunto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuarios getCodUsuarioEmisor() {
        return codUsuarioEmisor;
    }

    public void setCodUsuarioEmisor(Usuarios codUsuarioEmisor) {
        this.codUsuarioEmisor = codUsuarioEmisor;
    }

    public Usuarios getCodUsuarioReceptor() {
        return codUsuarioReceptor;
    }

    public void setCodUsuarioReceptor(Usuarios codUsuarioReceptor) {
        this.codUsuarioReceptor = codUsuarioReceptor;
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
        if (!(object instanceof Notificaciones)) {
            return false;
        }
        Notificaciones other = (Notificaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Notificaciones[ id=" + id + " ]";
    }
    
}
