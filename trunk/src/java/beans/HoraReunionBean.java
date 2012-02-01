/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Zeyckler
 */
@ManagedBean
@SessionScoped
public class HoraReunionBean {

    private String horas[] = {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "00", "01", "02", "03", "04", "05", "06", "07"};
    /** Creates a new instance of HoraReunionBean */
    private String minutos[] = {"00", "15", "30", "45"};

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
}
