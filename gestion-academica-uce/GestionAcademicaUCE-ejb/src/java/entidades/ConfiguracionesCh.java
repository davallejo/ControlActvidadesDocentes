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
@Table(name = "configuraciones_ch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConfiguracionesCh.findAll", query = "SELECT c FROM ConfiguracionesCh c")
    , @NamedQuery(name = "ConfiguracionesCh.findById", query = "SELECT c FROM ConfiguracionesCh c WHERE c.id = :id")
    , @NamedQuery(name = "ConfiguracionesCh.findByHat", query = "SELECT c FROM ConfiguracionesCh c WHERE c.hat = :hat")
    , @NamedQuery(name = "ConfiguracionesCh.findByHco", query = "SELECT c FROM ConfiguracionesCh c WHERE c.hco = :hco")
    , @NamedQuery(name = "ConfiguracionesCh.findByHga", query = "SELECT c FROM ConfiguracionesCh c WHERE c.hga = :hga")
    , @NamedQuery(name = "ConfiguracionesCh.findByHic", query = "SELECT c FROM ConfiguracionesCh c WHERE c.hic = :hic")
    , @NamedQuery(name = "ConfiguracionesCh.findByHi", query = "SELECT c FROM ConfiguracionesCh c WHERE c.hi = :hi")
    , @NamedQuery(name = "ConfiguracionesCh.findByHpc", query = "SELECT c FROM ConfiguracionesCh c WHERE c.hpc = :hpc")
    , @NamedQuery(name = "ConfiguracionesCh.findByHpe", query = "SELECT c FROM ConfiguracionesCh c WHERE c.hpe = :hpe")
    , @NamedQuery(name = "ConfiguracionesCh.findByHta", query = "SELECT c FROM ConfiguracionesCh c WHERE c.hta = :hta")
    , @NamedQuery(name = "ConfiguracionesCh.findByHti", query = "SELECT c FROM ConfiguracionesCh c WHERE c.hti = :hti")
    , @NamedQuery(name = "ConfiguracionesCh.findByHvs", query = "SELECT c FROM ConfiguracionesCh c WHERE c.hvs = :hvs")
    , @NamedQuery(name = "ConfiguracionesCh.findByHat1", query = "SELECT c FROM ConfiguracionesCh c WHERE c.hat1 = :hat1")
    , @NamedQuery(name = "ConfiguracionesCh.findByHco1", query = "SELECT c FROM ConfiguracionesCh c WHERE c.hco1 = :hco1")
    , @NamedQuery(name = "ConfiguracionesCh.findByHga1", query = "SELECT c FROM ConfiguracionesCh c WHERE c.hga1 = :hga1")
    , @NamedQuery(name = "ConfiguracionesCh.findByHic1", query = "SELECT c FROM ConfiguracionesCh c WHERE c.hic1 = :hic1")
    , @NamedQuery(name = "ConfiguracionesCh.findByHi1", query = "SELECT c FROM ConfiguracionesCh c WHERE c.hi1 = :hi1")
    , @NamedQuery(name = "ConfiguracionesCh.findByHpc1", query = "SELECT c FROM ConfiguracionesCh c WHERE c.hpc1 = :hpc1")
    , @NamedQuery(name = "ConfiguracionesCh.findByHpe1", query = "SELECT c FROM ConfiguracionesCh c WHERE c.hpe1 = :hpe1")
    , @NamedQuery(name = "ConfiguracionesCh.findByHta1", query = "SELECT c FROM ConfiguracionesCh c WHERE c.hta1 = :hta1")
    , @NamedQuery(name = "ConfiguracionesCh.findByHti1", query = "SELECT c FROM ConfiguracionesCh c WHERE c.hti1 = :hti1")
    , @NamedQuery(name = "ConfiguracionesCh.findByHvs1", query = "SELECT c FROM ConfiguracionesCh c WHERE c.hvs1 = :hvs1")})
