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
    public int size(){
        return lista.size();
    }

    public Elemento get(int i){
        return lista.get(i);
    }

    public Elemento getElementoFromId(String idElemento){
        for(int i = 0; i < lista.size(); i++){
            if(Objects.equals(idElemento, lista.get(i).getIdElemento())){
                return lista.get(i);
            }
        }
        return null;
    }
}