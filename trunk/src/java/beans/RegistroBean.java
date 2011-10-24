/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Empresas;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import javax.enterprise.inject.spi.Bean;
import javax.faces.context.ExternalContext;
import javax.servlet.http.HttpServletRequest;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Zeyckler
 */
public class RegistroBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Creates a new instance of RegistroBean */
    public RegistroBean() {
    }

    public String registraEmpresayUsuario() {
        boolean usuarioOK = false;
        boolean empresaOK = false;
        Map sesion = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        EmpresaBean empresa = (EmpresaBean) sesion.get("empresa");
        UsuariosBean usuario = (UsuariosBean) sesion.get("usuario");
        empresaOK = empresa.insertaEmpresa();
        
        System.out.print(empresaOK);


      if (empresaOK) {
            usuarioOK = usuario.insertaUsuario(1, new Empresas(empresa.getNif()));
        }
        if (empresaOK && usuarioOK) {
            return "ok";
        } else {
            return "error";
        }
    }
}
