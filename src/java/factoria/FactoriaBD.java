/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria;

/**
 *
 * @author Zeyckler
 */
import bd.Adjunto;
import bd.Asistenciareunion;
import bd.Empresas;
import bd.Empresasamigas;
import bd.Intervenciones;
import bd.Puntosdeldia;
import bd.Reuniones;
import bd.Salasreuniones;
import bd.Tiporeuniones;
import bd.Usuarios;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoriaBD {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    private static void abrirTransaccion() {
        emf = Persistence.createEntityManagerFactory("CreativeMPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    private static void terminarTransaccion() {
        em.flush();
        em.close();
        emf.close();
    }

    public static Adjunto creaAdjunto(Integer idadjunto, String rutaarchivo,
            Reuniones idreunion) {

        return new Adjunto(idadjunto, rutaarchivo, idreunion);
    }

    public static boolean insertaAdjunto(Adjunto adj) {

        boolean res = true;

        try {
            abrirTransaccion();
            em.persist(adj);
            terminarTransaccion();
        } catch (Exception e) {
            res = false;
        }
        return res;
    }

    public static Empresas creaEmpresa(String nif, int telefono, String razonsocial,
            String direccion, String email, String localidad, String provincia,
            String pais, int codigopostal, String web, String logotipo, Integer fax) {

        return new Empresas(nif, telefono, razonsocial, direccion, email,
                localidad, provincia, pais, codigopostal, web, logotipo, fax);
    }

    public static Empresas creaEmpresa(String nif) {

        return new Empresas(nif);

    }

    public static boolean insertaEmpresa(Empresas emp) {
        EntityManagerFactory emf1;
        EntityManager em1;

        boolean res = true;

        try {
            emf1 = Persistence.createEntityManagerFactory("CreativeMPU");
            em1 = emf1.createEntityManager();
            em1.getTransaction().begin();
            em1.persist(emp);
            em1.flush();
            em1.close();
            emf1.close();

        } catch (Exception e) {
            res = false;
        }
        return res;
    }

    public static Usuarios creaUsuario(String dni, String nombre, String apellido1, String apellido2,
            Date fechanacimiento, String direccion, Integer telefono, Integer movil,
            String email, String usuario, String contrasena, String localidad,
            String provincia, String pais, int codigopostal, String cargo, BigDecimal salario,
            int privilegios, boolean activo, Empresas nif) {

        return new Usuarios(dni, nombre, apellido1, apellido2,
                fechanacimiento, direccion, telefono, movil,
                email, usuario, contrasena, localidad,
                provincia, pais, codigopostal, cargo, salario,
                privilegios, activo, nif);
    }

    public static Usuarios creaUsuario(String dni) {
        return new Usuarios(dni);

    }

    public static boolean insertaUsuario(Usuarios us) {

        boolean res = true;

        try {
            abrirTransaccion();
            em.persist(us);
            terminarTransaccion();
        } catch (Exception e) {
            res = false;
            System.out.println("EXCEPCION - " + e.toString());
        }
        return res;
    }

    public static boolean preActualizarDato(Object o) {

        boolean res = true;

        try {
            abrirTransaccion();
            em.detach(o);
        } catch (Exception e) {
            res = false;
        }
        return res;
    }

    public static boolean posActualizarDato(Object o) {

        boolean res = true;

        try {
            em.merge(o);
            terminarTransaccion();
        } catch (Exception e) {
            res = false;
        }
        return res;
    }

    public static Asistenciareunion creaAsistenciareunion(Reuniones idreunion, Usuarios dni) {

        Asistenciareunion asr = new Asistenciareunion(dni, idreunion);
        return asr;
    }

    public static boolean insertaAsistenciareunion(Asistenciareunion asr1) {

        boolean res = true;

        try {
            abrirTransaccion();
            em.persist(asr1);
            terminarTransaccion();
        } catch (Exception e) {
            res = false;
        }
        return res;

    }

    public static boolean insertaListaAsistenciareunion(List<Asistenciareunion> listasistenciareunion) {

        boolean res = true;

        for (Asistenciareunion ar : listasistenciareunion) {
            try {
                abrirTransaccion();
                em.persist(ar);
                terminarTransaccion();
            } catch (Exception e) {
                System.out.print(e.toString());
                res = false;
            }
        }

        return res;

    }

    public static Intervenciones creaIntervencion(Integer idintervenciones, Date momentointervencion,
            String intervencion, Puntosdeldia idpuntodeldia, Asistenciareunion idasistenciareunion) {

        Intervenciones intv1 = new Intervenciones(idintervenciones, momentointervencion,
                intervencion, idpuntodeldia, idasistenciareunion);
        return intv1;

    }

    public static boolean insertaIntervenciones(Intervenciones intv1) {

        boolean res = true;

        try {
            abrirTransaccion();
            em.persist(intv1);
            terminarTransaccion();
        } catch (Exception e) {
            res = false;
        }
        return res;

    }

    public static Puntosdeldia creaPuntosdeldia(String titulopunto, Reuniones idreunion) {

        Puntosdeldia pt1 = new Puntosdeldia(titulopunto, idreunion);
        return pt1;

    }

    public static boolean insertaPuntosdeldia(Puntosdeldia pt1) {

        boolean res = true;

        try {
            abrirTransaccion();
            em.persist(pt1);
            terminarTransaccion();
        } catch (Exception e) {
            res = false;
        }
        return res;
    }

    public static boolean insertaListaPuntosdelDia(List<Puntosdeldia> listapuntosdia) {
        boolean res = true;

        for (Puntosdeldia pd : listapuntosdia) {
            try {
                abrirTransaccion();
                em.persist(pd);
                terminarTransaccion();
            } catch (Exception e) {
                System.out.print(e.toString());
                res = false;
            }
        }
        return res;

    }

    public static Reuniones creaReuniones(Date fechainicial, Date fechafinalestimada, Date fechafinalreal, Integer coste, Salasreuniones idsala) {

        Reuniones reunion = new Reuniones(fechainicial, fechafinalestimada, fechafinalreal, coste, idsala);

        return reunion;
    }

    public static Reuniones creaReuniones(Date fechainicial, Date fechafinalestimada, Tiporeuniones idtipo, Salasreuniones idsalareunion, Usuarios dnicreador) {

        return new Reuniones(fechainicial, fechafinalestimada, idtipo, idsalareunion, dnicreador);
    }

    public static boolean insertaReuniones(Reuniones r1) {

        boolean res = true;

        try {
            abrirTransaccion();
            em.persist(r1);
            terminarTransaccion();
        } catch (Exception e) {
            System.out.print(e.toString());
            res = false;

        }
        return res;
    }

    public static Salasreuniones creaSalasreuniones(String direccion,
            String codigopostal, String localidad, String provincia, String pais, int capacidad,
            BigDecimal costealquiler, int telefono, Empresas nif, String nombresala) {
        Salasreuniones slr1 = new Salasreuniones(direccion, codigopostal, localidad, provincia, pais, capacidad, costealquiler, telefono, nif, nombresala);
        return slr1;

    }

    public static boolean insertaSalasreuniones(Salasreuniones slr1) {

        boolean res = true;

        try {
            abrirTransaccion();
            em.persist(slr1);
            terminarTransaccion();
        } catch (Exception e) {
            res = false;
        }
        return res;
    }

    public static Tiporeuniones creaTiporeuniones(Integer id) {

        return new Tiporeuniones(id);
    }

    public static Tiporeuniones creaTiporeuniones(String tiporeunion) {

        return new Tiporeuniones(tiporeunion);
    }

    public static boolean insertaTiporeuniones(Tiporeuniones tpr1) {

        boolean res = true;

        try {
            abrirTransaccion();
            em.persist(tpr1);
            terminarTransaccion();
        } catch (Exception e) {
            res = false;
        }
        return res;


    }

    public static Empresasamigas creaEmpresasAmigas(Empresas emp1, Empresas emp2) {

        return new Empresasamigas(emp1, emp2);


    }

    public static boolean insertaEmpresasAmigas(Empresasamigas empa) {
        boolean res = true;

        try {
            abrirTransaccion();
            em.persist(empa);
            terminarTransaccion();
        } catch (Exception e) {
            System.out.print(e.toString());
            res = false;
        }
        return res;
    }
}