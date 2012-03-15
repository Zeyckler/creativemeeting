/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Usuarios;
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

    public String aceptarUsuarios() {
        String res = "";
        try {

            for (Object[] o : this.usuariosnuevosseleccionados) {
                Usuarios u = Consultas.buscarUsuario((String) o[0]);
                FactoriaBD.preActualizarDato(u);
                u.setActivacioninicial(false);
                u.setActivo(true);
                FactoriaBD.posActualizarDato(u);

            }
            this.filasusuariosnuevos.clear();
            this.usuariosnuevosseleccionados.clear();
            List<Object[]> aux = Consultas.buscarUsuariosporActivarAE(Utilidades.getNifEmpresaSesion());
            for (Object[] fila : aux) {
                this.filasusuariosnuevos.add(new Fila(fila, false));
            }
            res = "ok";
        } catch (Exception e) {
            res = "error";
            System.out.println(e.toString());
        }
        return res;
    }

    public String rechazarUsuarios() {
        String res = "";
        try {

            for (Object[] o : this.usuariosnuevosseleccionados) {
                Usuarios u = Consultas.buscarUsuario((String) o[0]);
                FactoriaBD.preActualizarDato(u);
                u.setActivacioninicial(false);
                u.setActivo(false);
                FactoriaBD.posActualizarDato(u);

            }
            this.filasusuariosnuevos.clear();
            this.usuariosnuevosseleccionados.clear();
            List<Object[]> aux = Consultas.buscarUsuariosporActivarAE(Utilidades.getNifEmpresaSesion());
            for (Object[] fila : aux) {
                this.filasusuariosnuevos.add(new Fila(fila, false));
            }
            res = "ok";
        } catch (Exception e) {
            res = "error";
            System.out.println(e.toString());
        }
        return res;
    }
}