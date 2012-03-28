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
import utiles.Consultas;

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


        Empresas emp = FactoriaBD.creaEmpresa(empresa.getNif().toLowerCase(), empresa.getTelefono(), empresa.getRazonsocial(),
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

    public String registraUsuario() {
        //moodificar todo
        
        boolean usuarioOK = false;
        
        Map sesion = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        UsuariosBean user = (UsuariosBean) sesion.get("usuario");
        
        String empnif= user.getNiftmp();
        
        
        
        Empresas emp = Consultas.buscaEmpresaNif(empnif);
        
        
        
        usuarioOK= user.insertaUsuario(new Integer(2), emp);
        
       
        if(usuarioOK == true){
            return "ok";
        }else{
            return "error";
        }
        
        
    }
}
