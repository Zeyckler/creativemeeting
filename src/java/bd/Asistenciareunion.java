/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "asistenciareunion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistenciareunion.findAll", query = "SELECT a FROM Asistenciareunion a"),
    @NamedQuery(name = "Asistenciareunion.findByIdasistenciareunion", query = "SELECT a FROM Asistenciareunion a WHERE a.idasistenciareunion = :idasistenciareunion")})
public class Asistenciareunion implements Serializable {
    @Column(name = "notificacion")
    private Boolean notificacion;
    @Column(name = "respuesta")
    private Boolean respuesta;
    @Column(name = "asistencia")
    private Boolean asistencia;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idasistenciareunion")
    private Integer idasistenciareunion;
    @JoinColumn(name = "idreunion", referencedColumnName = "idreunion")
    @ManyToOne
    private Reuniones idreunion;
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    @ManyToOne
    private Usuarios dni;
    @OneToMany(mappedBy = "idasistenciareunion")
    private Collection<Intervenciones> intervencionesCollection;

    public Asistenciareunion() {
    }

    public Asistenciareunion(Integer idasistenciareunion) {
        this.idasistenciareunion = idasistenciareunion;
    }
    
    public Asistenciareunion(Usuarios usuario, Reuniones reunion ){
        this.dni=usuario;
        this.idreunion=reunion;
    }

    public Asistenciareunion(Integer idasistenciareunion, Reuniones idreunion, Usuarios dni) {
        this.idasistenciareunion = idasistenciareunion;
        this.idreunion = idreunion;
        this.dni = dni;
    }
    

    public Integer getIdasistenciareunion() {
        return idasistenciareunion;
    }

    public void setIdasistenciareunion(Integer idasistenciareunion) {
        this.idasistenciareunion = idasistenciareunion;
    }

    public Reuniones getIdreunion() {
        return idreunion;
    }

    public void setIdreunion(Reuniones idreunion) {
        this.idreunion = idreunion;
    }

    public Usuarios getDni() {
        return dni;
    }

    public void setDni(Usuarios dni) {
        this.dni = dni;
    }

    @XmlTransient
    public Collection<Intervenciones> getIntervencionesCollection() {
        return intervencionesCollection;
    }

    public void setIntervencionesCollection(Collection<Intervenciones> intervencionesCollection) {
        this.intervencionesCollection = intervencionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasistenciareunion != null ? idasistenciareunion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistenciareunion)) {
            return false;
        }
        Asistenciareunion other = (Asistenciareunion) object;
        if ((this.idasistenciareunion == null && other.idasistenciareunion != null) || (this.idasistenciareunion != null && !this.idasistenciareunion.equals(other.idasistenciareunion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.Asistenciareunion[ idasistenciareunion=" + idasistenciareunion + " ]";
    }

    public Boolean getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(Boolean notificacion) {
        this.notificacion = notificacion;
    }

    public Boolean getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Boolean respuesta) {
        this.respuesta = respuesta;
    }

    public Boolean getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Boolean asistencia) {
        this.asistencia = asistencia;
    }
    
}
