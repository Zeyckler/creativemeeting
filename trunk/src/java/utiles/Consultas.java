/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import bd.Adjunto;
import bd.Asistenciareunion;
import bd.Empresas;
import bd.Empresasamigas;
import bd.Puntosdeldia;
import bd.Reuniones;
import bd.Salasreuniones;
import bd.Tiporeuniones;
import bd.Usuarios;
import com.sun.faces.application.resource.LibraryInfo;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Antonio
 */
public class Consultas {

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

    public static List<Usuarios> asistentesReunion(int idReunion) {
        abrirTransaccion();
        Query q1 = em.createNamedQuery(Reuniones.BUSCAR_REUNIONES);
        q1.setParameter("idreunion", idReunion);
        Object o1 = q1.getSingleResult();
        Reuniones r1 = (Reuniones) o1;
        Collection<Asistenciareunion> asisReunion = r1.getAsistenciareunionCollection();
        List<Usuarios> usReunion = new LinkedList<Usuarios>();

        for (Asistenciareunion ar : asisReunion) {
            Usuarios us = ar.getDni();
            usReunion.add(us);
        }

        return usReunion;

    }

    public static List<Usuarios> asistentesReunion2(int idReunion) {
        abrirTransaccion();
        Query q1 = em.createNamedQuery(Usuarios.BUSCAR_USUARIOSIDREUNIONES);
        q1.setParameter("idr1", idReunion);
        List<Usuarios> lu = q1.getResultList();

        return lu;

    }

    public static List<Usuarios> listaUsuariosActivos() {

        abrirTransaccion();
        Query q1 = em.createNamedQuery(Usuarios.BUSCAR_USUARIOSACTIVOS);
        q1.setParameter("activo", true);
        List<Usuarios> lu = q1.getResultList();

        return lu;

    }

    public static List<Empresas> listaEmpresas() {

        abrirTransaccion();
        Query q1 = em.createNamedQuery(Empresas.BUSCAR_EMPRESAS);
        List<Empresas> lu = q1.getResultList();

        return lu;
    }

    public static List<Usuarios> listaUsuariosEmpresa(String nif) {

        abrirTransaccion();
        Query q1 = em.createNamedQuery(Usuarios.BUSCAR_USUARIOSBYEMPRESA);
        q1.setParameter("nifempresa", nif);
        List<Usuarios> lu = q1.getResultList();

        return lu;
    }

    //listaReunionesCreador devuelve una lista de Reuniones que todavía no han 
    //sido celebradas
    public static List<Reuniones> listaReunionesCreador(String nif) {


        abrirTransaccion();
        Date fecha = new Date(111, 3, 16);
        Query q1 = em.createNamedQuery(Reuniones.BUSCAR_REUNIONESCREADOR);
        q1.setParameter("creador", nif);
        q1.setParameter("fechaactual", fecha);
        List<Reuniones> lu = q1.getResultList();

        return lu;

    }
    public static Reuniones buscaReunionId(Integer id) {


        abrirTransaccion();
        Query q1 = em.createNamedQuery("Reuniones.findByIdreunion");
        q1.setParameter("idreunion",id);
        Reuniones reunion =(Reuniones) q1.getSingleResult();

        return reunion;

    }

    public static List<Adjunto> listaAdjuntosReunion(int idReunion) {

        abrirTransaccion();
        Query q1 = em.createNamedQuery(Adjunto.BUSCAR_ADJUNTOIDREUNION);
        q1.setParameter("idreuniones", idReunion);
        List<Adjunto> lu = q1.getResultList();

        return lu;

    }

    public static List<Puntosdeldia> listaPuntosdesDiaReunion(int idReunion) {

        abrirTransaccion();
        Query q1 = em.createNamedQuery(Puntosdeldia.BUSCAR_PUNTOSDIAREUNION);
        q1.setParameter("idreunion", idReunion);
        List<Puntosdeldia> lu = q1.getResultList();

        return lu;

    }

    public static List<Object[]> listaIntervencionesEnReunion(int idReunion) {

        abrirTransaccion();
        Query q1 = em.createNamedQuery(Reuniones.BUSCAR_INTERVENCIONESPORREUNION);
        q1.setParameter("idre", idReunion);
        List<Object[]> lu = q1.getResultList();

        return lu;

    }

    public static List<Reuniones> listaReunionesUsuarios(String dni) {

        abrirTransaccion();
        Query q1 = em.createNamedQuery(Reuniones.BUSCAR_REUNIONESUSUARIO);
        q1.setParameter("dni", dni);
        List<Reuniones> lu = q1.getResultList();

        return lu;
    }

