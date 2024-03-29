/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Zeyckler
 */
@ManagedBean
@SessionScoped
public class HoraReunionBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String horas[] = {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "00", "01", "02", "03", "04", "05", "06", "07"};
    /** Creates a new instance of HoraReunionBean */
    private String minutos[] = {"00", "15", "30", "45"};
    
    private String duracionhoras[] = {"0","1","2","3","4","5"};
    
    private String duracionminutos[]= {"0", "30"};

    /** Creates a new instance of HoraReunionBean */
    public HoraReunionBean() {
    }

    public String[] getHoras() {
        return horas;
    }

    public void setHoras(String[] horas) {
        this.horas = horas;
    }

    public String[] getMinutos() {
        return minutos;
    }

    public void setMinutos(String[] minutos) {
        this.minutos = minutos;
    }

    public String[] getDuracionhoras() {
        return duracionhoras;
    }

    public void setDuracionhoras(String[] duracionhoras) {
        this.duracionhoras = duracionhoras;
    }

    public String[] getDuracionminutos() {
        return duracionminutos;
    }

    public void setDuracionminutos(String[] duracionminutos) {
        this.duracionminutos = duracionminutos;
    }
    
}
