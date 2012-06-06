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
    private boolean inactivo;

    /** Creates a new instance of LoginBean */
    public LoginBean() {
    }

    public void validarUsuario(FacesContext context, UIComponent validate, Object value) {
        //Hacerlo mensaje error en errorusuario


        String nomUsuario = (String) value;

        if (nomUsuario.length() <= 0) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("El nombre de usuario no puede estar vacío");
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
        this.usuario = nomUsuario;

    }

    public void validarContrasena(FacesContext context, UIComponent validate, Object value) {

        String clave = (String) value;
        Usuarios a = null;

        if (clave.equals("")) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("La contraseña no puede estar vacía");
            context.addMessage(validate.getClientId(context), msg);
        }

        try {

            a = Consultas.buscaUsuarioContrasena(this.usuario, clave);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (a == null) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Nombre de usuario y/o contraseña no válidos");
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
        this.inactivo= false;
        String res;
        Usuarios a = null;
        try {
            a = Consultas.buscaUsuarioContrasena(this.usuario, this.contrasena);
        } catch (Exception e) {
            System.out.println(e.toString());

        }


        if (a != null) {
            
            if (a.getActivo()==false){
                res= "inactivo"; 
                this.inactivo=true;
            }else{
            UsuariosBean user = new UsuariosBean(a);
            EmpresaBean emp = new EmpresaBean(a.getNif());
            FacesContext ctx = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);
            session.setAttribute("usuario", user);
            session.setAttribute("empresa", emp);

            res = "ok";
            }

        } else {
            res= "error";

        }
        return res;
        
    }
    public void cambiaInactivo(){
        this.inactivo =false;
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

    public void cerrarSesion() {
        try{
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        }catch(Exception e){
            
        }     
    }

    public String noCerrarSesion() {
        return "nocerrarsesion";
    }

    public boolean isInactivo() {
        return inactivo;
    }

    public void setInactivo(boolean inactivo) {
        this.inactivo = inactivo;
    }
    
}
