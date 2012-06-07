/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Reuniones;
import utiles.Consultas;

/**
 *
 * @author AntonioCZ
 */
public class actaReunionBean {
    
    private Reuniones reunion;
    private Integer idReunion;
    

    /** Creates a new instance of actaReunionBean */
    public actaReunionBean() {
    }

    public actaReunionBean(Integer idReunion) {
        this.idReunion = idReunion;
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
    public void inicializaActa(){
        
        this.reunion = Consultas.buscaReunionId(this.idReunion);
        
    }
    
    
}
