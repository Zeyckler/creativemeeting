/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Adjunto;
import bd.Asistenciareunion;
import bd.Puntosdeldia;
import bd.Salasreuniones;
import bd.Tiporeuniones;
import bd.Usuarios;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPBinding;
import utiles.Consultas;
import utiles.Fila;
import com.icesoft.faces.component.ext.RowSelector;
import com.icesoft.faces.component.ext.RowSelectorEvent;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

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

    /** Creates a new instance of CreaReunionBean */
    public CreaReunionBean() {
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
    public String creaReunionPaso2() {
        
        return "ok";
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

   
}
