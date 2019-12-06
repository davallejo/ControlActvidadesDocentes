/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.sql.Time;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "horario_actividades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorarioActividades.findAll", query = "SELECT h FROM HorarioActividades h")
    , @NamedQuery(name = "HorarioActividades.findById", query = "SELECT h FROM HorarioActividades h WHERE h.id = :id")
    , @NamedQuery(name = "HorarioActividades.findByDia", query = "SELECT h FROM HorarioActividades h WHERE h.dia = :dia")
    , @NamedQuery(name = "HorarioActividades.findByHoraInicio", query = "SELECT h FROM HorarioActividades h WHERE h.horaInicio = :horaInicio")
    , @NamedQuery(name = "HorarioActividades.findByHoraFin", query = "SELECT h FROM HorarioActividades h WHERE h.horaFin = :horaFin")})
public class HorarioActividades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dia")
    private Integer dia;
    @Column(name = "hora_inicio")
    //@Temporal(TemporalType.TIME)
    private Time horaInicio;
    @Column(name = "hora_fin")
    //@Temporal(TemporalType.TIME)
    private Time horaFin;
    @JoinColumn(name = "id_curso_aula", referencedColumnName = "id")
    @ManyToOne
    private CursoAula idCursoAula;
    @JoinColumn(name = "id_periodo", referencedColumnName = "id")
    @ManyToOne
    private Periodo idPeriodo;
    @JoinColumn(name = "id_tipoch", referencedColumnName = "id")
    @ManyToOne
    private TipoCh idTipoch;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idUsuario;

    public HorarioActividades() {
    }

    public HorarioActividades(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public CursoAula getIdCursoAula() {
        return idCursoAula;
    }

    public void setIdCursoAula(CursoAula idCursoAula) {
        this.idCursoAula = idCursoAula;
    }

    public Periodo getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Periodo idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public TipoCh getIdTipoch() {
        return idTipoch;
    }

    public void setIdTipoch(TipoCh idTipoch) {
        this.idTipoch = idTipoch;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof HorarioActividades)) {
            return false;
        }
        HorarioActividades other = (HorarioActividades) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HorarioActividades[ id=" + id + " ]";
    }
    
}
