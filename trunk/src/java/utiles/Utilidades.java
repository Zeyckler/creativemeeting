/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import bd.Reuniones;
import bd.Usuarios;
import beans.EmpresaBean;
import beans.UsuariosBean;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
        String hora = "", min = "";
        if (fecha.getHours() <= 9) {
            hora = "0" + fecha.getHours();
        }
        if (fecha.getMinutes() <= 9) {
            min = "0" + fecha.getMinutes();
        }

        return hora + ":" + min;


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

        String res = null;

        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);

        UsuariosBean usbean = (UsuariosBean) session.getAttribute("usuario");

        if (usbean != null) {
            res = usbean.getDni();
        }

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

    private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }
    /*Ejemplo de uso de SHA1
    String stringsha1 = Utilidades.SHA1("ContrasenaACodificar");
     */

    public static String SHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md;
        md = MessageDigest.getInstance("SHA-1");
        byte[] sha1hash = new byte[40];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        sha1hash = md.digest();
        return convertToHex(sha1hash);
    }
}
