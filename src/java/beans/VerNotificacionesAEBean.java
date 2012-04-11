/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Empresasamigas;
import bd.Puntosdeldia;
import bd.Reuniones;
import bd.Usuarios;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import factoria.FactoriaBD;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
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
    private boolean iniciovacio;
    private List<Fila<Object[]>> filasusuariosnuevos;
    private List<Object[]> usuariosnuevosseleccionados;
    private List<Reuniones> listadereunionesnotificacion;
    private List<Empresasamigas> listanotificacionesrelacionesempresariales;

    public VerNotificacionesAEBean() {
        this.iniciovacio = true;
    }

    public void inicializaVerNotificacionesAEBean() {
        this.iniciovacio = false;
        this.usuariosnuevosseleccionados = new LinkedList<Object[]>();
        this.filasusuariosnuevos = new LinkedList<Fila<Object[]>>();
        String dni = Utilidades.getDniUsuarioSesion();
        String nif = Utilidades.getNifEmpresaSesion();
        this.listadereunionesnotificacion = Consultas.buscaReunionesNotificacionesporUsuario(dni);
        this.listanotificacionesrelacionesempresariales = Consultas.buscaEmpresasAmigasNotificacion(nif);
        List<Object[]> aux = Consultas.buscarUsuariosporActivarAE(Utilidades.getNifEmpresaSesion());
        for (Object[] fila : aux) {
            this.filasusuariosnuevos.add(new Fila(fila, false));
        }
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

    public List<Reuniones> getListadereunionesnotificacion() {
        return listadereunionesnotificacion;
    }

    public void setListadereunionesnotificacion(List<Reuniones> listadereunionesnotificacion) {
        this.listadereunionesnotificacion = listadereunionesnotificacion;
    }

    public List<Empresasamigas> getListanotificacionesrelacionesempresariales() {
        return listanotificacionesrelacionesempresariales;
    }

    public void setListanotificacionesrelacionesempresariales(List<Empresasamigas> listanotificacionesrelacionesempresariales) {
        this.listanotificacionesrelacionesempresariales = listanotificacionesrelacionesempresariales;
    }

    public boolean isIniciovacio() {
        return iniciovacio;
    }

    public void setIniciovacio(boolean iniciovacio) {
        this.iniciovacio = iniciovacio;
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
                res = "ok";
            }
        } catch (Exception e) {
            res = "error";
            System.out.println(e);
        }
        this.filasusuariosnuevos.clear();
        this.usuariosnuevosseleccionados.clear();
        List<Object[]> aux = Consultas.buscarUsuariosporActivarAE(Utilidades.getNifEmpresaSesion());
        for (Object[] fila : aux) {
            this.filasusuariosnuevos.add(new Fila(fila, false));
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

    public String calcularDuracionReunion(int index) {
        String minutostr = null;
        Calendar calini = Calendar.getInstance();
        Date fechini = this.listadereunionesnotificacion.get(index).getFechainicial();
        calini.setTime(fechini);

        Calendar calfin = Calendar.getInstance();
        Date fechfin = this.listadereunionesnotificacion.get(index).getFechafinalestimada();
        calfin.setTime(fechfin);

        long a = calini.getTimeInMillis();
        long b = calfin.getTimeInMillis();
        long hora = (b - a) / 3600000;
        long restohora = (b - a) % 3600000;
        long minuto = restohora / 60000;

        if (minuto <= 9) {
            minutostr = "0" + minuto;
        } else {
            minutostr = Long.toString(minuto);
        }
        return hora + ":" + minutostr;
    }

    public String formatoFecha(Date fecha) {
        return Utilidades.getFormatoFecha(fecha) + " " + Utilidades.getFormatoFechaHora(fecha);
    }

    public String aceptaReunion(int indice) {
        System.out.print(indice);
        String res = "aceptarok";
        System.out.print(res);

        return res;
    }

    public String rechazaReunion(int indice) {
        System.out.print("Indice de rechazar:" + indice);
        return "rechazarok";

    }

    public String aceptarEmpresa(int indice) {
        String res = "";
        try {
            Empresasamigas ea = this.listanotificacionesrelacionesempresariales.get(indice);
            FactoriaBD.preActualizarDato(ea);
            ea.setActivacioninicial(false);
            ea.setActivo(true);
            FactoriaBD.posActualizarDato(ea);
            res = "ok";
        } catch (Exception e) {
            res = "error";
            System.out.println(e);
        }
        this.listanotificacionesrelacionesempresariales.clear();
        this.listanotificacionesrelacionesempresariales = Consultas.buscaEmpresasAmigasNotificacion(Utilidades.getNifEmpresaSesion());
        return res;
    }

    public String rechazarEmpresa(int indice) {
        String res = "";
        try {
            Empresasamigas ea = this.listanotificacionesrelacionesempresariales.get(indice);
            FactoriaBD.preActualizarDato(ea);
            ea.setActivacioninicial(false);
            FactoriaBD.posActualizarDato(ea);
            res = "ok";
        } catch (Exception e) {
            res = "error";
            System.out.println(e);
        }
        this.listanotificacionesrelacionesempresariales.clear();
        this.listanotificacionesrelacionesempresariales = Consultas.buscaEmpresasAmigasNotificacion(Utilidades.getNifEmpresaSesion());
        return res;
    }
}
