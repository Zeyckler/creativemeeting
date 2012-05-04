package beans;

import bd.Asistenciareunion;
import bd.Puntosdeldia;
import bd.Reuniones;
import bd.Salasreuniones;
import bd.Tiporeuniones;
import bd.Usuarios;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import utiles.Consultas;
import utiles.Fila;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import factoria.FactoriaBD;
import javax.faces.context.FacesContext;
import javax.jms.Session;
import javax.servlet.http.HttpSession;
import utiles.Utilidades;

/**
 *
 * @author AntonioCZ
 */
public class CreaReunionBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Date fechaCalendario;
    private List<Reuniones> listareunionescreareunion;
    private String reunionescadenacreareunion;
    private Integer aniocreareunion;
    private Integer listaanioscreareunion[];
    private Date fechainicial;
    private Date fechafinalestimada;
    private Date fechafinalreal;
    private String horastr;
    private String minutosstr;
    private Integer coste;
    private String tipostr;
    private String duracionhorareunion;
    private String duracionminutosreunion;
    private List<Fila<Salasreuniones>> filassalasdisponible;
    private List<Fila<Object[]>> filasempresasamigas;
    private List<Fila<Object[]>> filausuariosdisponibles;
    private List<Salasreuniones> salaSeleccionada;
    private List<Object[]> empresasamigasseleccionadas;
    private List<Object[]> usuariosdisponibleseleccionados;
    private List<String> listapuntosdeldia;
    private int posicion;
    private boolean eliminaUltimoDisabled;
    private boolean agregaNuevoDisabled;
    private boolean errores;
    private boolean errorpaso1;
    private String errorstrpaso1;
    private boolean errorpaso2;
    private String errorstrpaso2;
    private boolean errorusuariovacio;
    private String errorstrusuariovacio;
    private boolean errorfecha;
    private String errorstrfecha;

    {
    }
    

    /** Creates a new instance of CreaReunionBean */
    public CreaReunionBean() {
    }
    public void inicializaCreaReunionBean(){
        listapuntosdeldia = new LinkedList<String>();
        for (int i = 0; i < 10; i++) {
            listapuntosdeldia.add(i, "");
        }
        posicion = 0;
        errores = false;
        eliminaUltimoDisabled = true;
        agregaNuevoDisabled = false;
        filasempresasamigas = new LinkedList<Fila<Object[]>>();
        filassalasdisponible = new LinkedList<Fila<Salasreuniones>>();
        filausuariosdisponibles = new LinkedList<Fila<Object[]>>();
        empresasamigasseleccionadas = new LinkedList<Object[]>();
        salaSeleccionada = new LinkedList<Salasreuniones>();
        usuariosdisponibleseleccionados = new LinkedList<Object[]>();
        errorpaso1 = false;
        errorpaso2 = false;
        errorusuariovacio = false;
        errorfecha = false;
        fechaCalendario = Calendar.getInstance().getTime();
        aniocreareunion = Calendar.getInstance().get(Calendar.YEAR);
        listareunionescreareunion = Consultas.buscaReunionesUsuarioAnio(Utilidades.getDniUsuarioSesion(), aniocreareunion);
        reunionescadenacreareunion = Utilidades.trasformaListaFechaCadena(listareunionescreareunion);
        listaanioscreareunion = new Integer[]{Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.YEAR) + 1};
        
    }

    public boolean isAgregaNuevoDisabled() {
        return agregaNuevoDisabled;
    }

    public void setAgregaNuevoDisabled(boolean agregaNuevoDisabled) {
        this.agregaNuevoDisabled = agregaNuevoDisabled;
    }

    public Integer getCoste() {
        return coste;
    }

    public void setCoste(Integer coste) {
        this.coste = coste;
    }

    public String getDuracionhorareunion() {
        return duracionhorareunion;
    }

    public void setDuracionhorareunion(String duracionhorareunion) {
        this.duracionhorareunion = duracionhorareunion;
    }

    public String getDuracionminutosreunion() {
        return duracionminutosreunion;
    }

    public void setDuracionminutosreunion(String duracionminutosreunion) {
        this.duracionminutosreunion = duracionminutosreunion;
    }

    public boolean isEliminaUltimoDisabled() {
        return eliminaUltimoDisabled;
    }

    public void setEliminaUltimoDisabled(boolean eliminaUltimoDisabled) {
        this.eliminaUltimoDisabled = eliminaUltimoDisabled;
    }

    public boolean isErrores() {
        return errores;
    }

    public void setErrores(boolean errores) {
        this.errores = errores;
    }

    public Date getFechaCalendario() {
        return fechaCalendario;
    }

    public void setFechaCalendario(Date fechaCalendario) {
        this.fechaCalendario = fechaCalendario;
    }

    public Integer getAniocreareunion() {
        return aniocreareunion;
    }

    public void setAniocreareunion(Integer aniocreareunion) {
        this.aniocreareunion = aniocreareunion;
    }

    public Integer[] getListaanioscreareunion() {
        return listaanioscreareunion;
    }

    public void setListaanioscreareunion(Integer[] listaanioscreareunion) {
        this.listaanioscreareunion = listaanioscreareunion;
    }

    public List<Reuniones> getListareunionescreareunion() {
        return listareunionescreareunion;
    }

    public void setListareunionescreareunion(List<Reuniones> listareunionescreareunion) {
        this.listareunionescreareunion = listareunionescreareunion;
    }

    public String getReunionescadenacreareunion() {
        return reunionescadenacreareunion;
    }

    public void setReunionescadenacreareunion(String reunionescadenacreareunion) {
        this.reunionescadenacreareunion = reunionescadenacreareunion;
    }

    public Date getFechafinalestimada() {
        return fechafinalestimada;
    }

    public void setFechafinalestimada(Date fechafinalestimada) {
        this.fechafinalestimada = fechafinalestimada;
    }

    public Date getFechafinalreal() {
        return fechafinalreal;
    }

    public void setFechafinalreal(Date fechafinalreal) {
        this.fechafinalreal = fechafinalreal;
    }

    public Date getFechainicial() {
        return fechainicial;
    }

    public void setFechainicial(Date fechainicial) {
        this.fechainicial = fechainicial;
    }

    public List<Fila<Salasreuniones>> getFilassalasdisponible() {
        return filassalasdisponible;
    }

    public void setFilassalasdisponible(List<Fila<Salasreuniones>> filassalasdisponible) {
        this.filassalasdisponible = filassalasdisponible;
    }

    public String getHorastr() {
        return horastr;
    }

    public void setHorastr(String horastr) {
        this.horastr = horastr;
    }

    public List<String> getListapuntosdeldia() {
        return listapuntosdeldia;
    }

    public void setListapuntosdeldia(List<String> listapuntosdeldia) {
        this.listapuntosdeldia = listapuntosdeldia;
    }

    public String getMinutosstr() {
        return minutosstr;
    }

    public void setMinutosstr(String minutosstr) {
        this.minutosstr = minutosstr;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public List<Salasreuniones> getSalaSeleccionada() {
        return salaSeleccionada;
    }

    public void setSalaSeleccionada(List<Salasreuniones> salaSeleccionada) {
        this.salaSeleccionada = salaSeleccionada;
    }

    public String getTipostr() {
        return tipostr;
    }

    public void setTipostr(String tipostr) {
        this.tipostr = tipostr;
    }

    public List<Fila<Object[]>> getFilasempresasamigas() {
        return filasempresasamigas;
    }

    public void setFilasempresasamigas(List<Fila<Object[]>> filasempresasamigas) {
        this.filasempresasamigas = filasempresasamigas;
    }

    public List<Object[]> getEmpresasamigasseleccionadas() {
        return empresasamigasseleccionadas;
    }

    public void setEmpresasamigasseleccionadas(List<Object[]> empresasamigasseleccionadas) {
        this.empresasamigasseleccionadas = empresasamigasseleccionadas;
    }

    public List<Fila<Object[]>> getFilausuariosdisponibles() {
        return filausuariosdisponibles;
    }

    public void setFilausuariosdisponibles(List<Fila<Object[]>> filausuariosdisponibles) {
        this.filausuariosdisponibles = filausuariosdisponibles;
    }

    public List<Object[]> getUsuariosdisponibleseleccionados() {
        return usuariosdisponibleseleccionados;
    }

    public void setUsuariosdisponibleseleccionados(List<Object[]> usuariosdisponibleseleccionados) {
        this.usuariosdisponibleseleccionados = usuariosdisponibleseleccionados;
    }

    public boolean isErrorpaso1() {
        return errorpaso1;
    }

    public void setErrorpaso1(boolean errorpaso1) {
        this.errorpaso1 = errorpaso1;
    }

    public String getErrorstrpaso1() {
        return errorstrpaso1;
    }

    public void setErrorstrpaso1(String errorstrpaso1) {
        this.errorstrpaso1 = errorstrpaso1;
    }

    public boolean isErrorpaso2() {
        return errorpaso2;
    }

    public void setErrorpaso2(boolean errorpaso2) {
        this.errorpaso2 = errorpaso2;
    }

    public String getErrorstrpaso2() {
        return errorstrpaso2;
    }

    public void setErrorstrpaso2(String errorstrpaso2) {
        this.errorstrpaso2 = errorstrpaso2;
    }

    public String getErrorstrusuariovacio() {
        return errorstrusuariovacio;
    }

    public void setErrorstrusuariovacio(String errorstrusuariovacio) {
        this.errorstrusuariovacio = errorstrusuariovacio;
    }

    public boolean isErrorusuariovacio() {
        return errorusuariovacio;
    }

    public void setErrorusuariovacio(boolean errorusuariovacio) {
        this.errorusuariovacio = errorusuariovacio;
    }

    public boolean isErrorfecha() {
        return errorfecha;
    }

    public void setErrorfecha(boolean errorfecha) {
        this.errorfecha = errorfecha;
    }

    public String getErrorstrfecha() {
        return errorstrfecha;
    }

    public void setErrorstrfecha(String errorstrfecha) {
        this.errorstrfecha = errorstrfecha;
    }

    public void calculaFechasReunion(Date fechareunion, String horareunion, String minutosreunion, String duracionhorareunion, String duracionminutosreunion) {

        int hreunion = Integer.parseInt(horareunion);
        int mreunion = Integer.parseInt(minutosreunion);
        int durhorasreunion = Integer.parseInt(duracionhorareunion);
        int durminutosreunion = Integer.parseInt(duracionminutosreunion);

        if (durhorasreunion <= 0 && durminutosreunion <= 0) {
            this.errorpaso1 = true;
            this.errorstrpaso1 = "La duración de una reunión debe ser al menos de 30 minutos";
        }
        Calendar fechinicialestimada = new GregorianCalendar();
        fechinicialestimada.setTime(fechareunion);
        fechinicialestimada.set(Calendar.HOUR_OF_DAY, hreunion);
        fechinicialestimada.set(Calendar.MINUTE, mreunion);

        Calendar fechfinalestimada = (Calendar) fechinicialestimada.clone();
        fechfinalestimada.add(Calendar.HOUR_OF_DAY, durhorasreunion);
        fechfinalestimada.add(Calendar.MINUTE, durminutosreunion);

        this.fechainicial = fechinicialestimada.getTime();
        this.fechafinalestimada = fechfinalestimada.getTime();

        if (fechinicialestimada.get(Calendar.DAY_OF_YEAR) != fechfinalestimada.get(Calendar.DAY_OF_YEAR)) {
            this.errorpaso1 = true;
            this.errorstrpaso1 = "Una reunión no puede acabar un día distinto al de comienzo";
        }


    }

    public String creaReunionPaso1() {

        String res = null;
        this.errorpaso1 = false;
        this.errorfecha = false;


        calculaFechasReunion(this.fechaCalendario, this.horastr, this.minutosstr, this.duracionhorareunion, this.duracionminutosreunion);

        System.out.print(this.fechainicial);

        Calendar hoy = Calendar.getInstance();
        hoy.setTime(this.fechainicial);

        if (hoy.compareTo(Calendar.getInstance()) < 0) {
            this.errorfecha = true;
            this.errorstrfecha = "No puedes crear una reunión anterior a la fecha actual";
            res = "errorfecha";
        }
        System.out.print(errorfecha + ": " + errorstrpaso1);
        if (!errorfecha || !errorpaso1) {

            Calendar a = new GregorianCalendar();
            a.setTime(fechaCalendario);
            Integer diaanio = a.get(Calendar.DAY_OF_YEAR);
            String dianiostr = Integer.toString(diaanio);

            String[] listadias = this.reunionescadenacreareunion.split(",");
            for (String dia : listadias) {
                if (dia.equals(dianiostr)) {
                    this.errorfecha = true;
                    this.errorstrfecha = "Solo puede tener una reunión al dia";
                    res = "errorfecha";
                }


            }

            /*Calculamos la Lista de Filas de Salas disponibles y de Empresas amigas para mostrarlas en el siguiente paso*/
            this.filassalasdisponible.clear();
            List<Salasreuniones> listasalasdisponibles = Consultas.buscaSalasLibreFecha(this.fechainicial, this.fechafinalestimada);
            for (Salasreuniones salas : listasalasdisponibles) {
                Fila<Salasreuniones> fila = new Fila(salas, false);
                this.filassalasdisponible.add(fila);
            }
            this.filasempresasamigas.clear();
            List<Object[]> empresasamigas = Consultas.buscaempresasAmigas(Utilidades.getNifEmpresaSesion());
            for (Object[] emp : empresasamigas) {

                Fila<Object[]> fila2 = new Fila(emp, false);
                this.filasempresasamigas.add(fila2);
            }


            if (this.filassalasdisponible.isEmpty()) {

                res = "salasnodisponibles";

            } else if (this.filasempresasamigas.isEmpty()) {

                res = "empresasamigasnodisponibles";

            }

        }
        if (this.errorpaso1) {
            res = "errorpaso1";
        } else if (this.errorfecha) {
            res = "errorpaso1";
        } else {

            res = "ok";
        }
        return res;

    }

    public String creaReunionPaso2() {
        String res = null;
        this.errorpaso2 = false;
        this.errores = false;

        if (this.salaSeleccionada.isEmpty()) {
            this.errorpaso2 = true;
            this.errorstrpaso2 = "Debes seleccionar obligatoriamente una sala de reunión";
            res = "salanoseleccionada";
        } else {
            List<Object[]> listusuariosdisp = Consultas.buscaUsuariosDisponibleReunion(this.fechainicial, Utilidades.getNifEmpresaSesion());

            if (!this.empresasamigasseleccionadas.isEmpty()) {

                for (Object[] empresas : empresasamigasseleccionadas) {

                    String nifemp = (String) empresas[0];
                    listusuariosdisp.addAll(Consultas.buscaUsuariosDisponibleReunion(this.fechainicial, nifemp));

                }

            }
            this.filausuariosdisponibles.clear();
            for (Object[] usuarios : listusuariosdisp) {


                Fila f = new Fila<Object[]>(usuarios, false);

                this.filausuariosdisponibles.add(f);

            }
            System.out.print(this.filausuariosdisponibles.size());
            res = "ok";
        }

        return res;
    }

    public String creaReunionFinal() {

        String res = null;
        this.errores = false;
        this.errorusuariovacio = false;

        for (int i = 0; i <= this.posicion; i++) {
            String puntodia = this.listapuntosdeldia.get(i);
            if (puntodia.equals("")) {
                this.errores = true;
                res = "puntosdiavacio";
            }

        }

        if (!this.errores) {
            if (this.usuariosdisponibleseleccionados.size() > this.salaSeleccionada.get(0).getCapacidad()) {
                res = "overbooking";
            } else {
                if (usuariosdisponibleseleccionados.size() <= 0) {
                    res = "usuariosvacio";
                    this.errorusuariovacio = true;
                    this.errorstrusuariovacio = "Debe seleccionar al menos un usuario";
                    //hacer error en la pagina y redirigir el face config        
                } else {
                    Salasreuniones idsalareunion1 = salaSeleccionada.get(0);
                    Tiporeuniones idtipo1 = FactoriaBD.creaTiporeuniones(new Integer(2));
                    Usuarios dnicreador1 = FactoriaBD.creaUsuario(Utilidades.getDniUsuarioSesion());

                    Reuniones reunion = FactoriaBD.creaReuniones(this.fechainicial, this.fechafinalestimada, idtipo1, idsalareunion1, dnicreador1);

                    //boolean a = FactoriaBD.insertaReuniones(reunion);

                    List<Puntosdeldia> puntosdia = new LinkedList<Puntosdeldia>();

                    for (int i = 0; i <= this.posicion; i++) {

                        String pd = this.listapuntosdeldia.get(i);
                        Puntosdeldia puntod = FactoriaBD.creaPuntosdeldia(pd, reunion);
                        puntosdia.add(puntod);
                    }
                    reunion.setPuntosdeldiaCollection(puntosdia);
                    //boolean b = FactoriaBD.insertaListaPuntosdelDia(puntosdia);

                    List<Asistenciareunion> asistenciareunion = new LinkedList<Asistenciareunion>();

                    Asistenciareunion asitenciacreador = FactoriaBD.creaAsistenciareunion(reunion, dnicreador1);
                    asitenciacreador.setNotificacion(false);
                    asitenciacreador.setRespuesta(true);              
                    asistenciareunion.add(asitenciacreador);

                    for (Object[] usuariosd : this.usuariosdisponibleseleccionados) {

                        Usuarios us = FactoriaBD.creaUsuario((String) usuariosd[0]);
                        Asistenciareunion asistencia = FactoriaBD.creaAsistenciareunion(reunion, us);
                        asistenciareunion.add(asistencia);
                    }

                    //boolean c = FactoriaBD.insertaListaAsistenciareunion(asistenciareunion);
                    reunion.setAsistenciareunionCollection(asistenciareunion);

                    boolean a = FactoriaBD.insertaReuniones(reunion);

                    System.out.print(a);
                    res = "ok";


                    FacesContext ctx = FacesContext.getCurrentInstance();
                    HttpSession session = (HttpSession) ctx.getExternalContext().getSession(true);
                    session.removeAttribute("creaReunionBean");
                    session.removeAttribute("calendarioUsuarioBean");

                    //setListareunionescreareunion(Consultas.buscaReunionesUsuarioAnio(Utilidades.getDniUsuarioSesion(), this.aniocreareunion));
                    //setReunionescadenacreareunion(Utilidades.trasformaListaFechaCadena(listareunionescreareunion));



                }

            }

        }
        return res;


    }

    public void filaSeleccionadaListener(RowSelectorEvent event) {

        this.salaSeleccionada.clear();
        Integer numerofilas = filassalasdisponible.size();

        for (int i = 0, max = numerofilas; i < max; i++) {

            Fila<Salasreuniones> fila = filassalasdisponible.get(i);
            if (fila.isSeleccionada()) {
                this.salaSeleccionada.add(fila.getTipo());
            }

        }

    }

    public void filaSeleccionadaEmpresasAmigasListener(RowSelectorEvent event) {

        this.empresasamigasseleccionadas.clear();
        Integer numerofilas = filasempresasamigas.size();

        for (int i = 0, max = numerofilas; i < max; i++) {

            Fila<Object[]> fila = filasempresasamigas.get(i);
            if (fila.isSeleccionada()) {
                this.empresasamigasseleccionadas.add(fila.getTipo());
            }

        }

    }

    public void usuarioSeleccionadaListener(RowSelectorEvent event) {

        this.usuariosdisponibleseleccionados.clear();
        Integer numerofilas = filausuariosdisponibles.size();

        for (int i = 0, max = numerofilas; i < max; i++) {

            Fila<Object[]> fila = filausuariosdisponibles.get(i);
            if (fila.isSeleccionada()) {
                this.usuariosdisponibleseleccionados.add(fila.getTipo());
            }

        }

    }

    public String creaReunionPaso2Anterior() {
        return "ok";
    }

    public String creaReunionPaso3Anterior() {

        filassalasdisponible.clear();
        salaSeleccionada.clear();
        List<Salasreuniones> listasalasdisponibles = Consultas.buscaSalasLibreFecha(this.fechainicial, this.fechafinalestimada);
        for (Salasreuniones salas : listasalasdisponibles) {
            Fila<Salasreuniones> fila = new Fila(salas, false);
            this.filassalasdisponible.add(fila);
        }

        return "ok";
    }

    public String agregarNuevo() {

        this.errores = false;
        for (int i = 0; i <= this.posicion; i++) {
            String puntodia = this.listapuntosdeldia.get(i);
            if (puntodia.equals("")) {
                this.errores = true;
            }

        }
        if (!this.errores) {

            if (this.posicion < 9) {

                this.posicion++;

                if (this.getPosicion() > 8) {
                    this.setAgregaNuevoDisabled(true);
                }
                if (this.getPosicion() > 0) {
                    this.setEliminaUltimoDisabled(false);
                }

            }
        }
        return "ok";

    }

    public String eliminaUltimo() {


        if (this.listapuntosdeldia.get(this.posicion).equals("")) {
            this.listapuntosdeldia.set(this.posicion, " ");
        }
        if (this.posicion > 0) {
            this.listapuntosdeldia.set(posicion, "");

            this.posicion--;
            if (this.posicion == 0) {
                this.setEliminaUltimoDisabled(true);
            }
            if (this.posicion < 9) {
                this.setAgregaNuevoDisabled(false);
            }
        }
        return "ok";
    }

    public String irAnioCreaReunion() {

        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.YEAR, this.aniocreareunion);
        this.fechaCalendario = cal.getTime();

        this.listareunionescreareunion.clear();
        setListareunionescreareunion(Consultas.buscaReunionesUsuarioAnio(Utilidades.getDniUsuarioSesion(), this.aniocreareunion));
        setReunionescadenacreareunion(Utilidades.trasformaListaFechaCadena(listareunionescreareunion));

        return "ok";

    }
}
