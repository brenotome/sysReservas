package sysreservas;
import java.util.concurrent.*;

import java.util.concurrent.*;


public class SysReservas {
    private Assentos assentos;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        Log log = new Log("meulog");
        Assentos assentos = new Assentos(5,log,monitor);
        Thread th[] = new Thread[4];
        Thread tz;
        tz = new Thread(new Thread0(log));
        
        for(int i=0; i<4;i++){
            th[i]=new Thread(new ClienteThread(log,monitor,assentos,i+1));
        }
         tz.start();
        for(int i=0; i<4;i++){
            th[i].start();
        }
       

    }

    
}
