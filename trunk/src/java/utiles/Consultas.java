/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import bd.Adjunto;
import bd.Asistenciareunion;
import bd.Empresas;
import bd.Puntosdeldia;
import bd.Reuniones;
import bd.Usuarios;
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
        public static List<Usuarios> listaUsuariosActivos(){
      
      abrirTransaccion();
      Query q1= em.createNamedQuery(Usuarios.BUSCAR_USUARIOSACTIVOS);
      q1.setParameter("activo", true);
      List<Usuarios> lu = q1.getResultList();
      
      return lu;
        
    }
    public static List<Empresas> listaEmpresas(){
        
        abrirTransaccion();
        Query q1= em.createNamedQuery(Empresas.BUSCAR_EMPRESAS);
        List<Empresas> lu = q1.getResultList();
        
        return lu;
    }
    
    public static List<Usuarios> listaUsuariosEmpresa(String nif){
        
        abrirTransaccion();
        Query q1= em.createNamedQuery(Usuarios.BUSCAR_USUARIOSBYEMPRESA);
        q1.setParameter("nifempresa", nif);
        List<Usuarios> lu = q1.getResultList();
        
        return lu;
    }
    
    //listaReunionesCreador devuelve una lista de Reuniones que todavía no han 
    //sido celebradas
    
    public static List<Reuniones> listaReunionesCreador(String nif){
        
        
        abrirTransaccion();
        Date fecha= new Date(111, 3, 16);
        Query q1= em.createNamedQuery(Reuniones.BUSCAR_REUNIONESCREADOR);
        q1.setParameter("creador", nif);
        q1.setParameter("fechaactual", fecha);
        List<Reuniones> lu = q1.getResultList();
        
        return lu;
        
    }
    
    public static List<Adjunto> listaAdjuntosReunion(int idReunion){
        
        abrirTransaccion();
        Query q1= em.createNamedQuery(Adjunto.BUSCAR_ADJUNTOIDREUNION);
        q1.setParameter("idreuniones", idReunion);
        List<Adjunto> lu= q1.getResultList();
        
        return lu;
         
    }
    
    public static List<Puntosdeldia> listaPuntosdesDiaReunion(int idReunion){
        
        abrirTransaccion();
        Query q1= em.createNamedQuery(Puntosdeldia.BUSCAR_PUNTOSDIAREUNION);
        q1.setParameter("idreunion", idReunion);
        List<Puntosdeldia> lu= q1.getResultList();
        
        return lu;
        
    }
    public static List<Object[]> listaIntervencionesEnReunion(int idReunion){
        
        abrirTransaccion();
        Query q1= em.createNamedQuery(Reuniones.BUSCAR_INTERVENCIONESPORREUNION);
        q1.setParameter("idre", idReunion);
        List<Object[]> lu = q1.getResultList();
        
        return lu;
        
    }
    
    public static List<Reuniones> listaReunionesUsuarios(String dni){
        
        abrirTransaccion();
        Query q1= em.createNamedQuery(Reuniones.BUSCAR_REUNIONESUSUARIO);
        q1.setParameter("dni", dni);
        List<Reuniones> lu = q1.getResultList();
        
        return lu;    
    }
    
    public static Usuarios buscaUsuarioContrasena(String usuario, String contrasena){
        
        abrirTransaccion();
        Query q1 = em.createNamedQuery(Usuarios.BUSCAR_USUARIOYCONTRASENA);
        q1.setParameter("usuario", usuario);
        q1.setParameter("contasenia", contrasena);
        
        Usuarios user;
        try {
            user = (Usuarios) q1.getSingleResult();
        } catch (Exception e) {
            //Hay que ver si la execpcion es javax.persistence.NoResultException para que este el metodo bien
            user= null;
        }
        
        return user;
    }
    
    public static List<Usuarios> buscaUsuarioParecidos(String usuario){
        
        //Busca Usuarios con las mismas iniciales en el nombre apellido q y apellido 2
        
        abrirTransaccion();
        Query q1 = em.createNamedQuery(Usuarios.BUSCAR_USUARIOSPARECIDOS);
        q1.setParameter("usuario", "%"+usuario+"%");
        
        List<Usuarios> user = new LinkedList<Usuarios>();  
        try {
            user = (List<Usuarios>)  q1.getResultList();
        } catch (Exception e) {
            //Hay que ver si la execpcion es javax.persistence.NoResultException para que este el metodo bien
            user= null;
        }
        
        return user;
    }
}
