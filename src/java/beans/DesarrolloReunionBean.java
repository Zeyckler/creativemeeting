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
import factoria.FactoriaBD;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
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
    private List<Fila<Usuarios>> usuariosasistentesconfila;
    private boolean errorconfirmarasist;
    private String errorasistencia;
    private Set<Empresas> empresasasistentes;
    private Puntosdeldia puntoactual;
    private boolean arraydisabledaceptar[];
    private boolean arraydisabledrechazar[];
    private Usuarios usuarioIntervencion;
    private String intervencion;
    private boolean puntoinactivo;

    /** Creates a new instance of DesarrolloReunionBean */
    public DesarrolloReunionBean() {
    }

    public void inicializaDesarrolloReunion() {
        
        System.out.print("He entrado en el inicializaDesarrolloReunion");
        UsuariosBean us = (UsuariosBean) Utilidades.getSessionBean("usuario");

        this.reunion = us.getReunionhoy();
        this.errorasistencia = "";
        this.errorconfirmarasist = false;
        this.usuariosasistentes = new LinkedList<Fila<Usuarios>>();
        this.usuariosasistentesconfila = new LinkedList<Fila<Usuarios>>();
        this.usuariosasistentesconf = new LinkedList<Usuarios>();
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




        /*if (reunion.getAsistenciareunionCollection().size() > 0) {
        for (Asistenciareunion ar : reunion.getAsistenciareunionCollection()) {
        if (ar.getNotificacion() == false && ar.getRespuesta() == true) {
        Fila f = new Fila(ar.getDni(), false);
        usuariosasistentes.add(f);
        }
        }
        }*/
        ///
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

    public List<Fila<Usuarios>> getUsuariosasistentesconfila() {
        return usuariosasistentesconfila;
    }

    public void setUsuariosasistentesconfila(List<Fila<Usuarios>> usuariosasistentesconfila) {
        this.usuariosasistentesconfila = usuariosasistentesconfila;
    }

    public Usuarios getUsuarioIntervencion() {
        return usuarioIntervencion;
    }

    public void setUsuarioIntervencion(Usuarios usuarioIntervencion) {
        this.usuarioIntervencion = usuarioIntervencion;
    }

    public String getIntervencion() {
        return intervencion;
    }

    public void setIntervencion(String intervencion) {
        this.intervencion = intervencion;
    }

    public boolean isPuntoinactivo() {
        return puntoinactivo;
    }

    public void setPuntoinactivo(boolean puntoinactivo) {
        this.puntoinactivo = puntoinactivo;
    }

    public void usuarioSeleccionadaListener(RowSelectorEvent event) {

        this.usuariosasistentesconf.clear();
        this.usuariosasistentesconfila.clear();
        Integer numerofilas = this.usuariosasistentes.size();

        for (int i = 0, max = numerofilas; i < max; i++) {

            Fila<Usuarios> fila = this.usuariosasistentes.get(i);
            if (fila.isSeleccionada()) {
                this.usuariosasistentesconf.add(fila.getTipo());
                Fila confirmados = new Fila<Usuarios>(fila.getTipo(), false);
                this.usuariosasistentesconfila.add(confirmados);
            }

        }

    }

    public void usuarioIntervencion(RowSelectorEvent event) {

        this.usuarioIntervencion = null;
        Integer numerofilas = this.usuariosasistentesconfila.size();

        for (int i = 0, max = numerofilas; i < max; i++) {

            Fila<Usuarios> fila = this.usuariosasistentes.get(i);
            if (fila.isSeleccionada()) {
                this.usuarioIntervencion = fila.getTipo();
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
                Reuniones a = this.reunion;

                System.out.print("Preactualizando dato");
                FactoriaBD.preActualizarDato(a);
                a.setFechainicialreal(Calendar.getInstance().getTime());

                System.out.println("tamaño asistentes confirmados" + this.reunion.getAsistenciareunionCollection().size());
                List<Asistenciareunion> asr = this.reunion.getAsistenciareunionCollection();
                for (Usuarios user : this.usuariosasistentesconf) {
                    for (int i = 0; i < a.getAsistenciareunionCollection().size(); i++) {


                        if (user.getDni().equals(asr.get(i).getDni().getDni())) {
                            System.out.println(user.getDni());
                            asr.get(i).setAsistencia(true);
                        }

                    }
                }
                a.setAsistenciareunionCollection(asr);

                FactoriaBD.posActualizarDato(a);



                System.out.print("Preactualizando dato hecho");

                for (Usuarios us : this.usuariosasistentesconf) {
                    this.empresasasistentes.add(us.getNif());

                }
            }
        }

        return res;

    }

    public String formatoHora(Date a) {

        String fecha = "";
        fecha = Utilidades.getFormatoFechaHoraSegundo(a);

        return fecha;
    }

    public void vaciarUsuarioIntervencion() {

        if (this.usuariosasistentesconfila != null && !this.usuariosasistentesconfila.isEmpty()) {
            for (int i = 0; i < usuariosasistentesconfila.size(); i++) {

                usuariosasistentesconfila.get(i).setSeleccionada(false);

            }
        }
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
        this.puntoinactivo = false;
        res = "ok";
        vaciarUsuarioIntervencion();


        return res;
    }

    public String terminarPuntoDia(int indice) {
        String res = "";
        this.puntoinactivo = false;
        if (indice == this.arraydisabledaceptar.length - 1 || indice == this.arraydisabledrechazar.length - 1) {
            this.arraydisabledrechazar[indice] = true;
            this.reunion.getPuntosdeldiaCollection().get(indice).setHorafin(Calendar.getInstance().getTime());
            this.puntoinactivo = true;
            res = "ok";


        } else {
            this.arraydisabledrechazar[indice] = true;
            this.arraydisabledaceptar[indice + 1] = false;
            this.reunion.getPuntosdeldiaCollection().get(indice).setHorafin(Calendar.getInstance().getTime());
            this.puntoinactivo = true;
            res = "ok";


        }

        vaciarUsuarioIntervencion();

        return res;
    }

    
}
