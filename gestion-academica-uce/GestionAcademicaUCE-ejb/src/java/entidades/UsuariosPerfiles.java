/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "usuarios_perfiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariosPerfiles.findAll", query = "SELECT u FROM UsuariosPerfiles u")
    , @NamedQuery(name = "UsuariosPerfiles.findById", query = "SELECT u FROM UsuariosPerfiles u WHERE u.id = :id")})
public class UsuariosPerfiles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "cod_perfil", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Perfiles codPerfil;
    @JoinColumn(name = "cod_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios codUsuario;

    public UsuariosPerfiles() {
    }

    public UsuariosPerfiles(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Perfiles getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(Perfiles codPerfil) {
        this.codPerfil = codPerfil;
    }

    public Usuarios getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Usuarios codUsuario) {
        this.codUsuario = codUsuario;
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
        if (!(object instanceof UsuariosPerfiles)) {
            return false;
        }
        UsuariosPerfiles other = (UsuariosPerfiles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.UsuariosPerfiles[ id=" + id + " ]";
    }
    
}
