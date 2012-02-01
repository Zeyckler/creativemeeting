/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bd.Adjunto;
import bd.Asistenciareunion;
import bd.Puntosdeldia;
import bd.Salasreuniones;
import bd.Tiporeuniones;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author AntonioCZ
 */
public class RegistraReunion implements Serializable {

    private static final long serialVersionUID = 1L;
    private Date fecha;
    private Date hora;
    private String horastr;
    private String minutosstr;
    private Integer duracioninicial;
    private Integer coste;
    private Integer duracionreal;
    private Collection<Puntosdeldia> puntosdeldiaCollection;
    private Collection<Asistenciareunion> asistenciareunionCollection;
    private Tiporeuniones idtipo;
    private String tipostr;
    private Salasreuniones idsalareunion;
    private Collection<Adjunto> adjuntoCollection;
   
    /** Creates a new instance of RegistraReunion */
    public RegistraReunion() {
    }

    public Collection<Adjunto> getAdjuntoCollection() {
        return adjuntoCollection;
    }

    public void setAdjuntoCollection(Collection<Adjunto> adjuntoCollection) {
        this.adjuntoCollection = adjuntoCollection;
    }

    public Collection<Asistenciareunion> getAsistenciareunionCollection() {
        return asistenciareunionCollection;
    }

    public void setAsistenciareunionCollection(Collection<Asistenciareunion> asistenciareunionCollection) {
        this.asistenciareunionCollection = asistenciareunionCollection;
    }

    public Integer getCoste() {
        return coste;
    }

    public void setCoste(Integer coste) {
        this.coste = coste;
    }

    public Integer getDuracioninicial() {
        return duracioninicial;
    }

    public void setDuracioninicial(Integer duracioninicial) {
        this.duracioninicial = duracioninicial;
    }

    public Integer getDuracionreal() {
        return duracionreal;
    }

    public void setDuracionreal(Integer duracionreal) {
        this.duracionreal = duracionreal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Salasreuniones getIdsalareunion() {
        return idsalareunion;
    }

    public void setIdsalareunion(Salasreuniones idsalareunion) {
        this.idsalareunion = idsalareunion;
    }

    public Tiporeuniones getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Tiporeuniones idtipo) {
        this.idtipo = idtipo;
    }


    public Collection<Puntosdeldia> getPuntosdeldiaCollection() {
        return puntosdeldiaCollection;
    }

    public void setPuntosdeldiaCollection(Collection<Puntosdeldia> puntosdeldiaCollection) {
        this.puntosdeldiaCollection = puntosdeldiaCollection;
    }

    public String getTipostr() {
        return tipostr;
    }

    public void setTipostr(String tipostr) {
        this.tipostr = tipostr;
    }

    public String getHorastr() {
        return horastr;
    }

    public void setHorastr(String horastr) {
        this.horastr = horastr;
    }

    public String getMinutosstr() {
        return minutosstr;
    }

    public void setMinutosstr(String minutosstr) {
        this.minutosstr = minutosstr;
    }
    
    
    
    
    
}
