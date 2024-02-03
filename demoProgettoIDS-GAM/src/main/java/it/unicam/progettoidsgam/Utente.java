package it.unicam.progettoidsgam;


import it.unicam.progettoidsgam.PI;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.io.IOException;

//DA SISTEMARE
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Utente {

    private String nickname;
    @Id
    private String idUtente;
    //  private static ListaCondivisaNotifiche listaPersonale;

    public Utente(String nickname/*,ListaCondivisaNotifiche listaPersonale*/) {
        this.nickname = nickname;
        // this.listaPersonale = listaPersonale;
    }

    public Utente(){

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

  /*  public Segnalazione creaSegnalazione(Contenuto e,String descrizione,Curatore curatore){
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

   */
}

