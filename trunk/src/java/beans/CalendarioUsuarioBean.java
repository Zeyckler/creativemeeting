/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author AntonioCamacho
 */
public class CalendarioUsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Date> listadiasreuniones;
    private String reunionescadena;
    private Integer anio;
    private Date fecha = new Date(Calendar.getInstance().get(Calendar.YEAR) - 1900, 0, 2);
    private Integer listaanios[] = {Calendar.getInstance().get(Calendar.YEAR),
        Calendar.getInstance().get(Calendar.YEAR) - 1, Calendar.getInstance().get(Calendar.YEAR) + 1};
    
    private String fechias = "1,2,3,4,5,6,7,8,9,10";

    /** Creates a new instance of CalendarioUsuarioBean */
    public CalendarioUsuarioBean() {
    }

    public List<Date> getListadiasreuniones() {
        return listadiasreuniones;
    }

    public void setListadiasreuniones(List<Date> listadiasreuniones) {
        this.listadiasreuniones = listadiasreuniones;
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

    public String getFechias() {
        return fechias;
    }

    public void setFechias(String fechias) {
        this.fechias = fechias;
    }
    

    public String irAnio() {

        this.fecha = new Date(anio - 1900, 0, 2);
        setFechias("11,12,13,14,15");
        return "ok";

    }

    public String trasformaListaFechaCadena(List<Date> listaFecha) {

        String res = "";
        int i = 0;

        for (Date d : listaFecha) {

            i++;
            Calendar c1 = new GregorianCalendar();
            c1.setTime(d);
            int formatday = Calendar.DAY_OF_YEAR;
            int dia_ano = c1.get(formatday);

            if (i < listaFecha.size()) {
                res = res + dia_ano + ",";
            } else {
                res = res + dia_ano;
            }


        }

        reunionescadena = res;
        return res;
    }
    
    
}
