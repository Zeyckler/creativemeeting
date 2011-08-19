/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Usuarios;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import utiles.Consultas;

/**
 *
 * @author Zeyckler
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String usuario;
    private String contrasena;

    /** Creates a new instance of LoginBean */
    public LoginBean() {
    }

    public boolean compruebaVacio() {
        boolean res = true;
        if (usuario.equals("") || contrasena.equals("")) {
            res = false;
        }
        return res;
    }

    public String compruebaLogin() {

        if (compruebaVacio()) {
            Usuarios a = Consultas.buscaUsuarioContrasena(this.usuario, this.contrasena);
            if (a != null) {
                HolaBean holaBean = new HolaBean();
                return "ok";
            }

        }
        return "error";

    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String cerrarSesion() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.invalidateSession();
        return "cerrarsesion";
    }
}
