<%-- 
    Document   : CreaAntonio
    Created on : 03-ago-2011, 18:38:37
    Author     : japarejo
--%>

<%@page import="java.math.BigDecimal"%>
<%@page import="BD.Usuarios"%>
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

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CreativeMeetingsPU");
        EntityManager em = emf.createEntityManager();        
        Date d= new Date(1989,07,11);
        Usuarios us1= new Usuarios("28786879x", "Antonio", "Camacho", d, "C Linares nº4-2ºA",
                "antcamzap@gmail.com", "antcamzap", "holamundo", "Carmona", "Sevilla",
                "España", 41410, "Jefe Maximo",new BigDecimal(9999),true , true);
        em.persist(us1);        
        em.flush();

        %>
        <p>Antonio ha sido grabado :-D</p>
    </body>
</html>
