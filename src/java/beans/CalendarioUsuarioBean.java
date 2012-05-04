/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Reuniones;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.List;
import utiles.Consultas;
import utiles.Utilidades;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AntonioCamacho
 */
public class CalendarioUsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Reuniones> listareuniones;
    private String reunionescadena;
    private Integer anio;
    private Date fecha;
    private Integer listaanios[];
    private Reuniones reunion;
    private boolean verinformacion;
    private boolean errorinformacion;

    public CalendarioUsuarioBean() {
    }

    public void inicializaCalendarioUsuarioBean() {

        this.fecha = Calendar.getInstance().getTime();
        this.anio = Calendar.getInstance().get(Calendar.YEAR);
        String dniusuario = Utilidades.getDniUsuarioSesion();
        this.listareuniones = Consultas.buscaReunionesUsuarioAnio(dniusuario, anio);
        this.reunionescadena = Utilidades.trasformaListaFechaCadena(this.listareuniones);
        this.listaanios = new Integer[]{Calendar.getInstance().get(Calendar.YEAR),
            Calendar.getInstance().get(Calendar.YEAR) - 1, Calendar.getInstance().get(Calendar.YEAR) + 1};
        //System.out.print(reunionescadena.toString
        System.out.print("Se ha ejecutado inicializaCalendarioUsuarioBean");
        System.out.print("Tamaño lista reuniones" + listareuniones.size());
        this.verinformacion = false;
        this.errorinformacion = false;

    }

    public String getReunionescadena() {
        return reunionescadena;
    }

    public void setReunionescadena(String reunionescadena) {
        this.reunionescadena = reunionescadena;
    }

    public Integer[] getListaanios() {
        return listaanios;
    }

    public void setListaanios(Integer[] listaanios) {
        this.listaanios = listaanios;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public List<Reuniones> getListareuniones() {
        return listareuniones;
    }

    public void setListareuniones(List<Reuniones> listareuniones) {
        this.listareuniones = listareuniones;
    }

    public Reuniones getReunion() {
        return reunion;
    }

    public void setReunion(Reuniones reunion) {
        this.reunion = reunion;
    }

    public boolean isVerinformacion() {
        return verinformacion;
    }

    public void setVerinformacion(boolean verinformacion) {
        this.verinformacion = verinformacion;
    }

    public boolean isErrorinformacion() {
        return errorinformacion;
    }

    public void setErrorinformacion(boolean errorinformacion) {
        this.errorinformacion = errorinformacion;
    }

    public String irAnio() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.YEAR, this.anio);
        setFecha(cal.getTime());
        setListareuniones(Consultas.buscaReunionesUsuarioAnio(Utilidades.getDniUsuarioSesion(), anio));
        setReunionescadena(Utilidades.trasformaListaFechaCadena(this.listareuniones));

        return "ok";

    }

    public String informacionReunion() {

        this.errorinformacion = false;
        this.verinformacion = false;
        String res = null;
        String dniusuario = Utilidades.getDniUsuarioSesion();
        Calendar c1 = Calendar.getInstance();
        c1.setTime(fecha);
        c1.set(Calendar.HOUR_OF_DAY, 0);
        c1.set(Calendar.MINUTE, 0);
        Date d1 = c1.getTime();
        c1.set(Calendar.HOUR_OF_DAY, 23);
        c1.set(Calendar.MINUTE, 59);
        Date d2 = c1.getTime();

        this.reunion = Consultas.buscaReunionesUsuarioInformacion(dniusuario, d1, d2);

        if (this.reunion != null) {
            this.verinformacion = true;
            res = "ok";
            System.out.print("Verificaciones " + this.verinformacion);
            System.out.print("Reunion: " + this.reunion.getFechainicial());
        } else {
            this.errorinformacion = true;
            res = "error";
        }

        return res;
    }

    public String formatoFecha(Date fecha) {
        return Utilidades.getFormatoFecha(fecha) + " " + Utilidades.getFormatoFechaHora(fecha);
    }

    public String calcularDuracionReunion() {
        String minutostr = null;
        Calendar calini = Calendar.getInstance();
        Date fechini = reunion.getFechainicial();
        calini.setTime(fechini);

        Calendar calfin = Calendar.getInstance();
        Date fechfin = this.reunion.getFechafinalestimada();
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

    public boolean isEmpty() {
        boolean res = true;
        boolean a = this.listareuniones == null;
        boolean b = this.reunionescadena == null;
        boolean c = this.anio == null;
        boolean d = this.fecha == null;
        boolean e = this.listaanios == null;
        boolean f = this.reunion == null;

        if (a || b || c || d || e || f) {
            res = false;
        }

        return res;

    }
}
