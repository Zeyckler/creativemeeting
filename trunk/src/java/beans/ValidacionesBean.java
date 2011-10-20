/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.math.BigDecimal;
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

    public void validarCadena255(FacesContext context, UIComponent validate, Object value) {

        String cad = (String) value;
        boolean tam = true;

        if (cad.length() > 255) {
            tam = false;
        }
        if (!tam) {
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

    public void validarEmail(FacesContext context, UIComponent validate, Object value) {
        String emailEmp = (String) value;
        boolean res = true;
        boolean tam = true;

        if (emailEmp.length() > 255) {
            tam = false;
        }

        Pattern p = Pattern.compile("[a-zA-Z0-9]+[.[a-zA-Z0-9_-]+]*@[a-z0-9][\\w\\.-]*[a-z0-9]\\.[a-z][a-z\\.]*[a-z]$");
        Matcher m = p.matcher(emailEmp);
        res = m.matches();

        if (!res) {

            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Correo electronico no válido");
            context.addMessage(validate.getClientId(context), msg);
        }
        if (!tam) {

            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Tamaño máximo 255 caracteres");
            context.addMessage(validate.getClientId(context), msg);
        }
    }

    public void validarMovil(FacesContext context, UIComponent validate, Object value) {

        boolean res = true;
        String telefonoEmp = String.valueOf((Integer) value);


        Pattern p = Pattern.compile("^[6|7]\\d{8}$");
        Matcher m = p.matcher(telefonoEmp);
        res = m.matches();

        if (!res) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Debe de ser numero Móvil empezado por 6 0 7");
            context.addMessage(validate.getClientId(context), msg);
        }
    }

    public void validarTelefono(FacesContext context, UIComponent validate, Object value) {

        boolean res = true;
        String telefonoEmp = String.valueOf((Integer) value);

        Pattern p = Pattern.compile("^[9]\\d{8}$");
        Matcher m = p.matcher(telefonoEmp);
        res = m.matches();

        if (!res) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Debe de ser numero Fijo empezado por 9");
            context.addMessage(validate.getClientId(context), msg);
        }
    }

    public void validarCodigoPostal(FacesContext context, UIComponent validate, Object value) {

        boolean res = true;
        String cp = String.valueOf((Integer) value);

        Pattern p = Pattern.compile("^\\d{5}$");
        Matcher m = p.matcher(cp);
        res = m.matches();

        if (!res) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Debe ser un número");
            context.addMessage(validate.getClientId(context), msg);
        }
    }

    public void validarSalario(FacesContext context, UIComponent validate, Object value) {

        boolean res = true;
        String cp = String.valueOf((BigDecimal) value);

        Pattern p = Pattern.compile("^([1-9]\\d+)|([1-9]\\d+\\.\\d{2})$");
        Matcher m = p.matcher(cp);
        res = m.matches();

        if (!res) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Debe ser un número");
            context.addMessage(validate.getClientId(context), msg);
        }
    }
}
