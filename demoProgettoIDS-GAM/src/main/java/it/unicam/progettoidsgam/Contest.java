/*package it.unicam.progettoidsgam;

import it.unicam.progettoidsgam.PI;
import jakarta.persistence.Entity;

import java.io.IOException;
import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;

//DA SISTEMARE
@Entity
public class Contest extends Elemento {
    private String tipologia;
    private String titolo;
    private String descrizione;
    private Animatore creatore;
    private String idContest;
    private static int idCONPrecedente;
    private Duration durata;

   // private Invito invito;

    public Contest(String descrizione, String titolo, String tipologia, String piRiferimento, Animatore creatore, Duration durata) {
        super(descrizione, titolo, piRiferimento);
        this.creatore = creatore;
        this.tipologia = tipologia;
        this.durata = durata;
        setIdContest();
    }

    public Contest() {

    }


        public Contest(String descrizione, String titolo, String tipologia, String piRiferimento, Animatore creatore, Invito invito, Duration durata) {
            super(descrizione, titolo, piRiferimento);
            this.creatore = creatore;
            this.tipologia = tipologia;
          //  this.invito = invito;
            this.durata = durata;
            setIdContest();
        }

    public Duration getDurata() {
        return durata;
    }

    public void setDurata(Duration durata) {
        this.durata = durata;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }


    private void setIdContest() {
        super.setIdElemento("CON", idCONPrecedente);
        idCONPrecedente = idCONPrecedente + 1;

    }

    public Animatore getCreatore() {
        return creatore;
    }
}
    /*
    public void terminaEvento(ListaCondivisaElementoPubblicato lista,Contest c){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                lista.rimuoviEC(c);
                try {
                    lista.visualizza();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                timer.cancel();
            }
        },this.getDurata().toMillis());
    }
    public void visualizza(){
        if (idContest!=null){
            System.out.println(this.titolo+this.descrizione);
        }else{
            System.out.println("Il contest non esiste");
        }
    }
}

 */