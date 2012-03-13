/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Reuniones;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import utiles.Consultas;
import utiles.Utilidades;

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

    
    /** Creates a new instance of CalendarioUsuarioBean */
    public CalendarioUsuarioBean() {
    }

    public CalendarioUsuarioBean(String dniusuario) {

        this.anio = Calendar.getInstance().get(Calendar.YEAR);

        //Lista de reuniones por el año actual inicialmente
        this.listareuniones = Consultas.buscaReunionesUsuarioAnio(dniusuario, anio);

        //String con los dias del año que tienes reunión
        this.reunionescadena = Utilidades.trasformaListaFechaCadena(this.listareuniones);

        //Primer dia del año que se marcara el el calendario
        this.fecha = new Date(Calendar.getInstance().get(Calendar.YEAR) - 1900, 0, 2);
        //Lista por defecto para elegir el año de las reuniones
        this.listaanios = new Integer[]{Calendar.getInstance().get(Calendar.YEAR),
            Calendar.getInstance().get(Calendar.YEAR) - 1, Calendar.getInstance().get(Calendar.YEAR) + 1};
        
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

}
