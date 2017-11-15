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
public class Monitor {
   public static int leitores;
   public static int escritores;
   public static int pedidosEscrita;
   
   public static boolean readlock(int idThread) {
     return true;  
   };
   public static void readUnlock(int idThread){}

   public static boolean writelock(int idThread) {
     return true;  
   };
   public static void writeUnlock(int idThread){}
   
}
