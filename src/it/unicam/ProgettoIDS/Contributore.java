package it.unicam.ProgettoIDS;

import java.io.File;
import java.util.List;

public class Contributore {
    private String idContributore;
    private String nome;
    private String cognome;
    private String nomeUtente;
    private static  int idCPrecedente;



    public Contributore(String nome, String cognome, String nomeUtente) {
        this.nome=nome;
        this.cognome=cognome;
        this.nomeUtente=nomeUtente;
        setIdContributore();
    }
    public String getIdContributore() {

        return idContributore;
    }

    public int getIdPrecedente() {
        return idCPrecedente;
    }


    private void setIdContributore() {
        this.idContributore = "C"+idCPrecedente;
        idCPrecedente +=1;
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

    public Contenuto creaContenuto( File file,String titolo, String descrizione){
        if(file!=null) {
            return new Contenuto(file, titolo, descrizione, "immagine");
        }
        return new Contenuto(titolo,descrizione,"commento");
    }
    public Esperienza creaEsperienza(String tipologia, String titolo, String descrizione, List<PI> listaPI){
        return new Esperienza(tipologia, titolo, descrizione, listaPI);
    }
    public PI creaPI(String titolo, String descrizione, String tipologia, String longitudine,String latitudine){
        return new PI(descrizione, titolo, tipologia, longitudine, latitudine);
    }
    public Segnalazione creaSegnalazione(ListaCondivisaSegnalazioni listaSegnalazione,Elemento e,String descrizione){
        Segnalazione segnalazione= new Segnalazione(e.getIdElemento(),descrizione);
        listaSegnalazione.aggiungiSegnalazione(segnalazione, this,null, null, null);
        return segnalazione;
    }
   public void richiestaAutorizzazione(ListaCondivisaElemento listaCondivisa,Elemento e){
        listaCondivisa.aggiungiElemento(e, this, null);
   }
}
