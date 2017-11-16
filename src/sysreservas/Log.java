
package sysreservas;

import java.io.FileWriter;
import java.io.PrintWriter;

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
    Log(String logNome){
        this.logNome=logNome;
        this.logBuffer = new StringBuffer();
        try{
            PrintWriter writer = new PrintWriter(logNome+".py", "UTF-8");
            this.writer=writer;
            this.writer.println("import funcoes as fp");
            this.writer.close();
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

        
    }
    /**
     * escreve buffer em arquivo
     */
    public synchronized void escreveArquivo() {
            try{
            if(logBuffer.length()>0){
                PrintWriter writer = new PrintWriter(new FileWriter(logNome+".py", true));
                writer.println(logBuffer.toString());
                //writer.append(logNome);
                logBuffer.setLength(0);
                writer.close();
            }
            }catch(Exception e){}
        }
              
    }

