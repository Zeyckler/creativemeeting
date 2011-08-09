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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "puntosdeldia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puntosdeldia.findAll", query = "SELECT p FROM Puntosdeldia p"),
    @NamedQuery(name = "Puntosdeldia.findByIdpuntodeldia", query = "SELECT p FROM Puntosdeldia p WHERE p.idpuntodeldia = :idpuntodeldia"),
    @NamedQuery(name = "Puntosdeldia.findByTitulopunto", query = "SELECT p FROM Puntosdeldia p WHERE p.titulopunto = :titulopunto")})
public class Puntosdeldia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpuntodeldia")
    private Integer idpuntodeldia;
    @Size(max = 255)
    @Column(name = "titulopunto")
    private String titulopunto;
    @JoinColumn(name = "idreunion", referencedColumnName = "idreunion")
    @ManyToOne
    private Reuniones idreunion;
    @OneToMany(mappedBy = "idpuntodeldia")
    private Collection<Intervenciones> intervencionesCollection;

    public Puntosdeldia() {
    }

    public Puntosdeldia(Integer idpuntodeldia) {
        this.idpuntodeldia = idpuntodeldia;
    }

    public Puntosdeldia(String titulopunto, Reuniones idreunion) {
        this.titulopunto = titulopunto;
        this.idreunion = idreunion;
    }

    public Puntosdeldia(Integer idpuntodeldia, String titulopunto, Reuniones idreunion) {
        this.idpuntodeldia = idpuntodeldia;
        this.titulopunto = titulopunto;
        this.idreunion = idreunion;
    }
    

    public Integer getIdpuntodeldia() {
        return idpuntodeldia;
    }

    public void setIdpuntodeldia(Integer idpuntodeldia) {
        this.idpuntodeldia = idpuntodeldia;
    }

    public String getTitulopunto() {
        return titulopunto;
    }

    public void setTitulopunto(String titulopunto) {
        this.titulopunto = titulopunto;
    }

    public Reuniones getIdreunion() {
        return idreunion;
    }

    public void setIdreunion(Reuniones idreunion) {
        this.idreunion = idreunion;
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
        hash += (idpuntodeldia != null ? idpuntodeldia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puntosdeldia)) {
            return false;
        }
        Puntosdeldia other = (Puntosdeldia) object;
        if ((this.idpuntodeldia == null && other.idpuntodeldia != null) || (this.idpuntodeldia != null && !this.idpuntodeldia.equals(other.idpuntodeldia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.Puntosdeldia[ idpuntodeldia=" + idpuntodeldia + " ]";
    }
    
}
