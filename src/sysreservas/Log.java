
package sysreservas;

import java.io.PrintWriter;
import java.nio.file.FileSystemException;

/**
 * Classe salva log no buffer depois salva o buffer em arquivo de texto
 * @author breno
 */
public class Log {
    public StringBuffer logBuffer;
    public String logNome;
    private PrintWriter writer;
    
    /**
     * Cria arquivo
     * @param logName 
     */
    Log(String logName){
        this.logNome=logName;
        try{
            PrintWriter writer = new PrintWriter(logName+".txt", "UTF-8");
            this.writer=writer;
        }catch(Exception e){
            System.out.println("erro ao criar arquivo");
        }

    }
    /**
     * escreve o parametro para o Buffer, a classe logBuffer é threadSafe 
     * @param text 
     */
    public synchronized void escrevelog(String text){
        this.logBuffer.append(text);
        //this.logBuffer.append(System.lineSeparator());
        this.logBuffer.append("/n");
    }
    /**
     * escreve buffer em arquivo
     * @return falso quando ocorre erro
     */
    public synchronized void escreveArquivo() throws FileSystemException{
        try{
            if(this.logBuffer.length()>0){
                writer.println(this.logBuffer);
                //System.out.println(this.logBuffer);
            }
        }
        catch(Exception e){System.out.println(e.getMessage());}        
    }
}
