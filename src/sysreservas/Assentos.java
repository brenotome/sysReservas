/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysreservas;

/**
 *
 * @author breno
 */
public class Assentos {
   public int[] assentos;
   
   public int[] visualizarAssentos(int idThread){
      try
        {
            monitor.entraLeitor();
        }
        catch(InterruptedException e)
        {
            
        }
        log.escrevelog("1");
        log.escrevelog(Integer.ToString(idThread));
        for(int i = 0; i < numAssentos; i++)
        {
             //log.escrevelog(Integer.toString(assentos[i]);
        }
        monitor.saiLeitor();
       return this.assentos;
   }
   public void alocarAssentoLivre(int idThread){}
   public void alocarAssentoDado(int idThread, int assento){}
   public void liberarAssento(int idThread, int assento){}
   public void Assentos(int numAssentos){}
    
}
