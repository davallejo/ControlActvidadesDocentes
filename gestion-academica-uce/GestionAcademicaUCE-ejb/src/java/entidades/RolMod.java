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
@Table(name = "rol_mod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolMod.findAll", query = "SELECT r FROM RolMod r")
    , @NamedQuery(name = "RolMod.findById", query = "SELECT r FROM RolMod r WHERE r.id = :id")})
public class RolMod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "cod_modulo", referencedColumnName = "id")
    @ManyToOne
    private Modulos codModulo;
    @JoinColumn(name = "cod_rol", referencedColumnName = "id")
    @ManyToOne
    private Roles codRol;

    public RolMod() {
    }

    public RolMod(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Modulos getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(Modulos codModulo) {
        this.codModulo = codModulo;
    }

    public Roles getCodRol() {
        return codRol;
    }

    public void setCodRol(Roles codRol) {
        this.codRol = codRol;
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
        if (!(object instanceof RolMod)) {
            return false;
        }
        RolMod other = (RolMod) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.RolMod[ id=" + id + " ]";
    }
    
}
