<%-- 
    Document   : CreaAntonio
    Created on : 03-ago-2011, 18:38:37
    Author     : japarejo
--%>
<%@page import="utiles.Consultas"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="factoria.FactoriaBD"%>
<%@page import="bd.Intervenciones"%>
<%@page import="bd.Puntosdeldia"%>
<%@page import="bd.Asistenciareunion"%>
<%@page import="bd.Salasreuniones"%>
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
        //em.flush();
        */
        //Tiporeuniones tp= new Tiporeuniones(1,"Charla Coloquio333332");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CreativeMPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        /*
 *          Prueba Inicial:
        //Empresa
        Empresas emp1 = new Empresas("28786879z", 954191739, "Antonio Camacho S.L",
                "c/Linares nº4-2B", "camachosl@gmail.com", "Carmona", "Sevilla", 
                "España", 41410);
        em.persist(emp1);        
        //em.flush();
        
        //Usuarios
        Date d= new Date(89, 6, 11);
        Date d1= new Date(89, 0, 20);
        Usuarios us1= new Usuarios("28786879x","28786879z", "Antonio", "Camacho", d, "C Linares nº4-2ºA",
                "antcamzap@gmail.com", "antcamzap", "admin", "Carmona", "Sevilla",
                "España", 41410, "Jefe Maximo",new BigDecimal(9999),true , true);
        em.persist(us1);        
        //em.flush();
        Usuarios us2= new Usuarios("28828025d","28786879z", "Carlos", "Barrero", d1, "Avda La Barzola nº34 1ºC",
                "zeyckler@gmail.com", "carbarvaz", "admin", "Sevilla", "Sevilla",
                "España", 41008, "Jefe Maximo Segundo",new BigDecimal(9999),true , true);
        em.persist(us2);        
        //em.flush();
        
        //Sala de Reuniones
        Salasreuniones sr1= new Salasreuniones(new Integer(1) , "Avda Reina Mercedes sn",
                "41010", "Sevilla", "España",1223, new BigDecimal(99999), 987654213); 
        em.persist(sr1);        
        //em.flush();
        
        //Tipo de Reuniones
        Tiporeuniones tr1= new Tiporeuniones(new Integer(1), "Análisis Delphi");
        Tiporeuniones tr2 = new Tiporeuniones(new Integer(1), "7 Sombreros");
        Tiporeuniones tr3 = new Tiporeuniones(new Integer(1), "Reunión General");
        em.persist(tr1);
        em.persist(tr2);
        em.persist(tr3);
        //em.flush();
        
        //Reuniones
        Date fecha= new Date(110,5,9);
        Date hora= new Date(110,5,9,17,30,0);
        Reuniones ru1 = new Reuniones(new Integer(1) , fecha , hora, new Integer(123), new Integer(1234), new Integer(1234),tr1,sr1,us1);
        em.persist(ru1);
        //em.flush();
        
        //Asistencia Reunion
        Asistenciareunion asr1= new Asistenciareunion(new Integer(1),ru1 , us1);
        Asistenciareunion asr2= new Asistenciareunion(new Integer(1),ru1 , us2);
        em.persist(asr1);
        em.persist(asr2);
        //em.flush();
        
        //Puntos del dia 
        Puntosdeldia pd1= new Puntosdeldia(new Integer(1), "Presentación de la empresa", ru1);
        Puntosdeldia pd2= new Puntosdeldia(new Integer(1), "Sueldos de los jefes", ru1);
        em.persist(pd1);
        em.persist(pd2);
        //em.flush();
        
        //Adjunto
        Adjunto adj1= new Adjunto(new Integer(1), "/adjuntos/reunion1/acta.pdf", ru1);
        Adjunto adj2= new Adjunto(new Integer(1), "/adjuntos/reunion1/sueldos.pdf", ru1);
        em.persist(adj1);
        em.persist(adj2);
        //em.flush();
         
        //Intervención Reuniones
         Date dit1= new Date(110, 5, 9, 17, 35, 15);
         Date dit2= new Date(110, 5, 9, 17, 37, 15);
         Date dit3= new Date(110, 5, 9, 17, 41, 15);
         Date dit4= new Date(110, 5, 9, 17, 44, 15);
         
         Intervenciones it1= new Intervenciones(new Integer(1), dit1, "Yo, Antonio Camacho juro que sere leal a la empresa",
                 pd1, asr1);
         Intervenciones it2= new Intervenciones(new Integer(1), dit2, "Yo, Carlos Barrero  juro que sere leal a la empresa",
                 pd1, asr2);
         Intervenciones it3= new Intervenciones(new Integer(1), dit3, "Los sueldos serán en variables en función de los ingresos",
                 pd2, asr1);
         Intervenciones it4= new Intervenciones(new Integer(1), dit4, "Estoy de acuerdo",
                 pd2, asr2); 
        em.persist(it1);
        em.persist(it2);
        em.persist(it3);
        em.persist(it4);
 *      */
        /*
 *          Prueba Factoria crea e inserta
        Date d= new Date(89, 6, 11);
        Date d1= new Date(89, 0, 20);
        Usuarios us1= new Usuarios("28786879x","28786879z", "Antonio", "Camacho", d, "C Linares nº4-2ºA",
                "antcamzap@gmail.com", "antcamzap", "admin", "Carmona", "Sevilla",
                "España", 41410, "Jefe Maximo",new BigDecimal(9999),true , true);
        Date fecha= new Date(110,5,9);
        Date hora= new Date(110,5,9,17,30,0);
        Tiporeuniones tr1= new Tiporeuniones(new Integer(1), "Análisis Delphi");
        Salasreuniones sr1= new Salasreuniones(new Integer(1) , "Avda Reina Mercedes sn",
                "41010", "Sevilla", "España",1223, new BigDecimal(99999), 987654213);
        Reuniones ru1 = new Reuniones(new Integer(1) , fecha , hora, new Integer(123), new Integer(1234), new Integer(1234),tr1,sr1,us1);
        Adjunto adjuntoPrueba= FactoriaBD.creaAdjunto(new Integer(1), "/adjuntos/reunion1/presupuesto.pdf",ru1 );
        boolean a= FactoriaBD.insertaAdjunto(adjuntoPrueba);        
        out.print(a);
        */
        List<Usuarios>usuarios=Consultas.asistentesReunion(1);
        
        for(Usuarios us:usuarios){
            out.print("<h2>"+us.getNombre()+"  "+ us.getApellido1()+"</h2>");
        }
        
        
        
        
        %>
        <p>Antonio ha sido grabado :-D</p>
    </body>
</html>
