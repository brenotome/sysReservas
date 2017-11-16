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
   
   public synchronized int[] visualizarAssentos(int idThread){
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
   public synchronized int alocarAssentoLivre(int idThread){
      try
      {
         monitor.entraEscritor();
      }
      catch(InterruptedException e)
      {
         System.err.print(e);  
      }
       Random rand = new Random();
       int r = rand.nextInt(numAssentos);
       if(this.assentos[r]!=0){
           System.out.println("Assento Ocupado");
           return 0;
       }else{
           this.assentos[r]=idThread;
       }
       StringBuilder sb= new StringBuilder();
       sb.append("2,");
       sb.append(idThread+',');
       sb.append(Arrays.toString(assentos));
       log.escrevelog(sb.toString());
      monitor.saiEscritor();
       return 1;
   }
    public synchronized int alocarAssentoDado(int idThread, int assento)
   {
         int retorno;
         try
         {
            monitor.entraEscritor();
         }
         catch(InterruptedException e)
         {
            System.err.print(e);  
         }
         if(this.assentos[assento]!=0)
         {
           System.out.println("Assento Ocupado");
           retorno = 0;
         }
         else
         {
            retorno = 1;
            this.assentos[assento] = idThread;
         }
         StringBuilder sb= new StringBuilder();
         sb.append("3,");
         sb.append(idThread+',');
         sb.append(Arrays.toString(assentos));
         log.escrevelog(sb.toString());
         monitor.saiEscritor();
         return retorno;
    }
   
   public synchronized int liberarAssento(int idThread, int assento)
   {
      int retorno;
        try
         {
            monitor.entraEscritor();
         }
         catch(InterruptedException e)
         {
            System.err.print(e);  
         }
         if(assentos[assento] == 0 || assentos[assento] != idThread)
         {
             retorno = 0;
         }
         else
         {
             retorno = 1;
             assentos[assento] = 0;
         }
         StringBuilder sb= new StringBuilder();
         sb.append("4,");
         sb.append(idThread+',');
         sb.append(Arrays.toString(assentos));
         log.escrevelog(sb.toString());
         monitor.saiEscritor();
         return retorno;
   }
    
}
