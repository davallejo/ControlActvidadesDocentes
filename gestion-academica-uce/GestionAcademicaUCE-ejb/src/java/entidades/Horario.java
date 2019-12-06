/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h")
    , @NamedQuery(name = "Horario.findByIdHorario", query = "SELECT h FROM Horario h WHERE h.idHorario = :idHorario")
    , @NamedQuery(name = "Horario.findByCodigoHorario", query = "SELECT h FROM Horario h WHERE h.codigoHorario = :codigoHorario")
    , @NamedQuery(name = "Horario.findByHoraHorario", query = "SELECT h FROM Horario h WHERE h.horaHorario = :horaHorario")
    , @NamedQuery(name = "Horario.findByActLunHorario", query = "SELECT h FROM Horario h WHERE h.actLunHorario = :actLunHorario")
    , @NamedQuery(name = "Horario.findByCurLunHorario", query = "SELECT h FROM Horario h WHERE h.curLunHorario = :curLunHorario")
    , @NamedQuery(name = "Horario.findByActMarHorario", query = "SELECT h FROM Horario h WHERE h.actMarHorario = :actMarHorario")
    , @NamedQuery(name = "Horario.findByCurMarHorario", query = "SELECT h FROM Horario h WHERE h.curMarHorario = :curMarHorario")
    , @NamedQuery(name = "Horario.findByActMieHorario", query = "SELECT h FROM Horario h WHERE h.actMieHorario = :actMieHorario")
    , @NamedQuery(name = "Horario.findByCurMieHorario", query = "SELECT h FROM Horario h WHERE h.curMieHorario = :curMieHorario")
    , @NamedQuery(name = "Horario.findByActJueHorario", query = "SELECT h FROM Horario h WHERE h.actJueHorario = :actJueHorario")
    , @NamedQuery(name = "Horario.findByCurJueHorario", query = "SELECT h FROM Horario h WHERE h.curJueHorario = :curJueHorario")
    , @NamedQuery(name = "Horario.findByActVieHorario", query = "SELECT h FROM Horario h WHERE h.actVieHorario = :actVieHorario")
    , @NamedQuery(name = "Horario.findByCurVieHorario", query = "SELECT h FROM Horario h WHERE h.curVieHorario = :curVieHorario")
    , @NamedQuery(name = "Horario.findByActSabHorario", query = "SELECT h FROM Horario h WHERE h.actSabHorario = :actSabHorario")
    , @NamedQuery(name = "Horario.findByCurSabHorario", query = "SELECT h FROM Horario h WHERE h.curSabHorario = :curSabHorario")})
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_horario")
    private Integer idHorario;
    @Column(name = "codigo_horario")
    private Integer codigoHorario;
    @Size(max = 15)
    @Column(name = "hora_horario")
    private String horaHorario;
    @Size(max = 100)
    @Column(name = "act_lun_horario")
    private String actLunHorario;
    @Size(max = 24)
    @Column(name = "cur_lun_horario")
    private String curLunHorario;
    @Size(max = 100)
    @Column(name = "act_mar_horario")
    private String actMarHorario;
    @Size(max = 24)
    @Column(name = "cur_mar_horario")
    private String curMarHorario;
    @Size(max = 100)
    @Column(name = "act_mie_horario")
    private String actMieHorario;
    @Size(max = 24)
    @Column(name = "cur_mie_horario")
    private String curMieHorario;
    @Size(max = 100)
    @Column(name = "act_jue_horario")
    private String actJueHorario;
    @Size(max = 24)
    @Column(name = "cur_jue_horario")
    private String curJueHorario;
    @Size(max = 100)
    @Column(name = "act_vie_horario")
    private String actVieHorario;
    @Size(max = 24)
    @Column(name = "cur_vie_horario")
    private String curVieHorario;
    @Size(max = 100)
    @Column(name = "act_sab_horario")
    private String actSabHorario;
    @Size(max = 24)
    @Column(name = "cur_sab_horario")
    private String curSabHorario;
   

    public Horario() {
    }

    public Horario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Integer getCodigoHorario() {
        return codigoHorario;
    }

    public void setCodigoHorario(Integer codigoHorario) {
        this.codigoHorario = codigoHorario;
    }

    public String getHoraHorario() {
        return horaHorario;
    }

    public void setHoraHorario(String horaHorario) {
        this.horaHorario = horaHorario;
    }

    public String getActLunHorario() {
        return actLunHorario;
    }

    public void setActLunHorario(String actLunHorario) {
        this.actLunHorario = actLunHorario;
    }

    public String getCurLunHorario() {
        return curLunHorario;
    }

    public void setCurLunHorario(String curLunHorario) {
        this.curLunHorario = curLunHorario;
    }

    public String getActMarHorario() {
        return actMarHorario;
    }

    public void setActMarHorario(String actMarHorario) {
        this.actMarHorario = actMarHorario;
    }

    public String getCurMarHorario() {
        return curMarHorario;
    }

    public void setCurMarHorario(String curMarHorario) {
        this.curMarHorario = curMarHorario;
    }

    public String getActMieHorario() {
        return actMieHorario;
    }

    public void setActMieHorario(String actMieHorario) {
        this.actMieHorario = actMieHorario;
    }

    public String getCurMieHorario() {
        return curMieHorario;
    }

    public void setCurMieHorario(String curMieHorario) {
        this.curMieHorario = curMieHorario;
    }

    public String getActJueHorario() {
        return actJueHorario;
    }

    public void setActJueHorario(String actJueHorario) {
        this.actJueHorario = actJueHorario;
    }

    public String getCurJueHorario() {
        return curJueHorario;
    }

    public void setCurJueHorario(String curJueHorario) {
        this.curJueHorario = curJueHorario;
    }

    public String getActVieHorario() {
        return actVieHorario;
    }

    public void setActVieHorario(String actVieHorario) {
        this.actVieHorario = actVieHorario;
    }

    public String getCurVieHorario() {
        return curVieHorario;
    }

    public void setCurVieHorario(String curVieHorario) {
        this.curVieHorario = curVieHorario;
    }

    public String getActSabHorario() {
        return actSabHorario;
    }

    public void setActSabHorario(String actSabHorario) {
        this.actSabHorario = actSabHorario;
    }

    public String getCurSabHorario() {
        return curSabHorario;
    }

    public void setCurSabHorario(String curSabHorario) {
        this.curSabHorario = curSabHorario;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHorario != null ? idHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.idHorario == null && other.idHorario != null) || (this.idHorario != null && !this.idHorario.equals(other.idHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Horario[ idHorario=" + idHorario + " ]";
    }
    
}
