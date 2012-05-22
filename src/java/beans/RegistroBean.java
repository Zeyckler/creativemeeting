/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Empresas;
import bd.Usuarios;
import factoria.FactoriaBD;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import utiles.Consultas;
import utiles.Utilidades;

/**
 *
 * @author Zeyckler
 */
public class RegistroBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fechanacimiento;
    private String direccion;
    private Integer telefono;
    private Integer movil;
    private String email;
    private String usuario;
    private String provincia;
    private String contrasena;
    private String localidad;
    private String pais;
    private Integer codigopostal;
    private String cargo;
    private BigDecimal salario;
    private int privilegios;
    private boolean activo;
    private Empresas nif;
    private String niftmp;

    /** Creates a new instance of RegistroBean */
    public RegistroBean() {
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(Integer codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Integer getMovil() {
        return movil;
    }

    public void setMovil(Integer movil) {
        this.movil = movil;
    }

    public Empresas getNif() {
        return nif;
    }

    public void setNif(Empresas nif) {
        this.nif = nif;
    }

    public String getNiftmp() {
        return niftmp;
    }

    public void setNiftmp(String niftmp) {
        this.niftmp = niftmp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(int privilegios) {
        this.privilegios = privilegios;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public boolean insertaUsuario(Empresas nif) {
        String nomUsuario = Utilidades.creaNombreUsuario(this.nombre, this.apellido1, this.apellido2);
        Usuarios us = new Usuarios();
        boolean res = false;
        //Usuario Registrado perteneciente a una empresa
        us = FactoriaBD.creaUsuario(this.dni.toLowerCase(), this.nombre, this.apellido1,
                this.apellido2, this.fechanacimiento, this.direccion, this.telefono,
                this.movil, this.email, nomUsuario, "", this.localidad,
                this.provincia, this.pais, this.codigopostal, this.cargo, this.salario, 2, false, nif);
        res = FactoriaBD.insertaUsuario(us);
        return res;
    }

    public String registraUsuario() {
        boolean usuarioOK = false;
        Empresas emp = Consultas.buscaEmpresaNif(this.niftmp);
        usuarioOK = insertaUsuario(emp);
        if (usuarioOK == true) {
            return "ok";
        } else {
            return "error";
        }
    }

    public String volver() {
        return "ok";
    }
}
