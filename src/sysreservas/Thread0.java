/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysreservas;

/**
 * Thread responsavel por chamar a função log.escreve arquivo, que por sua vez
 * escreve o conteudo do buffer para um arquivo de texto
 * @author Breno Tomé e Ricardo Bayer
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
