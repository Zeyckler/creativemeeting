/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Zeyckler
 */
@ManagedBean
@SessionScoped
public class TiposReunionBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String tipodefault = "Reunión General";
    private String tipos[] = {"Reunión General"/*,"Análisis Delphi","7 Sombreros","Tormenta de Ideas"*/};

    /** Creates a new instance of PaisesBean */
    public TiposReunionBean() {
    }

    public String getTipodefault() {
        return tipodefault;
    }

    public void setTipodefault(String tipodefault) {
        this.tipodefault = tipodefault;
    }

    public String[] getTipos() {
        return tipos;
    }

    public void setTipos(String[] tipos) {
        this.tipos = tipos;
    }
}
