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
public class Thread0 implements Runnable {
    private Log log;
    
    Thread0(Log log) {
        this.log = log;
    }

    @Override
    public void  run() {
        while(!Thread.currentThread().isInterrupted()){
        try{
            log.escreveArquivo();
        }catch (Exception e){
            System.out.println("th zero erro");
        } 
      }
    }
}
