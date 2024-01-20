package it.unicam.ProgettoIDS;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//DA SISTEMARE
public class Curatore extends Utente{
    private String idCuratore;
    private String nome;
    private String cognome;
    private String nickname;



    public Curatore(String nome, String cognome, String nickname) {
        super(nickname);
        this.idCuratore = "CU001";
        this.nome = nome;
        this.cognome = cognome;
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
    public void autorizzazione(ListaCondivisaElementoPubblicato lCeP,ListaCondivisaElemento listaCondivisa,String idRichiesta /*controlla commento notifica autorizzazione*/){
        Elemento e = listaCondivisa.getElementoFromId(idRichiesta);
        listaCondivisa.rimuoviElemento(e,this);
        lCeP.aggiungiElemento(e,null,this); //"pubblico" l'elemento
        e.getPiRiferimento().aggiungi(e);
        notificaAutorizzazione(idRichiesta);
    }
    public void gestioneSegnalazione(ListaCondivisaSegnalazioni listaSegnalazione, ListaCondivisaElementoPubblicato lCeP,String idSegnalazione){
        Segnalazione s = listaSegnalazione.getSegnalazioneFromId(idSegnalazione);
        String idEl = s.getIdElemento();// da mettere poi nella classi ListaCondivisaA (LCA) e LCEP
        Elemento e = lCeP.getElementoFromId(idEl); // per il momento do per scontato che ogni segnalazione sia veritiera, quando/se  implementeremo la possibilità
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
    public Contenuto creaContenuto(File file, String titolo, String descrizione,PI piRiferimento){
        if(file!=null) {
            return new Contenuto(file, titolo, descrizione, "immagine",piRiferimento);
        }
        return new Contenuto(titolo,descrizione,"commento",piRiferimento);

    }

    public void pubblicazioneContenuto(ListaCondivisaElementoPubblicato lCeP,File file,String titolo,String descrizione,PI piRiferimento){
        Contenuto c= creaContenuto(file,titolo,descrizione,piRiferimento);
        lCeP.aggiungiElemento(c,null,this);
        piRiferimento.aggiungi(c);
        System.out.println("Il contenuto"+ c.getTitolo()+"è stato pubblicato");
    }

    public Esperienza creaEsperienza(String tipologia, String titolo, String descrizione, List<PI> listaPI){
        return new Esperienza(tipologia, titolo, descrizione, listaPI);

    }

    public void pubblicazioneEsperienza(ListaCondivisaElementoPubblicato lCeP,String tipologia,String titolo,String descrizione, List<PI> listaPI){
        Esperienza e= creaEsperienza(tipologia,titolo,descrizione,listaPI);
        lCeP.aggiungiElemento(e,null,this);
        listaPI.get(0).aggiungi(e);
        System.out.println("l'esperienza"+e.getTitolo()+"è stata pubblicata");
    }

    public PI creaPI(String titolo, String descrizione,String tipologia, String longitudine,String latitudine){
        return new PI(descrizione, titolo, tipologia,longitudine, latitudine);

    }

    public void pubblicazionePI(ListaCondivisaElementoPubblicato lCeP,PI pi){

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
