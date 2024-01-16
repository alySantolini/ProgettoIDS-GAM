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

    public void creaSegnalazione(ListaCondivisaSegnalazioni listaCondivisa, Contenuto e,String descrizione){
        Segnalazione segnalazione= new Segnalazione(e.getIdContenuto(),descrizione);
        listaCondivisa.aggiungiSegnalazione(segnalazione, null, this);
    }
    public void creaCommento(File file, String titolo){
        if(file!=null) {
            Commento commento=new Commento(file, titolo, "immagine");
            pubblicazioneCommento(commento);
        }
        Commento commento=new Commento(titolo,"commento");
        pubblicazioneCommento(commento);
    }
    public void pubblicazioneCommento(Commento commento){
        System.out.println("Il commento "+commento.getTitolo()+" è stato pubblicato");
    }
}
