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
    private LinkedList<String> listapuntosdeldia;
    int posicion;

    {
        listapuntosdeldia = new LinkedList<String>();
        for (int i = 0; i < 10; i++) {
            listapuntosdeldia.add(i, "");
        }
        posicion = 0;
    }

    public LinkedList<String> getlistapuntosdeldia() {
        return listapuntosdeldia;
    }

    public void agregarNuevo() {
        if (this.posicion < 9) {
            this.posicion++;
        }
    }

    public void eliminaUltimo() {
        if (this.posicion > 0) {
            listapuntosdeldia.set(this.posicion, "");
            this.posicion--;
        }
        
    }

    public void contenidoLista() {
        System.out.println("\n======\nDebug\n======");
        System.out.println("Posicion: "+getPosicion());
        for (String a : listapuntosdeldia) {
            System.out.println(a);
        }
    }

    public void setlistapuntosdeldia(LinkedList<String> listapuntosdeldia) {
        this.listapuntosdeldia = listapuntosdeldia;
    }

    public LinkedList<String> getListapuntosdeldia() {
        return listapuntosdeldia;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    /** Creates a new instance of CreaReunionBean1 */
    public CreaReunionBean1() {
        listapuntosdeldia = new LinkedList<String>();
        for (int i = 0; i < 10; i++) {
            listapuntosdeldia.add(i, "");
        }
    }
}
