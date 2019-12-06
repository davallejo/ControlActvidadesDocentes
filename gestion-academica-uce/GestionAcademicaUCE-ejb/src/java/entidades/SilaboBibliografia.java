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
@Table(name = "silabo_bibliografia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SilaboBibliografia.findAll", query = "SELECT s FROM SilaboBibliografia s")
    , @NamedQuery(name = "SilaboBibliografia.findById", query = "SELECT s FROM SilaboBibliografia s WHERE s.id = :id")})
public class SilaboBibliografia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "cod_bibliografia", referencedColumnName = "id")
    @ManyToOne
    private Bibliografia codBibliografia;
    @JoinColumn(name = "cod_silabo", referencedColumnName = "id")
    @ManyToOne
    private Silabos codSilabo;

    public SilaboBibliografia() {
    }

    public SilaboBibliografia(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bibliografia getCodBibliografia() {
        return codBibliografia;
    }

    public void setCodBibliografia(Bibliografia codBibliografia) {
        this.codBibliografia = codBibliografia;
    }

    public Silabos getCodSilabo() {
        return codSilabo;
    }

    public void setCodSilabo(Silabos codSilabo) {
        this.codSilabo = codSilabo;
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
        if (!(object instanceof SilaboBibliografia)) {
            return false;
        }
        SilaboBibliografia other = (SilaboBibliografia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.SilaboBibliografia[ id=" + id + " ]";
    }
    
}
