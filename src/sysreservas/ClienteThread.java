/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysreservas;


import java.util.Random;


public class ClienteThread implements Runnable{
    private Log log;
    private Monitor monitor;
    private Assentos assentos;
    private int id;
    public ClienteThread(Log log, Monitor monitor,Assentos assentos,int id) {
        this.log = log;
        this.monitor = monitor;
        this.id = id;
        this.assentos = assentos;
    }
    
    @Override
    public void run() {
        try{
            switch(id){
                case 1:
                    this.thread1();
                    break;
                case 2:
                    this.thread2();
                    break;
                case 3:
                    this.thread3();
                    break;
                case 4:
                    this.thread4();
                    break;
            }
        }catch (Exception e){} 
    }
    
    public void thread1(){
        System.out.println("Thread1");
        assentos.visualizarAssentos(id);
        Random rand = new Random();
        int r = rand.nextInt(assentos.numAssentos-1)+1;
        assentos.alocarAssentoDado(id,r);
        assentos.visualizarAssentos(id);
        assentos.liberarAssento(id, r);
    }
    public void thread2(){
        System.out.println("Thread2");
        Random rand = new Random();
        int r = rand.nextInt(assentos.numAssentos-1)+1;
        assentos.visualizarAssentos(id);
        assentos.alocarAssentoLivre(id);
        assentos.visualizarAssentos(id);
        assentos.liberarAssento(id, r);
    }
    public void thread3(){
        System.out.println("Thread3");
        Random rand = new Random();
        int r = rand.nextInt(assentos.numAssentos-1)+1;
        assentos.visualizarAssentos(id);
        assentos.alocarAssentoDado(id,r);
        assentos.visualizarAssentos(id);
        assentos.liberarAssento(id, r);
        assentos.alocarAssentoLivre(id);
        assentos.visualizarAssentos(id);
        r = rand.nextInt(assentos.numAssentos-1)+1;
        assentos.liberarAssento(id, r);
        
    }
    public void thread4(){
        System.out.println("Thread4");
        Random rand = new Random();
        int r = rand.nextInt(assentos.numAssentos-1)+1;
        assentos.visualizarAssentos(id);
        assentos.alocarAssentoLivre(id);
        assentos.visualizarAssentos(id);
        assentos.liberarAssento(id, r);
    }
    
    
}
