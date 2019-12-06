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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "perfiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfiles.findAll", query = "SELECT p FROM Perfiles p")
    , @NamedQuery(name = "Perfiles.findById", query = "SELECT p FROM Perfiles p WHERE p.id = :id")
    , @NamedQuery(name = "Perfiles.findByNombre", query = "SELECT p FROM Perfiles p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Perfiles.findByHoraEstablecida", query = "SELECT p FROM Perfiles p WHERE p.horaEstablecida = :horaEstablecida")})
public class Perfiles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "hora_establecida")
    private Integer horaEstablecida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPerfil")
    private List<PerfMod> perfModList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPerfil")
    private List<UsuariosPerfiles> usuariosPerfilesList;
  

    public Perfiles() {
    }

    public Perfiles(Integer id) {
        this.id = id;
    }

    public Perfiles(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public Integer getHoraEstablecida() {
        return horaEstablecida;
    }

    public void setHoraEstablecida(Integer horaEstablecida) {
        this.horaEstablecida = horaEstablecida;
    }

    @XmlTransient
    public List<PerfMod> getPerfModList() {
        return perfModList;
    }

    public void setPerfModList(List<PerfMod> perfModList) {
        this.perfModList = perfModList;
    }

    @XmlTransient
    public List<UsuariosPerfiles> getUsuariosPerfilesList() {
        return usuariosPerfilesList;
    }

    public void setUsuariosPerfilesList(List<UsuariosPerfiles> usuariosPerfilesList) {
        this.usuariosPerfilesList = usuariosPerfilesList;
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
        if (!(object instanceof Perfiles)) {
            return false;
        }
        Perfiles other = (Perfiles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Perfiles[ id=" + id + " ]";
    }
    
}