public class ConfiguracionesCh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "hat")
    private Integer hat;
    @Column(name = "hco")
    private Integer hco;
    @Column(name = "hga")
    private Integer hga;
    @Column(name = "hic")
    private Integer hic;
    @Column(name = "hi")
    private Integer hi;
    @Column(name = "hpc")
    private Integer hpc;
    @Column(name = "hpe")
    private Integer hpe;
    @Column(name = "hta")
    private Integer hta;
    @Column(name = "hti")
    private Integer hti;
    @Column(name = "hvs")
    private Integer hvs;
    @Column(name = "hat1")
    private Integer hat1;
    @Column(name = "hco1")
    private Integer hco1;
    @Column(name = "hga1")
    private Integer hga1;
    @Column(name = "hic1")
    private Integer hic1;
    @Column(name = "hi1")
    private Integer hi1;
    @Column(name = "hpc1")
    private Integer hpc1;
    @Column(name = "hpe1")
    private Integer hpe1;
    @Column(name = "hta1")
    private Integer hta1;
    @Column(name = "hti1")
    private Integer hti1;
    @Column(name = "hvs1")
    private Integer hvs1;
    @JoinColumn(name = "cod_periodo", referencedColumnName = "id")
    @ManyToOne
    private Periodo codPeriodo;
    @JoinColumn(name = "cod_profesor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios codProfesor;

    public ConfiguracionesCh() {
    }

    public ConfiguracionesCh(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHat() {
        return hat;
    }

    public void setHat(Integer hat) {
        this.hat = hat;
    }

    public Integer getHco() {
        return hco;
    }

    public void setHco(Integer hco) {
        this.hco = hco;
    }

    public Integer getHga() {
        return hga;
    }

    public void setHga(Integer hga) {
        this.hga = hga;
    }

    public Integer getHic() {
        return hic;
    }

    public void setHic(Integer hic) {
        this.hic = hic;
    }

    public Integer getHi() {
        return hi;
    }

    public void setHi(Integer hi) {
        this.hi = hi;
    }

    public Integer getHpc() {
        return hpc;
    }

    public void setHpc(Integer hpc) {
        this.hpc = hpc;
    }

    public Integer getHpe() {
        return hpe;
    }

    public void setHpe(Integer hpe) {
        this.hpe = hpe;
    }

    public Integer getHta() {
        return hta;
    }

    public void setHta(Integer hta) {
        this.hta = hta;
    }

    public Integer getHti() {
        return hti;
    }

    public void setHti(Integer hti) {
        this.hti = hti;
    }

    public Integer getHvs() {
        return hvs;
    }

    public void setHvs(Integer hvs) {
        this.hvs = hvs;
    }

    public Integer getHat1() {
        return hat1;
    }

    public void setHat1(Integer hat1) {
        this.hat1 = hat1;
    }

    public Integer getHco1() {
        return hco1;
    }

    public void setHco1(Integer hco1) {
        this.hco1 = hco1;
    }

    public Integer getHga1() {
        return hga1;
    }

    public void setHga1(Integer hga1) {
        this.hga1 = hga1;
    }

    public Integer getHic1() {
        return hic1;
    }

    public void setHic1(Integer hic1) {
        this.hic1 = hic1;
    }

    public Integer getHi1() {
        return hi1;
    }

    public void setHi1(Integer hi1) {
        this.hi1 = hi1;
    }

    public Integer getHpc1() {
        return hpc1;
    }

    public void setHpc1(Integer hpc1) {
        this.hpc1 = hpc1;
    }

    public Integer getHpe1() {
        return hpe1;
    }

    public void setHpe1(Integer hpe1) {
        this.hpe1 = hpe1;
    }

    public Integer getHta1() {
        return hta1;
    }

    public void setHta1(Integer hta1) {
        this.hta1 = hta1;
    }

    public Integer getHti1() {
        return hti1;
    }

    public void setHti1(Integer hti1) {
        this.hti1 = hti1;
    }

    public Integer getHvs1() {
        return hvs1;
    }

    public void setHvs1(Integer hvs1) {
        this.hvs1 = hvs1;
    }

    public Periodo getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Periodo codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public Usuarios getCodProfesor() {
        return codProfesor;
    }

    public void setCodProfesor(Usuarios codProfesor) {
        this.codProfesor = codProfesor;
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
        if (!(object instanceof ConfiguracionesCh)) {
            return false;
        }
        ConfiguracionesCh other = (ConfiguracionesCh) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ConfiguracionesCh[ id=" + id + " ]";
    }
    
}
