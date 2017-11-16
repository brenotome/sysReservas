
package sysreservas;

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
    Log(String logName){
        this.logNome=logName;
        this.logBuffer = new StringBuffer();
        try{
            PrintWriter writer = new PrintWriter(logName+".txt", "UTF-8");
            this.writer=writer;
//            this.writer.close();
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
     * @return falso quando ocorre erro
     */
    public synchronized void escreveArquivo() {
        
            if(logBuffer.length()>0){
                writer.println(logBuffer.toString());
                logBuffer.setLength(0);
                //writer.close();
                //System.out.println(this.logBuffer);
            }
        }
              
    }

