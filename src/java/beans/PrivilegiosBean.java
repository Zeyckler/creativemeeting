/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.mail.Session;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Zeyckler
 */
public class PrivilegiosBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Creates a new instance of PrivilegiosBean */
    public PrivilegiosBean() {
    }

    public int compruebaPrivilegiosSesion() {
        int privilegio;
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);

        UsuariosBean usB = (UsuariosBean) session.getAttribute("usuario");

        if (usB == null) {
            privilegio = 3;
        } else {
            privilegio = usB.getPrivilegios();
        }
        return privilegio;

    }
}
