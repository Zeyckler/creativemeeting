/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Asistenciareunion;
import bd.Empresas;
import bd.Reuniones;
import bd.Usuarios;
import factoria.FactoriaBD;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import utiles.Consultas;
import utiles.Fila;
import utiles.Utilidades;

/**
 *
 * @author Zeyckler
 */
public class UsuariosBean implements Serializable {

    private final static long serialVersionUID = 1L;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fechanacimiento;
    private String direccion;
    private Integer telefono;
    private Integer movil;
    private String email;
    private String usuario;
    private String provincia;
    private String contrasena;
    private String contrasena2;
    private String localidad;
    private String pais;
    private Integer codigopostal;
    private String cargo;
    private BigDecimal salario;
    private int privilegios;
    private boolean activo;
    private Empresas nif;
    private String niftmp;
    private Reuniones reunionhoy;
    private List<Reuniones> proximasreuniones;
    private boolean datosactualizados;
    private boolean falloinicioreunion;
    private boolean contrasenaactualizada;
    private boolean errorcambiocontrasena;
    private boolean salaanadida;
    private String falloinicioreunionstr;

    public UsuariosBean() {
    }

    public UsuariosBean(Usuarios us) {
        this.activo = us.getActivo();
        this.apellido1 = us.getApellido1();
        this.apellido2 = us.getApellido2();
        this.cargo = us.getCargo();
        this.codigopostal = us.getCodigopostal();
        this.contrasena = us.getContrasena();
        this.contrasena2 = "";
        this.direccion = us.getDireccion();
        this.dni = us.getDni();
        this.email = us.getEmail();
        this.fechanacimiento = us.getFechanacimiento();
        this.localidad = us.getLocalidad();
        this.movil = us.getMovil();
        this.nif = us.getNif();
        this.nombre = us.getNombre();
        this.pais = us.getPais();
        this.privilegios = us.getPrivilegios();
        this.provincia = us.getProvincia();
        this.salario = us.getSalario();
        this.telefono = us.getTelefono();
        this.usuario = us.getUsuario();
        this.datosactualizados = false;
        this.falloinicioreunion = false;
        this.contrasenaactualizada = false;
        this.errorcambiocontrasena = false;
        this.salaanadida = false;

    }

    public void inicializaUsuariosBean() {
        this.reunionhoy = Consultas.buscaReunionesUsuarioInformacionHoy(this.dni);
        this.proximasreuniones = Consultas.buscaProximasReunionesAceptada(this.dni);
        if(this.reunionhoy==null){
            System.out.print("HE entrado aquiiiiiiiiiiiiiiiiiii!!!!!!!");
        }
    }

