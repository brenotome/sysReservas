/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysreservas;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author breno
 */
public class Assentos {
   public int[] assentos;
   public int numAssentos;
   private Log log;
   private Monitor monitor;

    Assentos(int numAssentos, Log log, Monitor monitor) {
        this.assentos=new int[numAssentos];
        this.log = log;
        this.numAssentos = numAssentos;
        this.monitor=monitor;
    }
   
   public int[] visualizarAssentos(int idThread){
        try
        {
            monitor.entraLeitor();
        }
        catch(Exception e){}
        
        StringBuilder sb= new StringBuilder();
        sb.append("1,");
        sb.append(idThread+',');
        sb.append(Arrays.toString(assentos)); // faz o output  ficar no formato [0,0,1,1]
        log.escrevelog(sb.toString());
        monitor.saiLeitor();
       return this.assentos;
   }
   public int alocarAssentoLivre(int idThread){
       Random rand = new Random();
       int r = rand.nextInt(numAssentos);
       if(this.assentos[r]==0){
           System.out.println("Assento Ocupado");
           return 0;
       }else{
           this.assentos[r]=idThread;
       }
       StringBuilder sb= new StringBuilder();
       sb.append("2,");
       sb.append(idThread+',');
       sb.append(assentos);
       log.escrevelog(sb.toString());
       return 1;
   }
   public void alocarAssentoDado(int idThread, int assento){}
   public void liberarAssento(int idThread, int assento){}
    
}
