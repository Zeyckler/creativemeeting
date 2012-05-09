/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "empresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresas.findAll", query = "SELECT e FROM Empresas e"),
    @NamedQuery(name = "Empresas.findByNif", query = "SELECT e FROM Empresas e WHERE e.nif = :nif"),
    @NamedQuery(name = "Empresas.findByTelefono", query = "SELECT e FROM Empresas e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Empresas.findByFax", query = "SELECT e FROM Empresas e WHERE e.fax = :fax"),
    @NamedQuery(name = "Empresas.findByRazonsocial", query = "SELECT e FROM Empresas e WHERE e.razonsocial = :razonsocial"),
    @NamedQuery(name = "Empresas.findByDireccion", query = "SELECT e FROM Empresas e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Empresas.findByEmail", query = "SELECT e FROM Empresas e WHERE e.email = :email"),
    @NamedQuery(name = "Empresas.findByLocalidad", query = "SELECT e FROM Empresas e WHERE e.localidad = :localidad"),
    @NamedQuery(name = "Empresas.findByProvincia", query = "SELECT e FROM Empresas e WHERE e.provincia = :provincia"),
    @NamedQuery(name = "Empresas.findByPais", query = "SELECT e FROM Empresas e WHERE e.pais = :pais"),
    @NamedQuery(name = "Empresas.findByCodigopostal", query = "SELECT e FROM Empresas e WHERE e.codigopostal = :codigopostal"),
    @NamedQuery(name = "Empresas.findByActivarEmpresa", query = "SELECT e FROM Empresas e WHERE e.activacioninicial = :activo"),
    @NamedQuery(name = "Empresas.findByLogotipo", query = "SELECT e FROM Empresas e WHERE e.logotipo = :logotipo")
})
public class Empresas implements Serializable {
       
    @OneToMany(mappedBy = "nif")
    private Collection<Salasreuniones> salasreunionesCollection;
    @Size(max = 255)
    @Column(name = "web")
    private String web;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "nif")
    private String nif;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    @Column(name = "fax")
    private Integer fax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "razonsocial")
        private String razonsocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "direccion")
    private String direccion;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "localidad")
    private String localidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "provincia")
    private String provincia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigopostal")
    private int codigopostal;
    @Size(max = 255)
    @Column(name = "logotipo")
    private String logotipo;
    @Column(name = "activacioninicial")
    private Boolean activacioninicial;
    @Column(name = "activo")
    private Boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nif")
    private Collection<Usuarios> usuariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nif2")
    private Collection<Empresasamigas> empresasamigasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nif1")
    private Collection<Empresasamigas> empresasamigasCollection1;

    public static final String BUSCAR_EMPRESAS= "Empresas.findAll";
     public static final String BUSCAR_EMPRESAS_ACTIVACION= "Empresas.findByActivarEmpresa";
     public static final String BUSCAR_EMPRESA_NIF="Empresas.findByNif";
    
    public Empresas() {
    }

    public Empresas(String nif) {
        this.nif = nif;
    }

    public Empresas(String nif, int telefono, String razonsocial, String direccion, String email, String localidad, String provincia, String pais, int codigopostal, String web, String logotipo, Integer fax) {
        this.nif = nif;
        this.telefono = telefono;
        this.razonsocial = razonsocial;
        this.direccion = direccion;
        this.email = email;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
        this.codigopostal = codigopostal;
        this.web= web;
        this.logotipo= logotipo;
        this.fax=fax;
        this.activo= false;
        this.activacioninicial= true;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Integer getFax() {
        return fax;
    }

    public void setFax(Integer fax) {
        this.fax = fax;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(int codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getLogotipo() {
        return logotipo;
    }

    public void setLogotipo(String logotipo) {
        this.logotipo = logotipo;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nif != null ? nif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresas)) {
            return false;
        }
        Empresas other = (Empresas) object;
        if ((this.nif == null && other.nif != null) || (this.nif != null && !this.nif.equals(other.nif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.Empresas[ nif=" + nif + " ]";
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    @XmlTransient
    public Collection<Salasreuniones> getSalasreunionesCollection() {
        return salasreunionesCollection;
    }

    public void setSalasreunionesCollection(Collection<Salasreuniones> salasreunionesCollection) {
        this.salasreunionesCollection = salasreunionesCollection;
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

    @XmlTransient
    public Collection<Empresasamigas> getEmpresasamigasCollection() {
        return empresasamigasCollection;
    }

    public void setEmpresasamigasCollection(Collection<Empresasamigas> empresasamigasCollection) {
        this.empresasamigasCollection = empresasamigasCollection;
    }

    @XmlTransient
    public Collection<Empresasamigas> getEmpresasamigasCollection1() {
        return empresasamigasCollection1;
    }

    public void setEmpresasamigasCollection1(Collection<Empresasamigas> empresasamigasCollection1) {
        this.empresasamigasCollection1 = empresasamigasCollection1;
    }
    
}
