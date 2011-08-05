/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import BD.*;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Antonio
 */
public class Pruebas {
    public static void main(String[]args){
            
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CreativeMeetingsPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Date d= new Date(1989,07,11);
        Usuarios us1= new Usuarios("28786879x", "Antonio", "Camacho", d, "C Linares nº4-2ºA",
                "antcamzap@gmail.com", "antcamzap", "holamundo", "Carmona", "Sevilla",
                "España", 41410, "Jefe Maximo",new BigDecimal(9999),true , true);
        em.persist(us1);
        em.getTransaction().commit();
        System.out.print("El Carlos quiere que se ejecute");
        
    }
    
}
