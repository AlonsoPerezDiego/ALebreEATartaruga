/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lebre_e_tartaruga;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class Carreira {
    
    private int casillaL, casillaT;

    public Carreira() {
        casillaL = 1;
        casillaT = 1;
    }
    
    public synchronized void correndo(boolean lebre){
        while(casillaL < 70  && casillaT < 70){
            if(lebre){
                casillaL += movementoLebre();
                if(casillaL<0)
                    casillaL=0;
                if(casillaL>70)
                    casillaL=70;
                System.out.println("L: " + casillaL);
                try {
                    espera();
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Carreira.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                casillaT += movementoTartaruga();
                System.out.println("T: " + casillaT);
                if(casillaT<0)
                    casillaT=0;
                if(casillaT>70)
                    casillaT=70;
                try {
                    espera();
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Carreira.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        }
        System.exit(0);
    }
    
    private int movementoLebre(){
        int movemento, estadistica;
        estadistica = (int)(Math.random()*10);
        if(estadistica==0||estadistica==1)
            movemento = 0;
        else if(estadistica == 2|| estadistica==3)
            movemento = 9;
        else if(estadistica==4)
            movemento = -12;
        else if(estadistica>=5 || estadistica<=7)
            movemento = 1;
        else
            movemento = -2;
        
        return movemento;
    }
    
    private int movementoTartaruga(){
        int movemento, estadistica;
        estadistica = (int)(Math.random()*10);
        if(estadistica >= 0|| estadistica<=5)
            movemento = 3;
        else if(estadistica == 6|| estadistica==7)
            movemento = -6;
        else
            movemento = 1;
        
        return movemento;
    }
    
    private void espera(){
        try {
            Thread.sleep(1000);
            notify();
        } catch (InterruptedException ex) {
            Logger.getLogger(Carreira.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
