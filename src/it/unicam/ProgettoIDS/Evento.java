/*package it.unicam.ProgettoIDS;

import it.unicam.progettoidsgam.PI;

import java.io.IOException;
import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;

public class Evento extends Elemento{
    private String idEvento;
    private static int idEPrecedente;
    private Duration durata;

    public Evento(String descrizione, String titolo, PI piRiferimento, Duration durata) {
        super(descrizione, titolo, piRiferimento);
        this.durata = durata;
        setIdEvento();
    }


    public void setIdEvento() {
        super.setIdElemento("EV",idEPrecedente);
        idEPrecedente +=1;
    }

    public Duration getDurata() {
        return durata;
    }

    public void setDurata(Duration durata) {
        this.durata = durata;
    }
    public void terminaEvento(ListaCondivisaElementoPubblicato lista,Evento e){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                lista.rimuoviEC(e);
                try {
                    lista.visualizza();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                timer.cancel();
            }
        },this.getDurata().toMillis());
    }
    @Override
    public void visualizza() throws IOException {
        if (this.getIdElemento()!=null){
            System.out.println(this.getTitolo()+this.getDescrizione()+this.getDurata());
        }else{
            System.out.println("L'evento non esiste");
        }
    }


}

 */
