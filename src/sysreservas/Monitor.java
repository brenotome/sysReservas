package sysreservas;

public class Monitor
{
    private int leitores;
    private int escritores;
    private int req_escrita;
    
    Monitor()
    {
        this.leitores = 0;
        this.escritores = 0;
        this.req_escrita = 0;
    }

    public synchronized void entraLeitor() throws InterruptedException
    {
        while(escritores > 0 || req_escrita >0) wait();
        leitores++;
    }
    public synchronized void saiLeitor()
    {
        leitores--;
        notifyAll();
    }
    public synchronized void entraEscritor() throws InterruptedException
    {
        req_escrita++;
        while(leitores > 0 || escritores > 0) wait();
        req_escrita--;
        escritores++;
    }
    public synchronized void saiEscritor()
    {
        escritores--;
        notifyAll();
    }
}
