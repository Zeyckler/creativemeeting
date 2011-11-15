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

/**
 *
 * @author AntonioCamacho
 */
public class CalendarioUsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    List<Date> listadiasreuniones;
    String  reunionescadena;
    
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
    
    public  String trasformaListaFechaCadena(List<Date> listaFecha){
        
        String res="";
        int i = 0;
        
        for(Date d: listaFecha){
            
            i++;
            Calendar c1= new GregorianCalendar();
            c1.setTime(d);
            int formatday= Calendar.DAY_OF_YEAR;
            int dia_ano= c1.get(formatday);
            
            if(i<listaFecha.size()){
                res= res+dia_ano+",";
            }
            else{
                res= res+dia_ano;
            }
            
            
        }
        
        reunionescadena= res;
        return res;
    }
    
    
    
    
    
    
}
