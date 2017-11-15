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
public class Log {
    public String logBuffer;
    public String logNome;
    
    public void escrevelog(String Text){}
    public boolean escreveArquivo(){
        return true;
    }
    public Log(String logName){
        this.logNome=logName;
    }
}
