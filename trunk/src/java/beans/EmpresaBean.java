/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Empresas;
import factoria.FactoriaBD;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import utiles.Consultas;

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
    private Integer telefono;
    private Integer fax;
    private String razonsocial;
    private String direccion;
    private String localidad;
    private String provincia;
    private String pais;
    private Integer codigopostal;
    private String logotipo;
    private boolean datosactualizados;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public EmpresaBean() {
    }

    public EmpresaBean(Empresas emp) {
        this.codigopostal = emp.getCodigopostal();
        this.direccion = emp.getDireccion();
        this.email = emp.getEmail();
        this.fax = emp.getFax();
        this.localidad = emp.getLocalidad();
        this.logotipo = emp.getLogotipo();
        this.nif = emp.getNif();
        this.pais = emp.getPais();
        this.provincia = emp.getProvincia();
        this.razonsocial = emp.getRazonsocial();
        this.telefono = emp.getTelefono();
        this.web = emp.getWeb();
        this.datosactualizados = false;
    }

    public void inicializaMensajes() {
        this.datosactualizados = false;
    }

    public Integer getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(Integer codigopostal) {
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

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public boolean isDatosactualizados() {
        return datosactualizados;
    }

    public void setDatosactualizados(boolean datosactualizados) {
        this.datosactualizados = datosactualizados;
    }

    public boolean insertaEmpresa() {
        boolean res = false;
        Empresas empresa = FactoriaBD.creaEmpresa(this.nif, this.telefono, this.razonsocial,
                this.direccion, this.email, this.localidad, this.provincia,
                this.pais, this.codigopostal, this.web, "ljcnsdljn", this.fax);
        res = FactoriaBD.insertaEmpresa(empresa);
        return res;
    }

    public String actualizarDatosEmpresa() {
        String res = "";
        this.datosactualizados = false;
        try {
            Empresas emp = Consultas.buscaEmpresaNif(this.nif);
            FactoriaBD.preActualizarDato(emp);

            emp.setCodigopostal(this.codigopostal);
            emp.setDireccion(this.direccion);
            emp.setEmail(this.email);
            emp.setFax(this.fax);
            emp.setLocalidad(this.localidad);
            emp.setLogotipo("");
            emp.setPais(this.pais);
            emp.setProvincia(this.provincia);
            emp.setRazonsocial(this.razonsocial);
            emp.setTelefono(this.telefono);
            emp.setWeb(this.web);

            FactoriaBD.posActualizarDato(emp);
            res = "ok";
            this.datosactualizados = true;
        } catch (Exception e) {
            System.out.println(e.toString());
            res = "error";
        }
        return res;
    }
}
