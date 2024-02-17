package it.unicam.progettoidsgam;

import jakarta.persistence.Entity;
import java.time.Duration;
import java.util.Date;

//DA SISTEMARE
@Entity
public class Contest extends Elemento {
    private String tipologia;
    private String creatore;
    private static int idCONPrecedente;
    private Date dataInizio;
    private Date dataFine;
    // private Invito invito;

    public Contest(String descrizione, String titolo, String tipologia, String piRiferimento, String creatore, Date inizio,Date fine) {
        super(descrizione, titolo, piRiferimento);

        this.creatore = creatore;
        this.tipologia = tipologia;
        this.dataInizio = inizio;
        this.dataFine= fine;
        if (inizio.after(fine)) {
            throw new IllegalArgumentException("La data di inizio deve essere precedente alla data di fine.");
        }
        setIdContest();
    }

    public Contest() {
        super();
    }

    /*   public Contest(String descrizione, String titolo, String tipologia, String piRiferimento, Animatore creatore /*Invito invito, Duration durata) {
           super(descrizione, titolo, piRiferimento);
           this.creatore = creatore;
           this.tipologia = tipologia;
           //  this.invito = invito;
           this.durata = durata;
           setIdContest();
       }
   */
    public Date getDataInizio() {
        return dataInizio;
    }
    public Date getDataFine() {
        return dataFine;
    }
    public void setIdContest() {
        super.setIdElemento("CON",idCONPrecedente);
        idCONPrecedente +=1;

    }
    public String getIdContest() {
        return super.getIdElemento();
    }

    public void setDataInizio(Date inizio) {
        this.dataInizio = inizio;
    }
    public void setDataFine(Date fine) {
        this.dataFine = fine;
    }
    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public void setCreatore(String creatore) {
        this.creatore = creatore;
    }


    public String getCreatore() {
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
}*/