    public static boolean existeEmpresa(String nifemp) {

        abrirTransaccion();
        Query q1 = em.createNamedQuery(Empresas.BUSCAR_EMPRESA_NIF);
        q1.setParameter("nif", nifemp);

        int numeroEmp = q1.getResultList().size();

        if (numeroEmp == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static Empresas buscaEmpresaNif(String nifemp) {

        Empresas emp;
        abrirTransaccion();
        Query q1 = em.createNamedQuery(Empresas.BUSCAR_EMPRESA_NIF);
        q1.setParameter("nif", nifemp);
        try {
            emp = (Empresas) q1.getSingleResult();
        } catch (Exception e) {
            emp = null;
        }
        return emp;
    }

    //modificar
    public static Usuarios buscaUsuarioContrasena(String usuario, String contrasena) {

        abrirTransaccion();
        Query q1 = em.createNamedQuery(Usuarios.BUSCAR_USUARIOYCONTRASENA);
        q1.setParameter("usuario", usuario);
        q1.setParameter("contasenia", contrasena);

        Usuarios user;
        try {
            user = (Usuarios) q1.getSingleResult();
        } catch (Exception e) {
            //Hay que ver si la execpcion es javax.persistence.NoResultException para que este el metodo bien
            user = null;
        }

        return user;
    }

    public static List<Usuarios> buscaUsuarioParecidos(String usuario) {

        //Busca Usuarios con las mismas iniciales en el nombre apellido q y apellido 2

        abrirTransaccion();
        Query q1 = em.createNamedQuery(Usuarios.BUSCAR_USUARIOSPARECIDOS);
        q1.setParameter("usuario", "%" + usuario + "%");

        List<Usuarios> user = new LinkedList<Usuarios>();
        try {
            user = (List<Usuarios>) q1.getResultList();
        } catch (Exception e) {
            //Hay que ver si la execpcion es javax.persistence.NoResultException para que este el metodo bien
            user = null;
        }

        return user;
    }

    public static List<Empresas> buscaEmpresaPorActivar() {

        boolean activo = true;

        List<Empresas> empInactivas;

        abrirTransaccion();
        Query q1 = em.createNamedQuery(Empresas.BUSCAR_EMPRESAS_ACTIVACION);
        q1.setParameter("activo", activo);

        try {
            empInactivas = q1.getResultList();
        } catch (Exception e) {
            //Hay que ver si la execpcion es javax.persistence.NoResultException para que este el metodo bien
            empInactivas = null;
        }

        return empInactivas;


    }

    public static List<Reuniones> buscaReunionesUsuarioAnio(String dniusuario, Integer anio) {

        Date finicio = new Date(anio - 1901, 11, 31);
        Date ffinal = new Date(anio - 1900, 11, 31);




        List<Reuniones> listareuniones = null;
        abrirTransaccion();
        Query q1 = em.createNamedQuery(Reuniones.BUSCAR_REUNIONES_USUARIO_ANIO);
        q1.setParameter("dni", dniusuario);
        q1.setParameter("fecha1", finicio);
        q1.setParameter("fecha2", ffinal);
        q1.setParameter("notificacion", false);
        q1.setParameter("respuesta", true);
        try {
            listareuniones = q1.getResultList();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return listareuniones;

    }

    public static Reuniones buscaReunionesUsuarioInformacion(String dniusuario, Date fecha1, Date fecha2) {


        Reuniones reuniones = null;
        abrirTransaccion();
        Query q1 = em.createNamedQuery("Reuniones.findReunionesUsuarioInformacion");
        q1.setParameter("dni", dniusuario);
        q1.setParameter("fecha1", fecha1);
        q1.setParameter("fecha2", fecha2);
        q1.setParameter("notificacion", false);
        q1.setParameter("respuesta", true);
        try {
            reuniones = (Reuniones) q1.getSingleResult();
        } catch (Exception e) {
            reuniones = null;
        }
        return reuniones;

    }

    public static Reuniones buscaReunionesUsuarioInformacionHoy(String dniusuario) {

        Reuniones r = null;

        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.HOUR_OF_DAY, 0);
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.SECOND, 0);
        Date hoyinicial = c1.getTime();

        c1.set(Calendar.HOUR_OF_DAY, 23);
        c1.set(Calendar.MINUTE, 59);
        c1.set(Calendar.SECOND, 59);
        Date hoyfinal = c1.getTime();
        
        System.out.print("dni "+dniusuario+"Fecha inicial"+"Fecha inicial:"+ hoyinicial  + "Fecha Final"+ hoyfinal);

        try {
            r = buscaReunionesUsuarioInformacion(dniusuario, hoyinicial, hoyfinal);
        } catch (Exception e) {
            r = null;
        }
        return r;

    }

    public static List<Salasreuniones> buscaSalasLibreFecha(Date fechainicial, Date fechafinal) {

        List<Salasreuniones> salas = null;
        abrirTransaccion();
        Query q1 = em.createNamedQuery(Salasreuniones.BUSCAR_SALASLIBREFECHA);
        q1.setParameter("fechinicial", fechainicial);
        q1.setParameter("fechfinal", fechafinal);


        try {
            salas = q1.getResultList();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return salas;

    }

    private static List<Object[]> buscaEmpresasAmigas1(String nif) {

        List<Object[]> empresas = null;
        abrirTransaccion();
        Query q1 = em.createNamedQuery(Empresasamigas.BUSCAR_EMPRESAS_AMIGAS_1);
        q1.setParameter("nifempresa", nif);
        q1.setParameter("activacion", false);
        q1.setParameter("activo", true);

        try {
            empresas = q1.getResultList();
        } catch (Exception e) {
            System.out.print(e.toString());

        }
        return empresas;
    }

    private static List<Object[]> buscaEmpresasAmigas2(String nif) {

        List<Object[]> empresas = null;
        abrirTransaccion();
        Query q1 = em.createNamedQuery(Empresasamigas.BUSCAR_EMPRESAS_AMIGAS_2);
        q1.setParameter("nifempresa", nif);
        q1.setParameter("activacion", false);
        q1.setParameter("activo", true);

        try {
            empresas = q1.getResultList();
        } catch (Exception e) {
            System.out.print(e.toString());

        }
        return empresas;
    }

    public static List<Object[]> buscaempresasAmigas(String nif) {

        List<Object[]> empresas = null;

        empresas = buscaEmpresasAmigas1(nif);
        empresas.addAll(buscaEmpresasAmigas2(nif));

        return empresas;



    }

    public static List<Object[]> buscaUsuariosDisponibleReunion(Date fecha, String nif) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date fechinicial = calendar.getTime();

        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        Date fechfinal = calendar.getTime();


        List<Object[]> usuariosdisponibles = null;
        abrirTransaccion();
        Query q1 = em.createNamedQuery(Usuarios.BUSCAR_USUARIOSDISPONIBLESREUNION);
        q1.setParameter("fechfinal", fechfinal);
        q1.setParameter("fechinicial", fechinicial);
        q1.setParameter("notificacion", false);
        q1.setParameter("respuesta", false);
        q1.setParameter("notificaciont", true);
        q1.setParameter("nifemp", nif);
        q1.setParameter("dniadmin", Utilidades.getDniUsuarioSesion());


        try {
            usuariosdisponibles = q1.getResultList();
        } catch (Exception e) {
            System.out.print(e.toString());
        }

        return usuariosdisponibles;



    }

    public static Tiporeuniones buscarTipoReuniones(Integer id) {

        Tiporeuniones tipo = null;
        abrirTransaccion();
        Query q1 = em.createNamedQuery("Tiporeuniones.findByIdtipo");
        q1.setParameter("idtipo", id);

        try {
            tipo = (Tiporeuniones) q1.getSingleResult();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return tipo;
    }

    public static Usuarios buscarUsuario(String dni) {
        Usuarios usuario = null;
        abrirTransaccion();
        Query q1 = em.createNamedQuery("Usuarios.findByDni");
        q1.setParameter("dni", dni);

        try {
            usuario = (Usuarios) q1.getSingleResult();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return usuario;
    }

    public static List<Usuarios> buscarUsuariosporActivarAE(String nif) {
        List<Usuarios> usuarios = new LinkedList<Usuarios>();
        abrirTransaccion();
        Query q1 = em.createNamedQuery("Usuarios.findUsuariosNuevosPorActivarAE");
        q1.setParameter("empnif", nif);
        q1.setParameter("actini", true);
        try {
            usuarios = q1.getResultList();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return usuarios;
    }

    public static List<Reuniones> buscaReunionesNotificacionesporUsuario(String dni) {
        Date hoy = Calendar.getInstance().getTime();
        boolean notificacion = true;
        List<Reuniones> reuniones = null;
        abrirTransaccion();
        Query q1 = em.createNamedQuery("Reuniones.findReunionesNotificacionesPorUsuario");
        q1.setParameter("dni", dni);
        q1.setParameter("noti", notificacion);
        q1.setParameter("hoy", hoy);
        try {
            reuniones = q1.getResultList();
        } catch (Exception e) {
            System.out.print(e.toString());

        }
        return reuniones;
    }

    public static Empresasamigas buscaParejaEmpresasAmigas(String nif1, String nif2) {

        Empresasamigas empresasamigas = null;
        abrirTransaccion();
        Query q1 = em.createNamedQuery("Empresasamigas.findParejaEmpresasAmigas");
        q1.setParameter("nif1", nif1);
        q1.setParameter("nif2", nif2);
        q1.setParameter("activacion", false);
        q1.setParameter("activo", true);

        try {
            empresasamigas = (Empresasamigas) q1.getSingleResult();
        } catch (Exception e) {
            System.out.print(e.toString());

        }
        return empresasamigas;
    }

    public static Empresasamigas buscaParejaEmpresasAmigasAmistad(String nif1, String nif2, boolean activacioninicial, boolean activo) {

        Empresasamigas empresasamigas = null;
        abrirTransaccion();
        Query q1 = em.createNamedQuery("Empresasamigas.findParejaEmpresasAmigas");
        q1.setParameter("nif1", nif1);
        q1.setParameter("nif2", nif2);
        q1.setParameter("activacion", activacioninicial);
        q1.setParameter("activo", activo);

        try {
            empresasamigas = (Empresasamigas) q1.getSingleResult();
        } catch (Exception e) {
            System.out.print(e.toString());

        }
        return empresasamigas;
    }

    public static boolean existeParejaEmpresasAmigas(String nif1, String nif2, boolean activacion, boolean activo) {

        int empresasamigas = 0;
        boolean res = true;

        abrirTransaccion();
        Query q1 = em.createNamedQuery("Empresasamigas.findParejaEmpresasAmigas");
        q1.setParameter("nif1", nif1);
        q1.setParameter("nif2", nif2);
        q1.setParameter("activacion", activacion);
        q1.setParameter("activo", activo);

        try {
            empresasamigas = q1.getResultList().size();
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        if (empresasamigas > 0) {
            res = false;
        }

        return res;
    }

    public static Empresasamigas buscaParejaEmpresasAmigasInactivas(String nif1, String nif2) {

        Empresasamigas empresasamigas = null;
        abrirTransaccion();
        Query q1 = em.createNamedQuery("Empresasamigas.findEmpresasAmigasInactivas");
        q1.setParameter("nif1", nif1);
        q1.setParameter("nif2", nif2);
        q1.setParameter("activacion", false);
        q1.setParameter("activo", false);

        try {
            empresasamigas = (Empresasamigas) q1.getSingleResult();
        } catch (Exception e) {
            System.out.print(e.toString());

        }
        return empresasamigas;
    }

    public static List<Empresasamigas> buscaEmpresasAmigasNotificacion(String nif2) {

        List<Empresasamigas> empresasamigas;
        abrirTransaccion();
        Query q1 = em.createNamedQuery("Empresasamigas.findEmpresasAmigasNotificacion");
        q1.setParameter("nif2", nif2);
        q1.setParameter("activacion", true);
        q1.setParameter("activo", false);

        try {
            empresasamigas = q1.getResultList();
        } catch (Exception e) {
            System.out.print(e.toString());
            empresasamigas = null;
        }
        return empresasamigas;
    }

    public static List<Reuniones> buscaProximasReunionesAceptada(String dni) {

        List<Reuniones> reuniones = null;

        Calendar manana = Calendar.getInstance();
        manana.add(Calendar.DAY_OF_YEAR, 1);
        manana.set(Calendar.HOUR_OF_DAY, 0);
        manana.set(Calendar.MINUTE, 0);
        manana.set(Calendar.SECOND, 1);
        Date fecha = manana.getTime();


        abrirTransaccion();
        Query q1 = em.createNamedQuery("Reuniones.findReunionesUsuarioProximasInformacion");
        q1.setParameter("dni", dni);
        q1.setParameter("fechamanana", fecha);
        q1.setParameter("notificacion", false);
        q1.setParameter("respuesta", true);
        try {
            reuniones = q1.getResultList();
        } catch (Exception e) {
            reuniones = null;
        }
        return reuniones;

    }
}
