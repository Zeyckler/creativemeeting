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
 * @author Zeyckler
 */
public class VerNotificacionesAEBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Fila<Object[]>> filasusuariosnuevos;
    private List<Object[]> usuariosnuevosseleccionados;

    {
        this.usuariosnuevosseleccionados = new LinkedList<Object[]>();
        this.filasusuariosnuevos = new LinkedList<Fila<Object[]>>();
        List<Object[]> aux = Consultas.buscarUsuariosporActivarAE(Utilidades.getNifEmpresaSesion());
        for (Object[] fila : aux) {
            this.filasusuariosnuevos.add(new Fila(fila, false));
        }
    }

    /** Creates a new instance of VerNotificacionesAEBean */
    public VerNotificacionesAEBean() {
    }

    public List<Fila<Object[]>> getFilasusuariosnuevos() {
        return filasusuariosnuevos;
    }

    public void setFilasusuariosnuevos(List<Fila<Object[]>> filasusuariosnuevos) {
        this.filasusuariosnuevos = filasusuariosnuevos;
    }

    public List<Object[]> getUsuariosnuevosseleccionados() {
        return usuariosnuevosseleccionados;
    }

    public void setUsuariosnuevosseleccionados(List<Object[]> usuariosnuevosseleccionados) {
        this.usuariosnuevosseleccionados = usuariosnuevosseleccionados;
    }

    public void usuarioSeleccionadaListener(RowSelectorEvent event) {

        this.usuariosnuevosseleccionados.clear();
        Integer numerofilas = filasusuariosnuevos.size();

        for (int i = 0, max = numerofilas; i < max; i++) {

            Fila<Object[]> fila = filasusuariosnuevos.get(i);
            if (fila.isSeleccionada()) {
                this.usuariosnuevosseleccionados.add(fila.getTipo());
            }

        }

    }
}
