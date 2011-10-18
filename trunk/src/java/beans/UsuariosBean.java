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
import utiles.Consultas;

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

    public void setCodigopostal(int codigopostal) {
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
    
    public String creaNombreUsuario(){
        //TODO
        String nomUs;
        String nombreUs= this.nombre.toLowerCase().substring(0, 3);
        String apellido1Us= this.apellido1.toLowerCase().substring(0, 3);
        String apellido2Us= this.apellido2.toLowerCase().substring(0, 3);
        Integer numUs;
       
        nomUs=nombreUs+apellido1Us+apellido2Us;
        
        List<Usuarios> listUs = new LinkedList<Usuarios>();
        listUs=Consultas.buscaUsuarioParecidos(nomUs);
        
        numUs=listUs.size();
        
        if(numUs>0){
            nomUs=nomUs+numUs.toString();
        }
        
        this.usuario=nomUs;
        
        return nomUs;
    
    }
    
    public boolean insertaUsuario(Integer tipo, Empresas nif){
        //TODO
        Usuarios us= new Usuarios();
        boolean res= false;
        
        
        
        if(tipo==0){
            //Usuario Master
            us= FactoriaBD.creaUsuario(this.dni, this.nombre, this.apellido1,
                    this.apellido2, this.fechanacimiento, this.direccion, this.telefono, 
                    this.movil, this.email, this.usuario, this.contrasena, this.localidad,
                    this.provincia, this.pais, this.codigopostal, this.cargo, this.salario, 0 , false, nif);
        }
        if(tipo==1){
            //Usuario Administrador de Empresa
            
            us= FactoriaBD.creaUsuario(this.dni, this.nombre, this.apellido1,
                    this.apellido2, this.fechanacimiento, this.direccion, this.telefono, 
                    this.movil, this.email, this.usuario, this.contrasena, this.localidad,
                    this.provincia, this.pais, this.codigopostal, this.cargo, this.salario, 1 , false, nif);
        }
        if (tipo==2){
            //Usuario Registrado perteneciente a una empresa
            
            us= FactoriaBD.creaUsuario(this.dni, this.nombre, this.apellido1,
                    this.apellido2, this.fechanacimiento, this.direccion, this.telefono, 
                    this.movil, this.email, this.usuario, this.contrasena, this.localidad,
                    this.provincia, this.pais, this.codigopostal, this.cargo, this.salario, 2 , false, nif);
            
        }
        res=FactoriaBD.insertaUsuario(us);
     
        return res;
    }
    
}
