package it.unicam.progettoidsgam;

import it.unicam.progettoidsgam.PI;
import jakarta.persistence.Entity;


import java.time.Duration;
import java.util.List;

//DA SISTEMARE
@Entity
public class Animatore extends Utente {

    private String nome;
    private String cognome;
    private static int idAPrecedente;


    public Animatore(String nome, String cognome, String nickname /*istaCondivisaNotifiche listaPersonale*/) {
        super(nickname /*listaPersonale*/);
        this.nome = nome;
        this.cognome = cognome;
        setIdAnimatore();
    }

    public Animatore() {

    }

    public String getIdAnimatore() {
        return super.getIdUtente();
    }

    public void setIdAnimatore() {
        super.setIdUtente("A", idAPrecedente);
        idAPrecedente += 1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getIdPrecedente() {
        return idAPrecedente;
    }
}
/*
    public Contest creaContest(PI pi, String tipologia, String titolo, String descrizione, Animatore animatore, Duration durata){
        return new Contest (descrizione, titolo, tipologia, pi, this,durata);
    }
    public List<Contributore> creaLista(/*DU){

        /*ipotetico database utenti chiamato DU
        List<Contributore> destinatari = new ArrayList<>;
        for(Utente u: DU){
            if(u.instanceOf(Contributore)){
                if(u.getAutorizzato){
                destinatari.add(u);
                }
            }
        }
        if(destinatari.isEmpty()){
            System.out.println("la lista è vuota");
            return null;
        }else{
        return destinatari;


        return null;
    }
    public Invito creaInvito(String descrizione, List<Contributore> destinatari, String idContest){
        return new Invito(descrizione, destinatari, idContest);
    }
    public Contest creaContestconInvito(PI pi, String tipologia, String titolo, String descrizione, Animatore animatore, Invito invito,ListaCondivisaNotifiche lcN,Duration durata){
        return new Contest (descrizione, titolo, tipologia, pi, this, invito,durata);
    }

    public void pubblicaContest(ListaCondivisaElementoPubblicato lCeP,String titolo, String descrizione,String tipologia, PI piRiferimento, Duration durata){
        Contest contest = creaContest(piRiferimento,tipologia,titolo,descrizione,this,durata);
        lCeP.aggiungiElemento(contest,null,this,null);
        System.out.println("il contest "+contest.getTitolo()+"è stato pubblicato");
    }
}
*/