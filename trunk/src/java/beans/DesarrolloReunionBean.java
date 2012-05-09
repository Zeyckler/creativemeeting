/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Asistenciareunion;
import bd.Reuniones;
import bd.Usuarios;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import utiles.Fila;
import utiles.Utilidades;

/**
 *
 * @author AntonioCZ
 */
public class DesarrolloReunionBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Reuniones reunion;
    private List<Fila<Usuarios>> usuariosasistentes;
    private List<Usuarios> usuariosasistentesconf;
    private boolean errorconfirmarasist;
    private String errorasistencia;

    /** Creates a new instance of DesarrolloReunionBean */
    public DesarrolloReunionBean() {
    }

    public void inicializaDesarrolloReunion() {

        this.errorasistencia = "";
        this.errorconfirmarasist = false;

        UsuariosBean us = (UsuariosBean) Utilidades.getSessionBean("usuario");

        this.reunion = us.getReunionhoy();
        this.usuariosasistentes = new LinkedList<Fila<Usuarios>>();
        this.usuariosasistentesconf = new LinkedList<Usuarios>();

        for (Asistenciareunion ar : reunion.getAsistenciareunionCollection()) {
            if (ar.getNotificacion() == false && ar.getRespuesta() == true) {
                Fila f = new Fila(ar.getDni(), false);
                usuariosasistentes.add(f);
            }
        }





    }

    public Reuniones getReunion() {
        return reunion;
    }

    public void setReunion(Reuniones reunion) {
        this.reunion = reunion;
    }

    public List<Fila<Usuarios>> getUsuariosasistentes() {
        return usuariosasistentes;
    }

    public void setUsuariosasistentes(List<Fila<Usuarios>> usuariosasistentes) {
        this.usuariosasistentes = usuariosasistentes;
    }

    public List<Usuarios> getUsuariosasistentesconf() {
        return usuariosasistentesconf;
    }

    public void setUsuariosasistentesconf(List<Usuarios> usuariosasistentesconf) {
        this.usuariosasistentesconf = usuariosasistentesconf;
    }

    public String getErrorasistencia() {
        return errorasistencia;
    }

    public void setErrorasistencia(String errorasistencia) {
        this.errorasistencia = errorasistencia;
    }

    public boolean isErrorconfirmarasist() {
        return errorconfirmarasist;
    }

    public void setErrorconfirmarasist(boolean errorconfirmarasist) {
        this.errorconfirmarasist = errorconfirmarasist;
    }

    public void usuarioSeleccionadaListener(RowSelectorEvent event) {

        this.usuariosasistentesconf.clear();
        Integer numerofilas = this.usuariosasistentes.size();

        for (int i = 0, max = numerofilas; i < max; i++) {

            Fila<Usuarios> fila = this.usuariosasistentes.get(i);
            if (fila.isSeleccionada()) {
                this.usuariosasistentesconf.add(fila.getTipo());
            }

        }

    }

    public String confirmarAsistenciaReunion() {
        String res = "";
        this.errorasistencia = "";
        this.errorconfirmarasist = false;
        boolean admin = false;


        if (usuariosasistentesconf.size() < 2) {
            this.errorasistencia = "Debe haber al menos dos asistentes en la reunion";
            this.errorconfirmarasist = true;
            res = "error";
        } else {
            for (Usuarios u : usuariosasistentesconf) {

                if (u.getDni().equals(Utilidades.getDniUsuarioSesion())) {
                    admin = true;
                    break;
                }
            }
            if (admin == false) {
                this.errorasistencia = "El creador de la reunión debe asistir a la reunión";
                this.errorconfirmarasist = true;
                res = "error";
            } else {
                res = "ok";
            }
        }

        Calendar c1 = Calendar.getInstance();
        this.reunion.setFechainicialreal(c1.getTime());
        System.out.print(c1.getTime().toString());
        return res;

    }

    public String formatoHora(Date a) {
        
        String fecha;
        fecha = Utilidades.getFormatoFechaHoraSegundo(a);

        return fecha;
    }
}
