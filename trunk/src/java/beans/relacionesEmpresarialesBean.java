/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.icesoft.faces.component.ext.RowSelectorEvent;
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
    private List<Fila<Object[]>> filasempresasamigas;
    private List<Object[]> empresasamigasseleccionadas;
    private boolean mostrarlistadesvincular;
    private List<Object[]> empresasamigas ;

    {
        mostrarlistadesvincular = false;
        empresasamigasseleccionadas = new LinkedList<Object[]>();
        filasempresasamigas = new LinkedList<Fila<Object[]>>();
        empresasamigas = Consultas.buscaempresasAmigas(Utilidades.getNifEmpresaSesion());
        for (Object[] emp : empresasamigas) {
            Fila<Object[]> fila2 = new Fila(emp, false);
            this.filasempresasamigas.add(fila2);
        }

    }

    /** Creates a new instance of relacionesEmpresarialesBean */
    public relacionesEmpresarialesBean() {
    }

    public List<Object[]> getEmpresasamigasseleccionadas() {
        return empresasamigasseleccionadas;
    }

    public void setEmpresasamigasseleccionadas(List<Object[]> empresasamigasseleccionadas) {
        this.empresasamigasseleccionadas = empresasamigasseleccionadas;
    }

    public List<Fila<Object[]>> getFilasempresasamigas() {
        return filasempresasamigas;
    }

    public void setFilasempresasamigas(List<Fila<Object[]>> filasempresasamigas) {
        this.filasempresasamigas = filasempresasamigas;
    }

    public boolean isMostrarlistadesvincular() {
        return mostrarlistadesvincular;
    }

    public void setMostrarlistadesvincular(boolean mostrarlistadesvincular) {
        this.mostrarlistadesvincular = mostrarlistadesvincular;
    }

    public List<Object[]> getEmpresasamigas() {
        return empresasamigas;
    }

    public void setEmpresasamigas(List<Object[]> empresasamigas) {
        this.empresasamigas = empresasamigas;
    }
    
    
    

    public void filaSeleccionadaEmpresasAmigasListener(RowSelectorEvent event) {

        this.empresasamigasseleccionadas.clear();
        Integer numerofilas = filasempresasamigas.size();

        for (int i = 0, max = numerofilas; i < max; i++) {

            Fila<Object[]> fila = filasempresasamigas.get(i);
            if (fila.isSeleccionada()) {
                this.empresasamigasseleccionadas.add(fila.getTipo());
            }

        }

    }

    public String mostrarlistadesvincular() {
        
            this.mostrarlistadesvincular=true;
            return "ok";
            
    }
}
