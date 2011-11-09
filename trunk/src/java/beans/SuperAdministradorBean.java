/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Empresas;
import java.util.List;
import utiles.Consultas;

/**
 *
 * @author Zeyckler
 */
public class SuperAdministradorBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Empresas> listaempresassinactivar;

    /** Creates a new instance of SuperAdministradorBean */
    public SuperAdministradorBean() {
    }

    public void empresasNoActivadasInicialmente() {
        List<Empresas> le = Consultas.buscaEmpresaPorActivar();
        this.listaempresassinactivar = le;
    }
    
    public List<Empresas> listaEmpresasNoActivadas{}
}
