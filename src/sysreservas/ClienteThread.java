/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysreservas;

import java.util.Random;

/**
 *
 * @author breno
 */
public class ClienteThread implements Runnable{
    private Log log;
    private Monitor monitor;
    private Assentos assentos;
    private int id;
    public ClienteThread(Log log, Monitor monitor,int id) {
        this.log = log;
        this.monitor = monitor;
        this.id = id;
    }
    
    @Override
    public void run() {
     while(!Thread.currentThread().isInterrupted()){
        try{
            switch(id){
                case 1:
                    this.thread1();
                case 2:
                    this.thread2();
                case 3:
                    this.thread3();
                case 4:
                    this.thread4();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        } 
      }
    }
    
    public void thread1(){
        assentos.visualizarAssentos(id);
    }
    public void thread2(){
        assentos.visualizarAssentos(id);
    }
    public void thread3(){
        assentos.visualizarAssentos(id);
    }
    public void thread4(){
        assentos.visualizarAssentos(id);
    }
    
    
}
