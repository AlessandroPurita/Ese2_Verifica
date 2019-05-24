/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ese2;

import java.util.Random;

/**
 *
 * @author purita_alessandro
 */
public class ThGenera extends Thread {
     DatiCondivisi ptrDati;
    int num;
    int buffer;

    public ThGenera(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
        this.num = ptrDati.getNum();
        this.buffer=ptrDati.getBuffer();
    }
    
    @Override
    public void run()
    {
    Random rand = new Random();
        for(int i = 0; i < num; i++)
        {
        ptrDati.waitSem4();
        buffer=rand.nextInt(10);
        if(buffer %2 == 0)
        {
        ptrDati.incNumPariIns();
        
        }
        else
        {
        ptrDati.incNumDispariIns();
        
        }
        ptrDati.setBuffer(buffer);
        ptrDati.signalSem1();
        
        
        }
        
        
    
    }
    
}
