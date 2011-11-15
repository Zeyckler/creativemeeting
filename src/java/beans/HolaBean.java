/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.sun.net.httpserver.HttpServer;
import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.spi.http.HttpContext;
import sun.net.www.http.HttpCapture;

/**
 *
 * @author Zeyckler
 */
public class HolaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Date fecha = new Date();
    private String fechias = "1,2,3,4,5,6,7,8,9,10";

    /** Creates a new instance of HolaBean */
    public HolaBean() {
    }

    public void seleccionFechaChange(ValueChangeEvent valueChangeEvent ) {
        
        Date fechanuevovalor = (Date) valueChangeEvent.getNewValue();
        int anonuevo = fechanuevovalor.getYear();
        Date fechaantiguovalor = (Date) valueChangeEvent.getOldValue();
        int anoviejo = fechaantiguovalor.getYear();
        /*FacesContext a = FacesContext.getCurrentInstance();
        Map<Object, Object> mapa = a.getAttributes();
        Set<Object> cosas= mapa.keySet();
        for(Object o: cosas){
            System.out.println(o);
        }*/
        if (anonuevo != anoviejo) {
            System.out.println("SE SUPONE QUE SE HA CAMBIADO EL AÑO");
        } else {
            System.out.println("SOLO HA CAMBIADO EL DIA/MES");
        }
        SelectInputDate arr = (SelectInputDate) valueChangeEvent.getComponent();
        Map<String, Object> rer=arr.getAttributes();
        Set<String> wer= rer.keySet();
        for(String st: wer){
            System.out.println(st);
        }
        setFechias("11,12,13,14,15");
    }
    public void cambioAnio ( ActionEvent ae){
        
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

    public String getFechias() {
        return fechias;
    }

    public void setFechias(String fechias) {
        this.fechias = fechias;
    }
    
    
    
}
