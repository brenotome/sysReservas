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
    private SysReservas reservas;
    public ClienteThread(SysReservas reservas) {
        this.reservas = reservas;
    }
    
    @Override
    public void run() {
     while(!Thread.currentThread().isInterrupted()){
        try{
            Random rand = new Random();
            int r = rand.nextInt(3)+1;
            switch(r){
                case 1:
                    reservas.thread1();
                case 2:
                    reservas.thread2();
                case 3:
                    reservas.thread3();
                case 4:
                    reservas.thread4();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        } 
      }
    }
    
    
    
    
}
