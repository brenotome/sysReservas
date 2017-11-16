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
public class ClienteThread implements Runnable{

    @Override
    public void run() {
     while(!Thread.currentThread().isInterrupted()){
        try{
            //thread code
        }catch (Exception e){
            //exception 
        } 
      }
    }
    
    
}
