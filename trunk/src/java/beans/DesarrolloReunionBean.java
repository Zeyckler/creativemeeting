/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Reuniones;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import utiles.Utilidades;

/**
 *
 * @author AntonioCZ
 */
public class DesarrolloReunionBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Reuniones reunion;
    

    /** Creates a new instance of DesarrolloReunionBean */
    public DesarrolloReunionBean() {
    }

    public void inicializaDesarrolloReunion(){
        
        UsuariosBean us =  (UsuariosBean) Utilidades.getSessionBean("usuario");
        this.reunion  = us.getReunionhoy();
    }

    public Reuniones getReunion() {
        return reunion;
    }

    public void setReunion(Reuniones reunion) {
        this.reunion = reunion;
    }
    
    
}
