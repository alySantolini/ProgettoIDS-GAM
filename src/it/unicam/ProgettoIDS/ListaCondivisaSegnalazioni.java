package it.unicam.ProgettoIDS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//DA SISTEMARE
public class ListaCondivisaSegnalazioni {
    private List<Segnalazione> lista=new ArrayList<>();

    public void aggiungiSegnalazione(Segnalazione segnalazione, Utente utente){
        if(utente==null){
            return;
        }
        lista.add(segnalazione);
    }

    public void getLista() throws IOException {
        if(lista.isEmpty()){
            System.out.println("è vuota");
        }else {
            for (Segnalazione s : lista) {
                s.visualizza();
            }
        }
    }

    public void rimuoviSegnalazione(Segnalazione segnalazione, Curatore curatore){
        if(curatore!= null){
            lista.remove(segnalazione);
        }
    }
    public int size(){
        return lista.size();
    }
    public Segnalazione getSegnalazioneFromId(String idSegnalazione){
        for(Segnalazione s : lista){
            if (s.getIdSegnalazione().equals(idSegnalazione)) {
                return s;
            }
        }
        return null;
    }

}

