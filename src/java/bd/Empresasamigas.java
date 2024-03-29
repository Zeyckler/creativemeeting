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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AntonioCZ
 */
@Entity
@Table(name = "empresasamigas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresasamigas.findAll", query = "SELECT e FROM Empresasamigas e"),
    @NamedQuery(name = "Empresasamigas.findByIdempresasamigas", query = "SELECT e FROM Empresasamigas e WHERE e.idempresasamigas = :idempresasamigas"),
    @NamedQuery(name = "Empresasamigas.findByActivacioninicial", query = "SELECT e FROM Empresasamigas e WHERE e.activacioninicial = :activacioninicial"),
    @NamedQuery(name = "Empresasamigas.findByActivo", query = "SELECT e FROM Empresasamigas e WHERE e.activo = :activo"),
    @NamedQuery(name = "Empresasamigas.findEmpresasAmigas1", query = "SELECT e.nif2.nif, e.nif2.razonsocial, e.nif2.telefono, e.nif2.fax, e.nif2.direccion, e.nif2.email, e.nif2.localidad, e.nif2.provincia, e.nif2.pais, e.nif2.codigopostal, e.nif2.web   FROM Empresasamigas e JOIN e.nif1 empresa WHERE empresa.nif = :nifempresa AND e.activacioninicial= :activacion AND e.activo = :activo"),
    @NamedQuery(name = "Empresasamigas.findEmpresasAmigas2", query = "SELECT e.nif1.nif, e.nif1.razonsocial, e.nif1.telefono, e.nif1.fax, e.nif1.direccion, e.nif1.email, e.nif1.localidad, e.nif1.provincia, e.nif1.pais, e.nif1.codigopostal, e.nif1.web   FROM Empresasamigas e JOIN e.nif2 empresa WHERE empresa.nif = :nifempresa AND e.activacioninicial= :activacion AND e.activo = :activo"),
    @NamedQuery(name = "Empresasamigas.findParejaEmpresasAmigas", query = "SELECT e FROM Empresasamigas e WHERE (e.nif1.nif= :nif1 AND e.nif2.nif= :nif2 AND e.activacioninicial= :activacion AND e.activo = :activo ) OR (e.nif1.nif= :nif2 AND e.nif2.nif= :nif1 AND e.activacioninicial= :activacion AND e.activo = :activo)"),
    @NamedQuery(name = "Empresasamigas.findEmpresasAmigasInactivas", query = "SELECT e FROM Empresasamigas e WHERE (e.nif1.nif= :nif1 AND e.nif2.nif= :nif2 AND e.activacioninicial= :activacion AND e.activo = :activo ) OR (e.nif1.nif= :nif2 AND e.nif2.nif= :nif1 AND e.activacioninicial= :activacion AND e.activo = :activo)"),
    @NamedQuery(name = "Empresasamigas.findEmpresasAmigasNotificacion", query = "SELECT e FROM Empresasamigas e WHERE (e.nif2.nif= :nif2 AND e.activacioninicial= :activacion AND e.activo = :activo )")
})
public class Empresasamigas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idempresasamigas")
    private Integer idempresasamigas;
    @Column(name = "activacioninicial")
    private Boolean activacioninicial;
    @Column(name = "activo")
    private Boolean activo;
    @JoinColumn(name = "nif2", referencedColumnName = "nif")
    @ManyToOne(optional = false)
    private Empresas nif2;
    @JoinColumn(name = "nif1", referencedColumnName = "nif")
    @ManyToOne(optional = false)
    private Empresas nif1;
    
    public static final String BUSCAR_EMPRESAS_AMIGAS_1= "Empresasamigas.findEmpresasAmigas1";
    public static final String BUSCAR_EMPRESAS_AMIGAS_2= "Empresasamigas.findEmpresasAmigas2";

    public Empresasamigas() {
    }

    public Empresasamigas(Empresas nif1, Empresas nif2) {
        this.idempresasamigas= new Integer(1);
        this.activacioninicial = true;
        this.activo= false;
        this.nif1 = nif1;
        this.nif2 = nif2;
        
    }
    
    

    public Empresasamigas(Integer idempresasamigas) {
        this.idempresasamigas = idempresasamigas;
    }

    public Integer getIdempresasamigas() {
        return idempresasamigas;
    }

    public void setIdempresasamigas(Integer idempresasamigas) {
        this.idempresasamigas = idempresasamigas;
    }

    public Boolean getActivacioninicial() {
        return activacioninicial;
    }

    public void setActivacioninicial(Boolean activacioninicial) {
        this.activacioninicial = activacioninicial;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Empresas getNif2() {
        return nif2;
    }

    public void setNif2(Empresas nif2) {
        this.nif2 = nif2;
    }

    public Empresas getNif1() {
        return nif1;
    }

    public void setNif1(Empresas nif1) {
        this.nif1 = nif1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempresasamigas != null ? idempresasamigas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresasamigas)) {
            return false;
        }
        Empresasamigas other = (Empresasamigas) object;
        if ((this.idempresasamigas == null && other.idempresasamigas != null) || (this.idempresasamigas != null && !this.idempresasamigas.equals(other.idempresasamigas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.Empresasamigas[ idempresasamigas=" + idempresasamigas + " ]";
    }
    
}
