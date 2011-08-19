/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author Zeyckler
 */
public class HolaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Creates a new instance of HolaBean */
    public HolaBean() {
        prueba = "MIERDA GATO";
    }

    public String getPrueba() {
        return prueba;
    }

    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }
    private String prueba;
}
