/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Asistenciareunion;
import bd.Reuniones;
import bd.Usuarios;
import java.util.LinkedList;
import java.util.List;
import utiles.Consultas;

/**
 *
 * @author AntonioCZ
 */
public class actaReunionBean {
    
    private Reuniones reunion;
    private Integer idReunion;
    private List<Usuarios> usuariosasistente;
    

    /** Creates a new instance of actaReunionBean */
    public actaReunionBean() {
    }

    public actaReunionBean(Integer idReunion) {
        this.idReunion = idReunion;
    }
    public void inicializaActa(){
        
        this.reunion = Consultas.buscaReunionId(this.idReunion);
        this.usuariosasistente = new LinkedList<Usuarios>();
        for(Asistenciareunion asis: this.reunion.getAsistenciareunionCollection()){
            if(asis.getAsistencia()==true){
                this.usuariosasistente.add(asis.getDni());              
            }
            
        }
        
    }

    public Integer getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(Integer idReunion) {
        this.idReunion = idReunion;
    }

    public Reuniones getReunion() {
        return reunion;
    }

    public void setReunion(Reuniones reunion) {
        this.reunion = reunion;
    }

    public List<Usuarios> getUsuariosasistente() {
        return usuariosasistente;
    }

    public void setUsuariosasistente(List<Usuarios> usuariosasistente) {
        this.usuariosasistente = usuariosasistente;
    }
    
    
    
    
}
