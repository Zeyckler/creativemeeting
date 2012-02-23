/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Asistenciareunion;
import bd.Puntosdeldia;
import bd.Salasreuniones;
import bd.Tiporeuniones;
import bd.Usuarios;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpSession;
import utiles.Consultas;
import utiles.Fila;
import com.icesoft.faces.component.ext.RowSelectorEvent;

import javax.faces.context.FacesContext;

/**
 *
 * @author AntonioCZ
 */
public class CreaReunionBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Date fechaCalendario = Calendar.getInstance().getTime();
    private Date fechainicial;
    private Date fechafinalestimada;
    private Date fechafinalreal;
    private String horastr;
    private String minutosstr;
    private Integer coste;
    private Collection<Puntosdeldia> puntosdeldiaCollection;
    private Collection<Asistenciareunion> asistenciareunionCollection;
    private Tiporeuniones idtipo;
    private String tipostr;
    private Salasreuniones idsalareunion;
    private String duracionhorareunion;
    private String duracionminutosreunion;
    private Usuarios dnicreador;
    private List<Fila<Salasreuniones>> filassalasdisponible;
    private List<Salasreuniones> salaSeleccionada = new LinkedList<Salasreuniones>();
    private LinkedList<String> listapuntosdeldia;
    private LinkedList<String> display;
    int posicion;
    boolean eliminaUltimoDisabled = true;
    boolean agregaNuevoDisabled = false;

    {
        listapuntosdeldia = new LinkedList<String>();
        for (int i = 0; i < 10; i++) {
            listapuntosdeldia.add(i, "");
        }
        posicion = 0;
    }

    /** Creates a new instance of CreaReunionBean */
    public CreaReunionBean() {
        listapuntosdeldia = new LinkedList<String>();
        for (int i = 0; i < 10; i++) {
            listapuntosdeldia.add(i, "");
        }
    }

    public Date getFechafinalestimada() {
        return fechafinalestimada;
    }

    public void setFechafinalestimada(Date fechafinalestimada) {
        this.fechafinalestimada = fechafinalestimada;
    }

    public Date getFechafinalreal() {
        return fechafinalreal;
    }

    public void setFechafinalreal(Date fechafinalreal) {
        this.fechafinalreal = fechafinalreal;
    }

    public Date getFechainicial() {
        return fechainicial;
    }

    public void setFechainicial(Date fechainicial) {
        this.fechainicial = fechainicial;
    }

    public Collection<Asistenciareunion> getAsistenciareunionCollection() {
        return asistenciareunionCollection;
    }

    public void setAsistenciareunionCollection(Collection<Asistenciareunion> asistenciareunionCollection) {
        this.asistenciareunionCollection = asistenciareunionCollection;
    }

    public Integer getCoste() {
        return coste;
    }

    public void setCoste(Integer coste) {
        this.coste = coste;
    }

    public Salasreuniones getIdsalareunion() {
        return idsalareunion;
    }

    public void setIdsalareunion(Salasreuniones idsalareunion) {
        this.idsalareunion = idsalareunion;
    }

    public Tiporeuniones getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Tiporeuniones idtipo) {
        this.idtipo = idtipo;
    }

    public Collection<Puntosdeldia> getPuntosdeldiaCollection() {
        return puntosdeldiaCollection;
    }

    public void setPuntosdeldiaCollection(Collection<Puntosdeldia> puntosdeldiaCollection) {
        this.puntosdeldiaCollection = puntosdeldiaCollection;
    }

    public String getTipostr() {
        return tipostr;
    }

    public void setTipostr(String tipostr) {
        this.tipostr = tipostr;
    }

    public String getHorastr() {
        return horastr;
    }

    public void setHorastr(String horastr) {
        this.horastr = horastr;
    }

    public String getMinutosstr() {
        return minutosstr;
    }

    public void setMinutosstr(String minutosstr) {
        this.minutosstr = minutosstr;
    }

    public String getDuracionhorareunion() {
        return duracionhorareunion;
    }

    public void setDuracionhorareunion(String duracionhorareunion) {
        this.duracionhorareunion = duracionhorareunion;
    }

    public String getDuracionminutosreunion() {
        return duracionminutosreunion;
    }

    public void setDuracionminutosreunion(String duracionminutosreunion) {
        this.duracionminutosreunion = duracionminutosreunion;
    }

    public Usuarios getDnicreador() {
        return dnicreador;
    }

    public void setDnicreador(Usuarios dnicreador) {
        this.dnicreador = dnicreador;
    }

    public List<Fila<Salasreuniones>> getFilassalasdisponible() {
        return filassalasdisponible;
    }

    public void setFilassalasdisponible(List<Fila<Salasreuniones>> filassalasdisponible) {
        this.filassalasdisponible = filassalasdisponible;
    }

    public Date getFechaCalendario() {
        return fechaCalendario;
    }

    public void setFechaCalendario(Date fechaCalendario) {
        this.fechaCalendario = fechaCalendario;
    }

    public List<Salasreuniones> getSalaSeleccionada() {
        return salaSeleccionada;
    }

    public void setSalaSeleccionada(List<Salasreuniones> salaSeleccionada) {
        this.salaSeleccionada = salaSeleccionada;
    }

    public LinkedList<String> getlistapuntosdeldia() {
        return listapuntosdeldia;
    }

    public void setlistapuntosdeldia(LinkedList<String> listapuntosdeldia) {
        this.listapuntosdeldia = listapuntosdeldia;
    }

    public LinkedList<String> getListapuntosdeldia() {
        return listapuntosdeldia;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public boolean isAgregaNuevoDisabled() {
        return agregaNuevoDisabled;
    }

    public void setAgregaNuevoDisabled(boolean agregaNuevoDisabled) {
        this.agregaNuevoDisabled = agregaNuevoDisabled;
    }

    public boolean isEliminaUltimoDisabled() {
        return eliminaUltimoDisabled;
    }

    public void setEliminaUltimoDisabled(boolean eliminaUltimoDisabled) {
        this.eliminaUltimoDisabled = eliminaUltimoDisabled;
    }

    public LinkedList<String> getDisplay() {
        return display;
    }

    public void setDisplay(LinkedList<String> display) {
        this.display = display;
    }

    public String creaReunionPaso2Anterior() {
        return "ok";
    }

    public String creaReunionPaso2() {

        return "ok";
    }

    public void calculaFechasReunion(Date fechareunion, String horareunion, String minutosreunion, String duracionhorareunion, String duracionminutosreunion) {

        int hreunion = Integer.parseInt(horareunion);
        int mreunion = Integer.parseInt(minutosreunion);
        int durhorasreunion = Integer.parseInt(duracionhorareunion);
        int durminutosreunion = Integer.parseInt(duracionminutosreunion);

        Calendar fechinicialestimada = new GregorianCalendar();
        fechinicialestimada.setTime(fechareunion);
        fechinicialestimada.set(Calendar.HOUR_OF_DAY, hreunion);
        fechinicialestimada.set(Calendar.MINUTE, mreunion);

        Calendar fechfinalestimada = fechinicialestimada;
        fechfinalestimada.add(Calendar.HOUR_OF_DAY, durhorasreunion);
        fechfinalestimada.add(Calendar.MINUTE, durminutosreunion);

        this.fechainicial = fechinicialestimada.getTime();
        this.fechafinalestimada = fechfinalestimada.getTime();

    }

    public String creaReunionPaso1() {

        String res = null;

        /* Cogemos la sesión actual*/
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);

        /* Cogemos el creaReunionBean de la sesión*/
        CreaReunionBean creareunion = (CreaReunionBean) session.getAttribute("creaReunionBean");

        /* Calculamos las fechas iniciales y finales de la reunion*/
        calculaFechasReunion(this.fechaCalendario, this.horastr, this.minutosstr, this.duracionhorareunion, this.duracionminutosreunion);

        creareunion.setFechainicial(this.fechainicial);
        creareunion.setFechafinalestimada(this.fechafinalestimada);

        /*Calculamos la Lista de Filas de Salas disponibles para mostrarlas en el siguiente paso*/
        List<Salasreuniones> listasalasdisponibles = Consultas.buscaSalasLibreFecha(this.fechainicial, this.fechafinalestimada);
        List<Fila<Salasreuniones>> filassalasd = new LinkedList<Fila<Salasreuniones>>();

        for (Salasreuniones salas : listasalasdisponibles) {
            Fila<Salasreuniones> fila = new Fila(salas, false);
            filassalasd.add(fila);
        }
        this.filassalasdisponible = filassalasd;
        creareunion.setFilassalasdisponible(this.filassalasdisponible);

        if (filassalasd.isEmpty()) {

            res = "salasnodisponibles";

        } else {

            /*Asignamos los valores calculados a la sesión*/

            creareunion.setFechainicial(this.fechainicial);
            creareunion.setFechafinalestimada(this.fechafinalestimada);
            creareunion.setFilassalasdisponible(this.filassalasdisponible);

            session.setAttribute("creaReunionBean", creareunion);



            res = "ok";

        }
        System.out.print(res);
        System.out.print(filassalasdisponible.size());

        return res;

    }

    public void filaSeleccionadaListener(RowSelectorEvent event) {

        this.salaSeleccionada.clear();
        Integer numerofilas = filassalasdisponible.size();

        for (int i = 0, max = numerofilas; i < max; i++) {

            Fila<Salasreuniones> fila = filassalasdisponible.get(i);
            if (fila.isSeleccionada()) {
                this.salaSeleccionada.add(fila.getTipo());
            }

        }

    }

    public String agregarNuevo() {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        CreaReunionBean a = (CreaReunionBean) session.getAttribute("creaReunionBean");

        if (this.posicion < 9) {

            this.posicion++;


            //a.setPosicion(a.posicion + 1);


            if (this.getPosicion() > 8) {
                this.setAgregaNuevoDisabled(true);
            }
            if (this.getPosicion() > 0) {
                this.setEliminaUltimoDisabled(false);
            }

        }
        System.out.println(a.getPosicion());
        System.out.println("Sesion: "+ a.getPosicion());
       


        return "ok";

    }

    public String eliminaUltimo() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        CreaReunionBean a = (CreaReunionBean) session.getAttribute("creaReunionBean");


        if (a.posicion > 0) {
            a.listapuntosdeldia.set(posicion, "");

            a.posicion--;
            if (a.posicion == 0) {
                a.setEliminaUltimoDisabled(true);
            }
            if (a.posicion < 9) {
                a.setAgregaNuevoDisabled(false);
            }
        }
        session.setAttribute("creaReunionBean", a);

        return "ok";
    }

    public void contenidoLista() {
        System.out.println("\n======\nDebug\n======");
        System.out.println("Posicion: " + getPosicion());
        for (String a : listapuntosdeldia) {
            System.out.println(a);
        }
    }
}
