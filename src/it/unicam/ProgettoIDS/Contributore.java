package it.unicam.ProgettoIDS;

import java.util.List;

public class Contributore {
    private String idContributore;
    private String nome;
    private String cognome;
    private String nomeUtente;
    private static  int idPrecedente;


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
        return idPrecedente;
    }


    public void setIdContributore() {
        this.idContributore = "C"+idPrecedente;
        idPrecedente +=1;
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

    public Contenuto creaContenuto(String tipologia, String titolo, String descrizione){

        return null;

    }
    public Esperienza creaEsperienza(String tipologia, String titolo, String descrizione, List<PI> listaPI){

        return null;
    }
    public PI creaPI(String titolo, String descrizione){

        return null;
    }
    public Segnalazione creaSegnalazione(Elemento e){

        return null;
    }

    public void richiestaAutorizzazione(Elemento e){

    }

}
