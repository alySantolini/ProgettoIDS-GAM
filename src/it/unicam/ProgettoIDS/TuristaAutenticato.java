package it.unicam.ProgettoIDS;

import java.io.File;

//DA SISTEMARE
public class TuristaAutenticato extends Utente{
    private String idTuristaAutenticato;
    private String nickname;
    private static int idTAPrecedente;

    public TuristaAutenticato(String nickname,ListaCondivisaNotifiche listaPersonale) {
       super(nickname,listaPersonale);
        setIdTuristaAutenticato();
    }

    public String getIdTuristaAutenticato() {
        return idTuristaAutenticato;
    }

    private void setIdTuristaAutenticato() {
       super.setIdUtente("TA",idTAPrecedente);
        idTAPrecedente +=1;
    }
    public Commento creaCommento(File file,String descrizione, String titolo, String tipologia,PI piRiferimento){
        if(file!=null) {
            return new Commento(file,descrizione, titolo,"immagine",piRiferimento);
        }
        return new Commento(titolo,descrizione,"commento",piRiferimento);

    }
   public void richiestaAutorizzazione(ListaCondivisaElemento listaCondivisa,Commento e){
        listaCondivisa.aggiungiElemento(e, null, this);
    }

}
