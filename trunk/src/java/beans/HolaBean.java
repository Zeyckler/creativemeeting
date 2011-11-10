/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Zeyckler
 */
public class HolaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Date fecha = new Date();

    /** Creates a new instance of HolaBean */
    public HolaBean() {
    }

    public void seleccionFechaChange(ValueChangeEvent valueChangeEvent) {
        Date fechanuevovalor = (Date) valueChangeEvent.getNewValue();
        int anonuevo = fechanuevovalor.getYear();
        Date fechaantiguovalor = (Date) valueChangeEvent.getOldValue();
        int anoviejo = fechaantiguovalor.getYear();
        Set<String> set = valueChangeEvent.getComponent().getAttributes().keySet();
        for (String s : set) {
            System.out.println(s);
        }
        if (anonuevo != anoviejo) {
            System.out.println("SE SUPONE QUE SE HA CAMBIADO EL AÑO");
        } else {
            System.out.println("SOLO HA CAMBIADO EL DIA/MES");
        }
    }

    public void cambioFecha() {
        /* Calendar cal = Calendar.getInstance();
        cal.set(2010, 10, 9);
        this.fecha = cal.getTime();*/
        System.out.println(this.fecha.toGMTString());



    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
