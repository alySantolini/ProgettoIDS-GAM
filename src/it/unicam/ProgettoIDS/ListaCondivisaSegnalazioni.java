package it.unicam.ProgettoIDS;

import java.util.ArrayList;
import java.util.List;

public class ListaCondivisaSegnalazioni {
    private List<Segnalazione> lista=new ArrayList<>();

    public void aggiungiSegnalazione(Segnalazione segnalazione, Contributore contributore, TuristaAutenticato turista){
        if(contributore==null && turista==null){
            return;
        }
        lista.add(segnalazione);
    }

    public List<Segnalazione> getLista(){
        return new ArrayList<>(lista);
    }

    public void rimuoviSegnalazione(Segnalazione segnalazione, Curatore curatore){
        if(curatore!= null){
            lista.remove(segnalazione);
        }
    }
}
