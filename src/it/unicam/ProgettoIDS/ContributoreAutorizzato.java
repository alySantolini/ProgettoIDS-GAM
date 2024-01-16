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
    public void creaContenuto(File file, String titolo, String descrizione){
        if(file!=null) {
            Contenuto contenuto=new Contenuto(file, titolo, descrizione, "immagine");
            pubblicazioneContenuto(contenuto);
        }
        Contenuto contenuto=new Contenuto(titolo,descrizione,"commento");
        pubblicazioneContenuto(contenuto);
    }

    public void pubblicazioneContenuto(Contenuto contenuto){
       System.out.println("Il contenuto"+ contenuto.getTitolo()+"è stato pubblicato");
    }

    public void creaEsperienza(String tipologia, String titolo, String descrizione, List<PI> listaPI){
        Esperienza esperienza=new Esperienza(tipologia, titolo, descrizione, listaPI);
        pubblicazioneEsperienza(esperienza);
    }

    public void pubblicazioneEsperienza(Esperienza esperienza){
        System.out.println("l'esperienza"+esperienza.getTitolo()+"è stata pubblicata");
    }

    public void creaPI(String titolo, String descrizione, String longitudine,String latitudine){
        PI pi= new PI(descrizione, titolo, longitudine, latitudine);
        pubblicazionePI(pi);
    }

    public void pubblicazionePI(PI pi){
        System.out.println("Il PI"+pi.getTitolo()+"è stato pubblicato");
    }

    public void creaSegnalazione(ListaCondivisaSegnalazioni listaCondivisa, Contenuto e,String descrizione){
        Segnalazione segnalazione= new Segnalazione(e.getIdContenuto(),descrizione);
        listaCondivisa.aggiungiSegnalazione(segnalazione, this, null);
    }

}
