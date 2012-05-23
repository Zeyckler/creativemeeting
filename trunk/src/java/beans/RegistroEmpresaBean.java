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
import utiles.Utilidades;

/**
 *
 * @author Zeyckler
 */
public class RegistroEmpresaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String email;
    private String web;
    private String nif;
    private Integer telefono;
    private Integer fax;
    private String razonsocial;
    private String direccion;
    private String localidad;
    private String provincia;
    private String pais;
    private Integer codigopostal;
    private String logotipo;
    private String dniusuario;
    private String nombreusuario;
    private String apellido1usuario;
    private String apellido2usuario;
    private Date fechanacimientousuario;
    private String direccionusuario;
    private Integer telefonousuario;
    private Integer movilusuario;
    private String emailusuario;
    private String usuariousuario;
    private String provinciausuario;
    private String contrasenausuario;
    private String localidadusuario;
    private String paisusuario;
    private Integer codigopostalusuario;
    private String cargousuario;
    private BigDecimal salariousuario;
    private boolean errorregistro;
    private boolean exitoregistro;

    /** Creates a new instance of RegistroEmpresaBean */
    public RegistroEmpresaBean() {
    }

    public String getApellido1usuario() {
        return apellido1usuario;
    }

    public void setApellido1usuario(String apellido1usuario) {
        this.apellido1usuario = apellido1usuario;
    }

    public String getApellido2usuario() {
        return apellido2usuario;
    }

    public void setApellido2usuario(String apellido2usuario) {
        this.apellido2usuario = apellido2usuario;
    }

    public String getCargousuario() {
        return cargousuario;
    }

    public void setCargousuario(String cargousuario) {
        this.cargousuario = cargousuario;
    }

    public Integer getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(Integer codigopostal) {
        this.codigopostal = codigopostal;
    }

    public Integer getCodigopostalusuario() {
        return codigopostalusuario;
    }

    public void setCodigopostalusuario(Integer codigopostalusuario) {
        this.codigopostalusuario = codigopostalusuario;
    }

    public String getContrasenausuario() {
        return contrasenausuario;
    }

    public void setContrasenausuario(String contrasenausuario) {
        this.contrasenausuario = contrasenausuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccionusuario() {
        return direccionusuario;
    }

    public void setDireccionusuario(String direccionusuario) {
        this.direccionusuario = direccionusuario;
    }

    public String getDniusuario() {
        return dniusuario;
    }

    public void setDniusuario(String dniusuario) {
        this.dniusuario = dniusuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailusuario() {
        return emailusuario;
    }

    public void setEmailusuario(String emailusuario) {
        this.emailusuario = emailusuario;
    }

    public Integer getFax() {
        return fax;
    }

    public void setFax(Integer fax) {
        this.fax = fax;
    }

    public Date getFechanacimientousuario() {
        return fechanacimientousuario;
    }

    public void setFechanacimientousuario(Date fechanacimientousuario) {
        this.fechanacimientousuario = fechanacimientousuario;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getLocalidadusuario() {
        return localidadusuario;
    }

    public void setLocalidadusuario(String localidadusuario) {
        this.localidadusuario = localidadusuario;
    }

    public String getLogotipo() {
        return logotipo;
    }

    public void setLogotipo(String logotipo) {
        this.logotipo = logotipo;
    }

    public Integer getMovilusuario() {
        return movilusuario;
    }

    public void setMovilusuario(Integer movilusuario) {
        this.movilusuario = movilusuario;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPaisusuario() {
        return paisusuario;
    }

    public void setPaisusuario(String paisusuario) {
        this.paisusuario = paisusuario;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getProvinciausuario() {
        return provinciausuario;
    }

    public void setProvinciausuario(String provinciausuario) {
        this.provinciausuario = provinciausuario;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public BigDecimal getSalariousuario() {
        return salariousuario;
    }

    public void setSalariousuario(BigDecimal salariousuario) {
        this.salariousuario = salariousuario;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getTelefonousuario() {
        return telefonousuario;
    }

    public void setTelefonousuario(Integer telefonousuario) {
        this.telefonousuario = telefonousuario;
    }

    public String getUsuariousuario() {
        return usuariousuario;
    }

    public void setUsuariousuario(String usuariousuario) {
        this.usuariousuario = usuariousuario;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public boolean isErrorregistro() {
        return errorregistro;
    }

    public void setErrorregistro(boolean errorregistro) {
        this.errorregistro = errorregistro;
    }

    public boolean isExitoregistro() {
        return exitoregistro;
    }

    public void setExitoregistro(boolean exitoregistro) {
        this.exitoregistro = exitoregistro;
    }

    public String registraEmpresayUsuario() {
        boolean usuarioOK = false;
        boolean empresaOK = false;
        this.exitoregistro = false;
        this.errorregistro = false;
        Empresas emp = FactoriaBD.creaEmpresa(this.nif.toLowerCase(), this.telefono, this.razonsocial,
                this.direccion, this.email, this.localidad, this.provincia,
                this.pais, this.codigopostal, this.web, "", this.fax);
        empresaOK = FactoriaBD.insertaEmpresa(emp);
        if (empresaOK) {
            usuarioOK = insertaUsuario(emp);
        }
        if (empresaOK && usuarioOK) {
            this.exitoregistro = true;
            return "ok";
        } else {
            this.errorregistro = true;
            return "error";
        }
    }

    public boolean insertaUsuario(Empresas nif) {
        String nomUsuario = Utilidades.creaNombreUsuario(this.nombreusuario, this.apellido1usuario, this.apellido2usuario);
        Usuarios us = new Usuarios();
        boolean res = false;
        //Usuario Administrador de Empresa
        us = FactoriaBD.creaUsuario(this.dniusuario.toLowerCase(), this.nombreusuario, this.apellido1usuario,
                this.apellido2usuario, this.fechanacimientousuario, this.direccionusuario, this.telefonousuario,
                this.movilusuario, this.emailusuario, nomUsuario, this.contrasenausuario, this.localidadusuario,
                this.provinciausuario, this.paisusuario, this.codigopostalusuario, this.cargousuario, this.salariousuario, 1, false, nif);
        res = FactoriaBD.insertaUsuario(us);
        return res;
    }

    public String volver() {
        return "ok";
    }
}
