/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.util.Date;

/**
 *
 * @author Antonio
 */
public class Utilidades {

    public static String getFormatoFecha(Date fecha) {

        String fec = "";

        int dia = fecha.getDate();
        int mes = fecha.getMonth() + 1;
        int año = fecha.getYear() + 1900;
        fec = fec + dia + "-" + mes + "-" + año;

        return fec;
    }

    public static String getFormachoFechaHora(Date fecha) {

        String hora = "";
        hora = hora + fecha.getHours() + ":" + fecha.getMinutes() + ":" + fecha.getSeconds();
        return hora;


    }
}
