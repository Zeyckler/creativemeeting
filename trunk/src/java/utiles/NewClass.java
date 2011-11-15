/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingDeque;

/**
 *
 * @author AntonioCamacho
 */
public class NewClass {

    public static void main(String[] args) {
        
         
        Calendar a = Calendar.getInstance();
        int date = Calendar.DAY_OF_YEAR;
        int dia = a.get(date);
        
        System.out.print(dia);
        
        Date d1 = new Date( 111, 0, 1);
        Date d2 = new Date( 111, 0, 1);
        Date d3 = new Date( 111, 0, 1);
        Date d4 = new Date( 111, 0, 1);
        Date d5 = new Date( 111, 0, 1);
        
        List<Date> lista = new LinkedList<Date>();
        lista.add(d1);
        lista.add(d2);
        lista.add(d3);
        lista.add(d4);        
        lista.add(d5);
        
        
        
        
    }
}
