package it.unicam.progettoidsgam.modelli;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Contest {
    private String tipologia;
    private String titolo;
    private String descrizione;
    private String piRiferimento;
    private String creatore;
    @Id
    private String idContest;
    private static int idCONPrecedente;
    @OneToMany
    public static List<Elemento> elementiContest=new ArrayList<>();
    private Date dataInizio;
    private Date dataFine;

    public Contest(String descrizione, String titolo, String tipologia, String piRiferimento, String creatore, Date inizio,Date fine) {
        this.creatore = creatore;
        this.tipologia = tipologia;
        this.titolo=titolo;
        this.descrizione=descrizione;
        this.piRiferimento=piRiferimento;
        this.elementiContest=null;
        this.dataInizio = inizio;
        this.dataFine= fine;
        setIdContest();
    }

    public Contest(){}

  /*  @Override
    public void creazione() {
        System.out.println("Creato");
    }

   */

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getPiRiferimento() {
        return piRiferimento;
    }

    public void setPiRiferimento(String piRiferimento) {
        this.piRiferimento = piRiferimento;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }
    public void setIdContest() {
        idContest="CON"+idCONPrecedente;
        idCONPrecedente +=1;

    }
    public List<Elemento> getElementiContest() {
        return elementiContest;
    }

    public void setElementiContest(List<Elemento> elementiContest) {
        this.elementiContest = elementiContest;
    }

    public String getIdContest() {
        return idContest;
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

