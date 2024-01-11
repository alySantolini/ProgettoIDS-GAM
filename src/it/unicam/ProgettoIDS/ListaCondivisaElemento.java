package it.unicam.ProgettoIDS;

import java.util.ArrayList;
import java.util.List;

public class ListaCondivisaElemento {
    private List<Elemento> lista = new ArrayList<>();
    public void aggiungiElemento(Elemento elemento,Contributore contributore,TuristaAutenticato turista){
        if(contributore ==null && turista == null){
            return;
        }
        lista.add(elemento);
    }
    public List<Elemento> getLista(){
        return new ArrayList<>(lista);
    }
    public void rimuoviElemento(Elemento elemento,Curatore curatore){
        if (curatore != null){
            lista.remove(elemento);
        }
    }

}