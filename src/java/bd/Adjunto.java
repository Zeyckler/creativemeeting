/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "adjunto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adjunto.findAll", query = "SELECT a FROM Adjunto a"),
    @NamedQuery(name = "Adjunto.findByIdadjunto", query = "SELECT a FROM Adjunto a WHERE a.idadjunto = :idadjunto"),
    @NamedQuery(name = "Adjunto.findByRutaarchivo", query = "SELECT a FROM Adjunto a WHERE a.rutaarchivo = :rutaarchivo")})
public class Adjunto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idadjunto")
    private Integer idadjunto;
    @Size(max = 255)
    @Column(name = "rutaarchivo")
    private String rutaarchivo;
    @JoinColumn(name = "idreunion", referencedColumnName = "idreunion")
    @ManyToOne
    private Reuniones idreunion;

    public Adjunto() {
    }

    public Adjunto(Integer idadjunto) {
        this.idadjunto = idadjunto;
    }

    public Adjunto(String rutaarchivo, Reuniones idreunion) {
        this.rutaarchivo = rutaarchivo;
        this.idreunion = idreunion;
    }

    public Adjunto(Integer idadjunto, String rutaarchivo, Reuniones idreunion) {
        this.idadjunto = idadjunto;
        this.rutaarchivo = rutaarchivo;
        this.idreunion = idreunion;
    }
    
    
    public Integer getIdadjunto() {
        return idadjunto;
    }

    public void setIdadjunto(Integer idadjunto) {
        this.idadjunto = idadjunto;
    }

    public String getRutaarchivo() {
        return rutaarchivo;
    }

    public void setRutaarchivo(String rutaarchivo) {
        this.rutaarchivo = rutaarchivo;
    }

    public Reuniones getIdreunion() {
        return idreunion;
    }

    public void setIdreunion(Reuniones idreunion) {
        this.idreunion = idreunion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadjunto != null ? idadjunto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adjunto)) {
            return false;
        }
        Adjunto other = (Adjunto) object;
        if ((this.idadjunto == null && other.idadjunto != null) || (this.idadjunto != null && !this.idadjunto.equals(other.idadjunto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.Adjunto[ idadjunto=" + idadjunto + " ]";
    }
    
}
