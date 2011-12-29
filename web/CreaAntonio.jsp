<%-- 
    Document   : CreaAntonio
    Created on : 03-ago-2011, 18:38:37
    Author     : japarejo
--%>
<%@page import="utiles.Utilidades"%>
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
        
       /* EntityManagerFactory emf = Persistence.createEntityManagerFactory("CreativeMPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        */
 /*          Prueba Inicial:
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
        */
        
        //   Prueba Factoria crea e inserta
        /*
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
        out.print(a);*/
        
        
        //Prueba Consultas
        
        /*List<Usuarios>usuarios=Consultas.asistentesReunion2(1);
        
        for(Usuarios us:usuarios){
            out.print("<h2>"+us.getNombre()+"  "+ us.getApellido1()+"</h2>");
        }
        
        out.print("<h2>" +"usuarios Activos"+ "</h2>");
        List<Usuarios>usuariosact=Consultas.listaUsuariosActivos();
        
        for(Usuarios us12:usuariosact){
            out.print("<h2>"+us12.getNombre()+"  "+ us12.getApellido1()+"</h2>");
        }
        out.print("<h2>" +"Empresas"+ "</h2>");
        List<Empresas> empresas= Consultas.listaEmpresas();
        
        for(Empresas emp:empresas){
            out.print("<h2>"+ emp.getRazonsocial()+"<h2>");
        }

        out.print("usuarios de la empresa 28786879z");
        
        List<Usuarios> leu= Consultas.listaUsuariosEmpresa("28786879z");
        for(Usuarios usem:leu){
            out.print("<h2>"+usem.getNombre()+"  "+ usem.getApellido1()+"</h2>");
        }*/
        
        //Prueba insertado de Reunion
        
        /*Tiporeuniones tp1 = new Tiporeuniones(new Integer(3));
        Salasreuniones slr1 = new Salasreuniones(new Integer(1));
        Usuarios usuario1= new Usuarios("28786879x");
        Date fecha= new Date(111,5,9);
        Date hora= new Date(111,5,9,17,30,0);
        Reuniones reunion1= FactoriaBD.creaReuniones(new Integer (1) , fecha, hora, new Integer(30), new Integer(345), new Integer(35), tp1, slr1, usuario1);
        boolean bool = FactoriaBD.insertaReuniones(reunion1);
        out.print(bool);
        */
        /*List<Reuniones> lrusuarios= Consultas.listaReunionesCreador("28786879x");
        
        for(Reuniones rrr: lrusuarios){
            Date fecha= rrr.getFecha();
            String fechaReunion;
            fechaReunion= Utilidades.getFormatoFecha(fecha);
            String hora= Utilidades.getFormachoFechaHora(rrr.getHora());
            out.print("PRUEBA:"+fecha.getDay());
            out.print("<h4>"+ rrr.getDnicreador()+ "  "+ fecha+ "  "+fechaReunion+ "  "+ hora+ rrr.getIdreunion());
            
        }
        
        List<Adjunto> listaAdjunto= Consultas.listaAdjuntosReunion(1);
        
        for (Adjunto adj: listaAdjunto){
            
            out.print(adj.getRutaarchivo());
        }
        
        List<Puntosdeldia> listapd= Consultas.listaPuntosdesDiaReunion(1);
        
        for(Puntosdeldia ptd: listapd){
            
            out.print("<h3>"+ ptd.getTitulopunto()+"</h3>");
        }
        List<Object[]> listInterv= Consultas.listaIntervencionesEnReunion(1);
        
        for (Object[] obj1:listInterv){
            
            Usuarios usr1= (Usuarios) obj1[0];
            Intervenciones intrv1 = (Intervenciones) obj1[1];
            String hora=Utilidades.getFormachoFechaHora(intrv1.getMomentointervencion());
            out.print("<h4>"+usr1.getNombre()+" "+ usr1.getApellido1()+ "   dijo  "+intrv1.getIntervencion()+ "a las "+ hora+ "en el Punto del dia:  "+ intrv1.getIdpuntodeldia().getTitulopunto()+"</h4>" );
            
        }
        
        List<Reuniones> listareunionesUsuarios = Consultas.listaReunionesUsuarios("28786879y");
        
        for(Reuniones ru123: listareunionesUsuarios){
            
            String fecha12345= Utilidades.getFormatoFecha(ru123.getFecha());
            out.print("<h5> Fecha Reunion: "+ ru123.getFecha()+"  Hora Reunion: "+ fecha12345 );
        }
        
        Usuarios user= Consultas.buscaUsuarioContrasena("antcamzap", "akjdkajhd");
        out.print(user);
        */
        
        /*
        Empresas a= FactoriaBD.creaEmpresa("11111111H", 955444222, "pepito Perez", "Calle sin nombre", "ant@us.es", "Carmona", "Sevilla", "España", 41410, "www.artyos.es","antoñito" , 955444777);
        boolean rt= FactoriaBD.insertaEmpresa(a);
        
        out.print(rt );*/
        
        /*
        Empresas emp= Consultas.listaEmpresas().get(0);
        String usuario = Utilidades.creaNombreUsuario("Antonio", "Camacho", "Zapata");
        out.println("");
        out.println(usuario);
        Usuarios us1 = FactoriaBD.creaUsuario("11111111E", "Antonio", "Camacho", "Zapata", new Date(89, 6, 11),
                "c/ Linares nº1", 955632147 , 654123789 , "antcam@gmail.com" , usuario, "contraseña", "Carmona", 
                "Sevilla", "España" , 41410 , "Jefe", new BigDecimal(11111) , 1, true, emp);
        boolean a = FactoriaBD.insertaUsuario(us1);
        
        out.print(a);
          */
        int i=0; 
        List<Reuniones> l = Consultas.buscaReunionesUsuarioAnio("28500490v", 2010);
        for(Reuniones r: l){
            i++;
            out.println("Reunion: " + i + "realizada el dia" + Utilidades.getFormatoFecha(r.getFecha()));
            out.print("</br>");
            Collection<Asistenciareunion> listaAsistencia= r.getAsistenciareunionCollection();
            out.println("Usuarios que asisten a la reunion");
            out.print("</br>");
            for(Asistenciareunion asis: listaAsistencia){
                Usuarios us = asis.getDni();
                out.println(us.getDni()+"-"+ us.getNombre()+ us.getApellido1()+us.getApellido2()); 
                out.print("</br>");
            }
            
        }
        %>
        <p>¡¡¡Antonio ha sido grabado :-D!!!</p>
    </body>
</html>