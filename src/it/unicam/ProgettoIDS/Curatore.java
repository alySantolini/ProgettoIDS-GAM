package it.unicam.ProgettoIDS;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Curatore {
    private String idCuratore;
    private String nome;
    private String cognome;
    private String nomeUtente;



    public Curatore(String nome, String cognome, String nomeUtente) {
        this.idCuratore = "CU001";
        this.nome = nome;
        this.cognome = cognome;
        this.nomeUtente = nomeUtente;
    }

    public String getIdCuratore() {
        return idCuratore;
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

    public void autorizzazione(ListaCondivisaElementoPubblicato lCeP,ListaCondivisaElemento listaCondivisa,String idRichiesta /*controlla commento notifica autorizzazione*/){
        Contenuto e = listaCondivisa.getElementoFromId(idRichiesta);
        listaCondivisa.rimuoviElemento(e,this);
        lCeP.aggiungiElemento(e,null,this); //"pubblico" l'elemento
        notificaAutorizzazione(idRichiesta);
    }
    public void gestioneSegnalazione(ListaCondivisaSegnalazioni listaSegnalazione, ListaCondivisaElementoPubblicato lCeP,String idSegnalazione){
        Segnalazione s = listaSegnalazione.getSegnalazioneFromId(idSegnalazione);
        String idEl = s.getIdElemento();// da mettere poi nella classi ListaCondivisaA (LCA) e LCEP
        Contenuto e = lCeP.getElementoFromId(idEl); // per il momento do per scontato che ogni segnalazione sia veritiera, quando/se  implementeremo la possibilità
        lCeP.rimuoviElemento(e,this); //di avere imput da tastiera il curatore potrà scegliere se eliminare o no l'elemento
        listaSegnalazione.rimuoviSegnalazione(s, this);
        notificaSegnalazione(s.getIdSegnalazione());
    }
    public void controlloLista(ListaCondivisaElemento listaCondivisa) throws IOException {

        listaCondivisa.getLista();
    }
    public void controlloLista(ListaCondivisaSegnalazioni listaCondivisa) throws IOException {

        listaCondivisa.getLista();
    }
    public void controlloLista(ListaCondivisaElementoPubblicato listaCondivisa) throws IOException {

        listaCondivisa.getLista();
    }
    public Contenuto creaContenuto(File file, String titolo, String descrizione){
        if(file!=null) {
            return new Contenuto(file, titolo, descrizione, "immagine");
        }
        return new Contenuto(titolo,descrizione,"commento");

    }

    public void pubblicazioneContenuto(ListaCondivisaElementoPubblicato lCeP,File file,String titolo,String descrizione){
        Contenuto c= creaContenuto(file,titolo,descrizione);
        lCeP.aggiungiElemento(c,null,this);
        System.out.println("Il contenuto"+ c.getTitolo()+"è stato pubblicato");
    }

    public Esperienza creaEsperienza(String tipologia, String titolo, String descrizione, List<PI> listaPI){
        return new Esperienza(tipologia, titolo, descrizione, listaPI);

    }

    public void pubblicazioneEsperienza(ListaCondivisaElementoPubblicato lCeP,String tipologia,String titolo,String descrizione, List<PI> listaPI){
        Esperienza e= creaEsperienza(tipologia,titolo,descrizione,listaPI);
        lCeP.aggiungiElemento(e,null,this);
        System.out.println("l'esperienza"+e.getTitolo()+"è stata pubblicata");
    }

    public PI creaPI(String titolo, String descrizione, String longitudine,String latitudine){
        return new PI(descrizione, titolo, longitudine, latitudine);

    }

    public void pubblicazionePI(ListaCondivisaElementoPubblicato lCeP,String titolo, String descrizione, String longitudine,String latitudine){
        PI pi = creaPI(titolo, descrizione, longitudine,latitudine);
        lCeP.aggiungiElemento(pi,null,this);
        System.out.println("Il PI"+pi.getTitolo()+"è stato pubblicato");
    }
    public void notificaSegnalazione(String idSegnalazione){ //dovrebbe mandare il messaggio all'utente che ha generato la segnalazione
        System.out.println("resoconto segnalazione: l'elemento da lei segnalato è stato eliminato");//non ho la minima idea di come si faccia scusate
    }
    public void notificaAutorizzazione(String idRichiesta){ //stessa cosa di sopra :< ++ per comodità idRichiesta è l'id dell'elemento creato ed aggiunto alla LCE
        System.out.println("il post è stato pubblicato con successo");
    }


}
