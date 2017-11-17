package sysreservas;
import java.util.concurrent.*;
/**
 * 
 * @author Breno Tomé e Ricardo Bayer
 */


public class SysReservas {
    
    private Assentos assentos;
    /**
     * Classe principal, cria instancias do monitor, log e assentos 
     * depois cria e inicia 4 threads clientes e uma thread de log (Thread0)
     * @param args 
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
