/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import bd.Reuniones;
import bd.Usuarios;
import beans.EmpresaBean;
import beans.UsuariosBean;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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

    public static String getFormatoFechaHora(Date fecha) {

        String hora = "";
        hora = hora + fecha.getHours() + ":" + fecha.getMinutes() + ":" + fecha.getSeconds();
        return hora;


    }

    public static String creaNombreUsuario(String nombreUsuario, String apellido1Usuario, String apellido2Usuario) {


        String nomUs = "";
        Integer numUs;
        String nombreUs;
        String apellido1Us;
        String apellido2Us;

        List<Usuarios> listUs = new LinkedList<Usuarios>();

        nombreUs = nombreUsuario.substring(0, 3).toLowerCase();
        apellido1Us = apellido1Usuario.substring(0, 3).toLowerCase();
        apellido2Us = apellido2Usuario.substring(0, 3).toLowerCase();


        nomUs = nombreUs + apellido1Us + apellido2Us;


        listUs = Consultas.buscaUsuarioParecidos(nomUs);

        numUs = listUs.size();

        if (numUs > 0) {
            nomUs = nomUs + numUs.toString();
        }

        return nomUs;

    }

    public static String getNifEmpresaSesion() {

        String res;

        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);

        EmpresaBean emp = (EmpresaBean) session.getAttribute("empresa");

        res = emp.getNif();

        return res;
    }

    public static String getDniUsuarioSesion() {

        String res;

        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);

        UsuariosBean usbean = (UsuariosBean) session.getAttribute("usuario");

        res = usbean.getDni();

        return res;
    }

    public static String trasformaListaFechaCadena(List<Reuniones> listaReuniones) {

        String res = "";
        int i = 0;

        for (Reuniones d : listaReuniones) {

            i++;
            Calendar c1 = new GregorianCalendar();
            c1.setTime(d.getFechainicial());
            int formatday = Calendar.DAY_OF_YEAR;
            int dia_ano = c1.get(formatday);

            if (i < listaReuniones.size()) {
                res = res + dia_ano + ",";
            } else {
                res = res + dia_ano;
            }


        }

        return res;
    }

}
