/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Asistenciareunion;
import bd.Empresas;
import bd.Puntosdeldia;
import bd.Reuniones;
import bd.Usuarios;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
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
    private Set<Empresas> empresasasistentes;
    private Puntosdeldia puntoactual;
    private boolean arraydisabledaceptar[];
    private boolean arraydisabledrechazar[];

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
        this.empresasasistentes = new HashSet<Empresas>();

        int tampuntosdia = reunion.getPuntosdeldiaCollection().size();

        this.arraydisabledaceptar = new boolean[tampuntosdia];
        this.arraydisabledrechazar = new boolean[tampuntosdia];

        for (int i = 0; i < tampuntosdia; i++) {
            if (i == 0) {
                this.arraydisabledaceptar[i] = false;
                this.arraydisabledrechazar[i] = true;
            } else {
                this.arraydisabledaceptar[i] = true;
                this.arraydisabledrechazar[i] = true;
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

    public Set<Empresas> getEmpresasasistentes() {
        return empresasasistentes;
    }

    public void setEmpresasasistentes(Set<Empresas> empresasasistentes) {
        this.empresasasistentes = empresasasistentes;
    }

    public boolean[] getArraydisabledaceptar() {
        return arraydisabledaceptar;
    }

    public void setArraydisabledaceptar(boolean[] arraydisabledaceptar) {
        this.arraydisabledaceptar = arraydisabledaceptar;
    }

    public boolean[] getArraydisabledrechazar() {
        return arraydisabledrechazar;
    }

    public void setArraydisabledrechazar(boolean[] arraydisabledrechazar) {
        this.arraydisabledrechazar = arraydisabledrechazar;
    }

    public Puntosdeldia getPuntoactual() {
        return puntoactual;
    }

    public void setPuntoactual(Puntosdeldia puntoactual) {
        this.puntoactual = puntoactual;
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
                for (Usuarios us : this.usuariosasistentesconf) {
                    this.empresasasistentes.add(us.getNif());

                }
            }
        }

        Calendar c1 = Calendar.getInstance();
        this.reunion.setFechainicialreal(c1.getTime());
        System.out.print(c1.get(Calendar.HOUR_OF_DAY)+":"+ c1.get(Calendar.MINUTE)+":"+ c1.get(Calendar.SECOND));

        return res;

    }

    public String formatoHora(Date a) {

        String fecha ="";
        fecha = Utilidades.getFormatoFechaHoraSegundo(a);

        return fecha;
    }

    public boolean visibilidadAceptar(int indice) {

        return arraydisabledaceptar[indice];
    }

    public boolean visibilidadRechazar(int indice) {

        return arraydisabledrechazar[indice];
    }

    public String empezarPuntoDia(int indice) {
        String res = "";
        
        System.out.print(indice);

        this.puntoactual = reunion.getPuntosdeldiaCollection().get(indice);
        
        System.out.print(this.puntoactual.getTitulopunto());
        
        this.arraydisabledaceptar[indice] = true;
        this.arraydisabledrechazar[indice] = false;
        this.reunion.getPuntosdeldiaCollection().get(indice).setHorainicio(Calendar.getInstance().getTime());
        res = "ok";


        return res;
    }

    public String terminarPuntoDia(int indice) {
        String res = "";
        if (indice == this.arraydisabledaceptar.length - 1 || indice == this.arraydisabledrechazar.length - 1) {
            this.puntoactual = null;
            this.arraydisabledrechazar[indice] = true;
            this.reunion.getPuntosdeldiaCollection().get(indice).setHorafin(Calendar.getInstance().getTime());
            res = "ok";

        } else {
            this.puntoactual = null;
            this.arraydisabledrechazar[indice] = true;
            this.arraydisabledaceptar[indice + 1] = false;
            this.reunion.getPuntosdeldiaCollection().get(indice).setHorafin(Calendar.getInstance().getTime());
            res = "ok";

        }



        return res;
    }
}
