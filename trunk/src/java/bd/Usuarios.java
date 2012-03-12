package bd;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "Usuarios")
@SessionScoped
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByDni", query = "SELECT u FROM Usuarios u WHERE u.dni = :dni"),
    @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuarios.findByApellido1", query = "SELECT u FROM Usuarios u WHERE u.apellido1 = :apellido1"),
    @NamedQuery(name = "Usuarios.findByApellido2", query = "SELECT u FROM Usuarios u WHERE u.apellido2 = :apellido2"),
    @NamedQuery(name = "Usuarios.findByFechanacimiento", query = "SELECT u FROM Usuarios u WHERE u.fechanacimiento = :fechanacimiento"),
    @NamedQuery(name = "Usuarios.findByDireccion", query = "SELECT u FROM Usuarios u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "Usuarios.findByTelefono", query = "SELECT u FROM Usuarios u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuarios.findByMovil", query = "SELECT u FROM Usuarios u WHERE u.movil = :movil"),
    @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email"),
    @NamedQuery(name = "Usuarios.findByUsuario", query = "SELECT u FROM Usuarios u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuarios.findByUsuarioParecidos", query = "SELECT u FROM Usuarios u WHERE u.usuario LIKE :usuario"),
    @NamedQuery(name = "Usuarios.findByContrasena", query = "SELECT u FROM Usuarios u WHERE u.contrasena = :contrasena"),
    @NamedQuery(name = "Usuarios.findByLocalidad", query = "SELECT u FROM Usuarios u WHERE u.localidad = :localidad"),
    @NamedQuery(name = "Usuarios.findByProvincia", query = "SELECT u FROM Usuarios u WHERE u.provincia = :provincia"),
    @NamedQuery(name = "Usuarios.findByPais", query = "SELECT u FROM Usuarios u WHERE u.pais = :pais"),
    @NamedQuery(name = "Usuarios.findByCodigopostal", query = "SELECT u FROM Usuarios u WHERE u.codigopostal = :codigopostal"),
    @NamedQuery(name = "Usuarios.findByCargo", query = "SELECT u FROM Usuarios u WHERE u.cargo = :cargo"),
    @NamedQuery(name = "Usuarios.findBySalario", query = "SELECT u FROM Usuarios u WHERE u.salario = :salario"),
    @NamedQuery(name = "Usuarios.findByPrivilegios", query = "SELECT u FROM Usuarios u WHERE u.privilegios = :privilegios"),
    @NamedQuery(name = "Usuarios.findByActivo", query = "SELECT u FROM Usuarios u WHERE u.activo = :activo"),
    @NamedQuery(name = "Usuarios.findByIdReunion", query = "SELECT u FROM Usuarios u JOIN u.asistenciareunionCollection arc JOIN arc.idreunion idr WHERE idr.idreunion =:idr1 "),
    @NamedQuery(name = "Usuarios.findUsuarioByEmpresa", query = "SELECT u FROM Usuarios u JOIN u.nif emp WHERE emp.nif = :nifempresa"),
    @NamedQuery(name = "Usuarios.findByUsuarioyContrasena", query = "SELECT u FROM Usuarios u WHERE u.usuario = :usuario AND u.contrasena = :contasenia"),
    @NamedQuery(name = "Usuarios.finDUsuariosDisponiblesReunion", query = "SELECT u.dni, u.nombre, u.apellido1, u.apellido2, emp.nif, emp.razonsocial FROM Usuarios u LEFT JOIN u.asistenciareunionCollection arc LEFT JOIN arc.idreunion idr LEFT JOIN u.nif emp  WHERE (arc.notificacion = :notificacion AND arc.respuesta = :respuesta AND idr.fechainicial> :fechinicial AND idr.fechainicial< :fechfinal AND emp.nif = :nifemp AND NOT u.dni= :dniadmin) OR (arc.notificacion = :notificaciont AND idr.fechainicial> :fechinicial AND idr.fechainicial< :fechfinal AND emp.nif = :nifemp AND NOT u.dni= :dniadmin) OR (idr.fechainicial > :fechfinal AND emp.nif = :nifemp AND NOT u.dni= :dniadmin) OR ( idr.fechainicial < :fechinicial AND emp.nif = :nifemp AND NOT u.dni= :dniadmin) OR (arc.idasistenciareunion IS NULL AND emp.nif = :nifemp AND NOT u.dni= :dniadmin) ")
})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido1")
    private String apellido1;
    @Size(max = 45)
    @Column(name = "apellido2")
    private String apellido2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private Integer telefono;
    @Column(name = "movil")
    private Integer movil;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contrasena")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "localidad")
    private String localidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "provincia")
    private String provincia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigopostal")
    private int codigopostal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "cargo")
    private String cargo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "salario")
    private BigDecimal salario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @OneToMany(mappedBy = "dni")
    private Collection<Asistenciareunion> asistenciareunionCollection;
    @OneToMany(mappedBy = "dnicreador")
    private Collection<Reuniones> reunionesCollection;
    @JoinColumn(name = "nif", referencedColumnName = "nif")
    @ManyToOne(optional = false)
    private Empresas nif;
    @Basic(optional = false)
    @NotNull
    @Column(name = "privilegios")
    private int privilegios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activacioninicial")
    private boolean activacioninicial;
    public static final String BUSCAR_USUARIOSIDREUNIONES = "Usuarios.findByIdReunion";
    public static final String BUSCAR_USUARIOSACTIVOS = "Usuarios.findByActivo";
    public static final String BUSCAR_USUARIOSBYEMPRESA = "Usuarios.findUsuarioByEmpresa";
    public static final String BUSCAR_USUARIOYCONTRASENA = "Usuarios.findByUsuarioyContrasena";
    public static final String BUSCAR_USUARIOSPARECIDOS = "Usuarios.findByUsuarioParecidos";
    public static final String BUSCAR_USUARIOSDISPONIBLESREUNION = "Usuarios.finDUsuariosDisponiblesReunion";

    public Usuarios() {
    }

    public Usuarios(String dni, Empresas nif) {
        this.dni = dni;
        this.nif = nif;
    }

    public Usuarios(String dni) {
        this.dni = dni;
    }
    
    

    public Usuarios(String dni, String nombre, String apellido1, String apellido2,
            Date fechanacimiento, String direccion, Integer telefono, Integer movil,
            String email, String usuario, String contrasena, String localidad,
            String provincia, String pais, int codigopostal, String cargo, BigDecimal salario,
            int privilegios, boolean activo, Empresas nif) {

        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechanacimiento = fechanacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.movil = movil;
        this.email = email;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
        this.codigopostal = codigopostal;
        this.cargo = cargo;
        this.salario = salario;
        this.privilegios = privilegios;
        this.activo = activo;
        this.nif = nif;
        this.activacioninicial = true;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getMovil() {
        return movil;
    }

    public void setMovil(Integer movil) {
        this.movil = movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public Collection<Asistenciareunion> getAsistenciareunionCollection() {
        return asistenciareunionCollection;
    }

    public void setAsistenciareunionCollection(Collection<Asistenciareunion> asistenciareunionCollection) {
        this.asistenciareunionCollection = asistenciareunionCollection;
    }

    @XmlTransient
    public Collection<Reuniones> getReunionesCollection() {
        return reunionesCollection;
    }

    public void setReunionesCollection(Collection<Reuniones> reunionesCollection) {
        this.reunionesCollection = reunionesCollection;
    }

    public Empresas getNif() {
        return nif;
    }

    public void setNif(Empresas nif) {
        this.nif = nif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.Usuarios[ dni=" + dni + " ]";
    }

    public int getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(int privilegios) {
        this.privilegios = privilegios;
    }

    public boolean getActivacioninicial() {
        return activacioninicial;
    }

    public void setActivacioninicial(boolean activacioninicial) {
        this.activacioninicial = activacioninicial;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }
}