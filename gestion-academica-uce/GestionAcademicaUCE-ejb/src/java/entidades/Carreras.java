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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "carreras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carreras.findAll", query = "SELECT c FROM Carreras c")
    , @NamedQuery(name = "Carreras.findById", query = "SELECT c FROM Carreras c WHERE c.id = :id")
    , @NamedQuery(name = "Carreras.findByNombre", query = "SELECT c FROM Carreras c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Carreras.findByMision", query = "SELECT c FROM Carreras c WHERE c.mision = :mision")
    , @NamedQuery(name = "Carreras.findByVision", query = "SELECT c FROM Carreras c WHERE c.vision = :vision")
    , @NamedQuery(name = "Carreras.findByPerfilEgreso", query = "SELECT c FROM Carreras c WHERE c.perfilEgreso = :perfilEgreso")})
public class Carreras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "mision")
    private String mision;
    @Size(max = 2147483647)
    @Column(name = "vision")
    private String vision;
    @Size(max = 2147483647)
    @Column(name = "perfil_egreso")
    private String perfilEgreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCarrera")
    private List<Asignaturas> asignaturasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCarrera")
    private List<CarreraDirector> carreraDirectorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCarrera")
    private List<Formulario> formularioList;
    @JoinColumn(name = "cod_facultad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Facultades codFacultad;

    public Carreras() {
    }

    public Carreras(Integer id) {
        this.id = id;
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

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getPerfilEgreso() {
        return perfilEgreso;
    }

    public void setPerfilEgreso(String perfilEgreso) {
        this.perfilEgreso = perfilEgreso;
    }

    @XmlTransient
    public List<Asignaturas> getAsignaturasList() {
        return asignaturasList;
    }

    public void setAsignaturasList(List<Asignaturas> asignaturasList) {
        this.asignaturasList = asignaturasList;
    }

    @XmlTransient
    public List<CarreraDirector> getCarreraDirectorList() {
        return carreraDirectorList;
    }

    public void setCarreraDirectorList(List<CarreraDirector> carreraDirectorList) {
        this.carreraDirectorList = carreraDirectorList;
    }

    @XmlTransient
    public List<Formulario> getFormularioList() {
        return formularioList;
    }

    public void setFormularioList(List<Formulario> formularioList) {
        this.formularioList = formularioList;
    }

    public Facultades getCodFacultad() {
        return codFacultad;
    }

    public void setCodFacultad(Facultades codFacultad) {
        this.codFacultad = codFacultad;
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
        if (!(object instanceof Carreras)) {
            return false;
        }
        Carreras other = (Carreras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Carreras[ id=" + id + " ]";
    }
    
}
