/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "intervenciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Intervenciones.findAll", query = "SELECT i FROM Intervenciones i"),
    @NamedQuery(name = "Intervenciones.findByIdintervenciones", query = "SELECT i FROM Intervenciones i WHERE i.idintervenciones = :idintervenciones"),
    @NamedQuery(name = "Intervenciones.findByMomentointervencion", query = "SELECT i FROM Intervenciones i WHERE i.momentointervencion = :momentointervencion")})
public class Intervenciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idintervenciones")
    private Integer idintervenciones;
    @Column(name = "momentointervencion")
    @Temporal(TemporalType.TIME)
    private Date momentointervencion;
    @Lob
    @Size(max = 65535)
    @Column(name = "intervencion")
    private String intervencion;
    @JoinColumn(name = "idpuntodeldia", referencedColumnName = "idpuntodeldia")
    @ManyToOne
    private Puntosdeldia idpuntodeldia;
    @JoinColumn(name = "idasistenciareunion", referencedColumnName = "idasistenciareunion")
    @ManyToOne
    private Asistenciareunion idasistenciareunion;

    public Intervenciones() {
    }

    public Intervenciones(Integer idintervenciones) {
        this.idintervenciones = idintervenciones;
    }

    public Integer getIdintervenciones() {
        return idintervenciones;
    }

    public void setIdintervenciones(Integer idintervenciones) {
        this.idintervenciones = idintervenciones;
    }

    public Date getMomentointervencion() {
        return momentointervencion;
    }

    public void setMomentointervencion(Date momentointervencion) {
        this.momentointervencion = momentointervencion;
    }

    public String getIntervencion() {
        return intervencion;
    }

    public void setIntervencion(String intervencion) {
        this.intervencion = intervencion;
    }

    public Puntosdeldia getIdpuntodeldia() {
        return idpuntodeldia;
    }

    public void setIdpuntodeldia(Puntosdeldia idpuntodeldia) {
        this.idpuntodeldia = idpuntodeldia;
    }

    public Asistenciareunion getIdasistenciareunion() {
        return idasistenciareunion;
    }

    public void setIdasistenciareunion(Asistenciareunion idasistenciareunion) {
        this.idasistenciareunion = idasistenciareunion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idintervenciones != null ? idintervenciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Intervenciones)) {
            return false;
        }
        Intervenciones other = (Intervenciones) object;
        if ((this.idintervenciones == null && other.idintervenciones != null) || (this.idintervenciones != null && !this.idintervenciones.equals(other.idintervenciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BD.Intervenciones[ idintervenciones=" + idintervenciones + " ]";
    }
    
}
