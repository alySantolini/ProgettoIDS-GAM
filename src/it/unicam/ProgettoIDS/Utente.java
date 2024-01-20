package it.unicam.ProgettoIDS;

import java.io.IOException;
import java.util.List;

public abstract class Utente {

    private String nickname;
    private String idUtente;

    public Utente(String nickname) {
        this.nickname = nickname;
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

    public Segnalazione creaSegnalazione(ListaCondivisaSegnalazioni listaSegnalazione,Contenuto e,String descrizione){
        Segnalazione segnalazione= new Segnalazione(e.getIdElemento(),descrizione);
        listaSegnalazione.aggiungiSegnalazione(segnalazione, this);
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
}
