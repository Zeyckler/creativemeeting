/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Asistenciareunion;
import bd.Empresasamigas;
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
    private List<Usuarios> filasusuariosnuevos;
    private List<Reuniones> listadereunionesnotificacion;
    private List<Empresasamigas> listanotificacionesrelacionesempresariales;
    boolean errorsolicitudusuario;
    boolean errorsolicitudreunion;
    boolean errorsolicitudempresa;

    public VerNotificacionesAEBean() {
    }

    public void inicializaVerNotificacionesAEBean() {


        String dni = Utilidades.getDniUsuarioSesion();
        String nif = Utilidades.getNifEmpresaSesion();
        this.listadereunionesnotificacion = Consultas.buscaReunionesNotificacionesporUsuario(dni);
        this.listanotificacionesrelacionesempresariales = Consultas.buscaEmpresasAmigasNotificacion(nif);
        this.filasusuariosnuevos = Consultas.buscarUsuariosporActivarAE(Utilidades.getNifEmpresaSesion());

    }

    public List<Usuarios> getFilasusuariosnuevos() {
        return filasusuariosnuevos;
    }

    public void setFilasusuariosnuevos(List<Usuarios> filasusuariosnuevos) {
        this.filasusuariosnuevos = filasusuariosnuevos;
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

    public boolean isErrorsolicitudempresa() {
        return errorsolicitudempresa;
    }

    public void setErrorsolicitudempresa(boolean errorsolicitudempresa) {
        this.errorsolicitudempresa = errorsolicitudempresa;
    }

    public boolean isErrorsolicitudreunion() {
        return errorsolicitudreunion;
    }

    public void setErrorsolicitudreunion(boolean errorsolicitudreunion) {
        this.errorsolicitudreunion = errorsolicitudreunion;
    }

    public boolean isErrorsolicitudusuario() {
        return errorsolicitudusuario;
    }

    public void setErrorsolicitudusuario(boolean errorsolicitudusuario) {
        this.errorsolicitudusuario = errorsolicitudusuario;
    }

    public String aceptarUsuarios(int indice) {

        String res = "";
        this.errorsolicitudusuario = false;


        try {
            Usuarios us = this.filasusuariosnuevos.get(indice);
            FactoriaBD.preActualizarDato(us);
            us.setActivacioninicial(false);
            us.setActivo(true);
            FactoriaBD.posActualizarDato(us);
            res = "ok";
        } catch (Exception e) {
            res = "error";
            this.errorsolicitudusuario = true;
            System.out.println(e.toString());
        }

        return res;
    }
        public String rechazarUsuarios(int indice) {

        String res = "";
        this.errorsolicitudusuario = false;


        try {
            Usuarios us = this.filasusuariosnuevos.get(indice);
            FactoriaBD.preActualizarDato(us);
            us.setActivacioninicial(false);
            us.setActivo(false);
            FactoriaBD.posActualizarDato(us);
            res = "ok";
        } catch (Exception e) {
            res = "error";
            this.errorsolicitudusuario = true;
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

        String res = "";
        this.errorsolicitudreunion = false;
        String dniusuario = Utilidades.getDniUsuarioSesion();
        Reuniones reunion = this.listadereunionesnotificacion.get(indice);
        Integer id = reunion.getIdreunion();
        System.out.print("Indice de la lista de reuniones" + indice);

        System.out.print(Utilidades.getFormatoFecha(reunion.getFechainicial()));
        Collection<Asistenciareunion> asistencia = reunion.getAsistenciareunionCollection();
        System.out.print(asistencia.size());
        for (Asistenciareunion asis : asistencia) {
            Usuarios usuario = asis.getDni();
            System.out.print("Usuarios que asisten a la reunion :" + usuario.getDni());
            if (usuario.getDni().equals(dniusuario) && id == asis.getIdreunion().getIdreunion()) {
                try {
                    FactoriaBD.preActualizarDato(asis);
                    asis.setNotificacion(false);
                    asis.setRespuesta(true);
                    FactoriaBD.posActualizarDato(asis);
                    res = "aceptarok";
                    System.out.print("Se ha entrado en el try");
                } catch (Exception e) {
                    System.out.print(e.toString());
                    res = "aceptarerror";
                    this.errorsolicitudreunion = true;

                }
            }
        }
        System.out.print(res);
        return res;
    }

    public String rechazaReunion(int indice) {

        String res = "";
        this.errorsolicitudreunion = false;
        String dniusuario = Utilidades.getDniUsuarioSesion();
        Reuniones reunion = this.listadereunionesnotificacion.get(indice);
        Integer id = reunion.getIdreunion();
        System.out.print("Indice de la lista de reuniones" + indice);

        System.out.print(Utilidades.getFormatoFecha(reunion.getFechainicial()));
        Collection<Asistenciareunion> asistencia = reunion.getAsistenciareunionCollection();
        System.out.print(asistencia.size());
        for (Asistenciareunion asis : asistencia) {
            Usuarios usuario = asis.getDni();
            System.out.print("Usuarios que asisten a la reunion :" + usuario.getDni());
            if (usuario.getDni().equals(dniusuario) && id == asis.getIdreunion().getIdreunion()) {
                try {
                    FactoriaBD.preActualizarDato(asis);
                    asis.setNotificacion(false);
                    asis.setRespuesta(false);
                    asis.setAsistencia(false);
                    FactoriaBD.posActualizarDato(asis);
                    res = "rechazarok";
                    System.out.print("Se ha entrado en el try");
                } catch (Exception e) {
                    System.out.print(e.toString());
                    res = "rechazarerror";
                    this.errorsolicitudreunion = true;

                }
            }
        }
        System.out.print(res);
        return res;

    }

    public String aceptarEmpresa(int indice) {
        String res = "";
        this.errorsolicitudempresa = false;
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
            this.errorsolicitudempresa = true;
        }
        return res;
    }

    public String rechazarEmpresa(int indice) {
        String res = "";
        this.errorsolicitudempresa = false;
        try {
            Empresasamigas ea = this.listanotificacionesrelacionesempresariales.get(indice);
            FactoriaBD.preActualizarDato(ea);
            ea.setActivacioninicial(false);
            FactoriaBD.posActualizarDato(ea);
            res = "ok";
        } catch (Exception e) {
            res = "error";
            System.out.println(e);
            this.errorsolicitudempresa = true;
        }
        return res;
    }
}