/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 *
 * @author Antonio
 */
@ManagedBean
@SessionScoped
public class EmpresaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String email;
    private String web;
    private String nif;
    private int telefono;
    private Integer fax;
    private String razonsocial;
    private String direccion;
    private String localidad;
    private String provincia;
    private String pais;
    private int codigopostal;
    private String logotipo;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public EmpresaBean() {
    }

    public int getCodigopostal() {
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

    public int getTelefono() {
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

    public void validarCadena255(FacesContext context, UIComponent validate, Object value) {
        String cad = (String) value;
        boolean tam = true;

        if (cad.length() > 255) {
            tam = false;
        }
        if (!false) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Tamaño máximo 255 caracteres");
            context.addMessage(validate.getClientId(context), msg);
        }
        
        
    }
    
    public void validarEmail(FacesContext context, UIComponent validate, Object value) {
        String emailEmp = (String) value;
        boolean res = true;
        boolean tam = true;

        if (emailEmp.length() > 255) {
            tam = false;
        }

        Pattern p = Pattern.compile("[a-zA-Z0-9]+[.[a-zA-Z0-9_-]+]*@[a-z0-9][\\w\\.-]*[a-z0-9]\\.[a-z][a-z\\.]*[a-z]$");
        Matcher m = p.matcher(emailEmp);
        res = m.matches();

        if (!res) {

            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Correo electronico no válido");
            context.addMessage(validate.getClientId(context), msg);
        }
        if (!tam) {

            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Tamaño máximo 255 caracteres");
            context.addMessage(validate.getClientId(context), msg);
        }
    }

    public void validarWeb(FacesContext context, UIComponent validate, Object value) {

        validarCadena255(context, validate, value);
        
    }

    public void validarTelefono(FacesContext context, UIComponent validate, Object value) {

        boolean res = true;
        String telefonoEmp = (String) value;

        Pattern p = Pattern.compile("^\\d+$");
        Matcher m = p.matcher(telefonoEmp);
        res = m.matches();

        if (!res) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Debe ser un número");
            context.addMessage(validate.getClientId(context), msg);
        }

        if (telefonoEmp.length() > 9) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Tamaño maximo 9 numeros");
            context.addMessage(validate.getClientId(context), msg);
        }


    }

    public void validarFax(FacesContext context, UIComponent validate, Object value) {
        boolean res = true;
        String telefonoEmp = (String) value;

        Pattern p = Pattern.compile("^\\d+$");
        Matcher m = p.matcher(telefonoEmp);
        res = m.matches();

        if (!res) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Debe ser un número");
            context.addMessage(validate.getClientId(context), msg);
        }

        if (telefonoEmp.length() > 9) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Tamaño maximo 9 numeros");
            context.addMessage(validate.getClientId(context), msg);
        }
    }

    public void validarRazonSocial(FacesContext context, UIComponent validate, Object value) {
        validarCadena255(context, validate, value);
    }

    public void validarDireccion(FacesContext context, UIComponent validate, Object value) {
        
        validarCadena255(context, validate, value);
        
    }

    public void validarLocalidad(FacesContext context, UIComponent validate, Object value) {
        
        validarCadena255(context, validate, value);
        
    }

    public void validarProvincia(FacesContext context, UIComponent validate, Object value) {
        
        validarCadena255(context, validate, value);
    }
    
    public void validarPais(FacesContext context, UIComponent validate, Object value) {
        
        validarCadena255(context, validate, value);
    }
    
    public void validarCodigoPostal(FacesContext context, UIComponent validate, Object value) {
        
        boolean res = true;
        String telefonoEmp = (String) value;

        Pattern p = Pattern.compile("^\\d+$");
        Matcher m = p.matcher(telefonoEmp);
        res = m.matches();

        if (!res) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Debe ser un número");
            context.addMessage(validate.getClientId(context), msg);
        }

        if (telefonoEmp.length() > 10) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Tamaño maximo 10 numeros");
            context.addMessage(validate.getClientId(context), msg);
        }
        
    }
    
    
}
