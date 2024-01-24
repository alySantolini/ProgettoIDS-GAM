package it.unicam.ProgettoIDS;

import java.io.IOException;
import java.util.List;
//DA SISTEMARE
public abstract class Utente {

    private String nickname;
    private String idUtente;
    private static ListaCondivisaNotifiche listaPersonale;

    public Utente(String nickname,ListaCondivisaNotifiche listaPersonale) {
        this.nickname = nickname;
        this.listaPersonale = listaPersonale;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(String prefix,int idPrecedente) {
        this.idUtente = prefix+idPrecedente;
    }

    public Segnalazione creaSegnalazione(Contenuto e,String descrizione,Curatore curatore){
        Segnalazione segnalazione= new Segnalazione(e.getIdElemento(), descrizione,curatore);
        this.getListaNotifiche().aggiungiNotifica(segnalazione, curatore);
        return segnalazione;
    }
    public void ricercaPI(PI pi, ListaCondivisaElementoPubblicato lCeP) throws IOException {
        for(Elemento e : lCeP.getLista()){
            if(pi.equals(e)) {
                pi.visualizzaLista();
               // return pi.getLista();
                return ;
            }
        }
        System.out.println("pi non esiste");
        //return null;
    }

    public ListaCondivisaNotifiche getListaNotifiche(){
            return this.listaPersonale;
    }
}
