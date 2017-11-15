/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysreservas;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author breno
 */
public class Log {
    public StringBuffer logBuffer;
    public String logNome;
    private PrintWriter writer;
    
    public void escrevelog(String text){
        logBuffer.append(System.lineSeparator());
        this.logBuffer.append(text);
    }
    public boolean escreveArquivo(){
        try{
                writer.println(this.logBuffer);
        }
        catch(Exception e){System.out.println("erro de escrita no arquivo");return false;}
        return true;
    }
    public Log(String logName){
        this.logNome=logName;
        try{
            PrintWriter writer = new PrintWriter(logName+".txt", "UTF-8");
            this.writer=writer;
        }catch(Exception e){
            System.out.println("erro ao criar arquivo");
        }

    }
}
