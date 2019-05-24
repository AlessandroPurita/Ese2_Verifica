/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ese2;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author purita_alessandro
 */
public class Ese2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            int num;
            System.out.println("Inserisci il numero di numeri da generare");
            num = input.nextInt();
            
            DatiCondivisi ptrDati = new DatiCondivisi(num);
            ThGenera thG = new ThGenera(ptrDati);
            ThVisualizza thVis = new ThVisualizza(ptrDati);
            ThNumPariLetti thNumPariLetti = new ThNumPariLetti(ptrDati);
            ThNumDispariLetti thNumDispariLetti= new ThNumDispariLetti(ptrDati);
            
            thG.start();
            thVis.start();
            thNumPariLetti.start();
            thNumDispariLetti.start();
            
            thG.join();
            thVis.join();
            thNumPariLetti.join();
            thNumDispariLetti.join();
            int zerolet=0;
            if( ptrDati.getNumDispariLetti()>ptrDati.getNumPariLetti())
            {
             zerolet= ptrDati.getNumDispariLetti()-ptrDati.getNumPariLetti();
            
            }
            if( ptrDati.getNumDispariLetti()>ptrDati.getNumPariLetti())
            {
             zerolet= ptrDati.getNumPariLetti()-ptrDati.getNumDispariLetti();
            
            }
            System.out.println("zero inseriti "+zerolet);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ese2.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
}
