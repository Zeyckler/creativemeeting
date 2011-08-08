<%-- 
    Document   : CreaAntonio
    Created on : 03-ago-2011, 18:38:37
    Author     : japarejo
--%>
<%@page import="java.sql.Time"%>
<%@page import="bd.Reuniones"%>
<%@page import="bd.Adjunto"%>
<%@page import="bd.Tiporeuniones"%>
<%@page import="bd.Empresas"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="bd.Usuarios"%>
<%@page import="java.util.Date"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Vamos a crear a Antonio</h1>
        <%
        /*Date d= new Date(89, 06, 11);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CreativeMPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Usuarios us1= new Usuarios("87868678z","34567890x", "Antonio", "Camacho", d, "C Linares nº4-2ºA",
                "antcamzap@gmail.com", "antcamzap", "holamundo", "Carmona", "Sevilla",
                "España", 41410, "Jefe Maximo",new BigDecimal(9999),true , true);
        em.persist(us1);        
        em.flush();
        */
        //Tiporeuniones tp= new Tiporeuniones(1,"Charla Coloquio333332");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CreativeMPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Date d= new Date(89, 06, 11);
        Usuarios us1= new Usuarios("87868678z","34567890x", "Antonio", "Camacho", d, "C Linares nº4-2ºA",
                "antcamzap@gmail.com", "antcamzap", "holamundo", "Carmona", "Sevilla",
                "España", 41410, "Jefe Maximo",new BigDecimal(9999),true , true);
        
        Date fecha= new Date(110,5,9);
        Date hora= new Date(110,5,9,17,30,0);
        //Reuniones ru = new Reuniones(fecha, hora, 123, 1234, 1234, 1, 1, us1); 
        //m.persist(ru);        
        em.flush();
        
        
        
        
        %>
        <p>Antonio ha sido grabado :-D</p>
    </body>
</html>
