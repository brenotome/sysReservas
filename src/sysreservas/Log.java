/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysreservas;

import java.io.PrintWriter;

/**
 *
 * @author breno
 */
public class Log {
    public StringBuffer logBuffer;
    public String logNome;
    private PrintWriter writer;
    
    Log(String logName){
        this.logNome=logName;
        try{
            PrintWriter writer = new PrintWriter(logName+".txt", "UTF-8");
            this.writer=writer;
        }catch(Exception e){
            System.out.println("erro ao criar arquivo");
        }

    }
    public void escrevelog(String text){
        this.logBuffer.append(text);
                this.logBuffer.append(System.lineSeparator());
    }
    public boolean escreveArquivo(){
        try{
                writer.println(this.logBuffer);
                writer.close();
        }
        catch(Exception e){System.out.println("erro de escrita no arquivo");return false;}
        return true;
    }
}
