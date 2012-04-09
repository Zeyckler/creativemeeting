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
    private Reuniones reunion;
    private boolean verinformacion;
    
    {
        this.anio = Calendar.getInstance().get(Calendar.YEAR);
        String dniusuario= Utilidades.getDniUsuarioSesion();
        this.listareuniones = Consultas.buscaReunionesUsuarioAnio(dniusuario, anio);
        this.reunionescadena = Utilidades.trasformaListaFechaCadena(this.listareuniones);
        this.fecha =Calendar.getInstance().getTime();
        this.listaanios = new Integer[]{Calendar.getInstance().get(Calendar.YEAR),
            Calendar.getInstance().get(Calendar.YEAR) - 1, Calendar.getInstance().get(Calendar.YEAR) + 1};
        System.out.print(reunionescadena.toString());
        System.out.print("Tamaño lista reuniones"+ listareuniones.size());
        this.verinformacion=false;
    }
    
    public CalendarioUsuarioBean() {
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
    public String informacionReunion(){
        
        this.verinformacion=false;
        String res=null;
        String dniusuario= Utilidades.getDniUsuarioSesion();
        Calendar c1 =Calendar.getInstance();
        c1.setTime(fecha);
        c1.set(Calendar.HOUR_OF_DAY, 0);
        c1.set(Calendar.MINUTE, 0);
        Date d1 = c1.getTime();
        c1.set(Calendar.HOUR_OF_DAY, 23);
        c1.set(Calendar.MINUTE, 59);
        Date d2 = c1.getTime();
        
        this.reunion = Consultas.buscaReunionesUsuarioInformacion(dniusuario, d1, d2);
        
        if(this.reunion!=null){
            this.verinformacion=true;
            res="ok";
        }else{
            res="error";
        }
        System.out.print("Verificaciones " + this.verinformacion);
        System.out.print("Reunion: " + this.reunion.getFechainicial());
        return res;
    }
    public String formatoFecha(Date fecha) {
        return Utilidades.getFormatoFecha(fecha) + " " + Utilidades.getFormatoFechaHora(fecha);
    }

}
