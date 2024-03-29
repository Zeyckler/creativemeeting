/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Empresas;
import bd.Salasreuniones;
import factoria.FactoriaBD;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import utiles.Consultas;
import utiles.Utilidades;

/**
 *
 * @author Zeyckler
 */
public class SalaReunionBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idsalareunion;
    private String direccion;
    private String nombresala;
    private Integer codigopostal;
    private String localidad;
    private String provincia;
    private String pais;
    private Integer capacidad;
    private BigDecimal costealquiler;
    private Integer telefono;
    private Empresas nif;

    /** Creates a new instance of SalaReunionBean */
    public SalaReunionBean() {
        this.nif = Consultas.buscaEmpresaNif(Utilidades.getNifEmpresaSesion());
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(Integer codigopostal) {
        this.codigopostal = codigopostal;
    }

    public BigDecimal getCostealquiler() {
        return costealquiler;
    }

    public void setCostealquiler(BigDecimal costealquiler) {
        this.costealquiler = costealquiler;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getIdsalareunion() {
        return idsalareunion;
    }

    public void setIdsalareunion(Integer idsalareunion) {
        this.idsalareunion = idsalareunion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Empresas getNif() {
        return nif;
    }

    public void setNif(Empresas nif) {
        this.nif = nif;
    }

    public String getNombresala() {
        return nombresala;
    }

    public void setNombresala(String nombresala) {
        this.nombresala = nombresala;
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

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String anadirSala() {
        String res = "";
        try {


            Salasreuniones sr = FactoriaBD.creaSalasreuniones(this.direccion, this.codigopostal.toString(), this.localidad, this.provincia, this.pais, this.capacidad, this.costealquiler, this.telefono, this.nif, this.nombresala);

            FactoriaBD.insertaSalasreuniones(sr);

            FacesContext ctx = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);
            UsuariosBean usr = (UsuariosBean) session.getAttribute("usuario");
            usr.setSalaanadida(true);
            session.setAttribute("usuario", usr);
            session.removeAttribute("salaReunionBean");
            res = "ok";


        } catch (Exception e) {
            System.out.println("EXEPCION: " + e.toString());
            res = "error";
        }
        return res;
    }
}
