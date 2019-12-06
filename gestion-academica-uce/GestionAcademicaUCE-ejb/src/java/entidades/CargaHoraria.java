
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "carga_horaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CargaHoraria.findAll", query = "SELECT c FROM CargaHoraria c")
    , @NamedQuery(name = "CargaHoraria.findByTipoYFecha", query = "SELECT c FROM CargaHoraria c WHERE c.codTipoCh = :tipoCarga AND c.fecha >= :fecha")
    , @NamedQuery(name = "CargaHoraria.findByTipoYFechaYUser", query = "SELECT c FROM CargaHoraria c WHERE c.codTipoCh = :tipoCarga AND c.fecha >= :fecha AND c.codDocente =:ci ")
    , @NamedQuery(name = "CargaHoraria.findById", query = "SELECT c FROM CargaHoraria c WHERE c.id = :id")
    , @NamedQuery(name = "CargaHoraria.findByFecha", query = "SELECT c FROM CargaHoraria c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "CargaHoraria.findByHoraInicial", query = "SELECT c FROM CargaHoraria c WHERE c.horaInicial = :horaInicial")
    , @NamedQuery(name = "CargaHoraria.findByHoraFin", query = "SELECT c FROM CargaHoraria c WHERE c.horaFin = :horaFin")
    , @NamedQuery(name = "CargaHoraria.findByTema", query = "SELECT c FROM CargaHoraria c WHERE c.tema = :tema")
    , @NamedQuery(name = "CargaHoraria.findByHorario", query = "SELECT c FROM CargaHoraria c WHERE c.horario = :horario")})
public class CargaHoraria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "hora_inicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicial;
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFin;
    @Size(max = 2147483647)
    @Column(name = "tema")
    private String tema;
    @Size(max = 255)
    @Column(name = "horario")
    private String horario;
    @JoinColumn(name = "cod_tipo_ch", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoCh codTipoCh;
    @JoinColumn(name = "cod_docente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios codDocente;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "codCargaHoraria")
    private List<DetalleCh> detalleChList;

    public CargaHoraria() {
    }

    public CargaHoraria(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public TipoCh getCodTipoCh() {
        return codTipoCh;
    }

    public void setCodTipoCh(TipoCh codTipoCh) {
        this.codTipoCh = codTipoCh;
    }

    public Usuarios getCodDocente() {
        return codDocente;
    }

    public void setCodDocente(Usuarios codDocente) {
        this.codDocente = codDocente;
    }

    @XmlTransient
    public List<DetalleCh> getDetalleChList() {
        return detalleChList;
    }

    public void setDetalleChList(List<DetalleCh> detalleChList) {
        this.detalleChList = detalleChList;
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
        if (!(object instanceof CargaHoraria)) {
            return false;
        }
        CargaHoraria other = (CargaHoraria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CargaHoraria[ id=" + id + " ]";
    }
    
}
