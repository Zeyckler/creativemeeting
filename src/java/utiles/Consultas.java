/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import bd.Asistenciareunion;
import bd.Reuniones;
import bd.Usuarios;
import java.util.Collection;
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
}
