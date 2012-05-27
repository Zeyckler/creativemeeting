/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "salasreuniones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salasreuniones.findAll", query = "SELECT s FROM Salasreuniones s"),
    @NamedQuery(name = "Salasreuniones.findByIdsalareunion", query = "SELECT s FROM Salasreuniones s WHERE s.idsalareunion = :idsalareunion"),
    @NamedQuery(name = "Salasreuniones.findByDireccion", query = "SELECT s FROM Salasreuniones s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "Salasreuniones.findByCodigopostal", query = "SELECT s FROM Salasreuniones s WHERE s.codigopostal = :codigopostal"),
    @NamedQuery(name = "Salasreuniones.findByLocalidad", query = "SELECT s FROM Salasreuniones s WHERE s.localidad = :localidad"),
    @NamedQuery(name = "Salasreuniones.findByProvincia", query = "SELECT s FROM Salasreuniones s WHERE s.provincia = :provincia"),
    @NamedQuery(name = "Salasreuniones.findByPais", query = "SELECT s FROM Salasreuniones s WHERE s.pais = :pais"),
    @NamedQuery(name = "Salasreuniones.findByCapacidad", query = "SELECT s FROM Salasreuniones s WHERE s.capacidad = :capacidad"),
    @NamedQuery(name = "Salasreuniones.findByCostealquiler", query = "SELECT s FROM Salasreuniones s WHERE s.costealquiler = :costealquiler"),
    @NamedQuery(name = "Salasreuniones.findByTelefono", query = "SELECT s FROM Salasreuniones s WHERE s.telefono = :telefono"),
    @NamedQuery(name = "Salasreuniones.findsalaslibresreunion1", query = "SELECT s FROM Salasreuniones s LEFT JOIN s.reunionesCollection reunion WHERE ( reunion.fechainicial NOT BETWEEN :fechinicial  AND :fechfinal) OR (reunion.fechafinalestimada  NOT BETWEEN :fechinicial  AND :fechfinal ) OR reunion.fechainicial IS NULL OR reunion.fechafinalestimada IS NULL   "),
    @NamedQuery(name = "Salasreuniones.findsalaslibresreunion", query = "SELECT DISTINCT s FROM Salasreuniones s LEFT JOIN s.reunionesCollection reunion WHERE ( :fechinicial < reunion.fechainicial   AND :fechfinal <= reunion.fechainicial ) OR ( :fechfinal > reunion.fechafinalestimada   AND  :fechinicial >= reunion.fechafinalestimada ) OR reunion.fechainicial IS NULL OR reunion.fechafinalestimada IS NULL   ")
})
public class Salasreuniones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsalareunion")
    private Integer idsalareunion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 255)
    @Column(name = "nombresala")
    private String nombresala;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigopostal")
    private String codigopostal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "localidad")
    private String localidad;
    @Size(max = 200)
    @Column(name = "provincia")
    private String provincia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacidad")
    private int capacidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "costealquiler")
    private BigDecimal costealquiler;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    @OneToMany(mappedBy = "idsalareunion")
    private Collection<Reuniones> reunionesCollection;
    @JoinColumn(name = "nif", referencedColumnName = "nif")
    @ManyToOne
    private Empresas nif;
    /*Espacio reservado para las consultas*/
    public static final String BUSCAR_SALASLIBREFECHA = "Salasreuniones.findsalaslibresreunion";

    public Salasreuniones() {
    }

    public Salasreuniones(Integer idsalareunion) {
        this.idsalareunion = idsalareunion;
    }

    public Salasreuniones(Integer idsalareunion, String direccion, String codigopostal, String localidad, String pais, int capacidad, BigDecimal costealquiler, int telefono) {
        this.idsalareunion = idsalareunion;
        this.direccion = direccion;
        this.codigopostal = codigopostal;
        this.localidad = localidad;
        this.pais = pais;
        this.capacidad = capacidad;
        this.costealquiler = costealquiler;
        this.telefono = telefono;
    }

    public Salasreuniones(String direccion, String codigopostal, String localidad, String provincia, String pais, int capacidad, BigDecimal costealquiler, int telefono) {
        this.direccion = direccion;
        this.codigopostal = codigopostal;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
        this.capacidad = capacidad;
        this.costealquiler = costealquiler;
        this.telefono = telefono;
    }

    public Salasreuniones(String direccion, String codigopostal, String localidad, String provincia, String pais, int capacidad, BigDecimal costealquiler, int telefono, Empresas nif, String nombresala) {
        this.idsalareunion = new Integer(1);
        this.direccion = direccion;
        this.codigopostal = codigopostal;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
        this.capacidad = capacidad;
        this.costealquiler = costealquiler;
        this.telefono = telefono;
        this.nif = nif;
        this.nombresala = nombresala;
    }

    public Integer getIdsalareunion() {
        return idsalareunion;
    }

    public void setIdsalareunion(Integer idsalareunion) {
        this.idsalareunion = idsalareunion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public BigDecimal getCostealquiler() {
        return costealquiler;
    }

    public void setCostealquiler(BigDecimal costealquiler) {
        this.costealquiler = costealquiler;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
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
        hash += (idsalareunion != null ? idsalareunion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salasreuniones)) {
            return false;
        }
        Salasreuniones other = (Salasreuniones) object;
        if ((this.idsalareunion == null && other.idsalareunion != null) || (this.idsalareunion != null && !this.idsalareunion.equals(other.idsalareunion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.Salasreuniones[ idsalareunion=" + idsalareunion + " ]";
    }

    public Empresas getNif() {
        return nif;
    }

    public void setNif(Empresas nif) {
        this.nif = nif;
    }

    public String getNombresala() {
        return nombresala;
    }

    public void setNombresala(String nombresala) {
        this.nombresala = nombresala;
    }
}
