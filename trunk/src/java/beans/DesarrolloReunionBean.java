/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Asistenciareunion;
import bd.Empresas;
import bd.Intervenciones;
import bd.Puntosdeldia;
import bd.Reuniones;
import bd.Usuarios;
import beans.actaReunionBean;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import factoria.FactoriaBD;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
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
    private List<Usuarios> usuarioIntervencionlista;
    private String intervencion;
    private boolean puntoinactivo;
    private boolean errorintervencion;
    private String errorintervencionstr;
    private boolean exitointervencion;
    private double costealquilersala;
    private boolean reunionfinalizada;

    /** Creates a new instance of DesarrolloReunionBean */
    public DesarrolloReunionBean() {
    }

    public void inicializaDesarrolloReunion() {

        //System.out.print("He entrado en el inicializaDesarrolloReunion");
        UsuariosBean us = (UsuariosBean) Utilidades.getSessionBean("usuario");

        this.reunion = us.getReunionhoy();
        this.reunion.setCoste(new Integer(0));
        this.errorasistencia = "";
        this.errorconfirmarasist = false;
        this.errorintervencion = false;
        this.exitointervencion = false;
        this.usuariosasistentes = new LinkedList<Fila<Usuarios>>();
        this.usuariosasistentesconfila = new LinkedList<Fila<Usuarios>>();
        this.usuariosasistentesconf = new LinkedList<Usuarios>();
        this.empresasasistentes = new HashSet<Empresas>();
        this.usuarioIntervencionlista = new LinkedList<Usuarios>();


        int tampuntosdia = reunion.getPuntosdeldiaCollection().size();

        this.arraydisabledaceptar = new boolean[tampuntosdia];
        this.arraydisabledrechazar = new boolean[tampuntosdia];
        /*
        for (int i = 0; i < tampuntosdia; i++) {
        if (i == 0) {
        this.arraydisabledaceptar[i] = false;
        if (puntoComenzado(i) && !puntoTermindo(i)) {
        System.out.print("ha entrado donde yo quiero");
        this.arraydisabledrechazar[i] = false;
        this.puntoactual = this.reunion.getPuntosdeldiaCollection().get(i);
        this.setPuntoinactivo(false);
        } else {
        this.arraydisabledrechazar[i] = true;
        }
        } else {
        this.arraydisabledaceptar[i] = true;
        this.arraydisabledrechazar[i] = true;
        }
        
        }
         */


        for (int i = 0; i < tampuntosdia; i++) {
            this.arraydisabledaceptar[i] = true;
            this.arraydisabledrechazar[i] = true;
            if (i == (tampuntosdia - 1) && puntoComenzado(i) && puntoTermindo(i)) {
                this.puntoactual = null;
                this.puntoinactivo = false;
            }

            if (!puntoComenzado(i) && !puntoTermindo(i)) {
                this.arraydisabledaceptar[i] = false;
                this.arraydisabledrechazar[i] = true;
                this.puntoactual = null;
                this.setPuntoinactivo(true);

                i++;
                for (; i < tampuntosdia; i++) {
                    this.arraydisabledaceptar[i] = true;
                    this.arraydisabledrechazar[i] = true;
                }
                break;

            } else if (puntoComenzado(i) && !puntoTermindo(i)) {
                this.arraydisabledaceptar[i] = true;
                this.arraydisabledrechazar[i] = false;
                //System.out.print("ha entrado aqui en el indice: " + i);
                this.puntoactual = this.reunion.getPuntosdeldiaCollection().get(i);
                this.setPuntoinactivo(false);
                i++;
                for (; i < tampuntosdia; i++) {
                    this.arraydisabledaceptar[i] = true;
                    this.arraydisabledrechazar[i] = true;
                }
                break;
            }

        }
        if (!puntoComenzado(0) && !puntoTermindo(0)) {
            this.puntoactual = null;
            this.puntoinactivo = false;

        }
        for (Asistenciareunion ar : reunion.getAsistenciareunionCollection()) {
            if (ar.getNotificacion() == false && ar.getRespuesta() == true) {
                Fila f = new Fila(ar.getDni(), false);
                usuariosasistentes.add(f);
            }
        }
        this.costealquilersala = costeAlquilerSala();
        this.reunionfinalizada = false;

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

    public List<Usuarios> getUsuarioIntervencionlista() {
        return usuarioIntervencionlista;
    }

    public void setUsuarioIntervencionlista(List<Usuarios> usuarioIntervencionlista) {
        this.usuarioIntervencionlista = usuarioIntervencionlista;
    }

    public boolean isErrorintervencion() {
        return errorintervencion;
    }

    public void setErrorintervencion(boolean errorintervencion) {
        this.errorintervencion = errorintervencion;
    }

    public String getErrorintervencionstr() {
        return errorintervencionstr;
    }

    public void setErrorintervencionstr(String errorintervencionstr) {
        this.errorintervencionstr = errorintervencionstr;
    }

    public boolean isExitointervencion() {
        return exitointervencion;
    }

    public void setExitointervencion(boolean exitointervencion) {
        this.exitointervencion = exitointervencion;
    }

    public double getCostealquilersala() {
        return costealquilersala;
    }

    public void setCostealquilersala(double costealquilersala) {
        this.costealquilersala = costealquilersala;
    }

    public boolean isReunionfinalizada() {
        return reunionfinalizada;
    }

    public void setReunionfinalizada(boolean reunionfinalizada) {
        this.reunionfinalizada = reunionfinalizada;
    }

    public void usuarioSeleccionadaListener(RowSelectorEvent event) {

        this.usuariosasistentesconf.clear();
        this.usuariosasistentesconfila.clear();
        Integer numerofilas = this.usuariosasistentes.size();

        for (int i = 0; i < numerofilas; i++) {

            Fila<Usuarios> fila = this.usuariosasistentes.get(i);
            if (fila.isSeleccionada()) {
                this.usuariosasistentesconf.add(fila.getTipo());
                Fila confirmados = new Fila<Usuarios>(fila.getTipo(), false);
                this.usuariosasistentesconfila.add(confirmados);
            }

        }

    }

    public void usuarioIntervencionReunion(RowSelectorEvent event) {

        this.usuarioIntervencion = null;
        this.usuarioIntervencionlista = new LinkedList<Usuarios>();
        //System.out.print("hemos entrado en el Metodo Listener");

        Integer numerofilas = this.usuariosasistentesconfila.size();

        //System.out.print("numero de Filas asistentes" + numerofilas);

        for (int i = 0, max = numerofilas; i < max; i++) {

            Fila<Usuarios> fila = this.usuariosasistentesconfila.get(i);
            if (fila.isSeleccionada()) {
                this.usuarioIntervencion = fila.getTipo();
                this.usuarioIntervencionlista.add(fila.getTipo());
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

                //System.out.print("Preactualizando dato");
                FactoriaBD.preActualizarDato(a);
                a.setFechainicialreal(Calendar.getInstance().getTime());

                //System.out.println("tamaño asistentes confirmados" + this.reunion.getAsistenciareunionCollection().size());
                List<Asistenciareunion> asr = this.reunion.getAsistenciareunionCollection();
                for (Usuarios user : this.usuariosasistentesconf) {
                    for (int i = 0; i < a.getAsistenciareunionCollection().size(); i++) {


                        if (user.getDni().equals(asr.get(i).getDni().getDni())) {
                            //System.out.println(user.getDni());
                            asr.get(i).setAsistencia(true);
                        }

                    }
                }
                a.setAsistenciareunionCollection(asr);

                FactoriaBD.posActualizarDato(a);



                //System.out.print("Preactualizando dato hecho");

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

        //System.out.print(indice);

        this.puntoactual = reunion.getPuntosdeldiaCollection().get(indice);

        //System.out.print(this.puntoactual.getTitulopunto());

        this.arraydisabledaceptar[indice] = true;
        this.arraydisabledrechazar[indice] = false;
        this.reunion.getPuntosdeldiaCollection().get(indice).setHorainicio(Calendar.getInstance().getTime());
        this.puntoinactivo = false;
        res = "ok";
        vaciarUsuarioIntervencion();

        Puntosdeldia pt = reunion.getPuntosdeldiaCollection().get(indice);

        FactoriaBD.preActualizarDato(pt);

        pt.setHorainicio(Calendar.getInstance().getTime());

        FactoriaBD.posActualizarDato(pt);




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
        Puntosdeldia pt = reunion.getPuntosdeldiaCollection().get(indice);

        FactoriaBD.preActualizarDato(pt);

        pt.setHorafin(Calendar.getInstance().getTime());

        FactoriaBD.posActualizarDato(pt);
        vaciarUsuarioIntervencion();

        return res;
    }

    public boolean puntoComenzado(int indice) {
        boolean res = false;
        Puntosdeldia pt = reunion.getPuntosdeldiaCollection().get(indice);

        if (pt.getHorainicio() != null) {
            res = true;
        }

        return res;

    }

    public boolean puntoTermindo(int indice) {
        boolean res = false;
        Puntosdeldia pt = reunion.getPuntosdeldiaCollection().get(indice);

        if (pt.getHorafin() != null) {
            res = true;
        }
        //System.out.print("Punto del dia Terminado" + res);
        return res;

    }

    public String intervencionUsuarioReunion() {

        String res = "";
        this.errorintervencion = false;
        this.exitointervencion = false;
        Asistenciareunion asistenciaUsuario = null;
        Intervenciones intervencionUsuario;
        if (this.intervencion.equals("")) {
            res = "error";
            this.errorintervencionstr = "La intervencion no puede estar vacía.";
        } else {
            if (!usuarioIntervencionlista.isEmpty()) {
                for (Asistenciareunion asis : this.reunion.getAsistenciareunionCollection()) {
                    if (asis.getDni().getDni().equals(this.usuarioIntervencion.getDni())) {
                        asistenciaUsuario = asis;
                    }
                }

                if (asistenciaUsuario == null) {
                    res = "error";
                } else {
                    Date actual = Calendar.getInstance().getTime();
                    intervencionUsuario = new Intervenciones(new Integer(1), actual, this.intervencion, this.puntoactual, asistenciaUsuario);
                    try {
                        FactoriaBD.insertaIntervenciones(intervencionUsuario);
                    } catch (Exception e) {
                        System.out.println(e.toString());
                        res = "error";
                    }
                    res = "ok";
                    this.exitointervencion = true;
                    this.intervencion = "";

                }
            } else {
                res = "error";
                this.errorintervencionstr = "Debe seleccionar un usuario para registrar la intervención.";
            }
        }

        if (res == "error") {

            this.errorintervencion = true;
        }

        vaciarUsuarioIntervencion();

        return res;
    }

    public double costeAlquilerSala() {
        int preciohora = this.reunion.getIdsalareunion().getCostealquiler().intValue();
        double preciosegundo = (double) preciohora / (double) 3600;


        Date fechainicialreunion = this.reunion.getFechainicial();
        Date fechafinalreunion = this.reunion.getFechafinalestimada();

        Calendar fechini = Calendar.getInstance();
        fechini.setTime(fechainicialreunion);

        Calendar fechfin = Calendar.getInstance();
        fechfin.setTime(fechafinalreunion);

        long milsecfin = fechfin.getTimeInMillis();
        long milsecini = fechini.getTimeInMillis();

        long resta = milsecfin - milsecini;

        long digseg = resta / 1000;

        double alquilertotal = preciosegundo * digseg;

        return alquilertotal;


    }

    public String terminaReunion() {
        //Reuniones a = this.reunion;
        Date fechafinalreal = Calendar.getInstance().getTime();

        Date fechaini = this.reunion.getFechainicialreal();
        Date fechafin = this.reunion.getFechafinalestimada();
        /* System.out.print("Fecha Inicial Sistema: " + fechaini.toString());
        System.out.print("Fecha Final Sistema: " + fechafin.toString());*/


        Calendar fechainic = Calendar.getInstance();
        fechainic.set(fechainic.get(Calendar.YEAR), fechainic.get(Calendar.MONTH), fechainic.get(Calendar.DAY_OF_MONTH), fechaini.getHours(), fechaini.getMinutes(), fechaini.getSeconds());

        Calendar fechafinc = Calendar.getInstance();
        fechafinc.set(fechafinc.get(Calendar.YEAR), fechafinc.get(Calendar.MONTH), fechafinc.get(Calendar.DAY_OF_MONTH), fechafin.getHours(), fechafin.getMinutes(), fechafin.getSeconds());


        Date fechainicialreal = fechainic.getTime();
        Date fechafinalestimada = fechafinc.getTime();

        double costereunion = costReunion(fechainicialreal, fechafinalreal);

        FactoriaBD.preActualizarDato(this.reunion);
        this.reunion.setFechainicialreal(fechainicialreal);
        this.reunion.setFechafinalreal(fechafinalreal);
        this.reunion.setFechafinalestimada(fechafinalestimada);
        this.reunion.setCoste((int) costereunion);
        FactoriaBD.posActualizarDato(this.reunion);
        this.reunionfinalizada = true;
        
        
        actaReunionBean acta = new actaReunionBean(this.reunion.getIdreunion());

        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);
        session.setAttribute("actaReunionBean", acta);
        
        return "ok";
    }

    public double costReunion(Date fechainicial, Date fechafinal) {
        double costetotal = 0;
        double costeSala = this.costealquilersala;
        double costeasistentes = 0;

        Calendar fechini = Calendar.getInstance();
        fechini.setTime(fechainicial);

        Calendar fechfin = Calendar.getInstance();
        fechfin.setTime(fechafinal);

        long milsecfin = fechfin.getTimeInMillis();
        long milsecini = fechini.getTimeInMillis();

        long resta = milsecfin - milsecini;

        long difseg = resta / 1000;



        for (Usuarios participantes : this.usuariosasistentesconf) {

            costeasistentes = costeasistentes + calculaSueldoSegundo(participantes) * difseg;

        }
        costetotal = costeSala + costeasistentes;

        return costetotal;
    }

    public double calculaSueldoSegundo(Usuarios usuario) {
        double sueldo = 0;

        BigDecimal sueldomensual = usuario.getSalario();

        sueldo = ((sueldomensual.doubleValue() / 160) / 3600);

        return sueldo;
    }

}
