/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Empresas;
import factoria.FactoriaBD;
import java.io.Serializable;
import java.util.Map;
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


        Empresas emp = FactoriaBD.creaEmpresa(empresa.getNif(), empresa.getTelefono(), empresa.getRazonsocial(),
                empresa.getDireccion(), empresa.getEmail(), empresa.getLocalidad(), empresa.getProvincia(),
                empresa.getPais(), empresa.getCodigopostal(), empresa.getWeb(), "ljcnsdljn", empresa.getFax());

        empresaOK = FactoriaBD.insertaEmpresa(emp);
        
        if (empresaOK) {

            usuarioOK = usuario.insertaUsuario(new Integer(1), emp);
        }
        if (empresaOK && usuarioOK) {
            return "ok";
        } else {
            return "error";
        }
    }
}
