/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lebre_e_tartaruga;

/**
 *
 * @author Diego
 */
public class Lebre_e_Tartaruga {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carreira obj = new Carreira();
        Fios t1 = new Fios(obj, true);
        Fios t2 = new Fios(obj, false);
        
        t1.start();
        t2.start();
    }
    
}
