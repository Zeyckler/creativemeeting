/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Zeyckler
 */
public class CreaReunionBean1 implements Serializable {

    private static final long serialVersionUID = 1L;
    private LinkedList<String> listapuntosreunion;

    public LinkedList<String> getListapuntosreunion() {
        return listapuntosreunion;
    }

    public void setListapuntosreunion(LinkedList<String> listapuntosreunion) {
        this.listapuntosreunion = listapuntosreunion;
    }

    /** Creates a new instance of CreaReunionBean1 */
    public CreaReunionBean1() {
    }
}
