/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Antonio
 */
@ManagedBean
@SessionScoped
public class EmpresaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String email;
    //validarEmail
    private String web;
    //validarCadena255 
    private String nif;
    //validarNif
    private Integer telefono;
    //validarTelefono
    private Integer fax;
    //validarTelefono
    private String razonsocial;
    //validarCadena255
    private String direccion;
    //validarCadena255
    private String localidad;
    //validarCadena255
    private String provincia;
    //validarCadena255
    private String pais;
    //validarCadena255
    private Integer codigopostal;
    //validarCodigoPostal
    private String logotipo;
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public EmpresaBean() {
    }

    public Integer getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(int codigopostal) {
        this.codigopostal = codigopostal;
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

    public Integer getFax() {
        return fax;
    }

    public void setFax(Integer fax) {
        this.fax = fax;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getLogotipo() {
        return logotipo;
    }

    public void setLogotipo(String logotipo) {
        this.logotipo = logotipo;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}