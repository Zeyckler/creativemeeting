/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author AntonioCZ
 */
public class Fila <T> {
    
    private T tipo;
    private boolean seleccionada;

    public Fila(T tipo, boolean seleccionada) {
        this.tipo = tipo;
        this.seleccionada = seleccionada;
    }
    
    public boolean isSeleccionada() {
        return seleccionada;
    }

    public void setSeleccionada(boolean seleccionada) {
        this.seleccionada = seleccionada;
    }

    public T getTipo() {
        return tipo;
    }

    public void setTipo(T tipo) {
        this.tipo = tipo;
    }
   
  
    
    
    
}
