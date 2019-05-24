/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ese2;

/**
 *
 * @author purita_alessandro
 */
public class ThNumDispariLetti extends Thread{
    DatiCondivisi ptrDati;
    int num;
    int buffer;

    public ThNumDispariLetti(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
        this.num = ptrDati.getNum();
        this.buffer = ptrDati.getBuffer();
    }
    @Override
    public void run()
    {
    for(int i = 0; i < num; i++)
    {
    ptrDati.waitSem2();
    buffer=ptrDati.getBuffer();
    if(buffer%2 != 0)
    {
    ptrDati.incNumDispariLetti();
    
    }
    ptrDati.signalSem3();
    
    }
    
    
    }
}
