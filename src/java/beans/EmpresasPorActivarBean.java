/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Empresas;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import utiles.Consultas;

/**
 *
 * @author Zeyckler
 */
public class EmpresasPorActivarBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Empresas> listaempresassinactivar;

    /** Creates a new instance of EmpresasPorActivarBean */
    public EmpresasPorActivarBean() {
        this.listaempresassinactivar = Consultas.buscaEmpresaPorActivar();
    }

    public List<Empresas> getListaempresassinactivar() {
        return listaempresassinactivar;
    }

    public void setListaempresassinactivar(List<Empresas> listaempresassinactivar) {
        this.listaempresassinactivar = listaempresassinactivar;
    }
}
