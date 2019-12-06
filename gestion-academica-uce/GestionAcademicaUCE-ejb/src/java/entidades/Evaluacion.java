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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pochini
 */
@Entity
@Table(name = "evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e")
    , @NamedQuery(name = "Evaluacion.findById", query = "SELECT e FROM Evaluacion e WHERE e.id = :id")
    , @NamedQuery(name = "Evaluacion.findByEvalPractica1h", query = "SELECT e FROM Evaluacion e WHERE e.evalPractica1h = :evalPractica1h")
    , @NamedQuery(name = "Evaluacion.findByEvalAutonomo1h", query = "SELECT e FROM Evaluacion e WHERE e.evalAutonomo1h = :evalAutonomo1h")
    , @NamedQuery(name = "Evaluacion.findByEvalTrabajosIndiv1h", query = "SELECT e FROM Evaluacion e WHERE e.evalTrabajosIndiv1h = :evalTrabajosIndiv1h")
    , @NamedQuery(name = "Evaluacion.findByEvalTrabajosGrup1h", query = "SELECT e FROM Evaluacion e WHERE e.evalTrabajosGrup1h = :evalTrabajosGrup1h")
    , @NamedQuery(name = "Evaluacion.findByEvalTrabajosIntegrador1h", query = "SELECT e FROM Evaluacion e WHERE e.evalTrabajosIntegrador1h = :evalTrabajosIntegrador1h")
    , @NamedQuery(name = "Evaluacion.findByEvalPractica2h", query = "SELECT e FROM Evaluacion e WHERE e.evalPractica2h = :evalPractica2h")
    , @NamedQuery(name = "Evaluacion.findByEvalAtonomo2h", query = "SELECT e FROM Evaluacion e WHERE e.evalAtonomo2h = :evalAtonomo2h")
    , @NamedQuery(name = "Evaluacion.findByEvalTrabajosIndiv2h", query = "SELECT e FROM Evaluacion e WHERE e.evalTrabajosIndiv2h = :evalTrabajosIndiv2h")
    , @NamedQuery(name = "Evaluacion.findByEvalTrabajosGrup2h", query = "SELECT e FROM Evaluacion e WHERE e.evalTrabajosGrup2h = :evalTrabajosGrup2h")
    , @NamedQuery(name = "Evaluacion.findByEvalTrabajosIntegrador2h", query = "SELECT e FROM Evaluacion e WHERE e.evalTrabajosIntegrador2h = :evalTrabajosIntegrador2h")})
public class Evaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "eval_practica_1h")
    private Integer evalPractica1h;
    @Column(name = "eval_autonomo_1h")
    private Integer evalAutonomo1h;
    @Column(name = "eval_trabajos_indiv_1h")
    private Integer evalTrabajosIndiv1h;
    @Column(name = "eval_trabajos_grup_1h")
    private Integer evalTrabajosGrup1h;
    @Column(name = "eval_trabajos_integrador_1h")
    private Integer evalTrabajosIntegrador1h;
    @Column(name = "eval_practica_2h")
    private Integer evalPractica2h;
    @Column(name = "eval_atonomo_2h")
    private Integer evalAtonomo2h;
    @Column(name = "eval_trabajos_indiv_2h")
    private Integer evalTrabajosIndiv2h;
    @Column(name = "eval_trabajos_grup_2h")
    private Integer evalTrabajosGrup2h;
    @Column(name = "eval_trabajos_integrador_2h")
    private Integer evalTrabajosIntegrador2h;
    @OneToMany(mappedBy = "codEvaluacion")
    private List<Silabos> silabosList;

    public Evaluacion() {
    }

    public Evaluacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEvalPractica1h() {
        return evalPractica1h;
    }

    public void setEvalPractica1h(Integer evalPractica1h) {
        this.evalPractica1h = evalPractica1h;
    }

    public Integer getEvalAutonomo1h() {
        return evalAutonomo1h;
    }

    public void setEvalAutonomo1h(Integer evalAutonomo1h) {
        this.evalAutonomo1h = evalAutonomo1h;
    }

    public Integer getEvalTrabajosIndiv1h() {
        return evalTrabajosIndiv1h;
    }

    public void setEvalTrabajosIndiv1h(Integer evalTrabajosIndiv1h) {
        this.evalTrabajosIndiv1h = evalTrabajosIndiv1h;
    }

    public Integer getEvalTrabajosGrup1h() {
        return evalTrabajosGrup1h;
    }

    public void setEvalTrabajosGrup1h(Integer evalTrabajosGrup1h) {
        this.evalTrabajosGrup1h = evalTrabajosGrup1h;
    }

    public Integer getEvalTrabajosIntegrador1h() {
        return evalTrabajosIntegrador1h;
    }

    public void setEvalTrabajosIntegrador1h(Integer evalTrabajosIntegrador1h) {
        this.evalTrabajosIntegrador1h = evalTrabajosIntegrador1h;
    }

    public Integer getEvalPractica2h() {
        return evalPractica2h;
    }

    public void setEvalPractica2h(Integer evalPractica2h) {
        this.evalPractica2h = evalPractica2h;
    }

    public Integer getEvalAtonomo2h() {
        return evalAtonomo2h;
    }

    public void setEvalAtonomo2h(Integer evalAtonomo2h) {
        this.evalAtonomo2h = evalAtonomo2h;
    }

    public Integer getEvalTrabajosIndiv2h() {
        return evalTrabajosIndiv2h;
    }

    public void setEvalTrabajosIndiv2h(Integer evalTrabajosIndiv2h) {
        this.evalTrabajosIndiv2h = evalTrabajosIndiv2h;
    }

    public Integer getEvalTrabajosGrup2h() {
        return evalTrabajosGrup2h;
    }

    public void setEvalTrabajosGrup2h(Integer evalTrabajosGrup2h) {
        this.evalTrabajosGrup2h = evalTrabajosGrup2h;
    }

    public Integer getEvalTrabajosIntegrador2h() {
        return evalTrabajosIntegrador2h;
    }

    public void setEvalTrabajosIntegrador2h(Integer evalTrabajosIntegrador2h) {
        this.evalTrabajosIntegrador2h = evalTrabajosIntegrador2h;
    }

    @XmlTransient
    public List<Silabos> getSilabosList() {
        return silabosList;
    }

    public void setSilabosList(List<Silabos> silabosList) {
        this.silabosList = silabosList;
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
        if (!(object instanceof Evaluacion)) {
            return false;
        }
        Evaluacion other = (Evaluacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Evaluacion[ id=" + id + " ]";
    }
    
}
