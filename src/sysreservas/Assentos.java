/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysreservas;


import java.util.Arrays;
import java.util.Random;

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
   
   public synchronized void visualizarAssentos(int idThread){
        try
        {
            monitor.entraLeitor();
            StringBuilder sb= new StringBuilder();
            
            sb.append("vet=");
            sb.append(Arrays.toString(assentos)); // faz o output  ficar no formato [0,0,1,1]
            sb.append(";");
            sb.append("fp.op1(");
            sb.append(idThread);
            sb.append(",vet);");
            System.out.println(sb.toString());
            log.escrevelog(sb.toString());
            monitor.saiLeitor();
        }
        catch(InterruptedException e){}
        

   }
   public synchronized int alocarAssentoLivre(int idThread){
      try
      {
        monitor.entraEscritor();
        Random rand = new Random();
        int r = rand.nextInt(numAssentos);
        if(this.assentos[r]!=0){
        System.out.println("Assento Ocupado");
        return 0;
        }else{
         this.assentos[r]=idThread;
        }
       
        StringBuilder sb= new StringBuilder();
        sb.append("vet=");
        sb.append(Arrays.toString(assentos)); // faz o output  ficar no formato [0,0,1,1]
        sb.append(";");
        sb.append("fp.op2(");
        sb.append(idThread);sb.append(",");sb.append(r);
        sb.append(",vet);");
        System.out.println(sb.toString());
        log.escrevelog(sb.toString());
        monitor.saiEscritor();
        return 1;
      }
      catch(InterruptedException e)
      {
         System.err.print(e);  
      }
      return 0;
   }
    public synchronized int alocarAssentoDado(int idThread, int assento)
   {
         int retorno;
         try
         {
            monitor.entraEscritor();
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
            sb.append("vet=");
            sb.append(Arrays.toString(assentos)); // faz o output  ficar no formato [0,0,1,1]
            sb.append(";");
            sb.append("fp.op3(");
            sb.append(idThread);sb.append(",");sb.append(assento);
            sb.append(",vet);");
            System.out.println(sb.toString());
            log.escrevelog(sb.toString());
            monitor.saiEscritor();
            return retorno;
         }
         catch(InterruptedException e)
         {
            System.err.print(e);  
         }
         return 0;
    }
   
   public synchronized int liberarAssento(int idThread, int assento)
   {
      int retorno=0;
        try
         {
            monitor.entraEscritor();
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
            sb.append("vet=");
            sb.append(Arrays.toString(assentos)); // faz o output  ficar no formato [0,0,1,1]
            sb.append(";");
            sb.append("fp.op3(");
            sb.append(idThread);sb.append(",");sb.append(assento);
            sb.append(",vet);");
            System.out.println(sb.toString());
            log.escrevelog(sb.toString());
            monitor.saiEscritor();
         }
         catch(InterruptedException e)
         {
            System.err.print(e);  
         }
         
         
         return retorno;
   }
    
}
