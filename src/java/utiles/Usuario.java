/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utiles;

import bd.Usuarios;


/**
 *
 * @author japarejo
 */
public class Usuario {
    private Usuarios usuario;


    /** Creates a new instance of Usuario */
    public Usuario() {
    }

    public String getEmail()
    {
        return usuario.getEmail();
    }

    public void setEmail(String email)
    {
        usuario.setEmail(email);
    }

}
