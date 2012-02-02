/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Reuniones;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;
import utiles.Consultas;

/**
 *
 * @author AntonioCamacho
 */
public class CalendarioUsuarioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Reuniones> listareuniones;
    private String reunionescadena;
    private Integer anio;
    private Date fecha;
    private Integer listaanios[];
    private Integer listaanioscreareunion[];
    private String fechias = "1,2,3,4,5,6,7,8,9,10";

    /** Creates a new instance of CalendarioUsuarioBean */
    public CalendarioUsuarioBean() {
    }

    public CalendarioUsuarioBean(String dniusuario) {

        this.anio = Calendar.getInstance().get(Calendar.YEAR);
        //Lista de reuniones por el año actual inicialmente
        this.listareuniones = Consultas.buscaReunionesUsuarioAnio(dniusuario, anio);
        //String con los dias del año que tienes reunión
        this.reunionescadena = this.trasformaListaFechaCadena(this.listareuniones);
        //Primer dia del año que se marcara el el calendario
        this.fecha = new Date(Calendar.getInstance().get(Calendar.YEAR) - 1900, 0, 2);
        //Lista por defecto para elegir el año de las reuniones
        this.listaanios = new Integer[]{Calendar.getInstance().get(Calendar.YEAR),
            Calendar.getInstance().get(Calendar.YEAR) - 1, Calendar.getInstance().get(Calendar.YEAR) + 1};
        this.listaanioscreareunion= new Integer[]{Calendar.getInstance().get(Calendar.YEAR),Calendar.getInstance().get(Calendar.YEAR) + 1};
    }

    public String getReunionescadena() {
        return reunionescadena;
    }

    public void setReunionescadena(String reunionescadena) {
        this.reunionescadena = reunionescadena;
    }

    public Integer[] getListaanios() {
        return listaanios;
    }

    public void setListaanios(Integer[] listaanios) {
        this.listaanios = listaanios;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getFechias() {
        return fechias;
    }

    public void setFechias(String fechias) {
        this.fechias = fechias;
    }

    public List<Reuniones> getListareuniones() {
        return listareuniones;
    }

    public void setListareuniones(List<Reuniones> listareuniones) {
        this.listareuniones = listareuniones;
    }

    public Integer[] getListaanioscreareunion() {
        return listaanioscreareunion;
    }

    public void setListaanioscreareunion(Integer[] listaanioscreareunion) {
        this.listaanioscreareunion = listaanioscreareunion;
    }
    
    

    public String irAnio() {
        
        //Coger el Dni de Usuario para actualizar lista reuniones
        FacesContext ctx = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);
        UsuariosBean usBean = (UsuariosBean) session.getAttribute("usuario");
        String dni = usBean.getDni();

        
        setFecha(new Date(anio - 1900, 0, 2));
        setListareuniones(Consultas.buscaReunionesUsuarioAnio(dni, anio));
        setReunionescadena(trasformaListaFechaCadena(this.listareuniones));
        
        return "ok";

    }

    public String trasformaListaFechaCadena(List<Reuniones> listaReuniones) {

        String res = "";
        int i = 0;

        for (Reuniones d : listaReuniones) {

            i++;
            Calendar c1 = new GregorianCalendar();
            c1.setTime(d.getFecha());
            int formatday = Calendar.DAY_OF_YEAR;
            int dia_ano = c1.get(formatday);

            if (i < listaReuniones.size()) {
                res = res + dia_ano + ",";
            } else {
                res = res + dia_ano;
            }


        }

        reunionescadena = res;
        return res;
    }
}
