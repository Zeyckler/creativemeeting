/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Empresas;
import bd.Reuniones;
import bd.Usuarios;
import factoria.FactoriaBD;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import utiles.Consultas;
import utiles.Utilidades;

/**
 *
 * @author Zeyckler
 */
public class UsuariosBean implements Serializable {

    private final static long serialVersionUID = 1L;
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
    private Reuniones reunionhoy;
    private List<Reuniones> proximasreuniones;

    public UsuariosBean() {
    }
    //Hay que crear un Constructor con una entrada de usuario

    public UsuariosBean(Usuarios us) {
        this.activo = us.getActivo();
        this.apellido1 = us.getApellido1();
        this.apellido2 = us.getApellido2();
        this.cargo = us.getCargo();
        this.codigopostal = us.getCodigopostal();
        this.contrasena = us.getContrasena();
        this.direccion = us.getDireccion();
        this.dni = us.getDni();
        this.email = us.getEmail();
        this.fechanacimiento = us.getFechanacimiento();
        this.localidad = us.getLocalidad();
        this.movil = us.getMovil();
        this.nif = us.getNif();
        this.nombre = us.getNombre();
        this.pais = us.getPais();
        this.privilegios = us.getPrivilegios();
        this.provincia = us.getProvincia();
        this.salario = us.getSalario();
        this.telefono = us.getTelefono();
        this.usuario = us.getUsuario();      
        this.reunionhoy= Consultas.buscaReunionesUsuarioInformacionHoy(this.dni);
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

    public String getNiftmp() {
        return niftmp;
    }

    public void setNiftmp(String niftmp) {
        this.niftmp = niftmp;
    }

    public List<Reuniones> getProximasreuniones() {
        return proximasreuniones;
    }

    public void setProximasreuniones(List<Reuniones> proximasreuniones) {
        this.proximasreuniones = proximasreuniones;
    }

    public Reuniones getReunionhoy() {
        return reunionhoy;
    }

    public void setReunionhoy(Reuniones reunionhoy) {
        this.reunionhoy = reunionhoy;
    }
    

    public boolean insertaUsuario(Integer tipo, Empresas nif) {
        //TODO

        String nomUsuario = Utilidades.creaNombreUsuario(this.nombre, this.apellido1, this.apellido2);
        Usuarios us = new Usuarios();
        boolean res = false;


        if (tipo.intValue() == 0) {
            //Usuario Master
            us = FactoriaBD.creaUsuario(this.dni.toLowerCase(), this.nombre, this.apellido1,
                    this.apellido2, this.fechanacimiento, this.direccion, this.telefono,
                    this.movil, this.email, nomUsuario, "123445", this.localidad,
                    this.provincia, this.pais, this.codigopostal, this.cargo, this.salario, 0, false, nif);
        }
        if (tipo.intValue() == 1) {
            //Usuario Administrador de Empresa

            us = FactoriaBD.creaUsuario(this.dni.toLowerCase(), this.nombre, this.apellido1,
                    this.apellido2, this.fechanacimiento, this.direccion, this.telefono,
                    this.movil, this.email, nomUsuario, "123445", this.localidad,
                    this.provincia, this.pais, this.codigopostal, this.cargo, this.salario, 1, false, nif);
        }
        if (tipo.intValue() == 2) {
            //Usuario Registrado perteneciente a una empresa

            us = FactoriaBD.creaUsuario(this.dni.toLowerCase(), this.nombre, this.apellido1,
                    this.apellido2, this.fechanacimiento, this.direccion, this.telefono,
                    this.movil, this.email, nomUsuario, "123445", this.localidad,
                    this.provincia, this.pais, this.codigopostal, this.cargo, this.salario, 2, false, nif);


        }
        res = FactoriaBD.insertaUsuario(us);
        return res;
    }

    public void creaCalendarioUsuarioBean() {

        System.out.println("Se ha ejecutado CreaCalendarioUsuarioBean");



        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);
        CalendarioUsuarioBean cal =(CalendarioUsuarioBean) session.getAttribute("calendarioUsuarioBean");
        if(cal.getFecha().equals(Calendar.getInstance().getTime())){
        CalendarioUsuarioBean calUsBean = new CalendarioUsuarioBean();
        calUsBean.inicializaCalendarioUsuarioBean();
        session.setAttribute("calendarioUsuarioBean", calUsBean);
        }
    }

    public void creaVerNotificacionesAEBean() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);
        VerNotificacionesAEBean verNot = new VerNotificacionesAEBean();
        verNot.inicializaVerNotificacionesAEBean();
        session.setAttribute("verNotificacionesAEBean", verNot);

    }
    
    
}