    public void inicializaMensajes() {
        this.datosactualizados = false;
        this.falloinicioreunion = false;
        this.contrasenaactualizada = false;
        this.errorcambiocontrasena = false;
        this.salaanadida = false;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(Integer codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getContrasena2() {
        return contrasena2;
    }

    public void setContrasena2(String contrasena2) {
        this.contrasena2 = contrasena2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Integer getMovil() {
        return movil;
    }

    public void setMovil(Integer movil) {
        this.movil = movil;
    }

    public Empresas getNif() {
        return nif;
    }

    public void setNif(Empresas nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(int privilegios) {
        this.privilegios = privilegios;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNiftmp() {
        return niftmp;
    }

    public void setNiftmp(String niftmp) {
        this.niftmp = niftmp;
    }

    public List<Reuniones> getProximasreuniones() {
        return proximasreuniones;
    }

    public void setProximasreuniones(List<Reuniones> proximasreuniones) {
        this.proximasreuniones = proximasreuniones;
    }

    public Reuniones getReunionhoy() {
        //if(reunionhoy==null)
        //reunionhoy= Consultas.buscaReunionesUsuarioInformacionHoy(this.dni);
        return reunionhoy;
    }

    public void setReunionhoy(Reuniones reunionhoy) {
        this.reunionhoy = reunionhoy;
    }

    public boolean isFalloinicioreunion() {
        return falloinicioreunion;
    }

    public void setFalloinicioreunion(boolean falloinicioreunion) {
        this.falloinicioreunion = falloinicioreunion;
    }

    public boolean isContrasenaactualizada() {
        return contrasenaactualizada;
    }

    public void setContrasenaactualizada(boolean contrasenaactualizada) {
        this.contrasenaactualizada = contrasenaactualizada;
    }

    public boolean isErrorcambiocontrasena() {
        return errorcambiocontrasena;
    }

    public void setErrorcambiocontrasena(boolean errorcambiocontrasena) {
        this.errorcambiocontrasena = errorcambiocontrasena;
    }

    public boolean isDatosactualizados() {
        return datosactualizados;
    }

    public void setDatosactualizados(boolean datosactualizados) {
        this.datosactualizados = datosactualizados;
    }

    public String getFalloinicioreunionstr() {
        return falloinicioreunionstr;
    }

    public void setFalloinicioreunionstr(String falloinicioreunionstr) {
        this.falloinicioreunionstr = falloinicioreunionstr;
    }

    public boolean isSalaanadida() {
        return salaanadida;
    }

    public void setSalaanadida(boolean salaanadida) {
        this.salaanadida = salaanadida;
    }

    public String formatoFecha(Date fecha) {
        return Utilidades.getFormatoFecha(fecha) + " " + Utilidades.getFormatoFechaHora(fecha);
    }

    public String calcularDuracionReunion() {
        String minutostr = null;
        Calendar calini = Calendar.getInstance();
        Date fechini = this.reunionhoy.getFechainicial();
        calini.setTime(fechini);

        Calendar calfin = Calendar.getInstance();
        Date fechfin = this.reunionhoy.getFechafinalestimada();
        calfin.setTime(fechfin);

        long a = calini.getTimeInMillis();
        long b = calfin.getTimeInMillis();
        long hora = (b - a) / 3600000;
        long restohora = (b - a) % 3600000;
        long minuto = restohora / 60000;

        if (minuto <= 9) {
            minutostr = "0" + minuto;
        } else {
            minutostr = Long.toString(minuto);
        }
        return hora + ":" + minutostr;
    }

    public void creaCalendarioUsuarioBean() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);
        CalendarioUsuarioBean cal = (CalendarioUsuarioBean) session.getAttribute("calendarioUsuarioBean");
        if (cal == null || cal.getFecha() == null) {
            System.out.print("ha entrado aqui");
            CalendarioUsuarioBean calUsBean = new CalendarioUsuarioBean();
            calUsBean.inicializaCalendarioUsuarioBean();
            session.setAttribute("calendarioUsuarioBean", calUsBean);
        }
    }

    public void creaVerNotificacionesAEBean() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);
        VerNotificacionesAEBean verNot = new VerNotificacionesAEBean();
        verNot.inicializaVerNotificacionesAEBean();
        session.setAttribute("verNotificacionesAEBean", verNot);

    }

    public void creaReunionBean() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);
        CreaReunionBean creunion = (CreaReunionBean) session.getAttribute("creaReunionBean");
        if (creunion == null || creunion.getFechaCalendario() == null) {
            System.out.print("He entrado Aqui!!!!!!");
            CreaReunionBean crn = new CreaReunionBean();
            crn.inicializaCreaReunionBean();
            session.setAttribute("creaReunionBean", crn);
        }
    }

    public void retomaReunionBean() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);

        DesarrolloReunionBean desreunion = new DesarrolloReunionBean();
        desreunion.inicializaDesarrolloReunion();
        session.setAttribute("desarrolloReunionBean", desreunion);

    }

    public void creaDesarrolloReunion() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);
        DesarrolloReunionBean desreu = (DesarrolloReunionBean) session.getAttribute("desarrolloReunionBean");
        if (desreu == null || desreu.getReunion() == null) {
            DesarrolloReunionBean desreunion = new DesarrolloReunionBean();
            desreunion.inicializaDesarrolloReunion();
            session.setAttribute("desarrolloReunionBean", desreunion);
        }
    }

    public void creaUsuario() {

        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);
        UsuariosBean us = (UsuariosBean) session.getAttribute("usuario");
        us.inicializaUsuariosBean();
        session.setAttribute("usuario", us);

    }

    public boolean activarBotonComenzarReunion() {

        boolean res = true;
        Calendar fechainicialest = new GregorianCalendar();
        fechainicialest.setTime(this.reunionhoy.getFechainicial());
        Calendar fechafinalest = new GregorianCalendar();
        fechafinalest.setTime(this.reunionhoy.getFechafinalestimada());
        Calendar actual = Calendar.getInstance();

        if (actual.compareTo(fechainicialest) > 0 && actual.compareTo(fechafinalest) < 0) {
            res = false;
        }
        System.out.print("Boton activado: " + res);


        return res;
    }

    public String comenzarReunion() {

        String res = "";
        Calendar c1 = new GregorianCalendar();
        c1.setTime(this.reunionhoy.getFechainicial());
        Calendar c2 = Calendar.getInstance();
        this.falloinicioreunion = false;
        this.falloinicioreunionstr = "";

        if (c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR)) {
            res = "ok";
        } else {
            this.falloinicioreunion = true;
            this.falloinicioreunionstr = "No se puede comenzar la reunión";
            this.creaUsuario();
            res = "error";

        }
        return res;

    }

    public boolean reunionEnProgreso() {
        boolean res;
        if (this.reunionhoy.getFechainicialreal() == null) {
            res = false;
        } else {
            res = true;
        }
        System.out.print("Reunion Comenzada: " + res);
        return res;
    }

    public String retomarDesarrolloReunion() {
        String res = "";

        retomaReunionBean();
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);
        DesarrolloReunionBean desa = (DesarrolloReunionBean) session.getAttribute("desarrolloReunionBean");

        List<Asistenciareunion> asis = this.reunionhoy.getAsistenciareunionCollection();
        List<Usuarios> usuariosconf = new LinkedList<Usuarios>();
        List<Fila<Usuarios>> usuariosconfila = new LinkedList<Fila<Usuarios>>();
        Set<Empresas> empresasesasis = new HashSet<Empresas>();

        for (Asistenciareunion asreu : asis) {
            if (asreu.getAsistencia()) {
                usuariosconf.add(asreu.getDni());
                Fila f1 = new Fila(asreu.getDni(), false);
                usuariosconfila.add(f1);
            }
        }
        for (Usuarios usur : usuariosconf) {

            empresasesasis.add(usur.getNif());

        }
        desa.setUsuariosasistentesconf(usuariosconf);
        desa.setUsuariosasistentesconfila(usuariosconfila);
        desa.setEmpresasasistentes(empresasesasis);

        session.setAttribute("desarrolloReunionBean", desa);
        res = "ok";


        return res;
    }

    public String actualizarDatosUsuario() {
        String res = "";
        this.datosactualizados = false;
        try {
            Usuarios us = Consultas.buscarUsuario(this.dni);
            FactoriaBD.preActualizarDato(us);
            us.setApellido1(this.apellido1);
            us.setApellido2(this.apellido2);
            us.setCargo(this.cargo);
            us.setCodigopostal(this.codigopostal);
            us.setDireccion(this.direccion);
            us.setEmail(this.email);
            us.setFechanacimiento(this.fechanacimiento);
            us.setLocalidad(this.localidad);
            us.setMovil(this.movil);
            us.setNombre(this.nombre);
            us.setPais(this.pais);
            us.setProvincia(this.provincia);
            us.setTelefono(this.telefono);
            FactoriaBD.posActualizarDato(us);
            res = "ok";
            this.datosactualizados = true;
        } catch (Exception e) {
            System.out.println(e.toString());
            res = "error";
        }
        return res;
    }

    public String actualizarContrasena() {
        String res = "";
        this.errorcambiocontrasena = false;
        this.contrasenaactualizada = false;
        try {
            if (this.contrasena.equals(this.contrasena2)) {
                Usuarios us = Consultas.buscarUsuario(this.dni);
                FactoriaBD.preActualizarDato(us);
                us.setContrasena(this.contrasena);
                FactoriaBD.posActualizarDato(us);
                res = "ok";
                this.contrasenaactualizada = true;
            } else {
                this.errorcambiocontrasena = true;
                res = "errorcontrasena";
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            res = "error";
        }
        return res;
    }

    public String volver() {
        return "ok";
    }
}
