/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in tshe editor.
 */
package sysreservas;
import java.util.concurrent.*;

/**
 *
 * @author breno 
 */
public class SysReservas {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Log log = new Log("meulog");
        Assentos assentos = new Assentos(10,log);

    }
    public void thread0(){}
    public void thread1(){}
    public void thread2(){}
    public void thread3(){}
    public void thread4(){}
    
}
