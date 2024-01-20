package it.unicam.ProgettoIDS;

import java.io.File;
import java.util.List;

//DA SISTEMARE
public class ContributoreAutorizzato extends Utente{

    private String idContributore;
    private String nome;
    private String cognome;
    private String nickname;
    private static int idCAPrecedente;
    private boolean autorizzato=true;

    public ContributoreAutorizzato(String nome, String cognome, String nickname) {
        super(nickname);
        this.nome = nome;
        this.cognome = cognome;
        setIdContributore();
    }

    public String getIdContributore() {
        return idContributore;
    }

    private void setIdContributore() {
        super.setIdUtente("CA",idCAPrecedente);
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

    public boolean getAutorizzato(){
        return autorizzato;
    }
    public Contenuto creaContenuto(File file, String titolo, String descrizione,PI piRiferimento){
        if(file!=null) {
            return new Contenuto(file, titolo, descrizione, "immagine",piRiferimento);
        }
        return new Contenuto(titolo,descrizione,"commento",piRiferimento);

    }

    public void pubblicazioneContenuto(ListaCondivisaElementoPubblicato lCeP,File file,String titolo,String descrizione,PI piRiferimento){
        Contenuto c= creaContenuto(file,titolo,descrizione,piRiferimento);
        lCeP.aggiungiElemento(c,this,null);
        piRiferimento.aggiungi(c);
        System.out.println("Il contenuto"+ c.getTitolo()+"è stato pubblicato");
    }

    public Esperienza creaEsperienza(String tipologia, String titolo, String descrizione, List<PI> listaPI){
        return new Esperienza(tipologia, titolo, descrizione, listaPI);
    }

    public void pubblicazioneEsperienza(ListaCondivisaElementoPubblicato lCeP,String tipologia,String titolo,String descrizione, List<PI> listaPI){
        Esperienza e= creaEsperienza(tipologia,titolo,descrizione,listaPI);
        lCeP.aggiungiElemento(e,this,null);
        listaPI.get(0).aggiungi(e);
        System.out.println("l'esperienza"+e.getTitolo()+"è stata pubblicata");
    }

    public PI creaPI(String titolo, String descrizione, String tipologia,String longitudine,String latitudine){
        return new PI(descrizione, titolo,tipologia, longitudine, latitudine);

    }

    public void pubblicazionePI(ListaCondivisaElementoPubblicato lCeP,String titolo, String descrizione, String longitudine,String latitudine,String tipologia){
        PI pi = creaPI(descrizione, titolo,tipologia, longitudine,latitudine);
        lCeP.aggiungiElemento(pi,this,null);
        System.out.println("Il PI"+pi.getTitolo()+"è stato pubblicato");
    }


}
