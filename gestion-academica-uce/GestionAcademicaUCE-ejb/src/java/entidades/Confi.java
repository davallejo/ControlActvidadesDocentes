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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "confi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Confi.findAll", query = "SELECT c FROM Confi c")
    , @NamedQuery(name = "Confi.findByHic", query = "SELECT c FROM Confi c WHERE c.hic = :hic")
    , @NamedQuery(name = "Confi.findByHic1", query = "SELECT c FROM Confi c WHERE c.hic1 = :hic1")
    , @NamedQuery(name = "Confi.findByHi", query = "SELECT c FROM Confi c WHERE c.hi = :hi")
    , @NamedQuery(name = "Confi.findByHi1", query = "SELECT c FROM Confi c WHERE c.hi1 = :hi1")
    , @NamedQuery(name = "Confi.findByHvs", query = "SELECT c FROM Confi c WHERE c.hvs = :hvs")
    , @NamedQuery(name = "Confi.findByHvs1", query = "SELECT c FROM Confi c WHERE c.hvs1 = :hvs1")
    , @NamedQuery(name = "Confi.findByHpc", query = "SELECT c FROM Confi c WHERE c.hpc = :hpc")
    , @NamedQuery(name = "Confi.findByHpc1", query = "SELECT c FROM Confi c WHERE c.hpc1 = :hpc1")
    , @NamedQuery(name = "Confi.findByHpe", query = "SELECT c FROM Confi c WHERE c.hpe = :hpe")
    , @NamedQuery(name = "Confi.findByHpe1", query = "SELECT c FROM Confi c WHERE c.hpe1 = :hpe1")
    , @NamedQuery(name = "Confi.findByHta", query = "SELECT c FROM Confi c WHERE c.hta = :hta")
    , @NamedQuery(name = "Confi.findByHta1", query = "SELECT c FROM Confi c WHERE c.hta1 = :hta1")
    , @NamedQuery(name = "Confi.findByHat", query = "SELECT c FROM Confi c WHERE c.hat = :hat")
    , @NamedQuery(name = "Confi.findByHat1", query = "SELECT c FROM Confi c WHERE c.hat1 = :hat1")
    , @NamedQuery(name = "Confi.findByHga", query = "SELECT c FROM Confi c WHERE c.hga = :hga")
    , @NamedQuery(name = "Confi.findByHga1", query = "SELECT c FROM Confi c WHERE c.hga1 = :hga1")
    , @NamedQuery(name = "Confi.findById", query = "SELECT c FROM Confi c WHERE c.id = :id")})
public class Confi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "hic")
    private Integer hic;
    @Column(name = "hic1")
    private Integer hic1;
    @Column(name = "hi")
    private Integer hi;
    @Column(name = "hi1")
    private Integer hi1;
    @Column(name = "hvs")
    private Integer hvs;
    @Column(name = "hvs1")
    private Integer hvs1;
    @Column(name = "hpc")
    private Integer hpc;
    @Column(name = "hpc1")
    private Integer hpc1;
    @Column(name = "hpe")
    private Integer hpe;
    @Column(name = "hpe1")
    private Integer hpe1;
    @Column(name = "hta")
    private Integer hta;
    @Column(name = "hta1")
    private Integer hta1;
    @Column(name = "hat")
    private Integer hat;
    @Column(name = "hat1")
    private Integer hat1;
    @Column(name = "hga")
    private Integer hga;
    @Column(name = "hga1")
    private Integer hga1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Confi() {
    }

    public Confi(Integer id) {
        this.id = id;
    }

    public Integer getHic() {
        return hic;
    }

    public void setHic(Integer hic) {
        this.hic = hic;
    }

    public Integer getHic1() {
        return hic1;
    }

    public void setHic1(Integer hic1) {
        this.hic1 = hic1;
    }

    public Integer getHi() {
        return hi;
    }

    public void setHi(Integer hi) {
        this.hi = hi;
    }

    public Integer getHi1() {
        return hi1;
    }

    public void setHi1(Integer hi1) {
        this.hi1 = hi1;
    }

    public Integer getHvs() {
        return hvs;
    }

    public void setHvs(Integer hvs) {
        this.hvs = hvs;
    }

    public Integer getHvs1() {
        return hvs1;
    }

    public void setHvs1(Integer hvs1) {
        this.hvs1 = hvs1;
    }

    public Integer getHpc() {
        return hpc;
    }

    public void setHpc(Integer hpc) {
        this.hpc = hpc;
    }

    public Integer getHpc1() {
        return hpc1;
    }

    public void setHpc1(Integer hpc1) {
        this.hpc1 = hpc1;
    }

    public Integer getHpe() {
        return hpe;
    }

    public void setHpe(Integer hpe) {
        this.hpe = hpe;
    }

    public Integer getHpe1() {
        return hpe1;
    }

    public void setHpe1(Integer hpe1) {
        this.hpe1 = hpe1;
    }

    public Integer getHta() {
        return hta;
    }

    public void setHta(Integer hta) {
        this.hta = hta;
    }

    public Integer getHta1() {
        return hta1;
    }

    public void setHta1(Integer hta1) {
        this.hta1 = hta1;
    }

    public Integer getHat() {
        return hat;
    }

    public void setHat(Integer hat) {
        this.hat = hat;
    }

    public Integer getHat1() {
        return hat1;
    }

    public void setHat1(Integer hat1) {
        this.hat1 = hat1;
    }

    public Integer getHga() {
        return hga;
    }

    public void setHga(Integer hga) {
        this.hga = hga;
    }

    public Integer getHga1() {
        return hga1;
    }

    public void setHga1(Integer hga1) {
        this.hga1 = hga1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof Confi)) {
            return false;
        }
        Confi other = (Confi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Confi[ id=" + id + " ]";
    }
    
}
