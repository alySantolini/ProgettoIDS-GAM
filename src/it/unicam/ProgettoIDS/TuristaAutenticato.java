package it.unicam.ProgettoIDS;

import java.io.File;

public class TuristaAutenticato {
    private String idTuristaAutenticato;
    private String nickname;
    private static int idTAPrecedente;

    public TuristaAutenticato(String nickname) {
        this.nickname = nickname;
        setIdTuristaAutenticato();
    }

    public String getIdTuristaAutenticato() {
        return idTuristaAutenticato;
    }

    private void setIdTuristaAutenticato() {
        this.idTuristaAutenticato = "TA"+idTAPrecedente;
        idTAPrecedente +=1;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Segnalazione creaSegnalazione(ListaCondivisaSegnalazioni listaCondivisa, Contenuto e,String descrizione){
        Segnalazione segnalazione= new Segnalazione(e.getIdContenuto(),descrizione);
        listaCondivisa.aggiungiSegnalazione(segnalazione, null, null,null,this);
        return segnalazione;
    }
    public Commento creaCommento(File file, String titolo, String tipologia){
        if(file!=null) {
            return new Commento(file, titolo,"immagine");
        }
        return new Commento(titolo,"commento");

    }
    public void richiestaAutorizzazione(ListaCondivisaElemento listaCondivisa,Commento e){
        listaCondivisa.aggiungiElemento(e, null, this);
    }

}
