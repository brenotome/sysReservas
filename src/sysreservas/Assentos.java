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
       return this.assentos;
   }
   public void alocarAssentoLivre(int idThread){}
   public void alocarAssentoDado(int idThread, int assento){}
   public void liberarAssento(int idThread, int assento){}
   public void Assentos(int numAssentos){}
    
}
