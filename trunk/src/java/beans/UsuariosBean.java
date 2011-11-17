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
    //ValidarNif
    private String nombre;
    //ValidarCadena255
    private String apellido1;
    //ValidarCadena255
    private String apellido2;
    //No es requerido
    private Date fechanacimiento;
    //ValidarFechas ¡¡¡Sin hacer!!!
    private String direccion;
    //ValidarCadena255
    private Integer telefono;
    //validarTelefono
    private Integer movil;
    //validarMovil
    private String email;
    //ValidarEmail
    private String usuario;
    //No Necesita Validador
    private String provincia;
    //ValidarCadena255
    private String contrasena;
    //ValidarCadena255
    private String localidad;
    //ValidarCadena255
    private String pais;
    //ValidarCadena255
    private Integer codigopostal;
    //validarCodigoPostal
    private String cargo;
    //ValidarCadena255
    private BigDecimal salario;
    private int privilegios;
    //ValidarCadena255
    private boolean activo;
    //No necesita validacion
    private Empresas nif;
    //No necesita Validacion

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

    public boolean insertaUsuario(Integer tipo, Empresas nif) {
        //TODO

        String nomUsuario = Utilidades.creaNombreUsuario(this.nombre, this.apellido1, this.apellido2);
        Usuarios us = new Usuarios();
        boolean res = false;


        if (tipo.intValue() == 0) {
            //Usuario Master
            us = FactoriaBD.creaUsuario(this.dni, this.nombre, this.apellido1,
                    this.apellido2, this.fechanacimiento, this.direccion, this.telefono,
                    this.movil, this.email, nomUsuario, "123445", this.localidad,
                    this.provincia, this.pais, this.codigopostal, this.cargo, this.salario, 0, false, nif);
        }
        if (tipo.intValue() == 1) {
            //Usuario Administrador de Empresa

            us = FactoriaBD.creaUsuario(this.dni, this.nombre, this.apellido1,
                    this.apellido2, this.fechanacimiento, this.direccion, this.telefono,
                    this.movil, this.email, nomUsuario, "123445", this.localidad,
                    this.provincia, this.pais, this.codigopostal, this.cargo, this.salario, 1, false, nif);
        }
        if (tipo.intValue() == 2) {
            //Usuario Registrado perteneciente a una empresa

            us = FactoriaBD.creaUsuario(this.dni, this.nombre, this.apellido1,
                    this.apellido2, this.fechanacimiento, this.direccion, this.telefono,
                    this.movil, this.email, nomUsuario, "123445", this.localidad,
                    this.provincia, this.pais, this.codigopostal, this.cargo, this.salario, 2, false, nif);

        }
        res = FactoriaBD.insertaUsuario(us);

        return res;
    }

    public String insertarCalendarioSesion() {


        String res = "";
        try {
            FacesContext ctx = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);

            UsuariosBean usBean = (UsuariosBean) session.getAttribute("usuario");
            String dni = usBean.getDni();

            CalendarioUsuarioBean calbean = new CalendarioUsuarioBean(dni);

            session.setAttribute("calendarioUsuarioBean", calbean);
            res= "ok";

        }catch(Exception e){
            res= "error";
        }
        
        return res;


    }
}
