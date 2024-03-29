/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "reuniones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reuniones.findAll", query = "SELECT r FROM Reuniones r"),
    @NamedQuery(name = "Reuniones.findByIdreunion", query = "SELECT r FROM Reuniones r WHERE r.idreunion = :idreunion"),
    @NamedQuery(name = "Reuniones.findByCoste", query = "SELECT r FROM Reuniones r WHERE r.coste = :coste"),
    @NamedQuery(name = "Reuniones.findByReunionCreador", query = "SELECT r FROM Reuniones r JOIN r.dnicreador usuario WHERE usuario.dni= :creador AND r.fechainicial> :fechaactual"),
    @NamedQuery(name = "Reuniones.findIntervencionesByIdreunion", query = "SELECT u , intervenciones FROM Usuarios u JOIN u.asistenciareunionCollection asistencia JOIN asistencia.idreunion reunion JOIN asistencia.intervencionesCollection intervenciones WHERE reunion.idreunion =:idre ORDER BY intervenciones.momentointervencion"),
    @NamedQuery(name = "Reuniones.findReunionesdeUsuarios", query = "SELECT r FROM Reuniones r JOIN r.asistenciareunionCollection asistencia JOIN asistencia.dni usuario WHERE usuario.dni = :dni"),
    @NamedQuery(name = "Reuniones.findReunionesdeUsuariosAnio", query = "SELECT r FROM Reuniones r JOIN r.asistenciareunionCollection asistencia JOIN asistencia.dni usuario WHERE usuario.dni = :dni AND r.fechainicial BETWEEN :fecha1 AND :fecha2 AND asistencia.notificacion = :notificacion AND asistencia.respuesta= :respuesta"),
    @NamedQuery(name = "Reuniones.findReunionesNotificacionesPorUsuario", query = "SELECT r FROM Reuniones r JOIN r.asistenciareunionCollection asistencia WHERE asistencia.dni.dni = :dni AND asistencia.notificacion =:noti AND r.fechainicial >=:hoy ORDER BY r.fechainicial ASC"),
    @NamedQuery(name = "Reuniones.findReunionesUsuarioInformacion", query = "SELECT r FROM Reuniones r JOIN r.asistenciareunionCollection asistencia JOIN asistencia.dni usuario WHERE usuario.dni = :dni AND asistencia.notificacion =:notificacion AND asistencia.respuesta = :respuesta  AND r.fechainicial BETWEEN :fecha1 AND :fecha2"),
    @NamedQuery(name = "Reuniones.findReunionesUsuarioProximasInformacion", query = "SELECT r FROM Reuniones r JOIN r.asistenciareunionCollection asistencia JOIN asistencia.dni usuario WHERE usuario.dni = :dni AND asistencia.notificacion =:notificacion AND asistencia.respuesta = :respuesta  AND r.fechainicial> :fechamanana ORDER BY r.fechainicial")
})
public class Reuniones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idreunion")
    private Integer idreunion;
    @Column(name = "coste")
    private Integer coste;
    @Column(name = "fechainicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicial;
    @Column(name = "fechafinalestimada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafinalestimada;
    @Column(name = "fechafinalreal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafinalreal;
    @Column(name = "fechainicialreal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicialreal;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "idreunion")
    @OrderBy("idpuntodeldia")
    private List<Puntosdeldia> puntosdeldiaCollection;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "idreunion")
    private List<Adjunto> adjuntoCollection;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "idreunion")
    private List<Asistenciareunion> asistenciareunionCollection;
    @JoinColumn(name = "idtipo", referencedColumnName = "idtipo")
    @ManyToOne
    private Tiporeuniones idtipo;
    @JoinColumn(name = "idsalareunion", referencedColumnName = "idsalareunion")
    @ManyToOne
    private Salasreuniones idsalareunion;
    @JoinColumn(name = "dnicreador", referencedColumnName = "dni")
    @ManyToOne
    private Usuarios dnicreador;
    public static final String BUSCAR_REUNIONES = "Reuniones.findByIdreunion";
    public static final String BUSCAR_REUNIONESCREADOR = "Reuniones.findByReunionCreador";
    public static final String BUSCAR_INTERVENCIONESPORREUNION = "Reuniones.findIntervencionesByIdreunion";
    public static final String BUSCAR_REUNIONESUSUARIO = "Reuniones.findReunionesdeUsuarios";
    public static final String BUSCAR_REUNIONES_USUARIO_ANIO = "Reuniones.findReunionesdeUsuariosAnio";

    public Reuniones() {
    }

    public Reuniones(Date fechainicial, Date fechafinalestimada, Date fechafinalreal, Integer coste, Salasreuniones idsala) {
        this.fechainicial = fechainicial;
        this.fechafinalestimada = fechafinalestimada;
        this.fechafinalreal = fechafinalreal;
        this.coste = coste;
        this.idsalareunion = idsala;
    }

    public Reuniones(Date fechainicial, Date fechafinalestimada, Tiporeuniones idtipo, Salasreuniones idsalareunion, Usuarios dnicreador) {
        this.fechainicial = fechainicial;
        this.fechafinalestimada = fechafinalestimada;
        this.idtipo = idtipo;
        this.idsalareunion = idsalareunion;
        this.dnicreador = dnicreador;
        this.idreunion = new Integer(1);
    }

    public List<Adjunto> getAdjuntoCollection() {
        return adjuntoCollection;
    }

    public void setAdjuntoCollection(List<Adjunto> adjuntoCollection) {
        this.adjuntoCollection = adjuntoCollection;
    }

    public List<Asistenciareunion> getAsistenciareunionCollection() {
        return asistenciareunionCollection;
    }

    public void setAsistenciareunionCollection(List<Asistenciareunion> asistenciareunionCollection) {
        this.asistenciareunionCollection = asistenciareunionCollection;
    }

    public Integer getCoste() {
        return coste;
    }

    public void setCoste(Integer coste) {
        this.coste = coste;
    }

    public Usuarios getDnicreador() {
        return dnicreador;
    }

    public void setDnicreador(Usuarios dnicreador) {
        this.dnicreador = dnicreador;
    }

    public Date getFechafinalestimada() {
        return fechafinalestimada;
    }

    public void setFechafinalestimada(Date fechafinalestimada) {
        this.fechafinalestimada = fechafinalestimada;
    }

    public Date getFechafinalreal() {
        return fechafinalreal;
    }

    public void setFechafinalreal(Date fechafinalreal) {
        this.fechafinalreal = fechafinalreal;
    }

    public Date getFechainicial() {
        return fechainicial;
    }

    public void setFechainicial(Date fechainicial) {
        this.fechainicial = fechainicial;
    }

    public Date getFechainicialreal() {
        if(this.fechainicialreal==null){
            this.fechainicialreal=null;
        }
        return fechainicialreal;
    }

    public void setFechainicialreal(Date fechainicialreal) {
        this.fechainicialreal = fechainicialreal;
    }

    public Integer getIdreunion() {
        return idreunion;
    }

    public void setIdreunion(Integer idreunion) {
        this.idreunion = idreunion;
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

    public List<Puntosdeldia> getPuntosdeldiaCollection() {
        return puntosdeldiaCollection;
    }

    public void setPuntosdeldiaCollection(List<Puntosdeldia> puntosdeldiaCollection) {
        this.puntosdeldiaCollection = puntosdeldiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreunion != null ? idreunion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reuniones)) {
            return false;
        }
        Reuniones other = (Reuniones) object;
        if ((this.idreunion == null && other.idreunion != null) || (this.idreunion != null && !this.idreunion.equals(other.idreunion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd.Reuniones[ idreunion=" + idreunion + " ]";
    }
}
