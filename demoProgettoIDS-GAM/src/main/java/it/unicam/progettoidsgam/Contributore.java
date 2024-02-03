package it.unicam.progettoidsgam;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.File;
import java.time.Duration;
import java.util.List;

//DA SISTEMARE
@Entity
public class Contributore extends Utente {

    private String nome;
    private String cognome;
    private String nickname;
    private static int idCPrecedente;

    private boolean autorizzato;


    public Contributore(String nome, String cognome, String nickname, boolean autorizzato/*ListaCondivisaNotifiche listaPersonale*/) {
        super(nickname/*listaPersonale*/);
        this.autorizzato = autorizzato;
        this.nome = nome;
        this.cognome = cognome;
        setIdContributore();
    }

    public Contributore() {

    }

    public String getIdContributore() {

        return super.getIdUtente();
    }

    public int getIdPrecedente() {
        return idCPrecedente;
    }


    public void setIdContributore() {
        super.setIdUtente("C", idCPrecedente);
        idCPrecedente += 1;
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

    public boolean getAutorizzato() {
        return this.autorizzato;
    }

    public boolean authenticate(String nickname, String password) {
        return this.nickname.equals(nickname) && this.getIdContributore().equals(password);
    }
 /*   public Contenuto creaContenuto( File file,String titolo, String descrizione,PI piRiferimento){
        if(file!=null) {
            return new Contenuto(file, titolo, descrizione, "immagine",piRiferimento);
        }
        return new Contenuto(titolo,descrizione,"commento",piRiferimento);
    }

    public void pubblicazioneContenuto(ListaCondivisaElemento lcE,ListaCondivisaElementoPubblicato lCeP,File file,String titolo,String descrizione,PI piRiferimento) {
        Contenuto c = creaContenuto(file, titolo, descrizione, piRiferimento);
        if (autorizzato) {
            lCeP.aggiungiElemento(c, this, null,null);
            piRiferimento.aggiungi(c);
            System.out.println("Il contenuto" + c.getTitolo() + "è stato pubblicato");
        }else{this.richiestaAutorizzazione( lcE, c);
            }

    }
    public Esperienza creaEsperienza(String tipologia, String titolo, String descrizione, List<PI> listaPI){
        return new Esperienza(tipologia, titolo, descrizione, listaPI);
    }
    public void pubblicazioneEsperienza(ListaCondivisaElemento lcE, ListaCondivisaElementoPubblicato lCeP,String tipologia,String titolo,String descrizione, List<PI> listaPI){
        Esperienza e= creaEsperienza(tipologia,titolo,descrizione,listaPI);
        if (autorizzato) {
        lCeP.aggiungiElemento(e,this,null,null);
        listaPI.get(0).aggiungi(e);
        System.out.println("l'esperienza"+e.getTitolo()+"è stata pubblicata");
        }else{
            richiestaAutorizzazione(lcE, e);
        }
    }
    public PI creaPI(String titolo, String descrizione, String tipologia,String longitudine,String latitudine){
        return new PI(descrizione, titolo,tipologia, longitudine, latitudine);
    }
    public void pubblicazionePI(ListaCondivisaElemento lcE, ListaCondivisaElementoPubblicato lCeP,String titolo, String descrizione, String longitudine,String latitudine,String tipologia){
        PI pi = creaPI(descrizione, titolo,tipologia, longitudine,latitudine);
        if(autorizzato){
        lCeP.aggiungiElemento(pi,this,null,null);
        System.out.println("Il PI"+pi.getTitolo()+"è stato pubblicato");
    }else{
            richiestaAutorizzazione(lcE,pi);
        }
    }

    public Evento creaEvento(String titolo, String descrizione, PI piRiferimento, Duration durata){
        return new Evento(descrizione,titolo,piRiferimento,durata);
    }

    public void pubblicazioneEvento(ListaCondivisaElemento lcE, ListaCondivisaElementoPubblicato lCeP,String titolo, String descrizione, PI piRiferimento, Duration durata){
        Evento evento = creaEvento(titolo,descrizione,piRiferimento,durata);
        if(autorizzato){
            lCeP.aggiungiElemento(evento,this,null,null);
            System.out.println("L'evento "+evento.getTitolo()+"è stato pubblicato");
        }
        else{
            richiestaAutorizzazione(lcE,evento);
        }
    }

   public void richiestaAutorizzazione(ListaCondivisaElemento listaCondivisa,Elemento e){
        listaCondivisa.aggiungiElemento(e, this, null);
   }*/
}
