/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Empresas;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 *
 * @author Zeyckler
 */
public class UsuariosBean implements Serializable {

    private final static long serialVersionUID = 1L;
    
    private String dni;
    //ValidarNif
    private String nombre;
   //ValidarCadena255
    private String apellido1;
    //ValidarCadena255
    private String apellido2;
    //No es requerido
    private Date fechanacimiento;
    //ValidarFechas ¡¡¡Sin hacer!!!
    private String direccion;
    //ValidarCadena255
    private Integer telefono;
    //validarTelefono
    private Integer movil;
    //validarMovil
    private String email;
    //ValidarEmail
    private String usuario;
    
    private String provincia;
    //ValidarCadena255
    private String contrasena;
    private String localidad;
    private String pais;
    private int codigopostal;
    private String cargo;
    private BigDecimal salario;
    private int privilegios;
    private boolean activo;
    private Empresas nif;
 
    
    
    public UsuariosBean() {
    }
    //Hay que crear un Constructor con una entrada de usuario
    
    
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
        String nifEmp= (String)value; 

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
        if(!res){
            
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("N.I.F no válido");
            context.addMessage(validate.getClientId(context), msg);
            
        }
    }
    
    public void validarTelefono(FacesContext context, UIComponent validate, Object value) {

        boolean res = true;
        String telefonoEmp = (String) value;

        Pattern p = Pattern.compile("^\\d+$");
        Matcher m = p.matcher(telefonoEmp);
        res = m.matches();

        if (!res) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Debe ser un número");
            context.addMessage(validate.getClientId(context), msg);
        }

        if (telefonoEmp.length() > 9) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Tamaño maximo 9 numeros");
            context.addMessage(validate.getClientId(context), msg);
        }


    }
    public void validarMovil(FacesContext context, UIComponent validate, Object value) {
        
        //Este método hay que probarlo no está del todo claro.
        
        boolean res = true;
        String telefonoEmp = (String) value;

        Pattern p = Pattern.compile("^\\[6|9]d+$");
        Matcher m = p.matcher(telefonoEmp);
        res = m.matches();

        if (!res) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Debe ser un número");
            context.addMessage(validate.getClientId(context), msg);
        }

        if (telefonoEmp.length() > 9) {
            ((UIInput) validate).setValid(false);
            FacesMessage msg = new FacesMessage("Tamaño maximo 9 numeros");
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
    
     public void validarFecha(FacesContext context, UIComponent validate, Object value) {
        
        String fecha = (String) value;
        String dia;
        String mes;
        String año;
        
        
         
     }
        
        
        

    
}
