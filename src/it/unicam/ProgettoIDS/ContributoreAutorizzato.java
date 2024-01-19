package it.unicam.ProgettoIDS;

import java.io.File;
import java.util.List;

public class ContributoreAutorizzato {

    private String idContributore;
    private String nome;
    private String cognome;
    private String nomeUtente;
    private static int idCAPrecedente;
    private boolean autorizzato=true;

    public ContributoreAutorizzato(String nome, String cognome, String nomeUtente) {
        this.nome = nome;
        this.cognome = cognome;
        this.nomeUtente = nomeUtente;
        setIdContributore();
    }

    public String getIdContributore() {
        return idContributore;
    }

    private void setIdContributore() {
        this.idContributore = "CA" + idCAPrecedente;
        idCAPrecedente +=1;
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

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public boolean getAutorizzato(){
        return autorizzato;
    }
    public Contenuto creaContenuto(File file, String titolo, String descrizione){
        if(file!=null) {
            return new Contenuto(file, titolo, descrizione, "immagine");
        }
        return new Contenuto(titolo,descrizione,"commento");

    }

    public void pubblicazioneContenuto(ListaCondivisaElementoPubblicato lCeP,File file,String titolo,String descrizione){
        Contenuto c= creaContenuto(file,titolo,descrizione);
        lCeP.aggiungiElemento(c,this,null);
        System.out.println("Il contenuto"+ c.getTitolo()+"è stato pubblicato");
    }

    public Esperienza creaEsperienza(String tipologia, String titolo, String descrizione, List<PI> listaPI){
        return new Esperienza(tipologia, titolo, descrizione, listaPI);

    }

    public void pubblicazioneEsperienza(ListaCondivisaElementoPubblicato lCeP,String tipologia,String titolo,String descrizione, List<PI> listaPI){
        Esperienza e= creaEsperienza(tipologia,titolo,descrizione,listaPI);
        lCeP.aggiungiElemento(e,this,null);
        System.out.println("l'esperienza"+e.getTitolo()+"è stata pubblicata");
    }

    public PI creaPI(String titolo, String descrizione, String longitudine,String latitudine){
        return new PI(descrizione, titolo, longitudine, latitudine);

    }

    public void pubblicazionePI(ListaCondivisaElementoPubblicato lCeP,String titolo, String descrizione, String longitudine,String latitudine){
        PI pi = creaPI(titolo, descrizione, longitudine,latitudine);
        lCeP.aggiungiElemento(pi,this,null);
        System.out.println("Il PI"+pi.getTitolo()+"è stato pubblicato");
    }

    public Segnalazione creaSegnalazione(ListaCondivisaSegnalazioni listaCondivisa, Contenuto e,String descrizione){
        Segnalazione segnalazione= new Segnalazione(e.getIdContenuto(),descrizione);
        listaCondivisa.aggiungiSegnalazione(segnalazione, null, this,null,null);
        return segnalazione;
    }

}
