/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Usuarios;
import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
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
    private String errorlogin;

    /** Creates a new instance of LoginBean */
    public LoginBean() {
    }

    public void validarUsuario(FacesContext context, UIComponent validate, Object value) {
        //Hacerlo mensaje error en errorusuario


        String nomUsuario = (String) value;

        if (nomUsuario.length() <= 0) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("No puede estar vac&iacute;o");
            context.addMessage(validate.getClientId(context), msg);
        }
        if (nomUsuario.length() > 11) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Tamaño máximo 11 caracteres");
            context.addMessage(validate.getClientId(context), msg);

        }
        if (nomUsuario.length() < 9) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Tamaño mínimo 9 caracteres");
            context.addMessage(validate.getClientId(context), msg);

        }

    }

    public void validarContrasena(FacesContext context, UIComponent validate, Object value) {

        String clave = (String) value;

        if (clave.equals("")) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("No puede estar vacía");
            context.addMessage(validate.getClientId(context), msg);
        }

    }

    public boolean compruebaVacio() {
        boolean res = true;
        if (usuario.equals("") || contrasena.equals("")) {
            res = false;
        }
        return res;
    }

    public String compruebaLogin() {


        Usuarios a = Consultas.buscaUsuarioContrasena(this.usuario, this.contrasena);

        if (a != null) {
            UsuariosBean user = new UsuariosBean(a);
            EmpresaBean emp = new EmpresaBean(a.getNif());


            // -----------------Nuevo 8-11-11

            FacesContext ctx = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);

            session.setAttribute("usuario", user);
            session.setAttribute("empresa", emp);

            // -----------------


            return "ok";

        } else {
            this.errorlogin = "Usuario y/o contraseña incorrectos";
            return "error";

        }




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

    public String getErrorlogin() {
        return errorlogin;
    }

    public void setErrorlogin(String errorlogin) {
        this.errorlogin = errorlogin;
    }

    public String cerrarSesion() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        externalContext.invalidateSession();
        return "cerrarsesion";
    }
}
