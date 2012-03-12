/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Asistenciareunion;
import bd.Puntosdeldia;
import bd.Reuniones;
import bd.Salasreuniones;
import bd.Tiporeuniones;
import bd.Usuarios;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpSession;
import utiles.Consultas;
import utiles.Fila;
import com.icesoft.faces.component.ext.RowSelectorEvent;

import factoria.FactoriaBD;
import java.awt.BufferCapabilities.FlipContents;
import javax.faces.context.FacesContext;
import javax.jms.Session;
import utiles.Utilidades;

/**
 *
 * @author AntonioCZ
 */
public class CreaReunionBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Date fechaCalendario = Calendar.getInstance().getTime();
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
    private Collection<Puntosdeldia> puntosdeldiaCollection;
    private Collection<Asistenciareunion> asistenciareunionCollection;
    private Tiporeuniones idtipo;
    private Salasreuniones idsalareunion;
    private Usuarios dnicreador;

    {
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


    }

    /** Creates a new instance of CreaReunionBean */
    public CreaReunionBean() {
        listapuntosdeldia = new LinkedList<String>();
        for (int i = 0; i < 10; i++) {
            listapuntosdeldia.add(i, "");
        }
    }

    public boolean isAgregaNuevoDisabled() {
        return agregaNuevoDisabled;
    }

    public void setAgregaNuevoDisabled(boolean agregaNuevoDisabled) {
        this.agregaNuevoDisabled = agregaNuevoDisabled;
    }

    public Collection<Asistenciareunion> getAsistenciareunionCollection() {
        return asistenciareunionCollection;
    }

    public void setAsistenciareunionCollection(Collection<Asistenciareunion> asistenciareunionCollection) {
        this.asistenciareunionCollection = asistenciareunionCollection;
    }

    public Integer getCoste() {
        return coste;
    }

    public void setCoste(Integer coste) {
        this.coste = coste;
    }

    public Usuarios getDnicreador() {
        return dnicreador;
    }

    public void setDnicreador(Usuarios dnicreador) {
        this.dnicreador = dnicreador;
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

    public Salasreuniones getIdsalareunion() {
        return idsalareunion;
    }

    public void setIdsalareunion(Salasreuniones idsalareunion) {
        this.idsalareunion = idsalareunion;
    }

    public Tiporeuniones getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Tiporeuniones idtipo) {
        this.idtipo = idtipo;
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

    public Collection<Puntosdeldia> getPuntosdeldiaCollection() {
        return puntosdeldiaCollection;
    }

    public void setPuntosdeldiaCollection(Collection<Puntosdeldia> puntosdeldiaCollection) {
        this.puntosdeldiaCollection = puntosdeldiaCollection;
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

    public void calculaFechasReunion(Date fechareunion, String horareunion, String minutosreunion, String duracionhorareunion, String duracionminutosreunion) {

        int hreunion = Integer.parseInt(horareunion);
        int mreunion = Integer.parseInt(minutosreunion);
        int durhorasreunion = Integer.parseInt(duracionhorareunion);
        int durminutosreunion = Integer.parseInt(duracionminutosreunion);

        if (durhorasreunion <= 0 && durminutosreunion <= 0) {
            this.errorpaso1 = true;
            this.errorstrpaso1 = "La duración de una reunión debe ser al menos de 30 minutos";
        } else {
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

    }

    public String creaReunionPaso1() {

        String res = null;
        this.errorpaso1 = false;

        /* Calculamos las fechas iniciales y finales de la reunion*/
        calculaFechasReunion(this.fechaCalendario, this.horastr, this.minutosstr, this.duracionhorareunion, this.duracionminutosreunion);


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

        } else if (this.errorpaso1) {
            res = "errorpaso1";
        } else {

            res = "ok";

        }
        System.out.println("Fecha inicial: " + this.fechainicial);
        System.out.println("Fecha final estimada: " + this.fechafinalestimada);

        return res;

    }

    public String creaReunionPaso2() {
        String res = null;
        this.errorpaso2 = false;
        this.errores=false;

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


                Salasreuniones idsalareunion1 = salaSeleccionada.get(0);
                Tiporeuniones idtipo1 = FactoriaBD.creaTiporeuniones(new Integer(2));
                Usuarios dnicreador1 = FactoriaBD.creaUsuario(Utilidades.getDniUsuarioSesion());




                Reuniones reunion = FactoriaBD.creaReuniones(this.fechainicial, this.fechafinalestimada, idtipo1, idsalareunion1, dnicreador1);
                
                System.out.println("Dni Usuario Sesion" + dnicreador1.getDni());
                System.out.println("Sala Seleccionada" + idsalareunion1.getCodigopostal() + "  " + idsalareunion1.getIdsalareunion() + idsalareunion1.getNombresala());
                System.out.println("Id tipo reunion: " + idtipo1.getIdtipo());
                System.out.println("Fecha Inicial: " + this.fechainicial);
                System.out.println("Fecha Final: " + this.fechafinalestimada);
                boolean a = FactoriaBD.insertaReuniones(reunion);
                System.out.print(a);
                res = "ok";




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
            System.out.print("Tamño de la salas seleccionadas" + this.salaSeleccionada.size());

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
}
