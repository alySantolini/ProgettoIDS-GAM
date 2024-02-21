package it.unicam.progettoidsgam;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Contest extends Elemento {
    private String tipologia;
    private String creatore;
    private static int idCONPrecedente;
    @OneToMany
    public static List<Elemento> elementiContest=new ArrayList<>();
    private Date dataInizio;
    private Date dataFine;
    private String titolo;
    private String descrizione;

    public Contest(String descrizione, String titolo, String tipologia, String piRiferimento, String creatore, Date inizio,Date fine) {
        super(descrizione, titolo, piRiferimento);
        this.creatore = creatore;
        this.tipologia = tipologia;
        this.elementiContest=null;
        this.dataInizio = inizio;
        this.dataFine= fine;
        setIdContest();
    }

    public Contest() {
        super();
    }

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
    public List<Elemento> getElementiContest() {
        return elementiContest;
    }

    public void setElementiContest(List<Elemento> elementiContest) {
        this.elementiContest = elementiContest;
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

