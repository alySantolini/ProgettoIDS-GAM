package it.unicam.ProgettoIDS;

import java.io.File;
import java.util.List;

public class Contributore extends Utente{
    private String idContributore;
    private String nome;
    private String cognome;
    private String nickname;
    private static  int idCPrecedente;



    public Contributore(String nome, String cognome, String nickname) {
        super(nickname);
        this.nome=nome;
        this.cognome=cognome;
        setIdContributore();
    }
    public String getIdContributore() {

        return idContributore;
    }

    public int getIdPrecedente() {
        return idCPrecedente;
    }


    private void setIdContributore() {
        super.setIdUtente("C",idCPrecedente);
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
    public Contenuto creaContenuto( File file,String titolo, String descrizione,PI piRiferimento){
        if(file!=null) {
            return new Contenuto(file, titolo, descrizione, "immagine",piRiferimento);
        }
        return new Contenuto(titolo,descrizione,"commento",piRiferimento);
    }
    public Esperienza creaEsperienza(String tipologia, String titolo, String descrizione, List<PI> listaPI){
        return new Esperienza(tipologia, titolo, descrizione, listaPI);
    }
    public PI creaPI(String titolo, String descrizione, String tipologia,String longitudine,String latitudine){
        return new PI(descrizione, titolo,tipologia, longitudine, latitudine);
    }

   public void richiestaAutorizzazione(ListaCondivisaElemento listaCondivisa,Contenuto e){
        listaCondivisa.aggiungiElemento(e, this, null);
   }
}
