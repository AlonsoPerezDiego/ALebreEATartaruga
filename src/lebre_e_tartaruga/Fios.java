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
public class Fios extends Thread{
    
    Carreira obj;
    Boolean lebre;

    public Fios(Carreira obj, Boolean lebre) {
        this.obj = obj;
        this.lebre = lebre;
    }
    
    public void run(){
        obj.correndo(lebre);
    }
    
}
