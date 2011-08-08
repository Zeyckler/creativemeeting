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
@Table(name = "tiporeuniones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiporeuniones.findAll", query = "SELECT t FROM Tiporeuniones t"),
    @NamedQuery(name = "Tiporeuniones.findByIdtipo", query = "SELECT t FROM Tiporeuniones t WHERE t.idtipo = :idtipo"),
    @NamedQuery(name = "Tiporeuniones.findByTiporeunion", query = "SELECT t FROM Tiporeuniones t WHERE t.tiporeunion = :tiporeunion")})
public class Tiporeuniones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipo")
    private Integer idtipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "tiporeunion")
    private String tiporeunion;
    @OneToMany(mappedBy = "idtipo")
    private Collection<Reuniones> reunionesCollection;

    public Tiporeuniones() {
    }

    public Tiporeuniones(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public Tiporeuniones(Integer idtipo, String tiporeunion) {
        this.idtipo = idtipo;
        this.tiporeunion = tiporeunion;
    }

    public Tiporeuniones(String tiporeunion) {
        this.tiporeunion = tiporeunion;
    }
    

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public String getTiporeunion() {
        return tiporeunion;
    }

    public void setTiporeunion(String tiporeunion) {
        this.tiporeunion = tiporeunion;
    }

    @XmlTransient
    public Collection<Reuniones> getReunionesCollection() {
        return reunionesCollection;
    }

    public void setReunionesCollection(Collection<Reuniones> reunionesCollection) {
        this.reunionesCollection = reunionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipo != null ? idtipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiporeuniones)) {
            return false;
        }
        Tiporeuniones other = (Tiporeuniones) object;
        if ((this.idtipo == null && other.idtipo != null) || (this.idtipo != null && !this.idtipo.equals(other.idtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.Tiporeuniones[ idtipo=" + idtipo + " ]";
    }
    
}
