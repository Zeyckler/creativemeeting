/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 *
 * @author AntonioCamacho
 */
@Stateless
@LocalBean
public class ValidacionesBean {

    public ValidacionesBean() {
    }

    private void validarCadena255(FacesContext context, UIComponent validate, Object value) {
        String cad = (String) value;
        boolean tam = true;

        if (cad.length() > 255) {
            tam = false;
        }
        if (!false) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Tamaño máximo 255 caracteres");
            context.addMessage(validate.getClientId(context), msg);
        }
    }

    public void validarNif(FacesContext context, UIComponent validate, Object value) {

        boolean res = true;
        String nifEmp = (String) value;

        if (nifEmp.toUpperCase().startsWith("X") || nifEmp.toUpperCase().startsWith("Y") || nifEmp.toUpperCase().startsWith("Z")) {
            nifEmp = nifEmp.substring(1);
        }

        Pattern nifPattern =
                Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
        Matcher m = nifPattern.matcher(nifEmp);
        if (m.matches()) {
            String letra = m.group(2);

            //Extraer letra del NIF

            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            int dni = Integer.parseInt(m.group(1));
            dni = dni % 23;
            String reference = letras.substring(dni, dni + 1);

            if (reference.equalsIgnoreCase(letra)) {
                res = true;
            } else {
                res = false;
            }
        } else {
            res = false;
        }
        if (!res) {

            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("N.I.F no válido");
            context.addMessage(validate.getClientId(context), msg);

        }
    }

    public void ValidarFecha(FacesContext context, UIComponent validate, Object value) {
        boolean res = true;
        String fecha = (String) value;
        Integer dia;
        Integer mes;
        Integer anio;
        Pattern p = Pattern.compile("^(((0[1-9]|[12]\\d|3[01])\\/(0[13578]|1[02])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)\\/(0[13456789]|1[012])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])\\/02\\/((19|[2-9]\\d)\\d{2}))|(29\\/02\\/((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$");
        Matcher m = p.matcher(fecha);
        res = m.matches();

        if (res == false) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Formato Fecha dd/mm/aaaa");
            context.addMessage(validate.getClientId(context), msg);
        }
    }
    
}
