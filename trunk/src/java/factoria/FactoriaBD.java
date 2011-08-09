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
import bd.Empresas;
import bd.Reuniones;
import bd.Usuarios;
import java.math.BigDecimal;
import java.util.Date;
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

    public static void insertaAdjunto(Adjunto adj) {
        abrirTransaccion();
        em.persist(adj);
        terminarTransaccion();
    }

    public static Empresas creaEmpresa(String nif, int telefono, String razonsocial,
            String direccion, String email, String localidad, String provincia,
            String pais, int codigopostal) {
        return new Empresas(nif, telefono, razonsocial, direccion, email,
                localidad, provincia, pais, codigopostal);
    }

    public static void insertaEmpresa(Empresas emp) {
        abrirTransaccion();
        em.persist(emp);
        terminarTransaccion();
    }
    
    public void prueba(){}

    public static Usuarios creaUsuario(String dni, Empresas empresa, String nombre,
            String apellido1, Date fechanacimiento, String direccion, String email,
            String usuario, String contrasena, String localidad, String provincia,
            String pais, int codigopostal, String cargo, BigDecimal salario,
            boolean privilegios, boolean activo) {

        return new Usuarios(dni, empresa, nombre, apellido1, fechanacimiento,
                direccion, email, usuario, contrasena, localidad, provincia, pais,
                codigopostal, cargo, salario, privilegios, activo);
    }

    public static void insertaUsuario(Usuarios us) {
        abrirTransaccion();
        em.persist(us);
        terminarTransaccion();
    }
}