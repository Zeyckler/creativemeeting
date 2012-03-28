/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Empresas;
import bd.Empresasamigas;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import factoria.FactoriaBD;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import utiles.Consultas;
import utiles.Fila;
import utiles.Utilidades;

/**
 *
 * @author AntonioCZ
 */
public class relacionesEmpresarialesBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Object[]> empresasamigas;
    private String nifempresavinculo;
    private boolean vernotificacionvinculo;
    private String notificacionstr;

    {
        vernotificacionvinculo = false;
        empresasamigas = Consultas.buscaempresasAmigas(Utilidades.getNifEmpresaSesion());
        notificacionstr = "";

    }

    /** Creates a new instance of relacionesEmpresarialesBean */
    public relacionesEmpresarialesBean() {
    }

    public List<Object[]> getEmpresasamigas() {
        return empresasamigas;
    }

    public void setEmpresasamigas(List<Object[]> empresasamigas) {
        this.empresasamigas = empresasamigas;
    }

    public String getNifempresavinculo() {
        return nifempresavinculo;
    }

    public void setNifempresavinculo(String nifempresavinculo) {
        this.nifempresavinculo = nifempresavinculo;
    }

    public boolean isVernotificacionvinculo() {
        return vernotificacionvinculo;
    }

    public void setVernotificacionvinculo(boolean vernotificacionvinculo) {
        this.vernotificacionvinculo = vernotificacionvinculo;
    }

    public String getNotificacionstr() {
        return notificacionstr;
    }

    public void setNotificacionstr(String notificacionstr) {
        this.notificacionstr = notificacionstr;
    }

    public String desvincularEmpresa(int indice) {
        String res = null;
        String nif1 = (String) empresasamigas.get(indice)[0];
        String nif2 = Utilidades.getNifEmpresaSesion();
        Empresasamigas empa = Consultas.buscaParejaEmpresasAmigas(nif1, nif2);

        boolean a = FactoriaBD.preActualizarDato(empa);
        empa.setActivo(false);
        boolean b = FactoriaBD.posActualizarDato(empa);
        if (a && b) {
            res = "ok";
        } else {
            res = "error";
        }
        this.empresasamigas.clear();
        this.empresasamigas = Consultas.buscaempresasAmigas(Utilidades.getNifEmpresaSesion());


        return res;
    }

    public String vincularEmpresas() {

        String res = null;
        this.vernotificacionvinculo = false;
        this.notificacionstr = "";
        String nifempresa = Utilidades.getNifEmpresaSesion();
        Empresas emp1 = FactoriaBD.creaEmpresa(nifempresa);
        Empresas emp2 = FactoriaBD.creaEmpresa(this.nifempresavinculo);

        


        Empresasamigas empainactivas = Consultas.buscaParejaEmpresasAmigasInactivas(nifempresa, this.nifempresavinculo);

        if (empainactivas != null) {
            //Si el vinculo esta creado pero no se encuentra activo se actualiza el vinculo, cambiando la activacion inicial a Verdadera

            boolean pre = FactoriaBD.preActualizarDato(empainactivas);
            empainactivas.setActivacioninicial(true);
            empainactivas.setNif1(emp1);
            empainactivas.setNif2(emp2);
            boolean post = FactoriaBD.posActualizarDato(empainactivas);

            if (pre && post) {
                this.vernotificacionvinculo = true;
                this.notificacionstr = "El vinculo con la empresa con N.I.F " + this.nifempresavinculo + " está inactivo. Se ha vuelto a enviar la solicitud de vinculo. "
                        + "Si desea añadir otro vinculo inserte otro N.I.F distinto";
                res = "ok";
                this.empresasamigas.clear();
                this.empresasamigas = Consultas.buscaempresasAmigas(Utilidades.getNifEmpresaSesion());
                this.nifempresavinculo = "";
            } else {
                res = "error";
            }

        } else {

            //Si el vinculo no está creado se crea de nuevo


            Empresasamigas empa = FactoriaBD.creaEmpresasAmigas(emp1, emp2);

            boolean a = FactoriaBD.insertaEmpresasAmigas(empa);

            if (a) {
                this.vernotificacionvinculo = true;
                this.notificacionstr = "Se ha enviado la la solicitud de vinculo a la empresa con N.I.F " + this.nifempresavinculo
                        + ". Si desea añadir otro vinculo inserte otro N.I.F distinto";
                res = "ok";
                this.empresasamigas.clear();
                this.empresasamigas = Consultas.buscaempresasAmigas(Utilidades.getNifEmpresaSesion());
                this.nifempresavinculo = "";

            } else {
                res = "error";
            }
        }

        return res;
    }
}
