package it.unicam.ProgettoIDS;

import java.io.IOException;
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
    public void getLista() throws IOException {
        if(lista.isEmpty()){
            System.out.println("è vuota");
        }else {
            for (Elemento c : lista) {
                c.visualizza();
            }
        }
    }
    public void rimuoviElemento(Elemento elemento,Curatore curatore){
        if (curatore != null){
            lista.remove(elemento);
        }
    }
    public int size(){
        return lista.size();
    }

    /*public Elemento get(int i){
        return lista.get(i);
    }
*/
    public Elemento getElementoFromId(String idElemento){
        for(Elemento e : lista){
            if(e.getIdElemento().equals(idElemento)){
                return e;
            }
        }
        return null;
    }
}