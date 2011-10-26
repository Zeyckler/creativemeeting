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
import utiles.Utilidades;

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
        //empresaOK = empresa.insertaEmpresa();

        System.out.println("Nif: " + empresa.getNif());
        System.out.println("Telefono: " + empresa.getTelefono());
        System.out.println("Razonsocial: " + empresa.getRazonsocial());
        System.out.println("Direccion: " + empresa.getDireccion());
        System.out.println("Email: " + empresa.getEmail());
        System.out.println("Localidad: " + empresa.getLocalidad());
        System.out.println("Provincia: " + empresa.getProvincia());
        System.out.println("Pais: " + empresa.getPais());
        System.out.println("CP: " + empresa.getCodigopostal());
        System.out.println("Web: " + empresa.getWeb());
        System.out.println("Logotipo: " + empresa.getLogotipo());
        System.out.println("Fax: " + empresa.getFax());
        
        //Atrubutos de emp
        System.out.println("Datos referidos al Objeto");
        System.out.println("Nif: " + emp.getNif());
        System.out.println("Telefono: " + emp.getTelefono());
        System.out.println("Razonsocial: " + emp.getRazonsocial());
        System.out.println("Direccion: " + emp.getDireccion());
        System.out.println("Email: " + emp.getEmail());
        System.out.println("Localidad: " + emp.getLocalidad());
        System.out.println("Provincia: " + emp.getProvincia());
        System.out.println("Pais: " + emp.getPais());
        System.out.println("CP: " + emp.getCodigopostal());
        System.out.println("Web: " + emp.getWeb());
        System.out.println("Logotipo: " + emp.getLogotipo());
        System.out.println("Fax: " + emp.getFax());

        System.out.print(empresaOK);


        if (empresaOK) {
            
            usuarioOK = usuario.insertaUsuario(new Integer(1), emp);
            
            System.out.println("Datos referidos al Usuario");
            System.out.println("Apellido1: " + usuario.getApellido1());
            System.out.println("Apellido2: " + usuario.getApellido2());
            System.out.println("Cargo: " + usuario.getCargo());
            System.out.println("Contraseña: " + usuario.getContrasena());
            System.out.println("Direccion: " + usuario.getDireccion());
            System.out.println("DNI: " + usuario.getDni());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Localidad: " + usuario.getLocalidad());
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Pais: " + usuario.getPais());
            System.out.println("Provincia: " + usuario.getProvincia());
            System.out.println("Usuario: " + usuario.getUsuario());
            System.out.println("Codigo Postal: " + usuario.getCodigopostal());
            System.out.println("Apellido1: " + Utilidades.getFormatoFecha(usuario.getFechanacimiento()));
            System.out.println("Movil: " + usuario.getMovil());
            System.out.println("Privilegio: " + usuario.getPrivilegios());
            System.out.println("Slario: " + usuario.getSalario());
            System.out.println("Telegono: " + usuario.getTelefono());
            
            System.out.println(usuarioOK);
 
        }
        if (empresaOK && usuarioOK) {
            return "ok";
        } else {
            return "error";
        }
    }
}
